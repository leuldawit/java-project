

		create table teacher(tid int primary key identity,
teacherfname varchar(30),
teacherlname varchar(30),
gender varchar(10))
		
		
		create table course( cid int identity (1000,1)primary key , 
coursename  varchar(20) unique ,maxstudents int ,
numberofstudents int,
tid int foreign key references  teacher(tid))

		create table registeration (sid int foreign key references  student(sid),
age int not null, 
GPA decimal(3,2)check(GPA>1 and GPA <=4),
DOR date )


		create table student (sid int identity primary key,
firstname varchar(50),lastname varchar(50)
, gender varchar(7),
password varchar(50) )



	create table courses_taken(sid int foreign key references  student(sid),
cid int foreign key references course(cid),
tid int foreign key references teacher(tid))

use university select count (*) from course where maxstudents!=numberofstudents

UPDATE student 
SET  firstname='kidus',lastname='dawit',gender='F',password='2' where sid=1
insert into registeration(age,DOR)values( 20,CONVERT(DATE, GETDATE()))
SELECT 
    CONVERT(DATE, GETDATE());

drop table registeration
delete  from student
drop table course
drop table courses_taken
drop table teacher
select distinct * from course left join teacher on course.tid=teacher.tid
select * from student
select * from teacher
select * from regiseration
select * from course
select * from courses_taken

select  * from courses_taken left join course on courses_taken.cid=course.cid

SELECT
  sid
select * FROM student
ORDER BY sid DESC 
select * from course
select * from registeration



insert into teacher (teacherfname,teacherlname,gender) values('abebe','kebede','M')

select distinct * from course left join teacher on course.tid=course.cid
create view course_and_teacher as select  * from course left join teacher on course.maxstudents=teacher.tid
select * from course_and_teacher
drop view course_and_teacher
delete from course
delete from teacher
select distinct * from course left join teacher on course.tid=teacher.tid
select count(*) from course
