package br.com.alura.mvc.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;

@Repository  //o spring gerencia instancias qdo um controller pedir
public class PedidoRepository { 

	//conectar c/ o bd
		@PersistenceContext
		private EntityManager entityManager; //Injetado a dependencia pelo Spring
	
	public List<Pedido> recuperaTodosOsPedidos(){
		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
		return query.getResultList();
	}
	
}
