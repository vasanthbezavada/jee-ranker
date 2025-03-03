CREATE TABLE CUTOFF_RANK
(
    ID             INT PRIMARY KEY AUTO_INCREMENT,
    INSTITUTE      VARCHAR(225),
    PROGRAM        VARCHAR(225),
    QUOTA          VARCHAR(225),
    SEAT_TYPE      VARCHAR(225),
    GENDER         VARCHAR(225),
    OPENING_RANK   INT,
    CLOSING_RANK   INT,
    ACADEMIC_YEAR  INT,
    ROUND          INT,
    TYPE           VARCHAR(225),
    IS_PREPARATORY BOOLEAN
);

INSERT INTO CUTOFF_RANK(INSTITUTE, PROGRAM, QUOTA, SEAT_TYPE, GENDER, OPENING_RANK, CLOSING_RANK, ACADEMIC_YEAR, ROUND,
                        TYPE, IS_PREPARATORY)
SELECT *
FROM CSVREAD('src/main/resources/2024.csv');

INSERT INTO CUTOFF_RANK(INSTITUTE, PROGRAM, QUOTA, SEAT_TYPE, GENDER, OPENING_RANK, CLOSING_RANK, ACADEMIC_YEAR, ROUND,
                        TYPE, IS_PREPARATORY)
SELECT *
FROM CSVREAD('src/main/resources/2023.csv');

INSERT INTO CUTOFF_RANK(INSTITUTE, PROGRAM, QUOTA, SEAT_TYPE, GENDER, OPENING_RANK, CLOSING_RANK, ACADEMIC_YEAR, ROUND,
                        TYPE, IS_PREPARATORY)
SELECT *
FROM CSVREAD('src/main/resources/2022.csv');