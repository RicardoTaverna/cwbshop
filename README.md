<h1 align="center">
    <img alt="CWBShop" title="Lista Fáccil" src="./images/CWBSHOP.png"/>
    
</h1>
<h2 align="center">CWBShop</h2>

<p align="center">Projeto de Microserviços em JAVA da máteria de Desenvolvimento Web Seguro, prof. Rodrigo Fujioka. Criada uma API Rest utilizando java 11 Spring Boot e Maven, com Service Discovery (Eureka) e gateway para resgistrar as rotas, qualidade do código utilizando SonarQube e testes unitários com Junit 5.</p>

<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/RicardoTaverna/cwbshop?color=%23734F3C&style=for-the-badge">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/RicardoTaverna/cwbshop?style=for-the-badge">
  
  <a href="https://github.com/RicardoTaverna/cwbshop/commits/main">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/RicardoTaverna/cwbshop?color=%23734F3C&style=for-the-badge">
  </a>

  <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen?color=%23734F3C&style=for-the-badge">
   <a href="https://github.com/RicardoTaverna/cwbshop/stargazers">
    <img alt="Stargazers" src="https://img.shields.io/github/stars/RicardoTaverna/cwbshop?style=for-the-badge">
  </a>

  <img alt="Repository Issues" src="https://img.shields.io/github/issues/RicardoTaverna/cwbshop?color=%23734F3C&style=for-the-badge">
</p>


## 💻 Tabela de conteúdos


* [Sobre](#Sobre)
* [Tabela de Conteudo](#tabela-de-conteudo)
* [Tecnologias](#tecnologias)
* [Executar projeto](#executar-projeto)
    * [Pré-requisitos](#pré-requisitos)
    * [Execução](#execução)
    * [Ambiente Desenvolvimento](#Ambiente-Desenvolvimento)
    * [Testes](#Testes)
* [Endpoints](#endpoints)


## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- <a href="https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html">
    <img alt="Java" src="https://img.shields.io/badge/Java-v11-734F3C?style=for-the-badge" style="width: 100px;" >
</a>

- <a href="https://maven.apache.org/">
    <img alt="Maven" src="https://img.shields.io/badge/Maven-v3.8.4-734F3C?style=for-the-badge">
</a>

- <a href="https://spring.io/projects/spring-boot">
    <img alt="Spring Boot" src="https://img.shields.io/badge/SpringBoot-v5.3.13-734F3C?style=for-the-badge">
</a>

- <a href="https://www.docker.com">
    <img alt="Docker Compose" src="https://img.shields.io/badge/Docker_Compose-v1.28.5-734F3C?style=for-the-badge">
</a>

- <a href="https://www.docker.com">
    <img alt="Docker" src="https://img.shields.io/badge/Docker-v20.10-734F3C?style=for-the-badge">
</a>

- <a href="https://www.mysql.com">
    <img alt="Mysql" src="https://img.shields.io/badge/MySQL-v8.0.21-734F3C?style=for-the-badge">
</a>

- <a href="https://cloud.spring.io/spring-cloud-netflix/reference/html/">
    <img alt="Eureka" src="https://img.shields.io/badge/Eureka-v8.0.21-734F3C?style=for-the-badge">
</a>



## 🚀 Executar projeto

Para executar esse pojeto você precisa de alguns pré-requisitos:

### 🚥 Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html), [Apache Maven](https://maven.apache.org/) e [Docker](https://www.docker.com). 
Além disto é bom ter uma IDE para trabalhar com o código como [IntelliJ](hhttps://www.jetbrains.com/pt-br/idea/).

### ⌛ Execução
```bash
# clonar o repositório 
$ git clone https://github.com/RicardoTaverna/cwbshop.git
```
### 🏭 Ambiente Desenvolvimento

- Com sua IDE aberta, execute na ordem abaixo os projetos:
    - Projeto Eureka: eureka/src/main/java/com/rodrigofujioka/eureka/EurekaApplication.java
    - Projeto Gateway: gateway/src/main/java/com/rodrigofujioka/GatewayAppConfig.java
    - Projeto cwbshop (API): cwbshop/src/main/java/br/pucpr/cwbshop/CwbshopApplication.java
    ```bash
    # na pasta cwbshop/ rode o comando abaixo para criar as pastas corretas dentro de 'target'
    $ mvn clean install
    ```

- Para criar as imagens e subir como containers:
```bash

# Acessar a pasta /cwbshop
$ cd backend/

# criar uma imagem apartir do Dockerfile
$ docker build -t cwbshop-api/cwbshop-service:latest . 

# Acessar a pasta /eureka
$ cd ..
$ cd eureka/

# criar uma imagem apartir do Dockerfile
$ docker build -t cwbshop-api/eureka-service:latest .  

# Acessar a pasta /gateway
$ cd ..
$ cd gateway/

# criar uma imagem apartir do Dockerfile
$ docker build -t cwbshop-api/gateway-service:latest . 

# Subir todos os serviços
$ cd ..
$ docker-compose up


# o servidor do eureka iniciará localhost:8167
# o servidor do gateway iniciará localhost:8080
# o servidor da API iniciará localhost:8060
```

### 🐛 Testes

- Para executar os testes unitários, acesse e execute pela IDE o arquivo: cwbshop/src/test/java/br/pucpr/cwbshop/CwbshopApplicationTests.java
- Para visualizar a cobertura do código:
    - acesse o serviço do SonarQube: localhost:9000
    - entre com o usuário: __admin__ , senha: __admin__
    - de um nome para sua instância de testes e salve o token gerado <TOKEN>
    - acesse o projeto cwb e rode o comando:
    ```bash
    # na pasta cwbshop/ rode o comando abaixo para gerar as métricas no sonarqube
    $ mvn sonar:sonar -login:<TOKEN>
    ```

## 🚧 Endpoints
A documentação no padrão OpenAPI você encontra [aqui](/backend/docs/documentation.yml)