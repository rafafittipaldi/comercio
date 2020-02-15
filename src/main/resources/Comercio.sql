drop database if exists comercio;
create database comercio;

use comercio;

drop table if exists produto;
drop table if exists usuario;

create table produto (
	id int not null primary key auto_increment,
    foto blob(100000),
    nome varchar(80),
    descricao varchar(255),
    preco double(10,2)
);

create table usuario (
	id int not null primary key auto_increment,
    login varchar(80),
    senha varchar(80)
);

insert into usuario (login, senha)
	values(
		'rafael',
        '1234'
);

insert into produto (foto, nome, descricao, preco)
	values(
		'iphone.png',
        'Iphone',
        'Design inovador, totalmente em vidro. A câmera que o mundo inteiro adora, ainda melhor. O chip mais poderoso e inteligente em qualquer smartphone. Recarga sem fio simples de verdade.',
        3099.00
);