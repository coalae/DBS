package dbspr;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class Datenliste {
	
	private final static List<String> kundennamenliste = Arrays.asList(
		"Martin Auber", "Martin Buber", "Martin Cuber", "Martin Duber", "Martin Euber", "Martin Fuber", "Martin Guber", 
		"Martin Huber", "Martin Iuber", "Martin Juber", "Martin Kuber", "Martin Luber", "Martin Muber", "Martin Nuber", 
		"Martin Ouber", "Martin Puber", "Martin Quber", "Martin Ruber", "Martin Suber", "Martin Tuber", "Martin Uuber", 			
		"Martin Vuber", "Martin Wuber", "Martin Xuber", "Martin Yuber", "Martin Zuber",
		"Kathrin Auber", "Kathrin Buber", "Kathrin Cuber", "Kathrin Duber", "Kathrin Euber", "Kathrin Fuber", "Kathrin Guber", 
		"Kathrin Huber", "Kathrin Iuber", "Kathrin Juber", "Kathrin Kuber", "Kathrin Luber", "Kathrin Muber", "Kathrin Nuber", 			
		"Kathrin Ouber", "Kathrin Puber", "Kathrin Quber", "Kathrin Ruber", "Kathrin Suber", "Kathrin Tuber", "Kathrin Uuber", 
		"Kathrin Vuber", "Kathrin Wuber", "Kathrin Xuber", "Kathrin Yuber", "Kathrin Zuber",
	    "Maria Auster", "Maria Buster", "Maria Custer", "Maria Duster", "Maria Euster", "Maria Fuster", "Maria Guster", 	
	    "Maria Huster", "Maria Iuster", "Maria Juster", "Maria Kuster", "Maria Luster", "Maria Muster", "Maria Nuster", 
		"Maria Ouster", "Maria Puster", "Maria Quster", "Maria Ruster", "Maria Suster", "Maria Tuster", "Maria Uuster", 
		"Maria Vuster", "Maria Wuster", "Maria Xuster", "Maria Yuster", "Maria Zuster",
		"Michael Auster", "Michael Buster", "Michael Custer", "Michael Duster", "Michael Euster", "Michael Fuster", "Michael Guster", 
		"Michael Huster", "Michael Iuster", "Michael Juster", "Michael Kuster", "Michael Luster", "Michael Muster", "Michael Nuster", 
		"Michael Ouster", "Michael Puster", "Michael Quster", "Michael Ruster", "Michael Suster", "Michael Tuster", "Michael Uuster", 
		"Michael Vuster", "Michael Wuster", "Michael Xuster", "Michael Yuster", "Michael Zuster");
	
	private final static List<String> fznamenliste = Arrays.asList(
		"FS Aurach", "FS Burach", "FS Curach", "FS Durach", "FS Eurach", "FS Furach", "FS Gurach", "FS Hurach", "FS Iurach", "FS Jurach",
		"FS Kurach", "FS Lurach", "FS Murach", "FS Nurach", "FS Ourach", "FS Purach", "FS Qurach", "FS Rurach", "FS Surach", "FS Turach",
		
		"FS Aeberg", "FS Beberg", "FS Ceberg", "FS Deberg", "FS Eeberg", "FS Feberg", "FS Geberg", "FS Heberg", "FS Ieberg", "FS Jeberg",
		"FS Keberg", "FS Leberg", "FS Meberg", "FS Neberg", "FS Oeberg", "FS Peberg", "FS Qeberg", "FS Reberg", "FS Seberg", "FS Teberg",
		
		"FS Aauern", "FS Bauern", "FS Cauern", "FS Dauern", "FS Eauern", "FS Fauern", "FS Gauern", "FS Hauern", "FS Iauern", "FS Jauern", 
		"FS Kauern", "FS Lauern", "FS Mauern", "FS Nauern", "FS Oauern", "FS Pauern", "FS Qauern", "FS Rauern", "FS Sauern", "FS Tauern", 
		
		"FS Wien01", "FS Wien02", "FS Wien03", "FS Wien04", "FS Wien05", "FS Wien06", "FS Wien07", "FS Wien08", "FS Wien09", "FS Wien10",
		"FS Wien11", "FS Wien12", "FS Wien13", "FS Wien14", "FS Wien15", "FS Wien16", "FS Wien17", "FS Wien18", "FS Wien19", "FS Wien20",
		
		"FS Graz01", "FS Graz02", "FS Graz03", "FS Graz04", "FS Graz05", "FS Graz06", "FS Graz07", "FS Graz08", "FS Graz09", "FS Graz10", 
		"FS Graz11", "FS Graz12", "FS Graz13", "FS Graz14", "FS Graz15", "FS Graz16", "FS Graz17", "FS Graz18", "FS Graz19", "FS Graz20",
		
		"FS Linz01", "FS Linz02", "FS Linz03", "FS Linz04", "FS Linz05", "FS Linz06", "FS Linz07", "FS Linz08", "FS Linz09", "FS Linz10", 
		"FS Linz11", "FS Linz12", "FS Linz13", "FS Linz14", "FS Linz15", "FS Linz16", "FS Linz17", "FS Linz18", "FS Linz19", "FS Linz20", 
		
		"FS Wels01", "FS Wels02", "FS Wels03", "FS Wels04", "FS Wels05", "FS Wels06", "FS Wels07", "FS Wels08", "FS Wels09", "FS Wels10", 
		"FS Wels11", "FS Wels12", "FS Wels13", "FS Wels14", "FS Wels15", "FS Wels16", "FS Wels17", "FS Wels18", "FS Wels19", "FS Wels20");
	
	private final static List<String> autotypenliste = Arrays.asList(
			"PKW normal", "Gelaendewagen", "Limousine", "PKW mit Anhaenger", "Kleinbus", "Cabrio");

	public static String getRandomKundenname(){
			return doRandom(kundennamenliste);
	}

	public static String getRandomFZName(){
		return doRandom(fznamenliste);
	}
	
	public static String getRandomAutotyp(){
		return doRandom(autotypenliste);
	}
	  
	private static Random rand = new Random(System.currentTimeMillis());
    
    private static String doRandom(List<String> temp) {
        int index =-1;
        index= rand.nextInt(temp.size());
        return temp.get(index);
    }
	

}
