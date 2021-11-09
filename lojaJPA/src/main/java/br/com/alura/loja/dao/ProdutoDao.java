package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		//utilizando named queries 
		return em.createNamedQuery("Produto.produtosPorCategoria", Produto.class) 				
				.setParameter(2, "CELULARES") 
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoPorNome(String pnome){
		String jpsql = "SELECT p.preco FROM Produto p where p.nome = :nome  "; //carrega a entidade c/ apenas atributo preco 
		return em.createQuery(jpsql,BigDecimal.class) //apenas monta a query
				.setParameter("nome", pnome) //named parameter				
				.getSingleResult(); //retorna apenas 1 resultado
	}
	
	//usando parametros opcionais (+ flexíveis) na consulta
	public List<Produto> buscaPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro){
		
		String jpql = "SELECT p FROM PRODUTO p WHERE 1=1"; //1= 1 GAMBIARRA 
		
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		
		if (nome != null && !nome.trim().isEmpty()) {
			jpql= "AND p.nome = :nome";
			query.setParameter("nome", nome);
		}
		if (preco != null ) {
			jpql= "AND p.preco = :preco";
			query.setParameter("preco", preco);
		}
		if (dataCadastro != null ) {
			jpql= "AND p.dataCadastro = :dataCadastro";
			query.setParameter("dataCadastro", dataCadastro);
		}
		
		return query.getResultList();
	}
	
	//busca usando Criteria API
	public List<Produto> buscaPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro){
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		
		Root<Produto> from = query.from(Produto.class);
		
		Predicate filtros = builder.and();
		
		if (nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if (preco != null ) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
			//query.setParameter("preco", preco);
		}
		if (dataCadastro != null ) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
			
		}
		
		
		query.where(filtros);
		
		
		
		return em.createQuery(query).getResultList();
	}
	
}
