----------------------CITY-------------------------

Insert into city values(SYSDATETIME(),SYSDATETIME(),'C1');
Insert into city values(SYSDATETIME(),SYSDATETIME(),'C2');

----------------------Theater-------------------------

Insert into Theater values(SYSDATETIME(),SYSDATETIME(),'A2','T2', 3);
Insert into Theater values(SYSDATETIME(),SYSDATETIME(),'A2','T2', 3);
------------------------------------------------------------------


select * from auditorium;
Insert into Auditorium(name,capacity,theater_id,created_at,updated_at) values('A1',200,1,SYSDATETIME(),SYSDATETIME());
Insert into Auditorium(name,capacity,theater_id,created_at,updated_at) values('A2',150,1,SYSDATETIME(),SYSDATETIME());
Insert into Auditorium(name,capacity,theater_id,created_at,updated_at) values('A3',180,2,SYSDATETIME(),SYSDATETIME());
-------------------------------------------

select * from seat;
alter table seat drop column is_booked;

Insert into seat(seat_number,row_no,column_no,seat_type,auditorium_id,created_at,updated_at)
values('S1',1,1,1,2,SYSDATETIME(),SYSDATETIME());

Insert into seat(seat_number,row_no,column_no,seat_type,auditorium_id,created_at,updated_at)
values('S2',1,2,1,2,SYSDATETIME(),SYSDATETIME());

Insert into seat(seat_number,row_no,column_no,seat_type,auditorium_id,created_at,updated_at)
values('S3',2,1,0,3,SYSDATETIME(),SYSDATETIME());

Insert into seat(seat_number,row_no,column_no,seat_type,auditorium_id,created_at,updated_at)
values('S4',2,2,0,3,SYSDATETIME(),SYSDATETIME());
-------------------------------------

select * from movie;

insert into movie(name,poster,created_at,updated_at) values('dhurander','dhurander',SYSDATETIME(),SYSDATETIME());
------------------------------------
select * from show;
insert into show(auditorium_id,movie_id,created_at,updated_at,end_time,start_time) values(2,1,SYSDATETIME(),SYSDATETIME(),'2026-07-15 14:00:00','2026-07-15 16:30:00');

insert into show(auditorium_id,movie_id,created_at,updated_at,end_time,start_time) values(2,2,SYSDATETIME(),SYSDATETIME(),'2026-07-15 18:00:00','2026-07-15 21:30:00');
-------------------------
select * from show_seat;

insert into show_seat(show_id,seat_id,status,updated_at,created_at) values(2,3,1,SYSDATETIME(),SYSDATETIME());

insert into show_seat(show_id,seat_id,status,updated_at,created_at) values(2,4,1,SYSDATETIME(),SYSDATETIME());

insert into show_seat(show_id,seat_id,status,updated_at,created_at) values(1,4,1,SYSDATETIME(),SYSDATETIME());

---------------------

select * from user1;

insert into user1(name,email,created_at,updated_at) values('U1','u1',SYSDATETIME(),SYSDATETIME());
insert into user1(name,email,created_at,updated_at) values('U2','u2',SYSDATETIME(),SYSDATETIME());
-------------------------

select * from user1;
select * from show;
select * from seat;
select * from show_seat;
select * from ticket;
select * from city;
select * from auditorium;
select * from theater;
select * from movie;
--------------
drop table user1;
drop table show;
drop table seat;
drop table show_seat;
drop table ticket;
drop table city;
drop table theater;
drop table auditorium;
drop table movie;
----------------
get All foreign key of tables

SELECT
    fk.name AS ForeignKeyName,
    tp.name AS ParentTable,
    cp.name AS ParentColumn,
    tr.name AS ReferencedTable,
    cr.name AS ReferencedColumn
FROM sys.foreign_keys fk
JOIN sys.foreign_key_columns fkc
    ON fk.object_id = fkc.constraint_object_id
JOIN sys.tables tp
    ON fkc.parent_object_id = tp.object_id
JOIN sys.columns cp
    ON fkc.parent_object_id = cp.object_id
   AND fkc.parent_column_id = cp.column_id
JOIN sys.tables tr
    ON fkc.referenced_object_id = tr.object_id
JOIN sys.columns cr
    ON fkc.referenced_object_id = cr.object_id
   AND fkc.referenced_column_id = cr.column_id
WHERE tp.name = 'show';

---
drop foreign key of table

ALTER TABLE show_seat
DROP CONSTRAINT FKfnwp5xjbqxhw1pdanbf7el1cp;
