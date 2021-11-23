package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository; 
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao do funcionario deseja executar?");
			System.out.println("0-sair");
			System.out.println("1-pesquisar");
			
			
			int action = scanner.nextInt();
			
			switch(action) {
			case 1:
				buscaFuncionarioNome(scanner);
				break;
			
					
			default:
				system=false;
			
			}
		}
		
		
	}
	
	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseha pesquisar");
		
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
				
	}
}
