INSERT INTO time_slot (id, start_date, end_date) VALUES  (1, CURRENT_TIMESTAMP, DATEADD('HOUR', 1, CURRENT_TIMESTAMP));
INSERT INTO time_slot (id, start_date, end_date) VALUES ( 2,DATEADD('HOUR', 1, CURRENT_TIMESTAMP),DATEADD('HOUR', 2, CURRENT_TIMESTAMP));
INSERT INTO time_slot (id, start_date, end_date) VALUES ( 3,DATEADD('HOUR', -1, CURRENT_TIMESTAMP),CURRENT_TIMESTAMP );
INSERT INTO delivery_slot (client_name, client_phone, delivery_mode, time_slot_id, available) VALUES ('John Doe', '123-456-7890', 'DELIVERY_TODAY', 1, true);
INSERT INTO delivery_slot (client_name, client_phone, delivery_mode, time_slot_id, available)  VALUES ('Elsa Albert', '123-456-7890', 'DRIVE', 2, true);
INSERT INTO delivery_slot (client_name, client_phone, delivery_mode, time_slot_id, available)  VALUES ('Elsa Albert', '123-456-7890', 'DELIVERY', 3, false);