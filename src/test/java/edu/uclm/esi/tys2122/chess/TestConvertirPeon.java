package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestConvertirPeon extends TestCase {

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
	
	
	/*********************** Test convertir peones********************/
	
	public void testC1D(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 1, 'b', 1);
		t.mover('b', 7, 1, 8, 1, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	
	public void testC2D(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 2, 'b', 2);
		t.mover('b', 7, 2, 8, 2, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC3D(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 3, 'b', 3);
		t.mover('b', 7, 3, 8, 3, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC4D(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 4, 'b', 4);
		t.mover('b', 7, 4, 8, 4, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC5D(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 5, 'b', 5);
		t.mover('b', 7, 5, 8, 5, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC6D(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 6, 'b', 6);
		t.mover('b', 7, 6, 8, 6, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC7D(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 7, 'b', 7);
		t.mover('b', 7, 7, 8, 7, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC8D(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 8, 'b', 0);
		t.mover('b', 7, 8, 8, 8, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	
/*********************** Test Torres convertir peones********************/
	
	public void testC1t(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 1, 'b', 1);
		t.mover('b', 7, 1, 8, 1, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	
	public void testC2t(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 2, 'b', 1);
		t.mover('b', 7, 2, 8, 2, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC3t(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 3, 'b', 1);
		t.mover('b', 7, 3, 8, 3, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC4t(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 4, 'b', 1);
		t.mover('b', 7, 4, 8, 4, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC5t(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 5, 'b', 1);
		t.mover('b', 7, 5, 8, 5, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC6t(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 6, 'b', 1);
		t.mover('b', 7, 6, 8, 6, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC7t(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 7, 'b', 1);
		t.mover('b', 7, 7, 8, 7, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC8t(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 8, 'b', 1);
		t.mover('b', 7, 8, 8, 8, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	
	
/*********************** Test Alfiles convertir peones********************/
	
	public void testC1a(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 1, 'b', 1);
		t.mover('b', 7, 1, 8, 1, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	
	public void testC2a(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 2, 'b', 1);
		t.mover('b', 7, 2, 8, 2, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC3a(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 3, 'b', 1);
		t.mover('b', 7, 3, 8, 3, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC4a(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 4, 'b', 1);
		t.mover('b', 7, 4, 8, 4, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC5a(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 5, 'b', 1);
		t.mover('b', 7, 5, 8, 5, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC6a(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 6, 'b', 1);
		t.mover('b', 7, 6, 8, 6, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC7a(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(7, 7, 'b', 1);
		t.mover('b', 7, 7, 8, 7, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC8a(){
		this.addRey(3, 3, 'b');
		this.addRey(6, 5, 'n');
		
		this.addPeon(7, 8, 'b', 1);
		t.mover('b', 7, 8, 8, 8, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	
	
/*********************** Test Caballo convertir peones********************/
	
	public void testC1c(){
		this.addRey(3, 3, 'b');
		this.addRey(5, 6, 'n');
		
		this.addPeon(7, 1, 'b', 1);
		t.mover('b', 7, 1, 8, 1, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	
	public void testC2c(){
		this.addRey(3, 3, 'b');
		this.addRey(5, 6, 'n');
		
		this.addPeon(7, 2, 'b', 1);
		t.mover('b', 7, 2, 8, 2, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC3c(){
		this.addRey(3, 3, 'b');
		this.addRey(5, 6, 'n');
		
		this.addPeon(7, 3, 'b', 1);
		t.mover('b', 7, 3, 8, 3, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC4c(){
		this.addRey(3, 3, 'b');
		this.addRey(5, 5, 'n');
		
		this.addPeon(7, 4, 'b', 1);
		t.mover('b', 7, 4, 8, 4, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC5c(){
		this.addRey(3, 3, 'b');
		this.addRey(5, 6, 'n');
		
		this.addPeon(7, 5, 'b', 1);
		t.mover('b', 7, 5, 8, 5, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC6c(){
		this.addRey(3, 3, 'b');
		this.addRey(5, 5, 'n');
		
		this.addPeon(7, 6, 'b', 1);
		t.mover('b', 7, 6, 8, 6, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC7c(){
		this.addRey(3, 3, 'b');
		this.addRey(5, 6, 'n');
		
		this.addPeon(7, 7, 'b', 1);
		t.mover('b', 7, 7, 8, 7, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC8c(){
		this.addRey(3, 3, 'b');
		this.addRey(5, 5, 'n');
		
		this.addPeon(7, 8, 'b', 1);
		t.mover('b', 7, 8, 8, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	
	
	
	
	/************************AHora negras********/
	
	public void testC1DN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 1, 'n', 0);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 1, 1, 1, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC2DN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 2, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 2, 1, 2, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC3DN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 3, 'n', 2);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 3, 1, 3, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC4DN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 4, 'n', 3);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 4, 1, 4, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC5DN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 5, 'n', 4);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 5, 1, 5, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC6DN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 5, 'b');
		
		this.addPeon(2, 6, 'n', 5);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 6, 1, 6, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC7DN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 7, 'n', 6);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 7, 1, 7, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	public void testC8DN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 8, 'n', 7);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 8, 1, 8, "", "");
		int r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	
	
/************************AHora negrasTorre********/
	
	public void testC1tN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 1, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 1, 1, 1, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC2tN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 2, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 2, 1, 2, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC3tN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 3, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 3, 1, 3, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC4tN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 4, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 4, 1, 4, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC5tN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 5, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 5, 1, 5, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC6tN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 5, 'b');
		
		this.addPeon(2, 6, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 6, 1, 6, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC7tN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 7, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 7, 1, 7, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	public void testC8tN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 8, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 8, 1, 8, "", "");
		int r = t.convertirPeon('t');
		assertTrue(0==r);
	}
	
	
/************************AHora negrasAlfil********/
	
	public void testC1aN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 1, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 1, 1, 1, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC2aN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 2, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 2, 1, 2, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC3aN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 3, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 3, 1, 3, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC4aN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 4, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 4, 1, 4, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC5aN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 5, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 5, 1, 5, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC6aN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 5, 'b');
		
		this.addPeon(2, 6, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 6, 1, 6, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC7aN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 7, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 7, 1, 7, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	public void testC8aN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 8, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 8, 1, 8, "", "");
		int r = t.convertirPeon('a');
		assertTrue(0==r);
	}
	
	
/************************AHora negrasCaballo********/
	
	public void testC1cN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 1, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 1, 1, 1, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC2cN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 2, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 2, 1, 2, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC3cN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 3, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 3, 1, 3, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC4cN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 4, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 4, 1, 4, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC5cN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 5, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 5, 1, 5, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC6cN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 5, 'b');
		
		this.addPeon(2, 6, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 6, 1, 6, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC7cN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 7, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 7, 1, 7, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	public void testC8cN(){
		this.addRey(3, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(2, 8, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 8, 1, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	
	
	
	/********************Dejar en jaque********************/
	
	public void testC8cNDH(){
		this.addRey(3, 3, 'n');
		this.addRey(3, 7, 'b');
		
		this.addPeon(2, 8, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 8, 1, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(1==r);
	}
	
	
/********************Dejar en tablas********************/
	
	public void testC8cNDT(){
		this.addRey(3, 3, 'n');
		this.addRey(3, 8, 'b');
		this.addTorre1(2, 1, 'n');
		this.addTorre1(4, 1, 'n');
		
		this.addPeon(2, 8, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 8, 1, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(3==r);
	}
	
/********************Dejar en ganar********************/
	
	public void testC8cNG(){
		this.addRey(3, 3, 'n');
		this.addRey(3, 7, 'b');
		this.addTorre1(2, 1, 'n');
		this.addTorre1(4, 1, 'n');
		this.addDama(5, 8, 'n');
		
		this.addPeon(2, 8, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 2, 8, 1, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(2==r);
	}
	
	
	
	/******Casi convertido***********/
	public void testNoVale(){
		this.addRey(7, 3, 'n');
		this.addRey(6, 6, 'b');
		
		this.addPeon(3, 8, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 3, 8, 2, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	
	public void testNoValeB(){
		this.addRey(7, 3, 'b');
		this.addRey(6, 6, 'n');
		
		this.addPeon(6, 8, 'b', 1);
		
		t.mover('b', 6, 8, 7, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	
	
	
	/**************Cosas que pasan*********/
	
	public void testNoValeTorre(){
		this.addRey(7, 3, 'n');
		this.addRey(6, 6, 'b');
		this.addTorre1(1, 2, 'n');
		
		this.addPeon(3, 8, 'n', 1);
		t.setColorDelJugadorConElTurno('n');
		t.mover('n', 3, 8, 2, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	
	}
	
	public void testNoValeBTorre(){
		this.addRey(7, 3, 'b');
		this.addRey(6, 6, 'n');
		this.addTorre1(8, 2, 'b');
		this.addPeon(6, 8, 'b', 1);
		
		t.mover('b', 6, 8, 7, 8, "", "");
		int r = t.convertirPeon('c');
		assertTrue(0==r);
	}
	
	
}
