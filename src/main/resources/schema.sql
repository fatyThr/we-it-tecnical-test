CREATE SCHEMA IF NOT EXISTS testdb;

SET SCHEMA testdb;

CREATE TABLE IF NOT EXISTS time_slot
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS delivery_slot
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR (255),
    client_phone VARCHAR (20),
    delivery_mode VARCHAR (20),
    time_slot_id INT,
    available BOOLEAN,
    FOREIGN KEY (time_slot_id) REFERENCES time_slot (id)
    );
