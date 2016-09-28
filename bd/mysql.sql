CREATE DATABASE  IF NOT EXISTS `emea` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `emea`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: emea
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `aspectos_especiais`
--

DROP TABLE IF EXISTS `aspectos_especiais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aspectos_especiais` (
  `ID_ASPECTOS_ESPECIAIS` int(11) NOT NULL AUTO_INCREMENT,
  `DS_ASPECTOS_ESPECIAIS` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID_ASPECTOS_ESPECIAIS`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracao`
--

LOCK TABLES `configuracao` WRITE;
/*!40000 ALTER TABLE `configuracao` DISABLE KEYS */;
/*!40000 ALTER TABLE `configuracao` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
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
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto` (
  `ID_FOTO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_FOTO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_FOTO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
-- Table structure for table `sistema_construtivo`
--

DROP TABLE IF EXISTS `sistema_construtivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistema_construtivo` (
  `ID_SISTEMA_CONSTRUTIVO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_SISTEMA_CONSTRUTIVO` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_SISTEMA_CONSTRUTIVO`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
-- Table structure for table `tipo_administracao`
--

DROP TABLE IF EXISTS `tipo_administracao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_administracao` (
  `ID_TIPO_ADMINISTRACAO` int(11) NOT NULL AUTO_INCREMENT,
  `DS_TIPO_ADMINISTRACAO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_TIPO_ADMINISTRACAO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
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
-- Table structure for table `via`
--

DROP TABLE IF EXISTS `via`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `via` (
  `ID_VIA` int(11) NOT NULL AUTO_INCREMENT,
  `DS_VIA` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_VIA`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
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

-- Dump completed on 2016-09-28 13:59:11
