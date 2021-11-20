package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeService;

@SpringBootApplication //ao iniciar o Framework do Spring, ele percorra todas as anotações que temos dentro da nossa aplicação para executá-las
public class SpringDataApplication implements CommandLineRunner {

	
	private boolean system = true;
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeService unidadeService;
	
	public SpringDataApplication(CrudCargoService cargoService, 
			CrudFuncionarioService funcionarioService,
			CrudUnidadeService unidadeService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeService = unidadeService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);//inicia o fw do Spring junto c/ a app
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação vc quer executar?");
			System.out.println("0-sair");
			System.out.println("1-cargo");		
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorio dinamico");
		
			int action = scanner.nextInt();
	
			switch (action) {
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			case 3:
				unidadeService.inicial(scanner);
				break;
			/*case 4:
				relatoriosService.inicial(scanner);
				break;
			case 5:
				relatorioFuncionarioDinamico.inicial(scanner);
				break;*/
			default:
				System.out.println("Finalizando");
				system = false;
				break;
		}
		}
	}

}
