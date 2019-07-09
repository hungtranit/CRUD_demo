truncate table department;
alter SEQUENCE department_id_seq RESTART with 1;
insert into department (name) values ('Information Technology');
insert into department (name) values ('Human Resource');
insert into department (name) values ('Marketing');
insert into department (name) values ('Financial Accounting');
insert into department (name) values ('C-level');

truncate table employee;
alter SEQUENCE employee_id_seq RESTART with 1;
insert into employee (first_name, last_name, gender, email, department) values ('Hai', 'Nguyen', 'male', 'nmhai1995@gmail.com', 1);
insert into employee (first_name, last_name, gender, email, department) values ('Huy', 'Nguyen', 'male', 'huynguyen@gmail.com', 5);
insert into employee (first_name, last_name, gender, email, department) values ('Thao', 'Doan', 'female', 'nmhai1995@gmail.com', 3);