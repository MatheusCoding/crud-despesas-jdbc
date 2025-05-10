# CRUD de Despesas com Java JDBC e PostgreSQL

![Java](https://img.shields.io/badge/Java-17-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![JDBC](https://img.shields.io/badge/JDBC-4.2-blue)

Sistema completo para gerenciamento de despesas pessoais implementando operações CRUD (Create, Read, Update, Delete) usando Java JDBC com PostgreSQL.

## 📋 Funcionalidades

- Cadastro de despesas com categoria, valor e data
- Listagem completa de despesas
- Atualização de registros existentes
- Remoção de despesas
- Organização por categorias

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **JDBC** para conexão com banco de dados
- **PostgreSQL 15** como SGBD
- **Padrão DAO** (Data Access Object)
- **Maven** para gerenciamento de dependências

## 🗂️ Estrutura do Projeto
crud-despesas-jdbc/
├── src/
│ ├── main/java/org/example/
│ │ ├── dao/
│ │ │ ├── DespesaDAO.java
│ │ │ └── IDespesaDAO.java
│ │ ├── infra/
│ │ │ └── ConnectionFactory.java
│ │ ├── model/
│ │ │ ├── Categoria.java
│ │ │ └── Despesa.java
│ │ ├── AtualizarDespesas.java
│ │ ├── ListarDespesas.java
│ │ └── RemoverDespesa.java
├── pom.xml
