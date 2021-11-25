package br.com.alura.spring.data.orm;

//entidade com métodos com o nome das colunas que quero retornar num relatório
public interface FuncionarioProjecao {

	Integer getId();
	String getNome();
	Double getSalario();
	
}
