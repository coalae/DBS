/* ANGABE:
Ziel der Java Implementierung ist es „schreibend“ auf die Datenbank zuzugreifen. D.h. schreiben Sie ein Programm, welches es ermöglicht 
Testdaten in Ihre Datenbank zu importieren (mittels INSERT-Statements). Ein einfaches Command-Line Benutzerinterface ist ausreichend.  
 
Die Datengenerierung muss zumindest folgende Hauptzielsetzungen erfüllen:  
•	Das Datenvolumen muss eine realistische Größenordnung aufweisen:
    1. d.h. es muss zumindest eine Relation mehrere hundert Tupel umfassen ("Fahrschulzentrum")
    2. und es müssen zumindest zwei andere Relationen mehrere tausend Tupel umfassen ("Fahrzeug", "Kunde")
      
•	Die Dateninhalte müssen (mit Ausnahme der rein beschreibenden Attribute) realistische Zusammenhänge aufweisen, d.h. Schlüssel- und
    Fremdschlüsseleinschränkungen müssen erfüllt sein, sodass insbesondere die notwendigen Verbunde zwischen den Tabellen entsprechend 
    realistische Ergebnisse produzieren. Der Inhalt aller anderen Attribute darf von Ihnen frei, aber dem Datentyp entsprechend, gewählt 
    werden.  

Anmerkung: Kontrollieren Sie, ob Ihre Java Implementierung auch erfolgreich war, indem Sie die Anzahl der Datensätze einer Tabelle 
mittels SELECT COUNT(*) FROM <table-name> erfragen.  
*/

package dbspr;

import java.sql.*;

import oracle.jdbc.driver.*;

public class TestDataGenerator1 {

  public static void main(String args[]) {

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      String database = "jdbc:oracle:thin:@oracle-lab.cs.univie.ac.at:1521:lab";
      String user = "a0750881";
      String pass = "coala";

      // Connection zur Datenbank erstellen: 
      Connection con = DriverManager.getConnection(database, user, pass);
      Statement stmt = con.createStatement();
  
// KUNDE (mehrere Tausend Tupel, 2000)     
      // SQL-INSERTS in Kunde Tabelle:       
      int kundennr=2000;
      int reisepassnr=10000;
      
      for(int i=0;i<2000;i++){  
    	  try {
    		String insertSql = "INSERT INTO kunde VALUES ("+ (kundennr++) +", "+ (reisepassnr++) +", '"+ Datenliste.getRandomKundenname() +"')";
	        stmt.executeUpdate(insertSql); 
    	  } 
    	  catch (Exception e) {
	        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
	      }
        }     
      
      // CHECK: SELECT COUNT INSERTS in  Kunde Tabelle:
      ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM kunde");
      if (rs1.next()) {
        int count = rs1.getInt(1);
        System.out.println("Anzahl der Kunden: " + count);
      }   
    
// FAHRSCHULZENTRUM (mehrere Hundert Tupel, 300)     
      // SQL-INSERTS in Fahrschulzentrum Tabelle:       
      int plzstart=1000;
      int fzidstart=3000;
      
      for(int i=0;i<300;i++){  
    	  try {
    		String insertSql = "INSERT INTO fahrschulzentrum VALUES ("+ (fzidstart++) +", '"+ Datenliste.getRandomFZName() +"', "+ (plzstart++) +", 'Oesterreich')";
	        stmt.executeUpdate(insertSql); 
    	  } 
    	  catch (Exception e) {
	        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
	      }
        }     
      
      // CHECK: SELECT COUNT INSERTS in  Fahrschulzentrum Tabelle:
      ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM fahrschulzentrum");
      if (rs2.next()) {
        int count = rs2.getInt(1);
        System.out.println("Anzahl der Fahrschulzentren: " + count);
      }   
      
 
 // FAHRZEUG (mehrere Tausend Tupel, 2000)
      // SQL-INSERTS in Fahrzeug Tabelle:       
      int autokennnr=6000;
      int fkundennr=2000;
      
      for(int i=0;i<2000;i++){  
    	  try {
    		String insertSql = "INSERT INTO fahrzeug VALUES ("+ (autokennnr++) +", '"+ Datenliste.getRandomAutotyp() +"', 'Uebungsauto', "+ (fkundennr++) +")";
	        stmt.executeUpdate(insertSql); 
    	  } 
    	  catch (Exception e) {
	        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
	      }
        }     
      
      // CHECK: SELECT COUNT INSERTS in Fahrzeug Tabelle:
      ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) FROM fahrzeug");
      if (rs3.next()) {
        int count = rs3.getInt(1);
        System.out.println("Anzahl der Fahrzeuge: " + count);
      }
      
      
      
      // Clean Up Connections
      rs1.close();
      rs2.close();
      rs3.close();
      stmt.close();
      con.close();

    } catch (Exception e) {
    	System.err.println(e.getMessage());
      }
    
  	}
}


