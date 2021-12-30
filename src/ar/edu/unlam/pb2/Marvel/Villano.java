package ar.edu.unlam.pb2.Marvel;

public class Villano extends Avenger implements Comparable<Villano> {

	public Villano(String nombre, Integer poderInicial) {
		super(nombre, poderInicial);
	}

	public Villano(String nombre, Integer poderInicial, Gema gema) {
		super(nombre, poderInicial, gema);
	}

	@Override
	public int compareTo(Villano otro) {
		return super.getNombre().compareTo(otro.getNombre());
	}

	@Override
	public String toString() {
		return super.getNombre();
	}

}
