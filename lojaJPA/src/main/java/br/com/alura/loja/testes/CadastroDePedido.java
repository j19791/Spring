package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		
		PopularBancoDeDados.popularBancoDeDados();	
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		Cliente cliente = new ClienteDao(em).buscarPorId(1L);
		
		Pedido pedido = new Pedido(cliente); 		
		
		ProdutoDao dao = new ProdutoDao(em);
		
		Produto produto = dao.buscarPorId(1l);
		
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
		
		
		BigDecimal valorTotalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor total: " + valorTotalVendido);
		
		
	}

}
