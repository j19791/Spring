package br.com.alura.loja.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;

public class PedidoDao {

	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
	
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public void atualizar(Pedido pedido) {
		this.em.merge(pedido);
	}

	public Pedido buscarPorId(Long id) {
		return em.find(Pedido.class,id);
		
	}
	
	public BigDecimal valorTotalVendido() {
		
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		
		return em.createQuery(jpql, BigDecimal.class)
				.getSingleResult();
		
	}
	

}
