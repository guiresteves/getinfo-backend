Como testar a API localmente:

1. Baixe o projeto pelo github ou clone o repositório na sua máquina.
2. Instale o MySQL e o MySQLWorkbench
3. Escolher uma das opções abaixo para o banco de dados:


Opção 1:
É necessário que sua máquina tenha um banco de dados criado com essas especificações:
localhost:3306/contratosdb
username=contratos_user
password=getinfo123
##
Opção 2:
Pode criar um banco diferente mas deve editar o application-dev.properties
colocando qual banco que tem no seu computador que ele irá acessar.
Ajuste as partes que tem:
spring.datasource.url=jdbc:mysql://localhost:3306/contratosdb
spring.datasource.username=contratos_user
spring.datasource.password=getinfo123
##
É dessa forma que a aplicação e o JPA irá acessar o banco e criará as tabelas automaticamente.
4. Execute a classe ContratosApplication.
Caso não ocorra nenhum problema na inicialização e apareça a mensagem:
O servidor está sendo executado em http://localhost:8080
A aplicação foi inicializada com sucesso e você pode testar.

Caso teste usando swagger:
Pode acessar usando o link: http://localhost:8080/swagger-ui/index.html

