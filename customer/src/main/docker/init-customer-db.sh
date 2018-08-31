#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "postgres" <<-EOSQL
    CREATE USER admin PASSWORD 'admin';
    CREATE DATABASE customer_dsi OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE customer_dsi TO admin;
    
    \c customer_dsi admin
    
    CREATE TABLE IF NOT EXISTS customer(
	  id SERIAL PRIMARY KEY,
	  name VARCHAR(255) NOT NULL,
	  apaterno VARCHAR(100) NOT NULL,
	  amaterno VARCHAR(100),
	  email VARCHAR(100) NOT NULL,
	  password VARCHAR(100) NOT NULL,
	  status BOOLEAN NOT NULL,
	  created_date DATE NOT NULL
	);
EOSQL