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
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Daniele', 'daniele', 'ito.dani', '123', 3);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Usu1', 'usu1', 'ito.dani', '123', 1);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Usu2', 'usu2', 'ito.dani', '123', 1);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('dhi', 'dhi', 'dhi@inf.ufpr.br', '123', 2);
---------------------------------------------------------------------------

--UF
create table UF
	(
		ID_UF				int				not null identity(1,1),
		DS_UF				varchar(30)		not null,
		SG_UF				varchar(2)		not null,
		CONSTRAINT			pk_uf			PRIMARY KEY(ID_UF)
	);

GO
insert into UF (DS_UF, SG_UF) values ('Acre', 'AC');
insert into UF (DS_UF, SG_UF) values ('Alagoas', 'AL');
insert into UF (DS_UF, SG_UF) values ('Amapá', 'AP');
insert into UF (DS_UF, SG_UF) values ('Amazonas', 'AM');
insert into UF (DS_UF, SG_UF) values ('Bahia', 'BA');
insert into UF (DS_UF, SG_UF) values ('Ceará', 'CE');
insert into UF (DS_UF, SG_UF) values ('Distrito Federal', 'DF');
insert into UF (DS_UF, SG_UF) values ('Espírito Santo', 'ES');
insert into UF (DS_UF, SG_UF) values ('Goiás', 'GO');
insert into UF (DS_UF, SG_UF) values ('Maranhão', 'MA');
insert into UF (DS_UF, SG_UF) values ('Mato Grosso', 'MG');
insert into UF (DS_UF, SG_UF) values ('Mato Grosso do Sul', 'MS');
insert into UF (DS_UF, SG_UF) values ('Minas Gerais', 'MG');
insert into UF (DS_UF, SG_UF) values ('Pará', 'PA');
insert into UF (DS_UF, SG_UF) values ('Paraíba', 'PB');
insert into UF (DS_UF, SG_UF) values ('Paraná', 'PR');
insert into UF (DS_UF, SG_UF) values ('Pernambuco', 'PE');
insert into UF (DS_UF, SG_UF) values ('Piauí', 'PI');
insert into UF (DS_UF, SG_UF) values ('Rio de Janeiro', 'RJ');
insert into UF (DS_UF, SG_UF) values ('Rio Grande do Norte', 'RN');
insert into UF (DS_UF, SG_UF) values ('Rio Grande do Sul', 'RS');
insert into UF (DS_UF, SG_UF) values ('Rondônia', 'RO');
insert into UF (DS_UF, SG_UF) values ('Roraima', 'RR');
insert into UF (DS_UF, SG_UF) values ('Santa Catarina', 'SC');
insert into UF (DS_UF, SG_UF) values ('São Paulo', 'SP');
insert into UF (DS_UF, SG_UF) values ('Sergipe', 'SE');
insert into UF (DS_UF, SG_UF) values ('Tocantins', 'TO');

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

--Simulação
create table SIMULACAO
	(
		ID_SIMULACAO	int						not null identity(1,1),
		DT_DATA			date					not null,
		ID_USUARIO		int						not null,
		NM_SIMULACAO	varchar(100)			not null,
		CONSTRAINT		pk_simulacao			PRIMARY KEY(ID_SIMULACAO),
		CONSTRAINT		fk_simulacao_usuario	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
	);

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

--------------------------------DADOS PARA PREENCHIMENTO CADASTRO-----------------------------------
--Natureza de transposição

create table NATUREZA_TRANSPOSICAO
	(
		ID_NATUREZA_TRANSPOSICAO			int								not null identity(1,1),
		DS_NATUREZA_TRANSPOSICAO			varchar(50)						not null,
		CONSTRAINT							pk_naturezatransposicao			PRIMARY KEY(ID_NATUREZA_TRANSPOSICAO)
	);

GO
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Ponte');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Pontilhão');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto de transposição de rodovia');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto sobre ferrovia');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto sobre rodovia / rua');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto em encosta');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Passagem inferior');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Passarela de pedestres');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Não informado');

--Tipo de estrutura

create table TIPO_ESTRUTURA
	(
		ID_TIPO_ESTRUTURA			int				not null identity(1,1),
		DS_TIPO_ESTRUTURA		varchar(50)		not null,
		CONSTRAINT		pk_tipoestrutura			PRIMARY KEY(ID_TIPO_ESTRUTURA)
	);

GO
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga Caixão Concreto Armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga Caixão Concreto Protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga de concreto armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga de concreto protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Viga e laje metálicas');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Mista (viga metal e laje concreto)');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco inferior de concreto armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco inferior de concreto protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco inferior metálico');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco superior de concreto armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco superior de concreto protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco superior metálico');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Arco de alvenaria de pedra');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Treliça metálica');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Laje de concreto armado');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Laje de concreto protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Madeira');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Estaiada com vigamento metálico');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Estaiada com vigamento c. protendido');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Pênsil');
insert into TIPO_ESTRUTURA (DS_TIPO_ESTRUTURA) values ('Não informado');

--Sistema Construtivo

create table SISTEMA_CONSTRUTIVO
	(
		ID_SISTEMA_CONSTRUTIVO			int						not null identity(1,1),
		DS_SISTEMA_CONSTRUTIVO			varchar(50)				not null,
		CONSTRAINT						pk_sistemaconstrutivo	PRIMARY KEY(ID_SISTEMA_CONSTRUTIVO)
	);

GO
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Moldado no local');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Pré-moldado de concreto armado');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Pré-moldado protendido (pós-tensão)');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Pré-moldado protendido (pré-tensão)');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Balanços progressivos c/ continuidade');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Balanços progressivos c/ articulações');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Aduelas pré-moldadas');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Viga calha pré-moldada (Sist protótipo)');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Ponte empurrada');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Estaiado em avanços progressivos');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Não informado');
insert into SISTEMA_CONSTRUTIVO (DS_SISTEMA_CONSTRUTIVO) values ('Treliça metálica');

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

--Tipo de região

create table TIPO_REGIAO
	(
		ID_TIPO_REGIAO		int					not null identity(1,1),
		DS_TIPO_REGIAO		varchar(30)			not null,
		CONSTRAINT			pk_tiporegiao		PRIMARY KEY(ID_TIPO_REGIAO)
	);

GO
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Plana');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Ondulada');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Montanhosa');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Não informado');

--Tipo de traçado

create table TIPO_TRACADO
	(
		ID_TIPO_TRACADO		int					not null identity(1,1),
		DS_TIPO_TRACADO		varchar(30)			not null,
		CONSTRAINT			pk_tipotracado		PRIMARY KEY(ID_TIPO_TRACADO)
	);

GO
insert into TIPO_TRACADO (DS_TIPO_TRACADO) values ('Tangente');
insert into TIPO_TRACADO (DS_TIPO_TRACADO) values ('Curva');
insert into TIPO_TRACADO (DS_TIPO_TRACADO) values ('Não informado');

--Tipo de administração

create table TIPO_ADMINISTRACAO
	(
		ID_TIPO_ADMINISTRACAO			int						not null identity(1,1),
		DS_TIPO_ADMINISTRACAO			varchar(30)				not null,
		CONSTRAINT						pk_tipoadministracao	PRIMARY KEY(ID_TIPO_ADMINISTRACAO)
	);

GO
insert into TIPO_ADMINISTRACAO	 (DS_TIPO_ADMINISTRACAO) values ('Administração Direta');
insert into TIPO_ADMINISTRACAO	 (DS_TIPO_ADMINISTRACAO) values ('Administração Indireta');



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

--inspecao
create table IDENTIFICACAO_OBRA_INSPECAO
	(
		ID_IDENTIFICACAO_OBRA_INSPECAO		int									not null identity(1,1),
		DS_PERIODO							varchar(20),
		DS_EQUIPAMENTO_NECESSARIO			varchar(20),
		DS_MELHOR_EPOCA						varchar(20),
		CONSTRAINT							pk_identificacaoobrainspecao		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_INSPECAO)
	);

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

---------------------------------------------------------------------------
-- foto
create table FOTO
	(
		ID_FOTO			int				not null identity(1,1),
		DS_FOTO			varchar(30)		not null,
		CONSTRAINT		pk_foto			PRIMARY KEY(ID_FOTO)
	);

--extensao relativa
create table EXTENSAO_RELATIVA
	(
		ID_EXTENSAO_RELATIVA		int						not null identity(1,1),
		DS_EXTENSAO_RELATIVA		varchar(30)				not null,
		CONSTRAINT					pk_extensaorelativa		PRIMARY KEY(ID_EXTENSAO_RELATIVA)
	);

--reparo
create table REPARO
	(
		ID_REPARO		int				not null identity(1,1),
		DS_REPARO		varchar(30)		not null,
		CONSTRAINT		pk_reparo		PRIMARY KEY(ID_REPARO)
	);

--numero
create table NUMERO
	(
		ID_NUMERO		int				not null identity(1,1),
		DS_NUMERO		varchar(10)		not null,
		CONSTRAINT		pk_numero		PRIMARY KEY(ID_NUMERO)
	);
---------------------------------------------------------------------------
--rotas alternativas
create table ROTAS_ALTERNATIVAS
	(
		ID_ROTAS_ALTERNATIVAS			int							not null identity(1,1),
		DS_IDENTIFICACAO				varchar(20),
		DS_ROTA_ALTERNATIVA				varchar(400),
		DS_ACRESCIMO_KM					varchar(20),
		CONSTRAINT						pk_rotasalternativas		PRIMARY KEY(ID_ROTAS_ALTERNATIVAS)
	);

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

---------------------------------------------------------------------------

--observacoes
create table OBSERVACOES
	(
		ID_OBSERVACOES						int					not null identity(1,1),
		DS_IDENTIFICACAO					varchar(20),
		DS_OBSERVACOES						varchar(20),
		CONSTRAINT							pk_observacoes		PRIMARY KEY(ID_OBSERVACOES)
	);

---------------------------------------------------------------------------

-- Manifestações extensão
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
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Pequena','Dano de tamanho pequeno, em menos de 10% da área','0,5');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Média ','Dano de tamanho médio, confinado em uma área pequena 10% a 25% da área total do elemento','1');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Grande','Dano em área grande de 25% a 75%, ou em muitos lugares de um elemento estrutural','1,5');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Imensa','Danos muito grandes na maior parte da área de um elemento, mais de 75%','2');

---------------------------------------------------------------------------

-- Manifestações urgencia (reparo)
create table MANIFESTACOES_URGENCIA
	(
		ID_MANIFESTACOES_URGENCIA						int							not null identity(1,1),
		DS_MANIFESTACOES_URGENCIA						varchar(80),
		DS_CRITERIO_MANIFESTACOES_URGENCIA				varchar(200),
		DS_CAPA4										varchar(10),

		CONSTRAINT						pk_manifestacoesurgencia		PRIMARY KEY(ID_MANIFESTACOES_URGENCIA)
	);
GO
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Não urgente','Intervenção não é urgente pois o dano não interfere na utilização e capacidade da ponte, e também não altera a sua durabilidade','1');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Dano à reparar','Dano deve ser reparado em período não maior que 5 anos, para garantir a servicibilidade e não comprometer a durabilidade da OAE','2,5');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Reparo imediato','Reparo imediato, pois o dano já está comprometendo a utilização da OAE, com risco ás pessoas','4');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Limitação de carga','Limitação de carga, interrupção de tráfego e escoramento imediato deve ser feito, além do reparo','5');

---------------------------------------------------------------------------

-- Manifestações extensão
create table MANIFESTACOES_REPETICAO
	(
		ID_MANIFESTACOES_REPETICAO						int							not null identity(1,1),
		DS_CRITERIO_MANIFESTACOES_REPETICAO				varchar(200),
		DS_LIMITESUPERIOR								varchar(10),
		DS_CAPA3										varchar(10),

		CONSTRAINT						pk_manifestacoesrepeticao		PRIMARY KEY(ID_MANIFESTACOES_REPETICAO)
	);
GO
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano é aparece em menos de 10% dos elementos estruturais da OAE','0,1','0,5');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 10% e 25% dos elementos estruturais da OAE','0,25','1');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 25% e 75% dos elementos estruturais da OAE','0,75','1,5');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 75% e 100% dos elementos estruturais da OAE','1','2');

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

--deficiencias funcionais
create table DEFICIENCIAS_FUNCIONAIS
	(
		ID_DEFICIENCIAS_FUNCIONAIS		int							not null identity(1,1),
		CD_DEFICIENCIA_FUNCIONAL		varchar(20),
		DS_DEFICIENCIA_FUNCIONAL		varchar(80),
		DS_UNIDADE_MEDIDA				varchar(20),
		CONSTRAINT						pk_deficienciasfuncionais		PRIMARY KEY(ID_DEFICIENCIAS_FUNCIONAIS)
	);
GO
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('1', 'Ponte estreita (larg pista < 7,20m)','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('2', 'Ponte sem acostamento','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('3', 'Calçada para pedestres inexistente','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('4', 'Pingadeira inexistente','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('5', 'Drenagem de pista insuficiente','un - Unidade');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('6', 'Guarda-rodas obsoleto','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('7', 'Seção hidraúlica (greide baixo)','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('8', 'Seção hidraúlica (ponte curta)','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('9', 'Concordância vertical ruim','un - Unidade');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('10', 'Concordância horizontal ruim','un - Unidade');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('11', 'Capacidade de carga limitada','tf');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('12', 'Gabarito vertical sobre via urbana insuficiente','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('13', 'Gabarito vertical sobre rodovia insuficiente','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('14', 'Gabarito horizontal insuficiente','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('15', 'Gabarito vertical de navegação insuficiente','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('16', 'Gabarito vertical sobre ferrovia insuficiente','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('17', 'Pilar em canal de navegação sem proteção','un - Unidade');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('18', 'Alça de acesso inadequada','un - Unidade');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('19', 'Ponte muito estreita (em mão única)','m - Metro');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('22', 'Trem tipo de cálculo TB 24tf','tf');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('23', 'Trem tipo de cálculo TB 36tf','tf');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('24', 'Junta longitudinal de dilatação','un - Unidade');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('25', 'Viga caixão com interior inacessível','un - Unidade');
insert into DEFICIENCIAS_FUNCIONAIS (CD_DEFICIENCIA_FUNCIONAL,DS_DEFICIENCIA_FUNCIONAL, DS_UNIDADE_MEDIDA) values ('26', 'Aparelho de apoio não identificado','kg - Quilograma');


---------------------------------------------------------------------------
create table ELEMENTOS_UFPR
	(
		ID_ELEMENTO_UFPR		int						not null identity(1,1),
		CD_ELEMENTO				int,
		DS_ELEMENTO				varchar(100),
		DS_CAPA1				varchar(10)				not null,
		CONSTRAINT				pk_elementosufpr		PRIMARY KEY(ID_ELEMENTO_UFPR)
	);
GO
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '1', 'Laje de concreto armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '2', 'Laje de Concreto Protendido','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '3', 'Laje Metálica Ortotrópica','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '4', 'Laje Metálica de Chapa Corrugada','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '7', 'Laje em Pranchão de Madeira','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '5', 'Ponte em Laje de Concreto Armado','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '6', 'Ponte em Laje de Concreto Protendido','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '204', 'Travessa de apoio de concreto armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '205', 'Travessa de apoio de concreto protendido','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '104', 'Viga T ou I de concreto armado','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '105', 'Viga T ou I de concreto protendido','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '106', 'Viga I metálica','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '101', 'Viga Caixão de Concreto Armado','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '102', 'Viga Caixão de Concreto Protendido','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '103', 'Viga Caixão Metálica','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '206', 'Viga de contraventamento de pilar de concreto armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '109', 'Transversina Portante de Concreto Armado','0,3');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '110', 'Transversina Portante de Concreto Protendido','0,3');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '111', 'Transversina Portante Metálica','0,3');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '112', 'Transversina de Ligação de Concreto Armado','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '113', 'Transversina de Ligação de Concreto Protendido','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '114', 'Transversina de Ligação Metálica','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '202', 'Pilar em Colunas de Concreto Armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '201', 'Pilar Parede de Concreto Armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '203', 'Pilar Vazado de Concreto Armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '200', 'Pilar Parede de Alvenaria de Pedra','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '207', 'Parede de contraventamento de pilar de concreto armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '301', 'Aparelho de Apoio de Neoprene Fretado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '302', 'Aparelho de Apoio de Teflon','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '303', 'Aparelho de Apoio de Rolo Metálico','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '304', 'Aparelho de Apoio de Placa de Chumbo','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '305', 'Aparelho de Apoio Pot Bearing Fixo','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '306', 'Aparelho de Apoio Pot Bearing Directional','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '307', 'Aparelho de Apoio Freyssinet','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '308', 'Aparelho de Apoio Pêndulo','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '309', 'Articulação Metálica','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '107', 'Dente Gerber de Concreto Armado','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '108', 'Dente Gerber de concreto armado com protensão','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '118', 'Dente Gerber Metálico','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '252', 'Encontro de alvenaria de pedra','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '251', 'Encontro - Parede frontal portante de concreto armado','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '253', 'Encontro - Parede Lateral e Vigas de Concreto Armado','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '256', 'Encontro - Paredes e Vigas Secundárias de Concreto','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '254', 'Encontro - Laje de Concreto Armado','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '255', 'Encontro - Cortina de Concreto Armado','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '816', 'Muro de Arrimo de Concreto','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '818', 'Muro de Terra Armada','0,3');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '817', 'Revestimento de talude em concreto','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '504', 'Estaca de Concreto Armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '505', 'Estaca Metálica','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '506', 'Estaca de Madeira','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '501', 'Bloco ou Sapata de concreto armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '502', 'Tubulão ou estacão de concreto armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '503', 'Camisa Metálica de Revestimento para Estaca','0,3');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '813', 'Junta elastomérica de dilatação','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '815', 'Junta metálica de dilatação','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '801', 'Pavimento Asfáltico','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '802', 'Pavimento de Concreto','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '808', 'Calçada para pedestres de concreto armado','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '809', 'Calçada para pedestres metálica','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '803', 'Barreira new jersey','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '805', 'Guarda rodas qualquer','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '806', 'Guarda Corpo de Concreto Armado','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '807', 'Guarda Corpo Metálico','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '703', 'Reforço viga I - Encamisamento de viga','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '704', 'Reforço viga II - Armadura principal passiva','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '705', 'Reforço viga III - Cabo de protensão externo','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '706', 'Reforço viga IV - Bloqueio de articulação Gerber','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '701', 'Reforço laje I - Sobrelaje de concreto armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '702', 'Reforço de Laje II - Infradorso laje em Concreto Armado','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '707', 'Reforço de pilar - Encamisamento de pilar','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '708', 'Reforço estaca - Encamisamento de trecho livre','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '811', 'Aterro de Acesso','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '810', 'Laje de Aproximação','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '601', 'Torre de Concreto Armado para Estaiamento','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '603', 'Ancoragens de estais','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '451', 'Treliça de Concreto Armado','0,5');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '452', 'Treliça Metálica','0,5');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '401', 'Arco de Concreto Armado','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '402', 'Arco de Concreto Protendido','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '403', 'Arco Metálico','0,6');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '806', 'Guarda rodas antigo do DNER','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '812', 'Berço para junta de dilatação','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '814', 'Junta de dilatação','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '115', 'Cortina de concreto armado','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '116', 'Longarina de enrigecimento de laje','0,4');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '1000', 'Operação','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '1001', 'Drenagem','0,2');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '1002', 'Sinalização','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '820', 'Defensa Metálica','0,1');
insert into ELEMENTOS_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '819', 'Muro de gabião','0,4');



-- Manifestações ufpr
create table MANIFESTACOES_UFPR
	(
		ID_MANIFESTACOES_UFPR						int									not null identity(1,1),
		ID_ELEMENTO_UFPR							int,
		CD_MANIFESTACOES_UFPR						int,
		DS_MANIFESTACOES_UFPR						varchar(100),
		DS_UNIDADE									varchar(10),
		DS_BETA										varchar(10),

		CONSTRAINT									pk_manifestacoesufpr				PRIMARY KEY(ID_MANIFESTACOES_UFPR),
		CONSTRAINT									fk_manifestacoesufpr_elementosufpr	FOREIGN KEY(ID_ELEMENTO_UFPR) REFERENCES ELEMENTOS_UFPR(ID_ELEMENTO_UFPR)
	);

------------------------------------------------------------------------
-- cadastro manifestacao
create table CADASTRO_MANIFESTACAO
	(
		ID_CADASTRO_MANIFESTACAO		int											not null identity(1,1),
		ID_NUMERO						int,
		ID_MANIFESTACOES_UFPR			int,
		ID_FOTO							int,
		DS_TAMANHO						varchar(10),
		ID_EXTENSAO_RELATIVA			int,
		ID_REPARO						int,
		CONSTRAINT						pk_cadastromanifestacao						PRIMARY KEY(ID_CADASTRO_MANIFESTACAO),
		CONSTRAINT						fk_cadastromanifestacao_numero				FOREIGN KEY(ID_NUMERO) REFERENCES NUMERO(ID_NUMERO),
		CONSTRAINT						fk_cadastromanifestacao_manifestacoesufpr	FOREIGN KEY(ID_MANIFESTACOES_UFPR) REFERENCES MANIFESTACOES_UFPR(ID_MANIFESTACOES_UFPR),
		CONSTRAINT						fk_cadastromanifestacao_foto				FOREIGN KEY(ID_FOTO) REFERENCES FOTO(ID_FOTO),
		CONSTRAINT						fk_cadastromanifestacao_extensaorelativa	FOREIGN KEY(ID_EXTENSAO_RELATIVA) REFERENCES EXTENSAO_RELATIVA(ID_EXTENSAO_RELATIVA),
		CONSTRAINT						fk_cadastromanifestacao_reparo				FOREIGN KEY(ID_REPARO) REFERENCES REPARO(ID_REPARO)
	);
------------------------------------------------------------------------

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
		ID_OBSERVACOES									int													not null,
		ID_SUBSTITUICAO									int													not null,
		ID_CADASTRO_MANIFESTACAO						int													not null
		CONSTRAINT										pk_ponte											PRIMARY KEY(ID_PONTE), 
		CONSTRAINT										fk_ponte_identificacaoobradadosbasicos				FOREIGN KEY(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS) REFERENCES IDENTIFICACAO_OBRA_DADOS_BASICOS(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS),
		CONSTRAINT										fk_ponte_identificacaoobralocalizacao				FOREIGN KEY(ID_IDENTIFICACAO_OBRA_LOCALIZACAO) REFERENCES IDENTIFICACAO_OBRA_LOCALIZACAO(ID_IDENTIFICACAO_OBRA_LOCALIZACAO),
		CONSTRAINT										fk_ponte_identificacaoobraresponsaveis				FOREIGN KEY(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS) REFERENCES IDENTIFICACAO_OBRA_RESPONSAVEIS(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS),
		CONSTRAINT										fk_ponte_identificacaoobrainspecao					FOREIGN KEY(ID_IDENTIFICACAO_OBRA_INSPECAO) REFERENCES IDENTIFICACAO_OBRA_INSPECAO(ID_IDENTIFICACAO_OBRA_INSPECAO),
		CONSTRAINT										fk_ponte_caracteristicasfuncionaiscaracteristicas	FOREIGN KEY(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS) REFERENCES CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS),
		CONSTRAINT										fk_ponte_caracteristicasfuncionaisdimensoes			FOREIGN KEY(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES) REFERENCES CARACTERISTICAS_FUNCIONAIS_DIMENSOES(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES),
		CONSTRAINT										fk_ponte_rotasalternativas							FOREIGN KEY(ID_ROTAS_ALTERNATIVAS) REFERENCES ROTAS_ALTERNATIVAS(ID_ROTAS_ALTERNATIVAS),
		CONSTRAINT										fk_ponte_observacoes								FOREIGN KEY(ID_OBSERVACOES) REFERENCES OBSERVACOES(ID_OBSERVACOES),
		CONSTRAINT										fk_ponte_substituicao								FOREIGN KEY(ID_SUBSTITUICAO) REFERENCES SUBSTITUICAO(ID_SUBSTITUICAO),
		CONSTRAINT										fk_ponte_cadastromanifestacao						FOREIGN KEY(ID_CADASTRO_MANIFESTACAO) REFERENCES CADASTRO_MANIFESTACAO(ID_CADASTRO_MANIFESTACAO)
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

CREATE TABLE IMAGEM
   (
	   ID_IMAGEM		int				not null identity(1,1), 
	   NM_NOME			varchar(100)	not null,
	   TIPO_MIME		varchar(20)		not null,
	   DS_IMAGEM		varbinary(max),
	   CONSTRAINT		pk_imagem		PRIMARY KEY(ID_IMAGEM)
   );


--Arquivos anexos cadastro
create table ARQUIVO_ANEXO_CADASTRO
	(
		ID_ARQUIVO_ANEXO_CADASTRO		int								not null identity(1,1),
		ID_PONTE						int								not null,
		DS_ARQUIVO						varchar(20)						not null,
		DS_TIPO_ARQUIVO					varchar(10)						not null,
		NR_NUMERO						varchar(3)						not null,
		DS_DESCRICAO					varchar(20)						not null,
		DS_REGISTRO						varchar(10)						not null,
		DT_DATA_ANEXACAO				date							not null,
		--DS_MINIATURA
		ID_IMAGEM						int,					
		CONSTRAINT						pk_arquivoanexocadastro			PRIMARY KEY(ID_ARQUIVO_ANEXO_CADASTRO),
		CONSTRAINT						fk_arquivoanexocadastro_ponte	FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT						fk_arquivoanexocadastro_imagem	FOREIGN KEY(ID_IMAGEM) REFERENCES IMAGEM(ID_IMAGEM)
	);

--Arquivos anexos inspecao
create table ARQUIVO_ANEXO_INSPECAO
	(
		ID_ARQUIVO_ANEXO_INSPECAO		int				not null identity(1,1),
		ID_INSPECAO						int				not null,
		DS_ARQUIVO						varchar(20)		not null,
		DS_TIPO_ARQUIVO					varchar(10)		not null,
		NR_NUMERO						varchar(3)		not null,
		DS_DESCRICAO					varchar(20)		not null,
		DS_REGISTRO						varchar(10)		not null,
		DT_DATA_ANEXACAO				date			not null,
		--DS_MINIATURA
		ID_IMAGEM						int,
		CONSTRAINT						pk_arquivoanexoinspecao	PRIMARY KEY(ID_ARQUIVO_ANEXO_INSPECAO),
		CONSTRAINT						fk_arquivoanexoinspecao_inspecao	FOREIGN KEY(ID_INSPECAO) REFERENCES INSPECAO(ID_INSPECAO),
		CONSTRAINT						fk_arquivoanexoinspecao_imagem		FOREIGN KEY(ID_IMAGEM) REFERENCES IMAGEM(ID_IMAGEM)
	);
---------------------------------------------------------------------------


--aspectos especiais
create table ASPECTOS_ESPECIAIS
	(
		ID_ASPECTOS_ESPECIAIS				int							not null identity(1,1),
		DS_ASPECTOS_ESPECIAIS				varchar(80),

		CONSTRAINT						pk_aspectosespeciais		PRIMARY KEY(ID_ASPECTOS_ESPECIAIS)
	);
GO
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Meio ambiente agressivo');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Nível de vibração elevado');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Leito do rio erodível');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Fundação em solo mole');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Frequência elevada de carga pesada');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Desnível elevado entre greide e terreno');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Rio com lâmina dágua normal profunda');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Grande variação do NA do rio na cheia');
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
		CONSTRAINT							fk_ranking_simulacao	FOREIGN KEY(ID_SIMULACAO) REFERENCES SIMULACAO (ID_SIMULACAO) ON DELETE CASCADE
	);


---------------------------------------------------------------------------

-- Inspeções Manifestações

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
---------------------------------------------------------------------------

--inspecao rotineira

create table IDENTIFICACAO_OBRA_SGO
	(
		ID_IDENTIFICACAO_OBRA_SGO		int				not null identity(1,1),
		CD_CODIGO						varchar(20),
		DT_DATA_INSPECAO				varchar(10),
		NM_PONTE						varchar(30),
		NM_INSPETOR						varchar(50),
		ID_VIA							int,
		ID_UF							int,
		DS_KM							varchar(10),
		ID_SUPERINTENDENCIA_REGIONAL	int,
		DS_UL							varchar(30),
		CONSTRAINT						pk_identificacaoobrasgo								PRIMARY KEY(ID_IDENTIFICACAO_OBRA_SGO),
		CONSTRAINT						fk_identificacaoobrasgo_via							FOREIGN KEY(ID_VIA) REFERENCES VIA(ID_VIA),
		CONSTRAINT						fk_identificacaoobrasgo_uf							FOREIGN KEY(ID_UF) REFERENCES UF(ID_UF),
		CONSTRAINT						fk_identificacaoobrasgo_superintendenciaregional	FOREIGN KEY(ID_SUPERINTENDENCIA_REGIONAL) REFERENCES SUPERINTENDENCIA_REGIONAL(ID_SUPERINTENDENCIA_REGIONAL)
	);
insert into IDENTIFICACAO_OBRA_SGO values ('codigo', '04/08/2016', 'ponte', 'inspetor', 1, 1, 'km', 1, 'ul');

create table CONDICOES_SGO
	(
		ID_CONDICOES_SGO				int				not null identity(1,1),
		DS_CONDICAO_ESTABILIDADE		varchar(20),
		DS_CONDICAO_CONSERVACAO			varchar(20),
		DS_OBSERVACOES					varchar(80),
		DS_NOTA_TECNICA					varchar(20),
		CONSTRAINT						pk_condicoessgo	PRIMARY KEY(ID_CONDICOES_SGO)
	);
insert into CONDICOES_SGO values ('cond estabilidade', 'cond conservacao', 'observacoes', 'nota técnica');

create table DANOS_ELEMENTOS_SGO
	(
		ID_DANOS_ELEMENTOS_SGO		int						not null identity(1,1),
		DS_ELEMENTO					varchar(30),
		DS_NOTA						varchar(20),
		DS_DANO						varchar(20),
		DS_UNIDADE					varchar(20),
		DS_QUANTIDADE				varchar(20),
		DS_EXTENSAO_RELATIVA		varchar(20),
		DS_LOCALIZACAO				varchar(20),
		CONSTRAINT					pk_danoselementossgo	PRIMARY KEY(ID_DANOS_ELEMENTOS_SGO)
	);
insert into DANOS_ELEMENTOS_SGO values ('elemento', 'nota', 'dano', 'unidade', 'quantidade', 'ext relativa', 'localizacao');

create table INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO
	(
		ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO		int											not null identity(1,1),
		DS_ELEMENTO										varchar(30),
		DS_NOTA											varchar(20),
		DS_INSUFICIENCIA								varchar(20),
		DS_CAUSA_PROVAVEL								varchar(20),
		DS_COMENTARIOS									varchar(20),
		CONSTRAINT										pk_insuficienciaestruturaiselementossgo		PRIMARY KEY(ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO)
	);
insert into INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO values ('elemento', 'nota', 'insuficiencia', 'causa provável', 'comentários');

create table LAUDO_ESPECIALIZADO_SGO
	(
		ID_LAUDO_ESPECIALIZADO_SGO					int							not null identity(1,1),
		DT_DATA_LAUDO								varchar(10),
		DS_CONSULTOR								varchar(30),
		DS_OBSERVACOES								varchar(80),
		CONSTRAINT									pk_laudoespecializadosgo	PRIMARY KEY(ID_LAUDO_ESPECIALIZADO_SGO)
	);
insert into LAUDO_ESPECIALIZADO_SGO values ('04/08/2016', 'consultor', 'observações');

create table MONITORAMENTO_SGO
	(
		ID_MONITORAMENTO_SGO			int						not null identity(1,1),
		DS_PERIODO						varchar(20),
		DS_TIPO_MONITORAMENTO			varchar(20),
		DS_EXECUTOR						varchar(30),
		DS_CUSTO						varchar(20),
		DS_OBJETO						varchar(80),
		DS_TECNICAS						varchar(80),
		CONSTRAINT						pk_monitoramentosgo		PRIMARY KEY(ID_MONITORAMENTO_SGO)
	);
insert into MONITORAMENTO_SGO values ('período', 'tipo monitoramento', 'executor', 'custo', 'objeto', 'técnicas');

create table INSPECAO_ROTINEIRA
	(
		ID_INSPECAO_ROTINEIRA								int															not null identity(1,1),
		ID_PONTE											int															not null,
		ID_IDENTIFICACAO_OBRA_SGO							int															not null,
		ID_CONDICOES_SGO									int															not null,
		ID_DANOS_ELEMENTOS_SGO								int															not null,
		ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO			int															not null,
		ID_LAUDO_ESPECIALIZADO_SGO							int															not null,
		ID_MONITORAMENTO_SGO								int															not null,
		DS_RELATORIO										varchar(80)													not null,
		CONSTRAINT											pk_inspecaorotineira										PRIMARY KEY(ID_INSPECAO_ROTINEIRA),
		CONSTRAINT											fk_inspecaorotineira_ponte									FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT											fk_inspecaorotineira_identificacaoobrasgo					FOREIGN KEY(ID_IDENTIFICACAO_OBRA_SGO) REFERENCES IDENTIFICACAO_OBRA_SGO(ID_IDENTIFICACAO_OBRA_SGO),
		CONSTRAINT											fk_inspecaorotineira_condicaosgo							FOREIGN KEY(ID_CONDICOES_SGO) REFERENCES CONDICOES_SGO(ID_CONDICOES_SGO),
		CONSTRAINT											fk_inspecaorotineira_danoselementossgo						FOREIGN KEY(ID_DANOS_ELEMENTOS_SGO) REFERENCES DANOS_ELEMENTOS_SGO(ID_DANOS_ELEMENTOS_SGO),
		CONSTRAINT											fk_inspecaorotineira_insuficienciasestruturaiselementossgo	FOREIGN KEY(ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO) REFERENCES INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO(ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO),
		CONSTRAINT											fk_inspecaorotineira_laudoespecializadosgo					FOREIGN KEY(ID_LAUDO_ESPECIALIZADO_SGO) REFERENCES LAUDO_ESPECIALIZADO_SGO(ID_LAUDO_ESPECIALIZADO_SGO),
		CONSTRAINT											fk_inspecaorotineira_monitoramentosgo						FOREIGN KEY(ID_MONITORAMENTO_SGO) REFERENCES MONITORAMENTO_SGO(ID_MONITORAMENTO_SGO)
	);
---------------------------------------------------------------------------
--MENSAGENS acho que nao vai ser necessario

-- ARQUIVOS ANEXOS tabela ja existe

-- INSPECOES tabela ja existe

---------------------------------------------------------------------------