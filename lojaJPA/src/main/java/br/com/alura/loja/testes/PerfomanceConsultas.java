package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class PerfomanceConsultas {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		
		Pedido pedido = em.find(Pedido.class, 1l);//é lazy pois foi configurado na anotação mas vai dar erro LazyInitializationException depois de fechar o em
		
		Pedido pedidoQP = new PedidoDao(em).buscarPedidoComCliente(1l);
		
		
		System.out.println(pedido.getData()); //preciso apenas da data do pedido
		//Eager: carregamento antecipado-pa faz um join c/ a tabela de cliente: existe um relacionamento @ManyToOne (ou @OneToOne) c/ cliente e carrega os clientes
		//nao preciso carregar demais
		
		//ItemPedido
		System.out.println(pedido.getItens().size());
		
		//@OneToMany : lazy - preguiçoso - só carrega se for feito acesso
		
		//Efeitos colaterais
		em.close();
		
		//System.out.println(pedido.getCliente().getNome());LazyInitializationException - s/ a query planejada - NAO HAVIA SIDO CARREGADO ANTES
		
		////Query Planejada
		System.out.println(pedidoQP.getCliente().getNome()); 
	}
	
	private static void popularBancoDeDados() {
		
		
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi", "Muito legal", new BigDecimal(100), celulares ),
				videogame = new Produto("PS5","plasystaton", new BigDecimal(200), videogames),
				macbook = new Produto("MacBook", "mac", new BigDecimal(300), informatica);
		
		Cliente cliente = new Cliente("Roddrigo", "123456");
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, macbook));
		pedido.adicionarItem(new ItemPedido(40, pedido, videogame));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, macbook));
		pedido.adicionarItem(new ItemPedido(40, pedido, videogame));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		
		em.getTransaction().begin();
		
		produtoDao.cadastrar(macbook);
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		
		
		
		categoriaDao.cadastrar(informatica);
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		
		clienteDao.cadastrar(cliente);
		
		pedidoDao.cadastrar(pedido);		
		pedidoDao.cadastrar(pedido2);
		
		
		em.getTransaction().commit();
		
		
		
		
		
	}

}
