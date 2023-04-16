
# api_buscaCep

Projeto de API REST de consulta de cep's brasileiros. Basicamente, a API faz o dowload de um arquivo .csv com todos os cep's do Brasil e salva esses dados no banco.
## Stack utilizada

**Back-end:** JAVA 17, Spring Boot, Spring Data e MySQL.




## Documentação da API


### Recuperar o cep

```http
  GET localhost:8080/cep/{cep}
```
##### Exemplo de retorno
```bash
  {"cep":"39930000",
  "rua":null,
  "bairro":"",
  "cidade":"Jacinto",
  "estado":"MG"}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cep`      | `string` | **Obrigatório**. O código do cep que você quer recuperar|




## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/caiofrz/api_buscaCep.git
```

Entre no diretório do projeto

```bash
  cd api_buscaCep
```
### Configure o banco

É preciso que você tenha o MySQL instalado na sua máquina. Caso não tenha, acesse o [site](https://www.mysql.com) e instale.

O segundo passo é criar o banco. Para isso utilize o comando: 
```bash
  create database nomeDoBanco;
```

### Configurando a aplicação

Vá até o arquivo **application.properties** e altere as configurações. O caminho do arquivo é *src/main/resources*:

```bash
    spring.datasource.url=jdbc:mysql://localhost:porta/nomeDoBanco
```

| Parâmetro   | Exemplo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `porta`      | `3306` | Esse propriedade da url se refere a porta em que o MySQL estará rodando. A porta default é 3306|
| `nomeDoBanco`      | `buscacep` | Esse propriedade da url se refere ao nome do banco de dados que você criou|


```bash
    spring.datasource.username=root
    spring.datasource.password=root
```
| Parâmetro   | Exemplo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `username`      | `root` | Esse propriedade se refere ao seu nome de usuario que foi criado. O nome default é root|
| `password`      | `root` | Esse propriedade se refere a sua senha de usuario que foi criada|


Agora basta dar start na aplicação. O seu navegador deve abrir uma aba com a aplicação rodando.

Caso isso não aconteça a app estará rodando na porta *8080* da sua máquina. Acesse o navegador e digite: http://localhost:8080 e pronto.


## Feedback

Se você tiver algum feedback, por favor não deixe de dá-lo. 

Me contate através do [github](https://github.com/caiofrz) 
ou [LinkedIn](https://www.linkedin.com/in/caio-ferraz-almeida/) 


## Referência

 - [Milton](https://www.youtube.com/@1000tonprogramador) que disponibilizou a aula do projeto e o arquivo .csv com os cep's

