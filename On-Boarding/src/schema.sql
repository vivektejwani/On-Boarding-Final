create table emp(
                  emp_id int auto_increment primary key,
                  password varchar(32) not null,
                  name_first varchar(16) not null,
                  name_last varchar(16),
                  email varchar(64) not null unique,
                  designation varchar(16) not null
                  );

create table admin(
					admin_id int auto_increment primary key,
                  email varchar(64) not null unique,
                   password varchar(32) not null
                   );

create table hr(
                hr_id int auto_increment primary key,
                password varchar(32) not null,
                name_first varchar(16) not null,
                name_last varchar(16),
                email varchar(64) not null unique
                );


create table ggroup(
                   group_id int auto_increment primary key,
                   group_name varchar(32) not null,
                   hr_id int not null,
                   foreign key (hr_id) references hr(hr_id)
                   );

create table message(
                     msg varchar(256) not null,
                     subject varchar(32),
                     timestamp time ,
                     group_id int,
                     primary key (timestamp,group_id),
                     foreign key (group_id) references ggroup(group_id)
                     );

create table emp_group(
	                   emp_id int,
	                   group_id int,
	                   primary key (emp_id,group_id),
	                   foreign key emp_id references emp(emp_id),
	                   foreign key group_id references ggroup(group_id)
                       );



