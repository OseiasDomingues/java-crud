create database agenda;

create table contacts(
    id int not null auto_increment primary key,
    name varchar(40),
    age int,
    dateRegister date
)