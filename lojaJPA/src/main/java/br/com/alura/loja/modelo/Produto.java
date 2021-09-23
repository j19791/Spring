package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //existe uma tabela no bd sendo mapeada por essa classe
@Table(name="produtos") //nome da tabela do bd
public class Produto {
	
	//atributos que vão ser mapeadas em coluna no bd
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	//@Column(name="desc") //nome da coluna no bd
	private String descricao;
	private BigDecimal preco;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
}
