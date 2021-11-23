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
$ cd cwbshop/

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

- Para baixar a cwbshop direto do docker hub:
```bash
# Link docker hub https://hub.docker.com/r/stengrat/cwbshop
$ docker pull stengrat/cwbshop
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

### ⚙️OpenAPI
A documentação no padrão OpenAPI você pode consultar [aqui](http://localhost:8060/swagger-ui.html)

### 🧪 Payloads e Endpoints

É possivel fazer download do arquivo para importar no insomnia <a href="Insomnia_cwbshop_collection.json" download>aqui</a>

#### 🔓 Endpoints sem autenticação
```json
/attribute GET/POST/DELETE
localhost:8060/attribute

{
  "attribute_id": "teste",
  "value_name": "Marca del producto"
}
```
```json
/city GET/POST/DELETE
localhost:8060/city
        
{
  "id": "CWB",
  "name": "Curitiba"
}

```

```json
/country GET/POST/DELETE
localhost:8060/country

{
  "id": "BR",
  "name": "Brasil"
}
```

```json
/state GET/POST/DELETE
localhost:8060/state

{
  "id": "PR",
  "name": "Paraná"
}
```

```json
/address GET/POST/DELETE
localhost:8060/address

{
  "city": {
    "id": "CWB",
    "name": "Curitiba"
  },
  "state": {
    "id": "PR",
    "name": "Paraná"
  },
  "country":{
    "id": "BR",
    "name": "Brasil"
  }
}
```

#### 🔐 Endpoints com autenticação
Primeiro passo realizar o login, e salvar o token que retorna no Header

```json
/login GET
localhost:8060/login

{
  "username": "progweb",
  "password": "progweb"
}

```
Passar como Bearer token o codigo retornado atraves do endpoint /login

```json
/user GET/POST
localhost:8060/api/user

{
  "login": "gnomo",
  "password": "xambrolinha",
  "firstName": "Gnomo",
  "lastName": "Teste",
  "dtCreation": "2021-11-11",
  "dtUpdate": "2021-11-11"
}
```

```json
/api/product GET/POST/PUT/DELETE
localhost:8060/api/product

{
  "id":"MLB1191972200",
  "site_id":"MLB",
  "title":"iPhone Xs  64gb",
  "id_integracao": 123123,
  "subtitle":null,
  "seller_id":386261073,
  "price":7299,
  "base_price":7299,
  "original_price":null,
  "currency_id":"BRL",
  "initial_quantity":5,
  "available_quantity":2,
  "start_time":"2019-03-11T20:12:44.000Z",
  "stop_time":"2039-03-06T04:00:00.000Z",
  "condition":"new",
  "permalink":"URLASERDADA/NOMESERVICO/PRODUTO/IDANUNCIO",
  "seller_address":{
    "city":{
      "id":"TUxCQ1NFUmI1ZGQx",
      "name":"Serra"
    },
    "state":{
      "id":"BR-ES",
      "name":"Espírito Santo"
    },
    "country":{
      "id":"BR",
      "name":"Brasil"
    },
    "id":1017932319
  },
  "seller_contact":null,
  "attributes":[
    {
      "id":"BRAND",
      "value_name":"Marca del producto"
    },
    {
      "id":"EAN",
      "value_name":"7898095297749"
    }
  ]
}
```


