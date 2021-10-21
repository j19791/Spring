package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

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
	
	//preciso retornar 3 atributos de entidades diferentes
	public List<RelatorioDeVendasVo> relatorioDeVendas() { //Vo = value Objects - classe que só tem atributos
		String jpql = "select new br.com.alura.loja.vo.RelatorioDeVendasVo " //cria uma instancia dessa classe. (jpql só usa entidade e vo não é entidade) 
				+ "(produto.nome, "
				+ "sum(item.quantidade), "
				+ "max(pedido.data)) " //passa p/ o construtor
				+ "from Pedido pedido "
				+ "join pedido.itens item "
				+ "join item.produto produto "
				+ "group by produto.nome "
				+ "order by item.quantidade desc";
		
		return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
	}
	
	//Query Planejada - evitar problema de LazyInicializationException - FETCH: nessa consulta, cliente vai vir junto APENAS NESSA CONSULTA (foi configurado na anotação lazy)
	public Pedido buscarPedidoComCliente(Long id) {
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	

}
