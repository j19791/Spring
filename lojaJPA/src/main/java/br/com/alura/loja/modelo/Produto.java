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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	//@Column(name="desc") //nome da coluna no bd
	private String descricao;
	private BigDecimal preco;
	
	
}
