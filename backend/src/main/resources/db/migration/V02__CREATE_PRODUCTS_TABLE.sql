CREATE TABLE tb_products
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(255)   NOT NULL,
    description VARCHAR(255),
    image_url   VARCHAR(255),
    price       DECIMAL(10, 2) NOT NULL,
    available   BOOLEAN          DEFAULT FALSE,
    category_id SERIAL         NOT NULL,


    FOREIGN KEY (category_id) REFERENCES tb_categories (id)
);

INSERT INTO tb_products (name, description, image_url, price, available, category_id)
VALUES ('Pizza', 'Pizza', 'https://picsum.photos/200/300', 10.00, TRUE, 4);

INSERT INTO tb_products (name, description, image_url, price, available, category_id)
VALUES ('Burger', 'Burger', 'https://picsum.photos/200/300', 10.00, TRUE, 2);

INSERT INTO tb_products (name, description, image_url, price, available, category_id)
VALUES ('Hot Dog', 'Hot Dog', 'https://picsum.photos/200/300', 10.00, TRUE, 2);

INSERT INTO tb_products (name, description, image_url, price, available, category_id)
VALUES ('Sandwich', 'Sandwich', 'https://picsum.photos/200/300', 10.00, TRUE, 2);

INSERT INTO tb_products (name, description, image_url, price, available, category_id)
VALUES ('Teste', 'Teste', 'https://picsum.photos/200/300', 16.00, TRUE, 2);

INSERT INTO tb_products (name, description, image_url, price, available, category_id)
VALUES ('Sobremesa', 'Sobremesa', 'https://picsum.photos/200/300', 6.00, TRUE, 3);

INSERT INTO tb_products (name, description, image_url, price, available, category_id)
VALUES ('Refrigerante', 'Refrigerante', 'https://picsum.photos/200/300', 6.00, TRUE, 1);


INSERT INTO tb_products (name, description, image_url, price, available, category_id)
VALUES ('Cerveja', 'Cerveja', 'https://picsum.photos/200/300', 6.00, TRUE, 1);