package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestComerAlPAsoInvalido extends TestCase {

	
	
	public void testPeonComerAlPasoIzquierdaBlancaMuyLargo() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("h7-h5");
		dev = t.mover('b', 5, 2, 7, 1, "g5", "h7");
		
		
		super.assertEquals(-5, dev);
	} 
	
	
	
	public void testPeonComerAlPasoDerechaBlancaMuyLargo() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 1, 5, 1, "h4", "h5");
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.almacenarMovimiento("g7-g5");
		dev = t.mover('b', 5, 1, 7, 2, "h5", "g7");
		
		
		super.assertEquals(-5, dev);
	}
	
	
	
	public void testPeonComerAlPasoIzquierdaNegraMuyLargo() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		t.almacenarMovimiento("h2-h4");
		dev = t.mover('n', 4, 2, 2, 1, "g4", "h2");
		
		
		super.assertEquals(-5, dev);
	} 
	
	
	public void testPeonComerAlPasoDerechaNegraMuyLargo() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 1, 4, 1, "h5", "h4");
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.almacenarMovimiento("g2-g4");
		dev = t.mover('n', 4, 1, 2, 2, "h4", "g2");
		
		
		super.assertEquals(-5, dev);
	}
	
	public void testPeonComerAlPasoBlancaColumBad() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 3, 5, 3, "f7", "f5");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("h7-h5");
		dev = t.mover('b', 5, 2, 6, 2, "g5", "g6");
		super.assertEquals(0, dev);
		
	
	}
	
	public void testPeonComerAlPasoBlancaColumBadOL() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 3, 5, 3, "f7", "f5");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		
		
		t.almacenarMovimiento("f7-f5");
		dev = t.mover('b', 5, 2, 6, 2, "g5", "g6");
		super.assertEquals(0, dev);
	}
	
	
	
	
	
	
	
	public void testPeonComerAlPasoaNegraColumbad() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 3, 4, 3, "f2", "f3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		t.almacenarMovimiento("h2-h4");
		dev = t.mover('n', 4, 2, 3, 2, "g4", "g3");
		super.assertEquals(0, dev);
		
	} 
	public void testPeonComerAlPasoaNegraColumbadOL() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 3, 4, 3, "f2", "f3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		
		
		t.almacenarMovimiento("f2-f4");
		dev = t.mover('n', 4, 2, 3, 2, "g4", "g3");
		super.assertEquals(0, dev);
	} 
	
	
	public void testPeonComerAlPasoBlancaColumBadPasarse() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 4, 4, 4, "e2", "e4");
		t.mover('n', 7, 5, 5, 5, "d7", "d5");
		t.mover('b', 4, 4, 5, 4, "e4", "e5");
		t.mover('n', 7, 3, 5, 3, "f7", "f5");
		
		
		t.almacenarMovimiento("f7-f5");
		dev = t.mover('b', 5, 4, 6, 2, "e5", "g6");
		super.assertEquals(-5, dev);
		
	
	}
	
	public void testPeonComerAlPasoBlancaColumBadOLPasarse() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 4, 4, 4, "e2", "e4");
		t.mover('n', 7, 5, 5, 5, "d7", "d5");
		t.mover('b', 4, 4, 5, 4, "e4", "e5");
		t.mover('n', 7, 3, 5, 3, "f7", "f5");
		
		
		
		
		t.almacenarMovimiento("d7-d5");
		dev = t.mover('b', 5, 4, 6, 6, "e5", "c6");
		super.assertEquals(-5, dev);
	}
	
	
	
	
	
	
	
	public void testPeonComerAlPasoaNegraColumbadPasarse() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		t.mover('n', 7, 4, 5, 4, "e7", "e5");
		t.mover('b', 2, 5, 4, 5, "d2", "d3");
		t.mover('n', 5, 4, 4, 4, "e5", "e4");
		t.mover('b', 2, 3, 4, 3, "f2", "f4");
		
		
		t.almacenarMovimiento("f2-f4");
		dev = t.mover('n', 4, 4, 3, 2, "e4", "g3");
		super.assertEquals(-5, dev);
		
	} 
	public void testPeonComerAlPasoaNegraColumbadOLPasarse() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		t.mover('n', 7, 4, 5, 4, "e7", "e5");
		t.mover('b', 2, 5, 4, 5, "d2", "d3");
		t.mover('n', 5, 4, 4, 4, "e5", "e4");
		t.mover('b', 2, 3, 4, 3, "f2", "f4");
		
		
		
		
		t.almacenarMovimiento("d2-d4");
		dev = t.mover('n', 4, 4, 3, 6, "g4", "c3");
		super.assertEquals(-5, dev);
	} 
	
	
	public void testPeonComerAlPasoBlancaColumBadPasarse2() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 4, 4, 4, "e2", "e4");
		t.mover('n', 7, 6, 5, 6, "c7", "c5");
		t.mover('b', 4, 4, 5, 4, "e4", "e5");
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		
		
		t.almacenarMovimiento("f7-f5");
		dev = t.mover('b', 5, 4, 6, 2, "e5", "g6");
		super.assertEquals(-5, dev);
		
	
	}
	
	public void testPeonComerAlPasoBlancaColumBadOLPasarse2() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 4, 4, 4, "e2", "e4");
		t.mover('n', 7, 6, 5, 6, "c7", "c5");
		t.mover('b', 4, 4, 5, 4, "e4", "e5");
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		
		
		
		
		t.almacenarMovimiento("c7-c5");
		dev = t.mover('b', 5, 4, 6, 6, "e5", "c6");
		super.assertEquals(-5, dev);
	}
	
	
	
	
	
	
	
	public void testPeonComerAlPasoaNegraColumbadPasarse2() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		t.mover('n', 7, 4, 5, 4, "e7", "e5");
		t.mover('b', 2, 6, 4, 6, "c2", "c3");
		t.mover('n', 5, 4, 4, 4, "e5", "e4");
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		
		
		t.almacenarMovimiento("g2-g4");
		dev = t.mover('n', 4, 4, 3, 2, "e4", "g3");
		super.assertEquals(-5, dev);
		
	} 
	public void testPeonComerAlPasoaNegraColumbadOLPasarse2() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		t.mover('n', 7, 4, 5, 4, "e7", "e5");
		t.mover('b', 2, 6, 4, 6, "c2", "c3");
		t.mover('n', 5, 4, 4, 4, "e5", "e4");
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		
		
		
		
		t.almacenarMovimiento("c2-c4");
		dev = t.mover('n', 4, 4, 3, 6, "g4", "c3");
		super.assertEquals(-5, dev);
	} 
	
	
	
	public void testPeonComerAlPasoListaLarga() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		t.mover('n', 7, 5, 5, 5, "d7", "d5");
		t.mover('b', 2, 6, 4, 6, "c2", "c4");
		t.mover('n', 5, 5, 4, 5, "e5", "e4");
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		
		
		
		t.almacenarMovimiento("c1-a4");
		t.almacenarMovimiento("c3-b4");
		t.almacenarMovimiento("c4-d4");
		t.almacenarMovimiento("c5-e4");
		t.almacenarMovimiento("c6-f4");
		t.almacenarMovimiento("c7-g4");
		t.almacenarMovimiento("c8-h4");
		
		t.almacenarMovimiento("c2-c4");
		dev = t.mover('n', 4, 5, 3, 6, "g4", "c3");
		super.assertEquals(4, dev);
	} 
	
	
	public void testPeonComerAlPasoInvalidoSpecial() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("f7-f5");
		dev = t.mover('b', 5, 2, 6, 1, "g5", "h6");
		
		
		super.assertEquals(-5, dev);
	} 
	
	public void testPeonComerAlPasoInvalidoSpecial2() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("f7-h5");
		dev = t.mover('b', 5, 2, 6, 1, "g5", "h6");
		
		
		super.assertEquals(-5, dev);
	} 
	
	public void testPeonComerAlPasoInvalidoSpecial3() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("h8-h4");
		dev = t.mover('b', 5, 2, 6, 1, "g5", "h6");
		
		
		super.assertEquals(-5, dev);
	} 
	
	public void testPeonComerAlPasoInvalidoSpecial4() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("h8-h5");
		dev = t.mover('b', 5, 2, 6, 1, "g5", "h6");
		
		
		super.assertEquals(-5, dev);
	}
	
	public void testPeonComerAlPasoInvalidoSpecial5() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("h7-h6");
		dev = t.mover('b', 5, 2, 6, 1, "g5", "h6");
		
		
		super.assertEquals(-5, dev);
	}
	
	public void testPeonComerAlPasoInvalidoSpecial6() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("h6-h5");
		dev = t.mover('b', 5, 2, 6, 1, "g5", "h6");
		
		
		super.assertEquals(-5, dev);
	}
	
	public void testPeonComerAlPasoInvalidoSpecial7() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.mover('b', 2, 2, 4, 2, "g2", "g4");
		t.mover('n', 7, 8, 6, 8, "a7", "a6");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.mover('n', 7, 1, 5, 1, "h7", "h5");
		
		
		t.almacenarMovimiento("h7-h4");
		dev = t.mover('b', 5, 2, 6, 1, "g5", "h6");
		
		
		super.assertEquals(-5, dev);
	}
	
	
	
	
	
	/************************Ahora especiale spara negras*/
	
	public void testPeonComerAlPasoInvalidoSpecialn() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		t.almacenarMovimiento("f2-f4");
		dev = t.mover('n', 4, 2, 3, 1, "g4", "h3");
		
		
		super.assertEquals(-5, dev);
	} 
	
	public void testPeonComerAlPasoInvalidoSpecial2n() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		t.almacenarMovimiento("f2-h4");
		dev = t.mover('n', 4, 2, 3, 1, "g4", "h3");
		
		
		super.assertEquals(-5, dev);
	} 
	
	public void testPeonComerAlPasoInvalidoSpecial3n() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		t.almacenarMovimiento("h1-h5");
		dev = t.mover('n', 4, 2, 3, 1, "g4", "h3");
		
		
		super.assertEquals(-5, dev);
	} 
	
	public void testPeonComerAlPasoInvalidoSpecial4n() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		t.almacenarMovimiento("h1-h4");
		dev = t.mover('n', 4, 2, 3, 1, "g4", "h3");
		
		
		super.assertEquals(-5, dev);
	}
	
	public void testPeonComerAlPasoInvalidoSpecial5n() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		t.almacenarMovimiento("h2-h3");
		dev = t.mover('n', 4, 2, 3, 1, "g4", "h3");
		
		
		super.assertEquals(-5, dev);
	}
	
	public void testPeonComerAlPasoInvalidoSpecial6n() {
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		t.almacenarMovimiento("h3-h4");
		dev = t.mover('n', 4, 2, 3, 1, "g4", "h3");
		
		
		super.assertEquals(-5, dev);
	}
	
	public void testPeonComerAlPasoInvalidoSpecial7n(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 7, 2, 5, 2, "g7", "g5");
		t.mover('b', 2, 8, 3, 8, "a2", "a3");
		t.mover('n', 5, 2, 4, 2, "g5", "g4");
		t.mover('b', 2, 1, 4, 1, "h2", "h4");
		
		
		t.almacenarMovimiento("h2-h5");
		dev = t.mover('n', 4, 2, 3, 1, "g4", "h3");
		
		super.assertEquals(-5, dev);
	}
	 
}
