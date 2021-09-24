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
	private LocalDate dataCadastro = LocalDate.now();
	
	//@Enumerated(EnumType.STRING) 	
	//para nao gravar o valor da ordem (1,2,3) e sim a constante na tabela produtos
	//usar enum é ruim- rocado por uma entidad
	
	//relacionamento entre duas entidades: passar a cardinalidade p/ o JPA
	@ManyToOne //muitos produtos podem estar numa única categoria
	private Categoria categoria;
	
	
	
	
	public Produto() {
		super();
	}
	
	public Produto(String nome, String descricao, BigDecimal preco,  Categoria categoria) {
		
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		
		this.categoria = categoria;
	}
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
