-- CREATE DATABASE tpdb;

DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS produto CASCADE;
DROP TABLE IF EXISTS fornecedor CASCADE;
DROP TABLE IF EXISTS categoria CASCADE;
DROP TABLE IF EXISTS cidade CASCADE;
DROP TABLE IF EXISTS estado CASCADE;
DROP TABLE IF EXISTS compra_venda CASCADE;

CREATE TABLE produto (
    id bigserial CONSTRAINT veiculo_pkey PRIMARY KEY,
    nome text,
    preco numeric,
    descricao text,
    categoria_id bigint,
    fornecedor_id bigint
);

CREATE TABLE categoria (
    id bigserial CONSTRAINT categoria_pkey PRIMARY KEY,
    nome text
);

CREATE TABLE fornecedor (
    id bigserial CONSTRAINT fornecedor_pkey PRIMARY KEY,
    nome text,
    razaoSocial text
);

CREATE TABLE usuario (
    id bigserial CONSTRAINT usuario_pkey PRIMARY KEY,
    nome text,
    email text,
    senha text,
    cpf text,
    datanasc date,
    endereco text,
    bairro text,
    cidade_id bigint,
    fone text,
    tipo character(3) -- {adm, cmm}
);

CREATE TABLE estado (
    id bigserial CONSTRAINT estado_pkey PRIMARY KEY,
    sigla varchar(2),
    nome text
);

CREATE TABLE cidade (
    id bigserial CONSTRAINT cidade_pkey PRIMARY KEY,
    nome text,
    estado_id bigint
);

ALTER TABLE cidade ADD CONSTRAINT fk_cidade_estado FOREIGN KEY (estado_id) 
      REFERENCES estado (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;


ALTER TABLE usuario ADD CONSTRAINT fk_usuario_cidade FOREIGN KEY (cidade_id) 
      REFERENCES cidade (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE produto ADD CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id) 
      REFERENCES categoria (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE produto ADD CONSTRAINT fk_produto_fornecedor FOREIGN KEY (fornecedor_id) 
      REFERENCES fornecedor (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE TABLE compra_venda (
    id bigserial CONSTRAINT veiculocliente_pkey PRIMARY KEY,
    usuario_id bigint,
    produto_id bigint,
    dataTrans date,
    tipo_trans character(1) -- {c, v}
);

ALTER TABLE compra_venda ADD CONSTRAINT fk_compra_venda_usuario FOREIGN KEY (usuario_id) 
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE compra_venda ADD CONSTRAINT fk_compra_venda_produto FOREIGN KEY (produto_id) 
      REFERENCES produto (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;
