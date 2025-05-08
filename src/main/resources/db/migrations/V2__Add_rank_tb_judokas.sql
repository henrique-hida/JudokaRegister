-- V": Migrations para adicionar a coluna de rank na tabela de judokas

ALTER TABLE tb_judokas
ADD COLUMN rank VARCHAR(255);