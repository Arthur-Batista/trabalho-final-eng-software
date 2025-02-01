# **Projeto Final - Engenharia de Software I**  
Sistema de Biblioteca Acadêmica em Java

Desenvolvedores: **Arthur Batista** e **Malu Brito**

---

## **Descrição do Projeto**  
Este sistema de biblioteca acadêmica foi desenvolvido para gerenciar empréstimos, devoluções e reservas de livros, além de oferecer funcionalidades específicas para três tipos de usuários: alunos de graduação, alunos de pós-graduação e professores. O sistema também implementa notificações para observadores de livros e diversas consultas de informações.

### **Principais Funcionalidades**
- **Empréstimo de Livros:** Validação de disponibilidade e regras específicas por tipo de usuário.  
- **Devolução de Livros:** Registro e validação de devolução.  
- **Reserva de Livros:** Possibilidade de reserva com prioridade entre alunos.  
- **Observação de Livros:** Notificações para professores quando livros atingirem mais de duas reservas.  
- **Consultas:** Informações detalhadas sobre livros, usuários e notificações.  
- **Interface por Linha de Comando:** Sistema completamente operável via terminal.

---

## **Tecnologias Utilizadas**
- Linguagem de programação: **Java**
- Padrões de Projeto: **Singleton**, **Command**, **Strategy**, **Observer**
- Paradigma: **Programação Orientada a Objetos**

---

## **Como Inicializar o Sistema**
1. Certifique-se de estar na pasta `trabalho-final`.
2. Compile o código-fonte com o seguinte comando:  
   ```bash
   javac sistemabiblioteca/*.java
   ```
3. Execute o sistema com:  
   ```bash
   java sistemabiblioteca.InterfaceUsuario
   ```

---

## **Instruções de Uso**
1. **Comandos Disponíveis:**  
   - `emp <codigo_usuario> <codigo_livro>` – Realizar empréstimo de livro.  
   - `dev <codigo_usuario> <codigo_livro>` – Registrar devolução.  
   - `res <codigo_usuario> <codigo_livro>` – Fazer uma reserva de livro.  
   - `obs <codigo_usuario> <codigo_livro>` – Registrar professor como observador.  
   - `liv <codigo_livro>` – Consultar informações de um livro.  
   - `usu <codigo_usuario>` – Consultar informações de um usuário.  
   - `ntf <codigo_usuario>` – Consultar notificações recebidas por um professor.  
   - `sai` – Encerrar o sistema.  

---

## **Conformidade com Requisitos**
- Estrutura de classes baseada em **padrões de projeto**.
- Implementação de herança e polimorfismo.
- Sistema operável por **linha de comando**.
- Dados criados dinamicamente em memória.

---

## **Autores**  
- **Arthur Batista**  
- **Malu Brito**

