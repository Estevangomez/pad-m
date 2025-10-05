# ================================
# Etapa 1 — Build do projeto
# ================================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia todo o código para dentro do container
COPY . .

# Faz o build (gera o JAR em /target)
RUN mvn clean package -DskipTests

# ================================
# Etapa 2 — Imagem final para execução
# ================================
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=build /app/target/padm-0.0.1-SNAPSHOT.jar app.jar

# Define a porta (Render define via variável PORT)
ENV PORT=8080
EXPOSE 8080

# Comando que inicia o app
ENTRYPOINT ["java", "-jar", "app.jar"]
