
INSERT INTO User (userID,name, city) VALUES (1, 'Bob', 'Toronto');
INSERT INTO User (userID,name, city) VALUES (2, 'Jack', 'Vancouver');
INSERT INTO User (userID,name, city) VALUES (3, 'Joe', 'Dallas');

INSERT INTO Invoice (invoiceID, semester, amount, memo, userID) VALUES (1, 'H2020', 2000.20, 'Bon utilisateur', 1); 

INSERT INTO Invoice (invoiceID, semester, amount, memo, userID) VALUES (2, 'A2021', 4000.20, 'Bon utilisateur 22', 1); 

INSERT INTO Invoice (invoiceID, semester, amount, memo, userID) VALUES (3, 'A2019', 700.70, 'À vérifier', 2); 

COMMIT;
