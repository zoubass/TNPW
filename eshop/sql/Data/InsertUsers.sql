USE[TNPW]
GO
INSERT INTO TUser(username,password,enabled)VALUES('admin','admin',1)
INSERT INTO TAuthority(user_id, authority)VALUES(1,'ROLE_SUPER_ADMIN')
GO
