### monitor-assets

This project serves as the backend for the Ideal CTVM Code Challenge. It utilizes the H2 in-memory database, and its configuration can be found in the application.properties file. Additionally, a migration script named 'V1__create-table-stock' has been created to streamline the table creation process.

------------------------------------------------------------------------------

### Build with
- JAVA
- SpringBoot
- JUnit

### Instalation

1. Obtain a free API key from IEX Cloud.
2. Clone the repository: https://github.com/IanFirmino/monitor-assets
3. Download dependencies: mvn clean install
4. Run the project: mvn spring-boot:run

### Routes:

#### GET /stock/{symbol]
Returns the parameterized ticker quote.

#### POST /stock
Add the ticker to your watchlist.

#### GET /stock
returns your watchlist with all added tickers.



