# Projeto-peladas

## 🚀 Começando

Na primeira execução do projeto no Tomcat ir no browser e colocar http://localhost:8080/projeto-peladas/login.xhtml assim a tela de login será apresentada, mas lembre-se terá que criar o banco no postgresql com o nome peladas e ir no persistence.xml e alterar a senha do banco e a propriedade property name="hibernate.hbm2ddl.auto" value="update" para value="create", só assim serão criadas as tabelas no banco e logo em seguida para que seja feito o login criar um usuário na tabela usuario no postgresql.

### 🔧 Instalação

Assim que baixar o projeto do github ir no Eclipse e importar Existing projects into Workspace, assim o projeto será importado e execute a parte do backEnd, depois execute no Visual Studio Code a parte do FrontEnd com o comando npm run serve.

## 🛠️ Versões do Ambiente
* [Java14]
* [Spring Boot 2.4.5]
* [VUEJS]
* [PostgreSQL 13]
