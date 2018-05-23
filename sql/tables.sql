
USE PROGETTON;

DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS AIRPORTS;

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

CREATE TABLE AIRPORTS (
		IATA VARCHAR(3) NOT NULL,
		NAME VARCHAR(100) NOT NULL,
		CITY VARCHAR(50) NOT NULL,
		NATION VARCHAR(50) NOT NULL,
		PRIMARY KEY(IATA)
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
