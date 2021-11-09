package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

////DadosPessoais sao colunas da tabela de cliente
@Embeddable
public class DadosPessoais {

	
	public DadosPessoais() {
	}
	
	private String nome;
	private String cpf;
	
	
	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
}
