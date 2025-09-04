# ToDoList API

Uma API RESTful simples para gerenciamento de tarefas (To-Do List), construída com Spring Boot.

## 📝 Descrição

Este projeto é uma API RESTful desenvolvida para realizar operações básicas de um gerenciador de tarefas. Permite criar, listar, buscar, atualizar e deletar tarefas. A aplicação foi construída utilizando Java e o ecossistema Spring, demonstrando práticas modernas de desenvolvimento de APIs.

## ✨ Funcionalidades

* **Criar Tarefa:** Adicionar uma nova tarefa com título, descrição e prazo.
* **Listar Todas as Tarefas:** Obter uma lista completa de todas as tarefas cadastradas.
* **Buscar Tarefa por ID:** Encontrar uma tarefa específica utilizando seu ID.
* **Atualizar Tarefa:** Modificar o título, a descrição e o prazo de uma tarefa existente.
* **Deletar Tarefa:** Remover uma tarefa do sistema pelo seu ID.

## 🛠️ Tecnologias Utilizadas

Analisando os arquivos, as principais tecnologias utilizadas são:

* **Java**: Linguagem de programação principal.
* **Spring Boot**: Framework principal para a criação da aplicação e do servidor web embutido.
* **Spring Web**: Para a criação dos endpoints RESTful (`@RestController`).
* **Spring Data JPA**: Para a persistência de dados e comunicação com o banco de dados (`JpaRepository`).
* **Hibernate**: Como implementação da JPA, gerenciando o mapeamento objeto-relacional (`@Entity`, `@Column`, etc.).
* **Lombok**: Para reduzir código boilerplate em classes de modelo e controllers (`@Getter`, `@Setter`, `@AllArgsConstructor`, etc.).
* **Swagger (OpenAPI)**: Para a documentação interativa dos endpoints da API (`@Operation`, `@ApiResponse`).

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar o projeto em sua máquina local.

### Pré-requisitos

* JDK (Java Development Kit) instalado.
* Maven ou Gradle para gerenciamento de dependências.
* Um banco de dados compatível com JPA/Hibernate (Ex: H2, PostgreSQL, MySQL).
* Um cliente de API, como Postman ou Insomnia, para testar os endpoints.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/PierryB/ToDoList-Api.git](https://github.com/PierryB/ToDoList-Api.git)
    cd ToDoList-Api
    ```

2.  **Configure o Banco de Dados:**
    No arquivo `src/main/resources/application.properties` (ou `application.yml`), configure os detalhes da sua conexão com o banco de dados:
    ```properties
    spring.datasource.url=jdbc:seu-banco://localhost:5432/todolist
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Execute a aplicação:**
    Utilize o wrapper do Maven ou Gradle para executar a aplicação a partir da classe `ToDoListApplication`:
    ```bash
    # Usando Maven
    ./mvnw spring-boot:run

    # Usando Gradle
    ./gradlew bootRun
    ```

4.  **Acesse a API:**
    A aplicação estará disponível em `http://localhost:8080`.

### Documentação Swagger

Para uma visualização interativa e para testar os endpoints, acesse a documentação do Swagger UI no seu navegador após iniciar a aplicação:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
