package dbspr;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class DatenlisteRest {

	
	
	private final static List<String> gebaeudenamenliste = Arrays.asList(
			"Geb. Sonne", "Geb. Mond", "Geb. Sterne", "Geb. Erde", "Geb. Mars", "Geb. Venus", "Geb. Merkur", 
			"Geb. Saturn", "Geb. Uranus", "Geb. Pluto", "Geb. Sternschnuppe", "Geb. Neptun", "Geb. Jupiter"
			);

	private final static List<String> gebadressenliste = Arrays.asList(
			"Sonnenstr. 1", "Mondstr. 10", "Erdenstr. 50", "Venusstr. 100", "Merkurstr. 1", "Saturnstr. 2",
			"Uranusstr. 3", "Plutostr. 4", "Sternschnuppenstr. 20", "Neptunstr. 30", "Jupiterstr. 10"
			);
	
	private final static List<String> mitarbeiternamenliste = Arrays.asList(
			"Dominik Aaber", "Dominik Baber", "Dominik Caber", "Dominik Daber", "Dominik Eaber", "Dominik Faber", "Dominik Gaber", 
			"Philipp Haber", "Philipp Iaber", "Philipp Jaber", "Philipp Kaber", "Philipp Laber", "Philipp Maber", "Philipp Naber", 
			"Markus Oaber", "Markus Paber", "Markus Qaber", "Markus Raber", "Markus Saber", "Markus Taber", "Markus Uaber",
			"Marlene Aerger", "Marlene Berger", "Marlene Cerger", "Marlene Derger", "Marlene Eerger", "Marlene Ferger", 
			"Marina Gerger", "Marina Herger", "Marina Ierger", "Marina Jerger", "Marina Kerger", "Marina Lerger", 
			"Sabine Merger", "Sabine Nerger", "Sabine Oerger", "Sabine Perger", "Sabine Qerger", "Sabine Rerger"
			);
	
	private final static List<String> gehaltliste = Arrays.asList(
			"1000", "1500", "2000", "2500", "3000", "3500", "4000"
			);

	private final static List<String> hierarchielevelliste = Arrays.asList(
			"trainee", "manager", "spezialist"
			);
	
	private final static List<String> funktionsliste = Arrays.asList(
			"sachbearbeiter", "schulungskoordinator", "berater", "generalist"
			);

	private final static List<String> spezialisierungsliste = Arrays.asList(
			"Winter", "Autobahn", "Anhaenger", "Kleinbus", "Sommer", "Anfaenger", "Perfektion"			
			);
	
	private final static List<String> arbeitszimmernamenliste = Arrays.asList(
			"Donau", "Mur", "Drau", "Inn", "Thaya", "Rhein", "Seine", "Rhone", "Loire"			
			);

	private final static List<String> einrichtungsliste = Arrays.asList(
			"Basics", "Medium", "Luxury", "Flexibel"			
			);

	private final static List<String> tagesdatumliste = Arrays.asList(
			"01.05.2016", "02.05.2016", "03.05.2016", "04.05.2016", "05.05.2016", "06.05.2016", "07.05.2016", "08.05.2016",
			"09.05.2016", "10.05.2016", "11.05.2016", "12.05.2016", "13.05.2016", "14.05.2016", "15.05.2016", "16.05.2016",
			"17.05.2016", "18.05.2016", "19.05.2016", "20.05.2016", "21.05.2016", "22.05.2016", "23.05.2016", "24.05.2016",
			"25.05.2016", "26.05.2016", "27.05.2016", "28.05.2016", "29.05.2016", "30.05.2016", "31.05.2016"
			);
	
	private final static List<String> beginnzeitliste = Arrays.asList(
			"08.00", "09.00", "10.00", "11.00", "12.00", "13.00"
			);

	private final static List<String> endzeitliste = Arrays.asList(
			"15.00", "16.00", "17.00"
			);

	
	public static String getRandomGebaeudename(){
		return doRandom(gebaeudenamenliste);
	}

	public static String getRandomGebAdresse(){
		return doRandom(gebadressenliste);
	}
	
	public static String getRandomMitarbeitername(){
		return doRandom(mitarbeiternamenliste);
	}

	public static String getRandomGehalt(){
		return doRandom(gehaltliste);
	}
	
	public static String getRandomHierarchielevel(){
		return doRandom(hierarchielevelliste);
	}

	public static String getRandomFunktion(){
		return doRandom(funktionsliste);
	}

	public static String getRandomSpezialisierung(){
		return doRandom(spezialisierungsliste);
	}
	
	public static String getRandomArbeitszimmername(){
		return doRandom(arbeitszimmernamenliste);
	}

	public static String getRandomEinrichtung(){
		return doRandom(einrichtungsliste);
	}

	public static String getRandomTagesdatum(){
		return doRandom(tagesdatumliste);
	}

	public static String getRandomBeginnzeit(){
		return doRandom(beginnzeitliste);
	}

	public static String getRandomEndzeit(){
		return doRandom(endzeitliste);
	}
	
	
	
	private static Random rand = new Random(System.currentTimeMillis());
    
    private static String doRandom(List<String> temp) {
        int index =-1;
        index= rand.nextInt(temp.size());
        return temp.get(index);
    }
	
}
