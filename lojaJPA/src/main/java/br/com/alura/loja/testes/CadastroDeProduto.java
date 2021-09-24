package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("celulares");
		
		Produto celular = new Produto("Xiami Redmi", "Muito legal", new BigDecimal("800") ,  celulares);
	
		//a criação do EM foi isolada 
		EntityManager em = JPAUtil.getEntityManager();		
		
		//transferido para a classe DAO
		ProdutoDao dao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin(); //vc nao esta usando servidor de app - transaction-type="RESOURCE_LOCAL", s/ controle de transacao automatico
		
		//Transient Property Value Exception: antes de salvar o produto, eu preciso salvar a categoria antes:
		categoriaDao.cadastrar(celulares);
		dao.cadastrar(celular);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
}
