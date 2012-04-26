import java.util.Random;


public class Fahrer {
	
	Random r = new Random();	
	private int zahlen;
	private boolean ausgestiegen;
	
	public Fahrer() {
		this.zahlen = r.nextInt(30) + 21;
		this.ausgestiegen = false;
	}
	
	public int getZahlen() {
		return zahlen;
	}
	public void zahlen() {
		this.zahlen--;
		if (this.zahlen == 0) this.ausgestiegen=false;
	}
	
	public boolean isAusgestiegen() {
		return ausgestiegen;
	}
	public void setAusgestiegen(boolean ausgestiegen) {
		this.ausgestiegen = ausgestiegen;
	}
	
}
