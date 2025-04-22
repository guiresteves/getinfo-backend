#!/bin/bash

# Configurações
USUARIO="contratos_user"
BANCO="contratosdb"
ARQUIVO_SQL="CREATE-TABLE.sql"

# Pede a senha do usuário
echo -n "Digite a senha do MySQL para o usuário '$USUARIO': "
read -s SENHA
echo

# Cria a base de dados
echo "Criando banco de dados '$BANCO'..."
mysql -u "$USUARIO" -p"$SENHA" -e "CREATE DATABASE IF NOT EXISTS $BANCO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"

# Importa o SQL
echo "Importando o arquivo '$ARQUIVO_SQL' para o banco '$BANCO'..."
mysql -u "$USUARIO" -p"$SENHA" "$BANCO" < "$ARQUIVO_SQL"

echo "✅ Tudo pronto!"
