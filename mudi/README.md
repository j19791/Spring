# Spring MVC: Crie uma web app com Thymeleaf e Bootstrap 

## Conhecendo o Spring MVC
- O servlet do Spring MVC recebe as requisições e delega para controllers mais específicos

### Introdução
- Bootstrap: biblioteca de CSS que vai dar o layout da aplicação para vários dispositivos.
- Spring Expression Language

### Spring MVC com Spring Boot
- [Spring Initialzr](start.spring.io): aplicação Web que permite criarmos um projeto inicial com as dependências que precisamos 
- Spring Web - Spring MVC configurado
- Spring Boot para inicializar a aplicação e rodar o Tomcat. Spring Boot já tem o servlet container Tomcat embutido
- DevTools : projeto que faz o restart da aplicação enquanto estamos programando
- Thymeleaf: alternativa a tecnologia JSP, serve para gerar HTML dinamicamente
	- Source/main/resources/templates:  é onde vai ficar as nossas “views” 

### O primeiro controller
- @Controller: classe que responde uma requisição HTTP
- @RequestMapping: define uma parte da rota
- @GetMapping: Métodos que atendem requisições HTTP são chamados de action
- @PostMapping: 

### Thymeleaf
- usado no lugar do JSP pois nã introduz novas tags
- templates:
- formatação:
	- [Valores de moeda](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#numbers)
	- [data](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#calendars) 

### Bootstrap
- importar:
	- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
- [Documentação](https://getbootstrap.com/docs/5.1/getting-started/introduction/)
- biblioteca css
- posiciona elementos da página de maneira responsiva
- componentes

### Injeção de depêndencias
- quando uma classe (HomeController) depende de outra classe (um repositório), o Spring consegue descobrir e instanciar todas as dependências e entregar o objeto que o controller precisa
- delegamos a responsabilidade de criar um objeto para o Spring
- Para criar um repository é necessário uma conexão, da EntityManagerFactory, do EntityManager, etc. 
- Isso não importa no nosso código, pois o Spring assume essa responsabilidade

### Integração c/ Spring Data JPA
- incluir as dependencias : Spring JPA e o driver do MariaDB
- Configurar os dados da conexão pelo application.properties
- criar uma interface, extender o JpaRepository e usar a anotação @Repository
- um JPARepository já tem vários métodos implementados como findAll, save, delete ou findById
- usamos a injeção de dependências p/ receber uma instância do repositório

 ### DTO
 - padrão p/ receber dados da requisição HTTP
 - o nome do input HTML precisa ser igual aos atributos (getter e setter) do DTO
 - Web Parameter Tampering: falha de segurança. 
