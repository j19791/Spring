package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {//enum � ruim (fixo no c�digo)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	
	//quando � usado o merge - o jpa briga o uso de construtor padr�o
	public Categoria() {
		super();
	}
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
