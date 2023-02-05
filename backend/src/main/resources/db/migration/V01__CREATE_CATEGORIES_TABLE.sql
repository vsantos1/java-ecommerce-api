CREATE TABLE tb_categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO tb_categories (name)
VALUES ('Bebidas');
INSERT INTO tb_categories (name)
VALUES ('Lanches');
INSERT INTO tb_categories (name)
VALUES ('Sobremesas');
INSERT INTO tb_categories (name)
VALUES ('Salgados');
