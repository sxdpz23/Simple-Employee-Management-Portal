show databases;
drop database if exists liveproject;
create database liveproject;
use liveproject; 

create table e_service(
	employee_id int not null auto_increment,
    name varchar(50) not null,
    location varchar(20) not null,
    phone_one varchar(10) not null,
    phone_two varchar(10) not null,
    email varchar(50) not null,
    constraint e_service_employee_id_pk primary key ( employee_id )
);
create table et_service(
	email_id varchar(50) not null references e_service(email),
    course_name varchar(50) not null,
    course_code varchar(10) not null,
    score varchar(2) not null,
    hours_spent int not null,
    date_completed date,
    status varchar(20) not null,
    constraint et_service_email_id_pk primary key ( email_id )
);

-- alter table e_service add constraint e_service_email_fk foreign key (`email`) references e_service(`email`);

-- alter table et_service add constraint et_service_email_id_fk foreign key (`email_id`) references e_service(`email`);

alter table et_service add constraint et_service_score_ck check (score in ('A+', 'A', 'A-', 'B+', 'B', 'B-', 'C'));
alter table et_service add constraint et_service_hours_spent_ck check (hours_spent between 1 and 100);
alter table et_service add constraint et_service_status_ck check (status in ('STARTED', 'COMPLETED'));

insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( 1000000, 'Akriti Saksena', 'Goa', '9456186485', '8621859941', 'akriti.saksena@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( 1000001, 'Nidhin Kheira', 'Chandigarh', '9461346516', '8459513351', 'nidhin.kheira@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( 1000002, 'Tribuvi Papdeja', 'Mumbai', '7513244956', '9468151354', 'tribuvi.papdeja@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( null, 'Mukul Padia', 'Mohali', '6845161351', '9875515452', 'mukul.padia@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( null, 'Kshitij Kumar', 'Pune', '8457886512', '7451263554', 'kshitij.kumar@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( null, 'Ashiya Nazami', 'Bangalore', '9584562385', '7545213585', 'ashiya.nazami@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( null, 'Naomi Dsouza', 'Bangalore', '9896324855', '7853212654', 'naomi.dsouza@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( null, 'Priti Sethi', 'Delhi', '8453215645', '7598524521', 'prithi.sethi@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( null, 'Mukul Ingle', 'Palghar', '9832125545', '9218455874', 'mukul.ingle@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( null, 'Vijay Shah', 'Delhi', '8245563894', '9451231578', 'vijay.shah@infosys.com');
insert into e_service (employee_id, name, location, phone_one, phone_two, email) values ( null, 'Ritvik Shetty', 'Bangalore', '7420352327', '9545258956', 'ritvik.shetty@infosys.com');

insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'akriti.saksena@infosys.com', 'SpringBoot-Angular', '1235', 'A-', 50, null, 'STARTED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'nidhin.kheira@infosys.com', 'SpringBoot-React', '8561', 'B-', 61, '2021-02-04', 'COMPLETED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'tribuvi.papdeja@infosys.com', 'SpringBoot-Angular', '1235', 'A', 54, '2021-01-30', 'COMPLETED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'mukul.padia@infosys.com', 'SpringBoot-Angular', '1235', 'A+', 42, '2021-02-06', 'COMPLETED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'kshitij.kumar@infosys.com', 'SpringBoot-Angular', '1235', 'B', 47, '2021-01-27', 'COMPLETED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'ashiya.nazami@infosys.com', 'SpringBoot-Angular', '1235', 'B-', 12, null, 'STARTED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'naomi.dsouza@infosys.com', 'SpringBoot-Angular', '1235', 'B+', 33, null, 'STARTED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'prithi.sethi@infosys.com', 'SpringBoot-React', '8561', 'A', 59, null, 'STARTED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'mukul.ingle@infosys.com', 'SpringBoot-React', '8561', 'C', 23, null, 'STARTED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'vijay.shah@infosys.com', 'SpringBoot-React', '8561', 'A-', 48, null, 'STARTED');
insert into et_service (email_id, course_name, course_code, score, hours_spent, date_completed, status) values ( 'ritvik.shetty@infosys.com', 'SpringBoot-Angular', '1235', 'B+', 39, null, 'STARTED');

commit;

select * from e_service;
select * from et_service;