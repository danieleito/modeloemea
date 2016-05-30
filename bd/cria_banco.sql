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
insert into UF (DS_UF) values ('Paraná');
insert into UF (DS_UF) values ('Santa Catarina');
insert into UF (DS_UF) values ('São Paulo');

---------------------------------------------------------------------------
--Via
create table VIA
	(
		ID_VIA			int				not null identity(1,1),
		DS_VIA			varchar(10)		not null,
		CONSTRAINT		pk_via			PRIMARY KEY(ID_VIA)
	);

GO
insert into VIA (DS_VIA) values ('BR-116');
insert into VIA (DS_VIA) values ('BR-277');
insert into VIA (DS_VIA) values ('BR-376');
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
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - PR - Superintendência Regional do DNIT do estado do Paraná', 3);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL, ID_UF) values ('S.R.E. - SC - Superintendência Regional do DNIT do estado do Santa Catarina', 4);
insert into SUPERINTENDENCIA_REGIONAL (DS_SUPERINTENDENCIA_REGIONAL) values ('S.R.E. - SC - Superintendência Regional do DNIT do estado do Santa Catarina');
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
insert into UNIDADE_LOCAL (DS_UNIDADE_LOCAL, ID_SUPERINTENDENCIA_REGIONAL) values ('São José dos Pinhais', 1);
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






--dados basicos
create table IDENTIFICACAO_OBRA_DADOS_BASICOS
	(
		ID_IDENTIFICACAO_OBRA_DADOS_BASICOS		int										not null identity(1, 1),
		CD_CODIGO								varchar(20)								not null,
		CD_CODIGO_INTEGRACAO					varchar(20)								not null,
		DS_STATUS								varchar(20)								not null,
		DS_IDENTIFICACAO						varchar(20)								not null,
		DS_NATUREZA_TRANSPOSICAO				varchar(20)								not null,
		DS_TIPO_ESTRUTURA						varchar(20)								not null,
		DS_SISTEMA_CONSTRUTIVO					varchar(20)								not null,
		DS_COMPRIMENTO							varchar(20)								not null,
		DS_LARGURA								varchar(20)								not null,
		DS_TREM_TIPO							varchar(20)								not null,
		DS_ANO_CONSTRUCAO						varchar(20)								not null,
		CONSTRAINT								pk_identificacaoobradadosbasicos		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS)
	);

--localizacao
create table IDENTIFICACAO_OBRA_LOCALIZACAO
	(
		ID_IDENTIFICACAO_OBRA_LOCALIZACAO		int									not null identity(1,1),
		DS_UF									varchar(20)							not null,
		DS_VIA									varchar(20)							not null,
		DS_LOCAL_VIA							varchar(20)							not null,
		DS_CIDADE_MAIS_PROXIMA					varchar(20)							not null,
		DS_PNV_ANO								varchar(20)							not null,
		DS_PNV_VERSAO							varchar(20)							not null,
		DS_PNV_CODIGO							varchar(20)							not null,
		DS_PNV_ALTITUDE							varchar(20)							not null,
		DS_LATITUDE_GRAU						varchar(20)							not null,
		DS_LATITUDE_MINUTO						varchar(20)							not null,
		DS_LONGITUDE_GRAU						varchar(20)							not null,
		DS_LONGITUDE_MINUTO						varchar(20)							not null,
		CONSTRAINT								pk_identificacaoobralocalizacao		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_LOCALIZACAO)
	);

--responsaveis
create table IDENTIFICACAO_OBRA_RESPONSAVEIS
	(
		ID_IDENTIFICACAO_OBRA_RESPONSAVEIS		int										not null identity(1,1),
		DS_SUPERINTENDENCIA_REGIONAL			varchar(20)								not null,
		DS_UNIDADE_LOCAL						varchar(20)								not null,
		DS_TIPO_ADMINISTRACAO					varchar(20)								not null,
		DS_ADMINISTRADOR						varchar(20)								not null,
		DS_PROJETISTA_ORIGEM					varchar(20)								not null,
		DS_PROJETISTA_PROJETISTA				varchar(20)								not null,
		DS_CONSTRUTOR_ORIGEM					varchar(20)								not null,
		DS_CONSTRUTOR_CONSTRUTOR				varchar(20)								not null,
		DS_LOCALIZACAO_PROJETO					varchar(20)								not null,
		DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO	varchar(20)								not null,
		DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS		varchar(20)								not null,
		CONSTRAINT								pk_identificacaoobraresponsaveis		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS)
	);

--inspecao
create table IDENTIFICACAO_OBRA_INSPECAO
	(
		ID_IDENTIFICACAO_OBRA_INSPECAO		int									not null identity(1,1),
		DS_PERIODO							varchar(20)							not null,
		DS_EQUIPAMENTO_NECESSARIO			varchar(20)							not null,
		DS_MELHOR_EPOCA						varchar(20)							not null,
		CONSTRAINT							pk_identificacaoobrainspecao		PRIMARY KEY(ID_IDENTIFICACAO_OBRA_INSPECAO)
	);

--Identificacao da obra
create table IDENTIFICACAO_OBRA
	(
		ID_IDENTIFICACAO_OBRA					int													not null identity(1, 1),
		ID_IDENTIFICACAO_OBRA_DADOS_BASICOS		int													not null,
		ID_IDENTIFICACAO_OBRA_LOCALIZACAO		int													not null,
		ID_IDENTIFICACAO_OBRA_RESPONSAVEIS		int													not null,
		ID_IDENTIFICACAO_OBRA_INSPECAO			int													not null,
		CONSTRAINT								pk_identificacaoobra_identificacaoobradadosbasicos	FOREIGN KEY(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS) REFERENCES IDENTIFICACAO_OBRA_DADOS_BASICOS(ID_IDENTIFICACAO_OBRA_DADOS_BASICOS),
		CONSTRAINT								fk_identificacaoobra_identificacaoobralocalizacao	FOREIGN KEY(ID_IDENTIFICACAO_OBRA_LOCALIZACAO) REFERENCES IDENTIFICACAO_OBRA_LOCALIZACAO(ID_IDENTIFICACAO_OBRA_LOCALIZACAO),
		CONSTRAINT								fk_identificacaoobra_identificacaoobraresponsaveis	FOREIGN KEY(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS) REFERENCES IDENTIFICACAO_OBRA_RESPONSAVEIS(ID_IDENTIFICACAO_OBRA_RESPONSAVEIS),
		CONSTRAINT								fk_identificacaoobra_identificacaoobrainspecao		FOREIGN KEY(ID_IDENTIFICACAO_OBRA_INSPECAO) REFERENCES IDENTIFICACAO_OBRA_INSPECAO(ID_IDENTIFICACAO_OBRA_INSPECAO)
	);
---------------------------------------------------------------------------

--caracteristicas
create table CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS
	(
		ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS		int												not null identity(1,1),
		DS_IDENTIFICACAO									varchar(20)										not null,
		DS_TIPO_REGIAO										varchar(20)										not null,
		DS_TIPO_TRACADO										varchar(20)										not null,
		DS_RAMPA_MAXIMA										varchar(20)										not null,
		DS_RAIO_CURVA										varchar(20)										not null,
		DS_VMD												varchar(20)										not null,
		CONSTRAINT											pk_caracteristicasfuncionaiscaracteristicas		PRIMARY KEY(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS)
	);

--dimensoes
create table CARACTERISTICAS_FUNCIONAIS_DIMENSOES
	(
		ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES			int											not null identity(1,1),
		DS_NUMERO_FAIXAS								varchar(20)									not null,
		DS_LARGURA_FAIXA								varchar(20)									not null,
		DS_ACOSTAMENTO_DIREITO							varchar(20)									not null,
		DS_ACOSTAMENTO_ESQUERDO							varchar(20)									not null,
		DS_CALCADA_DIREITA								varchar(20)									not null,
		DS_CALCADA_ESQUERDA								varchar(20)									not null,
		DS_LARGURA_TOTAL_PISTA							varchar(20)									not null,
		DS_GABARITO_HORIZONTAL							varchar(20)									not null,
		DS_GABARITO_VERTICAL							varchar(20)									not null,
		DS_NUMERO_VAOS									varchar(20)									not null,
		DS_DESCRICAO_VAOS								varchar(20)									not null,
		CONSTRAINT										pk_caracteristicasfuncionaisdimensoes		PRIMARY KEY(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES)
	);

--caracteristicas funcionais
create table CARACTERISTICAS_FUNCIONAIS
	(
		ID_CARACTERISTICAS_FUNCIONAIS						int																		not null identity(1,1),
		ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS		int																		not null,
		ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES				int																		not null,
		CONSTRAINT											pk_caracteristicasfuncionais											PRIMARY KEY(ID_CARACTERISTICAS_FUNCIONAIS),
		CONSTRAINT											fk_caracteristicasfuncionais_caracteristicasfuncionaiscaracteristicas	FOREIGN KEY(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS) REFERENCES CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS(ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS),
		CONSTRAINT											fk_caracteristicasfuncionais_caracteristicasfuncionaisdimensoes			FOREIGN KEY(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES) REFERENCES CARACTERISTICAS_FUNCIONAIS_DIMENSOES(ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES)
	);
---------------------------------------------------------------------------

--elementos componentes
create table ELEMENTOS_COMPONENTES
	(
		ID_ELEMENTOS_COMPONENTES		int							not null identity(1,1),
		DS_IDENTIFICACAO				varchar(20)					not null,
		CD_CODIGO						varchar(20)					not null,
		DS_ELEMENTO						varchar(20)					not null,
		DS_DETALHE						varchar(20)					not null,
		CONSTRAINT						pk_elementoscomponentes		PRIMARY KEY(ID_ELEMENTOS_COMPONENTES)
	);
---------------------------------------------------------------------------

--aspectos especiais
create table ASPECTOS_ESPECIAIS
	(
		ID_ASPECTOS_ESPECIAIS			int							not null identity(1,1),
		DS_IDENTIFICACAO				varchar(20)					not null,
		CD_CODIGO						varchar(20)					not null,
		DS_DESCRICAO					varchar(20)					not null,
		DS_SIGLA						varchar(20)					not null,
		CONSTRAINT						pk_aspectosespeciais		PRIMARY KEY(ID_ASPECTOS_ESPECIAIS)
	);
---------------------------------------------------------------------------

--deficiencias funcionais
create table DEFICIENCIAS_FUNCIONAIS
	(
		ID_DEFICIENCIAS_FUNCIONAIS		int							not null identity(1,1),
		DS_IDENTIFICACAO				varchar(20)					not null,
		DS_DEFICIENCIA_FUNCIONAL		varchar(20)					not null,
		DS_UNIDADE_MEDIDA				varchar(20)					not null,
		CONSTRAINT						pk_deficienciasfuncionais		PRIMARY KEY(ID_DEFICIENCIAS_FUNCIONAIS)
	);
---------------------------------------------------------------------------

--rotas alternativas
create table ROTAS_ALTERNATIVAS
	(
		ID_ROTAS_ALTERNATIVAS			int							not null identity(1,1),
		DS_IDENTIFICACAO				varchar(20)					not null,
		DS_ROTA_ALTERNATIVA				varchar(20)					not null,
		DS_ACRESCIMO_KM					varchar(20)					not null,
		CONSTRAINT						pk_rotasalternativas		PRIMARY KEY(ID_ROTAS_ALTERNATIVAS)
	);
---------------------------------------------------------------------------

--substituicao
create table SUBSTITUICAO
	(
		ID_SUBSTITUICAO						int					not null identity(1,1),
		DS_IDENTIFICACAO					varchar(20)			not null,
		DS_EXISTE_PROJETO_SUBSTITUICAO		varchar(20)			not null,
		DS_CUSTO_ESTIMADO					varchar(20)			not null,
		DS_OBSERVACOES						varchar(20)			not null,
		CONSTRAINT							pk_substituicao		PRIMARY KEY(ID_SUBSTITUICAO)
	);
---------------------------------------------------------------------------

--observacoes
create table OBSERVACOES
	(
		ID_OBSERVACOES						int					not null identity(1,1),
		DS_IDENTIFICACAO					varchar(20)			not null,
		DS_OBSERVACOES						varchar(20)			not null,
		CONSTRAINT							pk_observacoes		PRIMARY KEY(ID_OBSERVACOES)
	);
---------------------------------------------------------------------------

--MENSAGENS acho que nao vai ser necessario

-- ARQUIVOS ANEXOS tabela ja existe

-- INSPECOES tabela ja existe

---------------------------------------------------------------------------