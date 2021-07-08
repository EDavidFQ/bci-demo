DROP TABLE IF EXISTS users;

CREATE TABLE users(
  id uuid default random_uuid() PRIMARY KEY,
  name varchar(50) not null,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  created date NOT NULL,
  modified date,
  last_login date,
  token varchar(50),
  active boolean
);

DROP TABLE IF EXISTS phones;

CREATE TABLE phones(
   id INT AUTO_INCREMENT  PRIMARY KEY,
   user_id uuid NOT NULL,
   number VARCHAR(15) NOT NULL,
   city_code VARCHAR(5) NOT NULL,
   country_code VARCHAR(5) NOT NULL
);