create database EMEA;
GO
use EMEA;
GO
---------------------------------------------------------------------------

--Equipe

create table ENGENHEIRO
	(
		ID_ENGENHEIRO	int				not null identity(1,1),
		NM_NOME			varchar(50)		not null,
		NR_CREA			varchar(15)		not null,
		CONSTRAINT		pk_engenheiro	PRIMARY KEY(ID_ENGENHEIRO)
	);
GO
insert into ENGENHEIRO (NM_NOME, NR_CREA) values ('Daniele Ito', '12345/PR');
insert into ENGENHEIRO (NM_NOME, NR_CREA) values ('Dani', '654321-PR');

create table AUXILIAR
	(
		ID_AUXILIAR		INT				not null identity(1,1),
		NM_NOME			varchar(50)		not null,
		CONSTRAINT		pk_auxiliar		PRIMARY KEY(ID_AUXILIAR)
	);
GO
insert into AUXILIAR (NM_NOME) values ('dani');
insert into AUXILIAR (NM_NOME) values ('daniele');

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

create table EQUIPE
	(
		ID_EQUIPE			int			not null identity(1,1),
		DT_DATA				varchar(10)	not null,
		ID_ENGENHEIRO_UM	int			not null,
		ID_ENGENHEIRO_DOIS	int,
		ID_AUXILIAR_UM		int			not null,
		ID_AUXILIAR_DOIS	int,
		ID_AUXILIAR_TRES	int,
		ID_AUXILIAR_QUATRO	int,
		ID_AUXILIAR_CINCO	int,
		CONSTRAINT			pk_equipe					PRIMARY KEY(ID_EQUIPE),
		CONSTRAINT			fk_equipe_engenheiroum		FOREIGN KEY(ID_ENGENHEIRO_UM) REFERENCES ENGENHEIRO(ID_ENGENHEIRO),
		CONSTRAINT			fk_equipe_engenheirodois	FOREIGN KEY(ID_ENGENHEIRO_DOIS) REFERENCES ENGENHEIRO(ID_ENGENHEIRO),
		CONSTRAINT			fk_equipe_auxiliarum		FOREIGN KEY(ID_AUXILIAR_UM) REFERENCES AUXILIAR(ID_AUXILIAR),
		CONSTRAINT			fk_equipe_auxiliardois		FOREIGN KEY(ID_AUXILIAR_DOIS) REFERENCES AUXILIAR(ID_AUXILIAR),
		CONSTRAINT			fk_equipe_auxiliartres		FOREIGN KEY(ID_AUXILIAR_TRES) REFERENCES AUXILIAR(ID_AUXILIAR),
		CONSTRAINT			fk_equipe_auxiliarquatro	FOREIGN KEY(ID_AUXILIAR_QUATRO) REFERENCES AUXILIAR(ID_AUXILIAR),
		CONSTRAINT			fk_equipe_auxiliarcinco		FOREIGN KEY(ID_AUXILIAR_CINCO) REFERENCES AUXILIAR(ID_AUXILIAR),
	);

insert into EQUIPE (DT_DATA, ID_ENGENHEIRO_UM, ID_ENGENHEIRO_DOIS, ID_AUXILIAR_UM, ID_AUXILIAR_DOIS, ID_AUXILIAR_TRES, ID_AUXILIAR_QUATRO, ID_AUXILIAR_CINCO) values ('04/02/2016', 1, 1, 1, 1, 1, 1, 1);
insert into EQUIPE (DT_DATA, ID_ENGENHEIRO_UM, ID_ENGENHEIRO_DOIS, ID_AUXILIAR_UM, ID_AUXILIAR_DOIS, ID_AUXILIAR_TRES, ID_AUXILIAR_QUATRO, ID_AUXILIAR_CINCO) values ('05/02/2016', 2, 2, 2, 2, 2, 2, 2);

---------------------------------------------------------------------------
--Simulação
create table SIMULACAO
	(
		ID_SIMULACAO	int						not null identity(1,1),
		DT_DATA			date					null,
		ID_USUARIO		int						not null,
		NM_SIMULACAO	varchar(20)				not null,
		CONSTRAINT		pk_simulacao			PRIMARY KEY(ID_SIMULACAO),
		CONSTRAINT		fk_simulacao_usuario	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
	);

insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('28/04/2016', 1, 'simulação 10');
---------------------------------------------------------------------------
--Ponte
create table PONTE
	(
		ID_PONTE							int				not null identity(1,1),
		CD_PONTE							varchar(10)		not null,
		DS_IDENTIFICACAO_OBRA				varchar(60)		not null,
		DS_VIA								varchar(6)			not null,
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

--Documentos
create table PROJETO_ORIGINAL
	(
		ID_PROJETO_ORIGINAL		int						not null identity(1,1),
		DS_TITULO				varchar(30),		
		DS_LOTE					varchar(30),
		DS_VOLUME				varchar(30),
		DS_PAGINA				varchar(30),
		CONSTRAINT				pk_projetooriginal		PRIMARY KEY(ID_PROJETO_ORIGINAL)
	);
insert into PROJETO_ORIGINAL (DS_TITULO, DS_LOTE, DS_VOLUME, DS_PAGINA) values ('tit', 'lot', 'vol', 'pag');

create table CALCULO_ESTRUTURAL
	(
		ID_CALCULO_ESTRUTURAL	int						not null identity(1,1),
		DS_TITULO				varchar(30),		
		DS_LOTE					varchar(30),
		DS_VOLUME				varchar(30),
		DS_PAGINA				varchar(30),
		CONSTRAINT				pk_calculoestrutural	PRIMARY KEY(ID_CALCULO_ESTRUTURAL)
	);
insert into CALCULO_ESTRUTURAL (DS_TITULO, DS_LOTE, DS_VOLUME, DS_PAGINA) values ('tit', 'lot', 'vol', 'pag');

create table ESTUDO_TRAFEGO
	(
		ID_ESTUDO_TRAFEGO		int						not null identity(1,1),
		DS_TITULO				varchar(30),		
		DS_LOTE					varchar(30),
		DS_VOLUME				varchar(30),
		DS_PAGINA				varchar(30),
		CONSTRAINT				pk_estudotrafego		PRIMARY KEY(ID_ESTUDO_TRAFEGO)
	);
insert into ESTUDO_TRAFEGO (DS_TITULO, DS_LOTE, DS_VOLUME, DS_PAGINA) values ('tit', 'lot', 'vol', 'pag');

create table ESTUDO_HIDROLOGICO
	(
		ID_ESTUDO_HIDROLOGICO	int						not null identity(1,1),
		DS_TITULO				varchar(30),		
		DS_LOTE					varchar(30),
		DS_VOLUME				varchar(30),
		DS_PAGINA				varchar(30),
		CONSTRAINT				pk_estudohidrologico	PRIMARY KEY(ID_ESTUDO_HIDROLOGICO)
	);
insert into ESTUDO_HIDROLOGICO (DS_TITULO, DS_LOTE, DS_VOLUME, DS_PAGINA) values ('tit', 'lot', 'vol', 'pag');

create table PROJETO_REFORCO
	(
		ID_PROJETO_REFORCO		int					not null identity(1,1),
		DS_TITULO				varchar(30),		
		DS_LOTE					varchar(30),
		DS_VOLUME				varchar(30),
		DS_PAGINA				varchar(30),
		CONSTRAINT				pk_projetoreforco	PRIMARY KEY(ID_PROJETO_REFORCO)
	);
insert into PROJETO_REFORCO(DS_TITULO, DS_LOTE, DS_VOLUME, DS_PAGINA) values ('tit', 'lot', 'vol', 'pag');

create table ESTUDO_GEOTECNICO
	(
		ID_ESTUDO_GEOTECNICO	int						not null identity(1,1),
		DS_TITULO				varchar(30),		
		DS_LOTE					varchar(30),
		DS_VOLUME				varchar(30),
		DS_PAGINA				varchar(30),
		CONSTRAINT				pk_estudogeotecnico		PRIMARY KEY(ID_ESTUDO_GEOTECNICO)
	);
insert into ESTUDO_GEOTECNICO(DS_TITULO, DS_LOTE, DS_VOLUME, DS_PAGINA) values ('tit', 'lot', 'vol', 'pag');

create table INSPECAO_ANTERIOR
	(
		ID_INSPECAO_ANTERIOR	int				not null identity(1,1),
		DS_TITULO				varchar(30),		
		DS_LOTE					varchar(30),
		DS_VOLUME				varchar(30),
		DS_PAGINA				varchar(30),
		CONSTRAINT				pk_inspecao		PRIMARY KEY(ID_INSPECAO_ANTERIOR)
	);
insert into INSPECAO_ANTERIOR(DS_TITULO, DS_LOTE, DS_VOLUME, DS_PAGINA) values ('tit', 'lot', 'vol', 'pag');

create table DOCUMENTO
	(
		ID_DOCUMENTO			int								not null identity(1,1),
		ID_PROJETO_ORIGINAL		int								not null,
		ID_CALCULO_ESTRUTURAL	int								not null,
		ID_ESTUDO_TRAFEGO		int								not null,
		ID_ESTUDO_HIDROLOGICO	int								not null,
		ID_PROJETO_REFORCO		int								not null,
		ID_ESTUDO_GEOTECNICO	int								not null,
		ID_INSPECAO_ANTERIOR	int								not null,
		CONSTRAINT				pk_documento					PRIMARY KEY(ID_DOCUMENTO),
		CONSTRAINT				fk_documento_projetooriginal	FOREIGN KEY(ID_PROJETO_ORIGINAL) REFERENCES PROJETO_ORIGINAL(ID_PROJETO_ORIGINAL),
		CONSTRAINT				fk_documento_calculoestrutural	FOREIGN KEY(ID_CALCULO_ESTRUTURAL) REFERENCES CALCULO_ESTRUTURAL(ID_CALCULO_ESTRUTURAL),
		CONSTRAINT				fk_documento_estudotrafego		FOREIGN KEY(ID_ESTUDO_TRAFEGO) REFERENCES ESTUDO_TRAFEGO(ID_ESTUDO_TRAFEGO),
		CONSTRAINT				fk_documento_estudohidrologico	FOREIGN KEY(ID_ESTUDO_HIDROLOGICO) REFERENCES ESTUDO_HIDROLOGICO(ID_ESTUDO_HIDROLOGICO),
		CONSTRAINT				fk_documento_projetoreforco		FOREIGN KEY(ID_PROJETO_REFORCO) REFERENCES PROJETO_REFORCO(ID_PROJETO_REFORCO),
		CONSTRAINT				fk_documento_projetogeotecnico	FOREIGN KEY(ID_ESTUDO_GEOTECNICO) REFERENCES ESTUDO_GEOTECNICO(ID_ESTUDO_GEOTECNICO),
		CONSTRAINT				fk_documento_inspecaoanterior	FOREIGN KEY(ID_INSPECAO_ANTERIOR) REFERENCES INSPECAO_ANTERIOR(ID_INSPECAO_ANTERIOR)
	);

insert into DOCUMENTO (ID_PROJETO_ORIGINAL, ID_CALCULO_ESTRUTURAL, ID_ESTUDO_TRAFEGO, ID_ESTUDO_HIDROLOGICO, ID_PROJETO_REFORCO, ID_ESTUDO_GEOTECNICO, ID_INSPECAO_ANTERIOR) values (1, 1, 1, 1, 1, 1, 1);
---------------------------------------------------------------------------

--Morfologia

create table GRUPO
	(
		ID_GRUPO		int				not null identity(1,1),
		NM_NOME			varchar(40)		not null,
		CONSTRAINT		pk_grupo		PRIMARY KEY(ID_GRUPO)
	);
GO
insert into GRUPO (NM_NOME) values ('Lajes');
insert into GRUPO (NM_NOME) values ('Travessas');
insert into GRUPO (NM_NOME) values ('Vigas');

--create table ELEMENTO
--	(
--		ID_ELEMENTO		int					not null identity(1,1),
--		NM_NOME			varchar(100)		not null,
--		CD_ELEMENTO		varchar(5)			not null,
--		VL_K1			int					not null,
--		ID_GRUPO		int					not null,
--		CONSTRAINT		pk_elemento			PRIMARY KEY(ID_ELEMENTO),
--		CONSTRAINT		fk_elemento_grupo	FOREIGN KEY(ID_GRUPO) REFERENCES GRUPO(ID_GRUPO)
--	);
--GO
--insert into ELEMENTO (NM_NOME, CD_ELEMENTO, VL_K1, ID_GRUPO) values ('laje de concreto armado', '0123', 0.4, 1);
--insert into ELEMENTO (NM_NOME, CD_ELEMENTO, VL_K1, ID_GRUPO) values ('laje de concreto protendido', '0124', 0.5, 1);
--insert into ELEMENTO (NM_NOME, CD_ELEMENTO, VL_K1, ID_GRUPO) values ('travessa de concreto armado', '0125', 0.4, 1);
--insert into ELEMENTO (NM_NOME, CD_ELEMENTO, VL_K1, ID_GRUPO) values ('travessa de concreto armado', '0125', 0.4, 2);
--insert into ELEMENTO (NM_NOME, CD_ELEMENTO, VL_K1, ID_GRUPO) values ('travessa de concreto armado bastante armado, muito mesmo', '0125', 0.4, 2);

--create table MORFOLOGIA
--	(
--		ID_MORFOLOGIA	int						not null identity(1,1),
--		ID_GRUPO		int						not null,
		--cod
--		NR_QUANTIDADE	varchar(5)				not null,
--		ID_ELEMENTO		int						not null,
--		CONSTRAINT		pk_morfologia			PRIMARY KEY(ID_MORFOLOGIA),
--		CONSTRAINT		fk_morfologia_grupo		FOREIGN KEY(ID_GRUPO) REFERENCES GRUPO(ID_GRUPO),
--		CONSTRAINT		fk_morfologia_elemento	FOREIGN KEY(ID_ELEMENTO) REFERENCES ELEMENTO(ID_ELEMENTO)
		--tabelaFoto
--	);
--GO
--insert into MORFOLOGIA (ID_GRUPO, NR_QUANTIDADE, ID_ELEMENTO) values (1, 10, 1);
--insert into MORFOLOGIA (ID_GRUPO, NR_QUANTIDADE, ID_ELEMENTO) values (1, 20, 2);

--create table TIPO_MANIFESTACAO
--	(
--		ID_TIPO_MANIFESTACAO	int								not null identity(1,1),
--		NM_NOME					varchar(100)					not null,
--		NR_B					int								not null,
		DS_UNIDADE				varchar(3),
		--ABREVIADO
--		DS_UNIDADE_EX			varchar(5),
--		ID_ELEMENTO				int								not null,
--		CONSTRAINT				pk_tipomanifestacao				PRIMARY KEY(ID_TIPO_MANIFESTACAO),
--		CONSTRAINT				fk_tipomanifestacao_elemento	FOREIGN KEY(ID_ELEMENTO) REFERENCES ELEMENTO(ID_ELEMENTO)
--	);
--GO
--insert into TIPO_MANIFESTACAO (NM_NOME, NR_B, DS_UNIDADE, DS_UNIDADE_EX, ID_ELEMENTO) values ('Manchas de fogo', 1, 'm²', 'mm', 1);
--insert into TIPO_MANIFESTACAO (NM_NOME, NR_B, DS_UNIDADE, ID_ELEMENTO) values ('Manchas de umidade', 1, 'm²', 2);
--insert into TIPO_MANIFESTACAO (NM_NOME, NR_B, DS_UNIDADE, DS_UNIDADE_EX, ID_ELEMENTO) values ('Manchas', 1, 'm²', 'mm', 1);
--insert into TIPO_MANIFESTACAO (NM_NOME, NR_B, DS_UNIDADE, DS_UNIDADE_EX, ID_ELEMENTO) values ('Manchas de', 1, 'm²', 'mm', 1);

--create table ELEMENTO_MORFOLOGIA
--	(
--		ID_ELEMENTO_MORFOLOGIA	int									not null identity(1,1),
--		ID_ELEMENTO				int									not null,
--		ID_MORFOLOGIA			int									not null,
--		CONSTRAINT				pk_elementomorfologia				PRIMARY KEY(ID_ELEMENTO_MORFOLOGIA),
--		CONSTRAINT				fk_elementomorfologia_elemento		FOREIGN KEY(ID_ELEMENTO) REFERENCES ELEMENTO(ID_ELEMENTO),
--		CONSTRAINT				fk_elementomorfologia_morfologia	FOREIGN KEY(ID_MORFOLOGIA) REFERENCES MORFOLOGIA(ID_MORFOLOGIA)
--	);

--create table ELEMENTO_MANIFESTACAO
--	(
--		ID_ELEMENTO_MANIFESTACAO	int										not null identity(1,1),
--		ID_ELEMENTO					int										not null,
--		ID_MANIFESTACAO				int										not null,
--		CONSTRAINT					pk_elementomanifestacao					PRIMARY KEY(ID_ELEMENTO_MANIFESTACAO),
--		CONSTRAINT					fk_elementomanifestacao_elemento		FOREIGN KEY(ID_ELEMENTO) REFERENCES ELEMENTO(ID_ELEMENTO),
--		CONSTRAINT					fk_elementomanifestacao_manifestacao	FOREIGN KEY(ID_MANIFESTACAO) REFERENCES TIPO_MANIFESTACAO(ID_TIPO_MANIFESTACAO)
--	);

---------------------------------------------------------------------------

--Fotos

create table CODIGO_FOTO
	(
		ID_CODIGO_FOTO		int					not null identity(1,1),
		CD_FOTO				varchar(2)			not null,
		CONSTRAINT			pk_codigofoto		PRIMARY KEY(ID_CODIGO_FOTO)
	);
GO
insert into CODIGO_FOTO (CD_FOTO) values ('CA');
insert into CODIGO_FOTO (CD_FOTO) values ('C');
insert into CODIGO_FOTO (CD_FOTO) values ('CR');
insert into CODIGO_FOTO (CD_FOTO) values ('O');
insert into CODIGO_FOTO (CD_FOTO) values ('E');

create table DESCRICAO_FOTO
	(
		ID_DESCRICAO_FOTO	int					not null identity(1,1),
		DS_DESCRICAO		varchar(30)			not null,
		CD_MP				varchar(100)		not null,
		CONSTRAINT			pk_descricaofoto	PRIMARY KEY(ID_DESCRICAO_FOTO)
	);
GO
insert into DESCRICAO_FOTO (DS_DESCRICAO, CD_MP) values ('vista geral', '888');
insert into DESCRICAO_FOTO (DS_DESCRICAO, CD_MP) values ('vista lateral esquerda', '999');
insert into DESCRICAO_FOTO (DS_DESCRICAO, CD_MP) values ('placa da ponte', '777');


create table FOTO
	(
		ID_FOTO			int						not null identity(1,1),
		NM_NOME			varchar(20),
		DS_NUMERO		varchar(5)				not null,
		ID_CODIGO		int						not null,
		DS_ELEMENTO		varchar(20),
		ID_DESCRICAO	int						not null,
		CONSTRAINT		pk_foto					PRIMARY KEY(ID_FOTO),
		CONSTRAINT		fk_foto_codigofoto		FOREIGN KEY(ID_CODIGO) REFERENCES CODIGO_FOTO(ID_CODIGO_FOTO),
		CONSTRAINT		fk_foto_descricaofoto	FOREIGN KEY(ID_DESCRICAO) REFERENCES DESCRICAO_FOTO(ID_DESCRICAO_FOTO)

	);
GO
insert into FOTO (NM_NOME, DS_NUMERO, ID_CODIGO, DS_ELEMENTO, ID_DESCRICAO) values ('foto1', 'num1' , 2, 'elemento1', 2);

---------------------------------------------------------------------------

--Manifestacoes

create table DIMENSAO
	(
		ID_DIMENSAO		int				not null identity(1,1),
		DS_TAMANHO		varchar(10)		not null,
		CONSTRAINT		pk_dimensao		PRIMARY KEY(ID_DIMENSAO)
	);
GO
insert into DIMENSAO (DS_TAMANHO) values ('Pequena');
insert into DIMENSAO (DS_TAMANHO) values ('Média');
insert into DIMENSAO (DS_TAMANHO) values ('Grande');

create table REPARO
	(
		ID_REPARO		int				not null identity(1,1),
		NM_NOME			varchar(20)		not null,
		CONSTRAINT		pk_reparo		PRIMARY KEY(ID_REPARO)
	);
GO
insert into REPARO (NM_NOME) values ('Urgente');
insert into REPARO (NM_NOME) values ('Não urgente');

create table UNIDADE
	(
		ID_UNIDADE		int				not null identity(1,1),
		DS_UNIDADE		varchar(3)		not null,
		CONSTRAINT		pk_unidade		PRIMARY KEY(ID_UNIDADE)
	);
GO
insert into UNIDADE (DS_UNIDADE) values ('m²');

--create table MANIFESTACAO
--	(
--		ID_MANIFESTACAO			int									not null identity(1,1),
--		ID_ELEMENTO				int									not null,
--		NR_NUMERO				varchar(5)							not null,
--		ID_TIPO_MANIFESTACAO	int									not null,
--		ID_DIMENSAO				int									not null,
--		ID_REPARO				int									not null,
--		ID_UNIDADE				int									not null,
--		DS_TAMANHO				varchar(10)							not null,
--		DS_FOTO					varchar(5)							not null,
--		DS_OBSERVACAO			varchar(100),
--		CONSTRAINT				pk_manifestacao						PRIMARY KEY(ID_MANIFESTACAO),
--		CONSTRAINT				fk_manifestacao_elemento			FOREIGN KEY(ID_ELEMENTO) REFERENCES ELEMENTO(ID_ELEMENTO),
--		CONSTRAINT				fk_manifestacao_tipomanifestacao	FOREIGN KEY(ID_TIPO_MANIFESTACAO) REFERENCES TIPO_MANIFESTACAO(ID_TIPO_MANIFESTACAO),
--		CONSTRAINT				fk_manifestacao_dimensao			FOREIGN KEY(ID_DIMENSAO) REFERENCES DIMENSAO(ID_DIMENSAO),
--		CONSTRAINT				fk_manifestacao_reparo				FOREIGN KEY(ID_REPARO) REFERENCES REPARO(ID_REPARO),
--		CONSTRAINT				fk_manifestacao_unidade				FOREIGN KEY(ID_UNIDADE) REFERENCES UNIDADE(ID_UNIDADE)
--	);
--insert into MANIFESTACAO(ID_ELEMENTO, NR_NUMERO, ID_TIPO_MANIFESTACAO, ID_DIMENSAO, ID_REPARO, ID_UNIDADE, DS_TAMANHO, DS_FOTO, DS_OBSERVACAO) values (1, 'num', 1, 1, 1, 1, 'tam', 'foto', 'obs');
---------------------------------------------------------------------------

-- Cadastros

create table TIPO_ESTRUTURA_CODIGO
	(
		ID_TIPO_ESTRUTURA_CODIGO	int							not null identity(1,1),
		CD_TIPO_ESTRUTURA		varchar(10)					not null,
		NM_NOME					varchar(100)				not null,
		CONSTRAINT				pk_tipoestruturacodigo		PRIMARY KEY(ID_TIPO_ESTRUTURA_CODIGO)
	);
GO
insert into TIPO_ESTRUTURA_CODIGO (CD_TIPO_ESTRUTURA, NM_NOME) values ('4', 'item4');
insert into TIPO_ESTRUTURA_CODIGO (CD_TIPO_ESTRUTURA, NM_NOME) values ('5', 'item5');
insert into TIPO_ESTRUTURA_CODIGO (CD_TIPO_ESTRUTURA, NM_NOME) values ('6', 'item6');
 
create table NATUREZA_TRANSPOSICAO_CODIGO
	(
		ID_NATUREZA_TRANSPOSICAO_CODIGO		int								not null identity(1,1),
		CD_NATUREZA_TRANSPOSICAO			varchar(10)						not null,
		NM_NOME								varchar(100)					not null,
		CONSTRAINT							pk_naturezatransposicaocodigo	PRIMARY KEY(ID_NATUREZA_TRANSPOSICAO_CODIGO)
	);
GO
insert into NATUREZA_TRANSPOSICAO_CODIGO (CD_NATUREZA_TRANSPOSICAO, NM_NOME) values ('4', 'item4');
insert into NATUREZA_TRANSPOSICAO_CODIGO (CD_NATUREZA_TRANSPOSICAO, NM_NOME) values ('5', 'item5');
insert into NATUREZA_TRANSPOSICAO_CODIGO (CD_NATUREZA_TRANSPOSICAO, NM_NOME) values ('6', 'item6');
 
create table SISTEMA_CONSTRUTIVO_CODIGO
	(
		ID_SISTEMA_CONSTRUTIVO_CODIGO	int						not null identity(1,1),
		CD_SISTEMA_CONSTRUTIVO		varchar(10)				not null,
		NM_NOME						varchar(100)			not null,
		CONSTRAINT					pk_sistemaconstrutivo	PRIMARY KEY(ID_SISTEMA_CONSTRUTIVO_CODIGO)
	);
GO
insert into SISTEMA_CONSTRUTIVO_CODIGO (CD_SISTEMA_CONSTRUTIVO, NM_NOME) values ('1', 'item1');
insert into SISTEMA_CONSTRUTIVO_CODIGO (CD_SISTEMA_CONSTRUTIVO, NM_NOME) values ('2', 'item2');
insert into SISTEMA_CONSTRUTIVO_CODIGO (CD_SISTEMA_CONSTRUTIVO, NM_NOME) values ('3', 'item3');

create table SUPERINTENDENCIA
	(
		ID_SUPERINTENDENCIA		int						not null identity(1,1),
		NM_NOME					varchar(100)			not null,
		CONSTRAINT				pk_superintendencia		PRIMARY KEY(ID_SUPERINTENDENCIA)
	);
GO
insert into SUPERINTENDENCIA (NM_NOME) values ('Regional do DNIT no Estado do Paraná');
insert into SUPERINTENDENCIA (NM_NOME) values ('Regional do DNIT no Estado do Santa Catarina');

create table UNIDADE_LOCAL
	(
		ID_UNIDADE_LOCAL	int					not null identity(1,1),
		DS_UNIDADE			varchar(100)		not null,
		CONSTRAINT			pk_unidadelocal		PRIMARY KEY(ID_UNIDADE_LOCAL)
	);
GO
insert into UNIDADE_LOCAL (DS_UNIDADE) values ('Londrina 9/7');
insert into UNIDADE_LOCAL (DS_UNIDADE) values ('Campo mourão 9/2');
insert into UNIDADE_LOCAL (DS_UNIDADE) values ('Colombo 9/1');
insert into UNIDADE_LOCAL (DS_UNIDADE) values ('São José dos Pinhais 9/6');

--ERA TIPO
create table TIPO_APARELHO_APOIO
	(
		ID_TIPO_APARELHO_APOIO		int						not null identity(1,1),
		CD_TIPO_APARELHO_APOIO		varchar(3),
		CONSTRAINT					pk_tipoaparelhoapoio	PRIMARY KEY(ID_TIPO_APARELHO_APOIO)
	);
GO
insert into TIPO_APARELHO_APOIO (CD_TIPO_APARELHO_APOIO) values ('NP');
insert into TIPO_APARELHO_APOIO (CD_TIPO_APARELHO_APOIO) values ('FR');
--------------------

create table CADASTRO_DADO_BASICO
	(
		--parte 1(dados basicos)
		ID_CADASTRO_DADO_BASICO						int						not null identity(1,1),
		ID_TIPO_ESTRUTURA_CODIGO					int						not null,
		ID_NATUREZA_TRANSPOSICAO_CODIGO				int						not null,
		ID_SISTEMA_CONSTRUTIVO_CODIGO				int						not null,
		NR_RODOVIA_BR								varchar(10)				not null,
		DS_UF										varchar(2)				not null,
		DS_TRECHO_SNV								varchar(15)				not null,
		NR_LOCALIZACAO_KM							varchar(8)				not null,
		DS_CIDADE_PROXIMA							varchar(50)				not null,
		NR_ALTITUDE									varchar(10)				not null,
		NR_LATITUDE_GRAU							varchar(10)				not null,
		NR_LATITUDE_MINUTO							varchar(10)				not null,
		NR_LONGITUDE_GRAU							varchar(10)				not null,
		NR_LONGITUDE_MINUTO							varchar(10)				not null,

		DS_TIPO_ADMINISTRACAO						varchar(50)				not null,
		DS_ADMINISTRADOR							varchar(50)				not null,
		ID_SUPERINTENDENCIA							int						not null,
		ID_UNIDADE_LOCAL							int						not null,
		NM_NOME_PROJETISTA							varchar(100),
		NR_ANO_CONSTRUCAO							varchar(11),
		NM_NOME_CONSTRUTOR							varchar(100),
		NR_TREM_TIPO_CLASSE							varchar(20),
		DS_DOCUMENTO_PROJETO						varchar(100)			not null,
		DS_LOCAL_ARQUIVAMENTO_DOCUMENTOS_PROJETO	varchar(100)			not null,
		DS_DOCUMENTO_CONSTRUCAO						varchar(100)			not null,
		DS_LOCAL_ARQUIVAMENTO_DOCUMENTOS_CONSTRUCAO	varchar(100)			not null,
		DS_DOCUMENTOS_DIVERSOS						varchar(100)			not null,
		DS_LOCAL_ARQUIVAMENTO_DOCUMENTOS_DIVERSOS	varchar(100)			not null,
		NR_COMPRIMENTO								varchar(10)				not null,
		NR_LARGURA									varchar(10)				not null,
		DT_DATA_CADASTRAMENTO						varchar(10)				not null,
		CONSTRAINT									pk_cadastrodadobasico								PRIMARY KEY(ID_CADASTRO_DADO_BASICO),
		CONSTRAINT									fk_cadastrodadobasico_tipoestruturacodigo			FOREIGN KEY(ID_TIPO_ESTRUTURA_CODIGO) REFERENCES TIPO_ESTRUTURA_CODIGO(ID_TIPO_ESTRUTURA_CODIGO),
		CONSTRAINT									fk_cadastrodadobasico_naturezatransposicaocodigo	FOREIGN KEY(ID_NATUREZA_TRANSPOSICAO_CODIGO) REFERENCES NATUREZA_TRANSPOSICAO_CODIGO(ID_NATUREZA_TRANSPOSICAO_CODIGO),
		CONSTRAINT									fk_cadastrodadobasico_sistemaconstrutivocodigo		FOREIGN KEY(ID_SISTEMA_CONSTRUTIVO_CODIGO) REFERENCES SISTEMA_CONSTRUTIVO_CODIGO(ID_SISTEMA_CONSTRUTIVO_CODIGO),
		CONSTRAINT									fk_cadastrodadobasico_superintendencia				FOREIGN KEY(ID_SUPERINTENDENCIA) REFERENCES SUPERINTENDENCIA(ID_SUPERINTENDENCIA),
		CONSTRAINT									fkcadastrodadobasico_unidadelocal					FOREIGN KEY(ID_UNIDADE_LOCAL) REFERENCES UNIDADE_LOCAL(ID_UNIDADE_LOCAL)
	);

GO
insert into CADASTRO_DADO_BASICO (ID_TIPO_ESTRUTURA_CODIGO, ID_NATUREZA_TRANSPOSICAO_CODIGO, ID_SISTEMA_CONSTRUTIVO_CODIGO, NR_RODOVIA_BR,
 DS_UF, DS_TRECHO_SNV, NR_LOCALIZACAO_KM, DS_CIDADE_PROXIMA, NR_ALTITUDE, NR_LATITUDE_GRAU, NR_LATITUDE_MINUTO, NR_LONGITUDE_GRAU,
 NR_LONGITUDE_MINUTO, DS_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, ID_SUPERINTENDENCIA, ID_UNIDADE_LOCAL, DS_DOCUMENTO_PROJETO, 
 DS_LOCAL_ARQUIVAMENTO_DOCUMENTOS_PROJETO, DS_DOCUMENTO_CONSTRUCAO, DS_LOCAL_ARQUIVAMENTO_DOCUMENTOS_CONSTRUCAO, DS_DOCUMENTOS_DIVERSOS, 
 DS_LOCAL_ARQUIVAMENTO_DOCUMENTOS_DIVERSOS, NR_COMPRIMENTO, NR_LARGURA, DT_DATA_CADASTRAMENTO) values (1, 1, 1, 'br', 'uf', 
 'tre', 'loc', 'cid', 'alt', 'l1', 'l2', 'l3', 'l4', 'tAd', 'adm', 1, 1, 'doc', 'loc', 'doc', 'loc', 'doc', 'loc', 'com', 'lar', 'dat');

create table CADASTRO_DADO_CARACTERISTICA_FUNCIONAL
	(
		-- parte 2 (Dados sobre caracteristicas funcionais)
		ID_CADASTRO_DADO_CARACTERISTICA_FUNCIONAL			int				not null identity(1,1),
		ST_REGIAO_PLANA										char(1),
		ST_REGIAO_ONDULADA									char(1),
		ST_REGIAO_MONTANHOSA								char(1),
		NR_GREIDE_RAMPA_MAXIMA								varchar(5)		not null,
		ST_TRACADO_TANGENTE									char(1),
		ST_TRACADO_CURVO									char(1),
		NR_RAIO												varchar(5)		not null,
		ST_TRAVESSIA_ORTOGONAL								char(1),
		ST_TRAVESSIA_ESCONSA								char(1),
		NR_LARGURA_TOTAL_PISTA								varchar(5)		not null,
		ST_PAVIMENTO_ASFALTO								char(1),
		ST_PAVIMENTO_CONCRETO								char(1),
		ST_DRENOS_SIM										char(1),
		ST_DRENOS_NAO										char(1),
		NR_NUMERO_FAIXAS									varchar(5)		not null,
		NR_LARGURA_DE_UMA_FAIXA								varchar(5)		not null,
		ST_PINGADEIRAS_SIM									char(1),
		ST_PINGADEIRAS_NAO									char(1),
		ST_ACOSTAMENTO_SIM									char(1),
		ST_ACOSTAMENTO_NAO									char(1),
		NR_LARGURA_PASSEIO_ESQUERDA							varchar(5)		not null,
		NR_LARGURA_PASSEIO_DIREITA							varchar(5)		not null,
		NR_LARGURA_ACOSTAMENTO_ESQUERDA						varchar(5)		not null,
		NR_LARGURA_ACOSTAMENTO_DIREITA						varchar(5)		not null,
		ST_GUARDA_RODAS_PADRAO_ANTIGO						char(1),
		ST_GUARDA_RODAS_NEW_JERSEY							char(1),
		ST_GUARDA_RODAS_OUTRO								char(1),
		NR_PARA_VIADUTO_HORIZONTAL							varchar(5)		not null,
		NR_PARA_VIADUTO_VERTICAL							varchar(5)		not null,
		NR_PARA_PONTE_SEM_RIO_NAVEGAVEL_HORIZONTAL			varchar(5)		not null,
		NR_PARA_PONTE_SEM_RIO_NAVEGAVEL_VERTICAL			varchar(5)		not null,
		ST_PROTECAO_PILARES_CONTRA_CHOQUE_EMBARCACAO_SIM	char(1),
		ST_PROTECAO_PILARES_CONTRA_CHOQUE_EMBARCACAO_NAO	char(1),
		NR_NUMERO_TOTAL_JUNTAS								varchar(5)		not null,
		ST_TIPO_VEDACAO_NENHUMA_NOS_PILARES_ARTICULACAO		char(1),
		ST_TIPO_VEDACAO_TIPO								char(1),
		DS_TIPO_VEDACAO										varchar(5)		not null,
		NR_VMD												varchar(5)		not null,
		ST_FREQUENCIA_CARGA_MOVEL_ALTA						char(1),
		ST_FREQUENCIA_CARGA_MOVEL_MEDIA						char(1),
		ST_FREQUENCIA_CARGA_MOVEL_BAIXA						char(1),
		ST_FREQUENCIA_CARGA_EXCEPCIONAIS_FREQUENTE			char(1),
		ST_FREQUENCIA_CARGA_EXCEPCIONAIS_ESPORADICA			char(1),
		CONSTRAINT											pk_cadastrodadocaracteristica		PRIMARY KEY(ID_CADASTRO_DADO_CARACTERISTICA_FUNCIONAL)
	);

GO
insert into CADASTRO_DADO_CARACTERISTICA_FUNCIONAL (NR_GREIDE_RAMPA_MAXIMA, NR_RAIO, NR_LARGURA_TOTAL_PISTA,
 NR_NUMERO_FAIXAS, NR_LARGURA_DE_UMA_FAIXA, NR_LARGURA_PASSEIO_ESQUERDA, NR_LARGURA_PASSEIO_DIREITA, 
 NR_LARGURA_ACOSTAMENTO_ESQUERDA, NR_LARGURA_ACOSTAMENTO_DIREITA, NR_PARA_VIADUTO_HORIZONTAL, NR_PARA_VIADUTO_VERTICAL, 
 NR_PARA_PONTE_SEM_RIO_NAVEGAVEL_HORIZONTAL, NR_PARA_PONTE_SEM_RIO_NAVEGAVEL_VERTICAL, NR_NUMERO_TOTAL_JUNTAS, 
 DS_TIPO_VEDACAO, NR_VMD) values ('grei', 'raio', 'larg', 'num', 'lar', 'lare', 'lard', 'lar', 'lar', 'par', 'para', 
 'pa', 'para', 'num', 'tipo', 'vmd');

 create table CADASTRO_CARACTERISTICA_ESTRUTURA
	(
		-- parte 3 (Caracteristica da estrutura)
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA		int				not null identity(1,1),
		--ID_MATERIAL_LAJE							int				not null foreign key references MATERIAL(ID_MATERIAL),
		--ID_MATERIAL_VIGA_PRINCIPAL					int				not null foreign key references MATERIAL(ID_MATERIAL),
		--ID_MATERIAL_PILAR							int				not null foreign key references MATERIAL(ID_MATERIAL),
		--ID_MATERIAL_FUNDACAO						int				not null foreign key references MATERIAL_FUNDACAO(ID_MATERIAL_FUNDACAO),
		--ID_SECAO_TIPO_VIGA_PRINCIPAL				int				not null foreign key references SECAO_TIPO_VIGA_PRINCIPAL(ID_SECAO_TIPO_VIGA_PRINCIPAL),
		--ID_SECAO_TIPO_PILAR							int				not null foreign key references SECAO_TIPO_PILAR(ID_SECAO_TIPO_PILAR),
		--ID_SECAO_TIPO_FUNDACAO						int				not null foreign key references SECAO_TIPO_FUNDACAO(ID_SECAO_TIPO_FUNDACAO),
		
		DS_APOIO_UM									varchar(10),
		DS_APOIO_DOIS								varchar(10),
		DS_APOIO_TRES								varchar(10),
		DS_APOIO_QUATRO								varchar(10),
		DS_APOIO_CINCO								varchar(10),
		DS_APOIO_SEIS								varchar(10),
		DS_APOIO_SETE								varchar(10),
		DS_APOIO_OITO								varchar(10),
		ID_TIPO_UM									int						not null,
		ID_TIPO_DOIS								int						not null,
		ID_TIPO_TRES								int						not null,
		ID_TIPO_QUATRO								int						not null,
		ID_TIPO_CINCO								int						not null,
		ID_TIPO_SEIS								int						not null,
		ID_TIPO_SETE								int						not null,
		ID_TIPO_OITO								int						not null,
		NR_NUMERO_VAOS								varchar(10),
		NR_ALTURA_VIGA_APOIO						varchar(10),
		NR_NUMERO_JUNTAS_GERBER						varchar(10),
		NR_ALTURA_VIGA_VAO							varchar(10),
		NR_COMPRIMENTO_VAO_MAIOR					varchar(10),
		NR_ALTURA_MAXIMA_PILAR						varchar(10),
		ST_EXTREMIDADE_INICIAL_ENCONTRO				char(1),
		ST_EXTREMIDADE_INICIAL_BALANCO				char(1),
		ST_EXTREMIDADE_FINAL_ENCONTRO				char(1),
		ST_EXTREMIDADE_FINAL_BALANCO				char(1),
		ST_LAJE_APROXIMACAO_SIM						char(1),
		ST_LAJE_APROXIMACAO_NAO						char(1),
		CONSTRAINT									pk_cadastrocaracteristicaestrutura				PRIMARY KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA),
		CONSTRAINT									fk_cadastrocaracteristicaestrutura_tipoum		FOREIGN KEY(ID_TIPO_UM) REFERENCES TIPO_APARELHO_APOIO(ID_TIPO_APARELHO_APOIO),
		CONSTRAINT									fk_cadastrocaracteristicaestrutura_tipodois		FOREIGN KEY(ID_TIPO_DOIS) REFERENCES TIPO_APARELHO_APOIO(ID_TIPO_APARELHO_APOIO),
		CONSTRAINT									fk_cadastrocaracteristicaestrutura_tipotres		FOREIGN KEY(ID_TIPO_TRES) REFERENCES TIPO_APARELHO_APOIO(ID_TIPO_APARELHO_APOIO),
		CONSTRAINT									fk_cadastrocaracteristicaestrutura_tipoquatro	FOREIGN KEY(ID_TIPO_QUATRO) REFERENCES TIPO_APARELHO_APOIO(ID_TIPO_APARELHO_APOIO),
		CONSTRAINT									fk_cadastrocaracteristicaestrutura_tipocinco	FOREIGN KEY(ID_TIPO_CINCO) REFERENCES TIPO_APARELHO_APOIO(ID_TIPO_APARELHO_APOIO),
		CONSTRAINT									fk_cadastrocaracteristicaestrutura_tiposeis		FOREIGN KEY(ID_TIPO_SEIS) REFERENCES TIPO_APARELHO_APOIO(ID_TIPO_APARELHO_APOIO),
		CONSTRAINT									fk_cadastrocaracteristicaestrutura_tiposete		FOREIGN KEY(ID_TIPO_SETE) REFERENCES TIPO_APARELHO_APOIO(ID_TIPO_APARELHO_APOIO),
		CONSTRAINT									fk_cadastrocaracteristicaestrutura_tipooito		FOREIGN KEY(ID_TIPO_OITO) REFERENCES TIPO_APARELHO_APOIO(ID_TIPO_APARELHO_APOIO)							
	);

GO
insert into CADASTRO_CARACTERISTICA_ESTRUTURA (ID_TIPO_UM, ID_TIPO_DOIS, ID_TIPO_TRES, ID_TIPO_QUATRO, ID_TIPO_CINCO, ID_TIPO_SEIS, ID_TIPO_SETE, ID_TIPO_OITO) values (1, 1, 1, 1, 1, 1, 1, 1);

create table COMPONENTE
	(
		ID_COMPONENTE		int				not null identity(1,1),
		NM_COMPONENTE		varchar(20)		not null,
		CONSTRAINT			pk_componente	PRIMARY KEY(ID_COMPONENTE)
	);
GO
insert into COMPONENTE (NM_COMPONENTE) values ('Laje');
insert into COMPONENTE (NM_COMPONENTE) values ('Vigas Principais');
insert into COMPONENTE (NM_COMPONENTE) values ('Pilares');
insert into COMPONENTE (NM_COMPONENTE) values ('Fundações');

-- a tabela MATERIAL faz referencia aos codigos das combos box Lajes, VigasPrincipais e Pilares
create table MATERIAL
	(
		ID_MATERIAL		int				not null identity(1,1),
		CD_MATERIAL		varchar(3)		not null,
		CONSTRAINT		pk_material		PRIMARY KEY(ID_MATERIAL)
	);
GO
insert into MATERIAL (CD_MATERIAL) values ('CA');
insert into MATERIAL (CD_MATERIAL) values ('CP');
insert into MATERIAL (CD_MATERIAL) values ('AC');

create table COMPONENTE_MATERIAL_LAJE
	(
		ID_COMPONENTE_MATERIAL_LAJE				int		not null identity(1,1),
		ID_COMPONENTE							int		not null,
		ID_MATERIAL								int		not null,
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA	int		not null,
		CONSTRAINT								pk_componentemateriallaje										PRIMARY KEY(ID_COMPONENTE_MATERIAL_LAJE),
		CONSTRAINT								fk_componentemateriallaje_componente							FOREIGN KEY(ID_COMPONENTE) REFERENCES COMPONENTE(ID_COMPONENTE),
		CONSTRAINT								fk_componentemateriallaje_material								FOREIGN KEY(ID_MATERIAL) REFERENCES MATERIAL(ID_MATERIAL),
		CONSTRAINT								fk_componentemateriallaje_cadastrocaracteristicaestrutura		FOREIGN KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA) REFERENCES CADASTRO_CARACTERISTICA_ESTRUTURA(ID_CADASTRO_CARACTERISTICA_ESTRUTURA)
	);
-- Em COMPONENTE_MATERIAL_LAJE o atributo ID_COMPONENTE sempre será 1;
insert into COMPONENTE_MATERIAL_LAJE (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (1, 1, 1);
insert into COMPONENTE_MATERIAL_LAJE (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (1, 2, 1);
insert into COMPONENTE_MATERIAL_LAJE (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (1, 3, 1);

create table COMPONENTE_MATERIAL_VIGA_PRINCIPAL
	(
		ID_COMPONENTE_MATERIAL_VIGA_PRINCIPAL	int		not null identity(1,1),
		ID_COMPONENTE							int		not null,
		ID_MATERIAL								int		not null,
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA	int		not null,
		CONSTRAINT								pk_componentematerialvigaprincipal						PRIMARY KEY(ID_COMPONENTE_MATERIAL_VIGA_PRINCIPAL),
		CONSTRAINT								fk_componentematerialvigaprincipal_componente			FOREIGN KEY(ID_COMPONENTE) REFERENCES COMPONENTE(ID_COMPONENTE),
		CONSTRAINT								fk_componentematerialvigaprincipal_material				FOREIGN KEY(ID_MATERIAL) REFERENCES MATERIAL(ID_MATERIAL),
		CONSTRAINT								fk_componentematerialvigaprincipal_cadastrocaracteristicaestrutura		FOREIGN KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA) REFERENCES CADASTRO_CARACTERISTICA_ESTRUTURA(ID_CADASTRO_CARACTERISTICA_ESTRUTURA)

	);
-- Em COMPONENTE_MATERIAL_VIGA_PRINCIPAL o atributo ID_COMPONENTE sempre será 2;
insert into COMPONENTE_MATERIAL_VIGA_PRINCIPAL (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (2, 1, 1);
insert into COMPONENTE_MATERIAL_VIGA_PRINCIPAL (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (2, 2, 1);
insert into COMPONENTE_MATERIAL_VIGA_PRINCIPAL (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (2, 3, 1);

create table COMPONENTE_MATERIAL_PILARES
	(
		ID_COMPONENTE_MATERIAL_PILARES			int		not null identity(1,1),
		ID_COMPONENTE							int		not null,
		ID_MATERIAL								int		not null,
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA	int		not null,
		CONSTRAINT								pk_componentematerialpilares										PRIMARY KEY(ID_COMPONENTE_MATERIAL_PILARES),
		CONSTRAINT								fk_componentematerialpilares_componente								FOREIGN KEY(ID_COMPONENTE) REFERENCES COMPONENTE(ID_COMPONENTE),
		CONSTRAINT								fk_componentematerialpilares_material								FOREIGN KEY(ID_MATERIAL) REFERENCES MATERIAL(ID_MATERIAL),
		CONSTRAINT								fk_componentematerialpilares_cadastrocaracteristicaestrutura		FOREIGN KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA) REFERENCES CADASTRO_CARACTERISTICA_ESTRUTURA(ID_CADASTRO_CARACTERISTICA_ESTRUTURA)
	);
-- Em COMPONENTE_MATERIAL_PILARES o atributo ID_COMPONENTE sempre será 3;
insert into COMPONENTE_MATERIAL_PILARES (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (3, 1, 1);
insert into COMPONENTE_MATERIAL_PILARES (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (3, 2, 1);
insert into COMPONENTE_MATERIAL_PILARES (ID_COMPONENTE, ID_MATERIAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (3, 3, 1);

-- a tabela MATERIAL_FUNDACAO faz referencia aos codigos da combos box Fundacoes
create table MATERIAL_FUNDACAO
	(
		ID_MATERIAL_FUNDACAO		int				not null identity(1,1),
		CD_MATERIAL_FUNDACAO		varchar(4)		not null,
		CONSTRAINT					pk_materialfundacao		PRIMARY KEY(ID_MATERIAL_FUNDACAO)
	);
GO
insert into MATERIAL_FUNDACAO (CD_MATERIAL_FUNDACAO) values ('EMS');
insert into MATERIAL_FUNDACAO (CD_MATERIAL_FUNDACAO) values ('EPC');
insert into MATERIAL_FUNDACAO (CD_MATERIAL_FUNDACAO) values ('EM');

create table COMPONENTE_MATERIAL_FUNDACAO
	(
		ID_COMPONENTE_MATERIAL_FUNDACAO			int		not null identity(1,1),
		ID_COMPONENTE							int		not null,
		ID_MATERIAL_FUNDACAO					int		not null,
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA	int		not null,
		CONSTRAINT								pk_componentematerialfundacoes										PRIMARY KEY(ID_COMPONENTE_MATERIAL_FUNDACAO),
		CONSTRAINT								fk_componentematerialfundacoes_componente							FOREIGN KEY(ID_COMPONENTE) REFERENCES COMPONENTE(ID_COMPONENTE),
		CONSTRAINT								fk_componentematerialfundacoes_materialfundacao						FOREIGN KEY(ID_MATERIAL_FUNDACAO) REFERENCES MATERIAL_FUNDACAO(ID_MATERIAL_FUNDACAO),
		CONSTRAINT								fk_componentematerialfundacoes_cadastrocaracteristicaestrutura		FOREIGN KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA) REFERENCES CADASTRO_CARACTERISTICA_ESTRUTURA(ID_CADASTRO_CARACTERISTICA_ESTRUTURA)
	);

-- Em COMPONENTE_MATERIAL_FUNDACAO o atributo ID_COMPONENTE sempre será 4;
insert into COMPONENTE_MATERIAL_FUNDACAO (ID_COMPONENTE, ID_MATERIAL_FUNDACAO, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (4, 1, 1);
insert into COMPONENTE_MATERIAL_FUNDACAO (ID_COMPONENTE, ID_MATERIAL_FUNDACAO, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (4, 2, 1);
insert into COMPONENTE_MATERIAL_FUNDACAO (ID_COMPONENTE, ID_MATERIAL_FUNDACAO, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (4, 3, 1);

-- a tabela SECAO_TIPO_VIGA_PRINCIPAL faz referencia aos codigos da combo box VigasPrincipais
create table SECAO_TIPO_VIGA_PRINCIPAL
	(
		ID_SECAO_TIPO_VIGA_PRINCIPAL		int								not null identity(1,1),
		CD_SECAO_TIPO_VIGA_PRINCIPAL		varchar(3),
		CONSTRAINT							pk_secaotipovigaprincipal		PRIMARY KEY(ID_SECAO_TIPO_VIGA_PRINCIPAL)
	);
GO
insert into SECAO_TIPO_VIGA_PRINCIPAL (CD_SECAO_TIPO_VIGA_PRINCIPAL) values ('2T');
insert into SECAO_TIPO_VIGA_PRINCIPAL (CD_SECAO_TIPO_VIGA_PRINCIPAL) values ('3T');
insert into SECAO_TIPO_VIGA_PRINCIPAL (CD_SECAO_TIPO_VIGA_PRINCIPAL) values ('4T');

create table COMPONENTE_SECAO_TIPO_VIGA_PRINCIPAL
	(
		ID_COMPONENTE_SECAO_TIPO_VIGA_PRINCIPAL		int		not null identity(1,1),
		ID_COMPONENTE								int		not null,
		ID_SECAO_TIPO_VIGA_PRINCIPAL				int		not null,
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA		int		not null,
		CONSTRAINT									pk_componentesecaotipovigaprincipal										PRIMARY KEY(ID_COMPONENTE_SECAO_TIPO_VIGA_PRINCIPAL),
		CONSTRAINT									fk_componentesecaotipovigaprincipal_componente							FOREIGN KEY(ID_COMPONENTE) REFERENCES COMPONENTE(ID_COMPONENTE),
		CONSTRAINT									fk_componentesecaotipovigaprincipal_secaotipovigaprincipal				FOREIGN KEY(ID_SECAO_TIPO_VIGA_PRINCIPAL) REFERENCES SECAO_TIPO_VIGA_PRINCIPAL(ID_SECAO_TIPO_VIGA_PRINCIPAL),
		CONSTRAINT									fk_componentesecaotipovigaprincipal_cadastrocaracteristicaestrutura		FOREIGN KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA) REFERENCES CADASTRO_CARACTERISTICA_ESTRUTURA(ID_CADASTRO_CARACTERISTICA_ESTRUTURA)
	);

--Em COMPONENETE_SECAO_TIPO_VIGA_PRINCIPAL o atributo ID_COMPONENTE sempre será 2;
insert into COMPONENTE_SECAO_TIPO_VIGA_PRINCIPAL (ID_COMPONENTE, ID_SECAO_TIPO_VIGA_PRINCIPAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (2, 1, 1);
insert into COMPONENTE_SECAO_TIPO_VIGA_PRINCIPAL (ID_COMPONENTE, ID_SECAO_TIPO_VIGA_PRINCIPAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (2, 2, 1);
insert into COMPONENTE_SECAO_TIPO_VIGA_PRINCIPAL (ID_COMPONENTE, ID_SECAO_TIPO_VIGA_PRINCIPAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (2, 3, 1);

-- a tabela SECAO_TIPO_VIGA_PRINCIPAL faz referencia aos codigos da combo box pilar
create table SECAO_TIPO_PILAR
	(
		ID_SECAO_TIPO_PILAR		int						not null identity(1,1),
		CD_SECAO_TIPO_PILAR		varchar(4),
		CONSTRAINT				pk_secaotipopilar		PRIMARY KEY(ID_SECAO_TIPO_PILAR)
	);
GO
insert into SECAO_TIPO_PILAR (CD_SECAO_TIPO_PILAR) values ('2CI');
insert into SECAO_TIPO_PILAR (CD_SECAO_TIPO_PILAR) values ('3CI');
insert into SECAO_TIPO_PILAR (CD_SECAO_TIPO_PILAR) values ('3CC');

create table COMPONENTE_SECAO_TIPO_PILAR
	(
		ID_COMPONENTE_SECAO_TIPO_PILAR			int		not null identity(1,1),
		ID_COMPONENTE							int		not null,
		ID_SECAO_TIPO_PILAR						int		not null,
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA	int		not null,
		CONSTRAINT								pk_componentesecaotipopilar										PRIMARY KEY(ID_COMPONENTE_SECAO_TIPO_PILAR),
		CONSTRAINT								fk_componentesecaotipopilar_componente							FOREIGN KEY(ID_COMPONENTE) REFERENCES COMPONENTE(ID_COMPONENTE),
		CONSTRAINT								fk_componentesecaotipopilar_secaotipopilar						FOREIGN KEY(ID_SECAO_TIPO_PILAR) REFERENCES SECAO_TIPO_PILAR(ID_SECAO_TIPO_PILAR),
		CONSTRAINT								fk_componentesecaotipopilar_cadastrocaracteristicaestrutura		FOREIGN KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA) REFERENCES CADASTRO_CARACTERISTICA_ESTRUTURA(ID_CADASTRO_CARACTERISTICA_ESTRUTURA)
	);

-- Em COMPONENTE_SECAO_TIPO_PILAR o atributo ID_COMPONENTE sempre sera 3;
insert into COMPONENTE_SECAO_TIPO_PILAR (ID_COMPONENTE, ID_SECAO_TIPO_PILAR, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (3, 1, 1);
insert into COMPONENTE_SECAO_TIPO_PILAR (ID_COMPONENTE, ID_SECAO_TIPO_PILAR, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (3, 2, 1);
insert into COMPONENTE_SECAO_TIPO_PILAR (ID_COMPONENTE, ID_SECAO_TIPO_PILAR, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (3, 3, 1);

create table SECAO_TIPO_FUNDACAO
	(
		ID_SECAO_TIPO_FUNDACAO		int				not null identity(1,1),
		CD_SECAO_TIPO_FUNDACAO		varchar(3),
		CONSTRAINT					pk_secaotipofundacao		PRIMARY KEY(ID_SECAO_TIPO_FUNDACAO)

	);
GO
insert into SECAO_TIPO_FUNDACAO (CD_SECAO_TIPO_FUNDACAO) values ('DI');
insert into SECAO_TIPO_FUNDACAO (CD_SECAO_TIPO_FUNDACAO) values ('BE');

create table COMPONENTE_SECAO_TIPO_FUNDACAO
	(
		ID_COMPONENTE_SECAO_TIPO_FUNDACAO		int			not null identity(1,1),
		ID_COMPONENTE							int			not null,
		ID_SECAO_TIPO_FUNDACAO					int			not null,
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA	int			not null,
		CONSTRAINT								pk_componentesecaotipofundacao										PRIMARY KEY(ID_COMPONENTE_SECAO_TIPO_FUNDACAO),
		CONSTRAINT								fk_componentesecaotipofundacao_componente							FOREIGN KEY(ID_COMPONENTE) REFERENCES COMPONENTE(ID_COMPONENTE),
		CONSTRAINT								fk_componentesecaotipofundacao_secaotipofundacao					FOREIGN KEY(ID_SECAO_TIPO_FUNDACAO) REFERENCES SECAO_TIPO_FUNDACAO(ID_SECAO_TIPO_FUNDACAO),
		CONSTRAINT								fk_componentesecaotipofundacao_cadastrocaracteristicaestrutura		FOREIGN KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA) REFERENCES CADASTRO_CARACTERISTICA_ESTRUTURA(ID_CADASTRO_CARACTERISTICA_ESTRUTURA)
	);

-- Em COMPONENTE_SECAO_TIPO_FUNDACAO o atributo ID_COMPONENTE sempre será 4;
insert into COMPONENTE_SECAO_TIPO_FUNDACAO (ID_COMPONENTE, ID_SECAO_TIPO_FUNDACAO, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (4, 1, 1);
insert into COMPONENTE_SECAO_TIPO_FUNDACAO (ID_COMPONENTE, ID_SECAO_TIPO_FUNDACAO, ID_CADASTRO_CARACTERISTICA_ESTRUTURA) values (4, 2, 1);

create table CADASTRO_OUTRO_ASPECTO
	(
		 --parte 4 (Outros aspectos)
		ID_CADASTRO_OUTRO_ASPECTO					int							not null  identity(1,1),
		NR_DESNIVEL_MAXIMO_ENTRE_GREIDE_TERRENO		varchar(10),
		NR_LAMINA_DAGUA_NORMAL						varchar(10),
		NR_LAMINA_DAGUA_CHEIA						varchar(10),
		NR_ACRESCIMO_DISTANCIA						varchar(10),
		DS_ROTAS_ALTERNATIVAS						varchar(300),
		ST_FUNDACOES_ESTAO_EM_SOLO_MOLE_SIM			char(1),
		ST_FUNDACOES_ESTAO_EM_SOLO_MOLE_NAO			char(1),
		ST_VIBRACAO_DA_ESTRUTURA_EXCESSIVA_SIM		char(1),
		ST_VIBRACAO_DA_ESTRUTURA_EXCESSIVA_NAO		char(1),
		ST_REGIME_DO_RIO_TORRENCIAL_SIM				char(1),
		ST_REGIME_DO_RIO_TORRENCIAL_NAO				char(1),
		ST_LEITO_DO_RIO_ERODIVEL_SIM				char(1),
		ST_LEITO_DO_RIO_ERODIVEL_NAO				char(1),
		ST_MEIO_AMBIENTE_AGRESSIVO_SIM				char(1),
		ST_MEIO_AMBIENTE_AGRESSIVO_NAO				char(1),
		ST_SECAO_DE_VAZAO_ADEQUADA_SIM				char(1),
		ST_SECAO_DE_VAZAO_ADEQUADA_NAO				char(1),
		ST_EXISTE_DRENAGEM_INTERIOR_CAIXAO_SIM		char(1),
		ST_EXISTE_DRENAGEM_INTERIOR_CAIXAO_NAO		char(1),
		ST_HISTORICO_MANUTENCAO_BOA					char(1),
		ST_HISTORICO_MANUTENCAO_REGULAR				char(1),
		ST_HISTORICO_MANUTENCAO_RUIM				char(1),
		ST_ROTAS_ALTERNATIVAS_EXISTEM				char(1),
		ST_ROTAS_ALTERNATIVAS_NAO_EXISTEM			char(1),
		DS_MELHOR_EPOCA_VISTORIAS					varchar(50),
		ST_PERIODICIDADE_NORMAL						char(1),
		ST_PERIODICIDADE_REDUZIDA					char(1),
		ST_PERIODICIDADE_DILATADA					char(1),
		ST_PERIODICIDADE_ESPECIAL_CONSULTOR			char(1),
		ST_PERIODICIDADE_ESPECIAL_L_MAIOR_DUZENTOS	char(1),
		ST_PERIODICIDADE_ESPECIAL_EQUIPAMENTO		char(1),
		ST_PERIODICIDADE_PARCIAL					char(1),
		ST_ACESSO_DIRETO_BINOCULO					char(1),
		ST_ACESSO_EQUIPAMENTO_ESPECIAL				char(1),
		DS_VAOS_DIRETO_BINOCULO						varchar(10),
		DS_VAOS_EQUIPAMENTO_ESPECIAL				varchar(10),
		CONSTRAINT									pk_cadastrooutroaspecto			PRIMARY KEY(ID_CADASTRO_OUTRO_ASPECTO)
	);

GO
insert into CADASTRO_OUTRO_ASPECTO (NR_DESNIVEL_MAXIMO_ENTRE_GREIDE_TERRENO) values ('desn');

create table CADASTRO 
	(
		ID_CADASTRO											int			not null identity(1,1),
		ID_CADASTRO_DADO_BASICO								int			not null,
		ID_CADASTRO_DADO_CARACTERISTICA_FUNCIONAL			int			not null,
		ID_CADASTRO_CARACTERISTICA_ESTRUTURA				int			not null,
		ID_CADASTRO_OUTRO_ASPECTO							int			not null,
		CONSTRAINT										pk_cadastro											PRIMARY KEY(ID_CADASTRO),
		CONSTRAINT										fk_cadastro_cadastrodadobasico						FOREIGN KEY(ID_CADASTRO_DADO_BASICO) REFERENCES CADASTRO_DADO_BASICO(ID_CADASTRO_DADO_BASICO),
		CONSTRAINT										fk_cadastro_cadastrodadocaracteristicafuncional		FOREIGN KEY(ID_CADASTRO_DADO_CARACTERISTICA_FUNCIONAL) REFERENCES CADASTRO_DADO_CARACTERISTICA_FUNCIONAL(ID_CADASTRO_DADO_CARACTERISTICA_FUNCIONAL),
		CONSTRAINT										fk_cadastro_cadastrocaracteristicaestrutura			FOREIGN KEY(ID_CADASTRO_CARACTERISTICA_ESTRUTURA) REFERENCES CADASTRO_CARACTERISTICA_ESTRUTURA(ID_CADASTRO_CARACTERISTICA_ESTRUTURA),
		CONSTRAINT										fk_cadastro_cadastrooutroaspecto					FOREIGN KEY(ID_CADASTRO_OUTRO_ASPECTO) REFERENCES CADASTRO_OUTRO_ASPECTO(ID_CADASTRO_OUTRO_ASPECTO)
	);
GO 
insert into CADASTRO (ID_CADASTRO_DADO_BASICO, ID_CADASTRO_DADO_CARACTERISTICA_FUNCIONAL, ID_CADASTRO_CARACTERISTICA_ESTRUTURA, ID_CADASTRO_OUTRO_ASPECTO) values (1, 1, 1, 1);

--SEPARAR EM MAIS TABELAS******
create table PRO_DEZ
	(
		ID_PRO_DEZ										int			not null identity(1,1),
		--comentarios gerais
		ST_CONDICOES_ESTABILIDADE_BOA					char(1),
		ST_CONDICOES_ESTABILIDADE_SOFRIVEL				char(1),
		ST_CONDICOES_ESTABILIDADE_PRECARIA				char(1),
		ST_CONDICOES_CONSERVACAO_BOA					char(1),
		ST_CONDICOES_CONSERVACAO_REGULAR				char(1),
		ST_CONDICOES_CONSERVACAO_SOFRIVEL				char(1),
		ST_CONDICOES_CONSERVACAO_RUIM					char(1),
		ST_NIVEL_VIBRACAO_TABULEIRO_NORMAL				char(1),
		ST_NIVEL_VIBRACAO_TABULEIRO_INTENSO				char(1),
		ST_NIVEL_VIBRACAO_TABULEIRO_EXAGERADO			char(1),
		ST_INSPECAO_ESPECIALIZADA_SIM					char(1),
		ST_INSPECAO_ESPECIALIZADA_NAO					char(1),
		ST_INSPECAO_ESPECIALIZADA_URGENTE_SIM			char(1),
		ST_INSPECAO_ESPECIALIZADA_URGENTE_NAO			char(1),
		ST_JA_HOUVE_ANTERIORMENTE_SIM					char(1),
		ST_JA_HOUVE_ANTERIORMENTE_NAO					char(1),
		DS_OBSERVACOES_ADICIONAIS						varchar(200),

		-- 1 laje
		NR_LAJE_NOTE_TECNICA							varchar(10),
		ST_LAJE_BURACO_EXISTE							char(1),
		ST_LAJE_BURACO_EMINENTE							char(1),
		ST_LAJE_ARMADURA_EXPOSTA_MUITO_OXIDADA			char(1),
		ST_LAJE_ARMADURA_EXPOSTA_GRANDE_INCIDENCIA		char(1),
		ST_LAJE_CONCRETO_DESAGREGADO_MUITA_INTENSIDADE	char(1),
		ST_LAJE_CONCRETO_DESAGREGADO_GRANDE_INCIDENCIA	char(1),
		ST_LAJE_FISSURAS_FORTE_INFILTRACAO				char(1),
		ST_LAJE_FISSURAS_GRANDE_INCIDENCIA				char(1),
		ST_LAJE_MARCAS_INFILTRACAO_FORTE_INFILTRACAO	char(1),
		ST_LAJE_MARCAS_INFILTRACAO_GRANDES_INCIDENCIA	char(1),
		ST_LAJE_ASPECTO_CONCRETO_MA_QUALIDADE			char(1),
		ST_LAJE_COBRIMENTO_AUSENTE_POUCO				char(1),
		DS_LAJE_LOCAL_BURACO							varchar(30),
		DS_LAJE_LOCAL_ARMADURA_EXPOSTA					varchar(30),
		DS_LAJE_LOCAL_CONCRETO_DESGREGADO				varchar(30),
		DS_LAJE_LOCAL_FISSURASs							varchar(30),
		DS_LAJE_LOCAL_MARCAS_INFILTRACAO				varchar(30),
		DS_LAJE_LOCAL_ASPECTO_CONCRETO					varchar(30),
		DS_LAJE_LOCAL_COBRIMENTO						varchar(30),
		DS_LAJE_QUANTIDADE_BURACO						varchar(30),
		DS_LAJE_QUANTIDADE_ARMADURA_EXPOSTA				varchar(30),
		DS_LAJE_QUANTIDADE_CONCRETO_DESGREGADO			varchar(30),
		DS_LAJE_QUANTIDADE_FISSURAS						varchar(30),
		DS_LAJE_QUANTIDADE_MARCAS_INFILTRACAO			varchar(30),
		DS_LAJE_QUANTIDADE_ASPECTO_CONCRETO				varchar(30),
		DS_LAJE_QUANTIDADE_COBRIMENTO					varchar(30),

		-- 2 Vigamento Principal
		NR_VIGAMENTO_PRINCIPAL_NOTA_TECNICA								varchar(10),
		ST_VIGAMENTO_PRINCIPAL_FISSURAS_FINAS_ALGUMAS					char(1),
		ST_VIGAMENTO_PRINCIPAL_FISSURAS_FINAS_GRANDE_INCIDENCIA			char(1),
		ST_VIGAMENTO_PRINCIPAL_TRINCAS_ALGUMAS							char(1),
		ST_VIGAMENTO_PRINCIPAL_TRINCAS_GRANDE_INCIDENCIA				char(1),
		ST_VIGAMENTO_PRINCIPAL_ARMADURA_PRINCIPAL_EXPOSTA				char(1),
		ST_VIGAMENTO_PRINCIPAL_ARMADURA_PRINCIPAL_MUITO_OXIDADA			char(1),
		ST_VIGAMENTO_PRINCIPAL_DESAGREGACAO_CONCRETOU_MUITO_INTENSO		char(1),
		ST_VIGAMENTO_PRINCIPAL_DESAGREGACAO_CONCRETOU_GRANDE_INCIDENCIA	char(1),
		ST_VIGAMENTO_PRINCIPAL_DENTE_GERBER_QUEBRADO_DESPEDACADO		char(1),
		ST_VIGAMENTO_PRINCIPAL_DENTE_GERBER_TRINCADO					char(1),
		ST_VIGAMENTO_PRINCIPAL_DEFORMACAO_EXAGERADA						char(1),
		ST_VIGAMENTO_PRINCIPAL_ASPECTO_CONCRETO_MA_QUALIDADE			char(1),
		ST_VIGAMENTO_PRINCIPAL_COBRIMENTO_AUSENTE_POUCO					char(1),
		DS_VIGAMENTO_PRINCIPAL_LOCAL_FISSURAS_FINAS						varchar(30),
		DS_VIGAMENTO_PRINCIPAL_LOCAL_TRINCAS							varchar(30),
		DS_VIGAMENTO_PRINCIPAL_LOCAL_ARMADURA_PRINCIPAL					varchar(30),
		DS_VIGAMENTO_PRINCIPAL_LOCAL_DESGREGACAO_CONCRETO				varchar(30),
		DS_VIGAMENTO_PRINCIPAL_LOCAL_DENTE_GERBER						varchar(30),
		DS_VIGAMENTO_PRINCIPAL_LOCAL_DEFORMACAO							varchar(30),
		DS_VIGAMENTO_PRINCIPAL_LOCAL_ASPECTO_CONCRETO					varchar(30),
		DS_VIGAMENTO_PRINCIPAL_LOCAL_COBRIMENTO							varchar(30),
		DS_VIGAMENTO_PRINCIPAL_QUANTIDADE_FISSURAS_FINAS				varchar(30),
		DS_VIGAMENTO_PRINCIPAL_QUANTIDADE_TRINCAS						varchar(30),
		DS_VIGAMENTO_PRINCIPAL_QUANTIDADE_ARMADURA_PRINCIPAL			varchar(30),
		DS_VIGAMENTO_PRINCIPAL_QUANTIDADE_DESGREGACAO_CONCRETO			varchar(30),
		DS_VIGAMENTO_PRINCIPAL_QUANTIDADE_DENTE_GERBER					varchar(30),
		DS_VIGAMENTO_PRINCIPAL_QUANTIDADE_DEFORMACAO					varchar(30),
		DS_VIGAMENTO_PRINCIPAL_QUANTIDADE_ASPECTO_CONCRETO				varchar(30),
		DS_VIGAMENTO_PRINCIPAL_QUANTIDADE_COBRIMENTO					varchar(30),

		-- 3 Mesoestrutura
		NR_MESOESTRUTURA_NOTA_TECNICA							varchar(10),
		ST_MESOESTRUTURA_ARMADURA_EXPOSTA_MUITO_OXIDADA			char(1),
		ST_MESOESTRUTURA_ARMADURA_EXPOSTA_GRANDE_INCIDENCIA		char(1),
		ST_MESOESTRUTURA_CONCRETO_DESAGREGADO_MUITO_INTENSIDADE	char(1),
		ST_MESOESTRUTURA_CONCRETO_DESAGREGADO_GRANDE_INCIDENCIA	char(1),
		ST_MESOESTRUTURA_FISSURAS_FORTE_INFILTRACAO				char(1),
		ST_MESOESTRUTURA_FISSURAS_MUITO_OXIDADA					char(1),
		ST_MESOESTRUTURA_APARELHOS_APOIO_DANIFICADO				char(1),
		ST_MESOESTRUTURA_APARELHOS_APOIO_GRANDE_INCIDENCIA		char(1),
		ST_MESOESTRUTURA_ASPECTO_CONCRETO_MA_QUALIDADE			char(1),
		ST_MESOESTRUTURA_ASPECTO_CONCRETO_TRINCADO				char(1),
		ST_MESOESTRUTURA_COBRIMENTO_EXAGERADA					char(1),
		ST_MESOESTRUTURA_DEPRUMO_HA								char(1),
		ST_MESOESTRUTURA_DESLOCABILIDADE_PILARES_FORTE			char(1),
		DS_MESOESTRUTURA_LOCAL_ARMADURA_EXPOSTA					varchar(30),
		DS_MESOESTRUTURA_LOCAL_CONCRETO_DESAGREGADO				varchar(30),
		DS_MESOESTRUTURA_LOCAL_FISSURAS							varchar(30),
		DS_MESOESTRUTURA_LOCAL_APARELHO_APOIO					varchar(30),
		DS_MESOESTRUTURA_LOCAL_ASPECTO_CONCRETO					varchar(30),
		DS_MESOESTRUTURA_LOCAL_COBRIMENTO						varchar(30),
		DS_MESOESTRUTURA_LOCAL_DESAPRUMO						varchar(30),
		DS_MESOESTRUTURA_LOCAL_DESLOCABILIDADE_PILARES			varchar(30),
		DS_MESOESTRUTURA_QUANTIDADE_ARMADURA_EXPOSTA			varchar(30),
		DS_MESOESTRUTURA_QUANTIDADE_CONCRETO_DESAGREGADO		varchar(30),
		DS_MESOESTRUTURA_QUANTIDADE_FISSURAS					varchar(30),
		DS_MESOESTRUTURA_QUANTIDADE_APARELHO_APOIO				varchar(30),
		DS_MESOESTRUTURA_QUANTIDADE_ASPECTO_CONCRETO			varchar(30),
		DS_MESOESTRUTURA_QUANTIDADE_COBRIMENTO					varchar(30),
		DS_MESOESTRUTURA_QUANTIDADE_DESAPRUMO					varchar(30),
		DS_MESOESTRUTURA_QUANTIDADE_DESLOCABILIDADE_PILARES		varchar(30),

		-- 4 infraestrutura
		NR_INFRAESTRUTURA_NOTA_TECNICA							varchar(10),
		ST_INFRAESTRUTURA_RECALQUE_FUNDACAO_HA					char(1),
		ST_INFRAESTRUTURA_DESLOCAMENTO_FUNDACAO_HA				char(1),
		ST_INFRAESTRUTURA_EROSAO_TERRENO_FUNDACAO_HA			char(1),
		ST_INFRAESTRUTURA_ESTACAS_DESENTERRADAS_HAa				char(1),
		DS_INFRAESTRUTURA_LOCAL_RECALQUE_FUNDACAO				varchar(30),
		DS_INFRAESTRUTURA_LOCAL_DESLOCAMENTO_FUNDACAO			varchar(30),
		DS_INFRAESTRUTURA_LOCAL_EROSAO_TERRENO_FUNDACAO			varchar(30),
		DS_INFRAESTRUTURA_LOCAL_ESTACAS_DESENTERRADAS			varchar(30),
		DS_INFRAESTRUTURA_QUANTIDADE_RECALQUE_FUNDACAO			varchar(30),
		DS_INFRAESTRUTURA_QUANTIDADE_DESLOCAMENTO_FUNDACAO		varchar(30),
		DS_INFRAESTRUTURA_QUANTIDADE_EROSAO_TERRENO_FUNDACAO	varchar(30),
		DS_INFRAESTRUTURA_QUANTIDADE_ESTACAO_DESENTERRADAS		varchar(30),

		-- 5 Pista Acesso
		NR_PISTA_ACESSO_NOTA_TECNICA							varchar(10),
		ST_PISTA_ACESSO_IRREGULARIDADE_PAVIMENTO_MUITO_INTENSIDADE	char(1),
		ST_PISTA_ACESSO_IRREGULARIDADE_PAVIMENTO_GRANDE_EXTENSAO	char(1),
		ST_PISTA_ACESSO_JUNTA_DILATACAO_FALTANDO_INOPERANTE		char(1),
		ST_PISTA_ACESSO_JUNTA_DILATACAO_MUITO_PROBLEMATICA		char(1),
		ST_PISTA_ACESSO_PONTE_DEGRAU_ACENTUADO					char(1),
		ST_PISTA_ACESSO_PONTE_CONCORDANCIA_PROBLEMATICA			char(1),
		ST_PISTA_ACESSO_ACIDENTES_VEICULOS_FREQUENTE			char(1),
		ST_PISTA_ACESSO_ACIDENTES_VEICULOS_EVENTUAL				char(1),
		DS_PISTA_ACESSO_LOCAL_IRREGULARIDADE_PAVIMENTO			varchar(30),
		DS_PISTA_ACESSO_LOCAL_JUNTAS_DILATACAO					varchar(30),
		DS_PISTA_ACESSO_LOCAL_ACESSO_PONTE						varchar(30),
		DS_PISTA_ACESSO_LOCAL_ACIDENTES_VEICULOS				varchar(30),
		DS_PISTA_ACESSO_QUANTIDADE_IRREGULARIDADE_PAVIMENTO		varchar(30),
		DS_PISTA_ACESSO_QUANTIDADE_JUNTA_DILATACAO				varchar(30),
		DS_PISTA_ACESSO_QUANTIDADE_ACESSOS_PONTE				varchar(30),
		DS_PISTA_ACESSO_QUANTIDADE_ACIDENTES_VEICULOS			varchar(30),
		CONSTRAINT												pk_prodez			PRIMARY KEY(ID_PRO_DEZ)
	);
insert into PRO_DEZ (DS_PISTA_ACESSO_QUANTIDADE_ACIDENTES_VEICULOS) values ('n');
---------------------------------------------------------------------------
create table PONTE
	(
		ID_PONTE			int						not null identity(1,1),
		CD_CODIGO_PONTE		varchar(20)				not null,
		ID_EQUIPE			int						null,
		--ID_MANIFESTACAO	int		not null foreign key references MANIFESTACAO(ID_MANIFESTACAO),
		--ID_PRO_DEZ			int		not null foreign key references PRO_DEZ(ID_PRO_DEZ),
		--ID_MODELO_EMEA	int		not null foreign key references MODELO_EMEA(ID_MODELO_EMEA),
		--ID_RELATORIO	int		not null foreign key references RELATORIO(ID_RELATORIO),
		ID_DOCUMENTO		int						null,
		ID_CADASTRO			int						null,
		CONSTRAINT			pk_ponte				PRIMARY KEY(ID_PONTE),
		CONSTRAINT			fk_ponte_equipe			FOREIGN KEY(ID_EQUIPE) REFERENCES EQUIPE(ID_EQUIPE),
		CONSTRAINT			fk_ponte_documento		FOREIGN KEY(ID_DOCUMENTO) REFERENCES DOCUMENTO(ID_DOCUMENTO),
		CONSTRAINT			fk_ponte_cadastro		FOREIGN KEY(ID_CADASTRO) REFERENCES CADASTRO(ID_CADASTRO)
	);
insert into PONTE (CD_CODIGO_PONTE, ID_EQUIPE, ID_DOCUMENTO, ID_CADASTRO)  values ('codigo', 1, 1, 1);
--insert into PONTE (idEquipe, idManifestacao, idPro10, idDocumento, idCadastro) values (1, 1, 1, 1, 1);

create table PONTE_MORFOLOGIA
	(
		ID_PONTE_MORFOLOGIA		int									not null identity(1,1),
		ID_PONTE				int									not null,
		ID_MORFOLOGIA			int									not null,
		CONSTRAINT				pk_pontemorfologia					PRIMARY KEY(ID_PONTE_MORFOLOGIA),
		CONSTRAINT				fk_pontemorfologia_ponte			FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT				fk_pontemorfologia_morfologia		FOREIGN KEY(ID_MORFOLOGIA) REFERENCES MORFOLOGIA(ID_MORFOLOGIA)
	);

create table PONTE_FOTO
	(
		ID_PONTE_FOTO			int						not null identity(1,1),
		ID_PONTE				int						not null,
		ID_FOTO					int						not null,
		CONSTRAINT				pk_pontefoto			PRIMARY KEY(ID_PONTE_FOTO),
		CONSTRAINT				fk_pontefoto_ponte		FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT				fk_pontefoto_foto		FOREIGN KEY(ID_FOTO) REFERENCES FOTO(ID_FOTO)
	);

create table PONTE_MANIFESTACAO
	(
		ID_PONTE_MANIFESTACAO	int										not null identity(1,1),
		ID_PONTE				int										not null,
		ID_MANIFESTACAO			int										not null,
		CONSTRAINT				pk_pontemanifestacao					PRIMARY KEY(ID_PONTE_MANIFESTACAO),
		CONSTRAINT				fk_pontemanifestacao_ponte				FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE),
		CONSTRAINT				fk_pontemanifestacao_manifestacao		FOREIGN KEY(ID_MANIFESTACAO) REFERENCES MANIFESTACAO(ID_MANIFESTACAO)
	);

---------------------------------------------------------------------------