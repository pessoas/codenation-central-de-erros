INSERT INTO users (email, password) VALUES ('testing@email.com', '123');

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (0,'internal server error','unknown error','server','2020-06-12 14:00','2020-06-12 14:00',1);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (1,'not found','not in database','client','2020-06-13 00:00','2020-06-15 07:23',5);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (2,'request successful','ok','server','2020-06-14 18:30','2020-06-14 22:01',4);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (2,'added to db','created','server','2020-06-14 18:30','2020-06-14 22:01',10);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (0,'server not reachable','unknown','not found','2020-06-14 18:30','2020-06-14 22:01',2);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (1,'avoid using deprecated','deprecated','client','2020-06-14 18:30','2020-06-14 22:01',50);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (0,'something occurred','unexpected','client','2020-06-14 18:30','2020-06-14 22:01',1);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (1,'no longer available','redirect','client','2020-06-14 18:30','2020-06-14 22:01',13);