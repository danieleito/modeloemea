-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: EMEA
-- Source Schemata: EMEA
-- Created: Wed Sep 21 16:11:55 2016
-- Workbench Version: 6.3.7
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema EMEA
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `EMEA` ;
CREATE SCHEMA IF NOT EXISTS `EMEA` ;

use EMEA;

-- ----------------------------------------------------------------------------
-- Table EMEA.INSPECAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`INSPECAO` (
  `ID_INSPECAO` INT NOT NULL AUTO_INCREMENT,
  `ID_PONTE` INT NOT NULL,
  `DT_DATA` DATE NOT NULL,
  `ID_USUARIO` INT NOT NULL,
  `ID_MODELO` INT NOT NULL,
  `ID_IDENTIFICACAO_OBRA_SGO` INT NOT NULL,
  `ID_CONDICOES_SGO` INT NOT NULL,
  `ID_LAUDO_ESPECIALIZADO_SGO` INT NOT NULL,
  `ID_MONITORAMENTO_SGO` INT NOT NULL,
  `DS_RELATORIO` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`ID_INSPECAO`),
  CONSTRAINT `fk_inspecao_usuario`
    FOREIGN KEY (`ID_USUARIO`)
    REFERENCES `EMEA`.`USUARIO` (`ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspecao_ponte`
    FOREIGN KEY (`ID_PONTE`)
    REFERENCES `EMEA`.`PONTE` (`ID_PONTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspecao_modelo`
    FOREIGN KEY (`ID_MODELO`)
    REFERENCES `EMEA`.`MODELO` (`ID_MODELO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspecao_identificacaoobrasgo`
    FOREIGN KEY (`ID_IDENTIFICACAO_OBRA_SGO`)
    REFERENCES `EMEA`.`IDENTIFICACAO_OBRA_SGO` (`ID_IDENTIFICACAO_OBRA_SGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspecao_condicaosgo`
    FOREIGN KEY (`ID_CONDICOES_SGO`)
    REFERENCES `EMEA`.`CONDICOES_SGO` (`ID_CONDICOES_SGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspecao_laudoespecializadosgo`
    FOREIGN KEY (`ID_LAUDO_ESPECIALIZADO_SGO`)
    REFERENCES `EMEA`.`LAUDO_ESPECIALIZADO_SGO` (`ID_LAUDO_ESPECIALIZADO_SGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspecao_monitoramentosgo`
    FOREIGN KEY (`ID_MONITORAMENTO_SGO`)
    REFERENCES `EMEA`.`MONITORAMENTO_SGO` (`ID_MONITORAMENTO_SGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.ARQUIVO_ANEXO_CADASTRO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`ARQUIVO_ANEXO_CADASTRO` (
  `ID_ARQUIVO_ANEXO_CADASTRO` INT NOT NULL AUTO_INCREMENT,
  `ID_PONTE` INT NOT NULL,
  `DS_ARQUIVO` VARCHAR(20) NOT NULL,
  `DS_TIPO_ARQUIVO` VARCHAR(10) NOT NULL,
  `NR_NUMERO` VARCHAR(3) NOT NULL,
  `DS_DESCRICAO` VARCHAR(20) NOT NULL,
  `DS_REGISTRO` VARCHAR(10) NOT NULL,
  `DT_DATA_ANEXACAO` DATE NOT NULL,
  `ID_IMAGEM` INT NULL,
  PRIMARY KEY (`ID_ARQUIVO_ANEXO_CADASTRO`),
  CONSTRAINT `fk_arquivoanexocadastro_ponte`
    FOREIGN KEY (`ID_PONTE`)
    REFERENCES `EMEA`.`PONTE` (`ID_PONTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_arquivoanexocadastro_imagem`
    FOREIGN KEY (`ID_IMAGEM`)
    REFERENCES `EMEA`.`IMAGEM` (`ID_IMAGEM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.ARQUIVO_ANEXO_INSPECAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`ARQUIVO_ANEXO_INSPECAO` (
  `ID_ARQUIVO_ANEXO_INSPECAO` INT NOT NULL AUTO_INCREMENT,
  `ID_INSPECAO` INT NOT NULL,
  `DS_ARQUIVO` VARCHAR(20) NOT NULL,
  `DS_TIPO_ARQUIVO` VARCHAR(10) NOT NULL,
  `NR_NUMERO` VARCHAR(3) NOT NULL,
  `DS_DESCRICAO` VARCHAR(20) NOT NULL,
  `DS_REGISTRO` VARCHAR(10) NOT NULL,
  `DT_DATA_ANEXACAO` DATE NOT NULL,
  `ID_IMAGEM` INT NULL,
  PRIMARY KEY (`ID_ARQUIVO_ANEXO_INSPECAO`),
  CONSTRAINT `fk_arquivoanexoinspecao_inspecao`
    FOREIGN KEY (`ID_INSPECAO`)
    REFERENCES `EMEA`.`INSPECAO` (`ID_INSPECAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_arquivoanexoinspecao_imagem`
    FOREIGN KEY (`ID_IMAGEM`)
    REFERENCES `EMEA`.`IMAGEM` (`ID_IMAGEM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.TIPO_USUARIO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`TIPO_USUARIO` (
  `ID_TIPO_USUARIO` INT NOT NULL AUTO_INCREMENT,
  `DS_TIPO` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID_TIPO_USUARIO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.USUARIO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`USUARIO` (
  `ID_USUARIO` INT NOT NULL AUTO_INCREMENT,
  `NM_NOME` VARCHAR(50) NOT NULL,
  `DS_USUARIO` VARCHAR(20) NOT NULL,
  `DS_EMAIL` VARCHAR(30) NOT NULL,
  `DS_SENHA` VARCHAR(20) NOT NULL,
  `ID_TIPO_USUARIO` INT NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  CONSTRAINT `fk_usuario_tipousuario`
    FOREIGN KEY (`ID_TIPO_USUARIO`)
    REFERENCES `EMEA`.`TIPO_USUARIO` (`ID_TIPO_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.DADOS_MANIFESTACAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`DADOS_MANIFESTACAO` (
  `ID_DADOS_MANIFESTACAO` INT NOT NULL AUTO_INCREMENT,
  `DS_FOTO` VARCHAR(10) NULL,
  `DS_TAMANHO` VARCHAR(10) NULL,
  `DS_NUMERO` VARCHAR(20) NULL,
  `ID_MANIFESTACOES_EXTENSAO` INT NULL,
  `ID_MANIFESTACOES_URGENCIA` INT NULL,
  PRIMARY KEY (`ID_DADOS_MANIFESTACAO`),
  CONSTRAINT `fk_dadosmanifestacao_manifestacoes_extensao`
    FOREIGN KEY (`ID_MANIFESTACOES_EXTENSAO`)
    REFERENCES `EMEA`.`MANIFESTACOES_EXTENSAO` (`ID_MANIFESTACOES_EXTENSAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dadosmanifestacao_manifestacoes_urgencia`
    FOREIGN KEY (`ID_MANIFESTACOES_URGENCIA`)
    REFERENCES `EMEA`.`MANIFESTACOES_URGENCIA` (`ID_MANIFESTACOES_URGENCIA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.UF
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`UF` (
  `ID_UF` INT NOT NULL AUTO_INCREMENT,
  `DS_UF` VARCHAR(30) NOT NULL,
  `SG_UF` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`ID_UF`));

-- ----------------------------------------------------------------------------
-- Table EMEA.ELEMENTO_UFPR_MANIFESTACAO_UFPR
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`ELEMENTO_UFPR_MANIFESTACAO_UFPR` (
  `ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR` INT NOT NULL AUTO_INCREMENT,
  `ID_ELEMENTO_UFPR` INT NOT NULL,
  `ID_MANIFESTACAO_UFPR` INT NOT NULL,
  PRIMARY KEY (`ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR`),
  CONSTRAINT `fk_elementoufprmanifestacaoufpr_elementoufpr`
    FOREIGN KEY (`ID_ELEMENTO_UFPR`)
    REFERENCES `EMEA`.`ELEMENTO_UFPR` (`ID_ELEMENTO_UFPR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_elementoufprmanifestacaoufpr_manifestacaoufpr`
    FOREIGN KEY (`ID_MANIFESTACAO_UFPR`)
    REFERENCES `EMEA`.`MANIFESTACAO_UFPR` (`ID_MANIFESTACAO_UFPR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.VIA
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`VIA` (
  `ID_VIA` INT NOT NULL AUTO_INCREMENT,
  `DS_VIA` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID_VIA`));

-- ----------------------------------------------------------------------------
-- Table EMEA.SUPERINTENDENCIA_REGIONAL
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`SUPERINTENDENCIA_REGIONAL` (
  `ID_SUPERINTENDENCIA_REGIONAL` INT NOT NULL AUTO_INCREMENT,
  `DS_SUPERINTENDENCIA_REGIONAL` VARCHAR(100) NOT NULL,
  `ID_UF` INT NULL,
  PRIMARY KEY (`ID_SUPERINTENDENCIA_REGIONAL`),
  CONSTRAINT `fk_superintendenciaregional_uf`
    FOREIGN KEY (`ID_UF`)
    REFERENCES `EMEA`.`UF` (`ID_UF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.INSPECAO_MANIFESTACAO_ELEMENTO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`INSPECAO_MANIFESTACAO_ELEMENTO` (
  `ID_INSPECAO_MANIFESTACAO_ELEMENTO` INT NOT NULL AUTO_INCREMENT,
  `ID_INSPECAO` INT NOT NULL,
  `ID_DADOS_MANIFESTACAO` INT NOT NULL,
  `ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR` INT NOT NULL,
  PRIMARY KEY (`ID_INSPECAO_MANIFESTACAO_ELEMENTO`),
  CONSTRAINT `fk_inspecaomanifestacaoelemento_inspecao`
    FOREIGN KEY (`ID_INSPECAO`)
    REFERENCES `EMEA`.`INSPECAO` (`ID_INSPECAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspecaomanifestacaoelemento_dadosmanifestacao`
    FOREIGN KEY (`ID_DADOS_MANIFESTACAO`)
    REFERENCES `EMEA`.`DADOS_MANIFESTACAO` (`ID_DADOS_MANIFESTACAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspecaomanifestacaoelemento_elementoufprelementoufpr`
    FOREIGN KEY (`ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR`)
    REFERENCES `EMEA`.`ELEMENTO_UFPR_MANIFESTACAO_UFPR` (`ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.UNIDADE_LOCAL
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`UNIDADE_LOCAL` (
  `ID_UNIDADE_LOCAL` INT NOT NULL AUTO_INCREMENT,
  `DS_UNIDADE_LOCAL` VARCHAR(50) NOT NULL,
  `ID_SUPERINTENDENCIA_REGIONAL` INT NOT NULL,
  PRIMARY KEY (`ID_UNIDADE_LOCAL`),
  CONSTRAINT `fk_unidadelocal_superintendenciaregional`
    FOREIGN KEY (`ID_SUPERINTENDENCIA_REGIONAL`)
    REFERENCES `EMEA`.`SUPERINTENDENCIA_REGIONAL` (`ID_SUPERINTENDENCIA_REGIONAL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.SIMULACAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`SIMULACAO` (
  `ID_SIMULACAO` INT NOT NULL AUTO_INCREMENT,
  `DT_DATA` DATE NOT NULL,
  `ID_USUARIO` INT NOT NULL,
  `NM_SIMULACAO` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID_SIMULACAO`),
  CONSTRAINT `fk_simulacao_usuario`
    FOREIGN KEY (`ID_USUARIO`)
    REFERENCES `EMEA`.`USUARIO` (`ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.DANOS_ELEMENTOS_SGO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`DANOS_ELEMENTOS_SGO` (
  `ID_DANOS_ELEMENTOS_SGO` INT NOT NULL AUTO_INCREMENT,
  `ID_INSPECAO` INT NOT NULL,
  `DS_ELEMENTO` VARCHAR(30) NULL,
  `DS_NOTA` VARCHAR(20) NULL,
  `DS_DANO` VARCHAR(20) NULL,
  `DS_UNIDADE` VARCHAR(20) NULL,
  `DS_QUANTIDADE` VARCHAR(20) NULL,
  `DS_EXTENSAO_RELATIVA` VARCHAR(20) NULL,
  `DS_LOCALIZACAO` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_DANOS_ELEMENTOS_SGO`),
  CONSTRAINT `fk_danoselementossgo_inspecao`
    FOREIGN KEY (`ID_INSPECAO`)
    REFERENCES `EMEA`.`INSPECAO` (`ID_INSPECAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.ELEMENTO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`ELEMENTO` (
  `ID_ELEMENTO` INT NOT NULL AUTO_INCREMENT,
  `NM_ELEMENTO` VARCHAR(100) NOT NULL,
  `DS_CAPA` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID_ELEMENTO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO` (
  `ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO` INT NOT NULL AUTO_INCREMENT,
  `ID_INSPECAO` INT NOT NULL,
  `DS_ELEMENTO` VARCHAR(30) NULL,
  `DS_NOTA` VARCHAR(20) NULL,
  `DS_INSUFICIENCIA` VARCHAR(20) NULL,
  `DS_CAUSA_PROVAVEL` VARCHAR(20) NULL,
  `DS_COMENTARIOS` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO`),
  CONSTRAINT `fk_insuficienciasestruturaiselementossgo_inspecao`
    FOREIGN KEY (`ID_INSPECAO`)
    REFERENCES `EMEA`.`INSPECAO` (`ID_INSPECAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.MANIFESTACAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`MANIFESTACAO` (
  `ID_MANIFESTACAO` INT NOT NULL AUTO_INCREMENT,
  `NM_MANIFESTACAO` VARCHAR(100) NOT NULL,
  `DS_BETA` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID_MANIFESTACAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.NATUREZA_TRANSPOSICAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`NATUREZA_TRANSPOSICAO` (
  `ID_NATUREZA_TRANSPOSICAO` INT NOT NULL AUTO_INCREMENT,
  `DS_NATUREZA_TRANSPOSICAO` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_NATUREZA_TRANSPOSICAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.TIPO_ESTRUTURA
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`TIPO_ESTRUTURA` (
  `ID_TIPO_ESTRUTURA` INT NOT NULL AUTO_INCREMENT,
  `DS_TIPO_ESTRUTURA` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_TIPO_ESTRUTURA`));

-- ----------------------------------------------------------------------------
-- Table EMEA.SISTEMA_CONSTRUTIVO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`SISTEMA_CONSTRUTIVO` (
  `ID_SISTEMA_CONSTRUTIVO` INT NOT NULL AUTO_INCREMENT,
  `DS_SISTEMA_CONSTRUTIVO` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_SISTEMA_CONSTRUTIVO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.TREM_TIPO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`TREM_TIPO` (
  `ID_TREM_TIPO` INT NOT NULL AUTO_INCREMENT,
  `DS_TREM_TIPO` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID_TREM_TIPO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.TIPO_REGIAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`TIPO_REGIAO` (
  `ID_TIPO_REGIAO` INT NOT NULL AUTO_INCREMENT,
  `DS_TIPO_REGIAO` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID_TIPO_REGIAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.TIPO_TRACADO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`TIPO_TRACADO` (
  `ID_TIPO_TRACADO` INT NOT NULL AUTO_INCREMENT,
  `DS_TIPO_TRACADO` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID_TIPO_TRACADO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.TIPO_ADMINISTRACAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`TIPO_ADMINISTRACAO` (
  `ID_TIPO_ADMINISTRACAO` INT NOT NULL AUTO_INCREMENT,
  `DS_TIPO_ADMINISTRACAO` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID_TIPO_ADMINISTRACAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.IDENTIFICACAO_OBRA_DADOS_BASICOS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`IDENTIFICACAO_OBRA_DADOS_BASICOS` (
  `ID_IDENTIFICACAO_OBRA_DADOS_BASICOS` INT NOT NULL AUTO_INCREMENT,
  `CD_CODIGO` VARCHAR(20) NULL,
  `CD_CODIGO_INTEGRACAO` VARCHAR(20) NULL,
  `DS_STATUS` VARCHAR(20) NULL,
  `DS_IDENTIFICACAO` VARCHAR(50) NOT NULL,
  `ID_NATUREZA_TRANSPOSICAO` INT NULL,
  `ID_TIPO_ESTRUTURA` INT NULL,
  `ID_SISTEMA_CONSTRUTIVO` INT NULL,
  `DS_COMPRIMENTO` VARCHAR(20) NOT NULL,
  `DS_LARGURA` VARCHAR(20) NOT NULL,
  `ID_TREM_TIPO` INT NULL,
  `DS_ANO_CONSTRUCAO` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_DADOS_BASICOS`),
  CONSTRAINT `fk_identificacaoobradadosbasicos_naturezatransposicao`
    FOREIGN KEY (`ID_NATUREZA_TRANSPOSICAO`)
    REFERENCES `EMEA`.`NATUREZA_TRANSPOSICAO` (`ID_NATUREZA_TRANSPOSICAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_identificacaoobradadosbasicos_tipoestrutura`
    FOREIGN KEY (`ID_TIPO_ESTRUTURA`)
    REFERENCES `EMEA`.`TIPO_ESTRUTURA` (`ID_TIPO_ESTRUTURA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_identificacaoobradadosbasicos_sistemaconstrutivo`
    FOREIGN KEY (`ID_SISTEMA_CONSTRUTIVO`)
    REFERENCES `EMEA`.`SISTEMA_CONSTRUTIVO` (`ID_SISTEMA_CONSTRUTIVO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_identificacaoobradadosbasicos_tremtipo`
    FOREIGN KEY (`ID_TREM_TIPO`)
    REFERENCES `EMEA`.`TREM_TIPO` (`ID_TREM_TIPO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.IDENTIFICACAO_OBRA_LOCALIZACAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`IDENTIFICACAO_OBRA_LOCALIZACAO` (
  `ID_IDENTIFICACAO_OBRA_LOCALIZACAO` INT NOT NULL AUTO_INCREMENT,
  `ID_UF` INT NOT NULL,
  `ID_VIA` INT NOT NULL,
  `DS_LOCAL_VIA` FLOAT(24,0) NULL,
  `DS_CIDADE_MAIS_PROXIMA` VARCHAR(40) NOT NULL,
  `DS_PNV_ANO` VARCHAR(20) NOT NULL,
  `DS_PNV_VERSAO` VARCHAR(20) NOT NULL,
  `DS_PNV_CODIGO` VARCHAR(40) NOT NULL,
  `DS_PNV_ALTITUDE` VARCHAR(20) NOT NULL,
  `DS_LATITUDE_GRAU` VARCHAR(20) NOT NULL,
  `DS_LATITUDE_MINUTO` VARCHAR(20) NOT NULL,
  `DS_LONGITUDE_GRAU` VARCHAR(20) NOT NULL,
  `DS_LONGITUDE_MINUTO` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_LOCALIZACAO`),
  CONSTRAINT `fk_identificacaoobralocalizacao_uf`
    FOREIGN KEY (`ID_UF`)
    REFERENCES `EMEA`.`UF` (`ID_UF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_identificacaoobralocalizacao_via`
    FOREIGN KEY (`ID_VIA`)
    REFERENCES `EMEA`.`VIA` (`ID_VIA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.IDENTIFICACAO_OBRA_RESPONSAVEIS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`IDENTIFICACAO_OBRA_RESPONSAVEIS` (
  `ID_IDENTIFICACAO_OBRA_RESPONSAVEIS` INT NOT NULL AUTO_INCREMENT,
  `ID_UNIDADE_LOCAL` INT NOT NULL,
  `ID_TIPO_ADMINISTRACAO` INT NOT NULL,
  `DS_ADMINISTRADOR` VARCHAR(80) NOT NULL,
  `DS_PROJETISTA_ORIGEM` VARCHAR(80) NULL,
  `DS_PROJETISTA_PROJETISTA` VARCHAR(80) NULL,
  `DS_CONSTRUTOR_ORIGEM` VARCHAR(80) NULL,
  `DS_CONSTRUTOR_CONSTRUTOR` VARCHAR(80) NULL,
  `DS_LOCALIZACAO_PROJETO` VARCHAR(80) NULL,
  `DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO` VARCHAR(80) NULL,
  `DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS` VARCHAR(80) NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_RESPONSAVEIS`),
  CONSTRAINT `fk_identificacaoobraresponsaveis_unidadelocal`
    FOREIGN KEY (`ID_UNIDADE_LOCAL`)
    REFERENCES `EMEA`.`UNIDADE_LOCAL` (`ID_UNIDADE_LOCAL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_identificacaoobraresponsaveis_tipoadministracao`
    FOREIGN KEY (`ID_TIPO_ADMINISTRACAO`)
    REFERENCES `EMEA`.`TIPO_ADMINISTRACAO` (`ID_TIPO_ADMINISTRACAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.IDENTIFICACAO_OBRA_INSPECAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`IDENTIFICACAO_OBRA_INSPECAO` (
  `ID_IDENTIFICACAO_OBRA_INSPECAO` INT NOT NULL AUTO_INCREMENT,
  `DS_PERIODO` VARCHAR(20) NOT NULL,
  `DS_EQUIPAMENTO_NECESSARIO` VARCHAR(20) NULL,
  `DS_MELHOR_EPOCA` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_INSPECAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS` (
  `ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS` INT NOT NULL AUTO_INCREMENT,
  `ID_TIPO_REGIAO` INT NULL,
  `ID_TIPO_TRACADO` INT NULL,
  `DS_RAMPA_MAXIMA` VARCHAR(20) NULL,
  `DS_RAIO_CURVA` VARCHAR(20) NULL,
  `DS_VMD` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS`),
  CONSTRAINT `fk_caracteristicasfuncionaiscaracteristicas_tiporegiao`
    FOREIGN KEY (`ID_TIPO_REGIAO`)
    REFERENCES `EMEA`.`TIPO_REGIAO` (`ID_TIPO_REGIAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_caracteristicasfuncionaiscaracteristicas_tipotracado`
    FOREIGN KEY (`ID_TIPO_TRACADO`)
    REFERENCES `EMEA`.`TIPO_TRACADO` (`ID_TIPO_TRACADO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.CARACTERISTICAS_FUNCIONAIS_DIMENSOES
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`CARACTERISTICAS_FUNCIONAIS_DIMENSOES` (
  `ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES` INT NOT NULL AUTO_INCREMENT,
  `DS_NUMERO_FAIXAS` VARCHAR(20) NULL,
  `DS_LARGURA_FAIXA` VARCHAR(20) NULL,
  `DS_ACOSTAMENTO_DIREITO` VARCHAR(20) NULL,
  `DS_ACOSTAMENTO_ESQUERDO` VARCHAR(20) NULL,
  `DS_CALCADA_DIREITA` VARCHAR(20) NULL,
  `DS_CALCADA_ESQUERDA` VARCHAR(20) NULL,
  `DS_LARGURA_TOTAL_PISTA` VARCHAR(20) NULL,
  `DS_GABARITO_HORIZONTAL` VARCHAR(20) NULL,
  `DS_GABARITO_VERTICAL` VARCHAR(20) NULL,
  `DS_NUMERO_VAOS` VARCHAR(20) NULL,
  `DS_DESCRICAO_VAOS` VARCHAR(80) NULL,
  PRIMARY KEY (`ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES`));

-- ----------------------------------------------------------------------------
-- Table EMEA.FOTO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`FOTO` (
  `ID_FOTO` INT NOT NULL AUTO_INCREMENT,
  `DS_FOTO` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID_FOTO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.NUMERO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`NUMERO` (
  `ID_NUMERO` INT NOT NULL AUTO_INCREMENT,
  `DS_NUMERO` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID_NUMERO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.ROTAS_ALTERNATIVAS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`ROTAS_ALTERNATIVAS` (
  `ID_ROTAS_ALTERNATIVAS` INT NOT NULL AUTO_INCREMENT,
  `DS_IDENTIFICACAO` VARCHAR(20) NULL,
  `DS_ROTA_ALTERNATIVA` VARCHAR(400) NULL,
  `DS_ACRESCIMO_KM` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_ROTAS_ALTERNATIVAS`));

-- ----------------------------------------------------------------------------
-- Table EMEA.SUBSTITUICAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`SUBSTITUICAO` (
  `ID_SUBSTITUICAO` INT NOT NULL AUTO_INCREMENT,
  `DS_IDENTIFICACAO` VARCHAR(20) NULL,
  `DS_EXISTE_PROJETO_SUBSTITUICAO` VARCHAR(20) NULL,
  `DS_CUSTO_ESTIMADO` VARCHAR(20) NULL,
  `DS_OBSERVACOES` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_SUBSTITUICAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.OBSERVACOES
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`OBSERVACOES` (
  `ID_OBSERVACOES` INT NOT NULL AUTO_INCREMENT,
  `DS_IDENTIFICACAO` VARCHAR(20) NULL,
  `DS_OBSERVACOES` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_OBSERVACOES`));

-- ----------------------------------------------------------------------------
-- Table EMEA.MANIFESTACOES_EXTENSAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`MANIFESTACOES_EXTENSAO` (
  `ID_MANIFESTACOES_EXTENSAO` INT NOT NULL AUTO_INCREMENT,
  `DS_MANIFESTACOES_EXTENSAO` VARCHAR(80) NULL,
  `DS_CRITERIO_MANIFESTACOES_EXTENSAO` VARCHAR(200) NULL,
  `DS_CAPA2` VARCHAR(10) NULL,
  PRIMARY KEY (`ID_MANIFESTACOES_EXTENSAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.MANIFESTACOES_URGENCIA
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`MANIFESTACOES_URGENCIA` (
  `ID_MANIFESTACOES_URGENCIA` INT NOT NULL AUTO_INCREMENT,
  `DS_MANIFESTACOES_URGENCIA` VARCHAR(80) NULL,
  `DS_CRITERIO_MANIFESTACOES_URGENCIA` VARCHAR(200) NULL,
  `DS_CAPA4` VARCHAR(10) NULL,
  PRIMARY KEY (`ID_MANIFESTACOES_URGENCIA`));

-- ----------------------------------------------------------------------------
-- Table EMEA.MANIFESTACOES_REPETICAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`MANIFESTACOES_REPETICAO` (
  `ID_MANIFESTACOES_REPETICAO` INT NOT NULL AUTO_INCREMENT,
  `DS_CRITERIO_MANIFESTACOES_REPETICAO` VARCHAR(200) NULL,
  `DS_LIMITESUPERIOR` VARCHAR(10) NULL,
  `DS_CAPA3` VARCHAR(10) NULL,
  PRIMARY KEY (`ID_MANIFESTACOES_REPETICAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.MODELO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`MODELO` (
  `ID_MODELO` INT NOT NULL AUTO_INCREMENT,
  `DS_INDICE_BASE` VARCHAR(20) NOT NULL,
  `DS_INDICE_PERFORMANCE` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_MODELO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.DEFICIENCIAS_FUNCIONAIS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`DEFICIENCIAS_FUNCIONAIS` (
  `ID_DEFICIENCIAS_FUNCIONAIS` INT NOT NULL AUTO_INCREMENT,
  `CD_DEFICIENCIA_FUNCIONAL` VARCHAR(20) NULL,
  `DS_DEFICIENCIA_FUNCIONAL` VARCHAR(80) NULL,
  `DS_UNIDADE_MEDIDA` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_DEFICIENCIAS_FUNCIONAIS`));

-- ----------------------------------------------------------------------------
-- Table EMEA.ELEMENTO_UFPR
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`ELEMENTO_UFPR` (
  `ID_ELEMENTO_UFPR` INT NOT NULL AUTO_INCREMENT,
  `CD_ELEMENTO` INT NULL,
  `DS_ELEMENTO` VARCHAR(100) NULL,
  `DS_CAPA1` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID_ELEMENTO_UFPR`));

-- ----------------------------------------------------------------------------
-- Table EMEA.MANIFESTACAO_UFPR
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`MANIFESTACAO_UFPR` (
  `ID_MANIFESTACAO_UFPR` INT NOT NULL AUTO_INCREMENT,
  `CD_MANIFESTACAO_UFPR` INT NULL,
  `DS_MANIFESTACAO_UFPR` VARCHAR(100) NULL,
  `DS_UNIDADE` VARCHAR(10) NULL,
  `DS_BETA` VARCHAR(10) NULL,
  PRIMARY KEY (`ID_MANIFESTACAO_UFPR`));

-- ----------------------------------------------------------------------------
-- Table EMEA.PONTE
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`PONTE` (
  `ID_PONTE` INT NOT NULL AUTO_INCREMENT,
  `DS_INDICE_PERFORMANCE_RELATIVO` VARCHAR(20) NULL,
  `ID_IDENTIFICACAO_OBRA_DADOS_BASICOS` INT NOT NULL,
  `ID_IDENTIFICACAO_OBRA_LOCALIZACAO` INT NOT NULL,
  `ID_IDENTIFICACAO_OBRA_RESPONSAVEIS` INT NOT NULL,
  `ID_IDENTIFICACAO_OBRA_INSPECAO` INT NOT NULL,
  `ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS` INT NOT NULL,
  `ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES` INT NOT NULL,
  `ID_ROTAS_ALTERNATIVAS` INT NOT NULL,
  `ID_OBSERVACOES` INT NOT NULL,
  `ID_SUBSTITUICAO` INT NOT NULL,
  PRIMARY KEY (`ID_PONTE`),
  CONSTRAINT `fk_ponte_identificacaoobradadosbasicos`
    FOREIGN KEY (`ID_IDENTIFICACAO_OBRA_DADOS_BASICOS`)
    REFERENCES `EMEA`.`IDENTIFICACAO_OBRA_DADOS_BASICOS` (`ID_IDENTIFICACAO_OBRA_DADOS_BASICOS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ponte_identificacaoobralocalizacao`
    FOREIGN KEY (`ID_IDENTIFICACAO_OBRA_LOCALIZACAO`)
    REFERENCES `EMEA`.`IDENTIFICACAO_OBRA_LOCALIZACAO` (`ID_IDENTIFICACAO_OBRA_LOCALIZACAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ponte_identificacaoobraresponsaveis`
    FOREIGN KEY (`ID_IDENTIFICACAO_OBRA_RESPONSAVEIS`)
    REFERENCES `EMEA`.`IDENTIFICACAO_OBRA_RESPONSAVEIS` (`ID_IDENTIFICACAO_OBRA_RESPONSAVEIS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ponte_identificacaoobrainspecao`
    FOREIGN KEY (`ID_IDENTIFICACAO_OBRA_INSPECAO`)
    REFERENCES `EMEA`.`IDENTIFICACAO_OBRA_INSPECAO` (`ID_IDENTIFICACAO_OBRA_INSPECAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ponte_caracteristicasfuncionaiscaracteristicas`
    FOREIGN KEY (`ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS`)
    REFERENCES `EMEA`.`CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS` (`ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ponte_caracteristicasfuncionaisdimensoes`
    FOREIGN KEY (`ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES`)
    REFERENCES `EMEA`.`CARACTERISTICAS_FUNCIONAIS_DIMENSOES` (`ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ponte_rotasalternativas`
    FOREIGN KEY (`ID_ROTAS_ALTERNATIVAS`)
    REFERENCES `EMEA`.`ROTAS_ALTERNATIVAS` (`ID_ROTAS_ALTERNATIVAS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ponte_observacoes`
    FOREIGN KEY (`ID_OBSERVACOES`)
    REFERENCES `EMEA`.`OBSERVACOES` (`ID_OBSERVACOES`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ponte_substituicao`
    FOREIGN KEY (`ID_SUBSTITUICAO`)
    REFERENCES `EMEA`.`SUBSTITUICAO` (`ID_SUBSTITUICAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.CONFIGURACAO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`CONFIGURACAO` (
  `ID_CONFIGURACAO` INT NOT NULL,
  `DS_CAMINHO_IMAGEM` LONGTEXT NOT NULL,
  PRIMARY KEY (`ID_CONFIGURACAO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.IMAGEM
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`IMAGEM` (
  `ID_IMAGEM` INT NOT NULL AUTO_INCREMENT,
  `NM_NOME` VARCHAR(100) NOT NULL,
  `TIPO_MIME` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID_IMAGEM`));

-- ----------------------------------------------------------------------------
-- Table EMEA.ASPECTOS_ESPECIAIS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`ASPECTOS_ESPECIAIS` (
  `ID_ASPECTOS_ESPECIAIS` INT NOT NULL AUTO_INCREMENT,
  `DS_ASPECTOS_ESPECIAIS` VARCHAR(80) NULL,
  PRIMARY KEY (`ID_ASPECTOS_ESPECIAIS`));

-- ----------------------------------------------------------------------------
-- Table EMEA.CADASTRO_ASPECTOS_ESPECIAIS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`CADASTRO_ASPECTOS_ESPECIAIS` (
  `ID_CADASTRO_ASPECTOS_ESPECIAIS` INT NOT NULL AUTO_INCREMENT,
  `ID_PONTE` INT NULL,
  `ID_ASPECTOS_ESPECIAIS` INT NULL,
  PRIMARY KEY (`ID_CADASTRO_ASPECTOS_ESPECIAIS`),
  CONSTRAINT `fk_cadastroaspectosespeciais_ponte`
    FOREIGN KEY (`ID_PONTE`)
    REFERENCES `EMEA`.`PONTE` (`ID_PONTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cadastroaspectosespeciais_aspectosespeciais`
    FOREIGN KEY (`ID_ASPECTOS_ESPECIAIS`)
    REFERENCES `EMEA`.`ASPECTOS_ESPECIAIS` (`ID_ASPECTOS_ESPECIAIS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.RANKING
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`RANKING` (
  `ID_RANKING` INT NOT NULL AUTO_INCREMENT,
  `ID_PONTE` INT NOT NULL,
  `ID_SIMULACAO` INT NOT NULL,
  PRIMARY KEY (`ID_RANKING`),
  CONSTRAINT `fk_ranking_ponte`
    FOREIGN KEY (`ID_PONTE`)
    REFERENCES `EMEA`.`PONTE` (`ID_PONTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ranking_simulacao`
    FOREIGN KEY (`ID_SIMULACAO`)
    REFERENCES `EMEA`.`SIMULACAO` (`ID_SIMULACAO`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.ELEMENTO_COMPONENTES
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`ELEMENTO_COMPONENTES` (
  `ID_ELEMENTO_COMPONENTES` INT NOT NULL AUTO_INCREMENT,
  `ID_PONTE` INT NOT NULL,
  `ID_ELEMENTO_UFPR` INT NOT NULL,
  `DS_DETALHE` VARCHAR(20) NULL,
  `NR_QUANTIDADE` VARCHAR(10) NULL,
  PRIMARY KEY (`ID_ELEMENTO_COMPONENTES`),
  CONSTRAINT `fk_elementocomponentes_ponte`
    FOREIGN KEY (`ID_PONTE`)
    REFERENCES `EMEA`.`PONTE` (`ID_PONTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_elementocomponentes_elementoufpr`
    FOREIGN KEY (`ID_ELEMENTO_UFPR`)
    REFERENCES `EMEA`.`ELEMENTO_UFPR` (`ID_ELEMENTO_UFPR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.IDENTIFICACAO_OBRA_SGO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`IDENTIFICACAO_OBRA_SGO` (
  `ID_IDENTIFICACAO_OBRA_SGO` INT NOT NULL AUTO_INCREMENT,
  `ID_PONTE` INT NOT NULL,
  `DT_DATA_INSPECAO` DATE NULL,
  `NM_INSPETOR` VARCHAR(50) NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_SGO`),
  CONSTRAINT `fk_identificacaoobrasgo_ponte`
    FOREIGN KEY (`ID_PONTE`)
    REFERENCES `EMEA`.`PONTE` (`ID_PONTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table EMEA.CONDICOES_SGO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`CONDICOES_SGO` (
  `ID_CONDICOES_SGO` INT NOT NULL AUTO_INCREMENT,
  `DS_CONDICAO_ESTABILIDADE` VARCHAR(20) NULL,
  `DS_CONDICAO_CONSERVACAO` VARCHAR(20) NULL,
  `DS_OBSERVACOES` VARCHAR(80) NULL,
  `DS_NOTA_TECNICA` VARCHAR(20) NULL,
  PRIMARY KEY (`ID_CONDICOES_SGO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.LAUDO_ESPECIALIZADO_SGO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`LAUDO_ESPECIALIZADO_SGO` (
  `ID_LAUDO_ESPECIALIZADO_SGO` INT NOT NULL AUTO_INCREMENT,
  `DT_DATA_LAUDO` DATE NULL,
  `DS_CONSULTOR` VARCHAR(30) NULL,
  `DS_OBSERVACOES` VARCHAR(80) NULL,
  PRIMARY KEY (`ID_LAUDO_ESPECIALIZADO_SGO`));

-- ----------------------------------------------------------------------------
-- Table EMEA.MONITORAMENTO_SGO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `EMEA`.`MONITORAMENTO_SGO` (
  `ID_MONITORAMENTO_SGO` INT NOT NULL AUTO_INCREMENT,
  `DS_PERIODO` VARCHAR(20) NULL,
  `DS_TIPO_MONITORAMENTO` VARCHAR(20) NULL,
  `DS_EXECUTOR` VARCHAR(30) NULL,
  `DS_CUSTO` VARCHAR(20) NULL,
  `DS_OBJETO` VARCHAR(80) NULL,
  `DS_TECNICAS` VARCHAR(80) NULL,
  PRIMARY KEY (`ID_MONITORAMENTO_SGO`));
SET FOREIGN_KEY_CHECKS = 1;
