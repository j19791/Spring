package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class BuscaDeProdutoUsandoAPICriteria {

	public static void main(String[] args) {
		
		PopularBancoDeDados.popularBancoDeDados();			

		EntityManager em = JPAUtil.getEntityManager();		

		ProdutoDao dao = new ProdutoDao(em);
		
				
		List<Produto> todos = dao.buscaPorParametrosComCriteria(null, null, LocalDate.now());
		
		
		

		

	}


	
	
	
	
}
