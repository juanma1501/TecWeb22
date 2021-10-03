package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestMoverRey extends TestCase {

	
	private Tablero t;
	private Jugador ja, jb;
	
	protected void setUp(){
		ja=new Jugador("ja");
		jb=new Jugador("jb");
		t = new Tablero(1, ja, jb);
		Pieza[][] tablero = t.getTablero();
		for(int i = 0;i<tablero.length;i++){
			for(int j = 0;j<tablero[i].length;j++){
				tablero[i][j] = null;
			}
		}
	}
	
	
	protected Peon addPeon(int fila, int colum, char color){
		Peon p = new Peon(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Torre addTorre(int fila, int colum, char color){
		Torre p = new Torre(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Caballo addCaballo(int fila, int colum, char color){
		Caballo p = new Caballo(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Alfil addAlfil(int fila, int colum, char color){
		Alfil p = new Alfil(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Dama addDama(int fila, int colum, char color){
		Dama p = new Dama(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Rey addRey(int fila, int colum, char color){
		Rey p = new Rey(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	
	
	public void testMover_1(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 5, 5,"e5", "d5");
		assertTrue(d == 0);
	}
	public void testMover_2(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 6, 5,"e5", "d6");
		assertTrue(d == 0);
	}
	public void testMover_3(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 4, 5,"e5", "d4");
		assertTrue(d == 0);
	}
	public void testMover_4(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 4, 4,"e5", "e4");
		assertTrue(d == 0);
	}
	public void testMover_5(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 6, 4,"e5", "e6");
		assertTrue(d == 0);
	}
	public void testMover_6(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 4, 3,"e5", "f4");
		assertTrue(d == 0);
	}
	public void testMover_7(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 5, 3,"e5", "f5");
		assertTrue(d == 0);
	}
	public void testMover_8(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 6, 3,"e5", "f6");
		assertTrue(d == 0);
	}
	
	
	public void testMover_NoValido(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 5, 4,"e5", "fe5");
		assertTrue(d == -4);
	}
	
	
	public void testMover_1NV(){
		this.addRey(5, 4, 'b');
		try{
			t.mover('b', 5, 4, 5, 6,"e5", "c5");
			fail();
		}catch(Exception e){
			
		}
		
	}
	public void testMover_2NV(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 6, 6,"e5", "c6");
		assertTrue(d == -5);
	}
	public void testMover_3NV(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 4, 6,"e5", "c4");
		assertTrue(d == -5);
	}
	public void testMover_4NV(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 3, 4,"e5", "e3");
		assertTrue(d == -5);
	}
	public void testMover_4NV_2(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 3, 3,"e5", "e3");
		assertTrue(d == -5);
	}
	public void testMover_4NV_3(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 3, 5,"e5", "e3");
		assertTrue(d == -5);
	}
	public void testMover_5NV(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 7, 4,"e5", "e6");
		assertTrue(d == -5);
	}
	public void testMover_5NV_1(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 7, 3,"e5", "e6");
		assertTrue(d == -5);
	}
	public void testMover_5NV_2(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 7, 5,"e5", "e6");
		assertTrue(d == -5);
	}
	
	
	public void testMover_6NV(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 4, 2,"e5", "f4");
		assertTrue(d == -5);
	}
	public void testMover_7NV(){
		this.addRey(5, 4, 'b');
		try{
			t.mover('b', 5, 4, 5, 2,"e5", "f5");
			fail();
		}catch(Exception e){
			
		}
		
	}
	public void testMover_8NV(){
		this.addRey(5, 4, 'b');
		int d = t.mover('b', 5, 4, 6, 2,"e5", "f6");
		assertTrue(d == -5);
	}
	
	
	
}
