-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: emea
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arquivo_anexo_cadastro`
--

USE `EMEA`;

DROP TABLE IF EXISTS `arquivo_anexo_cadastro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arquivo_anexo_cadastro` (
  `ID_ARQUIVO_ANEXO_CADASTRO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PONTE` int(11) NOT NULL,
  `DS_ARQUIVO` varchar(20) NOT NULL,
  `DS_TIPO_ARQUIVO` varchar(10) NOT NULL,
  `NR_NUMERO` varchar(3) NOT NULL,
  `DS_DESCRICAO` varchar(20) NOT NULL,
  `DS_REGISTRO` varchar(10) NOT NULL,
  `DT_DATA_ANEXACAO` date NOT NULL,
  `ID_IMAGEM` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ARQUIVO_ANEXO_CADASTRO`),
  KEY `fk_arquivoanexocadastro_ponte` (`ID_PONTE`),
  KEY `fk_arquivoanexocadastro_imagem` (`ID_IMAGEM`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arquivo_anexo_cadastro`
--

LOCK TABLES `arquivo_anexo_cadastro` WRITE;
/*!40000 ALTER TABLE `arquivo_anexo_cadastro` DISABLE KEYS */;
INSERT INTO `arquivo_anexo_cadastro` VALUES (1,1,'01.jpg','Foto','01','Vista geral','OAE','2016-07-05',1),(2,1,'02.jpg','Foto','02','Pista rolamento','OAE','2016-07-05',2),(3,1,'03.jpg','Foto','03','Vista geral','OAE','2016-07-05',3),(4,2,'geral.jpg','Foto','01','Vista geral','OAE','2016-09-19',4),(5,3,'ponte03Geral.jpg','Foto','01','Vista geral','OAE','2016-09-20',5),(6,3,'ponte03foto01.jpg','Foto','02','foto 01','OAE','2016-09-20',6),(7,3,'ponte03foto02.jpg','Foto','03','foto 02','OAE','2016-09-20',7),(8,4,'ponte04Geral.jpg','Foto','01','Vista geral','OAE','2016-09-20',8),(9,4,'ponte04foto01.jpg','Foto','02','foto 01','OAE','2016-09-21',9),(10,5,'ponte05Geral.jpg','Foto','01','Vista geral','OAE','2016-09-21',10),(11,5,'ponte05foto01.jpg','Foto','02','foto 01','OAE','2016-09-21',11),(12,6,'ponte06Geral.jpg','Foto','01','Vista geral','OAE','2016-09-21',12),(13,6,'ponte06foto01.jpg','Foto','02','foto 01','OAE','2016-09-21',13),(14,7,'ponte07Geral.jpg','Foto','01','Vista geral','OAE','2016-09-21',14),(15,7,'ponte07foto01.jpg','Foto','02','foto 01','OAE','2016-09-21',15),(16,8,'ponte08Geral.jpg','Foto','01','Vista geral','OAE','2016-09-21',16),(17,8,'ponte08foto01.jpg','Foto','02','foto 01','OAE','2016-09-21',17),(18,9,'ponte09Geral.jpg','Foto','01','Vista geral','OAE','2016-09-21',18),(19,9,'ponte09foto01.jpg','Foto','02','foto 01','OAE','2016-09-21',19),(20,10,'ponte10Geral.jpg','Foto','01','Vista geral','OAE','2016-09-21',20),(21,10,'ponte10foto01.jpg','Foto','02','foto 01','OAE','2016-09-21',21),(22,11,'ponte11Geral.jpg','Foto','01','Vista geral','OAE','2016-09-21',22),(23,11,'ponte11foto01.jpg','Foto','02','foto 01','OAE','2016-09-21',23);
/*!40000 ALTER TABLE `arquivo_anexo_cadastro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arquivo_anexo_inspecao`
--

DROP TABLE IF EXISTS `arquivo_anexo_inspecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arquivo_anexo_inspecao` (
  `ID_ARQUIVO_ANEXO_INSPECAO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_INSPECAO` int(11) NOT NULL,
  `DS_ARQUIVO` varchar(20) NOT NULL,
  `DS_TIPO_ARQUIVO` varchar(10) NOT NULL,
  `NR_NUMERO` varchar(3) NOT NULL,
  `DS_DESCRICAO` varchar(20) NOT NULL,
  `DS_REGISTRO` varchar(10) NOT NULL,
  `DT_DATA_ANEXACAO` date NOT NULL,
  `ID_IMAGEM` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ARQUIVO_ANEXO_INSPECAO`),
  KEY `fk_arquivoanexoinspecao_inspecao` (`ID_INSPECAO`),
  KEY `fk_arquivoanexoinspecao_imagem` (`ID_IMAGEM`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arquivo_anexo_inspecao`
--

LOCK TABLES `arquivo_anexo_inspecao` WRITE;
/*!40000 ALTER TABLE `arquivo_anexo_inspecao` DISABLE KEYS */;
INSERT INTO `arquivo_anexo_inspecao` VALUES (1,1,'01.jpg','Foto','01','Vista geral','INS','2016-08-05',2),(2,1,'02.jpg','Foto','02','Pista rolamento','INS','2016-08-05',3),(3,1,'03.jpg','Foto','03','Vista geral','INS','2016-08-05',1);
/*!40000 ALTER TABLE `arquivo_anexo_inspecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aspectos_especiais`
--

DROP TABLE IF EXISTS `aspectos_especiais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aspectos_especiais` (
  `ID_ASPECTOS_ESPECIAIS` int(11) NOT NULL AUTO_INCREMENT,
  `DS_ASPECTOS_ESPECIAIS` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID_ASPECTOS_ESPECIAIS`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aspectos_especiais`
--

LOCK TABLES `aspectos_especiais` WRITE;
/*!40000 ALTER TABLE `aspectos_especiais` DISABLE KEYS */;
INSERT INTO `aspectos_especiais` VALUES (1,'Meio ambiente agressivo'),(2,'Nível de vibração elevado'),(3,'Leito do rio erodível'),(4,'Fundação em solo mole'),(5,'Frequência elevada de carga pesada'),(6,'Desnível elevado entre greide e terreno'),(7,'Rio com lâmina dágua normal profunda'),(8,'Grande variação do NA do rio na cheia');
/*!40000 ALTER TABLE `aspectos_especiais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastro_aspectos_especiais`
--

DROP TABLE IF EXISTS `cadastro_aspectos_especiais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadastro_aspectos_especiais` (
  `ID_CADASTRO_ASPECTOS_ESPECIAIS` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PONTE` int(11) DEFAULT NULL,
  `ID_ASPECTOS_ESPECIAIS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CADASTRO_ASPECTOS_ESPECIAIS`),
  KEY `fk_cadastroaspectosespeciais_ponte` (`ID_PONTE`),
  KEY `fk_cadastroaspectosespeciais_aspectosespeciais` (`ID_ASPECTOS_ESPECIAIS`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastro_aspectos_especiais`
--

LOCK TABLES `cadastro_aspectos_especiais` WRITE;
/*!40000 ALTER TABLE `cadastro_aspectos_especiais` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastro_aspectos_especiais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristicas_funcionais_caracteristicas`
--

DROP TABLE IF EXISTS `caracteristicas_funcionais_caracteristicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristicas_funcionais_caracteristicas` (
  `ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TIPO_REGIAO` int(11) DEFAULT NULL,
  `ID_TIPO_TRACADO` int(11) DEFAULT NULL,
  `DS_RAMPA_MAXIMA` varchar(20) DEFAULT NULL,
  `DS_RAIO_CURVA` varchar(20) DEFAULT NULL,
  `DS_VMD` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS`),
  KEY `fk_caracteristicasfuncionaiscaracteristicas_tiporegiao` (`ID_TIPO_REGIAO`),
  KEY `fk_caracteristicasfuncionaiscaracteristicas_tipotracado` (`ID_TIPO_TRACADO`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristicas_funcionais_caracteristicas`
--

LOCK TABLES `caracteristicas_funcionais_caracteristicas` WRITE;
/*!40000 ALTER TABLE `caracteristicas_funcionais_caracteristicas` DISABLE KEYS */;
INSERT INTO `caracteristicas_funcionais_caracteristicas` VALUES (1,1,1,'00','0','00');
/*!40000 ALTER TABLE `caracteristicas_funcionais_caracteristicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristicas_funcionais_dimensoes`
--

DROP TABLE IF EXISTS `caracteristicas_funcionais_dimensoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristicas_funcionais_dimensoes` (
  `ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES` int(11) NOT NULL AUTO_INCREMENT,
  `DS_NUMERO_FAIXAS` varchar(20) DEFAULT NULL,
  `DS_LARGURA_FAIXA` varchar(20) DEFAULT NULL,
  `DS_ACOSTAMENTO_DIREITO` varchar(20) DEFAULT NULL,
  `DS_ACOSTAMENTO_ESQUERDO` varchar(20) DEFAULT NULL,
  `DS_CALCADA_DIREITA` varchar(20) DEFAULT NULL,
  `DS_CALCADA_ESQUERDA` varchar(20) DEFAULT NULL,
  `DS_LARGURA_TOTAL_PISTA` varchar(20) DEFAULT NULL,
  `DS_GABARITO_HORIZONTAL` varchar(20) DEFAULT NULL,
  `DS_GABARITO_VERTICAL` varchar(20) DEFAULT NULL,
  `DS_NUMERO_VAOS` varchar(20) DEFAULT NULL,
  `DS_DESCRICAO_VAOS` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristicas_funcionais_dimensoes`
--

LOCK TABLES `caracteristicas_funcionais_dimensoes` WRITE;
/*!40000 ALTER TABLE `caracteristicas_funcionais_dimensoes` DISABLE KEYS */;
INSERT INTO `caracteristicas_funcionais_dimensoes` VALUES (1,'00','00',NULL,NULL,NULL,NULL,'00',NULL,NULL,'00','00');
/*!40000 ALTER TABLE `caracteristicas_funcionais_dimensoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `condicoes_sgo`
--

DROP TABLE IF EXISTS `condicoes_sgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condicoes_sgo` (
  `ID_CONDICOES_SGO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_CONDICAO_ESTABILIDADE` varchar(20) DEFAULT NULL,
  `DS_CONDICAO_CONSERVACAO` varchar(20) DEFAULT NULL,
  `DS_OBSERVACOES` varchar(80) DEFAULT NULL,
  `DS_NOTA_TECNICA` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_CONDICOES_SGO`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condicoes_sgo`
--

LOCK TABLES `condicoes_sgo` WRITE;
/*!40000 ALTER TABLE `condicoes_sgo` DISABLE KEYS */;
INSERT INTO `condicoes_sgo` VALUES (1,'cond estabilidade','cond conservacao','observacoes','nota técnica');
/*!40000 ALTER TABLE `condicoes_sgo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracao`
--

DROP TABLE IF EXISTS `configuracao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuracao` (
  `ID_CONFIGURACAO` int(11) NOT NULL,
  `DS_CAMINHO_IMAGEM` longtext NOT NULL,
  PRIMARY KEY (`ID_CONFIGURACAO`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracao`
--

LOCK TABLES `configuracao` WRITE;
/*!40000 ALTER TABLE `configuracao` DISABLE KEYS */;
/*!40000 ALTER TABLE `configuracao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_manifestacao`
--

DROP TABLE IF EXISTS `dados_manifestacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dados_manifestacao` (
  `ID_DADOS_MANIFESTACAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_FOTO` varchar(10) DEFAULT NULL,
  `DS_TAMANHO` varchar(10) DEFAULT NULL,
  `DS_NUMERO` varchar(20) DEFAULT NULL,
  `ID_MANIFESTACOES_EXTENSAO` int(11) DEFAULT NULL,
  `ID_MANIFESTACOES_URGENCIA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DADOS_MANIFESTACAO`),
  KEY `fk_dadosmanifestacao_manifestacoes_extensao` (`ID_MANIFESTACOES_EXTENSAO`),
  KEY `fk_dadosmanifestacao_manifestacoes_urgencia` (`ID_MANIFESTACOES_URGENCIA`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_manifestacao`
--

LOCK TABLES `dados_manifestacao` WRITE;
/*!40000 ALTER TABLE `dados_manifestacao` DISABLE KEYS */;
INSERT INTO `dados_manifestacao` VALUES (1,'foto','tam',NULL,1,1),(2,'foto 2','tam 2',NULL,1,1),(3,'foto 3','tam 3',NULL,1,1),(4,'foto 4','tam 4',NULL,1,1),(5,'foto 5','tam 5',NULL,1,1);
/*!40000 ALTER TABLE `dados_manifestacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danos_elementos_sgo`
--

DROP TABLE IF EXISTS `danos_elementos_sgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danos_elementos_sgo` (
  `ID_DANOS_ELEMENTOS_SGO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_INSPECAO` int(11) NOT NULL,
  `DS_ELEMENTO` varchar(30) DEFAULT NULL,
  `DS_NOTA` varchar(20) DEFAULT NULL,
  `DS_DANO` varchar(20) DEFAULT NULL,
  `DS_UNIDADE` varchar(20) DEFAULT NULL,
  `DS_QUANTIDADE` varchar(20) DEFAULT NULL,
  `DS_EXTENSAO_RELATIVA` varchar(20) DEFAULT NULL,
  `DS_LOCALIZACAO` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_DANOS_ELEMENTOS_SGO`),
  KEY `fk_danoselementossgo_inspecao` (`ID_INSPECAO`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danos_elementos_sgo`
--

LOCK TABLES `danos_elementos_sgo` WRITE;
/*!40000 ALTER TABLE `danos_elementos_sgo` DISABLE KEYS */;
INSERT INTO `danos_elementos_sgo` VALUES (1,1,'elemento1','nota1','dano1','unidade1','quantidade1','ext relativa1','localizacao1'),(2,2,'elemento2','nota2','dano2','unidade2','quantidade2','ext relativa2','localizacao2'),(3,3,'elemento3','nota3','dano3','unidade3','quantidade3','ext relativa3','localizacao3');
/*!40000 ALTER TABLE `danos_elementos_sgo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deficiencias_funcionais`
--

DROP TABLE IF EXISTS `deficiencias_funcionais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deficiencias_funcionais` (
  `ID_DEFICIENCIAS_FUNCIONAIS` int(11) NOT NULL AUTO_INCREMENT,
  `CD_DEFICIENCIA_FUNCIONAL` varchar(20) DEFAULT NULL,
  `DS_DEFICIENCIA_FUNCIONAL` varchar(80) DEFAULT NULL,
  `DS_UNIDADE_MEDIDA` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_DEFICIENCIAS_FUNCIONAIS`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deficiencias_funcionais`
--

LOCK TABLES `deficiencias_funcionais` WRITE;
/*!40000 ALTER TABLE `deficiencias_funcionais` DISABLE KEYS */;
INSERT INTO `deficiencias_funcionais` VALUES (1,'1','Ponte estreita (larg pista < 7,20m)','m - Metro'),(2,'2','Ponte sem acostamento','m - Metro'),(3,'3','Calçada para pedestres inexistente','m - Metro'),(4,'4','Pingadeira inexistente','m - Metro'),(5,'5','Drenagem de pista insuficiente','un - Unidade'),(6,'6','Guarda-rodas obsoleto','m - Metro'),(7,'7','Seção hidraúlica (greide baixo)','m - Metro'),(8,'8','Seção hidraúlica (ponte curta)','m - Metro'),(9,'9','Concordância vertical ruim','un - Unidade'),(10,'10','Concordância horizontal ruim','un - Unidade'),(11,'11','Capacidade de carga limitada','tf'),(12,'12','Gabarito vertical sobre via urbana insuficiente','m - Metro'),(13,'13','Gabarito vertical sobre rodovia insuficiente','m - Metro'),(14,'14','Gabarito horizontal insuficiente','m - Metro'),(15,'15','Gabarito vertical de navegação insuficiente','m - Metro'),(16,'16','Gabarito vertical sobre ferrovia insuficiente','m - Metro'),(17,'17','Pilar em canal de navegação sem proteção','un - Unidade'),(18,'18','Alça de acesso inadequada','un - Unidade'),(19,'19','Ponte muito estreita (em mão única)','m - Metro'),(20,'22','Trem tipo de cálculo TB 24tf','tf'),(21,'23','Trem tipo de cálculo TB 36tf','tf'),(22,'24','Junta longitudinal de dilatação','un - Unidade'),(23,'25','Viga caixão com interior inacessível','un - Unidade'),(24,'26','Aparelho de apoio não identificado','kg - Quilograma');
/*!40000 ALTER TABLE `deficiencias_funcionais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elemento`
--

DROP TABLE IF EXISTS `elemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elemento` (
  `ID_ELEMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `NM_ELEMENTO` varchar(100) NOT NULL,
  `DS_CAPA` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_ELEMENTO`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elemento`
--

LOCK TABLES `elemento` WRITE;
/*!40000 ALTER TABLE `elemento` DISABLE KEYS */;
INSERT INTO `elemento` VALUES (1,'elemento01','K01'),(2,'elemento02','K02');
/*!40000 ALTER TABLE `elemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elemento_componentes`
--

DROP TABLE IF EXISTS `elemento_componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elemento_componentes` (
  `ID_ELEMENTO_COMPONENTES` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PONTE` int(11) NOT NULL,
  `ID_ELEMENTO_UFPR` int(11) NOT NULL,
  `DS_DETALHE` varchar(20) DEFAULT NULL,
  `NR_QUANTIDADE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_ELEMENTO_COMPONENTES`),
  KEY `fk_elementocomponentes_ponte` (`ID_PONTE`),
  KEY `fk_elementocomponentes_elementoufpr` (`ID_ELEMENTO_UFPR`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elemento_componentes`
--

LOCK TABLES `elemento_componentes` WRITE;
/*!40000 ALTER TABLE `elemento_componentes` DISABLE KEYS */;
INSERT INTO `elemento_componentes` VALUES (1,1,1,'00','00');
/*!40000 ALTER TABLE `elemento_componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elemento_ufpr`
--

DROP TABLE IF EXISTS `elemento_ufpr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elemento_ufpr` (
  `ID_ELEMENTO_UFPR` int(11) NOT NULL AUTO_INCREMENT,
  `CD_ELEMENTO` int(11) DEFAULT NULL,
  `DS_ELEMENTO` varchar(100) DEFAULT NULL,
  `DS_CAPA1` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_ELEMENTO_UFPR`)
) ENGINE=MyISAM AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elemento_ufpr`
--

LOCK TABLES `elemento_ufpr` WRITE;
/*!40000 ALTER TABLE `elemento_ufpr` DISABLE KEYS */;
INSERT INTO `elemento_ufpr` VALUES (1,1,'Laje de concreto armado','0,4'),(2,2,'Laje de Concreto Protendido','0,4'),(3,3,'Laje Metálica Ortotrópica','0,4'),(4,4,'Laje Metálica de Chapa Corrugada','0,4'),(5,7,'Laje em Pranchão de Madeira','0,4'),(6,5,'Ponte em Laje de Concreto Armado','0,6'),(7,6,'Ponte em Laje de Concreto Protendido','0,6'),(8,204,'Travessa de apoio de concreto armado','0,4'),(9,205,'Travessa de apoio de concreto protendido','0,4'),(10,104,'Viga T ou I de concreto armado','0,6'),(11,105,'Viga T ou I de concreto protendido','0,6'),(12,106,'Viga I metálica','0,6'),(13,101,'Viga Caixão de Concreto Armado','0,6'),(14,102,'Viga Caixão de Concreto Protendido','0,6'),(15,103,'Viga Caixão Metálica','0,6'),(16,206,'Viga de contraventamento de pilar de concreto armado','0,4'),(17,109,'Transversina Portante de Concreto Armado','0,3'),(18,110,'Transversina Portante de Concreto Protendido','0,3'),(19,111,'Transversina Portante Metálica','0,3'),(20,112,'Transversina de Ligação de Concreto Armado','0,2'),(21,113,'Transversina de Ligação de Concreto Protendido','0,2'),(22,114,'Transversina de Ligação Metálica','0,2'),(23,202,'Pilar em Colunas de Concreto Armado','0,4'),(24,201,'Pilar Parede de Concreto Armado','0,4'),(25,203,'Pilar Vazado de Concreto Armado','0,4'),(26,200,'Pilar Parede de Alvenaria de Pedra','0,4'),(27,207,'Parede de contraventamento de pilar de concreto armado','0,4'),(28,301,'Aparelho de Apoio de Neoprene Fretado','0,4'),(29,302,'Aparelho de Apoio de Teflon','0,4'),(30,303,'Aparelho de Apoio de Rolo Metálico','0,4'),(31,304,'Aparelho de Apoio de Placa de Chumbo','0,4'),(32,305,'Aparelho de Apoio Pot Bearing Fixo','0,4'),(33,306,'Aparelho de Apoio Pot Bearing Directional','0,4'),(34,307,'Aparelho de Apoio Freyssinet','0,4'),(35,308,'Aparelho de Apoio Pêndulo','0,4'),(36,309,'Articulação Metálica','0,4'),(37,107,'Dente Gerber de Concreto Armado','0,6'),(38,108,'Dente Gerber de concreto armado com protensão','0,6'),(39,118,'Dente Gerber Metálico','0,6'),(40,252,'Encontro de alvenaria de pedra','0,1'),(41,251,'Encontro - Parede frontal portante de concreto armado','0,1'),(42,253,'Encontro - Parede Lateral e Vigas de Concreto Armado','0,2'),(43,256,'Encontro - Paredes e Vigas Secundárias de Concreto','0,1'),(44,254,'Encontro - Laje de Concreto Armado','0,1'),(45,255,'Encontro - Cortina de Concreto Armado','0,2'),(46,816,'Muro de Arrimo de Concreto','0,4'),(47,818,'Muro de Terra Armada','0,3'),(48,817,'Revestimento de talude em concreto','0,4'),(49,504,'Estaca de Concreto Armado','0,4'),(50,505,'Estaca Metálica','0,4'),(51,506,'Estaca de Madeira','0,4'),(52,501,'Bloco ou Sapata de concreto armado','0,4'),(53,502,'Tubulão ou estacão de concreto armado','0,4'),(54,503,'Camisa Metálica de Revestimento para Estaca','0,3'),(55,813,'Junta elastomérica de dilatação','0,2'),(56,815,'Junta metálica de dilatação','0,2'),(57,801,'Pavimento Asfáltico','0,2'),(58,802,'Pavimento de Concreto','0,2'),(59,808,'Calçada para pedestres de concreto armado','0,2'),(60,809,'Calçada para pedestres metálica','0,2'),(61,803,'Barreira new jersey','0,1'),(62,805,'Guarda rodas qualquer','0,1'),(63,806,'Guarda Corpo de Concreto Armado','0,1'),(64,807,'Guarda Corpo Metálico','0,1'),(65,703,'Reforço viga I - Encamisamento de viga','0,6'),(66,704,'Reforço viga II - Armadura principal passiva','0,6'),(67,705,'Reforço viga III - Cabo de protensão externo','0,6'),(68,706,'Reforço viga IV - Bloqueio de articulação Gerber','0,6'),(69,701,'Reforço laje I - Sobrelaje de concreto armado','0,4'),(70,702,'Reforço de Laje II - Infradorso laje em Concreto Armado','0,4'),(71,707,'Reforço de pilar - Encamisamento de pilar','0,4'),(72,708,'Reforço estaca - Encamisamento de trecho livre','0,4'),(73,811,'Aterro de Acesso','0,2'),(74,810,'Laje de Aproximação','0,2'),(75,601,'Torre de Concreto Armado para Estaiamento','0,6'),(76,603,'Ancoragens de estais','0,6'),(77,451,'Treliça de Concreto Armado','0,5'),(78,452,'Treliça Metálica','0,5'),(79,401,'Arco de Concreto Armado','0,6'),(80,402,'Arco de Concreto Protendido','0,6'),(81,403,'Arco Metálico','0,6'),(82,806,'Guarda rodas antigo do DNER','0,1'),(83,812,'Berço para junta de dilatação','0,2'),(84,814,'Junta de dilatação','0,2'),(85,115,'Cortina de concreto armado','0,2'),(86,116,'Longarina de enrigecimento de laje','0,4'),(87,1000,'Operação','0,2'),(88,1001,'Drenagem','0,2'),(89,1002,'Sinalização','0,1'),(90,820,'Defensa Metálica','0,1'),(91,819,'Muro de gabião','0,4');
/*!40000 ALTER TABLE `elemento_ufpr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elemento_ufpr_manifestacao_ufpr`
--

DROP TABLE IF EXISTS `elemento_ufpr_manifestacao_ufpr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elemento_ufpr_manifestacao_ufpr` (
  `ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ELEMENTO_UFPR` int(11) NOT NULL,
  `ID_MANIFESTACAO_UFPR` int(11) NOT NULL,
  PRIMARY KEY (`ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR`),
  KEY `fk_elementoufprmanifestacaoufpr_elementoufpr` (`ID_ELEMENTO_UFPR`),
  KEY `fk_elementoufprmanifestacaoufpr_manifestacaoufpr` (`ID_MANIFESTACAO_UFPR`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elemento_ufpr_manifestacao_ufpr`
--

LOCK TABLES `elemento_ufpr_manifestacao_ufpr` WRITE;
/*!40000 ALTER TABLE `elemento_ufpr_manifestacao_ufpr` DISABLE KEYS */;
INSERT INTO `elemento_ufpr_manifestacao_ufpr` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12);
/*!40000 ALTER TABLE `elemento_ufpr_manifestacao_ufpr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto` (
  `ID_FOTO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_FOTO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_FOTO`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
INSERT INTO `foto` VALUES (1,'foto');
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identificacao_obra_dados_basicos`
--

DROP TABLE IF EXISTS `identificacao_obra_dados_basicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identificacao_obra_dados_basicos` (
  `ID_IDENTIFICACAO_OBRA_DADOS_BASICOS` int(11) NOT NULL AUTO_INCREMENT,
  `CD_CODIGO` varchar(20) DEFAULT NULL,
  `CD_CODIGO_INTEGRACAO` varchar(20) DEFAULT NULL,
  `DS_STATUS` varchar(20) DEFAULT NULL,
  `DS_IDENTIFICACAO` varchar(50) NOT NULL,
  `ID_NATUREZA_TRANSPOSICAO` int(11) DEFAULT NULL,
  `ID_TIPO_ESTRUTURA` int(11) DEFAULT NULL,
  `ID_SISTEMA_CONSTRUTIVO` int(11) DEFAULT NULL,
  `DS_COMPRIMENTO` varchar(20) NOT NULL,
  `DS_LARGURA` varchar(20) NOT NULL,
  `ID_TREM_TIPO` int(11) DEFAULT NULL,
  `DS_ANO_CONSTRUCAO` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_DADOS_BASICOS`),
  KEY `fk_identificacaoobradadosbasicos_naturezatransposicao` (`ID_NATUREZA_TRANSPOSICAO`),
  KEY `fk_identificacaoobradadosbasicos_tipoestrutura` (`ID_TIPO_ESTRUTURA`),
  KEY `fk_identificacaoobradadosbasicos_sistemaconstrutivo` (`ID_SISTEMA_CONSTRUTIVO`),
  KEY `fk_identificacaoobradadosbasicos_tremtipo` (`ID_TREM_TIPO`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identificacao_obra_dados_basicos`
--

LOCK TABLES `identificacao_obra_dados_basicos` WRITE;
/*!40000 ALTER TABLE `identificacao_obra_dados_basicos` DISABLE KEYS */;
INSERT INTO `identificacao_obra_dados_basicos` VALUES (1,'01','11','55','Ponte 01',1,1,3,'01','01',1,'01'),(2,'02','22','66','Ponte 02',2,3,2,'00','00',2,'00'),(3,'03','33','77','Ponte 03',3,2,5,'00','00',3,'00'),(4,'04','44','88','Ponte 04',4,5,3,'00','00',2,'00'),(5,'05','55','99','Ponte 05',5,4,1,'00','00',4,'00'),(6,'06','66','11','Ponte 06',1,6,10,'06','06',1,'06'),(7,'07','77','22','Ponte 07',2,7,6,'07','07',2,'00'),(8,'08','88','33','Ponte 08',3,8,9,'08','08',3,'00'),(9,'09','99','44','Ponte 09',4,9,7,'09','09',2,'00'),(10,'10','10','10','Ponte 10',5,10,8,'10','10',4,'00'),(11,'11','11','11','Ponte 11',5,10,8,'11','11',4,'00');
/*!40000 ALTER TABLE `identificacao_obra_dados_basicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identificacao_obra_inspecao`
--

DROP TABLE IF EXISTS `identificacao_obra_inspecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identificacao_obra_inspecao` (
  `ID_IDENTIFICACAO_OBRA_INSPECAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_PERIODO` varchar(20) NOT NULL,
  `DS_EQUIPAMENTO_NECESSARIO` varchar(20) DEFAULT NULL,
  `DS_MELHOR_EPOCA` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_INSPECAO`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identificacao_obra_inspecao`
--

LOCK TABLES `identificacao_obra_inspecao` WRITE;
/*!40000 ALTER TABLE `identificacao_obra_inspecao` DISABLE KEYS */;
INSERT INTO `identificacao_obra_inspecao` VALUES (1,'01','01','01'),(2,'02','02','02'),(3,'03','03','03'),(4,'04','04','04'),(5,'05','05','05'),(6,'06','06','06'),(7,'07','07','07'),(8,'08','08','08'),(9,'09','09','09'),(10,'10','10','10'),(11,'11','11','11');
/*!40000 ALTER TABLE `identificacao_obra_inspecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identificacao_obra_localizacao`
--

DROP TABLE IF EXISTS `identificacao_obra_localizacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identificacao_obra_localizacao` (
  `ID_IDENTIFICACAO_OBRA_LOCALIZACAO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_UF` int(11) NOT NULL,
  `ID_VIA` int(11) NOT NULL,
  `DS_LOCAL_VIA` float(24,0) DEFAULT NULL,
  `DS_CIDADE_MAIS_PROXIMA` varchar(40) NOT NULL,
  `DS_PNV_ANO` varchar(20) NOT NULL,
  `DS_PNV_VERSAO` varchar(20) NOT NULL,
  `DS_PNV_CODIGO` varchar(40) NOT NULL,
  `DS_PNV_ALTITUDE` varchar(20) NOT NULL,
  `DS_LATITUDE_GRAU` varchar(20) NOT NULL,
  `DS_LATITUDE_MINUTO` varchar(20) NOT NULL,
  `DS_LONGITUDE_GRAU` varchar(20) NOT NULL,
  `DS_LONGITUDE_MINUTO` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_LOCALIZACAO`),
  KEY `fk_identificacaoobralocalizacao_uf` (`ID_UF`),
  KEY `fk_identificacaoobralocalizacao_via` (`ID_VIA`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identificacao_obra_localizacao`
--

LOCK TABLES `identificacao_obra_localizacao` WRITE;
/*!40000 ALTER TABLE `identificacao_obra_localizacao` DISABLE KEYS */;
INSERT INTO `identificacao_obra_localizacao` VALUES (1,16,3,10,'00','00','00','00','00','25','33.347','49','20.542'),(2,16,3,66,'00','00','00','00','00','23','29.985','50','6.535'),(3,24,1,304,'00','00','00','00','00','28','30.426','49','02.980'),(4,16,3,308,'00','00','00','00','00','25','16.693','50','38.373'),(5,24,9,128,'00','00','00','00','00','27','48.231','49','29.434000'),(6,16,3,351,'00','00','00','00','00','25','37.242','50','42.374'),(7,16,3,428,'00','00','00','00','00','26','10.899','50','55.565'),(8,24,1,391,'00','00','00','00','00','28','48.066','49','21.867'),(9,16,3,145,'00','00','00','00','00','24','7.678','50','14.180'),(10,24,1,409,'00','00','00','00','00','28','54.887','49','29.187'),(11,24,1,455,'00','00','00','00','00','29','12.841','49','45.502');
/*!40000 ALTER TABLE `identificacao_obra_localizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identificacao_obra_responsaveis`
--

DROP TABLE IF EXISTS `identificacao_obra_responsaveis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identificacao_obra_responsaveis` (
  `ID_IDENTIFICACAO_OBRA_RESPONSAVEIS` int(11) NOT NULL AUTO_INCREMENT,
  `ID_UNIDADE_LOCAL` int(11) NOT NULL,
  `ID_TIPO_ADMINISTRACAO` int(11) NOT NULL,
  `DS_ADMINISTRADOR` varchar(80) NOT NULL,
  `DS_PROJETISTA_ORIGEM` varchar(80) DEFAULT NULL,
  `DS_PROJETISTA_PROJETISTA` varchar(80) DEFAULT NULL,
  `DS_CONSTRUTOR_ORIGEM` varchar(80) DEFAULT NULL,
  `DS_CONSTRUTOR_CONSTRUTOR` varchar(80) DEFAULT NULL,
  `DS_LOCALIZACAO_PROJETO` varchar(80) DEFAULT NULL,
  `DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO` varchar(80) DEFAULT NULL,
  `DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_RESPONSAVEIS`),
  KEY `fk_identificacaoobraresponsaveis_unidadelocal` (`ID_UNIDADE_LOCAL`),
  KEY `fk_identificacaoobraresponsaveis_tipoadministracao` (`ID_TIPO_ADMINISTRACAO`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identificacao_obra_responsaveis`
--

LOCK TABLES `identificacao_obra_responsaveis` WRITE;
/*!40000 ALTER TABLE `identificacao_obra_responsaveis` DISABLE KEYS */;
INSERT INTO `identificacao_obra_responsaveis` VALUES (1,1,1,'João','José','Junior','Joaquim','Jean','Local 01','Local 01','Local 01'),(2,2,2,'Pristorius','Philco','Phill','Pedro','Paulo','Local 2','Local 2','Local 2'),(3,3,1,'Fernando','Francisco','Fabricio','Frei','Faissal','Local 3','Local 3','Local 3'),(4,4,2,'Mitiko','Milena','Miriam','Michelle','Mirelle','Local 4','Local 4','Local 4'),(5,5,1,'Daniele','Daniele','Daniele','Daniele','Daniele','Local 5','Local 5','Local 5'),(6,1,1,'Pedro','Paulo','Pedro','Paulo','Pedro','Local 06','Local 06','Local 06'),(7,2,2,'Pristorius','Philco','Phill','Pedro','Paulo','Local 07','Local 07','Local 07'),(8,3,1,'Fernando','Francisco','Fabricio','Frei','Faissal','Local 08','Local 08','Local 08'),(9,4,2,'Mitiko','Milena','Miriam','Michelle','Mirelle','Local 09','Local 09','Local 09'),(10,5,1,'Daniele','Daniele','Daniele','Daniele','Daniele','Local 10','Local 10','Local 10'),(11,5,1,'Daniele','Daniele','Daniele','Daniele','Daniele','Local 11','Local 11','Local 11');
/*!40000 ALTER TABLE `identificacao_obra_responsaveis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identificacao_obra_sgo`
--

DROP TABLE IF EXISTS `identificacao_obra_sgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identificacao_obra_sgo` (
  `ID_IDENTIFICACAO_OBRA_SGO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PONTE` int(11) NOT NULL,
  `DT_DATA_INSPECAO` date DEFAULT NULL,
  `NM_INSPETOR` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_IDENTIFICACAO_OBRA_SGO`),
  KEY `fk_identificacaoobrasgo_ponte` (`ID_PONTE`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identificacao_obra_sgo`
--

LOCK TABLES `identificacao_obra_sgo` WRITE;
/*!40000 ALTER TABLE `identificacao_obra_sgo` DISABLE KEYS */;
INSERT INTO `identificacao_obra_sgo` VALUES (1,1,'2016-08-04','inspetor');
/*!40000 ALTER TABLE `identificacao_obra_sgo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagem`
--

DROP TABLE IF EXISTS `imagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagem` (
  `ID_IMAGEM` int(11) NOT NULL AUTO_INCREMENT,
  `NM_NOME` varchar(100) NOT NULL,
  `TIPO_MIME` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_IMAGEM`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagem`
--

LOCK TABLES `imagem` WRITE;
/*!40000 ALTER TABLE `imagem` DISABLE KEYS */;
INSERT INTO `imagem` VALUES (1,'Ponte01Vistageral.jpg','image/jpg'),(2,'Ponte01foto01.jpg','image/jpg'),(3,'Ponte01foto02.jpg','image/jpg'),(4,'Ponte02VistaGeral.jpg','image/jpg'),(5,'Ponte03VistaGeral.jpg','image/jpg'),(6,'Ponte03foto01.jpg','image/jpg'),(7,'Ponte03foto02.jpg','image/jpg'),(8,'Ponte04VistaGeral.jpg','image/jpg'),(9,'Ponte04foto01.jpg','image/jpg'),(10,'Ponte05VistaGeral.jpg','image/jpg'),(11,'Ponte05foto01.jpg','image/jpg'),(12,'Ponte06VistaGeral.jpg','image/jpg'),(13,'Ponte06foto01.jpg','image/jpg'),(14,'Ponte07VistaGeral.jpg','image/jpg'),(15,'Ponte07foto01.jpg','image/jpg'),(16,'Ponte08VistaGeral.jpg','image/jpg'),(17,'Ponte08foto01.jpg','image/jpg'),(18,'Ponte09VistaGeral.jpg','image/jpg'),(19,'Ponte09foto01.jpg','image/jpg'),(20,'Ponte10VistaGeral.jpg','image/jpg'),(21,'Ponte10foto01.jpg','image/jpg'),(22,'Ponte11VistaGeral.jpg','image/jpg'),(23,'Ponte11foto01.jpg','image/jpg');
/*!40000 ALTER TABLE `imagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inspecao`
--

DROP TABLE IF EXISTS `inspecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inspecao` (
  `ID_INSPECAO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PONTE` int(11) NOT NULL,
  `DT_DATA` date NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `ID_MODELO` int(11) NOT NULL,
  `ID_IDENTIFICACAO_OBRA_SGO` int(11) NOT NULL,
  `ID_CONDICOES_SGO` int(11) NOT NULL,
  `ID_LAUDO_ESPECIALIZADO_SGO` int(11) NOT NULL,
  `ID_MONITORAMENTO_SGO` int(11) NOT NULL,
  `DS_RELATORIO` varchar(80) NOT NULL,
  PRIMARY KEY (`ID_INSPECAO`),
  KEY `fk_inspecao_usuario` (`ID_USUARIO`),
  KEY `fk_inspecao_ponte` (`ID_PONTE`),
  KEY `fk_inspecao_modelo` (`ID_MODELO`),
  KEY `fk_inspecao_identificacaoobrasgo` (`ID_IDENTIFICACAO_OBRA_SGO`),
  KEY `fk_inspecao_condicaosgo` (`ID_CONDICOES_SGO`),
  KEY `fk_inspecao_laudoespecializadosgo` (`ID_LAUDO_ESPECIALIZADO_SGO`),
  KEY `fk_inspecao_monitoramentosgo` (`ID_MONITORAMENTO_SGO`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inspecao`
--

LOCK TABLES `inspecao` WRITE;
/*!40000 ALTER TABLE `inspecao` DISABLE KEYS */;
INSERT INTO `inspecao` VALUES (1,1,'2012-08-05',1,1,1,1,1,1,'relatórios1'),(2,2,'2016-02-08',1,1,1,1,1,1,'relatórios2'),(3,3,'2016-03-08',1,1,1,1,1,1,'relatórios3'),(4,4,'2016-04-08',1,1,1,1,1,1,'relatórios4'),(5,5,'2016-05-08',1,1,1,1,1,1,'relatórios5'),(6,1,'2014-08-05',1,1,1,1,1,1,'relatórios6'),(7,1,'2016-08-05',1,1,1,1,1,1,'relatórios7');
/*!40000 ALTER TABLE `inspecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inspecao_manifestacao_elemento`
--

DROP TABLE IF EXISTS `inspecao_manifestacao_elemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inspecao_manifestacao_elemento` (
  `ID_INSPECAO_MANIFESTACAO_ELEMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_INSPECAO` int(11) NOT NULL,
  `ID_DADOS_MANIFESTACAO` int(11) NOT NULL,
  `ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR` int(11) NOT NULL,
  PRIMARY KEY (`ID_INSPECAO_MANIFESTACAO_ELEMENTO`),
  KEY `fk_inspecaomanifestacaoelemento_inspecao` (`ID_INSPECAO`),
  KEY `fk_inspecaomanifestacaoelemento_dadosmanifestacao` (`ID_DADOS_MANIFESTACAO`),
  KEY `fk_inspecaomanifestacaoelemento_elementoufprelementoufpr` (`ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inspecao_manifestacao_elemento`
--

LOCK TABLES `inspecao_manifestacao_elemento` WRITE;
/*!40000 ALTER TABLE `inspecao_manifestacao_elemento` DISABLE KEYS */;
INSERT INTO `inspecao_manifestacao_elemento` VALUES (1,1,1,1),(2,1,2,2),(3,2,3,1),(4,3,4,1),(5,2,5,3),(6,1,1,4),(7,1,2,6),(8,2,3,5),(9,3,4,7),(10,2,5,9),(11,1,1,8),(12,1,2,10),(13,2,3,11),(14,3,4,10),(15,2,5,12);
/*!40000 ALTER TABLE `inspecao_manifestacao_elemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insuficiencias_estruturais_elementos_sgo`
--

DROP TABLE IF EXISTS `insuficiencias_estruturais_elementos_sgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insuficiencias_estruturais_elementos_sgo` (
  `ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_INSPECAO` int(11) NOT NULL,
  `DS_ELEMENTO` varchar(30) DEFAULT NULL,
  `DS_NOTA` varchar(20) DEFAULT NULL,
  `DS_INSUFICIENCIA` varchar(20) DEFAULT NULL,
  `DS_CAUSA_PROVAVEL` varchar(20) DEFAULT NULL,
  `DS_COMENTARIOS` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO`),
  KEY `fk_insuficienciasestruturaiselementossgo_inspecao` (`ID_INSPECAO`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insuficiencias_estruturais_elementos_sgo`
--

LOCK TABLES `insuficiencias_estruturais_elementos_sgo` WRITE;
/*!40000 ALTER TABLE `insuficiencias_estruturais_elementos_sgo` DISABLE KEYS */;
INSERT INTO `insuficiencias_estruturais_elementos_sgo` VALUES (1,1,'elemento1','nota1','insuficiencia1','causa provável1','comentários1'),(2,2,'elemento2','nota2','insuficiencia2','causa provável2','comentários2'),(3,3,'elemento3','nota3','insuficiencia3','causa provável3','comentários3');
/*!40000 ALTER TABLE `insuficiencias_estruturais_elementos_sgo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laudo_especializado_sgo`
--

DROP TABLE IF EXISTS `laudo_especializado_sgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laudo_especializado_sgo` (
  `ID_LAUDO_ESPECIALIZADO_SGO` int(11) NOT NULL AUTO_INCREMENT,
  `DT_DATA_LAUDO` date DEFAULT NULL,
  `DS_CONSULTOR` varchar(30) DEFAULT NULL,
  `DS_OBSERVACOES` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID_LAUDO_ESPECIALIZADO_SGO`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laudo_especializado_sgo`
--

LOCK TABLES `laudo_especializado_sgo` WRITE;
/*!40000 ALTER TABLE `laudo_especializado_sgo` DISABLE KEYS */;
INSERT INTO `laudo_especializado_sgo` VALUES (1,'2016-08-04','consultor','observações');
/*!40000 ALTER TABLE `laudo_especializado_sgo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manifestacao`
--

DROP TABLE IF EXISTS `manifestacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manifestacao` (
  `ID_MANIFESTACAO` int(11) NOT NULL AUTO_INCREMENT,
  `NM_MANIFESTACAO` varchar(100) NOT NULL,
  `DS_BETA` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_MANIFESTACAO`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manifestacao`
--

LOCK TABLES `manifestacao` WRITE;
/*!40000 ALTER TABLE `manifestacao` DISABLE KEYS */;
INSERT INTO `manifestacao` VALUES (1,'manifestacao01','B01'),(2,'manifestacao02','B02');
/*!40000 ALTER TABLE `manifestacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manifestacao_ufpr`
--

DROP TABLE IF EXISTS `manifestacao_ufpr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manifestacao_ufpr` (
  `ID_MANIFESTACAO_UFPR` int(11) NOT NULL AUTO_INCREMENT,
  `CD_MANIFESTACAO_UFPR` int(11) DEFAULT NULL,
  `DS_MANIFESTACAO_UFPR` varchar(100) DEFAULT NULL,
  `DS_UNIDADE` varchar(10) DEFAULT NULL,
  `DS_BETA` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_MANIFESTACAO_UFPR`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manifestacao_ufpr`
--

LOCK TABLES `manifestacao_ufpr` WRITE;
/*!40000 ALTER TABLE `manifestacao_ufpr` DISABLE KEYS */;
INSERT INTO `manifestacao_ufpr` VALUES (1,0,'Corrosão','00','00'),(2,1,'Nicho','01','01'),(3,2,'Desplacamento','02','02'),(4,3,'Manchas de umidade','03','03'),(5,4,'Fissura','04','04'),(6,5,'Eflorescência','05','05'),(7,6,'Nicho de concretagem','06','06'),(8,7,'Buraco','07','07'),(9,8,'Manchas','08','08'),(10,9,'Fissura em linha','09','09'),(11,10,'Corrosão da armadura','10','10'),(12,11,'Manchas de fogo','11','11'),(13,12,'Dano','12','12'),(14,13,'Desalinhamento','13','13'),(15,14,'Deformação','14','14');
/*!40000 ALTER TABLE `manifestacao_ufpr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manifestacoes_extensao`
--

DROP TABLE IF EXISTS `manifestacoes_extensao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manifestacoes_extensao` (
  `ID_MANIFESTACOES_EXTENSAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_MANIFESTACOES_EXTENSAO` varchar(80) DEFAULT NULL,
  `DS_CRITERIO_MANIFESTACOES_EXTENSAO` varchar(200) DEFAULT NULL,
  `DS_CAPA2` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_MANIFESTACOES_EXTENSAO`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manifestacoes_extensao`
--

LOCK TABLES `manifestacoes_extensao` WRITE;
/*!40000 ALTER TABLE `manifestacoes_extensao` DISABLE KEYS */;
INSERT INTO `manifestacoes_extensao` VALUES (1,'Insignificante','Dano irrelevante','0'),(2,'Pequena','Dano de tamanho pequeno, em menos de 10% da área','0,5'),(3,'Média ','Dano de tamanho médio, confinado em uma área pequena 10% a 25% da área total do elemento','1'),(4,'Grande','Dano em área grande de 25% a 75%, ou em muitos lugares de um elemento estrutural','1,5'),(5,'Imensa','Danos muito grandes na maior parte da área de um elemento, mais de 75%','2');
/*!40000 ALTER TABLE `manifestacoes_extensao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manifestacoes_repeticao`
--

DROP TABLE IF EXISTS `manifestacoes_repeticao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manifestacoes_repeticao` (
  `ID_MANIFESTACOES_REPETICAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_CRITERIO_MANIFESTACOES_REPETICAO` varchar(200) DEFAULT NULL,
  `DS_LIMITESUPERIOR` varchar(10) DEFAULT NULL,
  `DS_CAPA3` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_MANIFESTACOES_REPETICAO`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manifestacoes_repeticao`
--

LOCK TABLES `manifestacoes_repeticao` WRITE;
/*!40000 ALTER TABLE `manifestacoes_repeticao` DISABLE KEYS */;
INSERT INTO `manifestacoes_repeticao` VALUES (1,'Dano é aparece em menos de 10% dos elementos estruturais da OAE','0,1','0,5'),(2,'Dano aparece entre 10% e 25% dos elementos estruturais da OAE','0,25','1'),(3,'Dano aparece entre 25% e 75% dos elementos estruturais da OAE','0,75','1,5'),(4,'Dano aparece entre 75% e 100% dos elementos estruturais da OAE','1','2');
/*!40000 ALTER TABLE `manifestacoes_repeticao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manifestacoes_urgencia`
--

DROP TABLE IF EXISTS `manifestacoes_urgencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manifestacoes_urgencia` (
  `ID_MANIFESTACOES_URGENCIA` int(11) NOT NULL AUTO_INCREMENT,
  `DS_MANIFESTACOES_URGENCIA` varchar(80) DEFAULT NULL,
  `DS_CRITERIO_MANIFESTACOES_URGENCIA` varchar(200) DEFAULT NULL,
  `DS_CAPA4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_MANIFESTACOES_URGENCIA`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manifestacoes_urgencia`
--

LOCK TABLES `manifestacoes_urgencia` WRITE;
/*!40000 ALTER TABLE `manifestacoes_urgencia` DISABLE KEYS */;
INSERT INTO `manifestacoes_urgencia` VALUES (1,'Não urgente','Intervenção não é urgente pois o dano não interfere na utilização e capacidade da ponte, e também não altera a sua durabilidade','1'),(2,'Dano à reparar','Dano deve ser reparado em período não maior que 5 anos, para garantir a servicibilidade e não comprometer a durabilidade da OAE','2,5'),(3,'Reparo imediato','Reparo imediato, pois o dano já está comprometendo a utilização da OAE, com risco ás pessoas','4'),(4,'Limitação de carga','Limitação de carga, interrupção de tráfego e escoramento imediato deve ser feito, além do reparo','5');
/*!40000 ALTER TABLE `manifestacoes_urgencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `ID_MODELO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_INDICE_BASE` varchar(20) NOT NULL,
  `DS_INDICE_PERFORMANCE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_MODELO`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,'indice base','indice performance');
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitoramento_sgo`
--

DROP TABLE IF EXISTS `monitoramento_sgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monitoramento_sgo` (
  `ID_MONITORAMENTO_SGO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_PERIODO` varchar(20) DEFAULT NULL,
  `DS_TIPO_MONITORAMENTO` varchar(20) DEFAULT NULL,
  `DS_EXECUTOR` varchar(30) DEFAULT NULL,
  `DS_CUSTO` varchar(20) DEFAULT NULL,
  `DS_OBJETO` varchar(80) DEFAULT NULL,
  `DS_TECNICAS` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID_MONITORAMENTO_SGO`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitoramento_sgo`
--

LOCK TABLES `monitoramento_sgo` WRITE;
/*!40000 ALTER TABLE `monitoramento_sgo` DISABLE KEYS */;
INSERT INTO `monitoramento_sgo` VALUES (1,'período','tipo monitoramento','executor','custo','objeto','técnicas');
/*!40000 ALTER TABLE `monitoramento_sgo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `natureza_transposicao`
--

DROP TABLE IF EXISTS `natureza_transposicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `natureza_transposicao` (
  `ID_NATUREZA_TRANSPOSICAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_NATUREZA_TRANSPOSICAO` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_NATUREZA_TRANSPOSICAO`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `natureza_transposicao`
--

LOCK TABLES `natureza_transposicao` WRITE;
/*!40000 ALTER TABLE `natureza_transposicao` DISABLE KEYS */;
INSERT INTO `natureza_transposicao` VALUES (1,'Ponte'),(2,'Pontilhão'),(3,'Viaduto de transposição de rodovia'),(4,'Viaduto sobre ferrovia'),(5,'Viaduto sobre rodovia / rua'),(6,'Viaduto em encosta'),(7,'Passagem inferior'),(8,'Passarela de pedestres'),(9,'Não informado');
/*!40000 ALTER TABLE `natureza_transposicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numero`
--

DROP TABLE IF EXISTS `numero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numero` (
  `ID_NUMERO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_NUMERO` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_NUMERO`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numero`
--

LOCK TABLES `numero` WRITE;
/*!40000 ALTER TABLE `numero` DISABLE KEYS */;
INSERT INTO `numero` VALUES (1,'numero');
/*!40000 ALTER TABLE `numero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `observacoes`
--

DROP TABLE IF EXISTS `observacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `observacoes` (
  `ID_OBSERVACOES` int(11) NOT NULL AUTO_INCREMENT,
  `DS_IDENTIFICACAO` varchar(20) DEFAULT NULL,
  `DS_OBSERVACOES` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_OBSERVACOES`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `observacoes`
--

LOCK TABLES `observacoes` WRITE;
/*!40000 ALTER TABLE `observacoes` DISABLE KEYS */;
INSERT INTO `observacoes` VALUES (1,'00','00');
/*!40000 ALTER TABLE `observacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ponte`
--

DROP TABLE IF EXISTS `ponte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ponte` (
  `ID_PONTE` int(11) NOT NULL AUTO_INCREMENT,
  `DS_INDICE_PERFORMANCE_RELATIVO` varchar(20) DEFAULT NULL,
  `ID_IDENTIFICACAO_OBRA_DADOS_BASICOS` int(11) NOT NULL,
  `ID_IDENTIFICACAO_OBRA_LOCALIZACAO` int(11) NOT NULL,
  `ID_IDENTIFICACAO_OBRA_RESPONSAVEIS` int(11) NOT NULL,
  `ID_IDENTIFICACAO_OBRA_INSPECAO` int(11) NOT NULL,
  `ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS` int(11) NOT NULL,
  `ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES` int(11) NOT NULL,
  `ID_ROTAS_ALTERNATIVAS` int(11) NOT NULL,
  `ID_OBSERVACOES` int(11) NOT NULL,
  `ID_SUBSTITUICAO` int(11) NOT NULL,
  PRIMARY KEY (`ID_PONTE`),
  KEY `fk_ponte_identificacaoobradadosbasicos` (`ID_IDENTIFICACAO_OBRA_DADOS_BASICOS`),
  KEY `fk_ponte_identificacaoobralocalizacao` (`ID_IDENTIFICACAO_OBRA_LOCALIZACAO`),
  KEY `fk_ponte_identificacaoobraresponsaveis` (`ID_IDENTIFICACAO_OBRA_RESPONSAVEIS`),
  KEY `fk_ponte_identificacaoobrainspecao` (`ID_IDENTIFICACAO_OBRA_INSPECAO`),
  KEY `fk_ponte_caracteristicasfuncionaiscaracteristicas` (`ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS`),
  KEY `fk_ponte_caracteristicasfuncionaisdimensoes` (`ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES`),
  KEY `fk_ponte_rotasalternativas` (`ID_ROTAS_ALTERNATIVAS`),
  KEY `fk_ponte_observacoes` (`ID_OBSERVACOES`),
  KEY `fk_ponte_substituicao` (`ID_SUBSTITUICAO`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ponte`
--

LOCK TABLES `ponte` WRITE;
/*!40000 ALTER TABLE `ponte` DISABLE KEYS */;
INSERT INTO `ponte` VALUES (1,'1',1,1,1,1,1,1,1,1,1),(2,'4',2,2,2,2,1,1,1,1,1),(3,'2',3,3,3,3,1,1,1,1,1),(4,'5',4,4,4,4,1,1,1,1,1),(5,'3',5,5,5,5,1,1,1,1,1),(6,'1',6,6,6,6,1,1,1,1,1),(7,'4',7,7,7,7,1,1,1,1,1),(8,'2',8,8,8,8,1,1,1,1,1),(9,'5',9,9,9,9,1,1,1,1,1),(10,'3',10,10,10,10,1,1,1,1,1),(11,'6',11,11,11,11,1,1,1,1,1);
/*!40000 ALTER TABLE `ponte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranking`
--

DROP TABLE IF EXISTS `ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ranking` (
  `ID_RANKING` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PONTE` int(11) NOT NULL,
  `ID_SIMULACAO` int(11) NOT NULL,
  PRIMARY KEY (`ID_RANKING`),
  KEY `fk_ranking_ponte` (`ID_PONTE`),
  KEY `fk_ranking_simulacao` (`ID_SIMULACAO`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES (1,1,1),(2,2,1),(3,3,3),(4,3,1),(5,2,2),(6,1,4),(7,3,4),(8,2,4);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotas_alternativas`
--

DROP TABLE IF EXISTS `rotas_alternativas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotas_alternativas` (
  `ID_ROTAS_ALTERNATIVAS` int(11) NOT NULL AUTO_INCREMENT,
  `DS_IDENTIFICACAO` varchar(20) DEFAULT NULL,
  `DS_ROTA_ALTERNATIVA` varchar(400) DEFAULT NULL,
  `DS_ACRESCIMO_KM` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ROTAS_ALTERNATIVAS`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotas_alternativas`
--

LOCK TABLES `rotas_alternativas` WRITE;
/*!40000 ALTER TABLE `rotas_alternativas` DISABLE KEYS */;
INSERT INTO `rotas_alternativas` VALUES (1,'00','00','00');
/*!40000 ALTER TABLE `rotas_alternativas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simulacao`
--

DROP TABLE IF EXISTS `simulacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `simulacao` (
  `ID_SIMULACAO` int(11) NOT NULL AUTO_INCREMENT,
  `DT_DATA` date NOT NULL,
  `ID_USUARIO` int(11) NOT NULL,
  `NM_SIMULACAO` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_SIMULACAO`),
  KEY `fk_simulacao_usuario` (`ID_USUARIO`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simulacao`
--

LOCK TABLES `simulacao` WRITE;
/*!40000 ALTER TABLE `simulacao` DISABLE KEYS */;
INSERT INTO `simulacao` VALUES (1,'2016-04-28',1,'simulação 01'),(2,'2016-04-29',1,'simulação 02'),(3,'2016-04-30',5,'simulação 03'),(4,'2016-09-13',6,'simulação 04');
/*!40000 ALTER TABLE `simulacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sistema_construtivo`
--

DROP TABLE IF EXISTS `sistema_construtivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistema_construtivo` (
  `ID_SISTEMA_CONSTRUTIVO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_SISTEMA_CONSTRUTIVO` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_SISTEMA_CONSTRUTIVO`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sistema_construtivo`
--

LOCK TABLES `sistema_construtivo` WRITE;
/*!40000 ALTER TABLE `sistema_construtivo` DISABLE KEYS */;
INSERT INTO `sistema_construtivo` VALUES (1,'Moldado no local'),(2,'Pré-moldado de concreto armado'),(3,'Pré-moldado protendido (pós-tensão)'),(4,'Pré-moldado protendido (pré-tensão)'),(5,'Balanços progressivos c/ continuidade'),(6,'Balanços progressivos c/ articulações'),(7,'Aduelas pré-moldadas'),(8,'Viga calha pré-moldada (Sist protótipo)'),(9,'Ponte empurrada'),(10,'Estaiado em avanços progressivos'),(11,'Não informado'),(12,'Treliça metálica');
/*!40000 ALTER TABLE `sistema_construtivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `substituicao`
--

DROP TABLE IF EXISTS `substituicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `substituicao` (
  `ID_SUBSTITUICAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_IDENTIFICACAO` varchar(20) DEFAULT NULL,
  `DS_EXISTE_PROJETO_SUBSTITUICAO` varchar(20) DEFAULT NULL,
  `DS_CUSTO_ESTIMADO` varchar(20) DEFAULT NULL,
  `DS_OBSERVACOES` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_SUBSTITUICAO`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `substituicao`
--

LOCK TABLES `substituicao` WRITE;
/*!40000 ALTER TABLE `substituicao` DISABLE KEYS */;
INSERT INTO `substituicao` VALUES (1,'00','00','00','00');
/*!40000 ALTER TABLE `substituicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `superintendencia_regional`
--

DROP TABLE IF EXISTS `superintendencia_regional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `superintendencia_regional` (
  `ID_SUPERINTENDENCIA_REGIONAL` int(11) NOT NULL AUTO_INCREMENT,
  `DS_SUPERINTENDENCIA_REGIONAL` varchar(100) NOT NULL,
  `ID_UF` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_SUPERINTENDENCIA_REGIONAL`),
  KEY `fk_superintendenciaregional_uf` (`ID_UF`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `superintendencia_regional`
--

LOCK TABLES `superintendencia_regional` WRITE;
/*!40000 ALTER TABLE `superintendencia_regional` DISABLE KEYS */;
INSERT INTO `superintendencia_regional` VALUES (1,'S.R.E. - RR - Superintendência Regional do DNIT no estado de Roraima',23),(2,'S.R.E. - AL - Superintendência Regional do DNIT no estado de Alagoas',2),(3,'S.R.E. - AM - Superintendência Regional do DNIT no estado de Amazonas',4),(4,'S.R.E. - BA - Superintendência Regional do DNIT no estado da Bahia',5),(5,'S.R.E. - CE - Superintendência Regional do DNIT no estado do Ceará',6),(6,'S.R.E. - ES - Superintendência Regional do DNIT no estado do Espírito Santo',8),(7,'S.R.E. - GO - Superintendência Regional do DNIT no estado de Goiás e Distrito Federal',7),(8,'S.R.E. - MA - Superintendência Regional do DNIT no estado do Maranhão',10),(9,'S.R.E. - MT - Superintendência Regional do DNIT no estado do Mato Grosso',11),(10,'S.R.E. - MS - Superintendência Regional do DNIT no estado do Mato Grosso do Sul',12),(11,'S.R.E. - MG - Superintendência Regional do DNIT no estado de Minas Gerais',13),(12,'S.R.E. - PA - Superintendência Regional do DNIT no estado do Pará',14),(13,'S.R.E. - PB - Superintendência Regional do DNIT no estado de Paraíba',15),(14,'S.R.E. - PR - Superintendência Regional do DNIT no estado do Paraná',16),(15,'S.R.E. - PE - Superintendência Regional do DNIT no estado de Pernambuco',17),(16,'S.R.E. - PI - Superintendência Regional do DNIT no estado do Piauí',18),(17,'S.R.E. - RJ - Superintendência Regional do DNIT no estado do Rio de Janeiro',19),(18,'S.R.E. - RN - Superintendência Regional do DNIT no estado do Rio Grande do Norte',20),(19,'S.R.E. - RS - Superintendência Regional do DNIT no estado do Rio Grande do Sul',21),(20,'S.R.E. - RO - Superintendência Regional do DNIT no estado de Rondônia e Acre',22),(21,'S.R.E. - SC - Superintendência Regional do DNIT no estado de Santa Catarina',24),(22,'S.R.E. - SP - Superintendência Regional do DNIT no estado de São Paulo',25),(23,'S.R.E. - SE - Superintendência Regional do DNIT no estado de Sergipe',26),(24,'S.R.E. - TO - Superintendência Regional do DNIT no estado do Tocantins',27),(25,'S.R.E. - AP - Superintendência Regional do DNIT no estado do Amapá',3);
/*!40000 ALTER TABLE `superintendencia_regional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_administracao`
--

DROP TABLE IF EXISTS `tipo_administracao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_administracao` (
  `ID_TIPO_ADMINISTRACAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_TIPO_ADMINISTRACAO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_TIPO_ADMINISTRACAO`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_administracao`
--

LOCK TABLES `tipo_administracao` WRITE;
/*!40000 ALTER TABLE `tipo_administracao` DISABLE KEYS */;
INSERT INTO `tipo_administracao` VALUES (1,'Administração Direta'),(2,'Administração Indireta');
/*!40000 ALTER TABLE `tipo_administracao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_estrutura`
--

DROP TABLE IF EXISTS `tipo_estrutura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_estrutura` (
  `ID_TIPO_ESTRUTURA` int(11) NOT NULL AUTO_INCREMENT,
  `DS_TIPO_ESTRUTURA` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_TIPO_ESTRUTURA`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_estrutura`
--

LOCK TABLES `tipo_estrutura` WRITE;
/*!40000 ALTER TABLE `tipo_estrutura` DISABLE KEYS */;
INSERT INTO `tipo_estrutura` VALUES (1,'Viga Caixão Concreto Armado'),(2,'Viga Caixão Concreto Protendido'),(3,'Viga de concreto armado'),(4,'Viga de concreto protendido'),(5,'Viga e laje metálicas'),(6,'Mista (viga metal e laje concreto)'),(7,'Arco inferior de concreto armado'),(8,'Arco inferior de concreto protendido'),(9,'Arco inferior metálico'),(10,'Arco superior de concreto armado'),(11,'Arco superior de concreto protendido'),(12,'Arco superior metálico'),(13,'Arco de alvenaria de pedra'),(14,'Treliça metálica'),(15,'Laje de concreto armado'),(16,'Laje de concreto protendido'),(17,'Madeira'),(18,'Estaiada com vigamento metálico'),(19,'Estaiada com vigamento c. protendido'),(20,'Pênsil'),(21,'Não informado');
/*!40000 ALTER TABLE `tipo_estrutura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_regiao`
--

DROP TABLE IF EXISTS `tipo_regiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_regiao` (
  `ID_TIPO_REGIAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_TIPO_REGIAO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_TIPO_REGIAO`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_regiao`
--

LOCK TABLES `tipo_regiao` WRITE;
/*!40000 ALTER TABLE `tipo_regiao` DISABLE KEYS */;
INSERT INTO `tipo_regiao` VALUES (1,'Plana'),(2,'Ondulada'),(3,'Montanhosa'),(4,'Não informado');
/*!40000 ALTER TABLE `tipo_regiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_tracado`
--

DROP TABLE IF EXISTS `tipo_tracado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_tracado` (
  `ID_TIPO_TRACADO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_TIPO_TRACADO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_TIPO_TRACADO`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_tracado`
--

LOCK TABLES `tipo_tracado` WRITE;
/*!40000 ALTER TABLE `tipo_tracado` DISABLE KEYS */;
INSERT INTO `tipo_tracado` VALUES (1,'Tangente'),(2,'Curva'),(3,'Não informado');
/*!40000 ALTER TABLE `tipo_tracado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `ID_TIPO_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_TIPO` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_TIPO_USUARIO`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Administrador'),(2,'Usuário comum'),(3,'Coordenador');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trem_tipo`
--

DROP TABLE IF EXISTS `trem_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trem_tipo` (
  `ID_TREM_TIPO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_TREM_TIPO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_TREM_TIPO`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trem_tipo`
--

LOCK TABLES `trem_tipo` WRITE;
/*!40000 ALTER TABLE `trem_tipo` DISABLE KEYS */;
INSERT INTO `trem_tipo` VALUES (1,'Classe 0'),(2,'Classe 24'),(3,'Classe 36'),(4,'Classe 45');
/*!40000 ALTER TABLE `trem_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uf`
--

DROP TABLE IF EXISTS `uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uf` (
  `ID_UF` int(11) NOT NULL AUTO_INCREMENT,
  `DS_UF` varchar(30) NOT NULL,
  `SG_UF` varchar(2) NOT NULL,
  PRIMARY KEY (`ID_UF`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uf`
--

LOCK TABLES `uf` WRITE;
/*!40000 ALTER TABLE `uf` DISABLE KEYS */;
INSERT INTO `uf` VALUES (1,'Acre','AC'),(2,'Alagoas','AL'),(3,'Amapá','AP'),(4,'Amazonas','AM'),(5,'Bahia','BA'),(6,'Ceará','CE'),(7,'Distrito Federal','DF'),(8,'Espírito Santo','ES'),(9,'Goiás','GO'),(10,'Maranhão','MA'),(11,'Mato Grosso','MG'),(12,'Mato Grosso do Sul','MS'),(13,'Minas Gerais','MG'),(14,'Pará','PA'),(15,'Paraíba','PB'),(16,'Paraná','PR'),(17,'Pernambuco','PE'),(18,'Piauí','PI'),(19,'Rio de Janeiro','RJ'),(20,'Rio Grande do Norte','RN'),(21,'Rio Grande do Sul','RS'),(22,'Rondônia','RO'),(23,'Roraima','RR'),(24,'Santa Catarina','SC'),(25,'São Paulo','SP'),(26,'Sergipe','SE'),(27,'Tocantins','TO');
/*!40000 ALTER TABLE `uf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidade_local`
--

DROP TABLE IF EXISTS `unidade_local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidade_local` (
  `ID_UNIDADE_LOCAL` int(11) NOT NULL AUTO_INCREMENT,
  `DS_UNIDADE_LOCAL` varchar(50) NOT NULL,
  `ID_SUPERINTENDENCIA_REGIONAL` int(11) NOT NULL,
  PRIMARY KEY (`ID_UNIDADE_LOCAL`),
  KEY `fk_unidadelocal_superintendenciaregional` (`ID_SUPERINTENDENCIA_REGIONAL`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidade_local`
--

LOCK TABLES `unidade_local` WRITE;
/*!40000 ALTER TABLE `unidade_local` DISABLE KEYS */;
INSERT INTO `unidade_local` VALUES (1,'ULPR01 - Colombo',14),(2,'ULPR02 - Campo Mourão',14),(3,'ULPR03 - Laranjeiras do Sul',14),(4,'ULPR04 - Ponta Grossa',14),(5,'ULPR05 - Foz do Iguaçu',14),(6,'ULPR06 - São José dos Pinhais',14),(7,'ULPR07 - Londrina',14),(8,'PROFE-PR Procuradoria Federal Especializada SRE-PR',14),(9,'UL P. Branco/PR - Unidade local em Pato Branco/PR',14),(10,'ULSC01 - Tubarão',21),(11,'ULSC02 - Joinville',21),(12,'ULSC03 - Lages',21),(13,'ULSC04 - Joaçaba',21),(14,'ULSC05 - Mafra',21),(15,'ULSC08 - Chapecó',21),(16,'ULSC09 - Florianópolis',21),(17,'ULSC07 - Rio do Sul',21),(18,'ULSC06 - São José',21),(19,'ULSC09 - vago',21);
/*!40000 ALTER TABLE `unidade_local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NM_NOME` varchar(50) NOT NULL,
  `DS_USUARIO` varchar(20) NOT NULL,
  `DS_EMAIL` varchar(30) NOT NULL,
  `DS_SENHA` varchar(20) NOT NULL,
  `ID_TIPO_USUARIO` int(11) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  KEY `fk_usuario_tipousuario` (`ID_TIPO_USUARIO`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Dani','dani','ito.dani','123',1),(2,'Daniele','daniele','ito.dani','123',3),(3,'Usu1','usu1','ito.dani','123',1),(4,'Usu2','usu2','ito.dani','123',1),(5,'dhi','dhi','dhi@inf.ufpr.br','123',2),(6,'mauro','mauro','mauro@ufpr.br','123',3);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `via`
--

DROP TABLE IF EXISTS `via`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `via` (
  `ID_VIA` int(11) NOT NULL AUTO_INCREMENT,
  `DS_VIA` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_VIA`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `via`
--

LOCK TABLES `via` WRITE;
/*!40000 ALTER TABLE `via` DISABLE KEYS */;
INSERT INTO `via` VALUES (1,'BR-101'),(2,'BR-116'),(3,'BR-153'),(4,'BR-158'),(5,'BR-163'),(6,'BR-272'),(7,'BR-277'),(8,'BR-280'),(9,'BR-282'),(10,'BR-283'),(11,'BR-285'),(12,'BR-369'),(13,'BR-373'),(14,'BR-376'),(15,'BR-386'),(16,'BR-466'),(17,'BR-467'),(18,'BR-469'),(19,'BR-470'),(20,'BR-471'),(21,'BR-475'),(22,'BR-476'),(23,'BR-477'),(24,'BR-480'),(25,'BR-486'),(26,'BR-487');
/*!40000 ALTER TABLE `via` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-21 16:17:05
