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

### Thymeleaf
- usado no lugar do JSP pois nã introduz novas tags

### Bootstrap
- importar:
	- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
- [Documentação](https://getbootstrap.com/docs/5.1/getting-started/introduction/)
- biblioteca css
- posiciona elementos da página de maneira responsiva
- componentes