CREATE DATABASE Library_Database;
/* Creating database*/
USE Library_Database;
/*Using databse to create table*/
CREATE TABLE members(
member_id INT PRIMARY KEY AUTO_INCREMENT,
member_nm VARCHAR(20),
addressline1 VARCHAR(20),
addressline2 VARCHAR(20),
category CHAR);
/* creating table MEMBERS for different attributes*/
CREATE TABLE authors(
author_id INT PRIMARY KEY AUTO_INCREMENT,
author_nm VARCHAR(20));
/* Table AUTHORS for different attributes of author*/
CREATE TABLE publishers(
publisher_id INT PRIMARY KEY AUTO_INCREMENT,
publisher_nm VARCHAR(20));
/* table PUBLISHERS for different attributes of publisher*/
CREATE TABLE subjects(
subject_id INT PRIMARY KEY AUTO_INCREMENT,
subject_nm VARCHAR(20));
/* table SUBJECTS for different attributes of subjects of book*/
CREATE TABLE titles(
title_id INT PRIMARY KEY AUTO_INCREMENT,
title_nm VARCHAR(20),
subject_id INT,
publisher_id INT,
FOREIGN KEY(subject_id) REFERENCES subjects(subject_id),
CONSTRAINT publisher_id_first
FOREIGN KEY(publisher_id)REFERENCES publishers(publisher_id)
ON DELETE CASCADE
);
/* table titles for different attributes and having subject id and publisher id as foreign key*/
CREATE TABLE title_author(
title_id INT,
author_id INT,
PRIMARY KEY(title_id,author_id),
FOREIGN KEY(title_id) REFERENCES titles(title_id),
FOREIGN KEY(author_id) REFERENCES authors(author_id));
/* table title_author for different attributes and title id , author id as foreign key*/
CREATE TABLE books(
accession_no INT PRIMARY KEY AUTO_INCREMENT,
title_id INT,
purchase_dt DATE,
price INT,
status INT,
FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE
);
/* table books for different attributes of books and title id as foreign key*/
CREATE TABLE book_issue(
issue_dt DATE,
accession_no INT,
member_id INT,
due_dt DATE,
PRIMARY KEY(issue_dt,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES books(accession_no),
CONSTRAINT member_id_first
FOREIGN KEY(member_id) REFERENCES members(member_id)
ON DELETE CASCADE
);
/* table book_issue for different attributes of book issue and accession no and member id as foreign key*/

CREATE TABLE book_return(
return_dt DATE,
issue_dt DATE,
accession_no INT,
member_id INT,
PRIMARY KEY(return_dt,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES books(accession_no),
CONSTRAINT member_id_second
FOREIGN KEY(member_id) REFERENCES members(member_id)
ON DELETE CASCADE
);

/*table book return for different attributes and accession no and member id as foreign key*/
ALTER TABLE book_issue
MODIFY COLUMN issue_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP();
/* modifying the issue date by current date of system*/
CREATE TRIGGER book
BEFORE
INSERT 
ON book_issue  
FOR EACH ROW 
SET NEW.due_dt = NOW() + INTERVAL 15 day;
/*updating the due date by adding 15 days in issue date by using trigger*/

SHOW CREATE TABLE book_issue;
/*to show the create table book_issue */
ALTER TABLE book_issue
DROP FOREIGN KEY member_id_first;
/* droping the foreign key in book_issue table*/
ALTER TABLE book_return
DROP FOREIGN KEY member_id_second;

/* droping the foreign key in book_return table*/
DROP TABLE members;
/* droping table member*/
CREATE TABLE members(
member_id INT PRIMARY KEY AUTO_INCREMENT,
member_nm VARCHAR(20),
addressline1 VARCHAR(20),
addressline2 VARCHAR(20),
category CHAR);
/*again creating table members*/
ALTER TABLE book_issue
ADD CONSTRAINT member_id_first
FOREIGN KEY (member_id)
REFERENCES members(member_id);
/*again setting foreign key in table book_issue*/
ALTER TABLE book_return
ADD CONSTRAINT member_id_second
FOREIGN KEY (member_id)
REFERENCES members(member_id);

/*again setting foreign key in table book_return*/


USE LIBRARY_DATABASE;
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "pragati","420","neemuch",'f');
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "arushi","21","jaipur",'f');
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "sumitra","34","chittor",'f');
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "deepali","47","neemuch",'f');
INSERT INTO members (member_nm,addressline1,addressline2,category )
VALUES( "manju","75","neemuch",'f');
/*inserting value in table members*/
INSERT INTO subjects (subject_nm)
VALUES("Fiction Novel");
INSERT INTO subjects (subject_nm)
VALUES("Non-Fiction Novel");
INSERT INTO subjects (subject_nm)
VALUES("Business");
INSERT INTO subjects (subject_nm)
VALUES("Competitive Success");
INSERT INTO subjects (subject_nm)
VALUES("Technology");
/*inserting value in subject table*/
INSERT INTO publishers (publisher_nm)
VALUES("New Moon Books");
INSERT INTO publishers (publisher_nm)
VALUES("Technology");
INSERT INTO publishers (publisher_nm)
VALUES("Scootney Books");
INSERT INTO publishers (publisher_nm)
VALUES("Darshan");
INSERT INTO publishers (publisher_nm)
VALUES("Five Publishing");
/*inserting value in publisher table*/
INSERT INTO authors (author_nm)
VALUES("White Johnson");
INSERT INTO authors (author_nm)
VALUES("Dull Ann");
INSERT INTO authors (author_nm)
VALUES("Groon Marjorie");
INSERT INTO authors (author_nm)
VALUES("Branath Abraham");
INSERT INTO authors (author_nm)
VALUES("Smith Meander");

/*inserting value in author table*/
INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("DBMS",(SELECT subject_id FROM subjects where subject_nm='Technology'),
(SELECT publisher_id FROM publishers where publisher_nm='Scootney Books'));

INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("Operating System",(SELECT subject_id FROM subjects where subject_nm='Technology'),
(SELECT publisher_id FROM publishers where publisher_nm='Technology'));

INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("Ansi C",(SELECT subject_id FROM subjects where subject_nm='Technology'),
(SELECT publisher_id FROM publishers where publisher_nm='Technology'));

INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("The PRESENT",(SELECT subject_id FROM subjects where subject_nm='Technology'),
(SELECT publisher_id FROM publishers where publisher_nm='New Moon Books'));

INSERT INTO titles (title_nm,subject_id,publisher_id)
VALUES("PAPER TOWN",(SELECT subject_id FROM subjects where subject_nm='Technology'),
(SELECT publisher_id FROM publishers where publisher_nm='Five Publishing'));
/*inserting value in titles table*/
INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='Ansi C'),NOW(),2000,1);

INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='Operating System'),NOW(),4000,0);

INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='The PRESENT'),NOW(),8000,1);

INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='PAPER TOWN'),NOW(),900,0);

INSERT INTO books (title_id,purchase_dt,price,status)
VALUES((SELECT title_id FROM titles where title_nm='DBMS'),NOW(),3000,0);

/*inserting value in books table*/
INSERT INTO title_author (title_id,author_id)
VALUES((SELECT title_id FROM titles where title_nm='Ansi C'),(SELECT author_id FROM authors where author_nm='Dull Ann'));
/*inserting value in title_author table*/
INSERT INTO book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM titles where title_nm='Ansi C')),
(SELECT member_id FROM members where member_nm='pragati'));

/*inserting value in book_issue table*/
INSERT INTO book_return(return_dt,issue_dt,accession_no,member_id)
VALUES((SELECT due_dt from book_issue where member_id =1),
(SELECT issue_dt from book_issue where member_id=1),
(SELECT accession_no FROM book_issue where member_id=1),1);
/*inserting value in book_return table*/
SET SQL_SAFE_UPDATES=0;
UPDATE members SET addressline2='Jaipur' where member_id=member_id ;
/*to update the value of addressline2 in whole table*/
UPDATE members SET addressline1='EPIP, Sitapura' where category='f' ;
/*to update the value of addressline1 where categorgy of workers in female*/
ALTER TABLE titles
DROP FOREIGN KEY publisher_id_first;
/*droping foreign key in titles*/
Delete from publishers;
/*droping table publishers*/
SET @name= 'New Moon Books';
INSERT INTO publishers (publisher_nm)
VALUES(@name);

SET @name= 'Tecnology';
INSERT INTO publishers (publisher_nm)
VALUES(@name);

SET @name= 'Scootney Books';
INSERT INTO publishers (publisher_nm)
VALUES(@name);
/*inserting in publishers using sustitution method*/

DELETE FROM titles where publisher_id=1;
/*deleting the row from titles where publisher id is 1*?
