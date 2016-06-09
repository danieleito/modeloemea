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
insert into TIPO_USUARIO (DS_TIPO) values ('Coordenador');

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

--UF
create table UF
	(
		ID_UF				int				not null identity(1,1),
		DS_UF				varchar(30)		not null,
		CONSTRAINT			pk_uf			PRIMARY KEY(ID_UF)
	);

GO
insert into UF (DS_UF) values ('Acre');
insert into UF (DS_UF) values ('Alagoas');
insert into UF (DS_UF) values ('Amapá');
insert into UF (DS_UF) values ('Amazonas');
insert into UF (DS_UF) values ('Bahia');
insert into UF (DS_UF) values ('Ceará');
insert into UF (DS_UF) values ('Distrito Federal');
insert into UF (DS_UF) values ('Espírito Santo');
insert into UF (DS_UF) values ('Goiás');
insert into UF (DS_UF) values ('Maranhão');
insert into UF (DS_UF) values ('Mato Grosso');
insert into UF (DS_UF) values ('Mato Grosso do Sul');
insert into UF (DS_UF) values ('Minas Gerais');
insert into UF (DS_UF) values ('Pará');
insert into UF (DS_UF) values ('Paraíba');
insert into UF (DS_UF) values ('Paraná');
insert into UF (DS_UF) values ('Pernambuco');
insert into UF (DS_UF) values ('Piauí');
insert into UF (DS_UF) values ('Rio de Janeiro');
insert into UF (DS_UF) values ('Rio Grande do Norte');
insert into UF (DS_UF) values ('Rio Grande do Sul');
insert into UF (DS_UF) values ('Rondônia');
insert into UF (DS_UF) values ('Roraima');
insert into UF (DS_UF) values ('Santa Catarina');
insert into UF (DS_UF) values ('São Paulo');
insert into UF (DS_UF) values ('Sergipe');
insert into UF (DS_UF) values ('Tocantins');

---------------------------------------------------------------------------
--Via
create table VIA
	(
		ID_VIA			int				not null identity(1,1),
		DS_VIA			varchar(10)		not null,
		ID_UF			int,
		CONSTRAINT		pk_via			PRIMARY KEY(ID_VIA)
	);

GO
insert into VIA (DS_VIA) values ('BR-101');
insert into VIA (DS_VIA) values ('BR-116');
insert into VIA (DS_VIA) values ('BR-153');
insert into VIA (DS_VIA) values ('BR-158');
insert into VIA (DS_VIA) values ('BR-163');
insert into VIA (DS_VIA) values ('BR-272');
insert into VIA (DS_VIA) values ('BR-277');
insert into VIA (DS_VIA) values ('BR-280');
insert into VIA (DS_VIA) values ('BR-282');
insert into VIA (DS_VIA) values ('BR-283');
insert into VIA (DS_VIA) values ('BR-285');
insert into VIA (DS_VIA) values ('BR-369');
insert into VIA (DS_VIA) values ('BR-373');
insert into VIA (DS_VIA) values ('BR-376');
insert into VIA (DS_VIA) values ('BR-386');
insert into VIA (DS_VIA) values ('BR-466');
insert into VIA (DS_VIA) values ('BR-467');
insert into VIA (DS_VIA) values ('BR-469');
insert into VIA (DS_VIA) values ('BR-470');
insert into VIA (DS_VIA) values ('BR-471');
insert into VIA (DS_VIA) values ('BR-475');
insert into VIA (DS_VIA) values ('BR-476');
insert into VIA (DS_VIA) values ('BR-477');
insert into VIA (DS_VIA) values ('BR-480');
insert into VIA (DS_VIA) values ('BR-486');
insert into VIA (DS_VIA) values ('BR-487');

---------------------------------------------------------------------------

--Superintendencia Regional
create table SUPERINTENDENCIA_REGIONAL
	(
		ID_SUPERINTENDENCIA_REGIONAL		int								not null identity(1,1),
		DS_SUPERINTENDENCIA_REGIONAL		varchar(100)					not null,
		ID_UF								int,
		CONSTRAINT							pk_superintendenciaregional		PRIMARY KEY(ID_SUPERINTENDENCIA_REGIONAL),
		CONSTRAINT							fk_superintendenciaregional_uf	FOREIGN KEY(ID_UF) REFERENCES UF(ID_UF)
	);

GO

insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RR - Superintendência Regional do DNIT no estado de Roraima', 23);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - AL - Superintendência Regional do DNIT no estado de Alagoas', 2);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - AM - Superintendência Regional do DNIT no estado de Amazonas', 4);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - BA - Superintendência Regional do DNIT no estado da Bahia', 5);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - CE - Superintendência Regional do DNIT no estado do Ceará', 6);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - ES - Superintendência Regional do DNIT no estado do Espírito Santo', 8);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - GO - Superintendência Regional do DNIT no estado de Goiás e Distrito Federal', 7);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - MA - Superintendência Regional do DNIT no estado do Maranhão', 10);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - MT - Superintendência Regional do DNIT no estado do Mato Grosso', 11);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - MS - Superintendência Regional do DNIT no estado do Mato Grosso do Sul', 12);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - MG - Superintendência Regional do DNIT no estado de Minas Gerais', 13);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PA - Superintendência Regional do DNIT no estado do Pará', 14);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PB - Superintendência Regional do DNIT no estado de Paraíba', 15);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PR - Superintendência Regional do DNIT no estado do Paraná', 16);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PE - Superintendência Regional do DNIT no estado de Pernambuco', 17);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PI - Superintendência Regional do DNIT no estado do Piauí', 18);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RJ - Superintendência Regional do DNIT no estado do Rio de Janeiro', 19);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RN - Superintendência Regional do DNIT no estado do Rio Grande do Norte', 20);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RS - Superintendência Regional do DNIT no estado do Rio Grande do Sul', 21);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RO - Superintendência Regional do DNIT no estado de Rondônia e Acre', 22);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - SC - Superintendência Regional do DNIT no estado de Santa Catarina', 24);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - SP - Superintendência Regional do DNIT no estado de São Paulo', 25);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - SE - Superintendência Regional do DNIT no estado de Sergipe', 26);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - TO - Superintendência Regional do DNIT no estado do Tocantins', 27);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - AP - Superintendência Regional do DNIT no estado do Amapá', 3);

---------------------------------------------------------------------------

--Unidade Local
create table UNIDADE_LOCAL
	(
		ID_UNIDADE_LOCAL				int											not null identity(1,1),
		DS_UNIDADE_LOCAL				varchar(50)									not null,
		ID_SUPERINTENDENCIA_REGIONAL	int											not null,
		CONSTRAINT						pk_unidadelocal								PRIMARY KEY(ID_UNIDADE_LOCAL),
		CONSTRAINT						fk_unidadelocal_superintendenciaregional	FOREIGN KEY(ID_SUPERINTENDENCIA_REGIONAL) REFERENCES SUPERINTENDENCIA_REGIONAL(ID_SUPERINTENDENCIA_REGIONAL)
	);

GO
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR01 - Colombo', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR02 - Campo Mourão', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR03 - Laranjeiras do Sul', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR04 - Ponta Grossa', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR05 - Foz do Iguaçu', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR06 - São José dos Pinhais', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR07 - Londrina', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('PROFE-PR Procuradoria Federal Especializada SRE-PR', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('UL P. Branco/PR - Unidade local em Pato Branco/PR', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC01 - Tubarão', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC02 - Joinville', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC03 - Lages', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC04 - Joaçaba', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC05 - Mafra', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC08 - Chapecó', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC09 - Florianópolis', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC07 - Rio do Sul', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC06 - São José', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC09 - vago', 21);


---------------------------------------------------------------------------

--Ponte
create table PONTE
	(
		ID_PONTE							int				not null identity(1,1),
		CD_PONTE							varchar(10)		not null,
		DS_IDENTIFICACAO_OBRA				varchar(60)		not null,
		ID_VIA								int				not null,
		ID_UF								int				not null,
		DS_LOCAL_VIA						varchar(6)		not null,
		ID_SUPERINTENDENCIA_REGIONAL		int,
		ID_UNIDADE_LOCAL					int,
		CONSTRAINT							pk_ponte		PRIMARY KEY(ID_PONTE)
	);

insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, ID_VIA, ID_UF, DS_LOCAL_VIA, ID_SUPERINTENDENCIA_REGIONAL, ID_UNIDADE_LOCAL) values ('111111111', 'Ponte 111', 1, 16, 'KM-150', 14, 1);
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, ID_VIA, ID_UF, DS_LOCAL_VIA, ID_SUPERINTENDENCIA_REGIONAL, ID_UNIDADE_LOCAL) values ('2222222222', 'Ponte 222', 1, 24, 'KM-590', 21, 1);
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, ID_VIA, ID_UF, DS_LOCAL_VIA, ID_SUPERINTENDENCIA_REGIONAL, ID_UNIDADE_LOCAL) values ('3333333333', 'Ponte 333', 1, 16, 'KM-150', 14, 1);
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, ID_VIA, ID_UF, DS_LOCAL_VIA) values ('4444444444', 'Ponte 444', 2, 16, 'KM-840');
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, ID_VIA, ID_UF, DS_LOCAL_VIA) values ('5555555555', 'Ponte 555', 2, 24, 'KM-233');
insert into PONTE (CD_PONTE, DS_IDENTIFICACAO_OBRA, ID_VIA, ID_UF, DS_LOCAL_VIA) values ('6666666666', 'Ponte 666', 3, 24, 'KM-999');

SELECT * FROM VIA;
SELECT * FROM UF;
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
		DT_DATA_ULTIMA_INSPECAO				date			not null,
		ID_PONTE							int				not null,
		ID_SIMULACAO						int				not null,
		CS_CLASSIFICACAO					int				not null,
		DS_INDICE_PERFORMANCE_RELATIVO		varchar(20)		not null,
		CONSTRAINT							pk_ranking		PRIMARY KEY(ID_RANKING),
		CONSTRAINT							fk_ranking_ponte FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT							fk_ranking_simulacao FOREIGN KEY(ID_SIMULACAO) REFERENCES SIMULACAO (ID_SIMULACAO)
	);

insert into RANKING (DT_DATA_ULTIMA_INSPECAO, ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values ('25/05/2016', 1, 1, 1, '1');
insert into RANKING (DT_DATA_ULTIMA_INSPECAO, ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values ('25/05/2016', 2, 1, 2, '2');
insert into RANKING (DT_DATA_ULTIMA_INSPECAO, ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values ('27/05/2016', 3, 3, 3, '3');
insert into RANKING (DT_DATA_ULTIMA_INSPECAO, ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values ('29/05/2016', 4, 1, 4, '4');
insert into RANKING (DT_DATA_ULTIMA_INSPECAO, ID_PONTE, ID_SIMULACAO, CS_CLASSIFICACAO, DS_INDICE_PERFORMANCE_RELATIVO) values ('30/05/2016', 5, 2, 5, '5');
---------------------------------------------------------------------------

--Elemento
create table ELEMENTO
	(
		ID_ELEMENTO		int				not null identity(1,1),
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

--Arquivos anexos cadastro
create table ARQUIVO_ANEXO_CADASTRO
	(
		ID_ARQUIVO_ANEXO_CADASTRO		int						not null identity(1,1),
		DS_ARQUIVO						varchar(20)				not null,
		DS_TIPO_ARQUIVO					varchar(10)				not null,
		NR_NUMERO						varchar(3)				not null,
		DS_DESCRICAO					varchar(20)				not null,
		DS_REGISTRO						varchar(10)				not null,
		DT_DATA_ANEXACAO				date					not null,
		--DS_MINIATURA					
		CONSTRAINT						pk_arquivoanexocadastro	PRIMARY KEY(ID_ARQUIVO_ANEXO_CADASTRO)
	);
GO
insert into ARQUIVO_ANEXO_CADASTRO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('01.jpg', 'Foto', '01', 'Vista geral', 'OAE', '10/05/2016');
insert into ARQUIVO_ANEXO_CADASTRO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('02.jpg', 'Foto', '02', 'Pista rolamento', 'OAE', '11/05/2016');
insert into ARQUIVO_ANEXO_CADASTRO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('03.jpg', 'Foto', '03', 'Vista geral', 'OAE', '12/05/2016');


--Arquivos anexos inspecao
create table ARQUIVO_ANEXO_INSPECAO
	(
		ID_ARQUIVO_ANEXO_INSPECAO		int						not null identity(1,1),
		DS_ARQUIVO						varchar(20)				not null,
		DS_TIPO_ARQUIVO					varchar(10)				not null,
		NR_NUMERO						varchar(3)				not null,
		DS_DESCRICAO					varchar(20)				not null,
		DS_REGISTRO						varchar(10)				not null,
		DT_DATA_ANEXACAO				date					not null,
		--DS_MINIATURA			
		CONSTRAINT						pk_arquivoanexoinspecao	PRIMARY KEY(ID_ARQUIVO_ANEXO_INSPECAO)
	);
GO
insert into ARQUIVO_ANEXO_INSPECAO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('01.jpg', 'Foto', '01', 'Vista geral', 'INS', '13/05/2016');
insert into ARQUIVO_ANEXO_INSPECAO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('02.jpg', 'Foto', '02', 'Pista rolamento', 'INS', '14/05/2016');
insert into ARQUIVO_ANEXO_INSPECAO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('03.jpg', 'Foto', '03', 'Vista geral', 'INS', '15/05/2016');
---------------------------------------------------------------------------




--------------------------------CADASTRO-----------------------------------

--dados basicos
create table IDENTIFICACAO_OBRA_DADOS_BASICOS
	(
		ID_IDENTIFICACAO_OBRA_DADOS_BASICOS		int										not null identity(1, 1),
		CD_CODIGO								varchar(20),
		CD_CODIGO_INTEGRACAO					varchar(20),
		DS_STATUS								varchar(20),
		DS_IDENTIFICACAO						varchar(20),
		DS_NATUREZA_TRANSPOSICAO				varchar(20),
		DS_TIPO_ESTRUTURA						varchar(20),
		DS_SISTEMA_CONSTRUTIVO					varchar(20),
		DS_COMPRIMENTO							varchar(20),
		DS_LARGURA								varchar(20),
		DS_TREM_TIPO							varchar(20),
		DS_ANO_CONSTRUCAO						varchar(20),
		CONSTRAINT								pk_identificacaoobradadosbasicos		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS)
	);
GO
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, DS_NATUREZA_TRANSPOSICAO, 
DS_TIPO_ESTRUTURA, DS_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, DS_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('00', '00', '00', '00', '00', '00', '00', '00', '00', '00', '00');

--localizacao
create table IDENTIFICACAO_OBRA_LOCALIZACAO
	(
		ID_IDENTIFICACAO_OBRA_LOCALIZACAO		int									not null identity(1,1),
		DS_UF									varchar(20),
		DS_VIA									varchar(20),
		DS_LOCAL_VIA							varchar(20),
		DS_CIDADE_MAIS_PROXIMA					varchar(20),
		DS_PNV_ANO								varchar(20),
		DS_PNV_VERSAO							varchar(20),
		DS_PNV_CODIGO							varchar(20),
		DS_PNV_ALTITUDE							varchar(20),
		DS_LATITUDE_GRAU						varchar(20),
		DS_LATITUDE_MINUTO						varchar(20),
		DS_LONGITUDE_GRAU						varchar(20),
		DS_LONGITUDE_MINUTO						varchar(20),
		CONSTRAINT								pk_identificacaoobralocalizacao		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_LOCALIZACAO)
	);
GO
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (DS_UF, DS_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, 
DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values ('00', '00', '00', '00', '00', '00', '00', '00', '00', '00', '00', '00');

--responsaveis
create table IDENTIFICACAO_OBRA_RESPONSAVEIS
	(
		ID_IDENTIFICACAO_OBRA_RESPONSAVEIS		int										not null identity(1,1),
		DS_SUPERINTENDENCIA_REGIONAL			varchar(20),
		DS_UNIDADE_LOCAL						varchar(20),
		DS_TIPO_ADMINISTRACAO					varchar(20),
		DS_ADMINISTRADOR						varchar(20),
		DS_PROJETISTA_ORIGEM					varchar(20),
		DS_PROJETISTA_PROJETISTA				varchar(20),
		DS_CONSTRUTOR_ORIGEM					varchar(20),
		DS_CONSTRUTOR_CONSTRUTOR				varchar(20),
		DS_LOCALIZACAO_PROJETO					varchar(20),
		DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO	varchar(20),
		DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS		varchar(20),
		CONSTRAINT								pk_identificacaoobraresponsaveis		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS)
	);
GO
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (DS_SUPERINTENDENCIA_REGIONAL, DS_UNIDADE_LOCAL, DS_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, 
DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, 
DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) values ('00', '00', '00', '00', '00', '00', '00', '00', '00', '00', '00');

--inspecao
create table IDENTIFICACAO_OBRA_INSPECAO
	(
		ID_IDENTIFICACAO_OBRA_INSPECAO		int									not null identity(1,1),
		DS_PERIODO							varchar(20),
		DS_EQUIPAMENTO_NECESSARIO			varchar(20),
		DS_MELHOR_EPOCA						varchar(20),
		CONSTRAINT							pk_identificacaoobrainspecao		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_INSPECAO)
	);
GO
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('00', '00', '00');


---------------------------------------------------------------------------

--caracteristicas
create table CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS
	(
		ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS		int												not null identity(1,1),
		DS_IDENTIFICACAO									varchar(20),
		DS_TIPO_REGIAO										varchar(20),
		DS_TIPO_TRACADO										varchar(20),
		DS_RAMPA_MAXIMA										varchar(20),
		DS_RAIO_CURVA										varchar(20),
		DS_VMD												varchar(20),
		CONSTRAINT											pk_caracteristicasfuncionaiscaracteristicas		PRIMARY KEY(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS)
	);
GO
insert into CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS (DS_IDENTIFICACAO, DS_TIPO_REGIAO, DS_TIPO_TRACADO, DS_RAMPA_MAXIMA, DS_RAIO_CURVA, DS_VMD) 
values ('00', '00', '00', '00', '00', '00');

--dimensoes
create table CARACTERISTICAS_FUNCIONAIS_DIMENSOES
	(
		ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES			int											not null identity(1,1),
		DS_NUMERO_FAIXAS								varchar(20),
		DS_LARGURA_FAIXA								varchar(20),
		DS_ACOSTAMENTO_DIREITO							varchar(20),
		DS_ACOSTAMENTO_ESQUERDO							varchar(20),
		DS_CALCADA_DIREITA								varchar(20),
		DS_CALCADA_ESQUERDA								varchar(20),
		DS_LARGURA_TOTAL_PISTA							varchar(20),
		DS_GABARITO_HORIZONTAL							varchar(20),
		DS_GABARITO_VERTICAL							varchar(20),
		DS_NUMERO_VAOS									varchar(20),
		DS_DESCRICAO_VAOS								varchar(20),
		CONSTRAINT										pk_caracteristicasfuncionaisdimensoes		PRIMARY KEY(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES)
	);
GO
insert into CARACTERISTICAS_FUNCIONAIS_DIMENSOES (DS_NUMERO_FAIXAS, DS_LARGURA_FAIXA, DS_ACOSTAMENTO_DIREITO, DS_ACOSTAMENTO_ESQUERDO, 
DS_CALCADA_DIREITA, DS_CALCADA_ESQUERDA, DS_LARGURA_TOTAL_PISTA, DS_GABARITO_HORIZONTAL, DS_GABARITO_VERTICAL, DS_NUMERO_VAOS, DS_DESCRICAO_VAOS) 
values ('00', '00', '00', '00', '00', '00', '00', '00', '00', '00', '00');


---------------------------------------------------------------------------

--elementos componentes
--create table ELEMENTOS_COMPONENTES
--	(
--		ID_ELEMENTOS_COMPONENTES		int							not null identity(1,1),
--		DS_IDENTIFICACAO				varchar(20),
--		CD_CODIGO						varchar(20),
--		DS_ELEMENTO						varchar(20),
--		DS_DETALHE						varchar(20),
--		CONSTRAINT						pk_elementoscomponentes		PRIMARY KEY(ID_ELEMENTOS_COMPONENTES)
--	);
--GO
--insert into ELEMENTOS_COMPONENTES (DS_IDENTIFICACAO, CD_CODIGO, DS_ELEMENTO, DS_DETALHE) 
--values ('00', '00', '00', '00');

create table ELEMENTO_COMPONENTES
	(
		ID_PONTE				int						not null identity(1,1),
		CD_CODIGO				varchar(20),
		DS_DETALHE				varchar(20),
		NR_QUANTIDADE			varchar(10),
		CONSTRAINT				pk_elementoscomponentes		PRIMARY KEY(ID_PONTE)
	);
---------------------------------------------------------------------------

--aspectos especiais
create table ASPECTOS_ESPECIAIS
	(
		ID_ASPECTOS_ESPECIAIS			int							not null identity(1,1),
		DS_IDENTIFICACAO				varchar(20),
		CD_CODIGO						varchar(20),
		DS_DESCRICAO					varchar(20),
		DS_SIGLA						varchar(20),
		CONSTRAINT						pk_aspectosespeciais		PRIMARY KEY(ID_ASPECTOS_ESPECIAIS)
	);
GO
insert into ASPECTOS_ESPECIAIS (DS_IDENTIFICACAO, CD_CODIGO, DS_DESCRICAO, DS_SIGLA) 
values ('00', '00', '00', '00');

---------------------------------------------------------------------------

--deficiencias funcionais
create table DEFICIENCIAS_FUNCIONAIS
	(
		ID_DEFICIENCIAS_FUNCIONAIS		int							not null identity(1,1),
		DS_IDENTIFICACAO				varchar(20),
		DS_DEFICIENCIA_FUNCIONAL		varchar(20),
		DS_UNIDADE_MEDIDA				varchar(20),
		CONSTRAINT						pk_deficienciasfuncionais		PRIMARY KEY(ID_DEFICIENCIAS_FUNCIONAIS)
	);
GO
insert into DEFICIENCIAS_FUNCIONAIS (DS_IDENTIFICACAO, DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) 
values ('00', '00', '00');

---------------------------------------------------------------------------

--rotas alternativas
create table ROTAS_ALTERNATIVAS
	(
		ID_ROTAS_ALTERNATIVAS			int							not null identity(1,1),
		DS_IDENTIFICACAO				varchar(20),
		DS_ROTA_ALTERNATIVA				varchar(20),
		DS_ACRESCIMO_KM					varchar(20),
		CONSTRAINT						pk_rotasalternativas		PRIMARY KEY(ID_ROTAS_ALTERNATIVAS)
	);
GO
insert into ROTAS_ALTERNATIVAS (DS_IDENTIFICACAO, DS_ROTA_ALTERNATIVA, DS_ACRESCIMO_KM) 
values ('00', '00', '00');
---------------------------------------------------------------------------

--substituicao
create table SUBSTITUICAO
	(
		ID_SUBSTITUICAO						int					not null identity(1,1),
		DS_IDENTIFICACAO					varchar(20),
		DS_EXISTE_PROJETO_SUBSTITUICAO		varchar(20),
		DS_CUSTO_ESTIMADO					varchar(20),
		DS_OBSERVACOES						varchar(20),
		CONSTRAINT							pk_substituicao		PRIMARY KEY(ID_SUBSTITUICAO)
	);
GO
insert into SUBSTITUICAO (DS_IDENTIFICACAO, DS_EXISTE_PROJETO_SUBSTITUICAO, DS_CUSTO_ESTIMADO, DS_OBSERVACOES) 
values ('00', '00', '00', '00');
---------------------------------------------------------------------------

--observacoes
create table OBSERVACOES
	(
		ID_OBSERVACOES						int					not null identity(1,1),
		DS_IDENTIFICACAO					varchar(20),
		DS_OBSERVACOES						varchar(20),
		CONSTRAINT							pk_observacoes		PRIMARY KEY(ID_OBSERVACOES)
	);
GO
insert into OBSERVACOES (DS_IDENTIFICACAO, DS_OBSERVACOES) 
values ('00', '00');
---------------------------------------------------------------------------

-- Inspeções

create table INSPECOES_MANIFESTACOES
	(
		ID_INSPECOES_MANIFESTACOES				int									not null identity(1,1),
		DS_ELEMENTO								varchar(20),
		DS_NUMERO								varchar(20),
		DS_MANIFESTACAO							varchar(20),
		DS_FOTO									varchar(20),
		DS_TAMANHO								varchar(20),
		DS_EXTENSAO								varchar(20),
		DS_REPARO								varchar(20),
		CONSTRAINT								pk_inspecoesmanifestacoes		PRIMARY KEY(ID_INSPECOES_MANIFESTACOES)
	);
GO
insert into INSPECOES_MANIFESTACOES (DS_ELEMENTO, DS_NUMERO, DS_MANIFESTACAO, DS_FOTO, DS_TAMANHO, 
DS_EXTENSAO, DS_REPARO) 
values ('00', '00', '00', '00', '00', '00', '00');




--MENSAGENS acho que nao vai ser necessario

-- ARQUIVOS ANEXOS tabela ja existe

-- INSPECOES tabela ja existe

---------------------------------------------------------------------------

select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, P.DS_VIA, P.DS_UF, P.DS_LOCAL_VIA, P.ID_SUPERINTENDENCIA_REGIONAL, P.ID_UNIDADE_LOCAL, 
U.ID_UNIDADE_LOCAL, U.DS_UNIDADE_LOCAL, U.ID_SUPERINTENDENCIA_REGIONAL,  
S.ID_SUPERINTENDENCIA_REGIONAL
from PONTE P, UNIDADE_LOCAL U, SUPERINTENDENCIA_REGIONAL S 
where P.ID_UNIDADE_LOCAL = U.ID_UNIDADE_LOCAL 
and P.ID_SUPERINTENDENCIA_REGIONAL = S.ID_SUPERINTENDENCIA_REGIONAL
and P.ID_SUPERINTENDENCIA_REGIONAL = U.ID_SUPERINTENDENCIA_REGIONAL

and P.CD_PONTE = '111111111'
and P.DS_IDENTIFICACAO_OBRA = null;


select * from SUPERINTENDENCIA_REGIONAL;

select P.ID_PONTE, P.CD_PONTE, P.DS_IDENTIFICACAO_OBRA, P.ID_VIA,
P.ID_UF, P.DS_LOCAL_VIA, P.ID_SUPERINTENDENCIA_REGIONAL, P.ID_UNIDADE_LOCAL,
U.ID_UNIDADE_LOCAL, U.DS_UNIDADE_LOCAL, U.ID_SUPERINTENDENCIA_REGIONAL,
S.ID_SUPERINTENDENCIA_REGIONAL, S.DS_SUPERINTENDENCIA_REGIONAL, S.ID_UF 
from PONTE P, UNIDADE_LOCAL U, SUPERINTENDENCIA_REGIONAL S 
where P.ID_UNIDADE_LOCAL = U.ID_UNIDADE_LOCAL 
and P.ID_SUPERINTENDENCIA_REGIONAL = S.ID_SUPERINTENDENCIA_REGIONAL
and P.CD_PONTE like '%111111111%'
and P.DS_IDENTIFICACAO_OBRA like '%1%'
and P.ID_UF = 14
and S.ID_UF = P.ID_UF

--<!--                                        <f:selectItems value="#{ponte.ufs}" var="t" itemValue="#{t.id}" />-->    value="#{ponte.model.uf.id}"