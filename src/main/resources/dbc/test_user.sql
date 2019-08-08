insert into user(id,active,password,user_name)
values (1,1,'$2a$10$Uvv0E3rlFVjYq5RUfQcp4eTtYOW/uc7mJctT44lNPlu0k31UawmbW','user');
insert into role(role_id,role)values (1,'ADMIN' );
insert into role(role_id,role)values (2,'USER' );
insert into role(role_id,role)values (3,'GUEST' );

insert into user_role(user_id,role_id)values (1,1);
insert into user_role(user_id,role_id)values (1,2);
insert into user_role(user_id,role_id)values (1,3);