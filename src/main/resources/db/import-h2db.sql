--H2DB
insert into users(id, login, pass , last_password_reset, authorities, firstname, lastname) values(users_seq.nextval, 'test', '$2a$10$YUdjZbQuRNx2/hMAYbosG.WYHTOIjtu4K6zg7CwV.tlJZW13BduVe', null, 'ADMIN, USER', 'User’s first name', 'User’s last name');
insert into users(id, login, pass , last_password_reset, authorities) values(users_seq.nextval, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', null, 'USER');
insert into users(id, login, pass , last_password_reset, authorities) values(users_seq.nextval, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', null, 'ADMIN, ROOT');
insert into users(id, login, pass , last_password_reset, authorities) values(users_seq.nextval, 'expired', '$2a$10$PZ.A0IuNG958aHnKDzILyeD9k44EOi1Ny0VlAn.ygrGcgmVcg8PRK', parsedatetime('01-JAN-2050','dd-MMM-yyyy'), 'USER');
