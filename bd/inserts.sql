﻿insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('28/04/2016', 1, 'simulação 1');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('30/04/2016', 1, 'simulação 2');
insert into SIMULACAO (DT_DATA, ID_USUARIO, NM_SIMULACAO) values ('01/05/2016', 1, 'simulação 3');

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

insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (1, 1, 10.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (2, 2, 20.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (3, 3, 30.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (4, 4, 40.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');
insert into IDENTIFICACAO_OBRA_LOCALIZACAO (ID_UF, ID_VIA, DS_LOCAL_VIA, DS_CIDADE_MAIS_PROXIMA, DS_PNV_ANO, DS_PNV_VERSAO, DS_PNV_CODIGO, DS_PNV_ALTITUDE, DS_LATITUDE_GRAU, DS_LATITUDE_MINUTO, DS_LONGITUDE_GRAU, DS_LONGITUDE_MINUTO) 
values (5, 5, 50.5, '00', '00', '00', '00', '00', '00', '00', '00', '00');

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

insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('01', '01', '01');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('02', '02', '02');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('03', '03', '03');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('04', '04', '04');
insert into IDENTIFICACAO_OBRA_INSPECAO (DS_PERIODO, DS_EQUIPAMENTO_NECESSARIO, DS_MELHOR_EPOCA) values ('05', '05', '05');

insert into CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS (ID_TIPO_REGIAO, ID_TIPO_TRACADO, DS_RAMPA_MAXIMA, DS_RAIO_CURVA, DS_VMD) values (1, 1, '00', '00', '00');

insert into CARACTERISTICAS_FUNCIONAIS_DIMENSOES (DS_NUMERO_FAIXAS, DS_LARGURA_FAIXA, DS_ACOSTAMENTO_DIREITO, DS_ACOSTAMENTO_ESQUERDO, DS_CALCADA_DIREITA, DS_CALCADA_ESQUERDA, DS_LARGURA_TOTAL_PISTA, DS_GABARITO_HORIZONTAL, DS_GABARITO_VERTICAL, DS_NUMERO_VAOS, DS_DESCRICAO_VAOS) 
values ('00', '00', '00', '00', '00', '00', '00', '00', '00', '00', '00');

insert into ROTAS_ALTERNATIVAS (DS_IDENTIFICACAO, DS_ROTA_ALTERNATIVA, DS_ACRESCIMO_KM) values ('00', '00', '00');

insert into SUBSTITUICAO (DS_IDENTIFICACAO, DS_EXISTE_PROJETO_SUBSTITUICAO, DS_CUSTO_ESTIMADO, DS_OBSERVACOES) values ('00', '00', '00', '00');

insert into OBSERVACOES (DS_IDENTIFICACAO, DS_OBSERVACOES) values ('00', '00');


insert into MODELO (DS_INDICE_BASE, DS_INDICE_PERFORMANCE) values ('indice base', 'indice performance');

insert into MANIFESTACOES_UFPR (ID_ELEMENTO_UFPR, CD_MANIFESTACOES_UFPR, DS_MANIFESTACOES_UFPR, DS_UNIDADE, DS_BETA) values (1,'00','00','00','00');

insert into EXTENSAO_RELATIVA (DS_EXTENSAO_RELATIVA) values ('extensao relativa');

insert into REPARO (DS_REPARO) values ('reparo');
insert into FOTO (DS_FOTO) values ('foto');

insert into NUMERO (DS_NUMERO) values ('numero');

insert into CADASTRO_MANIFESTACAO (ID_NUMERO, ID_MANIFESTACOES_UFPR, ID_FOTO, DS_TAMANHO, ID_EXTENSAO_RELATIVA, ID_REPARO) values (1, 1, 1, 'tamanho', 1, 1);


insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO, ID_CADASTRO_MANIFESTACAO) values (1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO, ID_CADASTRO_MANIFESTACAO) values (4, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO, ID_CADASTRO_MANIFESTACAO) values (2, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO, ID_CADASTRO_MANIFESTACAO) values (5, 4, 4, 4, 4, 1, 1, 1, 1, 1, 1);
insert into PONTE (DS_INDICE_PERFORMANCE_RELATIVO, ID_IDENTIFICACAO_OBRA_DADOS_BASICOS, ID_IDENTIFICACAO_OBRA_LOCALIZACAO, ID_IDENTIFICACAO_OBRA_RESPONSAVEIS, ID_IDENTIFICACAO_OBRA_INSPECAO, ID_CARACTERISTICAS_FUNCIONAIS_CARACTERISTICAS, ID_CARACTERISTICAS_FUNCIONAIS_DIMENSOES, ID_ROTAS_ALTERNATIVAS, ID_OBSERVACOES, ID_SUBSTITUICAO, ID_CADASTRO_MANIFESTACAO) values (3, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1);

insert into ELEMENTO_COMPONENTES (ID_PONTE, ID_ELEMENTO_UFPR, DS_DETALHE, NR_QUANTIDADE) values (1, 1, '00', '00');

insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 1);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 1);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 3);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 1);
insert into RANKING (ID_PONTE, ID_SIMULACAO) values (1, 2);

insert into INSPECAO (DT_DATA, ID_USUARIO, ID_PONTE, ID_MODELO) values ('06/07/2016', 1, 1, 1);

insert into INSPECOES_MANIFESTACOES (ID_INSPECAO, ID_ELEMENTO_UFPR, DS_NUMERO, ID_MANIFESTACOES_UFPR, DS_FOTO, DS_TAMANHO, ID_MANIFESTACOES_EXTENSAO, ID_MANIFESTACOES_URGENCIA) values (1, 1, '00', 1, '00', '00', 1, 1);


insert into IMAGEM values ('Imagem 01', 'image/jpeg', (select * from openrowset(bulk 'C:\Users\Usuario\Desktop\Pasta Compartilhada na Rede\03. Pastas pessoais\Daniele\Fotos\imagem1.jpg', single_blob) as A))
insert into IMAGEM values ('Imagem 02', 'image/jpeg', (select * from openrowset(bulk 'C:\Users\Usuario\Desktop\Pasta Compartilhada na Rede\03. Pastas pessoais\Daniele\Fotos\imagem2.jpg', single_blob) as A))
insert into IMAGEM values ('Imagem 03', 'image/jpeg', (select * from openrowset(bulk 'C:\Users\Usuario\Desktop\Pasta Compartilhada na Rede\03. Pastas pessoais\Daniele\Fotos\imagem3.jpg', single_blob) as A))

insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '01.jpg', 'Foto', '01', 'Vista geral', 'OAE', '10/05/2016', 1);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '02.jpg', 'Foto', '02', 'Pista rolamento', 'OAE', '11/05/2016', 2);
insert into ARQUIVO_ANEXO_CADASTRO (ID_PONTE, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '03.jpg', 'Foto', '03', 'Vista geral', 'OAE', '12/05/2016', 3);


insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '01.jpg', 'Foto', '01', 'Vista geral', 'INS', '13/05/2016', 2);
insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '02.jpg', 'Foto', '02', 'Pista rolamento', 'INS', '14/05/2016', 3);
insert into ARQUIVO_ANEXO_INSPECAO (ID_INSPECAO, DS_ARQUIVO, DS_TIPO_ARQUIVO, NR_NUMERO, DS_DESCRICAO, DS_REGISTRO, DT_DATA_ANEXACAO, ID_IMAGEM) values (1, '03.jpg', 'Foto', '03', 'Vista geral', 'INS', '15/05/2016', 1);

