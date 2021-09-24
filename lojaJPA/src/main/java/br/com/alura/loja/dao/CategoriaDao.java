package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;

public class CategoriaDao {

	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
	
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria); //garante q categoria esta managed
	}
	
	public void remover(Categoria categoria) {
		categoria = this.em.merge(categoria); //garante q categoria esta managed
		this.em.remove(categoria); 
	}
	
}
