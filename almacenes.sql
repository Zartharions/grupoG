CREATE DATABASE IF NOT EXISTS `AlmacenesTia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `AlmacenesTia`;

create table Usuario(
	id int not null auto_increment primary key,
    Nombre varchar(250) not null,
    Contraseña  varchar(250) not null,
    Tipos_usuarios varchar(250) not null
)

SELECT * FROM almacenestia.usuario;

insert into Usuario(Nombre, contraseña,tipos_usuarios)
values ('admin','adm123','Administrador');

insert into Usuario(Nombre, contraseña,tipos_usuarios)
values ('Ron','ron123','Administrador');

SELECT * FROM usuario where usuario.Nombre='admin' and usuario.contraseña='adm123';

create table Cliente(
	id int not null auto_increment primary key,
    Ci int(20) not null,
    Nombre varchar(150) not null,
    Telefono int(15),
    Direccion varchar(200),
    Razon varchar(200),
    Fecha datetime default current_timestamp
);

create table Proveedor(
	id int not null auto_increment primary key,
    Ruc int(20) not null,
    Nombre varchar(150) not null,
    Telefono int(15),
    Direccion varchar(200),
    Razon varchar(200),
    Fecha datetime default current_timestamp
);

create table Productos(
	Id int not null auto_increment primary key,
    Codigo varchar(30) not null,
    Nombre varchar(255) not null,
    Proveedor varchar(100) not null,
    Stock int(20),
    Precio decimal(10,2),
    Fecha datetime default current_timestamp
);

create table Detalles(
	Id int not null auto_increment primary key,
    Codigo_Producto varchar(20),
    Cantidad int (20),
    Precio decimal(10,2),
    Id_Venta int(20)
);

create table Ventas(
	Id int not null auto_increment primary key,
    Cliente varchar(200),
    Vendedor varchar(200),
    Total decimal(10,2),
    Fecha datetime default current_timestamp
);

create table Config(
	Id int not null auto_increment primary key,
    Nombre varchar(200) not null,
    Ruc int(20) not null,
    Telefono int(15),
    Direccion varchar(200),
    Razon varchar(200)
);

select * from clientes;

ALTER TABLE clientes MODIFY Ci VARCHAR(255);

drop table config;