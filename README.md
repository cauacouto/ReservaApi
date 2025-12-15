# 🏨 reservaApi - Sistema de Gestão de Reservas

Projeto de back-end desenvolvido em **Spring Boot** para gerenciar o ciclo de vida de reservas (CRUD) e implementar um fluxo de trabalho de confirmação de e-mail transacional robusto, substituindo a dependência de serviços externos (como n8n) por uma solução nativa e segura.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21+
* **Framework:** Spring Boot 3.x
* **Persistência:** Spring Data JPA
* **Banco de Dados:** H2 Database (Em memória/Arquivo)
* **Email:** Spring Mail (Utilizando SMTP do Google/Gmail)
* **Ferramenta de API:** Insomnia / Postman

## 🚀 Funcionalidades Principais

* **CRUD Completo:** Criação, Leitura, Atualização (Total e Parcial) e Exclusão de Reservas.
* **Confirmação Imediata por E-mail:** Envio automático de confirmação de reserva para o cliente, disparado diretamente do `ReservaService`.
* **Integração Segura com Gmail:** Utilização do `JavaMailSender` e Senha de App (App Password) para autenticação SMTP segura.
* **Resiliência:** Implementação de tratamento de exceção (`try-catch`) no `EmailService` para garantir que a falha no envio do e-mail **NÃO** impeça o salvamento da reserva no banco de dados.

## ⚙️ Configuração e Instalação

### 1. Pré-requisitos

Certifique-se de ter instalado:
* Java Development Kit (JDK) 21 ou superior
* Maven

### 2. Clonar o Repositório

```bash
git clone [https://github.com/seu_usuario/reservaApi.git](https://github.com/seu_usuario/reservaApi.git)
cd reservaApi
