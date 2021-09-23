## JPA

### JDBC 
- especificação p/ acesso a bd relacionais. Camada de abstração. Facilita qdo necessário trocar SGBD
- drivers : implementação do sgbd do jdbc (jars)
- DAO: data access object - isola o código do JDBC dentro da app - forma de juntar OO com bd relacional
- lógica de negócios (service) ->  DAO (JDBC) -> BD
- desvantagens:
	- código verboso
	- alto acoplamneto c/ BD: troca o nome da tabela, coluna gera muito impacto na app

### Hibernate
- biblioteca de mercado p/ simplificar o JDBC
- JPA especificação p/ ORM (Object Relational Mapping) p/ as bibliotecas implementarem (independencia)
- Hibernate 3.5.0 (2010) passou a implementar JPA 2
- concorrentes: EclipseLink (implementação de referncia da JPA), OpenJPA

### Criando e configurando um novo projeto JPA
- incluir as dependencias do hibernate e do driver do bd no pom.xml
- dentro da pasta src/main/resources criar uma nova pasta chamada META-INF e dentro da pasta um arquivo **persistence.xml**
	- ensina o jpa como acessar o sgbd: driver, endpoint, usuario, senha, etc 
	- hibernate.hbm2ddl.auto 
		- create: toda vez que criarmos um EntityManagerFactory, o Hibernate  ele vai apagar tudo e criar do zero as tabelas
		- create-drop: cria as tabelas quando rodarmos a aplicação e, depois que terminamos de executar a aplicação, ele imediatamente dropa.
		- update: atualizar a tabela se alguma mudança surgir (não apaga os dados). se apagarmos uma entidade ou um atributo dela, ele não apaga a tabela e nem a coluna,
		- validate : não mexe no banco, apenas valida se está tudo ok no banco e gera um log
### Entidade
- classe que vai ser mapeada p/ uma tabela	



