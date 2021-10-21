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
- ciclo de vida:
![Ciclo de vida](/lojaJPA/imagens/ciclo_de_vida.jpg)

### DAO
- código isolado responsavel pela persistência. Faz a ponte c/ o bd

### Mapeamento
- enum: o valor gravado na tabela Produto é a ordem da constante do enum

### Cardinalidade
![Relacionamentos](/lojaJPA/imagens/relacionamentos.jpg)
- quando existe um relacionamento entre entidades, vc é obrigado passar uma cardinalidade
	- @ManyToOne : 
	- @ManyToMany: será criado uma tabela de join
	- bidirecional: quando duas entidades estão se mapeando: Pedido @OneToMany c/ ItemPedido @ManyToOne
- se estamos persistindo com uma entidade e vinculando com outra entidade, essa outra precisa estar persistida antes, ou receberemos uma exception "transiente property value excepetion".
- tabe


### JPQL
- não passo o nome da tabela e sim da entidade
- o sql não é case sensitive mas o nome das entidades são
- se a função de agregação não existe no bd (nativa de outro bd), o JPA lança exception  
- named queries: as consultas ficam junto com as entidades

### Perfomance nas consultas
- Eager: carregamento antecipado. Faz um join c/ outras tabelas 
	- existe um relacionamento @ManyToOne (ou @OneToOne) e tbm pode carregar dados desnecessariamente
	- reduz perfomance
	- incluir nas anotações @ManyToOne(fetch = FetchType.LAZY)
- Lazy: preguiçoso 
	- @OneToMany 
	- só carrega se for feito acesso