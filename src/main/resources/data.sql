drop table if exists chargers;
create table chargers(
    id int auto_increment primary key,
    name varchar (20) not null
    );
    insert into chargers(name) values ( 'Orlen');
    insert into chargers(name) values ( 'Nissan');
    insert into chargers(name) values ( 'Podgorska');
