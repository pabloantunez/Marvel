package ar.edu.unlam.pb2.Marvel;

public class Poder extends Gema implements Hechizable{

	public Poder() {

	}

	@Override
	public Integer hechizo(Integer poderInicial) {
		return poderInicial *2;
	}
	
	

}
