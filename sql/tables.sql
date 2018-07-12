USE PROGETTON;

DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS PAYMENTS;
DROP TABLE IF EXISTS AIRPORTS;
DROP TABLE IF EXISTS AIRPLANES;
DROP TABLE IF EXISTS FLIGHTS;
DROP TABLE IF EXISTS TICKETS;

CREATE TABLE USERS (
		USERNAME VARCHAR(20) NOT NULL,
		PASSWORD VARCHAR(20) NOT NULL,
		NAME VARCHAR(20) NOT NULL,
		SURNAME VARCHAR(20) NOT NULL,
		BIRTHDATE DATE NOT NULL,
		NATION VARCHAR(50) NOT NULL,
		EMAIL VARCHAR(50) NOT NULL,
		PRIMARY KEY(USERNAME)
);

CREATE TABLE PAYMENTS (
		ID VARCHAR(16) NOT NULL,
		METHOD VARCHAR(10) NOT NULL,
		OWNER VARCHAR(20) NOT NULL,
		FOREIGN KEY (OWNER) REFERENCES USERS(USERNAME),
		PRIMARY KEY(ID)
		);

CREATE TABLE AIRPORTS (
		IATA VARCHAR(3) NOT NULL,
		NAME VARCHAR(100) NOT NULL,
		CITY VARCHAR(50) NOT NULL,
		NATION VARCHAR(50) NOT NULL,
		PRIMARY KEY(IATA)
);

CREATE TABLE AIRPLANES (
		ID VARCHAR(5) NOT NULL,
		ECONOMY INT,
		BUSINESS INT,
		PRIMARY KEY(ID)
);

CREATE TABLE FLIGHTS (
		ID VARCHAR(9) NOT NULL,
		DEPARTURE VARCHAR(3) NOT NULL,
		ARRIVE VARCHAR(3) NOT NULL,
		DATED DATETIME NOT NULL,
		DATEA DATETIME NOT NULL,
		AIRPLANE VARCHAR(5) NOT NULL,
		FOREIGN KEY (DEPARTURE) REFERENCES IATA(AIRPORTS),
		FOREIGN KEY (ARRIVE) REFERENCES IATA(AIRPORTS),
		FOREIGN KEY (AIRPLANE) REFERENCES ID(AIRPLANES),
		PRIMARY KEY(ID)
);

CREATE TABLE TICKETS(
		ID VARCHAR(12) NOT NULL,
		OWNER VARCHAR(20) NOT NULL,
		FLIGHT VARCHAR(9) NOT NULL,
		BAGAGGE VARCHAR(6) NOT NULL,
		SEAT VARCHAR(3) NOT NULL,
		CHECKED TINYINT(1) NOT NULL,
		FOREIGN KEY (OWNER) REFERENCES USERNAME(USERS),
		FOREIGN KEY (FLIGHT) REFERENCES ID(FLIGHTS),
		PRIMARY KEY(ID)
);

INSERT INTO USERS (USERNAME, PASSWORD, NAME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('alessandrabianchi', 'passworda', 'Alessandra', 'Bianchi', '1999-06-06', 'Italy', 'alessandrabianchi@prova.it');
INSERT INTO USERS (USERNAME, PASSWORD, NAME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('brunorossi', 'passwordb', 'Bruno', 'Rossi', '1981-02-01', 'Italy', 'brunorossi@prova.it');
INSERT INTO USERS (USERNAME, PASSWORD, NAME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('claudiaverdi', 'passwordc', 'Claudia', 'Verdi', '1990-05-24', 'Italy', 'claudiaverdi@esempio.it');
INSERT INTO USERS (USERNAME, PASSWORD, NAME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('damianorossi', 'passwordd', 'Damiano', 'Rossi', '1975-07-10', 'Italy', 'damianorossi@esempio.it');
INSERT INTO USERS (USERNAME, PASSWORD, NAME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('enricoverdi', 'passworde', 'Enrico', 'Verdi', '1985-12-13', 'Italy', 'enricoverdi@italia.it');
INSERT INTO USERS (USERNAME, PASSWORD, NAME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('francescabianchi', 'passwordf', 'Francesca', 'Bianchi', '1992-11-18', 'Italy', 'francescabianchi@italia.it');
INSERT INTO USERS (USERNAME, PASSWORD, NAME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('giorgiorossi', 'passwordg', 'Giorgio', 'Rossi', '1971-01-08', 'Italy', 'giorgiorossi@ciaomondo.it');
INSERT INTO USERS (USERNAME, PASSWORD, NAME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('lucarossi', 'passwordl', 'Luca', 'Rossi', '1993-04-07', 'Italy', 'lucarossi@ciaomondo.it');
