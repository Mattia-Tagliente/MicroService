CREATE DATABASE fake_thcs;

USE fake_thcs;


CREATE TABLE user(
    user_id INT NOT NULL AUTO_INCREMENT,
    user_username VARCHAR(50) NOT NULL,
    user_name VARCHAR(30) NOT NULL,
    user_surname VARCHAR(30) NOT NULL,
    user_email VARCHAR(255) NOT NULL, 
    codice_fiscale CHAR(16) NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    registration_date TIMESTAMP NOT NULL,
    last_login TIMESTAMP NOT NULL,
    customer_id INT NULL,
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    admin_role BIT NOT NULL,
    PRIMARY KEY(user_id),
    UNIQUE(user_email,codice_fiscale, user_username)
)


CREATE TABLE customer(
    customer_id INT NOT NULL AUTO_INCREMENT,
    denominazione_sociale VARCHAR(255) NOT NULL,
    partita_iva CHAR(11) NOT NULL,
    PRIMARY KEY(customer_id),
    UNIQUE(partita_iva)
)

/*This table stores the types of tasks (es. creating a new feature, debugging an existent one etc.*/
CREATE TABLE task_type(
    task_id  INT NOT NULL AUTO_INCREMENT,
    type_name VARCHAR(30) NOT NULL,
    PRIMARY KEY(task_id)
)

CREATE TABLE ticket_status_type(
    type_id INT NOT NULL AUTO_INCREMENT,
    status_name VARCHAR(30) NOT NULL,
    PRIMARY KEY(type_id)
)

CREATE TABLE ticket(
    ticket_id INT NOT NULL AUTO_INCREMENT,
    ticket_code CHAR(12) NOT NULL,
    ticket_customer INT NOT NULL,
    FOREIGN KEY(ticket_customer) REFERENCES customer(customer_id),
    ticket_name VARCHAR(30) NOT NULL,
    ticket_description VARCHAR(255) NOT NULL,
    PRIMARY KEY(ticket_id),
    UNIQUE(ticket_code)
)

CREATE TABLE ticket_status(
    ticket_id INT NOT NULL,
    FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id),
    status_type INT NOT NULL,
    FOREIGN KEY(status_type) REFERENCES ticket_status_type(type_id),
    status_date TIMESTAMP NOT NULL,
    PRIMARY KEY(ticket_id, status_type)
)

CREATE TABLE ticket_resolution(

    resolution_id INT NOT NULL AUTO_INCREMENT,
    ticket_id INT NOT NULL,
    FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id),
    task_type INT NOT,
    FOREIGN KEY(task_type) REFERENCES task_type(task_id),
    resolution_post VARCHAR(255) NOT NULL,
    post_date TIMESTAMP NOT NULL,
    admin_name VARCHAR(30) NOT NULL,
    admin_surname VARCHAR(30) NOT NULL,
    admin_email VARCHAR(30) NOT NULL,
    PRIMARY KEY(resolution_id)

)
