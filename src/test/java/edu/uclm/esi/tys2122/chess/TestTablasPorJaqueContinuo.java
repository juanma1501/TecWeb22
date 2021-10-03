package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestTablasPorJaqueContinuo extends TestCase {

	private Tablero t;
	private Jugador ja, jb;
	
	protected void setUp(){
		ja=new Jugador("ja", "");
		jb=new Jugador("jb", "");
		t = new Tablero(1, ja, jb);
		Pieza[][] tablero = t.getTablero();
		for(int i = 0;i<tablero.length;i++){
			for(int j = 0;j<tablero[i].length;j++){
				tablero[i][j] = null;
			}
		}
		
		Pieza[] pb = t.getBlancas();
		for(int i = 0;i<pb.length;i++){
			pb[i] = null;
		}
		
		
		Pieza[] pn = t.getNegras();
		for(int i = 0;i<pn.length;i++){
			pn[i] = null;
		}
	}
	
	
	protected Peon addPeon(int fila, int colum, char color, int numero){
		Peon p = new Peon(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		
		if(color == 'b'){
			t.getBlancas()[numero] = p;
			
		}else{
			t.getNegras()[numero] = p;
		}
		return p;
	}
	
	protected Torre addTorre1(int fila, int colum, char color){
		Torre p = new Torre(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnTorre1] = p;
		}else{
			t.getNegras()[Tablero.fnTorre1] = p;
		}
		return p;
	}
	protected Torre addTorre2(int fila, int colum, char color){
		Torre p = new Torre(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnTorre2] = p;
		}else{
			t.getNegras()[Tablero.fnTorre2] = p;
		}
		return p;
	}
	
	protected Caballo addCaballo1(int fila, int colum, char color){
		Caballo p = new Caballo(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnCaballo1] = p;
		}else{
			t.getNegras()[Tablero.fnCaballo1] = p;
		}
		return p;
	}
	protected Caballo addCaballo2(int fila, int colum, char color){
		Caballo p = new Caballo(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnCaballo2] = p;
		}else{
			t.getNegras()[Tablero.fnCaballo2] = p;
		}
		return p;
	}
	
	protected Alfil addAlfil1(int fila, int colum, char color){
		Alfil p = new Alfil(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnAlfil1] = p;
		}else{
			t.getNegras()[Tablero.fnAlfil1] = p;
		}
		return p;
	}
	protected Alfil addAlfil2(int fila, int colum, char color){
		Alfil p = new Alfil(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnAlfil2] = p;
		}else{
			t.getNegras()[Tablero.fnAlfil2] = p;
		}
		return p;
	}
	
	protected Dama addDama(int fila, int colum, char color){
		Dama p = new Dama(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnDama] = p;
		}else{
			t.getNegras()[Tablero.fnDama] = p;
		}
		return p;
	}
	
	protected Rey addRey(int fila, int colum, char color){
		Rey p = new Rey(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnRey] = p;
		}else{
			t.getNegras()[Tablero.fnRey] = p;
		}
		return p;
	}
	
	
	
	
	public void testtablasJaqueContinuo(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(4, 2, 'b');
		
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.almacenarMovimiento("g4-g5");
		t.mover('n', 5, 5, 4, 5, "d5", "d4");
		t.almacenarMovimiento("d5-d4");
		t.mover('b', 5, 2, 4, 2, "g5", "g4");
		t.almacenarMovimiento("g5-g4");
		t.mover('n', 4, 5, 5, 5, "d4", "d5");
		t.almacenarMovimiento("d4-d5");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.almacenarMovimiento("g4-g5");
		t.mover('n', 5, 5, 4, 5, "d5", "d4");
		t.almacenarMovimiento("d5-d4");
		t.mover('b', 5, 2, 4, 2, "g5", "g4");
		t.almacenarMovimiento("g5-g4");
		t.mover('n', 4, 5, 5, 5, "d4", "d5");
		t.almacenarMovimiento("d4-d5");
		t.mover('b', 4, 2, 5, 2, "g4", "g5");
		t.almacenarMovimiento("g4-g5");
		t.mover('n', 5, 5, 4, 5, "d5", "d4");
		t.almacenarMovimiento("d5-d4");
		t.mover('b', 5, 2, 4, 2, "g5", "g4");
		t.almacenarMovimiento("g5-g4");
		int r = t.mover('n', 4, 5, 5, 5, "d4", "d5");
		
		assertTrue(r == 30);
		
		
		
	}
	
	
	public void testNotablasJaqueContinuo_1(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_2(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_3(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_4(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_5(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_6(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_7(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_8(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_9(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_10(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	public void testNotablasJaqueContinuo_11(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
	
	
	public void testTablasLargaLista(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		
		t.almacenarMovimiento("d1-d5");
		t.almacenarMovimiento("d2-d5");
		t.almacenarMovimiento("d3-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d5-d5");
		t.almacenarMovimiento("d6-d5");
		t.almacenarMovimiento("d7-d5");
		t.almacenarMovimiento("d8-d5");
		t.almacenarMovimiento("d4-d1");
		t.almacenarMovimiento("d4-d2");
		t.almacenarMovimiento("d4-d3");
		
		
		t.almacenarMovimiento("d1-d4");
		t.almacenarMovimiento("d2-d6");
		t.almacenarMovimiento("d3-d7");
		t.almacenarMovimiento("d4-d8");
		t.almacenarMovimiento("a5-d5");
		t.almacenarMovimiento("b6-d5");
		t.almacenarMovimiento("c7-d5");
		t.almacenarMovimiento("e8-d5");
		t.almacenarMovimiento("f4-d1");
		t.almacenarMovimiento("g4-d2");
		t.almacenarMovimiento("h4-d3");
		
		t.almacenarMovimiento("d1-a4");
		t.almacenarMovimiento("d2-b6");
		t.almacenarMovimiento("d3-c7");
		t.almacenarMovimiento("d4-e8");
		t.almacenarMovimiento("a5-f5");
		t.almacenarMovimiento("b6-g5");
		t.almacenarMovimiento("c7-h5");
		t.almacenarMovimiento("e8-a5");
		t.almacenarMovimiento("f4-b1");
		t.almacenarMovimiento("g4-c2");
		t.almacenarMovimiento("h4-e3");
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 30);
	}
	
	
	
	public void testNotablasJaqueContinuo_8Especial(){
		this.addRey(8, 8, 'b');
		this.addRey(3, 3,'n');
		this.addTorre1(4, 5, 'b');
		
		
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d6");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		t.almacenarMovimiento("d4-d5");
		
		int r = t.mover('b', 4, 5, 5, 5, "d4", "d5");
		assertTrue(r == 0);
		
	}
}
