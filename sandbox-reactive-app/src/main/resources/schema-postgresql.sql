create table if not exists customer(
id SERIAL PRIMARY KEY,
first_name varchar(64) NOT NULL,
age int not null
);
