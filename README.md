# com.envixo.products
Envixo Products API

### Reference Documentation
O projeto consiste numa REST API contendo os CRUDs de Categorias, Produtos e Tags.
Os CRUDs podem ser acessados por meio do plugin swagger-ui.

Está disponível no GitHub, no repositório https://github.com/pedrovgo/com.envixo.products

O respositório está sincronizado com o CI/CD do Heroku, 
e a função de deploy automátio está habilitada.
A aplicação pode ser acessada pelo endereço https://envixo-products.herokuapp.com/swagger-ui/#/

Para rodar a aplicação localmente basta rodar o médoto main da classe ProductsApplication
como uma aplicação Java.

<br>

#### TO DOs

- Implementar a integração com um servidor de arquivos.
- Melhorar o tratamento de exceções criando um arquivo de códigos e mensagens,
evitando que mensagens internas sejam retornadas nas requições e assim expondo vulnerabilidades da aplicação.
- Implementar testes unitários.
