package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {//enum é ruim (fixo no código)

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;
	
	@EmbeddedId //mapeando chave composta
	private CategoriaId id;


	//quando é usado o merge - o jpa briga o uso de construtor padrão
	public Categoria() {
		super();
	}
	public Categoria(String nome) {
		super();
		this.id = new CategoriaId(nome,"xpto");
	}
	public String getNome() {
		return id.getNome();
	}
	
	
	
}
