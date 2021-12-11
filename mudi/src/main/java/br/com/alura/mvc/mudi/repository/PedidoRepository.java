package br.com.alura.mvc.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;

@Repository  //o spring gerencia instancias qdo um controller pedir
public interface PedidoRepository extends JpaRepository<Pedido, Long> {//Long é o tipo do id do pedido 

	
	
}
