package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //existe uma tabela no bd sendo mapeada por essa classe
@Table(name="pedidos") //nome da tabela do bd
public class Pedido {

	

	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data = LocalDate.now();
	private BigDecimal valorTotal; //quando o atributo é separado por camelCase, a coluna é criada c/ _
	
	@ManyToOne
	private Cliente cliente;
	
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
