create database nupes;
use nupes;
create table usuario(
id int(10) auto_increment primary key,
usuario varchar(7) not null, 
senha varchar(7) not null);
describe  usuario;
INSERT INTO usuario(usuario,senha) VALUES ('root','123');