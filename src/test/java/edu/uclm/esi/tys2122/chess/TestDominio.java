package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestDominio extends TestCase {
		// Ordenaci?n de las piezas: primero la fila de los peones y despu?s 
		//las dem?s piezas; por tanto, los peones van del 0 al 7, y el resto son:
	protected final int fnTorre1 = 8;
	protected final int fnTorre2 = 9;
	protected final int fnCaballo1 = 10;
	protected final int fnCaballo2 = 11;
	protected final int fnAlfil1 = 12;
	protected final int fnAlfil2 = 13;
	protected final int fnDama = 14;
	protected final int fnRey = 15;
	
	private Jugador jugador1, jugador2;
	
	
	public TestDominio(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		jugador1=new Jugador("j1", "");
		jugador2=new Jugador("j2", "");
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	/***************   TESTS DE LA CLASE "TABLERO"   ***************/
	
	/* getJugador(char) */
	public void testGetJugador1() {
		Jugador dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getJugador(char): testGetJugador1");
		dev = t.getJugador('b');
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(jugador1, dev);
	} /* Fin m?todo testGetJugador1 */
	
	
	/* getJugador(char) */
	public void testGetJugador2() {
		Jugador dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getJugador(char): testGetJugador2");
		dev = t.getJugador('n');
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(jugador2, dev);
	} /* Fin m?todo testGetJugador2 */
	
	
	/* abandono(char) */
	public void testAbandonoNegras() {
		Jugador dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("abandono(char): testAbandonoNegras");
		t.abandonar('n');
		dev = t.getGanador();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==jugador2);
	} /* Fin m?todo testAbandonoNegras */	
	
	/* abandono(char) */
	public void testAbandonoBlancas() {
		Jugador dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("abandono(char): testAbandonoBlancas");
		t.abandonar('b');
		dev = t.getGanador();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==jugador1);
	} /* Fin m?todo testAbandonoBlancas */
	
	
	/* mover(char, int, int, int, int)
	 * 0: el movimiento se ha realizado correctamente */
	public void testMover0() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("mover(char, int, int, int, int): CASO testMover0");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 2, 1, 3, 1, "h2", "h3");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==0);
	} /* Fin m?todo testMover0 */
	
	
	/* mover(char, int, int, int, int)
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 0: el movimiento se ha realizado correctamente */
	public void testMover1_1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		System.out.println("mover(char, int, int, int, int): CASO testMover1_1");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 1, 7, 1, "h1", "h7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==1);
	} /* Fin m?todo testMover1_1 */
	
	
	/* mover(char, int, int, int, int)
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 0: el movimiento se ha realizado correctamente */
	public void testMover1_2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 1, 3, 1, "h2", "h3");
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 3, 1, 4, 1, "h3", "h4");
		System.out.println("mover(char, int, int, int, int): CASO testMover1_2");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 5, 2, 4, 1, "g5", "h4");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==1);
	} /* Fin m?todo testMover1_2 */
	
	
	/* mover(char, int, int, int, int)
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero
	 * 0: el movimiento se ha realizado correctamente */
	public void testMover2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[6][0].setPosicion(6, 0);
		System.out.println("mover(char, int, int, int, int): CASO testMover2");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 7, 1, 8, 1, "h7", "h8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==2);
	} /* Fin m?todo testMover2 */
	
	
	/* mover(char, int, int, int, int)
	 * 3: estados 1 y 2
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover3() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[6][0].setPosicion(6, 0);
		System.out.println("mover(char, int, int, int, int): CASO testMover3");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 7, 1, 8, 2, "h7", "g8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==3);
	} /* Fin m?todo testMover3 */
	
	
	/* mover(char, int, int, int, int)
	 * 4: estado 0 y el movimiento realizado ha sido tomar al paso */
	public void testMover4_1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		t.almacenarMovimiento("h7-h5");
		System.out.println("mover(char, int, int, int, int): CASO testMover4_1");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 2, 6, 1, "g5", "h6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==4);
	} /* Fin m?todo testMover4_1 */
	
	
	/* mover(char, int, int, int, int)
	 * 4: estado 0 y el movimiento realizado ha sido tomar al paso */
	public void testMover4_2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 1, 3, 1, "h2", "h3");
		t.mover('n', 7, 3, 5, 3, "f7", "f5");
		t.mover('b', 3, 1, 4, 1, "h3", "h4");
		t.mover('n', 5, 3, 4, 3, "f5", "f4");
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.almacenarMovimiento("g2-g4");
		System.out.println("mover(char, int, int, int, int): CASO testMover4_2");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 4, 3, 3, 2, "f4", "g3");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==4);
	} /* Fin m?todo testMover4_2 */
	
	
	/* mover(char, int, int, int, int)
	 * 4: estado 0 y el movimiento realizado ha sido tomar al paso */
	public void testMover4_3() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 4, 4, 4, "e2", "e4");
		t.mover('n', 7, 1, 6, 1, "h7", "h6");
		t.mover('b', 4, 4, 5, 4, "e4", "e5");
		t.mover('n', 7, 3, 5, 3, "f7", "f5");
		t.almacenarMovimiento("f7-f5");
		System.out.println("mover(char, int, int, int, int): CASO testMover4_3");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 4, 6, 3, "e5", "f6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==4);
	} /* Fin m?todo testMover4_3 */	
	
	
	/* mover(char, int, int, int, int)
	 * 4: estado 0 y el movimiento realizado ha sido tomar al paso */
	public void testMover4_4() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 5, 4, 5, "d2", "d4");
		t.mover('n', 7, 1, 6, 1, "h7", "h6");
		t.mover('b', 4, 5, 5, 5, "d4", "d5");
		t.mover('n', 7, 4, 5, 4, "e7", "e5");
		t.almacenarMovimiento("e7-e5");
		System.out.println("mover(char, int, int, int, int): CASO testMover4_4");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 5, 6, 4, "d5", "e6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==4);
	} /* Fin m?todo testMover4_4 */
	
	
	/* mover(char, int, int, int, int)
	 * 4: estado 0 y el movimiento realizado ha sido tomar al paso */
	public void testMover4_5() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 6, 4, 6, "c2", "c4");
		t.mover('n', 7, 1, 6, 1, "h7", "h6");
		t.mover('b', 4, 6, 5, 6, "c4", "c5");
		t.mover('n', 7, 5, 5, 5, "d7", "d5");
		t.almacenarMovimiento("d7-d5");
		System.out.println("mover(char, int, int, int, int): CASO testMover4_5");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 6, 6, 5, "c5", "d6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==4);
	} /* Fin m?todo testMover4_5 */
	
	
	/* mover(char, int, int, int, int)
	 * 4: estado 0 y el movimiento realizado ha sido tomar al paso */
	public void testMover4_6() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 7, 4, 7, "b2", "b7");
		t.mover('n', 7, 1, 6, 1, "h7", "h6");
		t.mover('b', 4, 7, 5, 7, "b4", "b7");
		t.mover('n', 7, 6, 5, 6, "c7", "c5");
		t.almacenarMovimiento("c7-c5");
		System.out.println("mover(char, int, int, int, int): CASO testMover4_6");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 7, 6, 6, "b5", "c6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==4);
	} /* Fin m?todo testMover4_6 */
	
	
	/* mover(char, int, int, int, int)
	 * 4: estado 0 y el movimiento realizado ha sido tomar al paso */
	public void testMover4_7() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 8, 4, 8, "a2", "a4");
		t.mover('n', 7, 1, 6, 1, "h7", "h6");
		t.mover('b', 4, 8, 5, 8, "a4", "a5");
		t.mover('n', 7, 7, 5, 7, "b7", "b5");
		t.almacenarMovimiento("b7-b5");
		System.out.println("mover(char, int, int, int, int): CASO testMover4_7");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 8, 6, 7, "a5", "b6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==4);
	} /* Fin m?todo testMover4_7 */
	
	
	/* mover(char, int, int, int, int)
	 * 4: estado 0 y el movimiento realizado ha sido tomar al paso */
	public void testMover4_8() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 7, 4, 7, "b2", "b4");
		t.mover('n', 7, 8, 5, 8, "a7", "a5");
		t.mover('b', 4, 7, 5, 7, "b4", "b5");
		t.mover('n', 8, 8, 7, 8, "a8", "a7");
		t.almacenarMovimiento("a8-a7");
		System.out.println("mover(char, int, int, int, int): CASO testMover4_8");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 7, 6, 8, "b5", "a6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-5);
	} /* Fin m?todo testMover4_8 */
	
	
	/* mover(char, int, int, int, int)
	 * 5: estado 0 y el movimiento realizado ha sido el enroque corto */
	public void testMover5() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 1, 3, 1, "h2", "h3");
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		System.out.println("mover(char, int, int, int, int): CASO testMover5");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 8, 4, 8, 2, "e8", "g8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==5);
	} /* Fin m?todo testMover5 */
	
	
	/* mover(char, int, int, int, int)
	 * 5: estado 0 y el movimiento realizado ha sido el enroque corto */
	public void testMover5_medio() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 1, 3, 1, "h2", "h3");
		t.getTablero()[3][3] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		System.out.println("mover(char, int, int, int, int): CASO testMover5_medio");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 8, 4, 8, 2, "e8", "g2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-5);
	} /* Fin m?todo testMover5_medio */
	
	
	/* mover(char, int, int, int, int)
	 * 6: estado 0 y el movimiento realizado ha sido el enroque largo */
	public void testMover6() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		System.out.println("mover(char, int, int, int, int): CASO testMover6");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 4, 1, 6, "e1", "c1");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==6);
	} /* Fin m?todo testMover6 */
	
	
	/* mover(char, int, int, int, int)
	 * 6: estado 0 y el movimiento realizado ha sido el enroque largo */
	public void testMover6_medio() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[4][3] = t.getTablero()[7][7];
		t.getTablero()[7][7] = null;
		t.getTablero()[4][3].setPosicion(4, 3);
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		System.out.println("mover(char, int, int, int, int): CASO testMover6_medio");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 4, 1, 6, "e1", "c1");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-5);
	} /* Fin m?todo testMover6_medio */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover10() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		System.out.println("mover(char, int, int, int, int): CASO testMover10");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 5, 2, 4, "d1", "e2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover10 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorComeAtacante() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][2] = t.getTablero()[7][1];
		t.getTablero()[7][1] = null;
		t.getTablero()[4][2].setPosicion(4, 2);
		t.getTablero()[7][2] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[7][2].setPosicion(7, 2);
		t.getTablero()[7][4] = t.getTablero()[6][1];
		t.getTablero()[6][1] = null;
		t.getTablero()[7][4].setPosicion(7, 4);
		t.mover('b', 1, 1, 2, 1, "h1", "h2");
		t.mover('n', 5, 3, 3, 2, "f5", "g3");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorComeAtacante");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 2, 1, 2, 4, "h2", "e2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorComeAtacante */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorTorreN() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[7][2] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[7][2].setPosicion(7, 2);
		t.getTablero()[7][4] = t.getTablero()[6][1];
		t.getTablero()[6][1] = null;
		t.getTablero()[7][4].setPosicion(7, 4);
		t.mover('b', 1, 1, 2, 1, "h1", "h2");
		t.mover('n', 8, 1, 6, 1, "h8", "h6");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorTorreN");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 2, 1, 2, 4, "h2", "e2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorTorreN */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorTorreE() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][0];
		t.getTablero()[7][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[7][0] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[7][0].setPosicion(7, 0);
		t.getTablero()[6][7] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[6][7].setPosicion(6, 7);
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorTorreE");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 7, 8, 8, 8, "a7", "a8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorTorreE */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorTorreS() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[0][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[0][2].setPosicion(0, 2);
		t.getTablero()[0][4] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[0][4].setPosicion(0, 4);
		t.getTablero()[6][0] = t.getTablero()[7][0];
		t.getTablero()[7][0] = null;
		t.getTablero()[6][0].setPosicion(6, 0);
		t.mover('b', 1, 1, 3, 1, "h1", "h3");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorTorreS");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 7, 1, 7, 4, "h7", "e7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorTorreS */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorTorreO() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getTablero()[4][4] = t.getTablero()[7][0];
		t.getTablero()[7][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[7][7] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[7][7].setPosicion(7, 7);
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorTorreO");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 1, 8, 1, "h1", "h8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorTorreO */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorAlfilNE() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[7][0] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[7][0].setPosicion(7, 0);
		t.getTablero()[7][1] = t.getTablero()[6][1];
		t.getTablero()[6][1] = null;
		t.getTablero()[7][1].setPosicion(7, 1);
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorAlfilNE");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 6, 2, 7, "c1", "b2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorAlfilNE */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorAlfilSE() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[0][1] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[0][1].setPosicion(0, 1);
		t.getTablero()[1][1] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[1][1].setPosicion(1, 1);
		t.mover('b', 2, 2, 1, 1, "g2", "h1");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorAlfilSE");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 8, 6, 7, 7, "c8", "b7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorAlfilSE */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorAlfilSO() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[0][6] = t.getTablero()[1][6];
		t.getTablero()[1][6] = null;
		t.getTablero()[0][6].setPosicion(0, 6);
		t.getTablero()[1][6] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[1][6].setPosicion(1, 6);
		t.mover('b', 2, 7, 1, 8, "b2", "a1");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorAlfilSO");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 8, 3, 7, 2, "f8", "g7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorAlfilSO */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorAlfilNO() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getTablero()[7][7] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[7][7].setPosicion(7, 7);
		t.getTablero()[7][6] = t.getTablero()[6][6];
		t.getTablero()[6][6] = null;
		t.getTablero()[7][6].setPosicion(7, 6);
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorAlfilNO");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 3, 2, 2, "f1", "g2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorAlfilNO */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorDamaN() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[0][0] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[0][0].setPosicion(0, 0);
		t.getTablero()[7][2] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[7][2].setPosicion(7, 2);
		t.getTablero()[7][4] = t.getTablero()[6][1];
		t.getTablero()[6][1] = null;
		t.getTablero()[7][4].setPosicion(7, 4);
		t.mover('b', 1, 1, 2, 1, "h1", "h2");
		t.mover('n', 8, 1, 6, 1, "h8", "h6");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorDamaN");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 2, 1, 2, 4, "h2", "e2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorDamaN */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorDamaE() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][0];
		t.getTablero()[7][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[7][0] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[7][0].setPosicion(7, 0);
		t.getTablero()[6][7] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[6][7].setPosicion(6, 7);
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorDamaE");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 7, 8, 8, 8, "a7", "a8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorDamaE */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorDamaS() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[0][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[0][2].setPosicion(0, 2);
		t.getTablero()[0][4] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[0][4].setPosicion(0, 4);
		t.mover('b', 1, 1, 3, 1, "h1", "h3");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorDamaS");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 8, 5, 7, 4, "d8", "e7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorDamaS */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorDamaO() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getTablero()[4][4] = t.getTablero()[7][0];
		t.getTablero()[7][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[7][7] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[7][7].setPosicion(7, 7);
		t.getTablero()[0][0] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[0][0].setPosicion(0, 0);
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorDamaO");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 1, 8, 1, "h1", "h8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorDamaO */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorDamaNE() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[7][0] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[7][0].setPosicion(7, 0);
		t.getTablero()[7][1] = t.getTablero()[6][1];
		t.getTablero()[6][1] = null;
		t.getTablero()[7][1].setPosicion(7, 1);
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorDamaNE");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 5, 4, 5, "d1", "d4");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorDamaNE */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorDamaSE() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[0][1] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[0][1].setPosicion(0, 1);
		t.getTablero()[1][1] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[1][1].setPosicion(1, 1);
		t.mover('b', 2, 2, 1, 1, "g2", "h1");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorDamaSE");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 8, 5, 5, 5, "e8", "e5");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorDamaSE */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorDamaSO() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[0][6] = t.getTablero()[1][6];
		t.getTablero()[1][6] = null;
		t.getTablero()[0][6].setPosicion(0, 6);
		t.getTablero()[1][6] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[1][6].setPosicion(1, 6);
		t.mover('b', 2, 7, 1, 8, "b2", "a1");
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorDamaSO");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 8, 5, 4, 5, "d8", "d4");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorDamaSO */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_SalvadorDamaNO() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getTablero()[7][7] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[7][7].setPosicion(7, 7);
		t.getTablero()[7][6] = t.getTablero()[6][6];
		t.getTablero()[6][6] = null;
		t.getTablero()[7][6].setPosicion(7, 6);
		System.out.println("mover(char, int, int, int, int): CASO testMover_SalvadorDamaNO");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 5, 5, 5, "d1", "d5");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_SalvadorDamaNO */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueCaballo1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][5] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[4][5].setPosicion(4, 5);
		t.getTablero()[3][1] = t.getTablero()[7][1];
		t.getTablero()[7][1] = null;
		t.getTablero()[3][1].setPosicion(3, 1);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueCaballo1");
		System.out.println(t.toString());
		System.out.println();
		t.mover('b', 5, 6, 5, 5, "c5", "d5");
		dev = t.mover('n', 4, 2, 3, 4, "g4", "e3");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueCaballo1 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueCaballo2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[3][7] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][7].setPosicion(3, 7);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueCaballo2");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 4, 8, 3, 6, "a4", "c3");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueCaballo2 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueCaballo3() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[5][7] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[5][7].setPosicion(5, 7);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueCaballo3");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 6, 8, 4, 7, "a6", "b4");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueCaballo3 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueCaballo4() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[3][7] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][7].setPosicion(3, 7);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueCaballo4");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 4, 8, 6, 7, "a4", "b6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueCaballo4 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueCaballo5() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[7][5] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[7][5].setPosicion(7, 5);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueCaballo5");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 8, 6, 7, 4, "c8", "e7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueCaballo5 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueCaballo6() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[7][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[7][3].setPosicion(8, 3);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueCaballo6");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 8, 4, 7, 6, "e8", "c7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueCaballo6 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueCaballo7() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[4][0] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[4][0].setPosicion(4, 0);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueCaballo7");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 1, 4, 3, "h5", "f4");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueCaballo7 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueCaballo8() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[4][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[4][0] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[4][0].setPosicion(4, 0);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueCaballo8");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 5, 1, 6, 3, "h5", "f6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueCaballo8 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueExtra1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[7][1] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[7][1].setPosicion(7, 1);
		t.getTablero()[5][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[5][2].setPosicion(5, 2);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueExtra1");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 6, 3, 7, 3, "f6", "f7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueExtra1 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueExtra2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[7][1] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[7][1].setPosicion(7, 1);
		t.getTablero()[5][4] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[5][4].setPosicion(5, 4);
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueExtra2");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 6, 5, 7, 5, "d6", "d7");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueExtra2 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueExtra3() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[2][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[2][1] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[2][1].setPosicion(2, 1);
		t.mover('b', 1, 4, 1, 3, "e1", "f1");
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueExtra3");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 3, 2, 2, 2, "g3", "g2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueExtra3 */
	
	
	/* mover(char, int, int, int, int)
	 * 1_: estado 0, 1, 2 o 3 y se produce jaque al rey contrario
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover_JaqueExtra4() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[2][4] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[2][3] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.mover('b', 1, 4, 1, 3, "e1", "f1");
		System.out.println("mover(char, int, int, int, int): CASO testMover_JaqueExtra4");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 3, 4, 2, 4, "e3", "e2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==10);
	} /* Fin m?todo testMover_JaqueExtra4 */
	
	
	/* mover(char, int, int, int, int)
	 * 2_: estado 0, 1, 2 o 3 y el jugador actual ha ganado la partida
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover20() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getTablero()[7][2] = t.getTablero()[7][0];
		t.getTablero()[7][0] = null;
		t.getTablero()[7][2].setPosicion(7, 2);
		t.getTablero()[7][4] = t.getTablero()[7][7];
		t.getTablero()[7][7] = null;
		t.getTablero()[7][4].setPosicion(7, 4);
		System.out.println("mover(char, int, int, int, int): CASO testMover20");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 5, 2, 4, "d1", "e2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==20);
	} /* Fin m?todo testMover20 */
	
	
	/* mover(char, int, int, int, int)
	 * 3_: estado 0, 1, 2 o 3 y se han producido tablas
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover31() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[1][0] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = t.getTablero()[6][7];
		t.getTablero()[6][7] = null;
		t.getTablero()[0][4].setPosicion(0, 4);
		System.out.println("mover(char, int, int, int, int): CASO testMover31");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 4, 1, 5, "e1", "d1");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==31);
	} /* Fin m?todo testMover31 */
	
	
	/* mover(char, int, int, int, int)
	 * 3_: estado 0, 1, 2 o 3 y se han producido tablas
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover3_Ahogado() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[5][3] = t.getTablero()[7][3];
		t.getTablero()[7][3] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		t.getBlancas()[t.getTablero()[0][0].getId()] = null;
		t.getTablero()[0][0] = null;
		t.getTablero()[4][2] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[4][2].setPosicion(4, 2);
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getTablero()[2][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[7][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[7][3].setPosicion(7, 3);
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getTablero()[4][4] = t.getTablero()[0][6];
		t.getTablero()[0][6] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][0].getId()] = null;
		t.getTablero()[4][1] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[4][1].setPosicion(4, 1);
		t.getTablero()[4][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[4][3].setPosicion(4, 3);
		t.getTablero()[4][5] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[4][5].setPosicion(4, 5);
		t.getTablero()[5][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[5][2].setPosicion(5, 2);
		t.getTablero()[5][4] = t.getTablero()[1][4];
		t.getTablero()[1][4] = null;
		t.getTablero()[5][4].setPosicion(5, 4);
		t.getTablero()[6][2] = t.getTablero()[1][5];
		t.getTablero()[1][5] = null;
		t.getTablero()[6][2].setPosicion(6, 2);
		t.getTablero()[6][3] = t.getTablero()[1][6];
		t.getTablero()[1][6] = null;
		t.getTablero()[6][3].setPosicion(6, 3);
		t.getTablero()[6][4] = t.getTablero()[1][7];
		t.getTablero()[1][7] = null;
		t.getTablero()[6][4].setPosicion(6, 4);
		System.out.println("mover(char, int, int, int, int): CASO testMover3_Ahogado");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 3, 4, 4, 4, "e3", "e4");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==30);
	} /* Fin m?todo testMover3_Ahogado */
	
	
	/* mover(char, int, int, int, int)
	 * 3_: estado 0, 1, 2 o 3 y se han producido tablas
	 * 0: el movimiento se ha realizado correctamente
	 * 1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 * 2: estado 0 y la pieza es un pe?n que ha llegado al final del tablero */
	public void testMover3_JaqueContinuo() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.almacenarMovimiento("g1-f3");
		t.mover('n', 8, 2, 6, 3, "g8", "f6");
		t.almacenarMovimiento("g8-f6");
		t.mover('b', 3, 3, 1, 2, "f3", "g1");
		t.almacenarMovimiento("f3-g1");
		t.mover('n', 6, 3, 8, 2, "f6", "g8");
		t.almacenarMovimiento("f6-g8");
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.almacenarMovimiento("g1-f3");
		t.mover('n', 8, 2, 6, 3, "g8", "f6");
		t.almacenarMovimiento("g8-f6");
		t.mover('b', 3, 3, 1, 2, "f3", "g1");
		t.almacenarMovimiento("f3-g1");
		t.mover('n', 6, 3, 8, 2, "f6", "g8");
		t.almacenarMovimiento("f6-g8");
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.almacenarMovimiento("g1-f3");
		t.mover('n', 8, 2, 6, 3, "g8", "f6");
		t.almacenarMovimiento("g8-f6");
		t.mover('b', 3, 3, 1, 2, "f3", "g1");
		t.almacenarMovimiento("f3-g1");
		System.out.println("mover(char, int, int, int, int): CASO testMover3_JaqueContinuo");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 6, 3, 8, 2, "f6", "g8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==30);
	} /* Fin m?todo testMover3_JaqueContinuo */
	
	
	/* mover(char, int, int, int, int)
	 * -1: no es el turno del jugador actual */
	public void testMoverMenos1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("mover(char, int, int, int, int): CASO testMoverMenos1");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 2, 1, 3, 1, "h2", "h3");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-1);
	} /* Fin m?todo testMoverMenos1 */
	
	
	/* mover(char, int, int, int, int)
	 * -2: no hay ninguna pieza en el origen */
	public void testMoverMenos2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("mover(char, int, int, int, int): CASO testMoverMenos2");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 3, 3, 4, 4, "f3", "e4");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-2);
	} /* Fin m?todo testMoverMenos2 */
	
	
	/* mover(char, int, int, int, int)
	 * -3: la pieza de la casilla origen no es del jugador actual */
	public void testMoverMenos3() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("mover(char, int, int, int, int): CASO testMoverMenos3");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 7, 1, 6, 1, "h7", "h6");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-3);
	} /* Fin m?todo testMoverMenos3 */
	
	
	/* mover(char, int, int, int, int)
	 * -4: hay una pieza del jugador actual en la casilla destino */
	public void testMoverMenos4() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("mover(char, int, int, int, int): CASO testMoverMenos4");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 1, 2, 1, "h1", "h2");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-4);
	} /* Fin m?todo testMoverMenos4 */
	
	
	/* mover(char, int, int, int, int)
	 * -5: el movimiento no se corresponde con la pieza del origen */
	public void testMoverMenos5() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("mover(char, int, int, int, int): CASO testMoverMenos5");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 2, 1, 3, 2, "h2", "g3");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-5);
	} /* Fin m?todo testMoverMenos5 */
	
	
	/* mover(char, int, int, int, int)
	 * -6: hay una pieza en medio que impide el movimiento solicitado */
	public void testMoverMenos6() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("mover(char, int, int, int, int): CASO testMoverMenos6");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('b', 1, 1, 4, 1, "h1", "h4");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-6);
	} /* Fin m?todo testMoverMenos6 */
	
	
	/* mover(char, int, int, int, int)
	 * -7: el movimiento dejar?a al rey en jaque */
	public void testMoverMenos7() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[1][3].setPosicion(1, 3);
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = t.getTablero()[7][4];
		t.getTablero()[7][4] = null;
		t.getTablero()[6][3].setPosicion(6, 3);
		t.mover('b', 2, 1, 3, 1, "h2", "h3");
		System.out.println("mover(char, int, int, int, int): CASO testMoverMenos7");
		System.out.println(t.toString());
		System.out.println();
		dev = t.mover('n', 7, 4, 8, 5, "e7", "d8");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==-7);
	} /* Fin m?todo testMoverMenos7 */
	
	
	/* convertirPeon(char)
	 * 0: conversi?n realizada sin incidencias */
	public void testConvertirPeon0() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 2, 3, 2, "g2", "g3");
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[7][0].setPosicion(7, 0);
		System.out.println("convertirPeon(): CASO testConvertirPeon0");
		System.out.println(t.toString());
		System.out.println();
		dev = t.convertirPeon('a');
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==0);
	} /* Fin m?todo testConvertirPeon0 */
	
	
	/* convertirPeon(char)
	 * 1: estado 0 y se produce jaque al rey contrario
	 * 0: conversi?n realizada sin incidencias */
	public void testConvertirPeon1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = t.getTablero()[6][2];
		t.getTablero()[6][2] = null;
		t.getTablero()[0][2].setPosicion(0, 2);
		System.out.println("convertirPeon(): CASO testConvertirPeon1");
		System.out.println(t.toString());
		System.out.println();
		dev = t.convertirPeon('t');
		System.out.println(t.toString());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==1);
	} /* Fin m?todo testConvertirPeon1 */
	
	
	/* convertirPeon(char)
	 * 2: estado 0 y el jugador actual ha ganado la partida
	 * 0: conversi?n realizada sin incidencias */
	public void testConvertirPeon2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 4, 1, 5, 2, "h4", "g5");
		t.mover('n', 7, 1, 6, 1, "h7", "h6");
		t.mover('b', 1, 1, 4, 1, "h1", "h4");
		t.mover('n', 6, 1, 5, 1, "h6", "h5");
		t.mover('b', 4, 1, 4, 2, "h4", "g4");
		t.mover('n', 5, 1, 4, 1, "h5", "h4");
		t.mover('b', 2, 2, 3, 2, "g2", "g3");
		t.mover('n', 4, 1, 3, 1, "h4", "h3");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 3, 1, 2, 1, "h3", "h2");
		t.mover('b', 3, 8, 4, 8, "a3", "a4");
		t.mover('n', 2, 1, 1, 1, "h2", "h1");
		System.out.println("convertirPeon(): CASO testConvertirPeon2");
		System.out.println(t.toString());
		System.out.println();
		dev = t.convertirPeon('d');
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==2);
	} /* Fin m?todo testConvertirPeon2 */
	
	
	/* convertirPeon(char)
	 * 3: estado 0 y se han producido tablas
	 * 0: conversi?n realizada sin incidencias */
	public void testConvertirPeon3() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getBlancas()[t.getTablero()[0][7].getId()] = null;
		t.getTablero()[0][7] = null;
		t.getBlancas()[t.getTablero()[1][1].getId()] = null;
		t.getTablero()[1][1] = null;
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][3].getId()] = null;
		t.getTablero()[1][3] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		t.getBlancas()[t.getTablero()[1][5].getId()] = null;
		t.getTablero()[1][5] = null;
		t.getBlancas()[t.getTablero()[1][6].getId()] = null;
		t.getTablero()[1][6] = null;
		t.getBlancas()[t.getTablero()[1][7].getId()] = null;
		t.getTablero()[1][7] = null;
		t.getNegras()[t.getTablero()[7][0].getId()] = null;
		t.getTablero()[7][0] = null;
		t.getNegras()[t.getTablero()[7][1].getId()] = null;
		t.getTablero()[7][1] = null;
		t.getNegras()[t.getTablero()[7][2].getId()] = null;
		t.getTablero()[7][2] = null;
		t.getNegras()[t.getTablero()[7][4].getId()] = null;
		t.getTablero()[7][4] = null;
		t.getNegras()[t.getTablero()[7][5].getId()] = null;
		t.getTablero()[7][5] = null;
		t.getNegras()[t.getTablero()[7][6].getId()] = null;
		t.getTablero()[7][6] = null;
		t.getNegras()[t.getTablero()[7][7].getId()] = null;
		t.getTablero()[7][7] = null;
		t.getNegras()[t.getTablero()[6][0].getId()] = null;
		t.getTablero()[6][0] = null;
		t.getNegras()[t.getTablero()[6][1].getId()] = null;
		t.getTablero()[6][1] = null;
		t.getNegras()[t.getTablero()[6][2].getId()] = null;
		t.getTablero()[6][2] = null;
		t.getNegras()[t.getTablero()[6][3].getId()] = null;
		t.getTablero()[6][3] = null;
		t.getNegras()[t.getTablero()[6][4].getId()] = null;
		t.getTablero()[6][4] = null;
		t.getNegras()[t.getTablero()[6][5].getId()] = null;
		t.getTablero()[6][5] = null;
		t.getNegras()[t.getTablero()[6][6].getId()] = null;
		t.getTablero()[6][6] = null;
		t.getNegras()[t.getTablero()[6][7].getId()] = null;
		t.getTablero()[6][7] = null;
		t.getTablero()[0][2] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[0][2].setPosicion(0, 2);
		t.getTablero()[6][1] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[6][1].setPosicion(6, 1);
		t.mover('b', 7, 2, 8, 2, "g7", "g8");
		System.out.println("convertirPeon(): CASO testConvertirPeon3");
		System.out.println(t.toString());
		System.out.println();
		dev = t.convertirPeon('c');
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(dev==3);
	} /* Fin m?todo testConvertirPeon3 */
		
	
	/***************   TESTS DE LA CLASE "PIEZA"   ***************/
	
	/* getId() */
	public void testGetId() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getId(): testGetId");
		System.out.println(apB[0].toString());
		System.out.println();
		dev = apB[0].getId();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(0, dev);
	} /* Fin m?todo testGetId */
	
	
	/* getTipo() */
	public void testGetTipo() {
		String dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apN = t.getNegras();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getTipo(): testGetTipo");
		System.out.println(apN[0].toString());
		System.out.println();
		dev = apN[0].getTipo();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals("p", dev);
	} /* Fin m?todo testGetTipo */
	
	
	/* getNombre() */
	public void testGetNombrePeon() {
		String dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getNombre(): testGetNombrePeon");
		System.out.println(apB[0].toString());
		System.out.println();
		dev = apB[0].getNombre();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals("peon", dev);
	} /* Fin m?todo testGetNombrePeon */
	
	
	/* getNombre() */
	public void testGetNombreTorre() {
		String dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getNombre(): testGetNombreTorre");
		System.out.println(apB[fnTorre1].toString());
		System.out.println();
		dev = apB[fnTorre1].getNombre();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals("torre", dev);
	} /* Fin m?todo testGetNombreTorre */
	
	
	/* getNombre() */
	public void testGetNombreCaballo() {
		String dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getNombre(): testGetNombreCaballo");
		System.out.println(apB[fnCaballo1].toString());
		System.out.println();
		dev = apB[fnCaballo1].getNombre();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals("caballo", dev);
	} /* Fin m?todo testGetNombreCaballo */
	
	
	/* getNombre() */
	public void testGetNombreAlfil() {
		String dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getNombre(): testGetNombreAlfil");
		System.out.println(apB[fnAlfil1].toString());
		System.out.println();
		dev = apB[fnAlfil1].getNombre();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals("alfil", dev);
	} /* Fin m?todo testGetNombreAlfil */
	
	
	/* getNombre() */
	public void testGetNombreDama() {
		String dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getNombre(): testGetNombreDama");
		System.out.println(apB[fnDama].toString());
		System.out.println();
		dev = apB[fnDama].getNombre();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals("dama", dev);
	} /* Fin m?todo testGetNombreDama */
	
	
	/* getNombre() */
	public void testGetNombreRey() {
		String dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getNombre(): testGetNombreRey");
		System.out.println(apB[fnRey].toString());
		System.out.println();
		dev = apB[fnRey].getNombre();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals("rey", dev);
	} /* Fin m?todo testGetNombreRey */
	
	
	/* getColor() */
	public void testGetColor() {
		char dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("getColor(): testGetColor");
		System.out.println(apB[0].toString());
		System.out.println();
		dev = apB[0].getColor();
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals('b', dev);
	} /* Fin m?todo testGetColor */
	
	
	/* setPosicion(int, int) */
	public void testSetPosicion() {
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		Pieza [] apB = t.getBlancas();
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("setPosicion(int, int): testSetPosicion");
		System.out.println(apB[0].toString());
		System.out.println();
		apB[0].setPosicion(5, 6);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertTrue(apB[0].getFila()==5 && apB[0].getColumna()==6);
	} /* Fin m?todo testSetPosicion */
	
	
	/***************   TESTS DE LA CLASE "PEON"   ***************/
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 0: el movimiento es v?lido o legal */
	public void testPeonEsValido0() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[4][4] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		System.out.println("esValido(Pieza [][], int, int, int, int): testPeonEsValido0");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[4][4].toString());
		System.out.println();
		dev = t.getTablero()[4][4].esValido(t.getTablero(), 4, 4, 5, 4);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(0, dev);
	} /* Fin m?todo testPeonEsValido0 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 0: el movimiento es v?lido o legal */
	public void testPeonEsValido0_comer() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][4] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[5][4].setPosicion(5, 4);
		System.out.println("esValido(Pieza [][], int, int, int, int): testPeonEsValido0_comer");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][4].toString());
		System.out.println();
		dev = t.getTablero()[5][4].esValido(t.getTablero(), 5, 4, 6, 5);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(0, dev);
	} /* Fin m?todo testPeonEsValido0_comer */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 1: se quiere tomar al paso a otro pe?n */
	public void testPeonEsValido1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "f2");
		t.mover('n', 7, 1, 5, 1, "a7", "a5");
		t.almacenarMovimiento("A7-A5");
		System.out.println("esValido(Pieza [][], int, int, int, int): testPeonEsValido1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[4][1].toString());
		System.out.println();
		dev = t.getTablero()[4][1].esValido(t.getTablero(), 4, 1, 5, 0);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(1, dev);
	} /* Fin m?todo testPeonEsValido1 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -1: el movimiento no se corresponde con la pieza del origen */
	public void testPeonEsValidoMenos1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[4][4] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		System.out.println("esValido(Pieza [][], int, int, int, int): testPeonEsValidoMenos1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[4][4].toString());
		System.out.println();
		dev = t.getTablero()[4][4].esValido(t.getTablero(), 4, 4, 3, 4);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-1, dev);
	} /* Fin m?todo testPeonEsValidoMenos1 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -2: hay una pieza en medio que impide el movimiento solicitado */
	public void testPeonEsValidoMenos2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[4][4] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		t.getTablero()[5][4] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[5][4].setPosicion(5, 4);
		System.out.println("esValido(Pieza [][], int, int, int, int): testPeonEsValidoMenos2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[4][4].toString());
		System.out.println();
		dev = t.getTablero()[4][4].esValido(t.getTablero(), 4, 4, 5, 4);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-2, dev);
	} /* Fin m?todo testPeonEsValidoMenos2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testPeonBloqueado1() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[2][2] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		System.out.println("estaBloqueada(Pieza [][]): testPeonBloqueado1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[1][3].toString());
		System.out.println();
		dev = t.getTablero()[1][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testPeonBloqueado1 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testPeonBloqueado2() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("estaBloqueada(Pieza [][]): testPeonBloqueado2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[1][0].toString());
		System.out.println();
		dev = t.getTablero()[1][0].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testPeonBloqueado2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testPeonBloqueado3() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[2][0] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[2][0].setPosicion(2, 0);
		t.getTablero()[2][1] = t.getTablero()[6][1];
		t.getTablero()[6][1] = null;
		t.getTablero()[2][1].setPosicion(2, 1);
		System.out.println("estaBloqueada(Pieza [][]): testPeonBloqueado3");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[1][0].toString());
		System.out.println();
		dev = t.getTablero()[1][0].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testPeonBloqueado3 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testPeonBloqueado4() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[5][2].setPosicion(5, 2);
		System.out.println("estaBloqueada(Pieza [][]): testPeonBloqueado4");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[6][3].toString());
		System.out.println();
		dev = t.getTablero()[6][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testPeonBloqueado4 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testPeonBloqueado5() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("estaBloqueada(Pieza [][]): testPeonBloqueado5");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[6][0].toString());
		System.out.println();
		dev = t.getTablero()[6][0].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testPeonBloqueado5 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testPeonBloqueado6() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][0] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[5][0].setPosicion(5, 0);
		t.getTablero()[5][1] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[5][1].setPosicion(5, 1);
		System.out.println("estaBloqueada(Pieza [][]): testPeonBloqueado6");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[6][0].toString());
		System.out.println();
		dev = t.getTablero()[6][0].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testPeonBloqueado6 */
	
	
	/***************   TESTS DE LA CLASE "TORRE"   ***************/
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 0: el movimiento es v?lido o legal */
	public void testTorreEsValido0() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][4] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[5][4].setPosicion(5, 4);
		System.out.println("esValido(Pieza [][], int, int, int, int): testTorreEsValido0");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][4].toString());
		System.out.println();
		dev = t.getTablero()[5][4].esValido(t.getTablero(), 5, 4, 3, 4);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(0, dev);
	} /* Fin m?todo testTorreEsValido0 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -1: el movimiento no se corresponde con la pieza del origen */
	public void testTorreEsValidoMenos1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][4] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[5][4].setPosicion(5, 4);
		System.out.println("esValido(Pieza [][], int, int, int, int): testTorreEsValidoMenos1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][4].toString());
		System.out.println();
		dev = t.getTablero()[5][4].esValido(t.getTablero(), 5, 4, 4, 3);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-1, dev);
	} /* Fin m?todo testTorreEsValidoMenos1 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -2: hay una pieza en medio que impide el movimiento solicitado */
	public void testTorreEsValidoMenos2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("esValido(Pieza [][], int, int, int, int): testTorreEsValidoMenos2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[0][0].toString());
		System.out.println();
		dev = t.getTablero()[0][0].esValido(t.getTablero(), 0, 0, 3, 0);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-2, dev);
	} /* Fin m?todo testTorreEsValidoMenos2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testTorreBloqueada1() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		System.out.println("estaBloqueada(Pieza [][]): testTorreBloqueada1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testTorreBloqueada1 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testTorreBloqueada2() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][3] = t.getTablero()[1][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		System.out.println("estaBloqueada(Pieza [][]): testTorreBloqueada2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testTorreBloqueada2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testTorreBloqueada3() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][3] = t.getTablero()[1][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[4][3] = t.getTablero()[1][1];
		t.getTablero()[0][0] = null;
		t.getTablero()[4][3].setPosicion(4, 3);
		System.out.println("estaBloqueada(Pieza [][]): testTorreBloqueada3");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testTorreBloqueada3 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testTorreBloqueada4() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][0];
		t.getTablero()[0][0] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][3] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[4][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[4][3].setPosicion(4, 3);
		t.getTablero()[3][2] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		t.getTablero()[3][4] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[3][4].setPosicion(3, 4);
		System.out.println("estaBloqueada(Pieza [][]): testTorreBloqueada4");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testTorreBloqueada4 */
	
	
	/***************   TESTS DE LA CLASE "CABALLO"   ***************/
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 0: el movimiento es v?lido o legal */
	public void testCaballoEsValido0() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("esValido(Pieza [][], int, int, int, int): testCaballoEsValido0");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[0][1].toString());
		System.out.println();
		dev = t.getTablero()[0][1].esValido(t.getTablero(), 0, 1, 2, 2);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(0, dev);
	} /* Fin m?todo testCaballoEsValido0 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -1: el movimiento no se corresponde con la pieza del origen */
	public void testCaballoEsValidoMenos1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		System.out.println("esValido(Pieza [][], int, int, int, int): testCaballoEsValidoMenos1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[0][1].toString());
		System.out.println();
		dev = t.getTablero()[0][1].esValido(t.getTablero(), 0, 1, 1, 1);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-1, dev);
	} /* Fin m?todo testCaballoEsValidoMenos1 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testCaballoBloqueado1() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getBlancas()[t.getTablero()[1][2].getId()] = null;
		t.getTablero()[1][2] = null;
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		System.out.println("estaBloqueada(Pieza [][]): testCaballoBloqueado1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testCaballoBloqueado1 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testCaballoBloqueado2() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getBlancas()[t.getTablero()[1][4].getId()] = null;
		t.getTablero()[1][4] = null;
		System.out.println("estaBloqueada(Pieza [][]): testCaballoBloqueado2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testCaballoBloqueado2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testCaballoBloqueado3() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		System.out.println("estaBloqueada(Pieza [][]): testCaballoBloqueado3");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testCaballoBloqueado3 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testCaballoBloqueado4() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][1] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][1].setPosicion(2, 1);
		System.out.println("estaBloqueada(Pieza [][]): testCaballoBloqueado4");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testCaballoBloqueado4 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testCaballoBloqueado5() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][1] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][1].setPosicion(2, 1);
		t.getTablero()[4][1] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[4][1].setPosicion(4, 1);
		System.out.println("estaBloqueada(Pieza [][]): testCaballoBloqueado5");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testCaballoBloqueado5 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testCaballoBloqueado6() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][1] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][1].setPosicion(2, 1);
		t.getTablero()[4][1] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[4][1].setPosicion(4, 1);
		t.getTablero()[2][5] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[2][5].setPosicion(2, 5);
		System.out.println("estaBloqueada(Pieza [][]): testCaballoBloqueado6");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testCaballoBloqueado6 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testCaballoBloqueado7() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][1] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][1].setPosicion(2, 1);
		t.getTablero()[4][1] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[4][1].setPosicion(4, 1);
		t.getTablero()[2][5] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[2][5].setPosicion(2, 5);
		t.getTablero()[4][5] = t.getTablero()[1][5];
		t.getTablero()[1][5] = null;
		t.getTablero()[4][5].setPosicion(4, 5);
		System.out.println("estaBloqueada(Pieza [][]): testCaballoBloqueado7");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testCaballoBloqueado7 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testCaballoBloqueado8() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][1];
		t.getTablero()[0][1] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][1] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][1].setPosicion(2, 1);
		t.getTablero()[4][1] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[4][1].setPosicion(4, 1);
		t.getTablero()[2][5] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[2][5].setPosicion(2, 5);
		t.getTablero()[4][5] = t.getTablero()[1][5];
		t.getTablero()[1][5] = null;
		t.getTablero()[4][5].setPosicion(4, 5);
		t.getTablero()[5][2] = t.getTablero()[1][6];
		t.getTablero()[1][6] = null;
		t.getTablero()[5][2].setPosicion(5, 2);
		t.getTablero()[5][4] = t.getTablero()[6][6];
		t.getTablero()[6][6] = null;
		t.getTablero()[5][4].setPosicion(5, 4);
		System.out.println("estaBloqueada(Pieza [][]): testCaballoBloqueado8");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testCaballoBloqueado8 */
	
	
	/***************   TESTS DE LA CLASE "ALFIL"   ***************/
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 0: el movimiento es v?lido o legal */
	public void testAlfilEsValido0() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][3] = t.getTablero()[0][2];
		t.getTablero()[0][2] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		System.out.println("esValido(Pieza [][], int, int, int, int): testAlfilEsValido0");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][3].toString());
		System.out.println();
		dev = t.getTablero()[5][3].esValido(t.getTablero(), 5, 3, 3, 1);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(0, dev);
	} /* Fin m?todo testAlfilEsValido0 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -1: el movimiento no se corresponde con la pieza del origen */
	public void testAlfilEsValidoMenos1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][3] = t.getTablero()[0][2];
		t.getTablero()[0][2] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		System.out.println("esValido(Pieza [][], int, int, int, int): testAlfilEsValidoMenos1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][3].toString());
		System.out.println();
		dev = t.getTablero()[5][3].esValido(t.getTablero(), 5, 3, 4, 3);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-1, dev);
	} /* Fin m?todo testAlfilEsValidoMenos1 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -2: hay una pieza en medio que impide el movimiento solicitado */
	public void testAlfilEsValidoMenos2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][3] = t.getTablero()[0][2];
		t.getTablero()[0][2] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		System.out.println("esValido(Pieza [][], int, int, int, int): testAlfilEsValidoMenos2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][3].toString());
		System.out.println();
		dev = t.getTablero()[5][3].esValido(t.getTablero(), 5, 3, 7, 1);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-2, dev);
	} /* Fin m?todo testAlfilEsValidoMenos2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testAlfilBloqueado1() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][2];
		t.getTablero()[0][2] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		System.out.println("estaBloqueada(Pieza [][]): testAlfilBloqueado1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testAlfilBloqueado1 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testAlfilBloqueado2() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][2];
		t.getTablero()[0][2] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		System.out.println("estaBloqueada(Pieza [][]): testAlfilBloqueado2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testAlfilBloqueado2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testAlfilBloqueado3() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][2];
		t.getTablero()[0][2] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][4] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		System.out.println("estaBloqueada(Pieza [][]): testAlfilBloqueado3");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testAlfilBloqueado3 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testAlfilBloqueado4() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][2];
		t.getTablero()[0][2] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][4] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[4][2] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[4][2].setPosicion(4, 2);
		t.getTablero()[4][4] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		System.out.println("estaBloqueada(Pieza [][]): testAlfilBloqueado4");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testAlfilBloqueado4 */
	
	
	/***************   TESTS DE LA CLASE "DAMA"   ***************/
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 0: el movimiento es v?lido o legal */
	public void testDamaEsValido0() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		System.out.println("esValido(Pieza [][], int, int, int, int): testDamaEsValido0");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][3].toString());
		System.out.println();
		dev = t.getTablero()[5][3].esValido(t.getTablero(), 5, 3, 3, 5);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(0, dev);
	} /* Fin m?todo testDamaEsValido0 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -1: el movimiento no se corresponde con la pieza del origen */
	public void testDamaEsValidoMenos1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		System.out.println("esValido(Pieza [][], int, int, int, int): testDamaEsValidoMenos1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][3].toString());
		System.out.println();
		dev = t.getTablero()[5][3].esValido(t.getTablero(), 5, 3, 4, 1);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-1, dev);
	} /* Fin m?todo testDamaEsValidoMenos1 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -2: hay una pieza en medio que impide el movimiento solicitado */
	public void testDamaEsValidoMenos2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		System.out.println("esValido(Pieza [][], int, int, int, int): testDamaEsValidoMenos2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][3].toString());
		System.out.println();
		dev = t.getTablero()[5][3].esValido(t.getTablero(), 5, 3, 7, 5);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-2, dev);
	} /* Fin m?todo testDamaEsValidoMenos2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testDamaBloqueada1() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		System.out.println("estaBloqueada(Pieza [][]): testDamaBloqueada1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testDamaBloqueada1 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testDamaBloqueada2() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		System.out.println("estaBloqueada(Pieza [][]): testDamaBloqueada2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testDamaBloqueada2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testDamaBloqueada3() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		System.out.println("estaBloqueada(Pieza [][]): testDamaBloqueada3");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testDamaBloqueada3 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testDamaBloqueada4() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		System.out.println("estaBloqueada(Pieza [][]): testDamaBloqueada4");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testDamaBloqueada4 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testDamaBloqueada5() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[3][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		System.out.println("estaBloqueada(Pieza [][]): testDamaBloqueada5");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testDamaBloqueada5 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testDamaBloqueada6() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[3][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		t.getTablero()[3][4] = t.getTablero()[1][4];
		t.getTablero()[1][4] = null;
		t.getTablero()[3][4].setPosicion(3, 4);
		System.out.println("estaBloqueada(Pieza [][]): testDamaBloqueada6");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testDamaBloqueada6 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testDamaBloqueada7() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[3][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		t.getTablero()[3][4] = t.getTablero()[1][4];
		t.getTablero()[1][4] = null;
		t.getTablero()[3][4].setPosicion(3, 4);
		t.getTablero()[4][2] = t.getTablero()[1][5];
		t.getTablero()[1][5] = null;
		t.getTablero()[4][2].setPosicion(4, 2);
		System.out.println("estaBloqueada(Pieza [][]): testDamaBloqueada7");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testDamaBloqueada7 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testDamaBloqueada8() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][4];
		t.getTablero()[0][4] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[3][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		t.getTablero()[3][4] = t.getTablero()[1][4];
		t.getTablero()[1][4] = null;
		t.getTablero()[3][4].setPosicion(3, 4);
		t.getTablero()[4][2] = t.getTablero()[1][5];
		t.getTablero()[1][5] = null;
		t.getTablero()[4][2].setPosicion(4, 2);
		t.getTablero()[4][3] = t.getTablero()[1][6];
		t.getTablero()[1][6] = null;
		t.getTablero()[4][3].setPosicion(4, 3);
		t.getTablero()[4][4] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		System.out.println("estaBloqueada(Pieza [][]): testDamaBloqueada8");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testDamaBloqueada8 */
	
	
	/***************   TESTS DE LA CLASE "REY"   ***************/
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 0: el movimiento es v?lido o legal */
	public void testReyEsValido0() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		System.out.println("esValido(Pieza [][], int, int, int, int): testReyEsValido0");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][3].toString());
		System.out.println();
		dev = t.getTablero()[5][3].esValido(t.getTablero(), 5, 3, 4, 3);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(0, dev);
	} /* Fin m?todo testReyEsValido0 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * -1: el movimiento no se corresponde con la pieza del origen */
	public void testReyEsValidoMenos1() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[5][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[5][3].setPosicion(5, 3);
		System.out.println("esValido(Pieza [][], int, int, int, int): testReyEsValidoMenos1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[5][3].toString());
		System.out.println();
		dev = t.getTablero()[5][3].esValido(t.getTablero(), 5, 3, 4, 1);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-1, dev);
	} /* Fin m?todo testReyEsValidoMenos1 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 2: se ha realizado el enroque corto */
	public void testReyEsValido2() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		System.out.println("esValido(Pieza [][], int, int, int, int): testReyEsValido2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[0][3].toString());
		System.out.println();
		dev = t.getTablero()[0][3].esValido(t.getTablero(), 0, 3, 0, 1);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(2, dev);
	} /* Fin m?todo testReyEsValido2 */
	
	
	/* esValido(Pieza [][], int, int, int, int)
	 * 3: se ha realizado el enroque largo */
	public void testReyEsValido3() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		System.out.println("esValido(Pieza [][], int, int, int, int): testReyEsValido3");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[0][3].toString());
		System.out.println();
		dev = t.getTablero()[0][3].esValido(t.getTablero(), 0, 3, 0, 5);
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(3, dev);
	} /* Fin m?todo testReyEsValido3 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testReyBloqueado1() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		System.out.println("estaBloqueada(Pieza [][]): testReyBloqueado1");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testReyBloqueado1 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testReyBloqueado2() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		System.out.println("estaBloqueada(Pieza [][]): testReyBloqueado2");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testReyBloqueado2 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testReyBloqueado3() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		System.out.println("estaBloqueada(Pieza [][]): testReyBloqueado3");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testReyBloqueado3 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testReyBloqueado4() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		System.out.println("estaBloqueada(Pieza [][]): testReyBloqueado4");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testReyBloqueado4 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testReyBloqueado5() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[3][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		System.out.println("estaBloqueada(Pieza [][]): testReyBloqueado5");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testReyBloqueado5 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testReyBloqueado6() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[3][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		t.getTablero()[3][4] = t.getTablero()[1][4];
		t.getTablero()[1][4] = null;
		t.getTablero()[3][4].setPosicion(3, 4);
		System.out.println("estaBloqueada(Pieza [][]): testReyBloqueado6");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testReyBloqueado6 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testReyBloqueado7() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[3][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		t.getTablero()[3][4] = t.getTablero()[1][4];
		t.getTablero()[1][4] = null;
		t.getTablero()[3][4].setPosicion(3, 4);
		t.getTablero()[4][2] = t.getTablero()[1][5];
		t.getTablero()[1][5] = null;
		t.getTablero()[4][2].setPosicion(4, 2);
		System.out.println("estaBloqueada(Pieza [][]): testReyBloqueado7");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testReyBloqueado7 */
	
	
	/* estaBloqueada(Pieza [][]) */
	public void testReyBloqueado8() {
		boolean dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getTablero()[3][3] = t.getTablero()[0][3];
		t.getTablero()[0][3] = null;
		t.getTablero()[3][3].setPosicion(3, 3);
		t.getTablero()[2][2] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][2].setPosicion(2, 2);
		t.getTablero()[2][3] = t.getTablero()[1][1];
		t.getTablero()[1][1] = null;
		t.getTablero()[2][3].setPosicion(2, 3);
		t.getTablero()[2][4] = t.getTablero()[1][2];
		t.getTablero()[1][2] = null;
		t.getTablero()[2][4].setPosicion(2, 4);
		t.getTablero()[3][2] = t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[3][2].setPosicion(3, 2);
		t.getTablero()[3][4] = t.getTablero()[1][4];
		t.getTablero()[1][4] = null;
		t.getTablero()[3][4].setPosicion(3, 4);
		t.getTablero()[4][2] = t.getTablero()[1][5];
		t.getTablero()[1][5] = null;
		t.getTablero()[4][2].setPosicion(4, 2);
		t.getTablero()[4][3] = t.getTablero()[1][6];
		t.getTablero()[1][6] = null;
		t.getTablero()[4][3].setPosicion(4, 3);
		t.getTablero()[4][4] = t.getTablero()[6][0];
		t.getTablero()[6][0] = null;
		t.getTablero()[4][4].setPosicion(4, 4);
		System.out.println("estaBloqueada(Pieza [][]): testReyBloqueado8");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[3][3].toString());
		System.out.println();
		dev = t.getTablero()[3][3].estaBloqueada(t.getTablero());
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertFalse(dev);
	} /* Fin m?todo testReyBloqueado8 */
	
	
	/* deshabilitarEnroqueCorto() */
	public void testReyDeshabilitarEnroqueCorto() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][1].getId()] = null;
		t.getTablero()[0][1] = null;
		t.getBlancas()[t.getTablero()[0][2].getId()] = null;
		t.getTablero()[0][2] = null;
		t.getTablero()[2][0] = t.getTablero()[1][0];
		t.getTablero()[1][0] = null;
		t.getTablero()[2][0].setPosicion(2, 0);
		t.mover('b', 1, 1, 2, 1, "h1", "h2");
		t.mover('n', 7, 1, 6, 1, "h7", "h6");
		System.out.println("deshabilitarEnroqueCorto(): testReyDeshabilitarEnroqueCorto");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[0][3].toString());
		System.out.println();
		dev = t.mover('b', 1, 4, 1, 2, "e1", "g1");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-5, dev);
	} /* Fin m?todo testReyDeshabilitarEnroqueCorto */
	
	
	/* deshabilitarEnroqueLargo() */
	public void testReyDeshabilitarEnroqueLargo() {
		int dev;
		//1? Construir instancia de la clase CUT
		Tablero t = new Tablero(1, jugador1, jugador2);
		//2? Ejecutar servicios sobre la instancia de la CUT
		t.getBlancas()[t.getTablero()[0][4].getId()] = null;
		t.getTablero()[0][4] = null;
		t.getBlancas()[t.getTablero()[0][5].getId()] = null;
		t.getTablero()[0][5] = null;
		t.getBlancas()[t.getTablero()[0][6].getId()] = null;
		t.getTablero()[0][6] = null;
		t.getTablero()[2][7] = t.getTablero()[1][7];
		t.getTablero()[1][7] = null;
		t.getTablero()[2][7].setPosicion(2, 7);
		t.mover('b', 1, 8, 2, 8, "a1", "a2");
		t.mover('n', 7, 1, 6, 1, "h7", "h6");
		System.out.println("deshabilitarEnroqueLargo(): testReyDeshabilitarEnroqueLargo");
		System.out.println(t.toString());
		System.out.println(t.getTablero()[0][3].toString());
		System.out.println();
		dev = t.mover('b', 1, 4, 1, 6, "e1", "c1");
		//3? Escribir or?culo (es un conjunto de instruccciones para comprobar 
		//que el resultado obtenido es el resultado esperado)
		super.assertEquals(-5, dev);
	} /* Fin m?todo testReyDeshabilitarEnroqueLargo */
	
} /* Fin clase TestDominio */
