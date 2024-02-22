# Projeto teste_pratico

### Frontend

Para iniciar o frontend, execute o seguinte comando:

npm start

para inciar o backend rodar o seguinte comando de depuração

./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=*:8000"

##Caminho da database

ao rodar o comando em cima o hibernate cria um schema da database mas caso precise aqui está o caminho da database 

feito em postgres

java/
└── com/
 └── teste/
   └── demo/
    └── Data/ 
      └── database.sql

##Collections 

java/
└── com/
 └── teste/
   └── demo/
    └── Data/ 
      └── Collections/

## Acompanhamento

### Backend

- [x] Config Spring Boot / Maven
- [x] Config versões variável de ambiente
- [x] Definir estrutura Controladores
- [x] Definir estrutura Entidades
- [x] Definir Estrutura Helpers
- [x] Definir estrutura Repo
- [x] Definir estrutura Services
- [x] String connections/cors
- [x] Mappers
- [x] Testes
- [x] Refatoração

### Frontend

- [x] Componentização
- [x] Implementação Estrutura de pastas
- [x] Estilização
- [x] String connections
- [x] Refresh page/callbacks(gridview)
- [x] Batch files
- [x] Download Conteúdo
- [x] Refatoração
