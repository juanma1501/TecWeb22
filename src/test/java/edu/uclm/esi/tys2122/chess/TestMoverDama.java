package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestMoverDama extends TestCase {

	
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
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 5, 8,"e5", "d5");
		assertTrue(d == 0);
	}
	public void testMover_2(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 1, 8,"e5", "d6");
		assertTrue(d == 0);
	}
	public void testMover_3(){
		this.addDama(4, 4, 'b');
		int d = t.mover('b', 4, 4, 7, 7,"e5", "d4");
		assertTrue(d == 0);
	}
	public void testMover_4(){
		this.addDama(5, 5, 'b');
		int d = t.mover('b', 5, 5, 1, 5,"e5", "e4");
		assertTrue(d == 0);
	}
	public void testMover_5(){
		this.addDama(3, 5, 'b');
		int d = t.mover('b', 3, 5, 6, 5,"e5", "e6");
		assertTrue(d == 0);
	}
	public void testMover_6(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 2, 1,"e5", "f4");
		assertTrue(d == 0);
	}
	public void testMover_7(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 5, 2,"e5", "f5");
		assertTrue(d == 0);
	}
	public void testMover_8(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 7, 2,"e5", "f6");
		assertTrue(d == 0);
	}
	
	
	public void testMover_NoValido(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 5, 4,"e5", "fe5");
		assertTrue(d == -4);
	}
	
	
	
	
	public void testMover_1NV(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 6, 8,"e5", "d5");
		assertTrue(d == -5);
	}
	public void testMover_1NV_2(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 4, 7,"e5", "d5");
		assertTrue(d == -5);
	}
	
	public void testMover_2NV(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 1, 7,"e5", "d6");
		assertTrue(d == -5);
	}
	public void testMover_2NV_2(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 2, 8,"e5", "d6");
		assertTrue(d == -5);
	}
	
	public void testMover_3NV(){
		this.addDama(4, 4, 'b');
		int d = t.mover('b', 4, 4, 7, 6,"e5", "d4");
		assertTrue(d == -5);
	}
	public void testMover_3NV_2(){
		this.addDama(4, 4, 'b');
		int d = t.mover('b', 4, 4, 6, 7,"e5", "d4");
		assertTrue(d == -5);
	}
	
	
	public void testMover_4NV(){
		this.addDama(5, 5, 'b');
		int d = t.mover('b', 5, 5, 1, 4,"e5", "e4");
		assertTrue(d == -5);
	}
	public void testMover_4NV_2(){
		this.addDama(5, 5, 'b');
		int d = t.mover('b', 5, 5, 1, 6,"e5", "e4");
		assertTrue(d == -5);
	}
	
	
	
	public void testMover_5NV(){
		this.addDama(3, 6, 'b');
		int d = t.mover('b', 3, 6, 6, 5,"e5", "e6");
		assertTrue(d == -5);
	}
	public void testMover_5NV_2(){
		this.addDama(3, 6, 'b');
		int d = t.mover('b', 3, 6, 7, 7,"e5", "e6");
		assertTrue(d == -5);
	}
	
	
	
	public void testMover_6NV(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 2, 2,"e5", "f4");
		assertTrue(d == -5);
	}
	public void testMover_6NV_2(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 3, 1,"e5", "f4");
		assertTrue(d == -5);
	}
	
	
	
	public void testMover_7NV(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 4, 1,"e5", "f5");
		assertTrue(d == -5);
	}
	public void testMover_7NV_2(){
		this.addDama(5, 4, 'b');
		int d = t.mover('b', 5, 4, 6, 1,"e5", "f5");
		assertTrue(d == -5);
	}
	
	
	
	public void testMover_8NV(){
		this.addDama(3, 6, 'b');
		int d = t.mover('b', 3, 6, 7, 1,"e5", "f6");
		assertTrue(d == -5);
	}
	public void testMover_8NV_2(){
		this.addDama(2, 7, 'b');
		int d = t.mover('b', 2, 7, 5, 5,"e5", "f6");
		assertTrue(d == -5);
	}
	
	
	
	public void testMover_1bloc(){
		this.addDama(5, 4, 'b');
		this.addPeon(5, 7, 'b');
		int d = t.mover('b', 5, 4, 5, 8,"e5", "d5");
		assertTrue(d == -6);
	}
	public void testMover_2bloc(){
		this.addDama(5, 4, 'b');
		this.addPeon(2, 7, 'b');
		int d = t.mover('b', 5, 4, 1, 8,"e5", "d6");
		assertTrue(d == -6);
	}
	public void testMover_3bloc(){
		this.addDama(4, 4, 'b');
		this.addPeon(5, 5, 'b');
		int d = t.mover('b', 4, 4, 7, 7,"e5", "d4");
		assertTrue(d == -6);
	}
	public void testMover_4bloc(){
		this.addDama(5, 5, 'b');
		this.addPeon(3, 5, 'b');
		int d = t.mover('b', 5, 5, 1, 5,"e5", "e4");
		assertTrue(d == -6);
	}
	public void testMover_5bloc(){
		this.addDama(3, 5, 'b');
		this.addPeon(4, 5, 'b');
		int d = t.mover('b', 3, 5, 6, 5,"e5", "e6");
		assertTrue(d == -6);
	}
	public void testMover_6bloc(){
		this.addDama(5, 4, 'b');
		this.addPeon(3, 2, 'b');
		int d = t.mover('b', 5, 4, 2, 1,"e5", "f4");
		assertTrue(d == -6);
	}
	public void testMover_7bloc(){
		this.addDama(5, 7, 'b');
		this.addPeon(5, 3, 'b');
		int d = t.mover('b', 5, 7, 5, 2,"e5", "f5");
		assertTrue(d == -6);
	}
	public void testMover_8bloc(){
		this.addDama(2, 7, 'b');
		this.addPeon(6, 3, 'b');
		int d = t.mover('b', 2, 7, 7, 2,"e5", "f6");
		assertTrue(d == -6);
	}
	
}
