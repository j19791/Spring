package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
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
	
	@Embedded //DadosPessoais sao colunas de cliente - Não é uma nova entidade
	private DadosPessoais dadosPessoais; //DadosPessoais nao é uma entidade. Serve apenas p/ separar as classes
	
	//classe delegated
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
	
	
	
	public Cliente(String nome, String cpf) {
		
		this.dadosPessoais = new DadosPessoais(nome,cpf);
		
	}
	public Cliente() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
	
	
	
}
