package ar.edu.unlam.pb2.Marvel;

public class Heroe extends Avenger implements Comparable<Heroe> {

	public Heroe(String nombre, Integer poderInicial) {
		super(nombre, poderInicial);
	}

	public Heroe(String nombre, Integer poderInicial, Gema gema) {
		super(nombre, poderInicial, gema);
	}

	@Override
	public int compareTo(Heroe otro) {
		return super.getPoderInicial().compareTo(otro.getPoderInicial());
	}

}
