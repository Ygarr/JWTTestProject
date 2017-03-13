--PostgreSQL

-- DROP TABLE  IF EXISTS USERS RESTRICT;

-- CREATE TABLE USERS (
--   id         INTEGER  PRIMARY KEY,
--   login VARCHAR(30),
--   pass VARCHAR(255),
--   ...
-- );

CREATE INDEX users_username ON users (login);

INSERT INTO USERS (login, pass, authorities, firstname, lastname) VALUES ('test', '$2a$10$YUdjZbQuRNx2/hMAYbosG.WYHTOIjtu4K6zg7CwV.tlJZW13BduVe', 'ADMIN, USER', 'User’s first name', 'User’s last name');