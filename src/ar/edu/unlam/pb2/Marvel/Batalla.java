package ar.edu.unlam.pb2.Marvel;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Batalla {

	private Set<Villano> villanos;
	private Set<Heroe> heroes;

	public Batalla() {
		this.villanos = new TreeSet<Villano>();
		this.heroes = new TreeSet<Heroe>();

	}

	public Avenger pelea(Avenger heroe, Avenger villano) throws PoderesEmpateException {
		Avenger ganador = null;
		if (heroe.getPoderInicial().equals(villano.getPoderInicial())) {
			throw new PoderesEmpateException("Ambos poseen los mismos poderes iniciales");
		}
		if (heroe.getPoderInicial() > villano.getPoderInicial()) {
			heroes.add((Heroe) heroe);
			return ganador = heroe;
		} else {
			villanos.add((Villano) villano);
			return ganador = villano;
		}
	}

	public TreeSet<Villano> villanosOrdenados(Comparator criterio) throws CollectionNullException {
		if (villanos.size() == 0) {
			throw new CollectionNullException("La colección de villanos esta vacía");
		}

		TreeSet<Villano> villanosOrdenados = new TreeSet<Villano>(criterio);
		villanosOrdenados.addAll(villanos);
		return villanosOrdenados;
	}

	public TreeSet<Heroe> getHeroesOrdenados() throws CollectionNullException {
		if (heroes.size() == 0) {
			throw new CollectionNullException("La colección de heroes esta vacía");
		}
		return (TreeSet<Heroe>) this.heroes;
	}

	public Boolean seSalvaElMundo() throws WorldDestroyedException {

		if (heroes.size() < villanos.size()) {
			throw new WorldDestroyedException("Los villanos dominaron el mundo.");
		}
		return (this.heroes.size() > this.villanos.size());
	}

}
