package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.UnidadeRepository;

@Service
public class CrudUnidadeService {

	private final UnidadeRepository unidadeRepository;
	private boolean system = true;
	
	public CrudUnidadeService(UnidadeRepository unidadeRepository) {
		this.unidadeRepository = unidadeRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao da unidade deseja executar?");
			System.out.println("0-sair");
			System.out.println("1-salvar");
			System.out.println("2-atualizar");
			System.out.println("3-visualizar");
			System.out.println("4-deletar");
			
			int action = scanner.nextInt();
			
			switch(action) {
			case 1:
				salvar(scanner);
				break;
			case 2:				
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
					
			default:
				system=false;
			
			}
		}
		
		
	}
	
	private void salvar(Scanner scanner) {
			 
		
		Unidade unidade = new Unidade();
		
		System.out.println("Descricao da unidade");	
		String descricao = scanner.next();
		unidade.setDescricao(descricao);
		
		System.out.println("Endereço da unidade");	
		String endereco = scanner.next();
		unidade.setEndereço(endereco);
			
		unidadeRepository.save(unidade);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id da unidade");
		Integer id = scanner.nextInt();
		
System.out.println("Descricao da unidade");		 
		
		Unidade unidade = new Unidade();
		
		String descricao = scanner.next();
		unidade.setDescricao(descricao);
		
		String endereco = scanner.next();
		unidade.setEndereço(endereco);
			
		unidadeRepository.save(unidade);
		System.out.println("Salvo");
		System.out.println("Atualizado");
	}
	
	private void visualizar() {
		
		Iterable<Unidade> unidades = unidadeRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
		
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("id");
		int id = scanner.nextInt();
		unidadeRepository.deleteById(id);
		System.out.println("Deletado");
	}
	
	
}
