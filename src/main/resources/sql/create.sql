DROP TABLE  IF EXISTS USERS RESTRICT;

CREATE TABLE USERS (
  userId         INTEGER  PRIMARY KEY,
  userName VARCHAR(30),
  passWord VARCHAR(255),
  userLastname VARCHAR(30),
  email VARCHAR(30),

  description VARCHAR(255),

  userRole VARCHAR(30),

  isActivated BOOLEAN,
  isAdmin BOOLEAN
);

CREATE INDEX users_username ON users (userName);

INSERT INTO USERS (USERID, USERNAME, PASSWORD, USERLASTNAME, EMAIL, DESCRIPTION, USERROLE, ISACTIVATED, ISADMIN) VALUES (1,      'test',   'correct','Иванов',     null,  null,        'ADMIN', true, true);