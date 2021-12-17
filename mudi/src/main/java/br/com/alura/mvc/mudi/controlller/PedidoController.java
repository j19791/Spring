package br.com.alura.mvc.mudi.controlller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo") //parametros da requisicao vao ser atribudos ao objeto da classe dto RequisicaoNovoPedido
	public String novo(@Valid //@Valid integra o Spring com a validação
			RequisicaoNovoPedido requisicao, 
			BindingResult result) {//Spring retorna o resultado dessa validação
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = requisicao.toPedido();
		
		pedidoRepository.save(pedido);
		return "pedido/formulario";
	}
	
	
}
