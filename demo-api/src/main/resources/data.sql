
INSERT INTO User (userID,name, city) VALUES (1, 'Bob', 'Toronto');
INSERT INTO User (userID,name, city) VALUES (2, 'Jack', 'Vancouver');
INSERT INTO User (userID,name, city) VALUES (3, 'Joe', 'Dallas');

INSERT INTO Invoice (invoiceID, semester, amount, memo, userID) VALUES (1, 'H2020', 2000.20, 'Bon utilisateur', 1); 

INSERT INTO Invoice (invoiceID, semester, amount, memo, userID) VALUES (2, 'A2021', 4000.20, 'Bon utilisateur 22', 1); 

INSERT INTO Invoice (invoiceID, semester, amount, memo, userID) VALUES (3, 'A2019', 700.70, 'À vérifier', 2); 

COMMIT;

INSERT INTO LoginUser (username, password)
VALUES ('user','$2a$10$xGexodzb.iPw6//7HMB07e4flzUblfJVdqW07lvXyF.G/NjHuomZW');

INSERT INTO LoginUser (username, password)
VALUES ('admin','$2a$10$4fByw7s7IGLi2SSP4tkZKuLhLVfEWLas7pkGkyrK8c6HeYpK/Pbui');

INSERT INTO Role(username, role)
VALUES ('user','USER');

INSERT INTO Role(username, role)
VALUES ('admin','ADMIN');

INSERT INTO Role(username, role)
VALUES ('admin','USER');



COMMIT;

