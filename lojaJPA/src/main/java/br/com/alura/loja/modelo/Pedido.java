package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
	private BigDecimal valorTotal; //quando o atributo � separado por camelCase, a coluna � criada c/ _
	
	@ManyToOne
	private Cliente cliente;
	
	/*
	@ManyToMany //1 pedido tem varios produtos, 1 produto pode estar em varios pedidos
	@JoinTable
	private List<Produto> produto;
	*/	
	//no entanto, no nosso modelo � necess�rio mais informa��es como qtd de produtos e preco naquele momento q foi realizado o pedido. Se o pre�o do produto for reajustado, o pre�o naquele pedido n�o � reajustado
	
	@OneToMany
	private List<ItemPedido> itens;
	
	
	
	public Pedido(Cliente cliente) {
	
		
		this.cliente = cliente;
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
