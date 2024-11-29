CREATE DATABASE tech_support_classwork_database;

USE tech_support_classwork_database;


CREATE TABLE user(
    user_id INT NOT NULL AUTO_INCREMENT,
    user_username VARCHAR(50) NOT NULL,
    user_name VARCHAR(30) NOT NULL,
    user_surname VARCHAR(30) NOT NULL,
    user_email VARCHAR(255) NOT NULL, 
    fiscal_code CHAR(16) NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    registration_date TIMESTAMP NOT NULL,
    last_login TIMESTAMP NULL,
    customer_id INT NULL,
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    admin_role BIT NOT NULL,
    PRIMARY KEY(user_id),
    UNIQUE(user_email,fiscal_code, user_username)
)


CREATE TABLE customer(
    customer_id INT NOT NULL AUTO_INCREMENT,
    company_name VARCHAR(255) NOT NULL,
    vat_number CHAR(11) NOT NULL,
    PRIMARY KEY(customer_id),
    UNIQUE(vat_number)
)

CREATE TABLE ticket_status_type(
    type_id INT NOT NULL AUTO_INCREMENT,
    status_name VARCHAR(30) NOT NULL,
    PRIMARY KEY(type_id),
    UNIQUE(status_name)
)

CREATE TABLE ticket(
    ticket_id INT NOT NULL AUTO_INCREMENT,
    ticket_code CHAR(12) NOT NULL,
    ticket_customer INT NOT NULL,
    FOREIGN KEY(ticket_customer) REFERENCES customer(customer_id) ON UPDATE CASCADE ON DELETE CASCADE,
    ticket_name VARCHAR(30) NOT NULL,
    ticket_description VARCHAR(255) NOT NULL,
    ticket_issue_date TIMESTAMP NOT NULL,
    PRIMARY KEY(ticket_id),
    UNIQUE(ticket_code)
)

CREATE TABLE ticket_status(
    ticket_id INT NOT NULL,
    FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id) ON UPDATE CASCADE ON DELETE CASCADE,
    status_type INT NOT NULL,
    FOREIGN KEY(status_type) REFERENCES ticket_status_type(type_id) ON UPDATE CASCADE ON DELETE CASCADE,
    status_date TIMESTAMP NOT NULL,
    PRIMARY KEY(ticket_id, status_type)
)

CREATE TABLE ticket_resolution(

    resolution_id INT NOT NULL AUTO_INCREMENT,
    ticket_id INT NOT NULL,
    FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id) ON UPDATE CASCADE ON DELETE CASCADE,
    resolution_note VARCHAR(255) NOT NULL,
    note_date TIMESTAMP NOT NULL,
    note_author INT NOT NULL,
    FOREIGN KEY(note_author) REFERENCES user(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY(resolution_id)

)
