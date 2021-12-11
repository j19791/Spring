package br.com.alura.mvc.mudi.controlller;

import java.util.List;

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
	private PedidoRepository pedidoRepository; //Spring disponibiliza uma instancia de PedidoRepository 
	
	@GetMapping("/home")
	public String home(Model model) {		

		
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		model.addAttribute("pedidos", pedidos);
		
		
		return "home";
	}
	
}
