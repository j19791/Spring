package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;

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
/*	
	public List<Produto> buscarTodos(){
		String jpsql = "SELECT p FROM Produto p"; //carrega o objeto p s/ atributos. É a entidade não o nome da tabela no bd
		return em.createQuery(jpsql, Produto.class) //apenas monta a query
				.getResultList();
	}
	
	public List<Produto> buscarPorNome(String pnome){

		String jpsql = "SELECT p FROM Produto p where p.nome = :nome  "; //carrega o objeto p inteiro s/ atributos. É a entidade não o nome da tabela no bd. No critério do where , usar o nome  dos atributos não das colunas 
		return em.createQuery(jpsql, Produto.class) //apenas monta a query
				.setParameter("nome", pnome) //named parameter				
				.getResultList();
	}
	
	public List<Produto> buscarPorNomeCategoria( String pcategoria){
		String jpsql = "SELECT p FROM Produto p where p.categoria.nome = ?2 "; //o jpql faz o join automatico 
		return em.createQuery(jpsql, Produto.class) 				
				.setParameter(2, "CELULARES") 
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoPorNome(String pnome){
		String jpsql = "SELECT p.preco FROM Produto p where p.nome = :nome  "; //carrega a entidade c/ apenas atributo preco 
		return em.createQuery(jpsql,BigDecimal.class) //apenas monta a query
				.setParameter("nome", pnome) //named parameter				
				.getSingleResult(); //retorna apenas 1 resultado
	}
	
	
*/	
}
