package ar.edu.unlam.pb2.Marvel;

import java.util.Comparator;

public class OrdenadosPorPoderInicial implements Comparator <Villano>{

	@Override
	public int compare(Villano uno, Villano dos) {
		return (dos.getPoderInicial().compareTo(uno.getPoderInicial()));
	}

	
}
