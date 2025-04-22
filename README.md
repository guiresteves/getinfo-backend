# Como executar o projeto

1. Baixe o projeto pelo github
2. Instale o MySQL
3. Abra o MySQL
4. Execute o script "CREATE USER 'contratos_user'@'localhost' IDENTIFIED BY 'getinfo123';"
5. Crie o schema "contratosdb"
6. Execute o script "GRANT ALL PRIVILEGES ON contratosdb.* TO 'contratos_user'@'localhost';"
7. Execute o arquivo [ContratosApplication.java](getinfo-backend/contratos/src/main/java/com/getinfo/contratos/ContratosApplication.java)
8. No navegador de sua preferência, acesse <http://localhost:8080/empresas>
