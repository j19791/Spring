package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;

@SpringBootApplication //ao iniciar o Framework do Spring, ele percorra todas as anotações que temos dentro da nossa aplicação para executá-las
public class SpringDataApplication implements CommandLineRunner {

	
	private boolean system = true;
	
	private final CrudCargoService cargoService;
	
	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
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
		
			int action = scanner.nextInt();
	
			if(action==1)
				cargoService.inicial(scanner);			
			else
				system=false;
		}
	}

}
