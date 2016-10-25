insert into TIPO_USUARIO (DS_TIPO) values ('Administrador');
insert into TIPO_USUARIO (DS_TIPO) values ('Usuário comum');
insert into TIPO_USUARIO (DS_TIPO) values ('Coordenador');

insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Dani', 'dani', 'ito.dani', '123', 1);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Daniele', 'daniele', 'ito.dani', '123', 3);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Usu1', 'usu1', 'ito.dani', '123', 1);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('Usu2', 'usu2', 'ito.dani', '123', 1);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('dhi', 'dhi', 'dhi@inf.ufpr.br', '123', 2);
insert into USUARIO (NM_NOME, DS_USUARIO, DS_EMAIL, DS_SENHA, ID_TIPO_USUARIO) values ('mauro', 'mauro', 'mauro@ufpr.br', '123', 3);

---------------------------------------------------------------------------

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

insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('28/04/2016', 1, 'simulação 01');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('29/04/2016', 1, 'simulação 02');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('30/04/2016', 5, 'simulação 03');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('13/09/2016', 6, 'simulação 04');

---------------------------------------------------------------------------

insert into ELEMENTO (NM_ELEMENTO, DS_CAPA) values ('elemento01', 'K01');
insert into ELEMENTO (NM_ELEMENTO, DS_CAPA) values ('elemento02', 'K02');

insert into MANIFESTACAO (NM_MANIFESTACAO, DS_BETA) values ('manifestacao01', 'B01');
insert into MANIFESTACAO (NM_MANIFESTACAO, DS_BETA) values ('manifestacao02', 'B02');

---------------------------------------------------------------------------

--------------------------------DADOS PARA PREENCHIMENTO CADASTRO-----------------------------------

insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Ponte');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Pontilhão');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto de transposição de rodovia');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto sobre ferrovia');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto sobre rodovia / rua');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Viaduto em encosta');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Passagem inferior');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Passarela de pedestres');
insert into NATUREZA_TRANSPOSICAO (DS_NATUREZA_TRANSPOSICAO) values ('Não informado');


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

insert into TREM_TIPO (DS_TREM_TIPO) values ('Classe 0');
insert into TREM_TIPO (DS_TREM_TIPO) values ('Classe 24');
insert into TREM_TIPO (DS_TREM_TIPO) values ('Classe 36');
insert into TREM_TIPO (DS_TREM_TIPO) values ('Classe 45');

insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Plana');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Ondulada');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Montanhosa');
insert into TIPO_REGIAO	 (DS_TIPO_REGIAO) values ('Não informado');

insert into TIPO_TRACADO (DS_TIPO_TRACADO) values ('Tangente');
insert into TIPO_TRACADO (DS_TIPO_TRACADO) values ('Curva');
insert into TIPO_TRACADO (DS_TIPO_TRACADO) values ('Não informado');

insert into TIPO_ADMINISTRACAO	 (DS_TIPO_ADMINISTRACAO) values ('Administração Direta');
insert into TIPO_ADMINISTRACAO	 (DS_TIPO_ADMINISTRACAO) values ('Administração Indireta');

---------------------------------------------------------------------------

--------------------------------CADASTRO-----------------------------------

insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('01', '11', '55', 'Ponte 01', 1, 1, 3, '01', '01', 1, '01');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('02', '22', '66', 'Ponte 02', 2, 3, 2, '00', '00', 2, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('03', '33', '77', 'Ponte 03', 3, 2, 5, '00', '00', 3, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('04', '44', '88', 'Ponte 04', 4, 5, 3, '00', '00', 2, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('05', '55', '99', 'Ponte 05', 5, 4, 1, '00', '00', 4, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('06', '66', '11', 'Ponte 06', 1, 6, 10, '06', '06', 1, '06');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('07', '77', '22', 'Ponte 07', 2, 7, 6, '07', '07', 2, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('08', '88', '33', 'Ponte 08', 3, 8, 9, '08', '08', 3, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('09', '99', '44', 'Ponte 09', 4, 9, 7, '09', '09', 2, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('10', '10', '10', 'Ponte 10', 5, 10, 8, '10', '10', 4, '00');
insert into IDENTIFICACAO_OBRA_DADOS_BASICOS (CD_CODIGO, CD_CODIGO_INTEGRACAO, DS_STATUS, DS_IDENTIFICACAO, ID_NATUREZA_TRANSPOSICAO, ID_TIPO_ESTRUTURA, ID_SISTEMA_CONSTRUTIVO, DS_COMPRIMENTO, DS_LARGURA, ID_TREM_TIPO, DS_ANO_CONSTRUCAO) 
values ('11', '11', '11', 'Ponte 11', 5, 10, 8, '11', '11', 4, '00');

insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (16, 3, 10.5, '00', '00', '00', '00', '00', '25', '33.347', '49', '20.542');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (16, 3, 66.4, '00', '00', '00', '00', '00', '23', '29.985', '50', '6.535');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (24, 1, 304.1, '00', '00', '00', '00', '00', '28', '30.426', '49', '02.980');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (16, 3, 308.5, '00', '00', '00', '00', '00', '25', '16.693', '50', '38.373');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (24, 9, 128.3, '00', '00', '00', '00', '00', '27', '48.231', '49', '29.434000');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (16, 3, 351, '00', '00', '00', '00', '00', '25', '37.242', '50', '42.374');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (16, 3, 428.1, '00', '00', '00', '00', '00', '26', '10.899', '50', '55.565');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (24, 1, 391, '00', '00', '00', '00', '00', '28', '48.066', '49', '21.867');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (16, 3, 145.5, '00', '00', '00', '00', '00', '24', '7.678', '50', '14.180');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (24, 1, 408.6, '00', '00', '00', '00', '00', '28', '54.887', '49', '29.187');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (24, 1, 454.9, '00', '00', '00', '00', '00', '29', '12.841', '49', '45.502');

insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (1, 1, 'João', 'José', 'Junior', 'Joaquim', 'Jean', 'Local 01', 'Local 01', 'Local 01');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (2, 2, 'Pristorius', 'Philco', 'Phill', 'Pedro', 'Paulo', 'Local 2', 'Local 2', 'Local 2');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (3, 1, 'Fernando', 'Francisco', 'Fabricio', 'Frei', 'Faissal', 'Local 3', 'Local 3', 'Local 3');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (4, 2, 'Mitiko', 'Milena', 'Miriam', 'Michelle', 'Mirelle', 'Local 4', 'Local 4', 'Local 4');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (5, 1, 'Daniele', 'Daniele', 'Daniele', 'Daniele', 'Daniele', 'Local 5', 'Local 5', 'Local 5');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (1, 1, 'Pedro', 'Paulo', 'Pedro', 'Paulo', 'Pedro', 'Local 06', 'Local 06', 'Local 06');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (2, 2, 'Pristorius', 'Philco', 'Phill', 'Pedro', 'Paulo', 'Local 07', 'Local 07', 'Local 07');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (3, 1, 'Fernando', 'Francisco', 'Fabricio', 'Frei', 'Faissal', 'Local 08', 'Local 08', 'Local 08');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (4, 2, 'Mitiko', 'Milena', 'Miriam', 'Michelle', 'Mirelle', 'Local 09', 'Local 09', 'Local 09');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (5, 1, 'Daniele', 'Daniele', 'Daniele', 'Daniele', 'Daniele', 'Local 10', 'Local 10', 'Local 10');
insert into IDENTIFICACAO_OBRA_RESPONSAVEIS (ID_UNIDADE_LOCAL, ID_TIPO_ADMINISTRACAO, DS_ADMINISTRADOR, DS_PROJETISTA_ORIGEM, DS_PROJETISTA_PROJETISTA, DS_CONSTRUTOR_ORIGEM, DS_CONSTRUTOR_CONSTRUTOR, DS_LOCALIZACAO_PROJETO, DS_LOCALIZACAO_DOCUMENTOS_CONSTRUCAO, DS_LOCALIZACAO_DOCUMENTOS_DIVERSOS) 
values (5, 1, 'Daniele', 'Daniele', 'Daniele', 'Daniele', 'Daniele', 'Local 11', 'Local 11', 'Local 11');

insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('01', '01', '01');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('02', '02', '02');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('03', '03', '03');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('04', '04', '04');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('05', '05', '05');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('06', '06', '06');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('07', '07', '07');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('08', '08', '08');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('09', '09', '09');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('10', '10', '10');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('11', '11', '11');

---------------------------------------------------------------------------

insert into CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS (ID_TIPO_REGIAO, ID_TIPO_TRACADO, DS_RAMPA_MAXIMA, DS_RAIO_CURVA, DS_VMD) values (1, 1, '00', '0', '00');

insert into CARACTERISTICAS_FUNCIONAIS_DIMENSOES (DS_NUMERO_FAIXAS, DS_LARGURA_FAIXA, DS_ACOSTAMENTO_DIREITO, DS_ACOSTAMENTO_ESQUERDO, DS_CALCADA_DIREITA, DS_CALCADA_ESQUERDA, 
DS_LARGURA_TOTAL_PISTA, DS_GABARITO_HORIZONTAL, DS_GABARITO_VERTICAL, DS_NUMERO_VAOS, DS_DESCRICAO_VAOS) 
values ('NF 10', 'LF 20', 'AD 30', 'AE 40', 'CD 50', 'CE 60', 'LTP 70', 'GH 80', 'GV 90', 'NV 10', 'DV 20');

--------------------------------------------------------------------------- 

insert into FOTO (DS_FOTO) values ('foto');

--insert into EXTENSAO_RELATIVA (DS_EXTENSAO_RELATIVA) values ('extensao relativa');

--insert into REPARO (DS_REPARO) values ('reparo');

insert into NUMERO (DS_NUMERO) values ('numero');
---------------------------------------------------------------------------

insert into ROTAS_ALTERNATIVAS (DS_IDENTIFICACAO, DS_ROTA_ALTERNATIVA, DS_ACRESCIMO_KM) values ('00', '00', '00');

insert into SUBSTITUICAO (DS_IDENTIFICACAO, DS_EXISTE_PROJETO_SUBSTITUICAO, DS_CUSTO_ESTIMADO, DS_OBSERVACOES) values ('00', '00', '00', '00');

insert into OBSERVACOES (DS_IDENTIFICACAO, DS_OBSERVACOES) values ('00', '00');

---------------------------------------------------------------------------

insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Insignificante','Dano irrelevante','0');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Pequena','Dano de tamanho pequeno, em menos de 10% da área','0,5');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Média ','Dano de tamanho médio, confinado em uma área pequena 10% a 25% da área total do elemento','1');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Grande','Dano em área grande de 25% a 75%, ou em muitos lugares de um elemento estrutural','1,5');
insert into MANIFESTACOES_EXTENSAO (DS_MANIFESTACOES_EXTENSAO, DS_CRITERIO_MANIFESTACOES_EXTENSAO,DS_CAPA2) values ('Imensa','Danos muito grandes na maior parte da área de um elemento, mais de 75%','2');

---------------------------------------------------------------------------

insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Não urgente','Intervenção não é urgente pois o dano não interfere na utilização e capacidade da ponte, e também não altera a sua durabilidade','1');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Dano à reparar','Dano deve ser reparado em período não maior que 5 anos, para garantir a servicibilidade e não comprometer a durabilidade da OAE','2,5');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Reparo imediato','Reparo imediato, pois o dano já está comprometendo a utilização da OAE, com risco ás pessoas','4');
insert into MANIFESTACOES_URGENCIA (DS_MANIFESTACOES_URGENCIA, DS_CRITERIO_MANIFESTACOES_URGENCIA,DS_CAPA4) values ('Limitação de carga','Limitação de carga, interrupção de tráfego e escoramento imediato deve ser feito, além do reparo','5');

---------------------------------------------------------------------------

insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano é aparece em menos de 10% dos elementos estruturais da OAE','0,1','0,5');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 10% e 25% dos elementos estruturais da OAE','0,25','1');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 25% e 75% dos elementos estruturais da OAE','0,75','1,5');
insert into MANIFESTACOES_REPETICAO (DS_CRITERIO_MANIFESTACOES_REPETICAO, DS_LIMITESUPERIOR, DS_CAPA3) values ('Dano aparece entre 75% e 100% dos elementos estruturais da OAE','1','2');

---------------------------------------------------------------------------

insert into MODELO (DS_INDICE_BASE, DS_INDICE_PERFORMANCE) values ('indice base', 'indice performance');

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

insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '1', 'Laje de concreto armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '2', 'Laje de Concreto Protendido','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '3', 'Laje Metálica Ortotrópica','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '4', 'Laje Metálica de Chapa Corrugada','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '7', 'Laje em Pranchão de Madeira','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '5', 'Ponte em Laje de Concreto Armado','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '6', 'Ponte em Laje de Concreto Protendido','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '204', 'Travessa de apoio de concreto armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '205', 'Travessa de apoio de concreto protendido','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '104', 'Viga T ou I de concreto armado','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '105', 'Viga T ou I de concreto protendido','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '106', 'Viga I metálica','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '101', 'Viga Caixão de Concreto Armado','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '102', 'Viga Caixão de Concreto Protendido','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '103', 'Viga Caixão Metálica','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '206', 'Viga de contraventamento de pilar de concreto armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '109', 'Transversina Portante de Concreto Armado','0,3');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '110', 'Transversina Portante de Concreto Protendido','0,3');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '111', 'Transversina Portante Metálica','0,3');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '112', 'Transversina de Ligação de Concreto Armado','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '113', 'Transversina de Ligação de Concreto Protendido','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '114', 'Transversina de Ligação Metálica','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '202', 'Pilar em Colunas de Concreto Armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '201', 'Pilar Parede de Concreto Armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '203', 'Pilar Vazado de Concreto Armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '200', 'Pilar Parede de Alvenaria de Pedra','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '207', 'Parede de contraventamento de pilar de concreto armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '301', 'Aparelho de Apoio de Neoprene Fretado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '302', 'Aparelho de Apoio de Teflon','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '303', 'Aparelho de Apoio de Rolo Metálico','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '304', 'Aparelho de Apoio de Placa de Chumbo','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '305', 'Aparelho de Apoio Pot Bearing Fixo','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '306', 'Aparelho de Apoio Pot Bearing Directional','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '307', 'Aparelho de Apoio Freyssinet','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '308', 'Aparelho de Apoio Pêndulo','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '309', 'Articulação Metálica','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '107', 'Dente Gerber de Concreto Armado','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '108', 'Dente Gerber de concreto armado com protensão','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '118', 'Dente Gerber Metálico','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '252', 'Encontro de alvenaria de pedra','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '251', 'Encontro - Parede frontal portante de concreto armado','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '253', 'Encontro - Parede Lateral e Vigas de Concreto Armado','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '256', 'Encontro - Paredes e Vigas Secundárias de Concreto','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '254', 'Encontro - Laje de Concreto Armado','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '255', 'Encontro - Cortina de Concreto Armado','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '816', 'Muro de Arrimo de Concreto','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '818', 'Muro de Terra Armada','0,3');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '817', 'Revestimento de talude em concreto','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '504', 'Estaca de Concreto Armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '505', 'Estaca Metálica','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '506', 'Estaca de Madeira','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '501', 'Bloco ou Sapata de concreto armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '502', 'Tubulão ou estacão de concreto armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '503', 'Camisa Metálica de Revestimento para Estaca','0,3');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '813', 'Junta elastomérica de dilatação','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '815', 'Junta metálica de dilatação','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '801', 'Pavimento Asfáltico','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '802', 'Pavimento de Concreto','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '808', 'Calçada para pedestres de concreto armado','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '809', 'Calçada para pedestres metálica','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '803', 'Barreira new jersey','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '805', 'Guarda rodas qualquer','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '806', 'Guarda Corpo de Concreto Armado','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '807', 'Guarda Corpo Metálico','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '703', 'Reforço viga I - Encamisamento de viga','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '704', 'Reforço viga II - Armadura principal passiva','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '705', 'Reforço viga III - Cabo de protensão externo','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '706', 'Reforço viga IV - Bloqueio de articulação Gerber','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '701', 'Reforço laje I - Sobrelaje de concreto armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '702', 'Reforço de Laje II - Infradorso laje em Concreto Armado','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '707', 'Reforço de pilar - Encamisamento de pilar','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '708', 'Reforço estaca - Encamisamento de trecho livre','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '811', 'Aterro de Acesso','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '810', 'Laje de Aproximação','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '601', 'Torre de Concreto Armado para Estaiamento','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '603', 'Ancoragens de estais','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '451', 'Treliça de Concreto Armado','0,5');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '452', 'Treliça Metálica','0,5');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '401', 'Arco de Concreto Armado','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '402', 'Arco de Concreto Protendido','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '403', 'Arco Metálico','0,6');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '806', 'Guarda rodas antigo do DNER','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '812', 'Berço para junta de dilatação','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '814', 'Junta de dilatação','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '115', 'Cortina de concreto armado','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '116', 'Longarina de enrigecimento de laje','0,4');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '1000', 'Operação','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '1001', 'Drenagem','0,2');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '1002', 'Sinalização','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '820', 'Defensa Metálica','0,1');
insert into ELEMENTO_UFPR (CD_ELEMENTO, DS_ELEMENTO, DS_CAPA1) values ( '819', 'Muro de gabião','0,4');

---------------------------------------------------------------------------

insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('00','Corrosão','00','00');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('01','Nicho','01','01');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('02','Desplacamento','02','02');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('03','Manchas de umidade','03','03');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('04','Fissura','04','04');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('05','Eflorescência','05','05');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('06','Nicho de concretagem','06','06');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('07','Buraco','07','07');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('08','Manchas','08','08');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('09','Fissura em linha','09','09');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('10','Corrosão da armadura','10','10');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('11','Manchas de fogo','11','11');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('12','Dano','12','12');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('13','Desalinhamento','13','13');
insert into MANIFESTACAO_UFPR (CD_MANIFESTACAO_UFPR, DS_MANIFESTACAO_UFPR, DS_UNIDADE, DS_BETA) values ('14','Deformação','14','14');

---------------------------------------------------------------------------

--insert into CADASTRO_MANIFESTACAO (ID_NUMERO, ID_MANIFESTACOES_UFPR, ID_FOTO, DS_TAMANHO, ID_EXTENSAO_RELATIVA, ID_REPARO) values (1, 1, 1, 'tamanho', 1, 1);

---------------------------------------------------------------------------

insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (1.2, 1, 1, 1, 1, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (4.3, 2, 2, 2, 2, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (2.5, 3, 3, 3, 3, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (5.6, 4, 4, 4, 4, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (3.9, 5, 5, 5, 5, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (1.7, 6, 6, 6, 6, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (4.7, 7, 7, 7, 7, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (2.2, 8, 8, 8, 8, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (5.1, 9, 9, 9, 9, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (3.1, 10, 10, 10, 10, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO) values (6.4, 11, 11, 11, 11, 1, 1, 1, 1, 1);

---------------------------------------------------------------------------

insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte01Vistageral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte01foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte01foto02.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte02VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte03VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte03foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte03foto02.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte04VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte04foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte05VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte05foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte06VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte06foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte07VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte07foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte08VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte08foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte09VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte09foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte10VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte10foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte11VistaGeral.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Ponte11foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('Croqui.pdf', 'image/pdf');

insert into IMAGEM(NM_NOME, TIPO_MIME) values ('foto01.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('foto02.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('foto03.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('foto04.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('foto05.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('foto06.jpg', 'image/jpg');
insert into IMAGEM(NM_NOME, TIPO_MIME) values ('foto01.jpg', 'image/jpg');
---------------------------------------------------------------------------

insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Meio ambiente agressivo');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Nível de vibração elevado');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Leito do rio erodível');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Fundação em solo mole');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Frequência elevada de carga pesada');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Desnível elevado entre greide e terreno');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Rio com lâmina dágua normal profunda');
insert into ASPECTOS_ESPECIAIS (DS_ASPECTOS_ESPECIAIS) values ('Grande variação do NA do rio na cheia');

---------------------------------------------------------------------------

---------------------------------------------------------------------------

insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 1);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (2, 1);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (3, 3);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (3, 1);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (2, 2);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 4);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (3, 4);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (2, 4);

---------------------------------------------------------------------------

insert into ELEMENTO_COMPONENTES (ID_PONTE, ID_ELEMENTO_UFPR, DS_DETALHE, NR_QUANTIDADE) values (1, 1, '00', '00');

---------------------------------------------------------------------------

insert into IDENTIFICACAO_OBRA_SGO values (1, '04/08/2016', 'inspetor1');
insert into IDENTIFICACAO_OBRA_SGO values (2, '10/08/2016', 'inspetor2');
insert into IDENTIFICACAO_OBRA_SGO values (3, '29/08/2016', 'inspetor3');

insert into CONDICOES_SGO values ('cond estabilidade1', 'cond conservacao1', 'observacoes1', 'nota técnica1');
insert into CONDICOES_SGO values ('cond estabilidade2', 'cond conservacao2', 'observacoes2', 'nota técnica2');
insert into CONDICOES_SGO values ('cond estabilidade3', 'cond conservacao3', 'observacoes3', 'nota técnica3');


insert into LAUDO_ESPECIALIZADO_SGO values ('04/08/2016', 'consultor1', 'observações1');
insert into LAUDO_ESPECIALIZADO_SGO values ('10/08/2016', 'consultor2', 'observações2');
insert into LAUDO_ESPECIALIZADO_SGO values ('29/08/2016', 'consultor3', 'observações3');

insert into MONITORAMENTO_SGO values ('período1', 'tipo monitoramento1', 'executor1', 'custo1', 'objeto1', 'técnicas1');
insert into MONITORAMENTO_SGO values ('período2', 'tipo monitoramento2', 'executor2', 'custo2', 'objeto2', 'técnicas2');
insert into MONITORAMENTO_SGO values ('período3', 'tipo monitoramento3', 'executor3', 'custo3', 'objeto3', 'técnicas3');

---------------------------------------------------------------------------

insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('05/08/2012', 1, 1, 1, 1, 1, 1, 1, 'relatórios1');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('08/02/2016', 1, 2, 1, 2, 2, 2, 2, 'relatórios2');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('08/03/2016', 1, 3, 1, 3, 3, 3, 3, 'relatórios3');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('08/04/2016', 1, 4, 1, 1, 2, 3, 1, 'relatórios4');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('08/05/2016', 1, 5, 1, 3, 3, 2, 1, 'relatórios5');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('05/08/2014', 1, 1, 1, 2, 1, 1, 3, 'relatórios6');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('05/08/2016', 1, 1, 1, 3, 2, 1, 2, 'relatórios7');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('05/08/2012', 1, 6, 1, 1, 1, 1, 1, 'relatórios8');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('08/02/2016', 1, 7, 1, 2, 2, 2, 2, 'relatórios9');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('08/03/2016', 1, 8, 1, 3, 3, 3, 3, 'relatórios10');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('08/04/2016', 1, 9, 1, 1, 2, 3, 2, 'relatórios11');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('08/05/2016', 1, 10, 1, 3, 3, 2, 1, 'relatórios12');
insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO, ID_IDENTIFICACAO_OBRA_SGO, ID_CONDICOES_SGO, ID_LAUDO_ESPECIALIZADO_SGO, ID_MONITORAMENTO_SGO, DS_RELATORIO) values ('20/08/2014', 1, 11, 1, 2, 1, 1, 3, 'relatórios13');
																																																		  
---------------------------------------------------------------------------																																  

insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '01.jpg', 'Foto', '01', 'Vista geral', 'OAE', '05/07/2016', 1);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '02.jpg', 'Foto', '02', 'Pista rolamento', 'OAE', '05/07/2016', 2);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '03.jpg', 'Foto', '03', 'Vista geral', 'OAE', '05/07/2016', 3);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (2, 'geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '19/09/2016', 4);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (3, 'ponte03Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '20/09/2016', 5);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (3, 'ponte03foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '20/09/2016', 6);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (3, 'ponte03foto02.jpg', 'Foto', '03', 'foto 02', 'OAE', '20/09/2016', 7);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (4, 'ponte04Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '20/09/2016', 8);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (4, 'ponte04foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '21/09/2016', 9);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (5, 'ponte05Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '21/09/2016', 10);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (5, 'ponte05foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '21/09/2016', 11);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (6, 'ponte06Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '21/09/2016', 12);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (6, 'ponte06foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '21/09/2016', 13);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (7, 'ponte07Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '21/09/2016', 14);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (7, 'ponte07foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '21/09/2016', 15);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (8, 'ponte08Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '21/09/2016', 16);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (8, 'ponte08foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '21/09/2016', 17);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (9, 'ponte09Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '21/09/2016', 18);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (9, 'ponte09foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '21/09/2016', 19);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (10, 'ponte10Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '21/09/2016', 20);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (10, 'ponte10foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '21/09/2016', 21);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (11, 'ponte11Geral.jpg', 'Foto', '01', 'Vista geral', 'OAE', '21/09/2016', 22);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (11, 'ponte11foto01.jpg', 'Foto', '02', 'foto 01', 'OAE', '21/09/2016', 23);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, 'Croqui.pdf', 'esquema', '01', 'croqui 01', 'OAE', '05/10/2016', 24);


insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '01.jpg', 'Foto', '01', 'foto01', 'INS', '05/08/2012', 25);
insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '02.jpg', 'Foto', '02', 'foto02', 'INS', '05/08/2012', 26);
insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '03.jpg', 'Foto', '03', 'foto03', 'INS', '05/08/2012', 27);
insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '04.jpg', 'Foto', '04', 'foto04', 'INS', '05/08/2012', 28);
insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '05.jpg', 'Foto', '05', 'foto05', 'INS', '05/08/2012', 29);
insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '06.jpg', 'Foto', '06', 'foto06', 'INS', '05/08/2012', 30);
insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (6, '01.jpg', 'Foto', '01', 'foto01', 'INS', '05/08/2014', 31);

---------------------------------------------------------------------------

--insert into DADOS_ELEMENTO (DS_NUMERO, DS_FOTO, DS_TAMANHO) values ('num', 'foto', 'tam');

insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 1', 'tam 1', 1, 1);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 2', 'tam 2', 2, 2);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 3', 'tam 3', 3, 3);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 4', 'tam 4', 4, 4);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 5', 'tam 5', 5, 2);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 6', 'tam 6', 1, 1);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 7', 'tam 7', 3, 1);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 8', 'tam 8', 2, 2);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 9', 'tam 9', 5, 3);
insert into DADOS_MANIFESTACAO (DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values ('foto 10', 'tam 10', 4, 4);

insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (1, 1);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (2, 2);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (3, 3);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (4, 4);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (5, 5);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (6, 6);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (7, 7);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (8, 8);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (9, 9);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (10, 10);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (11, 11);
insert into ELEMENTO_UFPR_MANIFESTACAO_UFPR (ID_ELEMENTO_UFPR, ID_MANIFESTACAO_UFPR) values (12, 12);

---------------------------------------------------------------------------

insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (1, 1, 1);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (1, 2, 2);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (2, 2, 1);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (3, 4, 1);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (2, 5, 3);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (1, 3, 4);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (1, 4, 6);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (2, 1, 5);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (3, 3, 7);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (2, 5, 9);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (1, 5, 8);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (1, 2, 10);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (2, 3, 11);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (3, 5, 10);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (2, 4, 12);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (4, 1, 1);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (5, 2, 2);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (6, 2, 1);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (7, 4, 1);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (8, 5, 3);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (9, 3, 4);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (10, 4, 6);
insert into INSPECAO_MANIFESTACAO_ELEMENTO (ID_INSPECAO, ID_DADOS_MANIFESTACAO, ID_ELEMENTO_UFPR_MANIFESTACAO_UFPR) values (11, 1, 5);

---------------------------------------------------------------------------

insert into DANOS_ELEMENTOS_SGO values (1, 'elemento1', 'nota1', 'dano1', 'unidade1', 'quantidade1', 'ext relativa1', 'localizacao1');
insert into DANOS_ELEMENTOS_SGO values (2, 'elemento2', 'nota2', 'dano2', 'unidade2', 'quantidade2', 'ext relativa2', 'localizacao2');
insert into DANOS_ELEMENTOS_SGO values (3, 'elemento3', 'nota3', 'dano3', 'unidade3', 'quantidade3', 'ext relativa3', 'localizacao3');

insert into INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO values (1, 'elemento1', 'nota1', 'insuficiencia1', 'causa provável1', 'comentários1');
insert into INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO values (2, 'elemento2', 'nota2', 'insuficiencia2', 'causa provável2', 'comentários2');
insert into INSUFICIENCIAS_ESTRUTURAIS_ELEMENTOS_SGO values (3, 'elemento3', 'nota3', 'insuficiencia3', 'causa provável3', 'comentários3');

---------------------------------------------------------------------------
