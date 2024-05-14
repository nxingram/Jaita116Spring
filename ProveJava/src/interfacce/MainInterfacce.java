package interfacce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainInterfacce {

	public static void main(String[] args) {
		//tipoVar nomeVar = instanzio il piccione - creo l'oggetto    
		Piccione p = new Piccione();		
		Aereo a = new Aereo();
		
		Volare v = new Piccione();
		Volare v2 = new Aereo();
		
		List<Volare> i = Arrays.asList(p, a);
		List<Volare> i2 = new ArrayList<Volare>();
		i2.add(p);

		//tipoVariabile nomeVariabile = istanza
		Automobile auto1 = new Automobile();
		Guidare auto = new Automobile();
		Volare auto2 = new Automobile();
		
	
		
		Guidare barca = new Barca();
		
	}
}
