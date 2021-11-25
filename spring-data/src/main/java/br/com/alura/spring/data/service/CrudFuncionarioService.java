package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeRepository;

@Service
public class CrudFuncionarioService {

	private Boolean system = true;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final UnidadeRepository unidadeRepository;
	
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, 
			CargoRepository cargoRepository, UnidadeRepository unidadeRepository) {
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
		this.unidadeRepository = unidadeRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao do funcionario deseja executar?");
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
				visualizar(scanner);
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
		System.out.println("Nome do funcionario");
		String nome = scanner.next();
		
		System.out.println("cpf");
		String cpf = scanner.next();
		
		System.out.println("salario");
		Double salario = scanner.nextDouble();
		
		System.out.println("Digite a data de contracao");
        String dataContratacao = scanner.next();
		
		
		System.out.println("cargo");
		Integer cargoId = scanner.nextInt();
		
		System.out.println("unidade");
		
		List<Unidade> unidades = unidade(scanner);

	    Funcionario funcionario = new Funcionario();
	    funcionario.setNome(nome);
	    funcionario.setCPF(cpf);
	    funcionario.setSalario(salario);
	    funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
	    
	    Optional<Cargo> cargo = cargoRepository.findById(cargoId);
	    funcionario.setCargo(cargo.get());
	    funcionario.setUnidades(unidades);


		
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id do funcionario");
		Integer id = scanner.nextInt();
		
		System.out.println("nome");
		String nome = scanner.next();
		
		System.out.println("cpf");
		String cpf = scanner.next();
		
		System.out.println("cargo");
		
		
		
		System.out.println("unidade");
		
		
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setCPF(cpf);
		
		funcionarioRepository.save(funcionario);
		System.out.println("Atualizado");
	}
	
	private void visualizar(Scanner scanner ) {
		
		System.out.println("Qual pagina vc deseja visualizar?");
		int page = scanner.nextInt();
		

		//encapsulamos a página, a quantidade de itens por página e qual o tipo de ordenação.
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC , "nome")); //ordenando pelo nome em ordem crescente
	
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		
		System.out.println(funcionarios);
		System.out.println("Pagina atual " + funcionarios.getNumber());
		System.out.println("Total elementos " + funcionarios.getTotalElements());
		
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
		
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("id");
		int id = scanner.nextInt();
		funcionarioRepository.deleteById(id);
		System.out.println("Deletado");
	}
	



private List<Unidade> unidade(Scanner scanner) {
    Boolean isTrue = true;
    List<Unidade> unidades = new ArrayList<>();

    while (isTrue) {
        System.out.println("Digite o unidadeId (Para sair digite 0)");
        Integer unidadeId = scanner.nextInt();

        if(unidadeId != 0) {
            Optional<Unidade> unidade = unidadeRepository.findById(unidadeId);
            unidades.add(unidade.get());
        } else {
            isTrue = false;
        }
    }

    return unidades;
}
	
	
}
