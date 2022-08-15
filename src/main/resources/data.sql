INSERT INTO tb_user (name, email, password) VALUES ('Alex', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_pedido (uri, moment, status, feedback, correct_Count) VALUES ('Lanche', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 0, 'Muito bom', 2);
INSERT INTO tb_pedido (uri, moment, status, feedback, correct_Count) VALUES ('Prato', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 1, 'Excelente', 3);
INSERT INTO tb_pedido (uri, moment, status, feedback, correct_Count) VALUES ('Macarrão', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 2, 'Excelente', 1);
INSERT INTO tb_pedido (uri, moment, status, feedback, correct_Count) VALUES ('Frango Frito', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 3, 'Excelente', 2);


INSERT INTO tb_entrega (price, produto, descricao, pedido_id) VALUES (20.0, 'Lanche', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 1);
INSERT INTO tb_entrega (price, produto, descricao, pedido_id) VALUES (45.0, 'Prato', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 2);
INSERT INTO tb_entrega (price, produto, descricao, pedido_id) VALUES (50.0, 'Macarrão', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 3);
INSERT INTO tb_entrega (price, produto, descricao, pedido_id) VALUES (60.0, 'Frango Frito', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 4);