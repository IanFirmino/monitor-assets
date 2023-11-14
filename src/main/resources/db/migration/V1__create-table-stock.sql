CREATE TABLE IF NOT EXISTS Stock (
    id INT AUTO_INCREMENT PRIMARY KEY,
    symbol VARCHAR(MAX),
    iex_realtime_price FLOAT
);