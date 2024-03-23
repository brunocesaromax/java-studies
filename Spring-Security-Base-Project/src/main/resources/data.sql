insert into permission (id, name) values
(1, 'ROLE_LIST_USERS'),
(2, 'ROLE_LIST_PRODUCTS'),
(3, 'ROLE_LIST_COLORS')
;

insert into user (id, name, username, password, active) values
(1, 'Bruno', 'bruno', '$2a$10$lmxdjBeHen/GUKF86n35TeE/HVA7IAUr44NxTFP38oIcJY9crAk4y', true),
(2, 'Davi', 'davi', '$2a$10$lmxdjBeHen/GUKF86n35TeE/HVA7IAUr44NxTFP38oIcJY9crAk4y', true)
;

insert into user_permission (user_id, permission_id) values
(1, 1)
, (1, 2)
, (1, 3)
, (2, 1)
, (2, 2)
;