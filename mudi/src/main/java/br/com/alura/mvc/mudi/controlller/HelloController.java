package br.com.alura.mvc.mudi.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //classe q adiciono as actions
public class HelloController { 

	@GetMapping("/hello") //action: vai processar uma requisição do usuário e vai redirecionar p/ a view hello
	//public String hello(HttpServletRequest request) {
	public String hello(Model model) {
		model.addAttribute("nome", "Mundo Bão"); //passando a variavel nome com o valor mundo bão p/ a view
		
		return "hello"; //view: hello.html (padrão do Thymeleaf) dentro da pasta src/main/resources/templates
	}
	
	
}
