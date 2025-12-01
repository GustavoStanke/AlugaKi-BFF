# AlugaKi BFF

Gateway BFF em Spring Boot 3 que expõe endpoints REST simplificados para o frontend e os encaminha para a API principal do AlugaKi.

## Tecnologias
- Java 17
- Spring Boot 3.5.6 (web + RestTemplate)
- Maven

## Pré-requisitos
- Java 17+
- Maven 3.6+
- API principal em execução (padrão em `http://localhost:8080`)

## Configuração
Edite `src/main/resources/application.properties` conforme necessário:
```properties
server.port=8081
api.usuario.url=http://localhost:8080/usuario
api.endereco.url=http://localhost:8080/enderecos
api.produto.url=http://localhost:8080/produto
api.periodo.url=http://localhost:8080/periodo
api.aluguel.url=http://localhost:8080/aluguel
api.statusaluguel.url=http://localhost:8080/statusaluguel
```

## Executando
- `mvn spring-boot:run`
- ou rodar a classe `AlugAkiBffApplication` pela IDE.

## Estrutura
```
src/main/java/com/AlugAKI_BFF/AlugAKI_BFF
  config/       # Beans (RestTemplate)
  Controler/    # Endpoints BFF
  Service/      # Chamadas HTTP à API principal
  Model/        # DTOs usados pelo BFF
src/main/resources
  application.properties
```

## Endpoints BFF (porta 8081 por padrão)

### Usuario
- GET `/bff/usuario`
- GET `/bff/usuario/{id}`
- POST `/bff/usuario`
- PUT `/bff/usuario/{id}`
- DELETE `/bff/usuario/{id}`
- POST `/bff/usuario/login`
- POST `/bff/usuario/redefinir-senha`

### Produto
- GET `/bff/produto`
- GET `/bff/produto/{id}`
- POST `/bff/produto`
- PUT `/bff/produto/{id}`

### Periodo
- GET `/bff/periodo`
- GET `/bff/periodo/{id}`

### StatusAluguel
- GET `/bff/statusaluguel`
- GET `/bff/statusaluguel/{id}`

### Endereco
- GET `/bff/enderecos`
- GET `/bff/enderecos/{id}`
- POST `/bff/enderecos`
- PUT `/bff/enderecos/{id}`
- DELETE `/bff/enderecos/{id}`

### Aluguel
- GET `/bff/aluguel`
- GET `/bff/aluguel/{id}`
- GET `/bff/aluguel/status/{statusId}`
- POST `/bff/aluguel`
- PUT `/bff/aluguel/{id}`
- DELETE `/bff/aluguel/{id}`
- POST `/bff/aluguel/{id}/alugar`
- POST `/bff/aluguel/{id}/confirmar`
