create database if not exists eazy_bank;

USE eazy_bank;

create table users(
                      id INT not null primary key auto_increment,
                      username varchar(50) not null,
                      password varchar(500) not null,
                      enabled boolean not null
);


create table authorities (
                             id INT not null primary key auto_increment,
                             userid INT not null,
                             authority varchar(50) not null,
                             constraint fk_authorities_users foreign key(userid) references users(id)
);
create unique index ix_auth_userid on authorities (userid,authority);

insert into users (username,password,enabled) values('root','root','1');

insert into  authorities (userid,authority) values(1,'write');

commit;