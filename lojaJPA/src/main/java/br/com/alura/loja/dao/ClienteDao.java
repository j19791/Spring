package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Cliente;

public class ClienteDao {

	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
	
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public void atualizar(Cliente cliente) {
		this.em.merge(cliente); //garante q categoria esta managed
	}
	
	public void remover(Cliente cliente) {
		cliente = this.em.merge(cliente); //garante q categoria esta managed. SE estiver detached o em gera exception
		this.em.remove(cliente); 
	}
	
	public Cliente buscarPorId(Long id) {
		
		return em.find(Cliente.class, id);
	}
	
}
