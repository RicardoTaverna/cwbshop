# cwbshop

Projeto de Microserviços em JAVA

## Levantar ambiente de dev

- executar o projeto cwbshop;
- executar o projeto eureka;
- executar o projeto gateway;
- acessar a pasta cwbshop e rodar o comando ```docker build -t cwbshop-api/cwbshop-service:latest . ```;
- acessar a pasta eureka e rodar o comando ```docker build -t cwbshop-api/eureka-service:latest . ```;
- acessar a pasta eureka e rodar o comando ```docker build -t cwbshop-api/gateway-service:latest . ```;
- acessar a pasta raiz e executar o comando ```docker-compose up -d ```;