package br.com.alura.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("lojaJPA"); //nome do persistence-unit 
	
	//pega o objeto e faz insert na tabela do produtos. JPA: persistencia no bd- EM : ponte entre entidades para fazer as operações no bd
	//Interface		
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
	
	
}
