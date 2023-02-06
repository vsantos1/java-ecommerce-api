CREATE TABLE tb_users_permissions
(
    user_id       BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, permission_id),
    FOREIGN KEY (user_id) REFERENCES tb_users (id),
    FOREIGN KEY (permission_id) REFERENCES tb_permissions (id)
);