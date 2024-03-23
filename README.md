
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

##### Value

```http
  {
    "name": "Fiat Toro 2023",
    "value": 203.000
  }
```

#### Return

```http
  201 Created 
```





| Função                    |  Comando                                    | 
| :----------               | :----------                                  | 
| `GET `          | `http://localhost:8080/products`                        |


#### Return

```http
   {
        "idProduct": "acfafa59-3763-4073-9317-5cbb3488467c",
        "name": "Fiat Toro 2023",
        "value": 203.00
    }
```



| Função                    |  Comando                                    | 
| :----------               | :----------                                  | 
| `GET `          | `http://localhost:8080/products/acfafa59-3763-4073-9317-5cbb3488467c`                        |


#### Return

```http
   {
        "idProduct": "acfafa59-3763-4073-9317-5cbb3488467c",
        "name": "Fiat Toro 2023",
        "value": 203.00
    }
```



| Função                    |  Comando                                    | 
| :----------               | :----------                                  | 
| `PUT `          | `http://localhost:8080/products/acfafa59-3763-4073-9317-5cbb3488467c`                        |



##### Value

```http
  {
    "name": "Fiat Toro 2020",
    "value": 103.000
  }
```

#### Return

```http
  201 Created 

```

| Função                    |  Comando                                    | 
| :----------               | :----------                                  | 
| `DELETE `          | `http://localhost:8080/products/acfafa59-3763-4073-9317-5cbb3488467c`                        |


#### Return

```http
  204 NO CONTENT 

```




