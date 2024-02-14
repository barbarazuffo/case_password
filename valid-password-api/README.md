## Projeto Validador de Senha
Indice
=================
<!--ts-->
* [1.0.0 Projeto Validador de Senha](#Projeto-Validador-de-Senha)
  * [1.1.0 Sobre](#Sobre)
  * [1.2.0 Estrutura do projeto](#Estrutura-do-projeto)
  * [1.3.0 Como usar](#Como-usar)
      * [1.3.1 Pré requisitos](#Pré-requisitos)
      * [1.3.2 Executar a aplicação](#Executar-a-aplicação)
      * [1.3.3 Executar os Testes](#Executar-os-testes)
<!--te-->
## Sobre
Aplicação para validar um input de senha de acordo com critérios específicos, caso seja invalida retorna o motivo.

## Estrutura do projeto
A aplicação foi projetada seguindo a linha do MVC - model, view, controller. O MVC promove a separação de preocupações, tornando o código mais modular, escalável e fácil de manter. Cada componente tem uma responsabilidade clara e interage com os outros de maneira definida.

- **Modelo:** é a ponte entre as camadas Visão (View) e Controle (Controller), consiste na parte lógica da aplicação, que gerencia o comportamento dos dados através de regras de negócios, lógica e funções.

- **Visão:** pode ser qualquer saída de representação dos dados. É onde os dados solicitados do Modelo (Model) são exibidos.

- **Controlador:** faz a mediação da entrada e saída, comandando a visão e o modelo para serem alterados de forma apropriada.


## Como usar
### Pré requisitos
Para começar sera necessario as seguintes instalações:  
- Java 17
- Maven 3.9.6
- IDE (Desenvolvida no intellij)
- Git
- Postman(Qualquer plataforma para testar reuisições)

### Executar a aplicação
 - Clonando o repositório no computador
```shell
git clone "https://github.com/barbarazuffo/case_password.git"
```
- Entrar na pasta certa do projeto
```shell
cd .\valid-password-api
```
- Baixar as dependencias e garantir que o codigo compile e execute
```shell
mvn clean package
```
- Rodando a aplicação: 
```shell
mvn spring-boot:run 
```
<!--ts-->
- Testando senhas
  - Entrar no postman criar uma nova requisição POST com a URL localhost:8080/validation
  - No Body, na opção de raw colocar {"password":"XXXXXXXXX"}
  - Enviar a requisição e conferir se a senha é valida ou não
<!--te-->

### Executar os testes
```shell
mvn test
```
###### _OBS : Antes de iniciar os testes é necessarop rodar o mvn clean package pelo menos uma vez._

