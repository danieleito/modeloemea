create database EMEA;
GO
use EMEA;
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
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('dhi', 'dhi', 'dhi10@inf.ufpr.br', '123', 2);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('di', 'di', 'di10@inf.ufpr.br', '1', 2);
---------------------------------------------------------------------------

--Ponte
create table PONTE
	(
		ID_PONTE							int				not null identity(1,1),
		CD_PONTE							varchar(10)		not null,
		DS_IDENTIFICACAO_OBRA				varchar(60)		not null,
		DS_VIA								varchar(6)		not null,
		DS_UF								varchar(60)		not null,
		DS_LOCAL_VIA						varchar(6)		not null,
		CONSTRAINT							pk_ponte		PRIMARY KEY(ID_PONTE)
	);

insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, DS_VIA, DS_UF, DS_LOCAL_VIA) values ('111111111', 'Ponte 111', 'BR-116', 'PARANÁ', 'KM-150');
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, DS_VIA, DS_UF, DS_LOCAL_VIA) values ('2222222222', 'Ponte 222', 'BR-116', 'PARANÁ', 'KM-590');
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, DS_VIA, DS_UF, DS_LOCAL_VIA) values ('3333333333', 'Ponte 333', 'BR-277', 'PARANÁ', 'KM-100');
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, DS_VIA, DS_UF, DS_LOCAL_VIA) values ('4444444444', 'Ponte 444', 'BR-277', 'PARANÁ', 'KM-840');
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, DS_VIA, DS_UF, DS_LOCAL_VIA) values ('5555555555', 'Ponte 555', 'BR-376', 'PARANÁ', 'KM-233');
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, DS_VIA, DS_UF, DS_LOCAL_VIA) values ('6666666666', 'Ponte 666', 'BR-376', 'PARANÁ', 'KM-999');
---------------------------------------------------------------------------

--Simulação
create table SIMULACAO
	(
		ID_SIMULACAO	int						not null identity(1,1),
		DT_DATA			date					not null,
		ID_USUARIO		int						not null,
		NM_SIMULACAO	varchar(20)				not null,
		--ID_RANKING		int						not null,
		CONSTRAINT		pk_simulacao			PRIMARY KEY(ID_SIMULACAO),
		CONSTRAINT		fk_simulacao_usuario	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
		--CONSTRAINT		fk_simulacao_ranking	FOREIGN KEY (ID_RANKING) REFERENCES RANKING(ID_RANKING)
	);

insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('28/04/2016', 1, 'simulação 1');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('30/04/2016', 1, 'simulação 2');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('01/05/2016', 1, 'simulação 3');
---------------------------------------------------------------------------

--Ranking
create table RANKING
	(
		ID_RANKING							int				not null identity(1,1),
		ID_PONTE							int				not null,
		ID_SIMULACAO						int				not null,
		CS_CLASSIFICACAO					int				not null,
		DS_INDICE_PERFORMANCE_RELATIVO		varchar(20)		not null,
		CONSTRAINT							pk_ranking		PRIMARY KEY(ID_RANKING),
		CONSTRAINT							fk_ranking_ponte FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT							fk_ranking_simulacao FOREIGN KEY(ID_SIMULACAO) REFERENCES SIMULACAO (ID_SIMULACAO)
	);

insert into RANKING (ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values (1, 1, 1, '1');
insert into RANKING (ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values (2, 1, 2, '2');
insert into RANKING (ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values (3, 3, 3, '3');
insert into RANKING (ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values (4, 1, 4, '4');
insert into RANKING (ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values (5, 2, 5, '5');
---------------------------------------------------------------------------

--Elemento
create table ELEMENTO
	(
		ID_ELEMENTO		int			not null identity(1,1),
		NM_ELEMENTO		varchar(100)	not null,
		DS_CAPA			varchar(10)		not null,
		CONSTRAINT		pk_elemento		PRIMARY KEY(ID_ELEMENTO)
	);
GO
insert into ELEMENTO (NM_ELEMENTO, DS_CAPA) values ('elemento01', 'K01');
insert into ELEMENTO (NM_ELEMENTO, DS_CAPA) values ('elemento02', 'K02');

--Manifestacao
create table MANIFESTACAO
	(
		ID_MANIFESTACAO			int						not null identity(1,1),
		NM_MANIFESTACAO			varchar(100)			not null,
		DS_BETA					varchar(10)				not null,
		CONSTRAINT				pk_manifestacao			PRIMARY KEY(ID_MANIFESTACAO)
	);
GO
insert into MANIFESTACAO (NM_MANIFESTACAO, DS_BETA) values ('manifestacao01', 'B01');
insert into MANIFESTACAO (NM_MANIFESTACAO, DS_BETA) values ('manifestacao02', 'B02');
---------------------------------------------------------------------------

--Inspecoes
create table INSPECAO
	(
		ID_INSPECAO					int			not null identity(1,1),
		DT_DATA						date		not null,
		ID_USUARIO					int			not null,
		DS_CONDICAO_ESTABILIDADE	varchar(30)	not null,
		DS_CONDICAO_CONSERVACAO		varchar(30)	not null,
		CONSTRAINT					pk_inspecao	PRIMARY KEY(ID_INSPECAO),
		CONSTRAINT					pk_inspecao_usuario	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
	);
GO
insert into INSPECAO (DT_DATA, ID_USUARIO, DS_CONDICAO_ESTABILIDADE, DS_CONDICAO_CONSERVACAO) values ('05/05/2016', 1, '1-condição estabilidade', '1- condição conservação');
insert into INSPECAO (DT_DATA, ID_USUARIO, DS_CONDICAO_ESTABILIDADE, DS_CONDICAO_CONSERVACAO) values ('10/05/2016', 1, '2-condição estabilidade', '2- condição conservação');
insert into INSPECAO (DT_DATA, ID_USUARIO, DS_CONDICAO_ESTABILIDADE, DS_CONDICAO_CONSERVACAO) values ('15/05/2016', 1, '3-condição estabilidade', '3- condição conservação');
---------------------------------------------------------------------------

--Arquivos anexos
create table ARQUIVOS_ANEXOS
	(
		ID_ARQUIVOS_ANEXOS		int				not null identity(1,1),
		DS_TIPO_FOTO			varchar(10)		not null,
		NR_NUMERO				varchar(3)		not null,
		DS_DESCRICAO			varchar(20)		not null,
		DS_REGISTRO				varchar(10)		not null,
		DT_DATA_ANEXACAO		date			not null,
		--DS_MINIATURA			
		CONSTRAINT				pk_arquivosarnexos	PRIMARY KEY(ID_ARQUIVOS_ANEXOS)
	);
GO
insert into ARQUIVOS_ANEXOS () values ();