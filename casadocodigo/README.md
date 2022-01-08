# Amazon e Spring: Deploy de uma aplicação Spring MVC na AWS

## Fazendo upload no S3
- serviço p/ armazenamento de arquivos

### Testando a aplicação localmente
- usando o MariaDB, o hibernate.dialect é o org.hibernate.dialect.MySQL5Dialect

### Configurando alarmes e criando bucket
- alarme de billing: Billing Console > Budgets
- bucket: balde ou repositório
- A Amazon estipula que os Buckets criados com os serviços do S3 devem ser únicos, ou seja, não é possível termos dois Buckets exatamente com o mesmo nome mesmo que tenham sido configurados por usuários diferentes ou regiões diferentes.

### Configurando acesso ao S3
-IAM: criar usuário c/ permissão deacessar os recursos do S3
	- tipo de acesso: Programmatic Access
	- Attach existing policies directly e selecione a opção Amazon S3 Full Access
	- fazer download do .csv c/ as credenciais que irão conter a chave de acesso e a chave de segredo para que possamos realizar a autenticação com a Amazon

### Criando classe de configuração
- incluir a dependência spring-cloud-aws-context	

### Alterando a classe FileSaver

