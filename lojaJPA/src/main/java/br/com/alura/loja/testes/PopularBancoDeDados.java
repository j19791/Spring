package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class PopularBancoDeDados {

	 static void popularBancoDeDados() {
		Categoria celulares = new Categoria("celulares"); //estado Transient: nunca foi persistida (objeto Java puro). Em não esta gerenciando 
		
		Produto celular = new Produto("Xiami Redmi", "Muito legal", new BigDecimal("800") ,  celulares);
	
		//a criação do EM foi isolada 
		EntityManager em = JPAUtil.getEntityManager();		
		
		//transferido para a classe DAO
		ProdutoDao dao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		//cliente tbm precisa ser salvo no bd antes de salvr o pedido
		ClienteDao clienteDao = new ClienteDao(em);
				
		Cliente cliente = new Cliente("Rodrigo", "123456");
				
		
		
		em.getTransaction().begin(); //vc nao esta usando servidor de app - transaction-type="RESOURCE_LOCAL", s/ controle de transacao automatico
		
		//Transient Property Value Exception: antes de salvar o produto, eu preciso salvar a categoria antes:
		categoriaDao.cadastrar(celulares); //estado MANAGED: QDO FOI PERSISTIDO - JPA observando -   -  pode sincronizar c/ o BD
		celulares.setNome("xpto"); //MANAGED: se for realizado uma alteração no atributo via set, o JPA faz update no bd
		
		
		dao.cadastrar(celular);
		
		clienteDao.cadastrar(cliente);
		
		//em.flush(); //sincroniza c/ obd (grava idnex) mas nao commit
		em.getTransaction().commit(); //gera o insert no bd
		//em.clear();
		
		//em.close();//DETACHED: Ja salvo no bd. nao esta mais gerenciado pela JPA
		
		/*
		celulares = em.merge(celulares); //merge: devolve uma entidade p/ o estado managed
		
		celulares.setNome("1234");
		
		Categoria sp = new Categoria("SmartPhones");
		new CategoriaDao(em).cadastrar(sp);
		
		Produto j5 = new Produto("j5", "meu celular",new BigDecimal(100), sp);
		
		dao.cadastrar(j5);
		
		em.getTransaction().commit();
		
		//em.flush();
		*/
	}

	
}
