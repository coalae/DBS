-- DROP und DELETE statements

-- STORED PROCEDURE loeschen
DROP PROCEDURE personalnr_arbeitsznr;

-- EINTRAEGE loeschen
DELETE FROM koordination WHERE koordid>=900;
DELETE FROM bekanntschaft WHERE kundennr1 >=2000;
DELETE FROM fahrkurs WHERE kursnr>0;
DELETE FROM arbeitszimmer WHERE arbeitsznr>=100;

        DELETE FROM fahrlehrerma WHERE personalnr>=1010;
        DELETE FROM adminma WHERE personalnr>=1000;
DELETE FROM mitarbeiter WHERE personalnr>=1000;

DELETE FROM gebaeude WHERE gebaeudenr>0;
DELETE FROM fahrzeug WHERE autokennnr>0;
DELETE FROM fahrschulzentrum WHERE land='Oesterreich';
DELETE FROM kunde WHERE kundennr>1999;

-- DROP VIEWS, TRIGGER, SEQUENCE - view, auto_increment-komponenten loeschen
DROP VIEW v3_ueber2kurse;
DROP VIEW v2_fzgeb;
DROP VIEW v1_kursteilnehmer;
DROP TRIGGER trigger_kursnr;
DROP SEQUENCE autoincrement_kursnr;

-- DROP TABLES - tabellen loeschen
DROP TABLE fahrzeug;
DROP TABLE koordination;
DROP TABLE bekanntschaft;
DROP TABLE fahrkurs;
DROP TABLE kunde;
DROP TABLE arbeitszimmer;
  DROP TABLE fahrlehrerma;
  DROP TABLE adminma;
DROP TABLE mitarbeiter;
DROP TABLE gebaeude;
DROP TABLE fahrschulzentrum;





