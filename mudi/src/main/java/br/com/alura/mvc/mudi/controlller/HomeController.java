package br.com.alura.mvc.mudi.controlller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {//Gerenciada (criando instancias) pelo Spring
//Diminuindo as responsabilidades - não tem conecção c/ bd
	
	@Autowired 
	private PedidoRepository repository; //Spring disponibiliza uma instancia de PedidoRepository 
	
	@GetMapping("/home")
	public String home(Model model) {		

		
		List<Pedido> pedidos = repository.recuperaTodosOsPedidos();
		
		model.addAttribute("pedidos", pedidos);
		
		
		return "home";
	}
	
}
