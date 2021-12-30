package ar.edu.unlam.pb2.Marvel;

public class Mente extends Gema implements Hechizable {

	public Mente() {
		super();
	}

	@Override
	public Integer hechizo(Integer poderInicial) {
		return poderInicial *2;
	}

}
