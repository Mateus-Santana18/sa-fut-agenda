create table usuario
(
    "id"       serial primary key,
    "nome"     varchar(40)  not null,
    "email"    text unique  not null,
    "telefone" varchar(20)  not null,
    "senha"    varchar(255) not null,
    "cargo"    varchar(255) not null
);

create table estabelecimento
(
    "id"       serial primary key,
    "endereco" varchar(40) not null,
    "cnpj"     varchar(16) not null
);

create table quadra
(
    "id"                 serial primary key,
    nome                 text not null,
    tipo                 text not null,
--	 				MUITOS PRA UM
    "id_estabelecimento" integer not null references estabelecimento (id)
);

create table organizador
(
    "id"         serial primary key,
    "id_usuario" integer not null
);

create table reserva
(
    "id"             serial primary key,
    "horario"        text    not null,
    "id_organizador" integer references organizador (id),
    "id_quadra"      integer not null references quadra (id)
);

create table reserva_usuario
(
    "id"         serial primary key,
    "id_usuario" integer,
    "id_reserva" integer references reserva (id),
    "funcao"     text    not null
);

insert into estabelecimento (endereco, cnpj)
VALUES ('SC-401, 300', '86376783000128')
returning id;

CREATE EXTENSION if not exists pgcrypto;

insert into usuario (nome, email, telefone, senha, cargo)
SELECT 'Admin', 'admin@gmail.com', '(48) 99960-3951', crypt('1234', gen_salt('bf')), 'ADMIN'
where not exists(select 1 from usuario where email = 'admin@gmail.com');