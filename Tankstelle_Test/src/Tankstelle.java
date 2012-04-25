import java.util.Random;


public class Tankstelle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 3 Tankschlangen und 1 Kassenschlange erzeugen

		Autobahn autobahn = new Autobahn();
		for( int i = 0; i < 3600; i++ ){
			if ( autobahn.rdmAuto() == true ){
				// Auto in kŸrzester Schlange erzeugen
				Auto a = new Auto();
				System.out.print(i + " ");
				System.out.print(a.getTanken() + " ");
				a.Warten();
				System.out.println(a.getWarten());
			}
 		}
		

	
	}

}
