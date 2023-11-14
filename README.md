### monitor-assets

This is a Ideal CTVM Code Challenge backend project.

Neste projeto estou utilizando o banco de dados em memória H2,
sua configuração pode ser visualizada em application.properties.
Foi criado uma migration 'V1__create-table-stock' para facilitar a criação da tabela;

------------------------------------------------------------------------------

### Build with
- JAVA
- SpringBoot
- JUnit

### Instalation

1. Get a Free API at https://iexcloud.io/documentation/reference/glossary.html#token-api-token
2. Clone the repository git clone https://github.com/your_username_/Project-Name.git
3. Download dependencies mvn clean install
4. Run project mvn spring-boot:run

### Routes:

#### GET /stock/{symbol]
Returns the parameterized ticker quote

{
  "symbol": "MSFT",
  "companyName": "Microsoft Corporation",
  "iexOpen": 368.01,
  "iexRealtimePrice": 366.6
}

#### POST /stock
Add the ticker to your watchlist

#### GET /stock
returns your watchlist with all added tickers



