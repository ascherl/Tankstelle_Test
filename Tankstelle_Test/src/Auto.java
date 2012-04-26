import java.util.Random;

/**
 * 
 * @author rudi
 * 
 */
public class Auto {
	Random r = new Random();
	private int nummer;
	private int tanken;
	private int raeumen;
	public Fahrer fahrer = new Fahrer();
	private int warten; // Kšnnte nutzlos werden, wenn jedes Auto eine Nummer (= Eintreffzeit) bekommt.
	
	public Auto(int ankunft) {
		this.nummer = ankunft;
		this.tanken = r.nextInt(100) + 201;
		this.raeumen = r.nextInt(40) + 31;
		this.warten = 0;
		Fahrer fahrer;
	}
	
	public int getNummer() {
		return nummer;
	}
	
	public int getTanken() {
		return tanken;
	}
	public void tanken() {
		this.tanken--;
		if (this.tanken == 0) {
			this.fahrer.setAusgestiegen(true);
		}
	}
	
	public int getRaeumen() {
		return raeumen;
	}
	public void raeumen() {
		this.raeumen--;
	}

	public int getWarten() {
		return warten;
	}
	public void warten() {
		this.warten++;
	}
	
}
