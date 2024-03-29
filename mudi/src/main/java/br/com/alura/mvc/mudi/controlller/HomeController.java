package br.com.alura.mvc.mudi.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {//Gerenciada (criando instancias) pelo Spring
//Diminuindo as responsabilidades - não tem conecção c/ bd
	
	@Autowired 
	private PedidoRepository pedidoRepository; //Spring disponibiliza uma instancia de PedidoRepository 
	
	@GetMapping //usuario preenche uma requisição na barra de endereço do navegador: requisição tipo get
	public String home(Model model) {		

		
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		model.addAttribute("pedidos", pedidos); //envia os pedidos recuperados para a view
		
		
		return "home"; //view
	}
	
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {		

		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status); //eu passo o status do parametro recebido da url para home.html 
		
		return "home";
	}
	
	//se ocorrer algum erro na pagina , redireciona p/ home
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:home";
	}
	
	
}
