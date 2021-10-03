package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestMoverCaballo extends TestCase {

	
	
	public void testMoverCaballoAAD(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 7, 5, "e5", "d7");
		super.assertEquals(1, dev);
	}
	
	public void testMoverCaballoAAI(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 7, 3, "e5", "f7");
		super.assertEquals(1, dev);
	}
	
	public void testMoverCaballoDDAb(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 6, 6, "e5", "c6");
		super.assertEquals(0, dev);
	}
	
	public void testMoverCaballoDDAr(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 4, 6, "e5", "c4");
		super.assertEquals(0, dev);
	}
	
	public void testMoverCaballoIIAb(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 6, 2, "e5", "g6");
		super.assertEquals(0, dev);
	}
	
	public void testMoverCaballoIIAr(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 4, 2, "e5", "g4");
		super.assertEquals(0, dev);
	}
	
	public void testMoverCaballoAArD(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 3, 5, "e5", "d3");
		super.assertEquals(0, dev);
	}
	
	public void testMoverCaballoAArI(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 3, 3, "e5", "f3");
		super.assertEquals(0, dev);
	}
	
	
	public void testMoverCaballoDDAbEspecial(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 4, 5, "f3", "g5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 4, 5, 5, 3, "g5", "c6");
		super.assertEquals(0, dev);
		t.setColorDelJugadorConElTurno('b');
		dev = t.mover('b', 5, 3, 6, 1, "g5", "c6");
		super.assertEquals(0, dev);
	}
	
	
	
	public void testMoverCaballoAADLargo(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 8, 5, "e5", "d7");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoAAILargo(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 8, 3, "e5", "f7");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoDDAbLargo(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 6, 7, "e5", "c6");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoDDArLargo(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 4, 7, "e5", "c4");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoIIAbLargo(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 6, 1, "e5", "g6");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoIIArLargo(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 4, 1, "e5", "g4");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoAArDLargo(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.getTablero().clone()[1][4] = null;
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 2, 5, "e5", "d3");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoAArILargo(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		t.getTablero().clone()[1][2] = null;
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 2, 3, "e5", "f3");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoEX4(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 3, 6, "e5", "g6");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoEX3(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 7, 6, "e5", "g4");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoEX2(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 3, 2, "e5", "d3");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoEX(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 7, 2, "e5", "f3");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoEX4Corto(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 4, 5, "e5", "g6");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoEX3Corto(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 6, 5, "e5", "g4");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoEX2Corto(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 4, 3, "e5", "d3");
		super.assertEquals(-5, dev);
	}
	
	public void testMoverCaballoEXCorto(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a"), new Jugador("b"));
		
		t.mover('b', 1, 2, 3, 3, "g1", "f3");
		t.setColorDelJugadorConElTurno('b');
		t.mover('b', 3, 3, 5, 4, "f3", "e5");
		t.setColorDelJugadorConElTurno('b');
		
		dev = t.mover('b', 5, 4, 6, 3, "e5", "f3");
		super.assertEquals(-5, dev);
	}
}
