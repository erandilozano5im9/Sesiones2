create database lab3;
use lab3;
create table usuario(
	nombre varchar(20),
    password varchar(20)
);
insert into usuario values("Erandi Lozano","Contraseña");
select * from usuario where nombre='Erandi Lozano';