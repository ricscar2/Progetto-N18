USE PROGETTON;

INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('alessandrabianchi', 'passworda', 'Alessandra', 'Bianchi', '1999-06-06', 'Italy', 'alessandrabianchi@prova.it');
INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('brunorossi', 'passwordb', 'Bruno', 'Rossi', '1981-02-01', 'Italy', 'brunorossi@prova.it');
INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('claudiaverdi', 'passwordc', 'Claudia', 'Verdi', '1990-05-24', 'Italy', 'claudiaverdi@esempio.it');
INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('damianorossi', 'passwordd', 'Damiano', 'Rossi', '1975-07-10', 'Italy', 'damianorossi@esempio.it');
INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('enricoverdi', 'passworde', 'Enrico', 'Verdi', '1985-12-13', 'Italy', 'enricoverdi@italia.it');
INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('francescabianchi', 'passwordf', 'Francesca', 'Bianchi', '1992-11-18', 'Italy', 'francescabianchi@italia.it');
INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('giorgiorossi', 'passwordg', 'Giorgio', 'Rossi', '1971-01-08', 'Italy', 'giorgiorossi@ciaomondo.it');
INSERT INTO USERS (USERNAME, PWD, NOME, SURNAME, BIRTHDATE, NATION, EMAIL) 
		VALUES ('lucarossi', 'passwordl', 'Luca', 'Rossi', '1993-04-07', 'Italy', 'lucarossi@ciaomondo.it');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('BGY', 'Orio al Serio International', 'Bergamo', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('LIN', 'Aeroporto di Milano - Linate', 'Milano', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('MXP', 'Aeroporto di Milano - Malpensa', 'Milano', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('VCE', 'Aeroporto di Venezia Tessera - Marco Polo', 'Venezia', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('AOI', 'Aeroporto di Ancona Falconara - Raffaele Sanzio', 'Ancona', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('BRI', 'Aeroporto di Bari - Palese', 'Bari', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('GOA', 'Aeroporto di Genova - Cristoforo Colombo', 'Genova', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('TRN', 'Aeroporto di Torino - Caselle - Sandro Pertini', 'Torino', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('FCO','Aeroporto di Roma Fiumicino - Leonardo Da Vinci', 'Roma', 'Italy');
INSERT INTO AIRPORTS (IATA, NOME, CITY, NATION)
		VALUES ('CAG','Aeroporto di Cagliari Elmas - Mario Mameli', 'Cagliari', 'Italy');
INSERT INTO AIRPLANES (ID, ECONOMY, BUSINESS)
		VALUES ('PN001', 60, 39);
INSERT INTO AIRPLANES (ID, ECONOMY, BUSINESS)
		VALUES ('PN002', 60, 39);
INSERT INTO AIRPLANES (ID, ECONOMY, BUSINESS)
		VALUES ('PN003', 60, 39);
INSERT INTO AIRPLANES (ID, ECONOMY, BUSINESS)
		VALUES ('PN004', 60, 39);
INSERT INTO AIRPLANES (ID, ECONOMY, BUSINESS)
		VALUES ('PN005', 80, 19);
INSERT INTO AIRPLANES (ID, ECONOMY, BUSINESS)
		VALUES ('PN006', 60, 39);
INSERT INTO AIRPLANES (ID, ECONOMY, BUSINESS)
		VALUES ('PN007', 60, 39);
INSERT INTO AIRPLANES (ID, ECONOMY, BUSINESS)
		VALUES ('PN008', 20, 79);
INSERT INTO FLIGHTS (ID, DEPARTURE, ARRIVE, DATED, DATEA, AIRPLANE)
		VALUES ('MXPFCO001', 'MXP', 'FCO', '09:34:00', '10:50:00', 'PN001');
INSERT INTO FLIGHTS (ID, DEPARTURE, ARRIVE, DATED, DATEA, AIRPLANE)
		VALUES ('BRITRN001', 'BRI', 'TRN', '05:17:00', '06:55:00', 'PN002');
INSERT INTO FLIGHTS (ID, DEPARTURE, ARRIVE, DATED, DATEA, AIRPLANE)
		VALUES ('AOIVCE001', 'AOI', 'VCE', '15:00:00', '15:50:00', 'PN003');
INSERT INTO FLIGHTS (ID,DEPARTURE, ARRIVE, DATED, DATEA, AIRPLANE)
		VALUES('BGYCAG001', 'BGY', 'CAG', '12:04:00', '13:28:00', 'PN004');

        

        
