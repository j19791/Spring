package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {

	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
	
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class,id);
		
	}
	
	public List<Produto> buscarTodos(){
		String jpsql = "SELECT p FROM Produto p"; //carrega o objeto p s/ atributos. É a entidade não o nome da tabela no bd
		return em.createQuery(jpsql, Produto.class) //apenas monta a query
				.getResultList();
	}
	
}
