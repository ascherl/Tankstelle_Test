import java.util.Random;

/**
 * 
 * @author rudi
 * 
 */
public class Auto {
	Random r = new Random();
	private int tanken;
	private int zahlen;
	private boolean ausgestiegen;
	private int raeumen;
	private int warten;
	
	public Auto() {
		tanken = r.nextInt(100) + 201;
		zahlen = r.nextInt(30) + 21;
		ausgestiegen = false;
		raeumen = r.nextInt(40) + 31;
		warten = 0;
	}
	
	public int getTanken() {
		return tanken;
	}
	public void Tanken(int tanken) {
		this.tanken--;
	}
	
	public int getZahlen() {
		return zahlen;
	}
	public void Zahlen() {
		this.zahlen--;
	}
	
	public int getRaeumen() {
		return raeumen;
	}
	public void Raeumen() {
		this.raeumen--;
	}

	public int getWarten() {
		return warten;
	}
	public void Warten() {
		this.warten++;
	}
	
	public boolean isAusgestiegen() {
		return ausgestiegen;
	}
	public void setAusgestiegen(boolean ausgestiegen) {
		this.ausgestiegen = ausgestiegen;
	}
	
}
