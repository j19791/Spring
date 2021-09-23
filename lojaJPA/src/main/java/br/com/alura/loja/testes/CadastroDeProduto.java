package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("Xiami Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));
		
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("lojaJPA"); //nome do persistence-unit 
		
		//pega o objeto e faz insert na tabela do produtos. JPA: persistencia no bd- EM : ponte entre entidades para fazer as operações no bd
		//Interface		
		EntityManager em =  factory.createEntityManager();
		
		em.getTransaction().begin(); //vc nao esta usando servidor de app - transaction-type="RESOURCE_LOCAL", s/ controle de transacao automatico
		
		em.persist(celular); //vai salvar o produto no bd
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
}
