// ANGABE: restliche INSERT-statements fuer Fahrschule

package dbspr;

import java.sql.*;
import dbspr.DatenlisteRest;
import oracle.jdbc.driver.*;

public class TestDataGeneratorRest {

	  public static void main(String args[]) {

		    try {
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      String database = "jdbc:oracle:thin:@oracle-lab.cs.univie.ac.at:1521:lab";
		      String user = "a0750881";
		      String pass = "coala";

		      // Connection zur Datenbank erstellen: 
		      Connection con = DriverManager.getConnection(database, user, pass);
		      Statement stmt = con.createStatement();
		  
// GEBAEUDE      
		      // SQL-INSERTS in GEBAEUDE Tabelle:       
		      int gebaeudenr=10;
		      int gbfzidstart=3000;
		      
		      for(int i=0;i<20;i++){  
		    	  try {
		    		String insertSql = "INSERT INTO gebaeude VALUES ("+ (gebaeudenr++) +", '"+ DatenlisteRest.getRandomGebaeudename() +"', '"+ DatenlisteRest.getRandomGebAdresse() +"', "+ (gbfzidstart++) +")";
			        stmt.executeUpdate(insertSql); 
		    	  } 
		    	  catch (Exception e) {
			        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
			      }
		        }     
		      
		      // CHECK: SELECT COUNT INSERTS in  GEBAEUDE Tabelle:
		      ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM gebaeude");
		      if (rs1.next()) {
		        int count = rs1.getInt(1);
		        System.out.println("Anzahl der Gebaeude: " + count);
		      }   

// MITARBEITER      
		      // SQL-INSERTS in MITARBEITER Tabelle:       
		      int personalnr=1000;
		      int svnr=700000;
		      int mafzidstart=3000;
		      
		      for(int i=0;i<20;i++){  
		    	  try {
		    		String insertSql = "INSERT INTO mitarbeiter VALUES ("+ (personalnr++) +", '"+ DatenlisteRest.getRandomMitarbeitername() +"',"+ (svnr++) +", "+ DatenlisteRest.getRandomGehalt() +", "+ mafzidstart++ +")";
			        stmt.executeUpdate(insertSql); 
		    	  } 
		    	  catch (Exception e) {
			        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
			      }
		        }     
		      
		      // CHECK: SELECT COUNT INSERTS in  MITARBEITER Tabelle:
		      ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM mitarbeiter");
		      if (rs2.next()) {
		        int count = rs2.getInt(1);
		        System.out.println("Anzahl der Mitarbeiter: " + count);
		      }   
		      
		      
 // ADMINMA (MITARBEITER)      
		      // SQL-INSERTS in ADMINMA Tabelle:       
		      int adminpersonalnr=1000;
		      int adminid=21000;
		      
		      for(int i=0;i<10;i++){  
		    	  try {
		    		String insertSql = "INSERT INTO adminma VALUES ("+ (adminpersonalnr++) +", "+ (adminid++) +", '"+ DatenlisteRest.getRandomHierarchielevel() +"', '"+ DatenlisteRest.getRandomFunktion() +"')";
			        stmt.executeUpdate(insertSql); 
		    	  } 
		    	  catch (Exception e) {
			        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
			      }
		        }     
		      
		      // CHECK: SELECT COUNT INSERTS in  ADMINMA Tabelle:
		      ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) FROM adminma");
		      if (rs3.next()) {
		        int count = rs3.getInt(1);
		        System.out.println("Anzahl der AdminMA: " + count);
		      }   
 

 // FAHRLEHRERMA (MITARBEITER)      
		      // SQL-INSERTS in FAHRLEHRERMA Tabelle:       
		      int fahrlehrerpersonalnr=1010;
		      int fahrlehrerid=22000;
		      int zulassungsnr=50;
		      
		      for(int i=0;i<10;i++){  
		    	  try {
		    		String insertSql = "INSERT INTO fahrlehrerma VALUES ("+ (fahrlehrerpersonalnr++) +", "+ (fahrlehrerid++) +", "+ (zulassungsnr++) +", '"+ DatenlisteRest.getRandomSpezialisierung() +"')";
			        stmt.executeUpdate(insertSql); 
		    	  } 
		    	  catch (Exception e) {
			        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
			      }
		        }     
		      
		      // CHECK: SELECT COUNT INSERTS in  FAHRLEHRERMA Tabelle:
		      ResultSet rs4 = stmt.executeQuery("SELECT COUNT(*) FROM fahrlehrerma");
		      if (rs4.next()) {
		        int count = rs4.getInt(1);
		        System.out.println("Anzahl der FahrlehrerMA: " + count);
		      }   

		      
// ARBEITSZIMMER (abhaengig von GEBAEUDE)      
		      // SQL-INSERTS in ARBEITSZIMMER Tabelle:       
		      int arbeitsznr=100;
		      int azgebaeudenr=10;
		      int azpersonalnr=1000;
		      
		      for(int i=0;i<10;i++){  
		    	  try {
		    		String insertSql = "INSERT INTO arbeitszimmer VALUES ("+ (arbeitsznr++) +", '"+ DatenlisteRest.getRandomArbeitszimmername() +"', '"+ DatenlisteRest.getRandomEinrichtung() +"', "+ (azgebaeudenr++) +", "+ (azpersonalnr++) +")";
			        stmt.executeUpdate(insertSql); 
		    	  } 
		    	  catch (Exception e) {
			        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
			      }
		        }     
		      
		      // CHECK: SELECT COUNT INSERTS in  ARBEITSZIMMER Tabelle:
		      ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) FROM arbeitszimmer");
		      if (rs5.next()) {
		        int count = rs5.getInt(1);
		        System.out.println("Anzahl der Arbeitszimmer: " + count);
		      }   

		      
// FAHRKURS       
		      // SQL-INSERTS in FAHRKURS Tabelle:       
		      int fkkundennr=2000;
		      
		      for(int i=0;i<10;i++){   // auto_increment fuer kursnr, daher nur daten fuer restliche Spalten eingegeben
		    	  try {
		    		String insertSql = "INSERT INTO fahrkurs (tagesdatum, beginnzeit, endzeit, kundennr) VALUES ('"+ DatenlisteRest.getRandomTagesdatum() +"', '"+ DatenlisteRest.getRandomBeginnzeit() +"', '"+ DatenlisteRest.getRandomEndzeit() +"', "+ (fkkundennr++) +")";
			        stmt.executeUpdate(insertSql); 
		    	  } 
		    	  catch (Exception e) {
			        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
			      }
		        }     
		      
		      // CHECK: SELECT COUNT INSERTS in  FAHRKURS Tabelle:
		      ResultSet rs6 = stmt.executeQuery("SELECT COUNT(*) FROM fahrkurs");
		      if (rs6.next()) {
		        int count = rs6.getInt(1);
		        System.out.println("Anzahl der Fahrkurse: " + count);
		      }   


// BEKANNTSCHAFT (zwischen KUNDE)       
		      // SQL-INSERTS in BEKANNTSCHAFT Tabelle:       
		      int bekundennr1=2000;
		      int bekundennr2=2100;
		      
		      for(int i=0;i<10;i++){   
		    	  try {
		    		String insertSql = "INSERT INTO bekanntschaft VALUES ("+ (bekundennr1++) +", "+ (bekundennr2++) +")";
			        stmt.executeUpdate(insertSql); 
		    	  } 
		    	  catch (Exception e) {
			        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
			      }
		        }     
		      
		      // CHECK: SELECT COUNT INSERTS in BEKANNTSCHAFT Tabelle:
		      ResultSet rs7 = stmt.executeQuery("SELECT COUNT(*) FROM bekanntschaft");
		      if (rs7.next()) {
		        int count = rs7.getInt(1);
		        System.out.println("Anzahl der Bekanntschaften: " + count);
		      }   

		      
// KOORDINATION        
		      // SQL-INSERTS in KOORDINATION Tabelle:       
		      int kopersonalnr1=1010;
		      int kofahrlehrerid=22000;
		      int kopersonalnr2=1000;
		      int koadminid=21000;
		      int kokursnr=1;  // siehe auto_increment SQL
		      int koordid=900;
		      int geheimreferenz=111;
		      
		      for(int i=0;i<10;i++){   
		    	  try {
		    		String insertSql = "INSERT INTO koordination VALUES ("+ (kopersonalnr1++) +", "+ (kofahrlehrerid++) +", "+ (kopersonalnr2++) +", "+ (koadminid++) +", "+ (kokursnr++) +", "+ (koordid++) +", "+ (geheimreferenz++) +")";
			        stmt.executeUpdate(insertSql); 
		    	  } 
		    	  catch (Exception e) {
			        System.err.println("Fehler beim Einfuegen des Datensatzes: " + e.getMessage());
			      }
		        }     
		      
		      // CHECK: SELECT COUNT INSERTS in KOORDINATION Tabelle:
		      ResultSet rs8 = stmt.executeQuery("SELECT COUNT(*) FROM koordination");
		      if (rs8.next()) {
		        int count = rs8.getInt(1);
		        System.out.println("Anzahl der Koordinationen: " + count);
		      }   
		      
		      
		      
		    		      
		      
		      // Clean Up Connections
		      rs1.close();
		      rs2.close();
		      rs3.close();
		      rs4.close();
		      rs5.close();
		      rs6.close();
		      rs7.close();
		      rs8.close();
		      stmt.close();
		      con.close();

		    } catch (Exception e) {
		    	System.err.println(e.getMessage());
		      }
		    
		  	}

	
}
