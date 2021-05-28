DROP TABLE AA_DISTANCE;
DROP TABLE AA_TMARSHRUT;
DROP TABLE AA_MARSHRUT;
DROP Table AA_TIMETABLE;
DROP TABLE AA_WAITINGS;
DROP TABLE AA_TRAIN_EMPLOYEE;a
DROP TABLE AA_TRAINS;
DROP TABLE AA_EMPLOYEE;
DROP TABLE AA_STATION;


CREATE TABLE AA_STATION (
                            ID_S  SERIAL PRIMARY KEY NOT NULL,
                            NAME CHAR(2000) NOT NULL
);

CREATE TABLE AA_EMPLOYEE (
                             ID SERIAL PRIMARY KEY NOT NULL,
                             FIO CHAR(2000) NOT NULL,
                             PLACE CHAR(512) NOT NULL,
                             STATION_ID INTEGER NOT NULL,
                             CONSTRAINT FK_AA_EMPL_ST FOREIGN KEY (STATION_ID) REFERENCES AA_STATION (ID_S)
);

CREATE TABLE AA_TRAINS (
                           NUM INTEGER PRIMARY KEY NOT NULL,
                           CATEGORY INTEGER NOT NULL,
                           QUANTITY INTEGER NOT NULL,
                           STATION_ID INTEGER NOT NULL,
                           M_NUM INTEGER NOT NULL,
                           CONSTRAINT FK_AA_TR_ST FOREIGN KEY (STATION_ID) REFERENCES AA_STATION (ID_S)
);

CREATE TABLE AA_TRAIN_EMPLOYEE (
                                   NUM INTEGER NOT NULL,
                                   ID SERIAL NOT NULL,
                                   CONSTRAINT PK_TRE_TRE PRIMARY KEY(NUM, ID),
                                   CONSTRAINT FK_AA_TREMP_TR FOREIGN KEY (NUM) REFERENCES AA_TRAINS (NUM),
                                   CONSTRAINT FK_TE_EMP FOREIGN KEY (ID) REFERENCES AA_EMPLOYEE(ID)
);

CREATE TABLE AA_WAITINGS (
                             ID SERIAL PRIMARY KEY NOT NULL,
                             CATEGORY INTEGER NOT NULL,
                             DT DATE NOT NULL,
                             NAPR INTEGER NOT NULL,
                             VALUE INTEGER NOT NULL,
                             CONSTRAINT FK_AA_WAIT_TR FOREIGN KEY (ID) REFERENCES AA_TRAINS (NUM)
);

CREATE TABLE AA_TIMETABLE (
                              ID SERIAL NOT NULL,
                              T_NUM INTEGER NOT NULL,
                              STATION_ID INTEGER NOT NULL,
                              DT1 DATE NOT NULL,
                              DT2 DATE NOT NULL,
                              NAPR INTEGER NOT NULL,
                              TICKETS INTEGER NOT NULL,
                              CONSTRAINT FK_AA_TIME_TIME PRIMARY KEY (ID, T_NUM, STATION_ID),
                              CONSTRAINT FK_AA_TIME_TR FOREIGN KEY (ID) REFERENCES AA_TRAINS (NUM),
                              CONSTRAINT FK_AA_TIME_ST FOREIGN KEY (T_NUM) REFERENCES  AA_STATION(ID_S)
);

CREATE TABLE AA_MARSHRUT(
                            M_NUM INTEGER NOT NULL,
                            STATION_ID INTEGER NOT NULL,
                            ORDER1 INTEGER NOT NULL,
                            CONSTRAINT PK_AA_MAR PRIMARY KEY(M_NUM, STATION_ID),
                            CONSTRAINT FK_AA_MARSH_ST FOREIGN KEY(STATION_ID) REFERENCES AA_STATION(ID_S)
);

CREATE TABLE AA_TMARSHRUT(
                             M_NUM INTEGER NOT NULL,
                             STATION_ID INTEGER NOT NULL,
                             ORDER1 INTEGER NOT NULL,
                             PM_NUM INTEGER NOT NULL,
                             CONSTRAINT PK_AA_TMARSH PRIMARY KEY(M_NUM, STATION_ID, PM_NUM),
                             CONSTRAINT FK_AA_TMARSH_ST FOREIGN KEY(PM_NUM, STATION_ID) REFERENCES AA_MARSHRUT(M_NUM, STATION_ID)
);

CREATE TABLE AA_DISTANCE(
                            ID SERIAL PRIMARY KEY NOT NULL,
                            ID_ST1 INTEGER NOT NULL,
                            ID_ST2 INTEGER NOT NULL,
                            VALUE INTEGER NOT NULL,
                            CONSTRAINT FK_AA_DIST_ST1 FOREIGN KEY(ID_ST1) REFERENCES AA_STATION(ID_S),
                            CONSTRAINT FK_AA_DIST_ST2 FOREIGN KEY(ID_ST2) REFERENCES AA_STATION(ID_S)
);


CREATE TABLE AA_USERS(
    NAME CHAR(2000) NOT NULL PRIMARY KEY,
    PASSWORD CHAR(200) NOT NULL
)