DROP TABLE User IF EXISTS;
DROP TABLE Invoice IF EXISTS;


CREATE TABLE User (
    userID int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    city varchar(255),
    gender varchar(10),
    country varchar(100),
    aboutYou varchar(500),
    mailingList boolean,
    PRIMARY KEY (userID)
);

CREATE TABLE Invoice(
	invoiceID int NOT NULL AUTO_INCREMENT,
	semester varchar(10),
	amount float,
	memo varchar(255),
	userID int NOT NULL,
	PRIMARY KEY (invoiceID),
	FOREIGN KEY (userID) REFERENCES User(userID)
);

CREATE TABLE LoginUser(
	username varchar(50) NOT NULL PRIMARY KEY,
	password varchar (200) NOT NULL
);

CREATE Table Role(
	username varchar(50) NOT NULL,
	role varchar(50) NOT NULL,
	FOREIGN KEY (username) REFERENCES LoginUser(username)
);

CREATE UNIQUE INDEX ix_role_username on Role(username,role);