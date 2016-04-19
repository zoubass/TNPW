USE[TNPW]
GO

create table TUser(
      id int IDENTITY(1,1) primary key,
      username nvarchar(50) not null,
      password nvarchar(50) not null,
      enabled bit not null);
	  create unique index ix_username on Tuser(username);

  create table TAuthority (
	  user_id int,
      authority nvarchar(50) not null,
      constraint fk_authorities_users foreign key(user_id) references TUser(username) on delete cascade);
      create unique index ix_auth_username on Tauthority(user_id,authority);
GO