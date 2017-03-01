--schema sql

DROP TABLE USERS IF EXISTS RESTRICT;

CREATE TABLE USERS (
  userId         INTEGER IDENTITY PRIMARY KEY,
  userName VARCHAR(30),
  passWord VARCHAR(255),
  userLastname VARCHAR(30),
  email VARCHAR(30),

  description VARCHAR(255),

  role VARCHAR(30),

  isActivated BOOLEAN,
  isAdmin BOOLEAN
);

CREATE INDEX users_username ON users (userName);

INSERT INTO USER (USERID, USERNAME, PASSWORD, USERLASTNAME, EMAIL, DESCRIPTION, ROLE, ISACTIVATED, ISADMIN) VALUES (1, 'test',  'Иван', 'correct', 'Иванов', null, null, "ADMIN", true, true);