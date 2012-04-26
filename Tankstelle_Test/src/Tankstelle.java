import java.util.Iterator;
import java.util.LinkedList;

/**
 * Erzeugt eine Tankstelle mit einer Anzahl von Zapfsäulen (ANZAHL_ZAPFSAEULEN) und gibt ein Protokoll aus.
 * @author rudi
 *
 */
public class Tankstelle {
	private static final int ANZAHL_ZAPFSAEULEN = 3;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Liste mit Zapfsauelen. 
		LinkedList<Auto>[] Zapfsaeulen = (LinkedList<Auto>[]) new LinkedList[ANZAHL_ZAPFSAEULEN]; // DAS IST JA WOHL MAL DER GROESSTE DUMMFICK!
		for (int i = 0; i < ANZAHL_ZAPFSAEULEN; i++) {
			Zapfsaeulen[i] = new LinkedList<Auto>();
		}
		// ... und eine Kasse – REICHT!
		LinkedList<Auto> Kasse = new LinkedList<Auto>();
		
		// Array der einzelnen Wartezeiten
		LinkedList<Auto> wartezeiten = new LinkedList<Auto>();
		
		Autobahn autobahn = new Autobahn();
		for( int i = 0; i < 3600; i++ ){
			// Random Auto zu kuerzester Schlange
			if( autobahn.rdmAuto() == true ){
				Auto auto = new Auto(i);
				
				//kuerzeste Zapfsaeulenschlange finden
				int minimaleLaenge = 0;
				LinkedList<Auto> kuerzesteSchlange = Zapfsaeulen[0];
				
				for(int j = 0; j < ANZAHL_ZAPFSAEULEN; j++){
					if(Zapfsaeulen[j].size() < minimaleLaenge) {
						kuerzesteSchlange = Zapfsaeulen[j];
					} else {
						minimaleLaenge = Zapfsaeulen[j].size();
					}
				}
				kuerzesteSchlange.addLast(auto);
			}
			// Tanken
			for( int j = 0; j < ANZAHL_ZAPFSAEULEN; j++) {
				if( Zapfsaeulen[j].size()>0 ) {
					// Aktionen erstes Auto
					Auto erstesAuto = Zapfsaeulen[j].getFirst();
					// Erstes Auto tanken
					if( erstesAuto.getTanken() > 1 ) {
						erstesAuto.tanken();
					}
					// Ersten Autofahrer, wenn fertig zum zahlen schicken.
					if( erstesAuto.getTanken() == 1 ) {
						erstesAuto.tanken();
						Kasse.addLast(erstesAuto);
					}

					// Erste Auto raeumen
					if( erstesAuto.getTanken()==0 && erstesAuto.fahrer.getZahlen() == 0 ) {
						erstesAuto.raeumen();
					}
					// Erstes Auto wegfahren
					if( erstesAuto.getRaeumen()==0 ) {
						// DEBUG System.out.println( "Auto " + erstesAuto.getNummer() +" verlaesst Zapfsaeule " + j + " um " + i );

						
						// Auto in wartezeit<Auto> festhalten
						wartezeiten.addLast(erstesAuto);
						
						// Und tschüß!
						Zapfsaeulen[j].removeFirst();

					}	
				}
				
				//Alle andern warten()
				if( Zapfsaeulen[j].size()>1 ) {
					// TODO CHECK Iterator
					Iterator<Auto> iterator = Zapfsaeulen[j].iterator();
					while (iterator.hasNext()) iterator.next().warten();
				}
			}
			
			// Zahlen an der Kasse
			if( Kasse.size()>0 ) {
				if (Kasse.getFirst().fahrer.getZahlen()==1) {
					Kasse.getFirst().fahrer.zahlen();
					Kasse.removeFirst();
				}
				else Kasse.getFirst().fahrer.zahlen();
				//Alle anderen warten()
				if( Kasse.size()>1 ) {
					//TODO CHECK ITERATOR
					Iterator<Auto> iterator = Kasse.iterator();
					while (iterator.hasNext()) iterator.next().warten();
				}
			}
			
			// Protokoll
			if(i%300==0){
				if(i==0) {
					System.out.print("Zeit");
					for(int j = 0; j < ANZAHL_ZAPFSAEULEN; j++) {
						System.out.print("\t\t"+j);
					}
					System.out.print("\t\tKasse\n\n");
				}
				System.out.print( i/60 + "\t\t");
				for(int j = 0; j < ANZAHL_ZAPFSAEULEN; j++) {
					System.out.print(Zapfsaeulen[j].size() + "\t\t");
				}
				System.out.print(Kasse.size());
				System.out.print("\n");
			}

		}
		
		
		// Statistik
		System.out.print("\n");
		int wartezeit = 0;
		int maximaleWartezeit = 0;
		for (int i = 0; i < wartezeiten.size(); i++) {
			wartezeit += wartezeiten.get(i).getWarten();
			if(wartezeiten.get(i).getWarten() > maximaleWartezeit) maximaleWartezeit = wartezeiten.get(i).getWarten();
		}
		// längste Wartezeit
		
		double durchschnittlicheWartezeit = (double) wartezeit / (double) wartezeiten.size();
		System.out.println("durchschnittliche Wartezeit \t" + durchschnittlicheWartezeit + " s");
		System.out.println("maximale Wartezeit \t\t" + maximaleWartezeit + " s");
	}
}
