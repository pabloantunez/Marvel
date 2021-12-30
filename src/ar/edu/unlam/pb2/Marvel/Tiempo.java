package ar.edu.unlam.pb2.Marvel;

public class Tiempo extends Gema implements Hechizable {

	public Tiempo() {

	}

	@Override
	public Integer hechizo(Integer poderInicial) {
		return poderInicial *2;
		
	}

}
