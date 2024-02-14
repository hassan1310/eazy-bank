create database if not exists eazy_bank;

USE eazy_bank;

create table if not exists users
(
    id       INT          not null primary key auto_increment,
    username varchar(50)  not null,
    password varchar(500) not null,
    enabled  boolean      not null
);


create table if not exists authorities
(
    id        INT         not null primary key auto_increment,
    username  varchar(50) not null,
    authority varchar(50) not null
);

insert into users (username, password, enabled)
values ('root', 'test', '1');

insert into authorities (username, authority)
values ('root', 'write');


create table if not exists clients
(
    id       INT          not null primary key auto_increment,
    name     varchar(50)  not null,
    email    varchar(50)  not null,
    password varchar(500) not null,
    role     varchar(50)  not null,
    enabled  boolean      not null
);

insert into clients (name, email, password, role, enabled)
values ('hassan', 'h.gamal@gmail.com', '12345', 'admin', 1);

commit;