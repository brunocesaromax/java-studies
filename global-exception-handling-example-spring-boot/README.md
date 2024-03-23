# Global Exception Handling
[![NPM](https://img.shields.io/npm/l/express)](https://github.com/brunocesaromax/global-exception-handling-example-spring-boot/blob/master/LICENSE)

# Sobre o projeto

A aplicação consiste na implementação do tratamento de vários erros possíveis que podem ser lançados em uma requisição para uma API REST.   
O objetivo principal dessa aplicação é servir de base para aplicações futuras que irão necessitar de um tratamento de erros mais completo.   
Referência: [Custom Error Message Handling for REST API](https://www.baeldung.com/global-error-handler-in-a-spring-rest-api)

## Tecnologias utilizadas

- Java 11
- Spring Boot 2.3.0
- Maven

## Como executar o projeto

Pré-requisitos: Java 11

  1 - Clonar o repositório: 
  
  ```bash 
  git clone https://github.com/brunocesaromax/global-exception-handling-example-spring-boot.git
  ```
  
  2 - Executar o projeto:
  
  
  ```bash 
  mvn spring-boot:run
  ```
  
  3 - Importar a coleção de requisições no postman:   
    - Caminho da coleção: /src/main/resources/static/postman-requests/Global Handling Errors.postman_collection.json   
    - Para importação do arquivo Global Handling Errors.postman_collection.json no Postman, seguir o seguinte tutorial: [Postman instructions for Importing and Exporting](https://kb.datamotion.com/?ht_kb=postman-instructions-for-exporting-and-importing)   
    
    
   ![Img 1](https://github.com/brunocesaromax/global-exception-handling-example-spring-boot/blob/master/src/main/resources/static/images/global-handler-img1.png)
   
  4 - Executar as requisições uma a uma e analisar o tratamento de erro obtido como resposta 
  
# Autor

Bruno César Vicente

 <a href="https://www.linkedin.com/in/bruno-cesar-vicente" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
