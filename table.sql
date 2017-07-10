create table account(accno int(10),fname varchar(10),lname varchar(20),city varchar(10),pin int(10),amount decimal(10,2),primary key(accno));

create table transaction(accno int(10),type varchar(10),date varchar(20),amount decimal(10,2),balance decimal(10,2),decide decimal(10,2),foreign key(accno) references account(accno));