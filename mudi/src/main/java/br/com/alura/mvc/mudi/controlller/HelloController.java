package br.com.alura.mvc.mudi.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	//public String hello(HttpServletRequest request) {
	public String hello(Model model) {
		model.addAttribute("nome", "Mundo Bão");
		
		return "hello";
	}
	
	
}
