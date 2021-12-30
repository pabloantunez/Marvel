package ar.edu.unlam.pb2.Marvel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.Test;

public class BatallaTest {

	@Test
	public void sePudoCrearLaBatalla() {
		Batalla batalla = new Batalla();
		assertNotNull(batalla);
	}

	@Test
	public void elHeroeResultaVencedorEnLaBatalla() throws PoderesEmpateException {
		Batalla batalla = new Batalla();
		Gema poder = new Poder();
		Avenger thor = new Heroe("Thor", 100, poder);
		Avenger loki = new Villano("Loki", 99);
		assertEquals(thor, batalla.pelea(thor, loki));
	}

	@Test(expected = PoderesEmpateException.class)
	public void elResultadoDeLaBatallaEsUnEmpate() throws PoderesEmpateException {
		Batalla batalla = new Batalla();
		Gema poder = new Poder();
		Avenger thor = new Heroe("Thor", 111, poder);
		Avenger loki = new Villano("Loki", 111);
		batalla.pelea(thor, loki);
	}

	@Test
	public void elVillanoAumentaElPoderYGanaLaBatalla()
			throws PoderesEmpateException, NoAumentaPoderException, LaGemaNoAumentaPoderException {
		Batalla batalla = new Batalla();
		Gema poder = new Poder();
		Avenger thor = new Heroe("Thor", 100);
		Avenger loki = new Villano("Loki", 100, poder);
		loki.aumentarPoder();
		assertEquals(loki, batalla.pelea(thor, loki));
	}

	@Test(expected = NoAumentaPoderException.class)
	public void noSePudoAumentarElPoderSinGema() throws NoAumentaPoderException, LaGemaNoAumentaPoderException {
		Batalla batalla = new Batalla();
		Avenger thor = new Heroe("Thor", 100);
		Avenger loki = new Villano("Loki", 100);
		loki.aumentarPoder();
	}

	@Test(expected = LaGemaNoAumentaPoderException.class)
	public void noSePudoAumentarElPoderPorSerGemaSinAumento()
			throws NoAumentaPoderException, LaGemaNoAumentaPoderException {
		Batalla batalla = new Batalla();
		Gema realidad = new Realidad();
		Avenger thor = new Heroe("Thor", 100);
		Avenger loki = new Villano("Loki", 100, realidad);
		loki.aumentarPoder();
	}

	@Test
	public void ordenarListaDeVillanosDescendente() throws PoderesEmpateException, NoAumentaPoderException,
			LaGemaNoAumentaPoderException, CollectionNullException {
		Batalla batalla = new Batalla();
		Gema mente = new Mente();
		Gema tiempo = new Tiempo();
		Gema realidad = new Realidad();
		Gema alma = new Alma();
		Gema espacio = new Espacio();
		Gema poder = new Poder();

		Avenger thor = new Heroe("Thor", 456, mente);
		Avenger capitanAmerica = new Heroe("Capitan America", 456);
		Avenger hulk = new Heroe("Hulk", 542, realidad);
		Avenger blackWidow = new Heroe("Black Widow", 8976);
		Avenger ironMan = new Heroe("Iron Man", 789, espacio);

		Avenger loki = new Villano("Loki", 789);
		Avenger ronnan = new Villano("Ronnan", 786, tiempo); // 1572
		Avenger redSkull = new Villano("Red Skull", 756, alma);
		Avenger soldadoDeInvierno = new Villano("Soldado De Invierno", 2875);
		Avenger hela = new Villano("Hela", 7865, poder); // 15730

		thor.aumentarPoder();
		ronnan.aumentarPoder();
		hela.aumentarPoder();

		batalla.pelea(thor, loki);
		batalla.pelea(capitanAmerica, ronnan);
		batalla.pelea(hulk, redSkull);
		batalla.pelea(blackWidow, soldadoDeInvierno);
		batalla.pelea(ironMan, hela);

		TreeSet<Villano> villanosOrdenados = batalla.villanosOrdenados(new OrdenadosPorPoderInicial());

		assertEquals(villanosOrdenados.first().equals(hela), villanosOrdenados.last().equals(redSkull));

		// PREGUNTA QUIEN GANO MAS PELEAS Y ORDENO EL ARRAY POR GANADORES ACORDE AL
		// CRITERIO. (TREESET)
		// EXCEPCIONES: QUE LA CANTIDAD DE PELEAS SEA IMPAR PERO QUE HAYA UN POSIBLE
		// EMPATE EN ALGUNA (YA ESTA ANALIZADO ARRIBA).
	}

	@Test
	public void ordenarListaDeHeroesAscendente() throws NoAumentaPoderException, LaGemaNoAumentaPoderException,
			PoderesEmpateException, CollectionNullException {
		Batalla batalla = new Batalla();
		Gema mente = new Mente();
		Gema tiempo = new Tiempo();
		Gema realidad = new Realidad();
		Gema alma = new Alma();
		Gema espacio = new Espacio();
		Gema poder = new Poder();

		Avenger thor = new Heroe("Thor", 456, mente);
		Avenger capitanAmerica = new Heroe("Capitan America", 456);
		Avenger hulk = new Heroe("Hulk", 542, realidad);
		Avenger blackWidow = new Heroe("Black Widow", 8976);
		Avenger ironMan = new Heroe("Iron Man", 789, espacio);

		Avenger loki = new Villano("Loki", 789);
		Avenger ronnan = new Villano("Ronnan", 786, tiempo); // 1572
		Avenger redSkull = new Villano("Red Skull", 756, alma);
		Avenger soldadoDeInvierno = new Villano("Soldado De Invierno", 2875);
		Avenger hela = new Villano("Hela", 7865, poder); // 15730

		thor.aumentarPoder();
		ronnan.aumentarPoder();
		hela.aumentarPoder();

		batalla.pelea(thor, loki);
		batalla.pelea(capitanAmerica, ronnan);
		batalla.pelea(hulk, redSkull);
		batalla.pelea(blackWidow, soldadoDeInvierno);
		batalla.pelea(ironMan, hela);

		assertEquals(batalla.getHeroesOrdenados().first().equals(thor),
				batalla.getHeroesOrdenados().last().equals(blackWidow));
	}

	@Test(expected = CollectionNullException.class)
	public void noSePudoOrdenarListadoDeVillanosPorEstarVacio() throws PoderesEmpateException, NoAumentaPoderException,
			LaGemaNoAumentaPoderException, CollectionNullException {
		Batalla batalla = new Batalla();
		Gema mente = new Mente();
		Gema tiempo = new Tiempo();
		Gema realidad = new Realidad();
		Gema alma = new Alma();
		Gema espacio = new Espacio();
		Gema poder = new Poder();

		Avenger thor = new Heroe("Thor", 456, mente);
		Avenger capitanAmerica = new Heroe("Capitan America", 456);
		Avenger hulk = new Heroe("Hulk", 542, realidad);
		Avenger blackWidow = new Heroe("Black Widow", 8976);
		Avenger ironMan = new Heroe("Iron Man", 789, espacio);

		Avenger loki = new Villano("Loki", 100);
		Avenger ronnan = new Villano("Ronnan", 100, tiempo); // 1572
		Avenger redSkull = new Villano("Red Skull", 100, alma);
		Avenger soldadoDeInvierno = new Villano("Soldado De Invierno", 100);
		Avenger hela = new Villano("Hela", 100, poder); // 15730

		thor.aumentarPoder();
		ronnan.aumentarPoder();
		hela.aumentarPoder();

		batalla.pelea(thor, loki);
		batalla.pelea(capitanAmerica, ronnan);
		batalla.pelea(hulk, redSkull);
		batalla.pelea(blackWidow, soldadoDeInvierno);
		batalla.pelea(ironMan, hela);

		TreeSet<Villano> villanosOrdenados = batalla.villanosOrdenados(new OrdenadosPorPoderInicial());
	}

	@Test(expected = CollectionNullException.class)
	public void noSePudoOrdenarListadoDeHeroesPorEstarVacio() throws PoderesEmpateException, NoAumentaPoderException,
			LaGemaNoAumentaPoderException, CollectionNullException {
		Batalla batalla = new Batalla();
		Gema mente = new Mente();
		Gema tiempo = new Tiempo();
		Gema realidad = new Realidad();
		Gema alma = new Alma();
		Gema espacio = new Espacio();
		Gema poder = new Poder();

		Avenger thor = new Heroe("Thor", 90, mente);
		Avenger capitanAmerica = new Heroe("Capitan America", 90);
		Avenger hulk = new Heroe("Hulk", 90, realidad);
		Avenger blackWidow = new Heroe("Black Widow", 90);
		Avenger ironMan = new Heroe("Iron Man", 90, espacio);

		Avenger loki = new Villano("Loki", 100);
		Avenger ronnan = new Villano("Ronnan", 100, tiempo); // 1572
		Avenger redSkull = new Villano("Red Skull", 100, alma);
		Avenger soldadoDeInvierno = new Villano("Soldado De Invierno", 100);
		Avenger hela = new Villano("Hela", 100, poder); // 15730

		// thor.aumentarPoder();
		ronnan.aumentarPoder();
		hela.aumentarPoder();

		batalla.pelea(thor, loki);
		batalla.pelea(capitanAmerica, ronnan);
		batalla.pelea(hulk, redSkull);
		batalla.pelea(blackWidow, soldadoDeInvierno);
		batalla.pelea(ironMan, hela);

		batalla.getHeroesOrdenados();
	}

	@Test
	public void sePuedeSalvarElMundo() throws NoAumentaPoderException, LaGemaNoAumentaPoderException,
			PoderesEmpateException, WorldDestroyedException {
		Batalla batalla = new Batalla();

		Gema mente = new Mente();
		Gema tiempo = new Tiempo();
		Gema realidad = new Realidad();
		Gema alma = new Alma();
		Gema espacio = new Espacio();
		Gema poder = new Poder();

		Avenger thor = new Heroe("Thor", 100, mente);
		Avenger capitanAmerica = new Heroe("Capitan America", 110);
		Avenger hulk = new Heroe("Hulk", 100, realidad);
		Avenger blackWidow = new Heroe("Black Widow", 100);
		Avenger ironMan = new Heroe("Iron Man", 110, espacio);

		Avenger loki = new Villano("Loki", 50);
		Avenger ronnan = new Villano("Ronnan", 50, tiempo);
		Avenger redSkull = new Villano("Red Skull", 50, alma);
		Avenger soldadoDeInvierno = new Villano("Soldado De Invierno", 50);
		Avenger hela = new Villano("Hela", 50, poder);

		thor.aumentarPoder();
		ronnan.aumentarPoder();
		hela.aumentarPoder();

		batalla.pelea(thor, loki);
		batalla.pelea(capitanAmerica, ronnan);
		batalla.pelea(hulk, redSkull);
		batalla.pelea(blackWidow, soldadoDeInvierno);
		batalla.pelea(ironMan, hela);

		assertTrue(batalla.seSalvaElMundo());
	}

	@Test(expected = WorldDestroyedException.class)
	public void noSePuedeSalvarElMundo() throws NoAumentaPoderException, LaGemaNoAumentaPoderException,
			PoderesEmpateException, WorldDestroyedException {
		Batalla batalla = new Batalla();

		Gema mente = new Mente();
		Gema tiempo = new Tiempo();
		Gema realidad = new Realidad();
		Gema alma = new Alma();
		Gema espacio = new Espacio();
		Gema poder = new Poder();

		Avenger thor = new Heroe("Thor", 100, mente);
		Avenger capitanAmerica = new Heroe("Capitan America", 110);
		Avenger hulk = new Heroe("Hulk", 100, realidad);
		Avenger blackWidow = new Heroe("Black Widow", 100);
		Avenger ironMan = new Heroe("Iron Man", 110, espacio);

		Avenger loki = new Villano("Loki", 100000);
		Avenger ronnan = new Villano("Ronnan", 800, tiempo);
		Avenger redSkull = new Villano("Red Skull", 700, alma);
		Avenger soldadoDeInvierno = new Villano("Soldado De Invierno", 900);
		Avenger hela = new Villano("Hela", 5000, poder);

		thor.aumentarPoder();
		ronnan.aumentarPoder();
		hela.aumentarPoder();

		batalla.pelea(thor, loki);
		batalla.pelea(capitanAmerica, ronnan);
		batalla.pelea(hulk, redSkull);
		batalla.pelea(blackWidow, soldadoDeInvierno);
		batalla.pelea(ironMan, hela);

		batalla.seSalvaElMundo();
	}
}
