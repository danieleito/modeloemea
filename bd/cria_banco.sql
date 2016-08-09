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

---------------------------------------------------------------------------

--UF
create table UF
	(
		ID_UF				int				not null identity(1,1),
		DS_UF				varchar(30)		not null,
		SG_UF				varchar(2)		not null,
		CONSTRAINT			pk_uf			PRIMARY KEY(ID_UF)
	);

---------------------------------------------------------------------------

--Via
create table VIA
	(
		ID_VIA			int				not null identity(1,1),
		DS_VIA			varchar(10)		not null,
		CONSTRAINT		pk_via			PRIMARY KEY(ID_VIA)
	);

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

--Manifestacao
create table MANIFESTACAO
	(
		ID_MANIFESTACAO			int						not null identity(1,1),
		NM_MANIFESTACAO			varchar(100)			not null,
		DS_BETA					varchar(10)				not null,
		CONSTRAINT				pk_manifestacao			PRIMARY KEY(ID_MANIFESTACAO)
	);

---------------------------------------------------------------------------

--------------------------------DADOS PARA PREENCHIMENTO CADASTRO-----------------------------------

--Natureza de transposição
create table NATUREZA_TRANSPOSICAO
	(
		ID_NATUREZA_TRANSPOSICAO			int								not null identity(1,1),
		DS_NATUREZA_TRANSPOSICAO			varchar(50)						not null,
		CONSTRAINT							pk_naturezatransposicao			PRIMARY KEY(ID_NATUREZA_TRANSPOSICAO)
	);

--Tipo de estrutura
create table TIPO_ESTRUTURA
	(
		ID_TIPO_ESTRUTURA			int				not null identity(1,1),
		DS_TIPO_ESTRUTURA		varchar(50)		not null,
		CONSTRAINT		pk_tipoestrutura			PRIMARY KEY(ID_TIPO_ESTRUTURA)
	);

--Sistema Construtivo
create table SISTEMA_CONSTRUTIVO
	(
		ID_SISTEMA_CONSTRUTIVO			int						not null identity(1,1),
		DS_SISTEMA_CONSTRUTIVO			varchar(50)				not null,
		CONSTRAINT						pk_sistemaconstrutivo	PRIMARY KEY(ID_SISTEMA_CONSTRUTIVO)
	);

--Trem-tipo
create table TREM_TIPO
	(
		ID_TREM_TIPO			int				not null identity(1,1),
		DS_TREM_TIPO			varchar(30)		not null,
		CONSTRAINT				pk_tremtipo		PRIMARY KEY(ID_TREM_TIPO)
	);

--Tipo de região
create table TIPO_REGIAO
	(
		ID_TIPO_REGIAO		int					not null identity(1,1),
		DS_TIPO_REGIAO		varchar(30)			not null,
		CONSTRAINT			pk_tiporegiao		PRIMARY KEY(ID_TIPO_REGIAO)
	);

--Tipo de traçado
create table TIPO_TRACADO
	(
		ID_TIPO_TRACADO		int					not null identity(1,1),
		DS_TIPO_TRACADO		varchar(30)			not null,
		CONSTRAINT			pk_tipotracado		PRIMARY KEY(ID_TIPO_TRACADO)
	);

--Tipo de administração
create table TIPO_ADMINISTRACAO
	(
		ID_TIPO_ADMINISTRACAO			int						not null identity(1,1),
		DS_TIPO_ADMINISTRACAO			varchar(30)				not null,
		CONSTRAINT						pk_tipoadministracao	PRIMARY KEY(ID_TIPO_ADMINISTRACAO)
	);


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

---------------------------------------------------------------------------

create table ELEMENTOS_UFPR
	(
		ID_ELEMENTO_UFPR		int						not null identity(1,1),
		CD_ELEMENTO				int,
		DS_ELEMENTO				varchar(100),
		DS_CAPA1				varchar(10)				not null,
		CONSTRAINT				pk_elementosufpr		PRIMARY KEY(ID_ELEMENTO_UFPR)
	);

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
		ID_IDENTIFICACAO_OBRA_SGO		int													not null identity(1,1),
		ID_PONTE						int													not null,
		DT_DATA_INSPECAO				date,
		NM_INSPETOR						varchar(50),
		CONSTRAINT						pk_identificacaoobrasgo								PRIMARY KEY(ID_IDENTIFICACAO_OBRA_SGO),
		CONSTRAINT						fk_identificacaoobrasgo_ponte						FOREIGN KEY(ID_PONTE) REFERENCES PONTE(ID_PONTE)
	);

create table CONDICOES_SGO
	(
		ID_CONDICOES_SGO				int				not null identity(1,1),
		DS_CONDICAO_ESTABILIDADE		varchar(20),
		DS_CONDICAO_CONSERVACAO			varchar(20),
		DS_OBSERVACOES					varchar(80),
		DS_NOTA_TECNICA					varchar(20),
		CONSTRAINT						pk_condicoessgo	PRIMARY KEY(ID_CONDICOES_SGO)
	);

create table LAUDO_ESPECIALIZADO_SGO
	(
		ID_LAUDO_ESPECIALIZADO_SGO					int							not null identity(1,1),
		DT_DATA_LAUDO								date,
		DS_CONSULTOR								varchar(30),
		DS_OBSERVACOES								varchar(80),
		CONSTRAINT									pk_laudoespecializadosgo	PRIMARY KEY(ID_LAUDO_ESPECIALIZADO_SGO)
	);

create table MONITORAMENTO_SGO
	(
		ID_MONITORAMENTO_SGO			int							not null identity(1,1),
		DS_PERIODO						varchar(20),
		DS_TIPO_MONITORAMENTO			varchar(20),
		DS_EXECUTOR						varchar(30),
		DS_CUSTO						varchar(20),
		DS_OBJETO						varchar(80),
		DS_TECNICAS						varchar(80),
		CONSTRAINT						pk_monitoramentosgo			PRIMARY KEY(ID_MONITORAMENTO_SGO)
	);

create table INSPECAO_ROTINEIRA
	(
		ID_INSPECAO_ROTINEIRA								int															not null identity(1,1),
		ID_INSPECAO											int															not null,
		ID_IDENTIFICACAO_OBRA_SGO							int															not null,
		ID_CONDICOES_SGO									int															not null,
		ID_LAUDO_ESPECIALIZADO_SGO							int															not null,
		ID_MONITORAMENTO_SGO								int															not null,
		DS_RELATORIO										varchar(80)													not null,
		CONSTRAINT											pk_inspecaorotineira										PRIMARY KEY(ID_INSPECAO_ROTINEIRA),
		CONSTRAINT											fk_inspecaorotineira_inspecao								FOREIGN KEY(ID_INSPECAO) REFERENCES INSPECAO(ID_INSPECAO),
		CONSTRAINT											fk_inspecaorotineira_identificacaoobrasgo					FOREIGN KEY(ID_IDENTIFICACAO_OBRA_SGO) REFERENCES IDENTIFICACAO_OBRA_SGO(ID_IDENTIFICACAO_OBRA_SGO),
		CONSTRAINT											fk_inspecaorotineira_condicaosgo							FOREIGN KEY(ID_CONDICOES_SGO) REFERENCES CONDICOES_SGO(ID_CONDICOES_SGO),
		CONSTRAINT											fk_inspecaorotineira_laudoespecializadosgo					FOREIGN KEY(ID_LAUDO_ESPECIALIZADO_SGO) REFERENCES LAUDO_ESPECIALIZADO_SGO(ID_LAUDO_ESPECIALIZADO_SGO),
		CONSTRAINT											fk_inspecaorotineira_monitoramentosgo						FOREIGN KEY(ID_MONITORAMENTO_SGO) REFERENCES MONITORAMENTO_SGO(ID_MONITORAMENTO_SGO)
	);

---------------------------------------------------------------------------

create table DANOS_ELEMENTOS_SGO
	(
		ID_DANOS_ELEMENTOS_SGO		int								not null identity(1,1),
		ID_INSPECAO_ROTINEIRA		int								not null,
		DS_ELEMENTO					varchar(30),
		DS_NOTA						varchar(20),
		DS_DANO						varchar(20),
		DS_UNIDADE					varchar(20),
		DS_QUANTIDADE				varchar(20),
		DS_EXTENSAO_RELATIVA		varchar(20),
		DS_LOCALIZACAO				varchar(20),
		CONSTRAINT					pk_danoselementossgo			PRIMARY KEY(ID_DANOS_ELEMENTOS_SGO),
		CONSTRAINT					fk_danoselementossgo			FOREIGN KEY(ID_INSPECAO_ROTINEIRA) REFERENCES INSPECAO_ROTINEIRA(ID_INSPECAO_ROTINEIRA)
	);

create table INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO
	(
		ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO		int																not null identity(1,1),
		ID_INSPECAO_ROTINEIRA							int																not null,
		DS_ELEMENTO										varchar(30),
		DS_NOTA											varchar(20),
		DS_INSUFICIENCIA								varchar(20),
		DS_CAUSA_PROVAVEL								varchar(20),
		DS_COMENTARIOS									varchar(20),
		CONSTRAINT										pk_insuficienciasestruturaiselementossgo						PRIMARY KEY(ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO),
		CONSTRAINT										fk_insuficienciasestruturaiselementossgo_inspecaorotineira		FOREIGN KEY(ID_INSPECAO_ROTINEIRA) REFERENCES INSPECAO_ROTINEIRA(ID_INSPECAO_ROTINEIRA)
	);

---------------------------------------------------------------------------
