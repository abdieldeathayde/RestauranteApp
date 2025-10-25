# 🍽️ RestauranteApp

## 📋 Descrição do Projeto

O **RestauranteApp** é um sistema de gerenciamento para restaurantes, desenvolvido para otimizar o fluxo de trabalho, desde o registro de pratos e mesas até o controle de pedidos e gestão de usuários.

A aplicação foi construída utilizando a arquitetura de microserviços/monolítica (escolha a que se aplica) com **Spring Boot**, garantindo uma API robusta e escalável, e **MySQL** como banco de dados para persistência dos dados.

## 🚀 Funcionalidades Principais

  * **Gestão de Menu:** Cadastro, visualização, edição e exclusão de pratos e bebidas.
  * **Controle de Mesas:** Abertura, fechamento e status de ocupação das mesas.
  * **Sistema de Pedidos:** Registro de novos pedidos associados às mesas.
  * **Gestão de Usuários:** Criação de perfis (Ex: Administrador, Garçom, Cozinheiro) com níveis de acesso.
  * *(Adicione outras funcionalidades específicas do seu projeto aqui.)*

## 💻 Tecnologias Utilizadas

| Categoria | Tecnologia | Versão |
| :--- | :--- | :--- |
| Linguagem | Java | JDK 17+ |
| Framework | Spring Boot | 3.x.x |
| Banco de Dados | MySQL | 8.x.x |
| Gerenciador de Dependências | Maven | 3.x.x |
| ORM/Persistência | Spring Data JPA | - |

**Dependências Principais do Spring:**

  * `spring-boot-starter-web` (Para API RESTful)
  * `spring-boot-starter-data-jpa` (Para persistência de dados)
  * `mysql-connector-j` (Driver do MySQL)
  * `spring-boot-starter-validation` (Para validação de dados)
  * `Lombok para eliminar necessidade de adicionar Getters e Setters manualmente`

## 🛠️ Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

  * **Java Development Kit (JDK):** Versão 17 ou superior.
  * **Apache Maven:** Versão 3.x.x ou superior.
  * **Servidor MySQL:** Versão 8.x.x ou superior.
  * **Uma IDE:** IntelliJ IDEA, Eclipse ou VS Code com suporte a Spring Boot.

## ⚙️ Instalação e Configuração

Siga os passos abaixo para configurar o projeto localmente:

### 1\. Clonar o Repositório

```bash
git clone https://github.com/abdieldeathayde/RestauranteApp.git
cd RestauranteApp
```

### 2\. Configurar o Banco de Dados

1.  Crie um novo banco de dados no seu servidor MySQL. Você pode usar o comando:

    ```sql
    CREATE DATABASE restaurante_db;
    ```

2.  Acesse o arquivo de configuração `src/main/resources/application.properties` (ou `application.yml`) e atualize as propriedades de conexão com o banco de dados conforme o seu ambiente:

    ```properties
    # application.properties
    spring.datasource.url=jdbc:mysql://localhost:3306/restaurante_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=seu_usuario_mysql
    spring.datasource.password=sua_senha_mysql
    spring.jpa.hibernate.ddl-auto=update # Ou create, dependendo da sua preferência
    ```

      * **Importante:** Se for usar a propriedade `spring.jpa.hibernate.ddl-auto=create`, ela criará as tabelas automaticamente. Para produção, use `none` ou `update` com cuidado.

### 3\. Executar o Projeto

1.  **Via Maven (Terminal):**

    Navegue até o diretório raiz do projeto e execute:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

2.  **Via IDE:**

      * Importe o projeto como um projeto Maven.
      * Localize a classe principal da aplicação (aquela com `@SpringBootApplication`, ex: `RestauranteAppApplication.java`).
      * Execute o método `main`.

A aplicação estará rodando em `http://localhost:8080` (porta padrão do Spring Boot).

## 📄 Estrutura de Rotas (API REST)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/api/pratos` | Lista todos os pratos no menu. |
| `POST` | `/api/pratos` | Cadastra um novo prato. |
| `GET` | `/api/pedidos/{id}` | Busca um pedido específico. |
| `PUT` | `/api/mesas/{id}/status` | Atualiza o status de uma mesa. |
| *(Liste as principais rotas da sua API para facilitar o uso)* | | |

## 🤝 Contribuição

Contribuições são bem-vindas\! Se você deseja contribuir, siga estas etapas:

1.  Faça um *fork* do projeto.
2.  Crie uma *branch* para sua funcionalidade (`git checkout -b feature/minha-nova-feature`).
3.  Faça *commit* de suas mudanças (`git commit -m 'feat: Adiciona nova feature X'`).
4.  Faça *push* para a *branch* (`git push origin feature/minha-nova-feature`).
5.  Abra um *Pull Request*.

## 🔑 Licença

Este projeto está sob a licença **[MIT](https://opensource.org/licenses/MIT)**.
