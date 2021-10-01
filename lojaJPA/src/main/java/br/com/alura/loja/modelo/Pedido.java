package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //existe uma tabela no bd sendo mapeada por essa classe
@Table(name="pedidos") //nome da tabela do bd
public class Pedido {

	

	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data = LocalDate.now();
	@Column(name="valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO; //quando o atributo � separado por camelCase, a coluna � criada c/ _
	
	@ManyToOne
	private Cliente cliente;
	
	/*
	@ManyToMany //1 pedido tem varios produtos, 1 produto pode estar em varios pedidos
	@JoinTable
	private List<Produto> produto;
	*/	
	//no entanto, no nosso modelo � necess�rio mais informa��es como qtd de produtos e preco naquele momento q foi realizado o pedido. Se o pre�o do produto for reajustado, o pre�o naquele pedido n�o � reajustado
	
	@OneToMany(mappedBy = "pedido", //relacionamneto bidirecional: ja mapeado no ItemPedido. Para n�o criar uma segunda tabela de join
			cascade = CascadeType.ALL) //jpa salva pedido no bd e tbm insere 1 item de pedido respectivo ao pedido. Tudo q acontece c/ o pedido, tbm faz no itemPedido
	private List<ItemPedido> itens = new ArrayList<>(); //boa pr�tica iniciar c/ cole��o vazia
	
	
	
	public Pedido(Cliente cliente) {	
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this); //qdo adicionado um item novo, automaticmanente � passado o Pedido
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
	

	public Pedido() {
	}


	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
