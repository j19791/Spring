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
- @GetMapping: Métodos que atendem requisições HTTP são chamados de action