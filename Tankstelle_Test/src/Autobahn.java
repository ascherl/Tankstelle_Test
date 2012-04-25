import java.util.Random;


public class Autobahn {

	public Autobahn(){
	}

	/**
	 * Ergebnis aus 1000 Simulationen: 14.99 Autos pro Stunde
	 * Min.: 2.00, 1st Qu.: 12, Median: 15.00, Mean: 14.99, 3rd Qu.: 18.00, Max.: 28.00
	 * @return boolean
	 */
	public boolean rdmAuto() {
		Random r = new Random();
		int rdm = r.nextInt(240);
		if(rdm == 239) {
			return true;
		}
		else return false;
	}

}
	
