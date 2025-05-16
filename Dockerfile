# ----- Estágio 1: Build (Compilação) -----
# Usaremos uma imagem que tenha o Maven e o JDK 23.
# A tag 'maven:3.9-eclipse-temurin-23' combina Maven com JDK 23 da Eclipse Temurin.
# Verifique no Docker Hub por tags mais recentes ou específicas se necessário.
FROM maven:3.9-eclipse-temurin-23 AS builder

# Define o diretório de trabalho dentro do container para o estágio de build.
WORKDIR /build-app

# Copia o arquivo pom.xml primeiro.
# Isso otimiza o cache do Docker: se o pom.xml não mudar,
# o Docker pode reutilizar a camada de dependências já baixadas, acelerando o build.
COPY pom.xml .

# Baixa todas as dependências do projeto definidas no pom.xml.
# O comando 'dependency:go-offline' tenta baixar todas as dependências.
# '-B' (batch mode) evita prompts interativos.
RUN mvn dependency:go-offline -B

# Agora copia todo o código-fonte do seu projeto (a pasta 'src')
# para o diretório de trabalho no container.
COPY src ./src

# Executa o build do Maven para compilar o código e empacotar a aplicação em um arquivo JAR.
# '-DskipTests' pula a execução dos testes, o que é comum para acelerar o build da imagem Docker.
# Se você precisar que os testes rodem durante o build da imagem, remova -DskipTests.
RUN mvn clean package -DskipTests

# ----- Estágio 2: Runtime (Execução) -----
# Para o estágio de runtime, usamos uma imagem base leve que tenha apenas o JRE (Java Runtime Environment) 23.
# 'eclipse-temurin:23-jre-jammy' é uma boa opção, oferecendo o JRE 23 sobre uma base Ubuntu Jammy.
# Imagens 'alpine' são menores, mas 'jammy' (ou similar baseada em Debian/Ubuntu) pode ser mais compatível.
FROM eclipse-temurin:23-jre-jammy

# Define o diretório de trabalho dentro do container para o estágio de runtime.
WORKDIR /app

# Copia APENAS o arquivo JAR compilado do estágio 'builder'
# para o diretório de trabalho atual (/app) na imagem final.
# O Maven geralmente coloca o JAR em target/SEU_APP-VERSAO.jar.
# O '*' (curinga) ajuda a pegar o JAR mesmo que o nome da versão mude,
# assumindo que é o único JAR principal na pasta target.
COPY --from=builder /build-app/target/*.jar app.jar

# (Opcional, mas recomendado para segurança)
# Cria um usuário e grupo dedicados para rodar a aplicação, em vez de usar root.
RUN addgroup --system springappgroup && adduser --system --ingroup springappgroup springappuser
USER springappuser

# Expõe a porta em que a aplicação Spring Boot estará escutando dentro do container.
# O Spring Boot usa a porta 8080 por padrão.
EXPOSE 8080

# Define o comando que será executado quando o container iniciar.
# Isso executa o seu arquivo JAR.
ENTRYPOINT ["java", "-jar", "app.jar"]
