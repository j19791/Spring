package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		PopularBancoDeDados.popularBancoDeDados();			

		EntityManager em = JPAUtil.getEntityManager();		

		ProdutoDao dao = new ProdutoDao(em);
		
		Produto p = dao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = dao.buscarTodos();
		
		todos.forEach(p2 -> System.out.println(p2.getNome()));
		
		List<Produto> todosPorNome = dao.buscarPorNome("Xiami Redmi");
		
		todosPorNome.forEach(p2 -> System.out.println(p2.getNome()));
		
		List<Produto> todosPorCategoria = dao.buscarPorNomeCategoria("CELULARES");
		
		todosPorCategoria.forEach(p2 -> System.out.println(p2.getNome()));
		
		

		
		
		BigDecimal preco = dao.buscarPrecoDoProdutoPorNome("j5");
		System.out.println(preco);
		

	}


	
	
	
	
}
