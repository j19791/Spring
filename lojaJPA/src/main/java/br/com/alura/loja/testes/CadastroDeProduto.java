package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("Xiami Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));
		
		//a criação do EM foi isolada 
		EntityManager em = JPAUtil.getEntityManager();
		
		
		em.getTransaction().begin(); //vc nao esta usando servidor de app - transaction-type="RESOURCE_LOCAL", s/ controle de transacao automatico
		
		//transferido para a classe DAO
		ProdutoDao dao = new ProdutoDao(em);
		dao.cadastrar(celular);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
}
