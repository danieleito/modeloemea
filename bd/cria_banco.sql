create database EMEA;
GO
use EMEA;
GO
---------------------------------------------------------------------------

create table TIPO_USUARIO
	(
		ID_TIPO_USUARIO		INT				not null identity(1,1),
		DS_TIPO				varchar(20)		not null,
		CONSTRAINT			pk_tipausuario	PRIMARY KEY(ID_TIPO_USUARIO)
	);
GO
insert into TIPO_USUARIO (DS_TIPO) values ('Administrador');
insert into TIPO_USUARIO (DS_TIPO) values ('Usu�rio comum');
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
insert into UF (DS_UF) values ('Amap�');
insert into UF (DS_UF) values ('Amazonas');
insert into UF (DS_UF) values ('Bahia');
insert into UF (DS_UF) values ('Cear�');
insert into UF (DS_UF) values ('Distrito Federal');
insert into UF (DS_UF) values ('Esp�rito Santo');
insert into UF (DS_UF) values ('Goi�s');
insert into UF (DS_UF) values ('Maranh�o');
insert into UF (DS_UF) values ('Mato Grosso');
insert into UF (DS_UF) values ('Mato Grosso do Sul');
insert into UF (DS_UF) values ('Minas Gerais');
insert into UF (DS_UF) values ('Par�');
insert into UF (DS_UF) values ('Para�ba');
insert into UF (DS_UF) values ('Paran�');
insert into UF (DS_UF) values ('Pernambuco');
insert into UF (DS_UF) values ('Piau�');
insert into UF (DS_UF) values ('Rio de Janeiro');
insert into UF (DS_UF) values ('Rio Grande do Norte');
insert into UF (DS_UF) values ('Rio Grande do Sul');
insert into UF (DS_UF) values ('Rond�nia');
insert into UF (DS_UF) values ('Roraima');
insert into UF (DS_UF) values ('Santa Catarina');
insert into UF (DS_UF) values ('S�o Paulo');
insert into UF (DS_UF) values ('Sergipe');
insert into UF (DS_UF) values ('Tocantins');

---------------------------------------------------------------------------
--Via
create table VIA
	(
		ID_VIA			int				not null identity(1,1),
		DS_VIA			varchar(10)		not null,
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

insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RR - Superintend�ncia Regional do DNIT no estado de Roraima', 23);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - AL - Superintend�ncia Regional do DNIT no estado de Alagoas', 2);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - AM - Superintend�ncia Regional do DNIT no estado de Amazonas', 4);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - BA - Superintend�ncia Regional do DNIT no estado da Bahia', 5);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - CE - Superintend�ncia Regional do DNIT no estado do Cear�', 6);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - ES - Superintend�ncia Regional do DNIT no estado do Esp�rito Santo', 8);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - GO - Superintend�ncia Regional do DNIT no estado de Goi�s e Distrito Federal', 7);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - MA - Superintend�ncia Regional do DNIT no estado do Maranh�o', 10);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - MT - Superintend�ncia Regional do DNIT no estado do Mato Grosso', 11);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - MS - Superintend�ncia Regional do DNIT no estado do Mato Grosso do Sul', 12);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - MG - Superintend�ncia Regional do DNIT no estado de Minas Gerais', 13);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PA - Superintend�ncia Regional do DNIT no estado do Par�', 14);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PB - Superintend�ncia Regional do DNIT no estado de Para�ba', 15);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PR - Superintend�ncia Regional do DNIT no estado do Paran�', 16);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PE - Superintend�ncia Regional do DNIT no estado de Pernambuco', 17);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PI - Superintend�ncia Regional do DNIT no estado do Piau�', 18);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RJ - Superintend�ncia Regional do DNIT no estado do Rio de Janeiro', 19);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RN - Superintend�ncia Regional do DNIT no estado do Rio Grande do Norte', 20);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RS - Superintend�ncia Regional do DNIT no estado do Rio Grande do Sul', 21);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - RO - Superintend�ncia Regional do DNIT no estado de Rond�nia e Acre', 22);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - SC - Superintend�ncia Regional do DNIT no estado de Santa Catarina', 24);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - SP - Superintend�ncia Regional do DNIT no estado de S�o Paulo', 25);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - SE - Superintend�ncia Regional do DNIT no estado de Sergipe', 26);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - TO - Superintend�ncia Regional do DNIT no estado do Tocantins', 27);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - AP - Superintend�ncia Regional do DNIT no estado do Amap�', 3);

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
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR02 - Campo Mour�o', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR03 - Laranjeiras do Sul', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR04 - Ponta Grossa', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR05 - Foz do Igua�u', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR06 - S�o Jos� dos Pinhais', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULPR07 - Londrina', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('PROFE-PR Procuradoria Federal Especializada SRE-PR', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('UL P. Branco/PR - Unidade local em Pato Branco/PR', 14);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC01 - Tubar�o', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC02 - Joinville', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC03 - Lages', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC04 - Joa�aba', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC05 - Mafra', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC08 - Chapec�', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC09 - Florian�polis', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC07 - Rio do Sul', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC06 - S�o Jos�', 21);
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('ULSC09 - vago', 21);
---------------------------------------------------------------------------

--Simula��o
create table SIMULACAO
	(
		ID_SIMULACAO	int						not null identity(1,1),
		DT_DATA			date					not null,
		ID_USUARIO		int						not null,
		NM_SIMULACAO	varchar(100)			not null,
		CONSTRAINT		pk_simulacao			PRIMARY KEY(ID_SIMULACAO),
		CONSTRAINT		fk_simulacao_usuario	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
	);

insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('28/04/2016', 1, 'simula��o 1');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('30/04/2016', 1, 'simula��o 2');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('01/05/2016', 1, 'simula��o 3');
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

--Arquivos anexos cadastro
create table ARQUIVO_ANEXO_CADASTRO
	(
		ID_ARQUIVO_ANEXO_CADASTRO		int				not null identity(1,1),
		DS_ARQUIVO				varchar(20)		not null,
		DS_TIPO_ARQUIVO			varchar(10)		not null,
		NR_NUMERO				varchar(3)		not null,
		DS_DESCRICAO			varchar(20)		not null,
		DS_REGISTRO				varchar(10)		not null,
		DT_DATA_ANEXACAO		date			not null,
		--DS_MINIATURA			
		CONSTRAINT				pk_arquivoanexocadastro	PRIMARY KEY(ID_ARQUIVO_ANEXO_CADASTRO)
	);
GO
insert into ARQUIVO_ANEXO_CADASTRO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('01.jpg', 'Foto', '01', 'Vista geral', 'OAE', '10/05/2016');
insert into ARQUIVO_ANEXO_CADASTRO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('02.jpg', 'Foto', '02', 'Pista rolamento', 'OAE', '11/05/2016');
insert into ARQUIVO_ANEXO_CADASTRO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('03.jpg', 'Foto', '03', 'Vista geral', 'OAE', '12/05/2016');


--Arquivos anexos inspecao
create table ARQUIVO_ANEXO_INSPECAO
	(
		ID_ARQUIVO_ANEXO_INSPECAO		int				not null identity(1,1),
		DS_ARQUIVO						varchar(20)		not null,
		DS_TIPO_ARQUIVO					varchar(10)		not null,
		NR_NUMERO						varchar(3)		not null,
		DS_DESCRICAO					varchar(20)		not null,
		DS_REGISTRO						varchar(10)		not null,
		DT_DATA_ANEXACAO				date			not null,
		--DS_MINIATURA			
		CONSTRAINT						pk_arquivoanexoinspecao	PRIMARY KEY(ID_ARQUIVO_ANEXO_INSPECAO)
	);
GO
insert into ARQUIVO_ANEXO_INSPECAO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('01.jpg', 'Foto', '01', 'Vista geral', 'INS', '13/05/2016');
insert into ARQUIVO_ANEXO_INSPECAO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('02.jpg', 'Foto', '02', 'Pista rolamento', 'INS', '14/05/2016');
insert into ARQUIVO_ANEXO_INSPECAO (DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO) values ('03.jpg', 'Foto', '03', 'Vista geral', 'INS', '15/05/2016');
---------------------------------------------------------------------------




--------------------------------DADOS PARA PREENCHIMENTO CADASTRO-----------------------------------
--Natureza de transposi��o

create table NATUREZA_TRANSPOSICAO
	(
		ID_NATUREZA_TRANSPOSICAO			int								not null identity(1,1),
		DS_NATUREZA_TRANSPOSICAO			varchar(50)						not null,
		CONSTRAINT							pk_naturezatransposicao			PRIMARY KEY(ID_NATUREZA_TRANSPOSICAO)
	);

GO
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Ponte');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Pontilh�o');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto de transposi��o de rodovia');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto sobre ferrovia');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto sobre rodovia / rua');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto em encosta');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Passagem inferior');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Passarela de pedestres');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('N�o informado');

--Tipo de estrutura

create table TIPO_ESTRUTURA
	(
		ID_TIPO_ESTRUTURA			int				not null identity(1,1),
		DS_TIPO_ESTRUTURA		varchar(50)		not null,
		CONSTRAINT		pk_tipoestrutura			PRIMARY KEY(ID_TIPO_ESTRUTURA)
	);

GO
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga Caix�o Concreto Armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga Caix�o Concreto Protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga de concreto armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga de concreto protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga e laje met�licas');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Mista (viga metal e laje concreto)');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco inferior de concreto armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco inferior de concreto protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco inferior met�lico');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco superior de concreto armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco superior de concreto protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco superior met�lico');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco de alvenaria de pedra');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Treli�a met�lica');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Laje de concreto armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Laje de concreto protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Madeira');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Estaiada com vigamento met�lico');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Estaiada com vigamento c. protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('P�nsil');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('N�o informado');

--Sistema Construtivo

create table SISTEMA_CONSTRUTIVO
	(
		ID_SISTEMA_CONSTRUTIVO			int						not null identity(1,1),
		DS_SISTEMA_CONSTRUTIVO			varchar(50)				not null,
		CONSTRAINT						pk_sistemaconstrutivo	PRIMARY KEY(ID_SISTEMA_CONSTRUTIVO)
	);

GO
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Moldado no local');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Pr�-moldado de concreto armado');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Pr�-moldado protendido (p�s-tens�o)');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Pr�-moldado protendido (pr�-tens�o)');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Balan�os progressivos c/ continuidade');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Balan�os progressivos c/ articula��es');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Aduelas pr�-moldadas');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Viga calha pr�-moldada (Sist prot�tipo)');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Ponte empurrada');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Estaiado em avan�os progressivos');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('N�o informado');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Treli�a met�lica');

--Trem-tipo

create table TREM_TIPO
	(
		ID_TREM_TIPO			int				not null identity(1,1),
		DS_TREM_TIPO			varchar(30)		not null,
		CONSTRAINT				pk_tremtipo		PRIMARY KEY(ID_TREM_TIPO)
	);

GO
insert into TREM_TIPO (DS_TREM_TIPO) values ('Classe 0');
insert into TREM_TIPO (DS_TREM_TIPO) values ('Classe 24');
insert into TREM_TIPO (DS_TREM_TIPO) values ('Classe 36');
insert into TREM_TIPO (DS_TREM_TIPO) values ('Classe 45');

--Tipo de regi�o

create table TIPO_REGIAO
	(
		ID_TIPO_REGIAO			int				not null identity(1,1),
		DS_TIPO_REGIAO		varchar(30)		not null,
		CONSTRAINT		pk_tiporegiao			PRIMARY KEY(ID_TIPO_REGIAO)
	);

GO
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Plana');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Ondulada');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Montanhosa');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('N�o informado');

--Tipo de tra�ado

create table TIPO_TRACADO
	(
		ID_TIPO_TRACADO			int				not null identity(1,1),
		DS_TIPO_TRACADO		varchar(30)		not null,
		CONSTRAINT		pk_tipotracado			PRIMARY KEY(ID_TIPO_TRACADO)
	);

GO
insert into TIPO_TRACADO	 (DS_TIPO_TRACADO) values ('Tangente');
insert into TIPO_TRACADO	 (DS_TIPO_TRACADO) values ('Curva');
insert into TIPO_TRACADO	 (DS_TIPO_TRACADO) values ('N�o informado');

--Tipo de administra��o

create table TIPO_ADMINISTRACAO
	(
		ID_TIPO_ADMINISTRACAO			int						not null identity(1,1),
		DS_TIPO_ADMINISTRACAO			varchar(30)				not null,
		CONSTRAINT						pk_tipoadministracao	PRIMARY KEY(ID_TIPO_ADMINISTRACAO)
	);

GO
insert into TIPO_ADMINISTRACAO	 (DS_TIPO_ADMINISTRACAO) values ('Administra��o Direta');
insert into TIPO_ADMINISTRACAO	 (DS_TIPO_ADMINISTRACAO) values ('Administra��o Indireta');



--------------------------------CADASTRO-----------------------------------
--dados basicos
create table IDENTIFICACAO_OBRA_DADOS_BASICOS
	(
		ID_IDENTIFICACAO_OBRA_DADOS_BASICOS		int														not null identity(1, 1),
		CD_CODIGO								varchar(20),
		CD_CODIGO_INTEGRACAO					varchar(20),
		DS_STATUS								varchar(20),
		DS_IDENTIFICACAO						varchar(50),
		ID_NATUREZA_TRANSPOSICAO				int,	
		ID_TIPO_ESTRUTURA						int,
		ID_SISTEMA_CONSTRUTIVO					int,
		DS_COMPRIMENTO							varchar(20),
		DS_LARGURA								varchar(20),
		ID_TREM_TIPO							int,
		DS_ANO_CONSTRUCAO						varchar(20),
		CONSTRAINT								pk_identificacaoobradadosbasicos						PRIMARY KEY(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS),
		CONSTRAINT								fk_identificacaoobradadosbasicos_naturezatransposicao	FOREIGN KEY(ID_NATUREZA_TRANSPOSICAO) REFERENCES NATUREZA_TRANSPOSICAO(ID_NATUREZA_TRANSPOSICAO),
		CONSTRAINT								fk_identificacaoobradadosbasicos_tipoestrutura			FOREIGN KEY(ID_TIPO_ESTRUTURA) REFERENCES TIPO_ESTRUTURA(ID_TIPO_ESTRUTURA),
		CONSTRAINT								fk_identificacaoobradadosbasicos_sistemaconstrutivo		FOREIGN KEY(ID_SISTEMA_CONSTRUTIVO) REFERENCES SISTEMA_CONSTRUTIVO(ID_SISTEMA_CONSTRUTIVO),
		CONSTRAINT								fk_identificacaoobradadosbasicos_tremtipo				FOREIGN KEY(ID_TREM_TIPO) REFERENCES TREM_TIPO(ID_TREM_TIPO)
	);
GO
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('01', '11', '55', 'Ponte 01', 1, 1, 3, '00', '00', 1, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('02', '22', '66', 'Ponte 02', 2, 3, 2, '00', '00', 2, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('03', '33', '77', 'Ponte 03', 3, 2, 5, '00', '00', 3, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('04', '44', '88', 'Ponte 04', 4, 5, 3, '00', '00', 2, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('05', '55', '99', 'Ponte 05', 5, 4, 1, '00', '00', 4, '00');

--localizacao
create table IDENTIFICACAO_OBRA_LOCALIZACAO
	(
		ID_IDENTIFICACAO_OBRA_LOCALIZACAO		int										not null identity(1,1),
		ID_UF									int,
		ID_VIA									int,
		DS_LOCAL_VIA							real,
		DS_CIDADE_MAIS_PROXIMA					varchar(40),
		DS_PNV_ANO								varchar(20),
		DS_PNV_VERSAO							varchar(20),
		DS_PNV_CODIGO							varchar(40),
		DS_PNV_ALTITUDE							varchar(20),
		DS_LATITUDE_GRAU						varchar(20),
		DS_LATITUDE_MINUTO						varchar(20),
		DS_LONGITUDE_GRAU						varchar(20),
		DS_LONGITUDE_MINUTO						varchar(20),
		CONSTRAINT								pk_identificacaoobralocalizacao			PRIMARY KEY(ID_IDENTIFICACAO_OBRA_LOCALIZACAO),
		CONSTRAINT								fk_identificacaoobralocalizacao_uf		FOREIGN KEY(ID_UF) REFERENCES UF(ID_UF),
		CONSTRAINT								fk_identificacaoobralocalizacao_via		FOREIGN KEY(ID_VIA) REFERENCES VIA(ID_VIA)
	);
GO
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, 
DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (1, 1, 10.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');

insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, 
DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (2, 2, 20.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');

insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, 
DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (3, 3, 30.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');

insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, 
DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (4, 4, 40.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');

insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, 
DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (5, 5, 50.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');

--responsaveis
create table IDENTIFICACAO_OBRA_RESPONSAVEIS
	(
		ID_IDENTIFICACAO_OBRA_RESPONSAVEIS		int					not null identity(1,1),
		ID_UNIDADE_LOCAL						int,
		ID_TIPO_ADMINISTRACAO					int,
		DS_ADMINISTRADOR						varchar(80),
		DS_PROJETISTA_ORIGEM					varchar(80),
		DS_PROJETISTA_PROJETISTA				varchar(80),
		DS_CONSTRUTOR_ORIGEM					varchar(80),
		DS_CONSTRUTOR_CONSTRUTOR				varchar(80),
		DS_LOCALIZACAO_PROJETO					varchar(80),
		DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO	varchar(80),
		DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS		varchar(80),
		CONSTRAINT								pk_identificacaoobraresponsaveis								PRIMARY KEY(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS),
		CONSTRAINT								fk_identificacaoobraresponsaveis_unidadelocal					FOREIGN KEY(ID_UNIDADE_LOCAL) REFERENCES UNIDADE_LOCAL(ID_UNIDADE_LOCAL),
		CONSTRAINT								fk_identificacaoobraresponsaveis_tipoadministracao				FOREIGN KEY(ID_TIPO_ADMINISTRACAO) REFERENCES TIPO_ADMINISTRACAO(ID_TIPO_ADMINISTRACAO)
	);
GO
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, 
DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, 
DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) values (1, 1, 'Jo�o', 'Jos�', 'Junior', 'Joaquim', 'Jean', 'Local 01', 'Local 01', 'Local 01');

insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, 
DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, 
DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) values (2, 2, 'Pristorius', 'Philco', 'Phill', 'Pedro', 'Paulo', 'Local 2', 'Local 2', 'Local 2');

insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, 
DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, 
DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) values (3, 1, 'Fernando', 'Francisco', 'Fabr�cio', 'Frei', 'Faissal', 'Local 3', 'Local 3', 'Local 3');

insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, 
DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, 
DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) values (4, 2, 'Mitiko', 'Milena', 'Miriam', 'Michelle', 'Mirelle', 'Local 4', 'Local 4', 'Local 4');

insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, 
DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, 
DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) values (5, 1, 'Daniele', 'Daniele', 'Daniele', 'Daniele', 'Daniele', 'Local 5', 'Local 5', 'Local 5');

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
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('01', '01', '01');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('02', '02', '02');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('03', '03', '03');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('04', '04', '04');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('05', '05', '05');

---------------------------------------------------------------------------

--caracteristicas
create table CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS
	(
		ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS		int															not null identity(1,1),
		ID_TIPO_REGIAO										int,
		ID_TIPO_TRACADO										int,
		DS_RAMPA_MAXIMA										varchar(20),
		DS_RAIO_CURVA										varchar(20),
		DS_VMD												varchar(20),
		CONSTRAINT											pk_caracteristicasfuncionaiscaracteristicas					PRIMARY KEY(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS),
		CONSTRAINT											fk_caracteristicasfuncionaiscaracteristicas_tiporegiao		FOREIGN KEY(ID_TIPO_REGIAO) REFERENCES TIPO_REGIAO(ID_TIPO_REGIAO),
		CONSTRAINT											fk_caracteristicasfuncionaiscaracteristicas_tipotracado		FOREIGN KEY(ID_TIPO_TRACADO) REFERENCES TIPO_TRACADO(ID_TIPO_TRACADO)
	);
GO
insert into CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS (ID_TIPO_REGIAO, ID_TIPO_TRACADO, DS_RAMPA_MAXIMA, DS_RAIO_CURVA, DS_VMD) 
values (1, 1, '00', '00', '00');

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
		DS_DESCRICAO_VAOS								varchar(80),
		CONSTRAINT										pk_caracteristicasfuncionaisdimensoes		PRIMARY KEY(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES)
	);
GO
insert into CARACTERISTICAS_FUNCIONAIS_DIMENSOES (DS_NUMERO_FAIXAS, DS_LARGURA_FAIXA, DS_ACOSTAMENTO_DIREITO, DS_ACOSTAMENTO_ESQUERDO, 
DS_CALCADA_DIREITA, DS_CALCADA_ESQUERDA, DS_LARGURA_TOTAL_PISTA, DS_GABARITO_HORIZONTAL, DS_GABARITO_VERTICAL, DS_NUMERO_VAOS, DS_DESCRICAO_VAOS) 
values ('00', '00', '00', '00', '00', '00', '00', '00', '00', '00', '00');


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

-- Manifesta��es extens�o
create table MANIFESTACOES_EXTENSAO
	(
		ID_MANIFESTACOES_EXTENSAO						int							not null identity(1,1),
		DS_MANIFESTACOES_EXTENSAO						varchar(80),
		DS_CRITERIO_MANIFESTACOES_EXTENSAO				varchar(200),
		DS_CAPA2										varchar(10),

		CONSTRAINT						pk_manifestacoesextensao		PRIMARY KEY(ID_MANIFESTACOES_EXTENSAO)
	);
GO
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Insignificante','Dano irrelevante','0');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Pequena','Dano de tamanho pequeno, em menos de 10% da �rea','0,5');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('M�dia ','Dano de tamanho m�dio, confinado em uma �rea pequena 10% a 25% da �rea total do elemento','1');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Grande','Dano em �rea grande de 25% a 75%, ou em muitos lugares de um elemento estrutural','1,5');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Imensa','Danos muito grandes na maior parte da �rea de um elemento, mais de 75%','2');

---------------------------------------------------------------------------

-- Manifesta��es extens�o
create table MANIFESTACOES_URGENCIA
	(
		ID_MANIFESTACOES_URGENCIA						int							not null identity(1,1),
		DS_MANIFESTACOES_URGENCIA						varchar(80),
		DS_CRITERIO_MANIFESTACOES_URGENCIA				varchar(200),
		DS_CAPA4										varchar(10),

		CONSTRAINT						pk_manifestacoesurgencia		PRIMARY KEY(ID_MANIFESTACOES_URGENCIA)
	);
GO
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('N�o urgente','Interven��o n�o � urgente pois o dano n�o interfere na utiliza��o e capacidade da ponte, e tamb�m n�o altera a sua durabilidade','1');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Dano � reparar','Dano deve ser reparado em per�odo n�o maior que 5 anos, para garantir a servicibilidade e n�o comprometer a durabilidade da OAE','2,5');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Reparo imediato','Reparo imediato, pois o dano j� est� comprometendo a utiliza��o da OAE, com risco �s pessoas','4');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Limita��o de carga','Limita��o de carga, interrup��o de tr�fego e escoramento imediato deve ser feito, al�m do reparo','5');

---------------------------------------------------------------------------

-- Manifesta��es extens�o
create table MANIFESTACOES_REPETICAO
	(
		ID_MANIFESTACOES_REPETICAO						int							not null identity(1,1),
		DS_CRITERIO_MANIFESTACOES_REPETICAO				varchar(200),
		DS_LIMITESUPERIOR								varchar(10),
		DS_CAPA3										varchar(10),

		CONSTRAINT						pk_manifestacoesrepeticao		PRIMARY KEY(ID_MANIFESTACOES_REPETICAO)
	);
GO
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano � aparece em menos de 10% dos elementos estruturais da OAE','0,1','0,5');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 10% e 25% dos elementos estruturais da OAE','0,25','1');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 25% e 75% dos elementos estruturais da OAE','0,75','1,5');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 75% e 100% dos elementos estruturais da OAE','1','2');

---------------------------------------------------------------------------
-- ponte
create table PONTE
	(
		ID_PONTE										int													not null identity(1,1),
		DS_INDICE_PERFORMANCE_RELATIVO					varchar(20)											null,
		ID_IDENTIFICACAO_OBRA_DADOS_BASICOS				int													not null,	
		ID_IDENTIFICACAO_OBRA_LOCALIZACAO				int													not null,
		ID_IDENTIFICACAO_OBRA_RESPONSAVEIS				int													not null,
		ID_IDENTIFICACAO_OBRA_INSPECAO					int													not null,
		ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS	int													not null,
		ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES			int													not null,
		ID_ROTAS_ALTERNATIVAS							int													not null,
		CONSTRAINT										pk_ponte											PRIMARY KEY(ID_PONTE), 
		CONSTRAINT										fk_ponte_identificacaoobradadosbasicos				FOREIGN KEY(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS) REFERENCES IDENTIFICACAO_OBRA_DADOS_BASICOS(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS),
		CONSTRAINT										fk_ponte_identificacaoobralocalizacao				FOREIGN KEY(ID_IDENTIFICACAO_OBRA_LOCALIZACAO) REFERENCES IDENTIFICACAO_OBRA_LOCALIZACAO(ID_IDENTIFICACAO_OBRA_LOCALIZACAO),
		CONSTRAINT										fk_ponte_identificacaoobraresponsaveis				FOREIGN KEY(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS) REFERENCES IDENTIFICACAO_OBRA_RESPONSAVEIS(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS),
		CONSTRAINT										fk_ponte_identificacaoobrainspecao					FOREIGN KEY(ID_IDENTIFICACAO_OBRA_INSPECAO) REFERENCES IDENTIFICACAO_OBRA_INSPECAO(ID_IDENTIFICACAO_OBRA_INSPECAO),
		CONSTRAINT										fk_ponte_caracteristicasfuncionaiscaracteristicas	FOREIGN KEY(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS) REFERENCES CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS),
		CONSTRAINT										fk_ponte_caracteristicasfuncionaisdimensoes			FOREIGN KEY(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES) REFERENCES CARACTERISTICAS_FUNCIONAIS_DIMENSOES(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES),
		CONSTRAINT										fk_ponte_rotasalternativas							FOREIGN KEY(ID_ROTAS_ALTERNATIVAS) REFERENCES ROTAS_ALTERNATIVAS(ID_ROTAS_ALTERNATIVAS)
	);

GO
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS) values (1, 1, 1, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS) values (4, 2, 2, 2, 2, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS) values (2, 3, 3, 3, 3, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS) values (5, 4, 4, 4, 4, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS) values (3, 5, 5, 5, 5, 1, 1, 1);

---------------------------------------------------------------------------
--deficiencias funcionais
create table DEFICIENCIAS_FUNCIONAIS
	(
		ID_DEFICIENCIAS_FUNCIONAIS		int							not null identity(1,1),
		ID_PONTE						int							not null,
		CD_DEFICIENCIA_FUNCIONAL		varchar(20),
		DS_DEFICIENCIA_FUNCIONAL		varchar(80),
		DS_UNIDADE_MEDIDA				varchar(20),
		CONSTRAINT						pk_deficienciasfuncionais		PRIMARY KEY(ID_DEFICIENCIAS_FUNCIONAIS),
		CONSTRAINT						fk_deficienciasfuncionais_ponte		FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE)
	);
	
GO
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('1', 'Ponte estreita (larg pista < 7,20m)', 'm - Metro', 1);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('2', 'Ponte sem acostamento','m - Metro', 2);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('3', 'Cal�ada para pedestres inexistente','m - Metro', 3);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('4', 'Pingadeira inexistente','m - Metro', 3);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('5', 'Drenagem de pista insuficiente','un - Unidade', 4);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('6', 'Guarda-rodas obsoleto','m - Metro', 1);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('7', 'Se��o hidra�lica (greide baixo)','m - Metro', 2);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('8', 'Se��o hidra�lica (ponte curta)','m - Metro', 4);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('9', 'Concord�ncia vertical ruim','un - Unidade', 3);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('10', 'Concord�ncia horizontal ruim','un - Unidade', 5);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('11', 'Capacidade de carga limitada','tf', 3);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('12', 'Gabarito vertical sobre via urbana insuficiente','m - Metro', 1);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('13', 'Gabarito vertical sobre rodovia insuficiente','m - Metro', 4);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('14', 'Gabarito horizontal insuficiente','m - Metro', 5);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('15', 'Gabarito vertical de navega��o insuficiente','m - Metro', 1);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('16', 'Gabarito vertical sobre ferrovia insuficiente','m - Metro', 2);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('17', 'Pilar em canal de navega��o sem prote��o','un - Unidade', 4);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('18', 'Al�a de acesso inadequada','un - Unidade', 4);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('19', 'Ponte muito estreita (em m�o �nica)','m - Metro', 5);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('22', 'Trem tipo de c�lculo TB 24tf','tf', 2);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('23', 'Trem tipo de c�lculo TB 36tf','tf', 5);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('24', 'Junta longitudinal de dilata��o','un - Unidade', 1);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('25', 'Viga caix�o com interior inacess�vel','un - Unidade', 3);
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA, ID_PONTE) values ('26', 'Aparelho de apoio n�o identificado','kg - Quilograma', 2);



---------------------------------------------------------------------------

--aspectos especiais
create table ASPECTOS_ESPECIAIS
	(
		ID_ASPECTOS_ESPECIAIS				int							not null identity(1,1),
		DS_ASPECTOS_ESPECIAIS				varchar(80),
		ID_PONTE							int							not null,

		CONSTRAINT						pk_aspectosespeciais		PRIMARY KEY(ID_ASPECTOS_ESPECIAIS),
		CONSTRAINT						fk_aspectosespeciais_ponte		FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE)
	);
GO
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS, ID_PONTE) values ('Meio ambiente agressivo', 1);
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS, ID_PONTE) values ('N�vel de vibra��o elevado', 3);
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS, ID_PONTE) values ('Leito do rio erod�vel', 2);
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS, ID_PONTE) values ('Funda��o em solo mole', 1);
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS, ID_PONTE) values ('Frequ�ncia elevada de carga pesada', 4);
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS, ID_PONTE) values ('Desn�vel elevado entre greide e terreno', 2);
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS, ID_PONTE) values ('Rio com l�mina d�gua normal profunda', 3);
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS, ID_PONTE) values ('Grande varia��o do NA do rio na cheia', 5);

---------------------------------------------------------------------------

create table CADASTRO_ASPECTOS_ESPECIAIS
	(
		ID_CADASTRO_ASPECTOS_ESPECIAIS			int						not null identity(1,1),
		ID_PONTE								int,
		ID_ASPECTOS_ESPECIAIS					int,
		
		CONSTRAINT				pk_cadastroaspectosespeciais		PRIMARY KEY(ID_CADASTRO_ASPECTOS_ESPECIAIS),
		CONSTRAINT				fk_cadastroaspectosespeciais_ponte	FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT				fk_cadastroaspectosespeciais_aspectosespeciais	FOREIGN KEY(ID_ASPECTOS_ESPECIAIS) REFERENCES ASPECTOS_ESPECIAIS(ID_ASPECTOS_ESPECIAIS)
	);
---------------------------------------------------------------------------

--Ranking
create table RANKING
	(
		ID_RANKING							int						not null identity(1,1),
		ID_PONTE							int						not null,
		ID_SIMULACAO						int						not null,
		CONSTRAINT							pk_ranking				PRIMARY KEY(ID_RANKING),
		CONSTRAINT							fk_ranking_ponte		FOREIGN KEY(ID_PONTE) REFERENCES PONTE (ID_PONTE),
		CONSTRAINT							fk_ranking_simulacao	FOREIGN KEY(ID_SIMULACAO) REFERENCES SIMULACAO (ID_SIMULACAO)
	);

--insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 1);
--insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 1);
--insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 3);
--insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 1);
--insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 2);

---------------------------------------------------------------------------

--modelo
create table MODELO
	(
		ID_MODELO				int			not null identity(1,1),
		DS_INDICE_BASE			varchar(20)	not null,
		DS_INDICE_PERFORMANCE	varchar(20) null,
		CONSTRAINT				pk_modelo	PRIMARY KEY(ID_MODELO)

	);
---------------------------------------------------------------------------

--Inspecoes
create table INSPECAO
	(
		ID_INSPECAO					int						not null identity(1,1),
		DT_DATA						date					not null,
		ID_USUARIO					int						not null,
		ID_PONTE					int						not null,
		ID_MODELO					int						not null,
		CONSTRAINT					pk_inspecao				PRIMARY KEY(ID_INSPECAO),
		CONSTRAINT					fk_inspecao_usuario		FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID_USUARIO),
		CONSTRAINT					fk_inspecao_ponte		FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT					fk_inspecao_modelo		FOREIGN KEY(ID_MODELO) REFERENCES MODELO(ID_MODELO)
	);

---------------------------------------------------------------------------
create table ELEMENTOS_UFPR
	(
		ID_ELEMENTO_UFPR		int						not null identity(1,1),
		CD_ELEMENTO				int,
		DS_ELEMENTO				varchar(100),
		DS_CAPA1				varchar(10)				not null,
		ID_PONTE				int						not null, 
		CONSTRAINT				pk_elementosufpr		PRIMARY KEY(ID_ELEMENTO_UFPR),
		CONSTRAINT				fk_elementosufpr_ponte		FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE)
	);
GO
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '1', 'Laje de concreto armado','0,4', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '2', 'Laje de Concreto Protendido','0,4', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '3', 'Laje Met�lica Ortotr�pica','0,4', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '4', 'Laje Met�lica de Chapa Corrugada','0,4', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '7', 'Laje em Pranch�o de Madeira','0,4', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '5', 'Ponte em Laje de Concreto Armado','0,6', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '6', 'Ponte em Laje de Concreto Protendido','0,6', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '204', 'Travessa de apoio de concreto armado','0,4', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '205', 'Travessa de apoio de concreto protendido','0,4', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '104', 'Viga T ou I de concreto armado','0,6', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '105', 'Viga T ou I de concreto protendido','0,6', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '106', 'Viga I met�lica','0,6', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '101', 'Viga Caix�o de Concreto Armado','0,6', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '102', 'Viga Caix�o de Concreto Protendido','0,6', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '103', 'Viga Caix�o Met�lica','0,6', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '206', 'Viga de contraventamento de pilar de concreto armado','0,4', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '109', 'Transversina Portante de Concreto Armado','0,3', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '110', 'Transversina Portante de Concreto Protendido','0,3', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '111', 'Transversina Portante Met�lica','0,3', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '112', 'Transversina de Liga��o de Concreto Armado','0,2', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '113', 'Transversina de Liga��o de Concreto Protendido','0,2', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '114', 'Transversina de Liga��o Met�lica','0,2', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '202', 'Pilar em Colunas de Concreto Armado','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '201', 'Pilar Parede de Concreto Armado','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '203', 'Pilar Vazado de Concreto Armado','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '200', 'Pilar Parede de Alvenaria de Pedra','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '207', 'Parede de contraventamento de pilar de concreto armado','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '301', 'Aparelho de Apoio de Neoprene Fretado','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '302', 'Aparelho de Apoio de Teflon','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '303', 'Aparelho de Apoio de Rolo Met�lico','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '304', 'Aparelho de Apoio de Placa de Chumbo','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '305', 'Aparelho de Apoio Pot Bearing Fixo','0,4', 3);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '306', 'Aparelho de Apoio Pot Bearing Directional','0,4', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '307', 'Aparelho de Apoio Freyssinet','0,4', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '308', 'Aparelho de Apoio P�ndulo','0,4', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '309', 'Articula��o Met�lica','0,4', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '107', 'Dente Gerber de Concreto Armado','0,6', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '108', 'Dente Gerber de concreto armado com protens�o','0,6', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '118', 'Dente Gerber Met�lico','0,6', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '252', 'Encontro de alvenaria de pedra','0,1', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '251', 'Encontro - Parede frontal portante de concreto armado','0,1', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '253', 'Encontro - Parede Lateral e Vigas de Concreto Armado','0,2', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '256', 'Encontro - Paredes e Vigas Secund�rias de Concreto','0,1', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '254', 'Encontro - Laje de Concreto Armado','0,1', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '255', 'Encontro - Cortina de Concreto Armado','0,2', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '816', 'Muro de Arrimo de Concreto','0,4', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '818', 'Muro de Terra Armada','0,3', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '817', 'Revestimento de talude em concreto','0,4', 4);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '504', 'Estaca de Concreto Armado','0,4', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '505', 'Estaca Met�lica','0,4', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '506', 'Estaca de Madeira','0,4', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '501', 'Bloco ou Sapata de concreto armado','0,4', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '502', 'Tubul�o ou estac�o de concreto armado','0,4', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '503', 'Camisa Met�lica de Revestimento para Estaca','0,3', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '813', 'Junta elastom�rica de dilata��o','0,2', 2);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '815', 'Junta met�lica de dilata��o','0,2', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '801', 'Pavimento Asf�ltico','0,2', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '802', 'Pavimento de Concreto','0,2', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '808', 'Cal�ada para pedestres de concreto armado','0,2', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '809', 'Cal�ada para pedestres met�lica','0,2', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '803', 'Barreira new jersey','0,1', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '805', 'Guarda rodas qualquer','0,1', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '806', 'Guarda Corpo de Concreto Armado','0,1', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '807', 'Guarda Corpo Met�lico','0,1', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '703', 'Refor�o viga I - Encamisamento de viga','0,6', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '704', 'Refor�o viga II - Armadura principal passiva','0,6', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '705', 'Refor�o viga III - Cabo de protens�o externo','0,6', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '706', 'Refor�o viga IV - Bloqueio de articula��o Gerber','0,6', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '701', 'Refor�o laje I - Sobrelaje de concreto armado','0,4', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '702', 'Refor�o de Laje II - Infradorso laje em Concreto Armado','0,4', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '707', 'Refor�o de pilar - Encamisamento de pilar','0,4', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '708', 'Refor�o estaca - Encamisamento de trecho livre','0,4', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '811', 'Aterro de Acesso','0,2', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '810', 'Laje de Aproxima��o','0,2', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '601', 'Torre de Concreto Armado para Estaiamento','0,6', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '603', 'Ancoragens de estais','0,6', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '451', 'Treli�a de Concreto Armado','0,5', 5);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '452', 'Treli�a Met�lica','0,5', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '401', 'Arco de Concreto Armado','0,6', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '402', 'Arco de Concreto Protendido','0,6', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '403', 'Arco Met�lico','0,6', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '806', 'Guarda rodas antigo do DNER','0,1', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '812', 'Ber�o para junta de dilata��o','0,2', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '814', 'Junta de dilata��o','0,2', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '115', 'Cortina de concreto armado','0,2', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '116', 'Longarina de enrigecimento de laje','0,4', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '1000', 'Opera��o','0,2', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '1001', 'Drenagem','0,2', 1);
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1, ID_PONTE) values ( '1002', 'Sinaliza��o','0,1', 1);

---------------------------------------------------------------------------

-- Manifesta��es ufpr
create table MANIFESTACOES_UFPR
	(
		ID_MANIFESTACOES_UFPR						int							not null identity(1,1),
		ID_ELEMENTO_UFPR							int,
		CD_MANIFESTACOES_UFPR						int,
		DS_MANIFESTACOES_UFPR						varchar(100),
		DS_UNIDADE									varchar(10),
		DS_BETA										varchar(10),

		CONSTRAINT									pk_manifestacoesufpr		PRIMARY KEY(ID_MANIFESTACOES_UFPR),
		CONSTRAINT									fk_manifestacoesufpr_elementosufpr	FOREIGN KEY(ID_ELEMENTO_UFPR) REFERENCES ELEMENTOS_UFPR(ID_ELEMENTO_UFPR)
	);

--GO
--insert into MANIFESTACOES_UFPR (CD_ELEMENTOS_UFPR, CD_MANIFESTACOES_UFPR, DS_MANIFESTACOES_UFPR, DS_UNIDADE, DS_BETA) values ('00','00','00','00','00');

---------------------------------------------------------------------------

-- Inspe��es Manifesta��es

create table INSPECOES_MANIFESTACOES
	(
		ID_INSPECOES_MANIFESTACOES				int									not null identity(1,1),
		ID_INSPECAO								int,
		ID_ELEMENTO_UFPR						int,
		DS_NUMERO								varchar(20),
		ID_MANIFESTACOES_UFPR					int,
		DS_FOTO									varchar(20),
		DS_TAMANHO								varchar(20),
		ID_MANIFESTACOES_EXTENSAO				int,
		ID_MANIFESTACOES_URGENCIA				int,
		CONSTRAINT								pk_inspecoesmanifestacoes		PRIMARY KEY(ID_INSPECOES_MANIFESTACOES),
		CONSTRAINT								fk_inspecoesmanifestacoes_inspecao	FOREIGN KEY(ID_INSPECAO) REFERENCES INSPECAO(ID_INSPECAO),
		CONSTRAINT								fk_inspecoesmanifestacoes_elementosufpr	FOREIGN KEY(ID_ELEMENTO_UFPR) REFERENCES ELEMENTOS_UFPR(ID_ELEMENTO_UFPR),
		CONSTRAINT								fk_inspecoesmanifestacoes_manifestacoesufpr	FOREIGN KEY(ID_MANIFESTACOES_UFPR) REFERENCES MANIFESTACOES_UFPR(ID_MANIFESTACOES_UFPR),
		CONSTRAINT								fk_inspecoesmanifestacoes_manifestacoesextensao	FOREIGN KEY(ID_MANIFESTACOES_EXTENSAO) REFERENCES MANIFESTACOES_EXTENSAO(ID_MANIFESTACOES_EXTENSAO),
		CONSTRAINT								fk_inspecoesmanifestacoes_manifestacoesurgencia	FOREIGN KEY(ID_MANIFESTACOES_URGENCIA) REFERENCES MANIFESTACOES_URGENCIA(ID_MANIFESTACOES_URGENCIA)
		
	);

--GO
--insert into INSPECOES_MANIFESTACOES (ID_INSPECAO, CD_ELEMENTO, DS_NUMERO, CD_MANIFESTACAO, DS_FOTO, DS_TAMANHO, 
--CD_EXTENSAO, CD_REPARO) 
--values ('00', '00', '00', '00', '00', '00', '00', '00');



------------------------------------------------------------------------

create table ELEMENTO_COMPONENTES
	(
		ID_ELEMENTO_COMPONENTES			int										not null identity(1,1),
		ID_PONTE						int										not null,	
		ID_ELEMENTO_UFPR				int										not null,
		DS_DETALHE						varchar(20),
		NR_QUANTIDADE					varchar(10),	
		CONSTRAINT						pk_elementoscomponentes					PRIMARY KEY(ID_ELEMENTO_COMPONENTES),
		CONSTRAINT						fk_elementoscomponentes_ponte			FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT						fk_elementoscomponentes_elementosufpr	FOREIGN KEY(ID_ELEMENTO_UFPR) REFERENCES ELEMENTOS_UFPR(ID_ELEMENTO_UFPR)
	);

---	GO
---	insert into ELEMENTO_COMPONENTES (CD_CODIGO, CD_ELEMENTO, DS_DETALHE, NR_QUANTIDADE)
---	values ('00', '00', '00', '00');





--MENSAGENS acho que nao vai ser necessario

-- ARQUIVOS ANEXOS tabela ja existe

-- INSPECOES tabela ja existe

---------------------------------------------------------------------------