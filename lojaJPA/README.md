## JPA

### JDBC 
- especifica��o p/ acesso a bd relacionais. Camada de abstra��o. Facilita qdo necess�rio trocar SGBD
- drivers : implementa��o do sgbd do jdbc (jars)
- DAO: data access object - isola o c�digo do JDBC dentro da app - forma de juntar OO com bd relacional
- l�gica de neg�cios (service) ->  DAO (JDBC) -> BD
- desvantagens:
	- c�digo verboso
	- alto acoplamneto c/ BD: troca o nome da tabela, coluna gera muito impacto na app

### Hibernate
- biblioteca de mercado p/ simplificar o JDBC
- JPA especifica��o p/ ORM (Object Relational Mapping) p/ as bibliotecas implementarem (independencia)
- Hibernate 3.5.0 (2010) passou a implementar JPA 2
- concorrentes: EclipseLink (implementa��o de referncia da JPA), OpenJPA

### Criando e configurando um novo projeto JPA
- incluir as dependencias do hibernate e do driver do bd no pom.xml
- dentro da pasta src/main/resources criar uma nova pasta chamada META-INF e dentro da pasta um arquivo **persistence.xml**
	- ensina o jpa como acessar o sgbd: driver, endpoint, usuario, senha, etc 
	- hibernate.hbm2ddl.auto 
		- create: toda vez que criarmos um EntityManagerFactory, o Hibernate  ele vai apagar tudo e criar do zero as tabelas
		- create-drop: cria as tabelas quando rodarmos a aplica��o e, depois que terminamos de executar a aplica��o, ele imediatamente dropa.
		- update: atualizar a tabela se alguma mudan�a surgir (n�o apaga os dados). se apagarmos uma entidade ou um atributo dela, ele n�o apaga a tabela e nem a coluna,
		- validate : n�o mexe no banco, apenas valida se est� tudo ok no banco e gera um log
### Entidade
- classe que vai ser mapeada p/ uma tabela	
- ciclo de vida:
![Ciclo de vida](/lojaJPA/imagens/ciclo_de_vida.jpg)

### DAO
- c�digo isolado responsavel pela persist�ncia. Faz a ponte c/ o bd

### Mapeamento
- enum: o valor gravado na tabela Produto � a ordem da constante do enum

### Cardinalidade
![Relacionamentos](/lojaJPA/imagens/relacionamentos.jpg)
- quando existe um relacionamento entre entidades, vc � obrigado passar uma cardinalidade
	- @ManyToOne : 
	- @ManyToMany: ser� criado uma tabela de join
	- bidirecional: quando duas entidades est�o se mapeando: Pedido @OneToMany c/ ItemPedido @ManyToOne
- se estamos persistindo com uma entidade e vinculando com outra entidade, essa outra precisa estar persistida antes, ou receberemos uma exception "transiente property value excepetion".
- tabe


### JPQL
- n�o passo o nome da tabela e sim da entidade
- o sql n�o � case sensitive mas o nome das entidades s�o
- se a fun��o de agrega��o n�o existe no bd (nativa de outro bd), o JPA lan�a exception  
- named queries: as consultas ficam junto com as entidades

### Perfomance nas consultas
- Eager: carregamento antecipado. Faz um join c/ outras tabelas 
	- existe um relacionamento @ManyToOne (ou @OneToOne) e tbm pode carregar dados desnecessariamente
	- reduz perfomance
	- incluir nas anota��es @ManyToOne(fetch = FetchType.LAZY)
- Lazy: pregui�oso 
	- @OneToMany 
	- s� carrega se for feito acesso