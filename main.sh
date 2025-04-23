#!/bin/bash

ROOT_USER="root"
NOVO_USUARIO="contrato_user"
BANCO="contratosdb"
CREATE_SQL="CREATE-TABLE.sql"
INSERT_SQL="INSERTS-exemplos.sql"

echo -n "Digite a senha do MySQL para o usuário '$ROOT_USER': "
read -s ROOT_SENHA
echo

# 1. Criar o banco
echo "Criando banco de dados '$BANCO'..."
mysql -u "$ROOT_USER" -p"$ROOT_SENHA" -e "CREATE DATABASE IF NOT EXISTS $BANCO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"

# 2. Criar novo usuário e senha (senha padrão: getinfo123)
echo "Criando o usuário '$NOVO_USUARIO' com acesso total ao banco '$BANCO'..."
mysql -u "$ROOT_USER" -p"$ROOT_SENHA" -e "CREATE USER IF NOT EXISTS '$NOVO_USUARIO'@'localhost' IDENTIFIED BY 'getinfo123';"
mysql -u "$ROOT_USER" -p"$ROOT_SENHA" -e "GRANT ALL PRIVILEGES ON $BANCO.* TO '$NOVO_USUARIO'@'localhost';"
mysql -u "$ROOT_USER" -p"$ROOT_SENHA" -e "FLUSH PRIVILEGES;"

# 3. Criar tabelas com o novo usuário
echo "Criando tabelas com '$CREATE_SQL' usando '$NOVO_USUARIO'..."
mysql -u "$NOVO_USUARIO" -p"getinfo123" "$BANCO" < "$CREATE_SQL"

# 4. Importar dados com o novo usuário
echo "Importando dados com '$INSERT_SQL' usando '$NOVO_USUARIO'..."
mysql -u "$NOVO_USUARIO" -p"getinfo123" "$BANCO" < "$INSERT_SQL"

echo "✅ Banco criado, usuário configurado e dados importados com sucesso!"
read -p "Pressione Enter para sair..."