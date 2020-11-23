drop user if exists 'library'@'localhost';
create user 'library'@'localhost' identified by 'mylibrary';
grant all privileges on librarydb.* to 'library'@'localhost';
flush privileges;

drop database if exists librarydb;
create database librarydb;