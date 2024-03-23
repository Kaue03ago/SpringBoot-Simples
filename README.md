
# Spring Boot Básico

Está é uma implementação básica de um Spring Boot, por enquanto! O intuito é realizar o desenvolvimento de mais funcionalidade para ele.

# Preparação Ambiente:
- JDK 17
- Maven
- Postman
- PgAdmin (Postgres)
- IDE (IntelliJ, STS, Eclipse, etc)
## Instalação e Execução 

#### 1- Clone o repositório 

```http
 git clone https://github.com/Kaue03ago/SpringBoot-Simples.git
```
#### 2- Navegue até o diretório do projeto:

```http
 cd SpringBoot-Simples
```

#### 3- Execute em sua IDE de preferencia

#### 4- O projeto estará disponível em http://localhost:8080

#### 5- Abra o Postman para testar as funcionalidades 




# Endpoints da API


```http
  GET /api/items/${id}
```

| Parâmetro                 | Descrição                                    |
| :----------               | :----------                                  |
| `POST /products`          | `Cria novos produtos`                        |
| `GET /products`           | `Retorna todos os produtos`                  |
| `GET /products/{id}`      | `Cria novos produtos`                        |
| `PUT /products/{id}`      | ` Atualiza um produto existente pelo ID.`    |
| `DELETE /products/{id}`   | `Deleta um produto existente pelo ID.`       |
| `DELETE /products`        | `Deleta todos os produtos`                   |



#   Exemplo de requisições

##### Utilizando o Postman.

| Função                    |  Comando                                    | 
| :----------               | :----------                                  | 
| `POST `          | `http://localhost:8080/products`                        |
| `GET `          | `http://localhost:8080/products`                        |
| `GET `          | `http://localhost:8080/products/acfafa59-3763-4073-9317-5cbb3488467c`                        |
| `PUT `          | `http://localhost:8080/products/acfafa59-3763-4073-9317-5cbb3488467c`                        |
| `DELETE `          | `http://localhost:8080/products/acfafa59-3763-4073-9317-5cbb3488467c`                        |
