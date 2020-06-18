INSERT INTO users (email, password) VALUES ('testing@email.com', '123');

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (0,'a log','log','somewhere','2020-06-12 14:00','2020-06-12 14:00',1);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (1,'new log','log','someplace','2020-06-11 00:00','2020-06-11 00:00',5);

INSERT INTO logs (log_level, description, log_event, origin, created_at, updated_at, event_number)
    VALUES (2,'another log','log','nowhere','2020-06-11 22:00','2020-06-11 22:00',4);