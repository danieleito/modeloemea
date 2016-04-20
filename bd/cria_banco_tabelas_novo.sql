create database EMEA2;
GO
use EMEA2;
GO
---------------------------------------------------------------------------
create table TIPO_USUARIO
	(
		ID_TIPO_USUARIO		INT				not null identity(1,1),
		DS_TIPO				varchar(20)		not null,
		CONSTRAINT			pk_tipousuario	PRIMARY KEY(ID_TIPO_USUARIO)
	);
GO
insert into TIPO_USUARIO (DS_TIPO) values ('Administrador');
insert into TIPO_USUARIO (DS_TIPO) values ('Usuário comum');

create table USUARIO 
	(
		ID_USUARIO			int				not null identity(1,1),
		NM_NOME				varchar(50)		not null,
		DS_USUARIO			varchar(20)		not null,
		DS_EMAIL			varchar(30)		not null,
		DS_SENHA			varchar(20)		not null,
		ID_TIPO_USUARIO		int				not null,
		CONSTRAINT			pk_usuario		PRIMARY KEY(ID_USUARIO),
		CONSTRAINT			fk_usuario_tipousuario FOREIGN KEY(ID_TIPO_USUARIO) REFERENCES TIPO_USUARIO(ID_TIPO_USUARIO)
	);
GO
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Dani', 'dani', 'ito.dani', '123', 1);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Daniele', 'daniele', 'ito.dani', '123', 1);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Usu1', 'usu1', 'ito.dani', '123', 1);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Usu2', 'usu2', 'ito.dani', '123', 1);
---------------------------------------------------------------------------
--Simulação
create table SIMULACAO
	(
		ID_SIMULACAO	int					not null identity(1,1),
		--DT_DATA			date				not null,
		NM_INSPETOR		varchar(50)			not null,
		NM_SIMULACAO	varchar(20)			not null,
		CONSTRAINT		pk_simulacao		PRIMARY KEY(ID_SIMULACAO)
	);

insert into SIMULACAO ( NM_INSPETOR, NM_SIMULACAO) values ('dani', 'simulacao01');
---------------------------------------------------------------------------
--Ranking
create table RANKING
	(
		ID_RANKING							int				not null identity(1,1),
		CD_RANKING							varchar(20)		not null,
		DS_IDENTIFICACAO_OBRA				varchar(20)		not null,
		DS_VIA								varchar(20)		not null,
		DS_UF								varchar(20)		not null,
		DS_LOCAL_VIA						varchar(20)		not null,
		DS_INDICE_PERFORMANCE_RELATIVO		varchar(20)		not null,
		CONSTRAINT							pk_ranking		PRIMARY KEY(ID_RANKING)
	);

insert into RANKING (CD_RANKING, DS_IDENTIFICACAO_OBRA, DS_VIA, DS_UF, DS_LOCAL_VIA, DS_INDICE_PERFORMANCE_RELATIVO) values ('codigo', 'identificacao', 'via', 'uf', 'local_via', 'indice');
---------------------------------------------------------------------------
--Elemento
create table ELEMENTO
	(
		ID_ELEMENTO		int				not null identity(1,1),
		NM_ELEMENTO		varchar(100)	not null,
		DS_KAPPA		varchar(10)		not null,
--		mais alguns itens
		CONSTRAINT		pk_elemento		PRIMARY KEY(ID_ELEMENTO)
	);

insert into ELEMENTO (NM_ELEMENTO, DS_KAPPA) values ('ELEMENTO', 'KAPA');
---------------------------------------------------------------------------
--Manifestacao
create table MANIFESTACAO
	(
		ID_MANIFESTACAO			int						not null identity(1,1),
		NM_MANIFESTACAO			varchar(100)			not null,
		DS_BETA					varchar(10)				not null,
--		mais alguns itens
		CONSTRAINT				pk_manifestacao			PRIMARY KEY(ID_MANIFESTACAO)
	);

insert into MANIFESTACAO (NM_MANIFESTACAO, DS_BETA) values ('manifestacao', 'beta');
---------------------------------------------------------------------------

---------------------------------------------------------------------------

---------------------------------------------------------------------------

---------------------------------------------------------------------------

---------------------------------------------------------------------------

---------------------------------------------------------------------------