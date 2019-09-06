# TODO-LIST-API
É um RESTFUL API simples que armazena e atualiza tarefas (TODO LIST API).

Deploy Local pelo Eclipse
   - Para realizar o deploy local, é necessário ter instalado o Eclipse e MongoDB.
   - Eclipse:
      - Baixar o Projeto TODO-LIST-API
      - Configurar o Eclipse com o Maven.
      - Logo após é só executar.
      - O projeto está configurado para executar na porta 8080.
      
   - MongoDB:
      - Instalar o MongoBD
      - Executar o servidor local, o localhost é o 127.0.0.1 e a porta 27017.
      - O projeto já está configurado com o localhost e o nome do banco.  
      - Configuração:
            - MONGODB_HOST:127.0.0.1
            - MONGODB_PORT:27017
            - MONGODB_DATABASE:list-api-itau

Deploy Local pelo .war
  - Foi gerado um arquivo .was para rodar a aplicação, basta executar o Tomcat ou Glassfish e rodar pelo localhost:8080
  
APIs utilizadas:Testes realizado pelo Postman 
- POST:
   - API: http://localhost:8080/todo/task
   - Para inserir, deve conter o campo name e status
   - OBS: Não colocar o id, pois é gerado automático.
   - EX:
      {
        "name": "Boletos",
        "status": "completed"
      }
      
- PUT:  
   - API: http://localhost:8080/todo/task/{{colocar o id da tarefa}}
   - OBS: Colocar o id.
   - EX:
       {
        "id": "5d7120d979850e39a8667b1d",
        "name": " Teste Boletos",
        "status": "completed"
       }
- DELETE: 
   - API: http://localhost:8080/todo/task/{{colocar o id da tarefa}}
   - Api só precisa do id para excluir no Banco.
   - EX:
   http://localhost:8080/todo/task/5d7120d979850e39a8667b1d

- GET: 
  - Get ALL:
      - API: http://localhost:8080/todo/task/getAll
      - Irá retornar uma lista de Tarefas. 
      
      - Ex: 
      [
         {
           "id": "5d7120d979850e39a8667b1d",
           "name": "Boletos",
            "status": "completed"
         },
         {
           "id": "5d710f1379850e3e24e29d2d",
           "name": "Cartão de Credito",
           "status": "pending"
         },
         {
           "id": "5d6d7abd1f802d2634451ef2",
            "name": "Seguros",
            "status": "pending"
         }
      ]

  - GET por ID:
      - API: http://localhost:8080/todo/task/{{colocar o id da tarefa}}
      - Retorna apenas as informações do Id informado.
      
      - Ex: http://localhost:8080/todo/task/5d7120d979850e39a8667b1d
       Retorno: 
       {
          "id": "5d7120d979850e39a8667b1d",
          "name": "Boletos",
          "status": "completed"
       }

----------------------------------------------------------------------------
APIs utilizadas:Testes realizado pelo CURL
   - Para realizar os testes, basta abrir o git bash.
   
- POST:
   - Comando CURL: curl -i -X POST -H "Content-Type: application/json" -d "{{Json que vai ser cadastrado}}" http://localhost:8080/todo/task
   - EX: curl -i -X POST -H "Content-Type: application/json" -d "{\"name\":\"Banco Itau\", \"status\":\"pending\"}" http://localhost:8080/todo/task
   - Retorno: % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   113    0    72  100    41    176    100 --:--:-- --:--:-- --:--:--   277HTTP/1.1 200
vary: accept-encoding
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Fri, 06 Sep 2019 13:54:25 GMT

{"id":"5d7265114ecbe11888bb1cc8","name":"Banco Itau","status":"pending"}
      
- PUT:  
    - Comando CURL: curl -i -X PUT -H "Content-Type: application/json" -d "{{Colocar o json com as modificações da tarefa}}" http://localhost:8080/todo/task/{{colocar o id da tarefa}}
    - EX: curl -i -X PUT -H "Content-Type: application/json" -d "{\"id\":\"5d7265114ecbe11888bb1cc8\",\"name\":\"Banco Itau Seguros\", \"status\":\"pending\"}" http://localhost:8080/todo/task/5d7265114ecbe11888bb1cc8
    - Retorno:  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   161    0    80  100    81   5000   5062 --:--:-- --:--:-- --:--:-- 10062HTTP/1.1 200
vary: accept-encoding
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Fri, 06 Sep 2019 14:03:16 GMT

{"id":"5d7265114ecbe11888bb1cc8","name":"Banco Itau Seguros","status":"pending"}
    
- DELETE: 
  - Comando CURL: curl -i -X DELETE http://localhost:8080/todo/task/{{colocar o id da tarefa}}
  - EX: curl -i -X DELETE http://localhost:8080/todo/task/5d7265114ecbe11888bb1cc8 
  - Retorno: % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0HTTP/1.1 204
Date: Fri, 06 Sep 2019 14:14:04 GMT


- GET ALL: 
  - Comando CURL: curl http://localhost:8080/todo/task/getAll
  - Retorno:  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   152    0   152    0     0    156      0 --:--:-- --:--:-- --:--:--   156[{"id":"5d710f1379850e3e24e29d2d","name":"Cartão de Credito","status":"pending"},{"id":"5d6d7abd1f802d2634451ef2","name":"Seguros","status":"pending"}]

  - GET por ID:
     - Comando CURL: curl http://localhost:8080/todo/task/{{colocar o id da tarefa}}
     - EX: curl http://localhost:8080/todo/task/5d710f1379850e3e24e29d2d
     - Retorno:  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    80    0    80    0     0    131      0 --:--:-- --:--:-- --:--:--   131{"id":"5d710f1379850e3e24e29d2d","name":"Cartão de Credito","status":"pending"}




















