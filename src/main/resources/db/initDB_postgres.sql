DROP TABLE IF EXISTS orders_products;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS comments;
CREATE TABLE products (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL,
  price       NUMERIC(10, 2),
  color       INTEGER,
  capacity    INTEGER,
  display     TEXT,
  description TEXT
);


CREATE TABLE comments (
  id       SERIAL PRIMARY KEY,
  id_product INTEGER,
  author   TEXT NOT NULL ,
  dateTime TIMESTAMP NOT NULL ,
  text     TEXT NOT NULL ,
  rating   INTEGER NOT NULL

);

CREATE TABLE orders (
  id           SERIAL PRIMARY KEY,
  total_amount NUMERIC(10, 2) NOT NULL,
  name         TEXT           NOT NULL,
  email        TEXT           NOT NULL,
  phone        TEXT,
  address      TEXT           NOT NULL,
  date_time    TIMESTAMP      NOT NULL
);

CREATE TABLE orders_products (
  order_id   INTEGER NOT NULL,
  product_id INTEGER NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);
