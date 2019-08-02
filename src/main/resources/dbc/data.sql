drop table if exists chargers;
create table chargers(
    id int auto_increment primary key,
    name varchar (100) not null
    );
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (1,'Cracow','ul.Josepha Conrada 66','IKEA','ok','VCS','image','24h');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (2,'Cracow','ul.Jasnogórska 60','Nisssan','only for customers Nissan','VCS','image','9am-6pm');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (3,'Cracow','ul.Łagiewniki','Electric vehicle charging station','next to the tram loop','VCS','image','24h');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (4,'Cracow','Aleja Ignacego Daszyńskiego 32','EV Charging Outlet, Blue Parking F5','open to close the gallery','EV','image','10am-9pm');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (5,'Cracow','Aleja Pokoju 67','GO + EAuto Charging station for electric cars','gallery M1','VCS','image','24h');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (6,'Cracow','ul.profesora Adama Rożańskiego 32','GreenWay Polska Factory Kraków','gallery Factory','VCS','image','24h');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (7,'Cracow','ul.Praska','GO+EAuto','parking','VCS','image','24h');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (8,'Cracow','ul.Stanisława Stojałowskiego 12','GreenWay Polska','private,for customers','VCS','image','private');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (9,'Cracow','ul.Tadeusza Kościuszki 49','AB City Tour Melexy Cracow','phone','VCS','image','7am-8pm');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (9,'Cracow','ul.Siewna 13','GO+EAuto','phone','CCS,CHAdeMO, Type-2','image','24h');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (9,'Cracow','ul.Stawowa 61','GreenWay Polska','no','VCS','image','24h');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (9,'Cracow','Aleja Jana Pawła II','GreenWay Polska Podium Park','phone 58 325 10 77','VCS','image','???');
    insert into chargers(id,city,address,place_name,place_info,charger_type,image,opening_hours)
    values (9,'Zielonki','unnamed','GreenWay Polska','phone','EV','image','24h');
--     insert into chargers(id,city,place_name,place_info) values (2,'Wrocław','cc','bb');
--     insert into chargers(id,city,place_name,place_info) values (3,'Opole','cc','bb');
--     insert into chargers(id,city,place_name,place_info) values (4,'Legnica','cc','bb');
--     insert into chargers(id,city,place_name,place_info) values (5,'Rzeszow','cc','bb');
--     insert into chargers(id,city,place_name,place_info) values (6,'Jastarnia','cc','bb');
--     insert into chargers(id,city,place_name,place_info) values (7,'Skawina','cc','bb');
--     insert into chargers(id,city,place_name,place_info) values (8,'Lubomierz','cc','bb');

