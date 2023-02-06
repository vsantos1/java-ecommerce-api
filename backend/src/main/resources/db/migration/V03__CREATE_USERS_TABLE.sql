CREATE TABLE tb_users
(
    id                      SERIAL NOT NULL PRIMARY KEY,
    email                   varchar(255) DEFAULT NULL,
    first_name              varchar(255) DEFAULT NULL,
    last_name               varchar(255) DEFAULT NULL,
    password                varchar(255) DEFAULT NULL,
    account_non_expired     BOOLEAN      DEFAULT TRUE,
    account_non_locked      BOOLEAN      DEFAULT TRUE,
    credentials_non_expired BOOLEAN      DEFAULT TRUE,
    enabled                 BOOLEAN      DEFAULT TRUE,
    UNIQUE (email)
);