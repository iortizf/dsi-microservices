#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "postgres" <<-EOSQL
    CREATE USER admin PASSWORD 'admin';
    CREATE DATABASE loan_dsi OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE loan_dsi TO admin;
    
    \c loan_dsi admin
    
    CREATE TABLE IF NOT EXISTS loan(
	  loan_id SERIAL PRIMARY KEY,
	  customer_id INT NOT NULL,
	  amount DECIMAL NOT NULL,  
	  installment INT NOT NULL,  
	  created_date DATE NOT NULL
	);
EOSQL