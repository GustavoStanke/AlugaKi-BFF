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
Edite `src/main/resources/application.properties` conforme necessário (valores padrão do projeto):
```properties
server.port=8081
api.usuario.url=http://localhost:8080/usuario
api.endereco.url=http://localhost:8080/enderecos
api.produto.url=http://localhost:8080/produto
api.periodo.url=http://localhost:8080/periodo
api.aluguel.url=http://localhost:8080/aluguel
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

## Endpoints BFF
Todos respondem em `http://localhost:8081` (porta configurável via `server.port`).

### Usuario
- GET `/bff/usuario` — lista usuários.
- GET `/bff/usuario/{id}` — busca por ID.
- POST `/bff/usuario` — cria usuário.
- PUT `/bff/usuario/{id}` — atualiza usuário.
- DELETE `/bff/usuario/{id}` — remove usuário.

### Produto
- GET `/bff/produto` — lista produtos.
- GET `/bff/produto/{id}` — busca por ID.
- POST `/bff/produto` — cria produto.

### Periodo
- GET `/bff/periodo` — lista períodos.
- GET `/bff/periodo/{id}` — busca por ID.

### Endereco
- GET `/bff/enderecos` — lista endereços.
- GET `/bff/enderecos/{id}` — busca por ID.
- POST `/bff/enderecos` — cria endereço.
- PUT `/bff/enderecos/{id}` — atualiza endereço.
- DELETE `/bff/enderecos/{id}` — remove endereço.

### Aluguel
- GET `/bff/aluguel` — lista aluguéis.
- GET `/bff/aluguel/{id}` — busca por ID.
- GET `/bff/aluguel/status/{statusId}` — lista aluguéis por status.
- POST `/bff/aluguel` — cria aluguel.
- PUT `/bff/aluguel/{id}` — atualiza aluguel.
- DELETE `/bff/aluguel/{id}` — remove aluguel.
- POST `/bff/aluguel/{id}/alugar` — marca como alugado (status 3) e atribui locatário. Body: `{"usuarioIdUsuario": <id>}`.
