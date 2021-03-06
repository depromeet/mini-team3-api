create database dpm2018; -- Create the new database
create user 'dpm'@'localhost' identified by 'dpm'; -- Creates the user
grant all on dpm2018.* to 'dpm'@'localhost'; -- Gives all the privileges to the new user on the newly created database

use dpm2018;

create table user (
	user_id int(5) unsigned NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(255) NOT NULL,
    phone VARCHAR(255),
    image VARCHAR(255),
    primary key (user_id)
);

select * from user;
