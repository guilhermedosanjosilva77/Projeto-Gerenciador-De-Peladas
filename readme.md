<div align="center">
  <h1><strong>⚽ Gerenciador de Peladas (MasterLiga)</strong></h1>
</div>


<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />
</div>

O Gerenciador de peladas é uma Api FullStack desenvolvido para organizar campeonatos de futebol amador, gerenciar times, jogadores e automatizar o controle de estatísticas (gols, assistências e cartões). O projeto foca em integridade de dados e relacionamentos complexos no banco de dados.

🚀 *Tecnologias Utilizadas*
Back-end

•	Java 17 & Spring Boot 3.4+

•	Spring Data JPA: Persistência de dados e relacionamentos complexos.

•	Hibernate: Mapeamento Objeto-Relacional (ORM) com suporte a operações em cascata e vínculos bidirecionais.

•	MySQL: Banco de dados relacional.

•	Maven: Gerenciamento de dependências.
_____________________________________________________

⚙️ *Arquitetura do Sistema*
A aplicação segue o padrão de camadas para garantir a separação de responsabilidades:
1.	Controller: Exposição de endpoints REST com tratamento de respostas via Response.
2.	Service: Camada de regras de negócio, incluindo a lógica de vínculos bidirecionais (ex: associar múltiplos times a uma liga simultaneamente).
3.	Repository: Interface de comunicação com o MySQL via JPA.
4.	DTO (Data Transfer Object): Uso de Java Records para transferir dados de forma segura, evitando recursão infinita em relacionamentos @OneToMany.
________________________________________________________

🛠️ *Funcionalidades Principais*

•	Gestão de Ligas: Criação de competições com definição de modalidade, formato e limites de times.

•	Vínculo Inteligente: Ao criar uma liga, o sistema associa automaticamente os IDs dos times, atualizando a chave estrangeira no banco de dados via lógica bidirecional.

•	Estatísticas de Atletas: Registro individual de performance (Gols, Assistências, Cartões Amarelos/Vermelhos).

•	Segurança de Dados: Tratamento de erros para IDs inexistentes e validação de campos nulos.

________________________________________________________

📥 *Como executar o projeto*

Pré-requisitos
•	Java 17 ou superior.

•	MySQL Server.

Passos para o Back-end:

1.	Clone o repositório:
Bash
git clone https://github.com/seu-usuario/gerenciadordepeladas.git

2.	Configure o application.properties com suas credenciais do MySQL:
Properties ->
spring.datasource.url=jdbc:mysql://localhost:3306/gerenciadorpeladas_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

3.	Execute a aplicação via Maven:
Bash
./mvnw spring-boot:run

________________________________________________________

📝 *Endpoints Principais*

Endpoint	Descrição

Método /Endpoint	Descrição

/liga |	Cria uma nova liga e vincula os times.

/time |	Cria e busca detalhes de um time e sua respectiva liga.

/estatisticas-jogador |	Registra a performance de um atleta.

/jogador |	Cria perfis de jogadores e vincula aos seus times.

/statsTime |	Registra a performance de um time.

________________________________________________________
👨‍💻 *Autor*

Guilherme Dos Anjos Silva Estudante de Análise e Desenvolvimento de Sistemas - SENAI.

Foco em Apis Rest(Java/Spring Boot).
________________________________________________________
