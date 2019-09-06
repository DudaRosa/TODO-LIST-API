# TODO-LIST-API
É um RESTFUL API simples que armazena e atualiza tarefas (TODO LIST API).

MongoDB: Banco de dados utilizado.

Postman: Ferramenta para executar a API.

Deploy Local pelo Eclipse
   - Para realizar o deploy local, é necessario ter instalado o Eclipse e MongoDB.
   - Eclipse:
      - Baixar o Projeto TODO-LIST-API
      - Configurar o Eclipse com o Maven.
      - Logo após é só executar.
      - O projeto está configurado para executar na porta 8080.
      
   - MongoDB:
      - Instalar o MongoBD
      - Executar o servidor local, o localhost é o 127.0.0.1 e a porta 27017.
      - O projeto já está configurado com o localhost e o nome do banco.  

Deploy pelo .war
  - Foi gerado um arquivo .was para rodar a aplicação, basta Starta o Tomcat ou Glassfish e rodar pelo localhost:8080
  
APIs utilizadas:
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
      - API: http://localhost:8080/api/task/getAll
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



















