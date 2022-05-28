# Run these SQL commands to create the DB and Tables before running the code

CREATE DATABASE classmanagement;

USE classmanagement;


SET foreign_key_checks = 0;

drop table ListTeachers;

drop table ListClass;

drop table ListStudents;

drop table ListSubjects;

drop table Class_Stu;

drop table Class_Sub;

drop table Teacher_Sub;

SET foreign_key_checks = 1;


create table ListTeachers(cid int NOT NULL AUTO_INCREMENT,tname varchar (255),email varchar (255),phone varchar (255),PRIMARY KEY (cid));

create table ListClass(cid int NOT NULL AUTO_INCREMENT,cname varchar (255),PRIMARY KEY (cid));

create table ListStudents(cid int NOT NULL AUTO_INCREMENT,sname varchar (255),email varchar (255),phone varchar (255),PRIMARY KEY (cid));

create table ListSubjects(cid int NOT NULL AUTO_INCREMENT,subname varchar (255),PRIMARY KEY (cid));


create table Class_Stu(cid_cname int, cid_sname int, FOREIGN KEY (cid_cname)  REFERENCES ListClass(cid), FOREIGN KEY (cid_sname) REFERENCES ListStudents(cid)  );

create table Class_Sub(cid_cname int, cid_subname int, FOREIGN KEY (cid_cname)  REFERENCES ListClass(cid), FOREIGN KEY (cid_subname) REFERENCES ListSubjects(cid)  );

create table Teacher_Sub(cid_tname int, cid_subname int, FOREIGN KEY (cid_tname)  REFERENCES ListTeachers(cid), FOREIGN KEY (cid_subname) REFERENCES ListSubjects(cid)  );


select * from ListTeachers;

select * from ListClass;

select * from  ListStudents;

select * from ListSubjects;


select * from Class_Stu;

select * from  Class_Sub;

select * from  Teacher_Sub;


#### After creating the SQL tables, run the "Login.Jsp" file and you will the screen as below:
![image](https://user-images.githubusercontent.com/20127370/170828400-ac0e91d6-1bbd-4f50-b910-f07313beab30.png)

