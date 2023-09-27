-- Users Table

INSERT INTO users (id, name, surname1, surname2, email, phone_number, nif, nickname, status, entry_date, password)
VALUES
(nextval('sq_users'), 'Pepe', 'González', 'Pérez', 'pepe@axpe.es', '+34689456123', '123456789J', 'admin', 'ACTIVO', CURRENT_TIMESTAMP, '$2a$10$FRDQgZ83i4/E7Edw6cijIu6lRxiBv5GJu5wD8CiRWC19kYTJLMBRe');

INSERT INTO users (id, name, surname1, surname2, email, phone_number, nif, nickname, status, entry_date, password)
VALUES
(nextval('sq_users'), 'Sandra', 'Guzman', 'Herrera', 'sandra@axpe.es', NULL, '223456789J', 'sandra', 'ACTIVO', CURRENT_TIMESTAMP, '$2a$10$FRDQgZ83i4/E7Edw6cijIu6lRxiBv5GJu5wD8CiRWC19kYTJLMBRe');

INSERT INTO users (id, name, surname1, surname2, email, phone_number, nif, nickname, status, entry_date, password)
VALUES
(nextval('sq_users'), 'Antonio', 'Losada', 'Hernández', 'antonio@axpe.es', '+34689456153', '323456789J', 'antonio', 'ACTIVO', CURRENT_TIMESTAMP, '$2a$10$FRDQgZ83i4/E7Edw6cijIu6lRxiBv5GJu5wD8CiRWC19kYTJLMBRe');

INSERT INTO users (id, name, surname1, surname2, email, phone_number, nif, nickname, status, entry_date, password)
VALUES
(nextval('sq_users'), 'Sara', 'Bonilla', 'Cuadrado', 'sara@axpe.es', '+34689456126', '423456789J', 'sara', 'ACTIVO', CURRENT_TIMESTAMP, '$2a$10$FRDQgZ83i4/E7Edw6cijIu6lRxiBv5GJu5wD8CiRWC19kYTJLMBRe');    


-- Books Table

INSERT INTO books(id_books, name, description, author, category, entry_date)
VALUES
(nextval('sq_books'), 'Brandon Sanderson Saga 1', 'Libros mu raros largos y muchos', 'Brandon Sanderson', 'Fantasia', CURRENT_TIMESTAMP);

INSERT INTO books(id_books, name, description, author, category, entry_date)
VALUES
(nextval('sq_books'), 'Brandon Sanderson Saga 2', 'Libros mu raros largos y muchos', 'Brandon Sanderson', 'Fantasia', CURRENT_TIMESTAMP);

INSERT INTO books(id_books, name, description, author, category, entry_date)
VALUES
(nextval('sq_books'), 'Brandon Sanderson Saga 3', 'Libros mu raros largos y muchos', 'Brandon Sanderson', 'Fantasia', CURRENT_TIMESTAMP);

INSERT INTO books(id_books, name, description, author, category, entry_date)
VALUES
(nextval('sq_books'), 'Stepehen Curren', 'Libros criosos', 'Maikol Stepen', 'Accion', CURRENT_TIMESTAMP);

INSERT INTO books(id_books, name, description, author, category, entry_date)
VALUES
(nextval('sq_books'), 'Cuando fui a por trabajo', 'Explica la historia de un parado', 'Pedro Sanchez', 'Realidad', CURRENT_TIMESTAMP);