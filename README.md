Aqui está o README para o seu projeto "Fut - Agenda":

---

# Fut - Agenda ⚽

**Fut - Agenda** é um sistema de gerenciamento de partidas de futebol, desenvolvido para facilitar a organização de jogos e o controle de agendamentos de campos. Com ele, campos e administradores podem gerenciar partidas, horários e pagamentos, enquanto usuários e organizadores podem reservar horários, ingressar em partidas e gerenciar seus perfis.

![Fut - Agenda Banner](https://via.placeholder.com/800x300.png?text=Fut+-+Agenda)

## Tecnologias Utilizadas 🛠️
- **Back-end:** Java (Spring Boot)
- **Front-end:** React.js
- **Banco de Dados:** PostgreSQL
- **Outras tecnologias:** RESTful APIs, JWT para autenticação.

## Funcionalidades Principais 🎯
### Papéis e Responsabilidades
- **Campo:**
  - Criar, editar e excluir partidas.
  - Editar valor dos aluguéis.
  - Consultar informações de pagamento.
  - Confirmar o aluguel da partida.
  
- **Admin:**
  - Criar, editar e excluir partidas.
  - Editar valor de aluguéis.
  - Consultar informações de pagamento.
  - Confirmar o aluguel de partidas.
  - Excluir usuários.
  - Criar usuários de campos.

- **Usuário:**
  - Ingressar em partidas.
  - Editar e excluir perfil.
  - Consultar partidas disponíveis.
  - Enviar comprovante de pagamento.

- **Organizador:**
  - Gerenciar partidas.
  - Ingressar em partidas.
  - Editar e excluir perfil.
  - Enviar comprovante de pagamento.

### Requisitos Funcionais 📋
1. Criar, editar e excluir partidas.
2. Exibir lista de horários disponíveis.
3. Permitir aluguel de horários pelos usuários.
4. Upload de comprovantes de pagamento.
5. Cadastro e login de usuários.
6. Confirmar aluguel do campo.
7. Excluir e editar perfil e partidas (usuários e organizadores).
8. Permitir que o admin gerencie usuários.

### Requisitos Não Funcionais 🔧
1. Resposta do sistema em até 2,5 segundos.
2. Acesso dos campos a dados dos usuários.

## Instalação 🚀
### Backend
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/fut-agenda.git
   cd backend
   ```
2. Configure o banco de dados PostgreSQL no `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/futagenda
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   ```

3. Compile e execute a aplicação Spring Boot:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend
1. Navegue até o diretório do frontend:
   ```bash
   cd frontend
   ```

2. Instale as dependências:
   ```bash
   npm install
   ```

3. Inicie o servidor de desenvolvimento:
   ```bash
   npm start
   ```

## Contribuição 🤝
Sinta-se à vontade para contribuir com melhorias e novas funcionalidades para o **Fut - Agenda**. Para isso, siga os passos:
1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Envie suas alterações (`git commit -am 'Adiciona nova feature'`).
4. Faça o push para a branch (`git push origin feature/nova-feature`).
5. Crie um pull request.

## Licença 📄
Este projeto está licenciado sob a [MIT License](LICENSE).

---

Essa estrutura de README proporciona clareza e facilita o entendimento do projeto. Você pode personalizar ainda mais incluindo capturas de tela reais ou diagramas do sistema.