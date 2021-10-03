package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestGanarPartida extends TestCase {

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
	
	
	public void testGanarLD(){
		this.addRey(5, 8, 'n');
		this.addRey(7, 2, 'b');
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(6, 3, 'b');
		
		int r = t.mover('b', 6, 3, 5, 3, "", "");
		
		assertTrue(r == 20);
		
		
	}
	
	public void testGanarLDN(){
		this.addRey(5, 8, 'b');
		this.addRey(7, 2, 'n');
		
		this.addTorre1(4, 1, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(6, 3, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 3, 5, 3, "", "");
		
		assertTrue(r == 20);
		
		
	}
	
	
	public void testGanarLI(){
		this.addRey(5, 1, 'n');
		this.addRey(7, 8, 'b');
		
		this.addTorre1(4, 8, 'b');
		this.addTorre2(6, 8, 'b');
		this.addDama(6, 7, 'b');
		
		int r = t.mover('b', 6, 7, 5, 7, "", "");
		
		assertTrue(r == 20);
		
		
	}
	
	public void testGanarLIN(){
		this.addRey(5, 1, 'b');
		this.addRey(7, 8, 'n');
		
		this.addTorre1(4, 8, 'n');
		this.addTorre2(6, 8, 'n');
		this.addDama(6, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 7, 5, 7, "", "");
		
		assertTrue(r == 20);
		
		
	}
	
	
	public void testGanarLAr(){
		this.addRey(1, 5, 'n');
		this.addRey(7, 2, 'b');
		
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(7, 7, 'b');
		
		int r = t.mover('b', 7, 7, 7, 5, "", "");
		
		assertTrue(r == 20);
		
		
	}
	
	public void testGanarLArN(){
		this.addRey(1, 5, 'b');
		this.addRey(7, 2, 'n');
		
		this.addTorre1(8, 4, 'n');
		this.addTorre2(8, 6, 'n');
		this.addDama(7, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 7, 7, 5, "", "");
		
		assertTrue(r == 20);
		
		
	}
	
	
	public void testGanarLAb(){
		this.addRey(8, 5, 'n');
		this.addRey(2, 2, 'b');
		
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(2, 7, 'b');
		
		int r = t.mover('b', 2, 7, 2, 5, "", "");
		
		assertTrue(r == 20);
		
		
	}
	
	public void testGanarLAbN(){
		this.addRey(8, 5, 'b');
		this.addRey(2, 2, 'n');
		
		this.addTorre1(1, 4, 'n');
		this.addTorre2(1, 6, 'n');
		this.addDama(2, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 2, 7, 2, 5, "", "");
		
		assertTrue(r == 20);
		
		
	}
	
	
	/*****************Casi haque mate******************/
	
	public void testNoGanarLD(){
		this.addRey(5, 7, 'n');
		this.addRey(7, 2, 'b');
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 6, 'b');
		this.addAlfil1(2, 2, 'b');
		
		int r = t.mover('b', 2, 2, 1, 3, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLDN(){
		this.addRey(5, 7, 'b');
		this.addRey(7, 2, 'n');
		
		this.addTorre1(4, 1, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(1, 6, 'n');
		this.addAlfil1(2, 2, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 2, 2, 1, 3, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	
	public void testNoGanarLI(){
		this.addRey(5, 2, 'n');
		this.addRey(7, 8, 'b');
		
		this.addTorre1(4, 8, 'b');
		this.addTorre2(6, 8, 'b');
		this.addDama(1, 3, 'b');
		this.addAlfil1(2, 7, 'b');
		
		int r = t.mover('b', 2, 7, 1, 6, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLIN(){
		this.addRey(5, 2, 'b');
		this.addRey(7, 8, 'n');
		
		this.addTorre1(4, 8, 'n');
		this.addTorre2(6, 8, 'n');
		this.addDama(1, 3, 'n');
		this.addAlfil1(2, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 2, 7, 1, 6, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	
	public void testNoGanarLAr(){
		this.addRey(2, 5, 'n');
		this.addRey(7, 8, 'b');
		
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(3, 1, 'b');
		this.addAlfil1(6, 7, 'b');
		
		int r = t.mover('b', 6, 7, 5, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLArN(){
		this.addRey(2, 5, 'b');
		this.addRey(7, 8, 'n');
		
		this.addTorre1(8, 4, 'n');
		this.addTorre2(8, 6, 'n');
		this.addDama(3, 1, 'n');
		this.addAlfil1(6, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 7, 5, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	public void testNoGanarLAb(){
		this.addRey(7, 5, 'n');
		this.addRey(2, 8, 'b');
		
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(6, 1, 'b');
		this.addAlfil1(3, 7, 'b');
		
		int r = t.mover('b', 3, 7, 4, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLAbN(){
		this.addRey(7, 5, 'b');
		this.addRey(2, 8, 'n');
		
		this.addTorre1(1, 4, 'n');
		this.addTorre2(1, 6, 'n');
		this.addDama(6, 1, 'n');
		this.addAlfil1(3, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 3, 7, 4, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	
	
	
	
	/*************Casi jaque esquina***/
	
	public void testNoGanarLDAr(){
		this.addRey(5, 7, 'n');
		this.addRey(7, 2, 'b');
		
		this.addDama(6, 5, 'b');
		this.addAlfil1(1, 4, 'b');
		this.addAlfil2(2, 2, 'b');
		
		int r = t.mover('b', 2, 2, 1, 3, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLDNAr(){
		this.addRey(5, 7, 'b');
		this.addRey(7, 2, 'n');
		
		this.addDama(6, 5, 'n');
		this.addAlfil1(1, 4, 'n');
		this.addAlfil2(2, 2, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 2, 2, 1, 3, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLDAb(){
		this.addRey(5, 7, 'n');
		this.addRey(7, 2, 'b');
		
		this.addDama(4, 5, 'b');
		this.addAlfil1(8, 5, 'b');
		this.addAlfil2(7, 3, 'b');
		
		int r = t.mover('b', 7, 3, 8, 4, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLDNAb(){
		this.addRey(5, 7, 'b');
		this.addRey(7, 2, 'n');
		
		this.addDama(4, 5, 'n');
		this.addAlfil1(8, 5, 'n');
		this.addAlfil2(7, 3, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 3, 8, 4, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	
	  public void testNoGanarLIAr(){
	 
		this.addRey(5, 2, 'n');
		this.addRey(7, 8, 'b');
		
		
		this.addDama(6, 4, 'b');
		this.addAlfil2(1, 5, 'b');
		this.addAlfil1(2, 7, 'b');
		
		int r = t.mover('b', 2, 7, 1, 6, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLIArN(){
		this.addRey(5, 2, 'b');
		this.addRey(7, 8, 'n');
		
		
		this.addDama(6, 4, 'n');
		this.addAlfil2(1, 5, 'n');
		this.addAlfil1(2, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 2, 7, 1, 6, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	 public void testNoGanarLIAb(){
		 
			this.addRey(5, 2, 'n');
			this.addRey(7, 8, 'b');
			
			
			this.addDama(4, 4, 'b');
			this.addAlfil2(8, 4, 'b');
			this.addAlfil1(7, 6, 'b');
			
			int r = t.mover('b', 7, 6, 8, 5, "", "");
			
			assertTrue(r == 10);
			
			
		}
		public void testNoGanarLIAbN(){
			this.addRey(5, 2, 'b');
			this.addRey(7, 8, 'n');
			
			
			this.addDama(4, 4, 'n');
			this.addAlfil2(8, 4, 'n');
			this.addAlfil1(7, 6, 'n');
			
			t.setColorDelJugadorConElTurno('n');
			int r = t.mover('n', 7, 6, 8, 5, "", "");
			
			assertTrue(r == 10);
			
			
		}
	
	
	public void testNoGanarLArI(){
		this.addRey(2, 5, 'n');
		this.addRey(7, 8, 'b');
		
		this.addDama(4, 6, 'b');
		this.addAlfil1(5, 1, 'b');
		this.addAlfil2(7, 2, 'b');
		
		int r = t.mover('b', 7, 2, 6, 1, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLArIN(){
		this.addRey(2, 5, 'b');
		this.addRey(7, 8, 'n');
		
		this.addDama(4, 6, 'n');
		this.addAlfil1(5, 1, 'n');
		this.addAlfil2(7, 2, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 2, 6, 1, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	public void testNoGanarLArD(){
		this.addRey(2, 5, 'n');
		this.addRey(7, 8, 'b');
		
		this.addDama(4, 4, 'b');
		this.addAlfil1(4, 8, 'b');
		this.addAlfil2(6, 7, 'b');
		
		int r = t.mover('b', 6, 7, 5, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLArDN(){
		this.addRey(2, 5, 'b');
		this.addRey(7, 8, 'n');
		
		this.addDama(4, 4, 'n');
		this.addAlfil1(4, 8, 'n');
		this.addAlfil2(6, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 7, 5, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	public void testNoGanarLAbI(){
		this.addRey(7, 5, 'n');
		this.addRey(2, 8, 'b');
		
		this.addDama(5, 6, 'b');
		this.addAlfil1(5, 8, 'b');
		this.addAlfil2(3, 7, 'b');
		
		
		int r = t.mover('b', 3, 7, 4, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLAbIN(){
		this.addRey(7, 5, 'b');
		this.addRey(2, 8, 'n');
		
		this.addDama(5, 6, 'n');
		this.addAlfil1(5, 8, 'n');
		this.addAlfil2(3, 7, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 3, 7, 4, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	public void testNoGanarLAbD(){
		this.addRey(7, 5, 'n');
		this.addRey(2, 8, 'b');
		
		this.addDama(5, 4, 'b');
		this.addAlfil1(5, 8, 'b');
		this.addAlfil2(3, 7, 'b');
		
		
		int r = t.mover('b', 3, 7, 4, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	public void testNoGanarLAbDN(){
		this.addRey(7, 5, 'b');
		this.addRey(2, 8, 'n');
		
		this.addDama(5, 4, 'n');
		this.addAlfil1(5, 8, 'n');
		this.addAlfil2(3, 7, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 3, 7, 4, 8, "", "");
		
		assertTrue(r == 10);
		
		
	}
	
	
	/********************Ganar bloqueado con fichas**********************/
	
	
	public void testBlockAr(){
		this.addRey(2, 5, 'n');
		this.addRey(7, 7, 'b');
		
		this.addPeon(1, 5, 'n', 1);
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(3, 8, 'b');
		this.addAlfil1(6, 7, 'b');
		
		int r = t.mover('b', 6, 7, 5, 8, "", "");
		assertTrue(r == 20);
		
		
	}
	public void testNoBlockAr(){
		this.addRey(2, 5, 'n');
		this.addRey(7, 7, 'b');
		
		this.addPeon(1, 5, 'b', 1);
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(3, 8, 'b');
		this.addAlfil1(6, 7, 'b');
		
		int r = t.mover('b', 6, 7, 5, 8, "", "");
		assertTrue(r == 10);
		
		
	}
	
	public void testBlockArN(){
		this.addRey(2, 5, 'b');
		this.addRey(7, 7, 'n');
		
		this.addPeon(1, 5, 'b', 1);
		this.addTorre1(8, 4, 'n');
		this.addTorre2(8, 6, 'n');
		this.addDama(3, 8, 'n');
		this.addAlfil1(6, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 7, 5, 8, "", "");
		assertTrue(r == 20);
		
		
	}
	public void testNoBlockArN(){
		this.addRey(2, 5, 'b');
		this.addRey(7, 7, 'n');
		
		this.addPeon(1, 5, 'n', 1);
		this.addTorre1(8, 4, 'n');
		this.addTorre2(8, 6, 'n');
		this.addDama(3, 8, 'n');
		this.addAlfil1(6, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 7, 5, 8, "", "");
		assertTrue(r == 10);
		
		
	}
	
	
	public void testBlockAb(){
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(6, 5, 'n', 1);
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(4, 1, 'b');
		this.addAlfil1(1, 7, 'b');
		
		int r = t.mover('b', 1, 7, 2, 8, "", "");
		assertTrue(r == 20);
		
		
	}
	public void testNoBlockAb(){
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(6, 5, 'b', 1);
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(4, 1, 'b');
		this.addAlfil1(1, 7, 'b');
		
		int r = t.mover('b', 1, 7, 2, 8, "", "");
		assertTrue(r == 10);
		
		
	}
	
	public void testBlockAbN(){
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(6, 5, 'b', 1);
		this.addTorre1(8, 4, 'n');
		this.addTorre2(8, 6, 'n');
		this.addDama(4, 1, 'n');
		this.addAlfil1(1, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 7, 2, 8, "", "");
		assertTrue(r == 20);
		
		
	}
	public void testNoBlockAbN(){
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(6, 5, 'n', 1);
		this.addTorre1(8, 4, 'n');
		this.addTorre2(8, 6, 'n');
		this.addDama(4, 1, 'n');
		this.addAlfil1(1, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 7, 2, 8, "", "");
		assertTrue(r == 10);
		
		
	}
	
	
	/****DErecha****/
	
	public void testBlockD(){
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(5, 4, 'n', 1);
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 6, 'b');
		this.addAlfil1(1, 7, 'b');
		
		int r = t.mover('b', 1, 7, 2, 8, "", "");
		assertTrue(r == 20);
		
		
	}
	public void testNoBlockD(){
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(5, 4, 'b', 1);
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 6, 'b');
		this.addAlfil1(1, 7, 'b');
		
		int r = t.mover('b', 1, 7, 2, 8, "", "");
		assertTrue(r == 10);
		
		
	}
	
	public void testBlockDN(){
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(5, 4, 'b', 1);
		this.addTorre1(4, 1, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(1, 6, 'n');
		this.addAlfil1(1, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 7, 2, 8, "", "");
		assertTrue(r == 20);
		
		
	}
	public void testNoBlockDN(){
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(5, 4, 'n', 1);
		this.addTorre1(4, 1, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(1, 6, 'n');
		this.addAlfil1(1, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 7, 2, 8, "", "");
		assertTrue(r == 10);
		
		
	}
	
	
	/***Izquierda*******/
	
	
	public void testBlockI(){
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addAlfil1(5, 6, 'n');
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 4, 'b');
		this.addAlfil1(1, 7, 'b');
		
		int r = t.mover('b', 1, 7, 2, 8, "", "");
		assertTrue(r == 20);
		
		
	}
	public void testNoBlockI(){
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(5, 6, 'b', 1);
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 4, 'b');
		this.addAlfil1(1, 7, 'b');
		
		int r = t.mover('b', 1, 7, 2, 8, "", "");
		assertTrue(r == 10);
		
		
	}
	
	public void testBlockIN(){
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(5, 6, 'b', 1);
		this.addTorre1(4, 1, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(1, 4, 'n');
		this.addAlfil1(1, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 7, 2, 8, "", "");
		assertTrue(r == 20);
		
		
	}
	public void testNoBlockIN(){
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(5, 6, 'n', 1);
		this.addTorre1(4, 1, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(1, 4, 'n');
		this.addAlfil1(1, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 7, 2, 8, "", "");
		assertTrue(r == 10);
		
		
	}
	
	/***************TestGanarColores******************/
	
	public void testSICasiGana(){
		
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(4, 4, 'b', 1);
		
		this.addTorre1(1, 6, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(7, 8, 'n');
		this.addAlfil1(1, 8, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 8, 5, 8, "", "");
		assertTrue(r == 20);
		
	}
	public void testSICasiGanaN(){
		
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(4, 4, 'n', 1);
		
		this.addTorre1(1, 6, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(7, 8, 'b');
		this.addAlfil1(1, 8, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 7, 8, 5, 8, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testICasiGana(){
		
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(5, 4, 'b', 1);
		
		this.addTorre1(4, 1, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(8, 6, 'n');
		this.addAlfil1(6, 8, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 8, 7, 7, "", "");
		assertTrue(r == 20);
		
	}
	public void testICasiGanaN(){
		

		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(5, 4, 'n', 1);
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(8, 6, 'b');
		this.addAlfil1(6, 8, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 6, 8, 7, 7, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testAbICasiGana(){
		
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(6, 4, 'b', 1);
		
		this.addTorre1(4, 1, 'n');
		this.addTorre2(1, 6, 'n');
		this.addDama(1, 2, 'n');
		this.addAlfil1(8, 7, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 2, 1, 1, "", "");
		assertTrue(r == 20);
		
	}
	public void testAbICasiGanaN(){
		

		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(6, 4, 'n', 1);
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(1, 2, 'b');
		this.addAlfil1(8, 7, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 1, 2, 1, 1, "", "");
		assertTrue(r == 20);
		
	}
	
	
	public void testArDCasiGana(){
		
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(4, 6, 'b', 1);
		
		this.addTorre1(1, 4, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(7, 8, 'n');
		this.addAlfil1(1, 2, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 8, 7, 7, "", "");
		assertTrue(r == 20);
		
	}
	public void testArDCasiGanaN(){
		
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(4, 6, 'n', 1);
		
		this.addTorre1(1, 4, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(7, 8, 'b');
		this.addAlfil1(1, 2, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 7, 8, 5, 8, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testDCasiGana(){
		
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(5, 6, 'b', 1);
		
		this.addTorre1(4, 1, 'n');
		this.addTorre2(6, 1, 'n');
		this.addDama(8, 4, 'n');
		this.addAlfil1(6, 2, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 2, 7, 3, "", "");
		assertTrue(r == 20);
		
	}
	public void testDCasiGanaN(){
		

		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(5, 6, 'n', 1);
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(8, 4, 'b');
		this.addAlfil1(6, 8, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 6, 8, 7, 7, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testAbDCasiGana(){
		
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(6, 6, 'b', 1);
		
		this.addTorre1(4, 1, 'n');
		this.addTorre2(1, 4, 'n');
		this.addDama(8, 1, 'n');
		this.addAlfil1(8, 3, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 1, 8, 2, "", "");
		assertTrue(r == 20);
		
	}
	public void testAbDCasiGanaN(){
		

		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(6, 6, 'n', 1);
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(1, 4, 'b');
		this.addDama(8, 1, 'b');
		this.addAlfil1(8, 3, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 8, 1, 8, 2, "", "");
		assertTrue(r == 20);
		
	}
	
	
	
	public void testArCasiGana(){
		
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(4, 5, 'b', 1);
		
		this.addTorre1(1, 4, 'n');
		this.addTorre2(1, 6, 'n');
		this.addDama(6, 1, 'n');
		this.addAlfil1(6, 2, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 2, 7, 3, "", "");
		assertTrue(r == 20);
		
	}
	public void testArCasiGanaN(){
		

		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(4, 5, 'n', 1);
		
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(6, 1, 'b');
		this.addAlfil1(6, 8, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 6, 8, 7, 7, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testAbCasiGana(){
		
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		
		this.addPeon(6, 5, 'b', 1);
		
		this.addTorre1(1, 4, 'n');
		this.addTorre2(1, 6, 'n');
		this.addDama(4, 1, 'n');
		this.addAlfil1(6, 2, 'n');
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 6, 2, 7, 3, "", "");
		assertTrue(r == 20);
		
	}
	public void testAbCasiGanaN(){
		

		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addPeon(6, 5, 'n', 1);
		
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(4, 1, 'b');
		this.addAlfil1(6, 8, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 6, 8, 7, 7, "", "");
		assertTrue(r == 20);
		
	}
	
	
	/******************Salvarse laterales************/
	
	public void testsalvareLateralI(){
		this.addRey(5, 2, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(4, 8, 'b');
		this.addTorre2(6, 8, 'b');
		this.addDama(1, 3, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 1, 3, 1, 2, "", "");
		assertTrue(r == 10);
	}
	
	public void testsalvareLateralD(){
		this.addRey(5, 7, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 3, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 1, 3, 1, 7, "", "");
		assertTrue(r == 10);
	}
	
	public void testsalvareLateralAr(){
		this.addRey(2, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(3, 2, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 3, 2, 2, 2, "", "");
		assertTrue(r == 10);
	}
	
	public void testsalvareLateralAb(){
		this.addRey(7, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(3, 2, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 3, 2, 7, 2, "", "");
		assertTrue(r == 10);
	}
	
	
	
	public void testsalvareLateralIAr(){
		this.addRey(5, 2, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(4, 8, 'b');
		this.addTorre2(6, 8, 'b');
		this.addDama(1, 3, 'b');
		this.addAlfil1(8, 6, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 4, 8, 5, 8, "", "");
		assertTrue(r == 10);
	}
	public void testsalvareLateralIAb(){
		this.addRey(5, 2, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(4, 8, 'b');
		this.addTorre2(6, 8, 'b');
		this.addDama(1, 3, 'b');
		this.addAlfil1(8, 4, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 6, 8, 5, 8, "", "");
		assertTrue(r == 10);
	}
	
	public void testsalvareLateralDAr(){
		this.addRey(5, 7, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 6, 'b');
		this.addAlfil1(1, 4, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 4, 1, 5, 1, "", "");
		assertTrue(r == 10);
	}
	public void testsalvareLateralDAb(){
		this.addRey(5, 7, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 6, 'b');
		this.addAlfil1(8, 5, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 6, 1, 5, 1, "", "");
		assertTrue(r == 10);
	}
	
	public void testsalvareLateralArD(){
		this.addRey(2, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(3, 1, 'b');
		this.addAlfil1(4, 8, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 8, 6, 8, 5, "", "");
		assertTrue(r == 10);
	}
	public void testsalvareLateralArI(){
		this.addRey(2, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(3, 1, 'b');
		this.addAlfil1(5, 1, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 8, 4, 8, 5, "", "");
		assertTrue(r == 10);
	}
	
	public void testsalvareLateralAbI(){
		this.addRey(7, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(6, 1, 'b');
		this.addAlfil1(4, 1, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 1, 4, 1, 5, "", "");
		assertTrue(r == 10);
	}
	
	public void testsalvareLateralAbD(){
		this.addRey(7, 5, 'n');
		this.addRey(8, 8, 'b');
		
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(6, 1, 'b');
		this.addAlfil1(5, 8, 'b');
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 1, 6, 1, 5, "", "");
		assertTrue(r == 10);
	}
	
	
	/*********Test caombertir peon no haque**************/
	
	public void testCasiGanaCombertirPeon(){
		this.addRey(7, 6, 'n');
		this.addRey(1, 8, 'b');
		this.addDama(3, 4, 'n');
		
		this.addTorre1(1, 7, 'b');
		this.addTorre2(1, 5, 'b');
		this.addDama(6, 1, 'b');
		this.addPeon(7, 3, 'b',1);
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 7, 3, 8, 3, "", "");
		r = t.convertirPeon('d');
		assertTrue(0==r);
	}
	
	/*****/
	public void testDobleHaquePiezaSalva(){
		
		this.addRey(8, 8, 'n');
		this.addRey(1, 8, 'b');
		this.addDama(3, 4, 'n');
		
		this.addTorre1(8, 4, 'b');
		this.addTorre2(7, 1, 'b');
		this.addDama(2, 1, 'b');
		
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 2, 1, 2, 8, "", "");
		assertTrue(r==20);
	}
	
	public void testDobleHaquePiezaSalva2(){
		
		this.addRey(8, 8, 'n');
		this.addRey(1, 8, 'b');
		this.addDama(4, 6, 'n');
		
		this.addTorre1(8, 4, 'b');
		this.addTorre2(7, 1, 'b');
		this.addDama(2, 1, 'b');
		
		
		t.setColorDelJugadorConElTurno('b');
		int r = t.mover('b', 2, 1, 2, 8, "", "");
		assertTrue(r==20);
	}
}
