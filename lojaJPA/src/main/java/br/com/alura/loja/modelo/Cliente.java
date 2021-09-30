package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //existe uma tabela no bd sendo mapeada por essa classe
@Table(name="clientes") //nome da tabela do bd
public class Cliente {

	
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	public Cliente(String nome, String cpf) {
		
		this.nome = nome;
		this.cpf = cpf;
	}
	public Cliente() {
		
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
