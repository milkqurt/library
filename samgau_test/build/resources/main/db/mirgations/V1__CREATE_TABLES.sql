create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE student(
    id BIGINT NOT NULL AUTO_INCREMENT,
    username varchar(64) not null unique,
    password varchar(64) not null,
    group varchar(64) not null,
    PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE book(
    id BIGINT NOT NULL AUTO_INCREMENT,
    title varchar(64) not null,
    author varchar(64) not null,
    price double not null,
    genre varchar(64) not null,
    status BOOLEAN NOT NULL,
    PRIMARY KEY (id)
) engine=MyISAM;
