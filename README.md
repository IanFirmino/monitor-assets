### monitor-assets

------------------------------------------------------------------------------

### Build with
- JAVA
- SpringBoot
  
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



