INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10001,  'Mehedi', 'Bangladesh', CURRENT_DATE);
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10002,  'James', 'New York',CURRENT_DATE);
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10003,  'Pieter', 'Amsterdam',CURRENT_DATE);

insert into course(id, name, created_date, last_updated_date)
values(10001,'Learn JPA', CURRENT_DATE, CURRENT_DATE);
insert into course(id, name, created_date, last_updated_date)
values(10002,'Learn Spring', CURRENT_DATE, CURRENT_DATE);
insert into course(id, name, created_date, last_updated_date)
values(10003,'Learn Spring Boot', CURRENT_DATE, CURRENT_DATE);

insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Mehedi',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);
--
insert into review(id,rating,description, course_id)
values(50001,'5', 'Great Course', 10001);
insert into review(id,rating,description, course_id)
values(50002,'4', 'Wonderful Course', 10001);
insert into review(id,rating,description, course_id)
values(50003,'5', 'Awesome Course', 10001);