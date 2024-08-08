create database reservasCanchas;
use reservasCanchas;

-- PARTE LOGIN GENERAL --
create table usuarios(
nombre varchar(20) not null,
apellido varchar (20) not null,
email varchar(30) not null unique,
contrasenia varchar(30) not null,
cedula varchar(10) primary key,
modo varchar(30) not null
);


-- PARTE ADMINISTRADOR --
create table agregar_jugadores(
nombre varchar(20) not null,
apellido varchar(20) not null,
edad int,
cedula varchar(10) primary key,
email varchar(30) not null unique,
contrasenia varchar(30) not null,
telefono varchar(10) not null,
tipo_rol varchar(10) not null
);

create table canchas(
facultad varchar(20) not null,
cedula varchar(20) not null,
tipo_cancha varchar(30) not null,
ubicacion varchar(30) not null,
capacidad int
);

create table horarios(
fecha date,
hora_inicio time,
hora_fin time,
tipo_cancha varchar(30) not null
);


-- PARTE JUGADOR --
create table reservar_canchas(
cedula varchar(10) not null,
fecha date,
hora time,
tipoCanchas_Reservas varchar(30) not null,
hora_fin time
);

create table cancelar_reserva(
cedula varchar(10) not null,
tipo_canchas_cancelar varchar(30) not null
);


-- Parte Encargado --
create table estado(
tipo_cancha varchar(20) not null,
estado varchar(20) not null
);


select * from usuarios;
select * from agregar_jugadores;
select * from canchas;
select * from horarios;
select * from reservar_canchas;
select * from cancelar_reserva;
select * from estado;









-- Borra todos los datos de las tablas
TRUNCATE TABLE usuarios;
TRUNCATE TABLE agregar_jugadores;
TRUNCATE TABLE canchas;
TRUNCATE TABLE horarios;
TRUNCATE TABLE reservar_canchas;
TRUNCATE TABLE estado;


alter table canchas
change column nombre cedula varchar (10) not null;

alter table reservar_canchas
add column hora_fin time;

alter table reservar_canchas
add column tipoCanchas_Reservas varchar(30) not null;

alter table agregar_jugadores
add column tipo_rol varchar(10) not null;

