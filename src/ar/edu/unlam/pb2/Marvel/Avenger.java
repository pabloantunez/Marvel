package ar.edu.unlam.pb2.Marvel;

public class Avenger {

	private String nombre;
	private Integer poderInicial;
	private Gema gema;

	public Avenger(String nombre, Integer poderInicial, Gema gema) {
		this.nombre = nombre;
		this.poderInicial = poderInicial;
		this.gema = gema;
	}

	public Avenger(String nombre, Integer poderInicial) {
		this.nombre = nombre;
		this.poderInicial = poderInicial;
	}

	public void aumentarPoder() throws NoAumentaPoderException, LaGemaNoAumentaPoderException {
		if (gema == null) {
			throw new NoAumentaPoderException("No puede aumentar poder por no tener gema.");
		}
		if (gema instanceof Alma || gema instanceof Espacio || gema instanceof Realidad) {
			throw new LaGemaNoAumentaPoderException("No se puede aumentar porder por no ser tipo de gema aumentable.");
		}
		if (gema instanceof Mente) {
			this.setPoderInicial(((Mente) gema).hechizo(poderInicial));
		} else if (gema instanceof Poder) {
			this.setPoderInicial(((Poder) gema).hechizo(poderInicial));
		} else if (gema instanceof Tiempo) {
			this.setPoderInicial(((Tiempo) gema).hechizo(poderInicial));
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPoderInicial() {
		return poderInicial;
	}

	public void setPoderInicial(Integer poderInicial) {
		this.poderInicial = poderInicial;
	}

	public Gema getGema() {
		return gema;
	}

	public void setGema(Gema gema) {
		this.gema = gema;
	}

}
