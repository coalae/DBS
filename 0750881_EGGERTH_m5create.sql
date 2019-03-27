-- meilenstein3 physischer entwurf der datenbank

-- create statements 

CREATE TABLE fahrschulzentrum (
  fzid      INTEGER,
  fzname    VARCHAR(100),
  plz       INTEGER,
  land       VARCHAR(100) DEFAULT 'Oesterreich',
  CONSTRAINT pk_fzid PRIMARY KEY(fzid) 
);

CREATE TABLE gebaeude (
  gebaeudenr  INTEGER, 
  gbname      VARCHAR(100),
  adresse     VARCHAR(100),
  fzid        INTEGER,
  CONSTRAINT pk_gebaeudenr PRIMARY KEY(gebaeudenr),
  CONSTRAINT fk_ge_fzid FOREIGN KEY(fzid) REFERENCES fahrschulzentrum (fzid)
);

CREATE TABLE mitarbeiter (
  personalnr  INTEGER, 
  maname      VARCHAR(100),
  svnr        INTEGER,
  gehalt      INTEGER,
  fzid        INTEGER,
  CONSTRAINT pk_personalnr PRIMARY KEY(personalnr),
  CONSTRAINT fk_ma_fzid FOREIGN KEY(fzid) REFERENCES fahrschulzentrum (fzid)
);

CREATE TABLE adminma (
  personalnr      INTEGER,
  adminid         INTEGER,
  hierarchielevel VARCHAR(100),
  funktion        VARCHAR(100),
  CONSTRAINT fk_ad_personalnr FOREIGN KEY (personalnr) REFERENCES mitarbeiter (personalnr),
  CONSTRAINT pk_admin PRIMARY KEY(personalnr, adminid)
);

CREATE TABLE fahrlehrerma (
  personalnr      INTEGER,
  fahrlehrerid    INTEGER,
  zulassungsnr    INTEGER,
  spezialisierung VARCHAR(100),
  CONSTRAINT fk_fl_personalnr FOREIGN KEY (personalnr) REFERENCES mitarbeiter (personalnr),
  CONSTRAINT pk_fahrlehrer PRIMARY KEY(personalnr, fahrlehrerid)
);

CREATE TABLE arbeitszimmer (
  arbeitsznr      INTEGER,
  azname          VARCHAR(100),
  einrichtung     VARCHAR(100),
  gebaeudenr      INTEGER,
  personalnr      INTEGER,
  CONSTRAINT fk_az_gebaeudenr FOREIGN KEY(gebaeudenr) REFERENCES gebaeude (gebaeudenr),
  CONSTRAINT fk_ma_personalnr FOREIGN KEY(personalnr) REFERENCES mitarbeiter (personalnr),
  CONSTRAINT pk_arbeitszimmer PRIMARY KEY(arbeitsznr, gebaeudenr)
);

CREATE TABLE kunde (
  kundennr      INTEGER,
  reisepassnr   INTEGER, 
  kname         VARCHAR(100),
  CONSTRAINT pk_kunde PRIMARY KEY(kundennr)
);

CREATE TABLE fahrkurs (
  kursnr        INTEGER CHECK(kursnr>0),
  tagesdatum    VARCHAR(10),                 
  beginnzeit    VARCHAR(5),
  endzeit       VARCHAR(5),
  kundennr      INTEGER,
  CONSTRAINT fk_kundennr FOREIGN KEY(kundennr) REFERENCES kunde (kundennr),
  CONSTRAINT pk_fahrkurs PRIMARY KEY(kursnr)
);

CREATE TABLE bekanntschaft (
  kundennr1   INTEGER,
  kundennr2   INTEGER,
  CONSTRAINT fk_kundennr1 FOREIGN KEY(kundennr1) REFERENCES kunde (kundennr) ON DELETE CASCADE, 
  CONSTRAINT fk_kundennr2 FOREIGN KEY(kundennr2) REFERENCES kunde (kundennr) ON DELETE CASCADE,
  CONSTRAINT pk_bekanntschaft PRIMARY KEY(kundennr1, kundennr2)
);

CREATE TABLE koordination (
    personalnr1   INTEGER,
    fahrlehrerid  INTEGER,
    personalnr2   INTEGER,
    adminid       INTEGER,
    kursnr        INTEGER,
    koordid       INTEGER NOT NULL,           -- vereinfachend wird hier als PK die "koordid" (i.e. koordinationsID) eingefuehrt; NOT NULL constraint
    geheimreferenz INTEGER UNIQUE,            -- UNIQUE constraint (= geheimreferenz, wenn in der oeffentlichkeit ueber koordinationen gesprochen wird       
    CONSTRAINT pk_koordination PRIMARY KEY(koordid),
    CONSTRAINT fk_ko_fahrl FOREIGN KEY(personalnr1, fahrlehrerid) REFERENCES fahrlehrerma (personalnr, fahrlehrerid),
    CONSTRAINT fk_ko_admin FOREIGN KEY(personalnr2, adminid) REFERENCES adminma (personalnr, adminid),
    CONSTRAINT fk_kursnr FOREIGN KEY(kursnr) REFERENCES fahrkurs (kursnr)
);

CREATE TABLE fahrzeug (
  autokennnr    INTEGER,
  autotyp       VARCHAR(100),
  innenausstattung VARCHAR(100),
  kundennr      INTEGER,
  CONSTRAINT pk_autokennnr PRIMARY KEY (autokennnr),
  CONSTRAINT fk_fzgkundennr FOREIGN KEY(kundennr) REFERENCES kunde (kundennr)
);

DESCR fahrschulzentrum;
DESCR gebaeude;
DESCR mitarbeiter;
DESCR adminma;
DESCR fahrlehrerma;
DESCR arbeitszimmer;
DESCR kunde;
DESCR fahrkurs;
DESCR bekanntschaft;
DESCR koordination;
DESCR fahrzeug;



-- anzeige statements (ausfuehren, wenn notwendig)
SELECT table_name FROM user_tables; 

-- SEQUENCE (fuer auto-increment des PK kursnr in der tabelle fahrkurs)
CREATE SEQUENCE autoincrement_kursnr
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  NOCACHE;
  
-- TRIGGER (fuer auto-increment des PK kursnr in der tabelle fahrkurs)
CREATE OR REPLACE TRIGGER trigger_kursnr
  BEFORE INSERT ON fahrkurs FOR EACH ROW
  BEGIN
    SELECT autoincrement_kursnr.NEXTVAL
      INTO :NEW.kursnr
    FROM DUAL;
  END;

-- VIEW1 (Aggregatsfunktion COUNT; GROUP BY):  VIEW1 zaehlt, an wievielen fahrkursen kunden teilnehmen und zeigt dies gruppiert nach dem kundenname
CREATE VIEW v1_kursteilnehmer AS
SELECT kname, COUNT(kursnr) AS "kursanzahl"
FROM kunde JOIN fahrkurs ON kunde.kundennr = fahrkurs.kundennr 
GROUP BY kname; 

-- VIEW2 (NATURAL JOIN): VIEW2 verbindet fahrschulzentrum und gebaeude und zeigt die spalten fzname, plz, ort, gebaeudenr und gbname gemeinsam an
CREATE VIEW v2_fzgeb AS
SELECT fzname, plz, land, gebaeudenr, gbname 
FROM  fahrschulzentrum NATURAL JOIN gebaeude
WHERE plz=1001;

-- VIEW3 (Aggregatsfunktion COUNT; GROUP BY ... HAVING): VIEW3 zeigt kursteilnehmer, die an ueber 2 fahrkursen teilnehmen (gruppiert nach dem kundenname)
CREATE VIEW v3_ueber2kurse AS
SELECT kname, COUNT(kursnr) AS "kursanzahl_ueber2"
FROM kunde JOIN fahrkurs ON kunde.kundennr = fahrkurs.kundennr 
GROUP BY kname
HAVING COUNT(kursnr)>2;

-- CHECKS FUER INSERTS "TestDataGenerator1"
-- CHECKS JAVA KUNDE:
SELECT * FROM kunde;

-- CHECK JAVA FAHRZENTRUM:
SELECT * FROM fahrschulzentrum;

-- CHECK JAVA FAHRZEUG:
SELECT * FROM fahrzeug;


-- CHECKS FUER INSERTS "TestDataGenerator2"
-- CHECK JAVA GEBAEUDE:
SELECT * FROM gebaeude;

-- CHECK JAVA MITARBEITER:
SELECT * FROM mitarbeiter;

        -- CHECK JAVA ADMINMA (MITARBEITER):
        SELECT * FROM adminma;
     
         -- CHECK JAVA FAHRLEHRERMA (MITARBEITER):
        SELECT * FROM fahrlehrerma;
    
 -- CHECK JAVA ARBEITSZIMMER (abh. von GEBAEUDE):
SELECT * FROM arbeitszimmer;

  -- CHECK JAVA FAHRKURS (auto_increment):
SELECT * FROM fahrkurs;

 -- CHECK JAVA BEKANNTSCHAFT (zw. KUNDE):
SELECT * FROM bekanntschaft;

-- CHECK JAVA KOORDINATION:
SELECT * FROM koordination;


-- STORED PROCEDURE ANLEGEN:
create or replace PROCEDURE personalnr_arbeitsznr(persnr IN NUMBER, aznr OUT NUMBER) IS
BEGIN
     Select a.arbeitsznr INTO aznr from mitarbeiter p, arbeitszimmer a
     where p.personalnr=persnr AND a.personalnr=persnr;
END;


 