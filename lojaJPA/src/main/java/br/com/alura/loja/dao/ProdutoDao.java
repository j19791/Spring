package br.com.alura.loja.dao;

import java.math.BigDecimal;
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
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class,id);
		
	}
	
	public List<Produto> buscarTodos(){
		String jpsql = "SELECT p FROM Produto p"; //carrega o objeto p s/ atributos. � a entidade n�o o nome da tabela no bd
		return em.createQuery(jpsql, Produto.class) //apenas monta a query
				.getResultList();
	}
	
	public List<Produto> buscarPorNome(String pnome){

		String jpsql = "SELECT p FROM Produto p where p.nome = :nome  "; //carrega o objeto p inteiro s/ atributos. � a entidade n�o o nome da tabela no bd. No crit�rio do where , usar o nome  dos atributos n�o das colunas 
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
	
	
	
}
