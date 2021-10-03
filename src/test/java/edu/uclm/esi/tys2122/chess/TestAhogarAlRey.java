package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestAhogarAlRey extends TestCase {

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
	
	
	public void testResyAhogadoSinFichasB(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(5, 7, 'b');
		this.addTorre2(5, 5, 'b');
		this.addDama(4, 4, 'b');
		this.addAlfil1(4, 2, 'b');
		int r = t.mover('b', 4, 2, 1, 5, "g4", "d5");
		assertTrue(r == 30 );
	}
	
	public void testResyAhogadoSinFichasN(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(5, 7, 'n');
		this.addTorre2(5, 5, 'n');
		this.addDama(4, 4, 'n');
		this.addAlfil1(4, 2, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 4, 2, 1, 5, "g4", "d5");
		assertTrue(r == 30 );
	}
	
	public void testReyAhogadoConAlfilB(){
		this.addRey(7, 2, 'b');
		this.addRey(8, 6, 'n');
		this.addTorre1(1, 7, 'b');
		this.addTorre2(8, 3, 'b');
		this.addDama(5, 1, 'b');
		this.addAlfil1(8, 5, 'n');
		
		int r = t.mover('b', 5, 1, 7, 3, "h4", "f3");
		assertTrue(r == 30 );
	}
	public void testReyAhogadoConAlfilN(){
		this.addRey(7, 2, 'n');
		this.addRey(8, 6, 'b');
		this.addTorre1(1, 7, 'n');
		this.addTorre2(8, 3, 'n');
		this.addDama(5, 1, 'n');
		this.addAlfil1(8, 5, 'b');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 4, 2, 1, 5, "g4", "d5");
		assertTrue(r == 30 );
	}
	
	public void testReyAhogadoConPeonB(){
		this.addRey(7, 2, 'b');
		this.addRey(5, 8, 'n');
		this.addTorre1(5, 3, 'b');
		this.addTorre2(6, 3, 'b');
		this.addDama(5, 2, 'b');
		this.addPeon(5, 7, 'n',1);
		
		int r = t.mover('b', 5, 2, 4, 3, "g5", "f4");
		assertTrue(r == 30 );
	}
	public void testReyAhogadoConPeonN(){
		this.addRey(7, 2, 'n');
		this.addRey(5, 8, 'b');
		this.addTorre1(5, 3, 'n');
		this.addTorre2(6, 3, 'n');
		this.addDama(5, 2, 'n');
		this.addPeon(5, 7, 'b',1);
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 5, 2, 4, 3, "g5", "f4");
		assertTrue(r == 30 );
	}
	
	
	
	/*********************REy casi ahogado*********************/
	
	public void testCasiAhoragadoB_1(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(1, 5, 'b');
		this.addTorre2(1, 7, 'b');
		this.addDama(5, 3, 'b');
		
		int r = t.mover('b', 5, 3, 4, 3, "f5", "e4");
		assertTrue(r == 0 );
	}
	public void testCasiAhoragadoN_1(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(1, 5, 'n');
		this.addTorre2(1, 7, 'n');
		this.addDama(5, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 5, 3, 4, 3, "f5", "e4");
		assertTrue(r == 0 );
	}
	
	
	public void testCasiAhoragadoB_2(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(1, 5, 'b');
		this.addAlfil1(4, 8, 'b');
		this.addDama(5, 3, 'b');
		
		int r = t.mover('b', 5, 3, 4, 4, "f5", "e4");
		assertTrue(r == 0 );
	}
	public void testCasiAhoragadoN_2(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(1, 5, 'n');
		this.addAlfil1(4, 8, 'n');
		this.addDama(5, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 5, 3, 4, 4, "f5", "e4");
		assertTrue(r == 0 );
	}
	
	
	public void testCasiAhoragadoB_3(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(1, 7, 'b');
		this.addDama(5, 3, 'b');
		
		int r = t.mover('b', 5, 3, 4, 4, "f5", "e4");
		assertTrue(r == 0 );
	}
	public void testCasiAhoragadoN_3(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(1, 7, 'n');
		this.addDama(5, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 5, 3, 4, 4, "f5", "e4");
		assertTrue(r == 0 );
	}
	
	
	public void testCasiAhoragadoB_4(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(1, 7, 'b');
		this.addDama(4, 2, 'b');
		
		int r = t.mover('b', 4, 2, 2, 4, "f5", "e4");
		assertTrue(r == 0 );
	}
	public void testCasiAhoragadoN_4(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(1, 7, 'n');
		this.addDama(4, 2, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 4, 2, 2, 4, "f5", "e4");
		assertTrue(r == 0 );
	}
	
	public void testCasiAhoragadoB_5(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(2, 4, 'b');
		this.addDama(5, 3, 'b');
		
		int r = t.mover('b', 5, 3, 5, 5, "f5", "e4");
		assertTrue(r == 0 );
	}
	public void testCasiAhoragadoN_5(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(2, 4, 'n');
		this.addDama(5, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 5, 3, 5, 5, "f5", "e4");
		assertTrue(r == 0 );
	}
	
	
	public void testCasiAhoragadoB_6(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(1, 5, 'b');
		this.addTorre2(1, 7, 'b');
		this.addDama(4, 2, 'b');
		
		int r = t.mover('b', 4, 2, 2, 2, "f5", "e4");
		assertTrue(r == 0 );
	}
	public void testCasiAhoragadoN_6(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(1, 5, 'n');
		this.addTorre2(1, 7, 'n');
		this.addDama(4, 2, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 4, 2, 2, 2, "f5", "e4");
		assertTrue(r == 0 );
	}
	
	public void testCasiAhoragadoB_7(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(2, 8, 'b');
		this.addTorre2(4, 8, 'b');
		this.addDama(8, 5, 'b');
		
		int r = t.mover('b', 8, 5, 8, 7, "f5", "e4");
		assertTrue(r == 0 );
	}
	public void testCasiAhoragadoN_7(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(1, 5, 'n');
		this.addTorre2(1, 7, 'n');
		this.addDama(8, 5, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 5, 8, 7, "f5", "e4");
		assertTrue(r == 0 );
	}
	
	public void testCasiAhoragadoB_8(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 6, 'n');
		this.addTorre1(2, 8, 'b');
		this.addTorre2(4, 8, 'b');
		this.addDama(8, 4, 'b');
		
		int r = t.mover('b', 8, 4, 8, 5, "f5", "e4");
		assertTrue(r == 0 );
	}
	public void testCasiAhoragadoN_8(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 6, 'b');
		this.addTorre1(1, 5, 'n');
		this.addTorre2(1, 7, 'n');
		this.addDama(8, 4, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 4, 8, 5, "f5", "e4");
		assertTrue(r == 0 );
	}
	
	
	/**************Ahogar en lateradles******************/
	
	
	public void testahogarIB(){
		this.addRey(7, 8, 'b');
		this.addRey(3, 1, 'n');
		this.addTorre1(2, 8, 'b');
		this.addTorre2(4, 8, 'b');
		this.addDama(8, 4, 'b');
		
		int r = t.mover('b', 8, 4, 8, 2, "f5", "e4");
		assertTrue(r == 30 );
	}
	public void testahogarIN(){
		this.addRey(7, 8, 'n');
		this.addRey(3, 1, 'b');
		this.addTorre1(2, 8, 'n');
		this.addTorre2(4, 8, 'n');
		this.addDama(8, 4, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 4, 8, 2, "f5", "e4");
		assertTrue(r == 30 );
	}
	
	public void testahogarDB(){
		this.addRey(7, 2, 'b');
		this.addRey(3, 8, 'n');
		this.addTorre1(2, 1, 'b');
		this.addTorre2(4, 1, 'b');
		this.addDama(8, 4, 'b');
		
		int r = t.mover('b', 8, 4, 8, 7, "f5", "e4");
		assertTrue(r == 30 );
	}
	public void testahogarDN(){
		this.addRey(7, 2, 'n');
		this.addRey(3, 8, 'b');
		this.addTorre1(2, 1, 'n');
		this.addTorre2(4, 1, 'n');
		this.addDama(8, 4, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 4, 8, 7, "f5", "e4");
		assertTrue(r == 30 );
	}
	
	public void testahogarArB(){
		this.addRey(7, 2, 'b');
		this.addRey(1, 5, 'n');
		this.addTorre1(8, 4, 'b');
		this.addTorre2(8, 6, 'b');
		this.addDama(3, 1, 'b');
		
		int r = t.mover('b', 3, 1, 2, 1, "f5", "e4");
		assertTrue(r == 30 );
	}
	public void testahogarArN(){
		this.addRey(7, 2, 'n');
		this.addRey(1, 5, 'b');
		this.addTorre1(8, 4, 'n');
		this.addTorre2(8, 6, 'n');
		this.addDama(3, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 3, 1, 2, 1, "f5", "e4");
		assertTrue(r == 30 );
	}
	
	public void testahogarAbB(){
		this.addRey(1, 2, 'b');
		this.addRey(8, 5, 'n');
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addDama(3, 1, 'b');
		
		int r = t.mover('b', 3, 1, 7, 1, "f5", "e4");
		assertTrue(r == 30 );
	}
	public void testahogarAbN(){
		this.addRey(1, 2, 'n');
		this.addRey(8, 5, 'b');
		this.addTorre1(1, 4, 'n');
		this.addTorre2(1, 6, 'n');
		this.addDama(3, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 3, 1, 7, 1, "f5", "e4");
		assertTrue(r == 30 );
	}
	
	
	/****************Ahogar en las esquinas del talero*****************/
	
	
	public void testahogarIArBES(){
		this.addRey(5, 5, 'b');
		this.addRey(1, 1, 'n');
		this.addTorre1(8, 2, 'b');
		this.addDama(8, 8, 'b');
		
		int r = t.mover('b', 8, 8, 2, 8, "a8", "a2");
		assertTrue(r == 30 );
	}
	public void testahogarIArNES(){
		this.addRey(5, 5, 'n');
		this.addRey(1, 1, 'b');
		this.addTorre1(8, 2, 'n');
		this.addDama(8, 8, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 8, 2, 8, "a8", "a2");
		assertTrue(r == 30 );
	}
	
	public void testahogarDArBES(){
		this.addRey(5, 5, 'b');
		this.addRey(1, 8, 'n');
		this.addTorre1(8, 7, 'b');
		this.addDama(8, 1, 'b');
		
		int r = t.mover('b', 8, 1, 2, 1, "a8", "a2");
		assertTrue(r == 30 );
	}
	public void testahogarDArNES(){
		this.addRey(5, 5, 'n');
		this.addRey(1, 8, 'b');
		this.addTorre1(8, 7, 'n');
		this.addDama(8, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 1, 2, 1, "a8", "a2");
		assertTrue(r == 30 );
	}
	
	
	public void testahogarDAbBES(){
		this.addRey(5, 5, 'b');
		this.addRey(8, 8, 'n');
		this.addTorre1(1, 7, 'b');
		this.addDama(1, 1, 'b');
		
		int r = t.mover('b', 1, 1, 7, 1, "a8", "a2");
		assertTrue(r == 30 );
	}
	public void testahogarDAbNES(){
		this.addRey(5, 5, 'n');
		this.addRey(8, 8, 'b');
		this.addTorre1(1, 7, 'n');
		this.addDama(1, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 1, 7, 1, "a8", "a2");
		assertTrue(r == 30 );
	}
	
	
	public void testahogarIAbBES(){
		this.addRey(5, 5, 'b');
		this.addRey(8, 1, 'n');
		this.addTorre1(1, 2, 'b');
		this.addDama(1, 8, 'b');
		
		int r = t.mover('b', 1, 8, 7, 8, "a8", "a2");
		assertTrue(r == 30 );
	}
	public void testahogarIAbNES(){
		this.addRey(5, 5, 'n');
		this.addRey(8, 1, 'b');
		this.addTorre1(1, 2, 'n');
		this.addDama(1, 8, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 8, 7, 8, "a8", "a2");
		assertTrue(r == 30 );
	}
	
	
	/*****************Atacar el rey con fichas de mi color*******************/
	
	public void testahogarFichasI(){
		this.addRey(8, 8, 'n');
		this.addRey(7, 5, 'b');
		this.addTorre1(6, 8, 'n');
		this.addDama(1, 7, 'n');
		this.addPeon(7, 4, 'b', 1);
		this.addPeon(8, 3, 'b', 2);
		this.addPeon(8, 4, 'b', 3);
		this.addPeon(8, 5, 'b', 4);
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 7, 8, 7, "b1", "b6");
		assertTrue(r == 30 );
	}
	
	
	public void testahogarFichasD(){
		this.addRey(8, 8, 'n');
		this.addRey(7, 5, 'b');
		this.addTorre1(6, 8, 'n');
		this.addDama(1, 3, 'n');
		this.addPeon(7, 6, 'b', 1);
		this.addPeon(8, 5, 'b', 2);
		this.addPeon(8, 6, 'b', 3);
		this.addPeon(8, 7, 'b', 4);
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 3, 8, 3, "b1", "b6");
		assertTrue(r == 30 );
	}
	
	public void testahogarFichasAbD(){
		this.addRey(8, 8, 'n');
		this.addRey(7, 5, 'b');
		this.addTorre1(6, 8, 'n');
		this.addAlfil1(5, 8, 'n');
		this.addDama(1, 3, 'n');
		
		this.addPeon(8, 6, 'b', 2);
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 3, 8, 3, "b1", "b6");
		assertTrue(r == 30 );
	}
	public void testahogarFichasAb(){
		this.addRey(8, 8, 'n');
		this.addRey(7, 5, 'b');
		this.addTorre1(6, 8, 'n');
		this.addTorre2(1, 6, 'n');
		this.addDama(1, 3, 'n');
		
		this.addPeon(8, 5, 'b', 2);
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 3, 8, 3, "b1", "b6");
		assertTrue(r == 30 );
	}
	
	
	public void testahogarFichasAbI(){
		this.addRey(8, 8, 'n');
		this.addRey(7, 5, 'b');
		this.addTorre1(6, 8, 'n');
		this.addAlfil1(4, 1, 'n');
		this.addDama(1, 7, 'n');
		
		this.addPeon(8, 4, 'b', 2);
		
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 1, 7, 8, 7, "b1", "b6");
		assertTrue(r == 30 );
	}
	
	public void testahogarFichasAr(){
		this.addRey(8, 8, 'b');
		this.addRey(2, 5, 'n');
		this.addTorre1(3, 8, 'b');
		this.addTorre2(8, 4, 'b');
		this.addDama(8, 7, 'b');
		
		this.addPeon(1, 5, 'n', 2);
		
		int r = t.mover('b', 8, 7, 1, 7, "b1", "b6");
		assertTrue(r == 30 );
	}
	
	public void testahogarFichasArD(){
		this.addRey(8, 8, 'b');
		this.addRey(2, 5, 'n');
		this.addTorre1(3, 8, 'b');
		this.addAlfil2(4, 8, 'b');
		this.addDama(8, 3, 'b');
		
		this.addPeon(1, 6, 'n', 2);
		
		int r = t.mover('b', 8, 3, 1, 3, "b1", "b6");
		assertTrue(r == 30 );
	}
	
	public void testahogarFichasArI(){
		this.addRey(8, 8, 'b');
		this.addRey(2, 5, 'n');
		this.addTorre1(3, 8, 'b');
		this.addAlfil2(4, 2, 'b');
		this.addDama(8, 7, 'b');
		
		this.addPeon(1, 4, 'n', 2);
		
		int r = t.mover('b', 8, 7, 1, 7, "b1", "b6");
		assertTrue(r == 30 );
	}
	
	
	
	public void testahogarSinFichasEspecial(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 7, 'n');
		this.addTorre1(4, 1, 'b');
		this.addTorre2(6, 1, 'b');
		this.addDama(1, 1, 'b');
		
		int r = t.mover('b', 1,1, 1, 6, "h1", "h6");
		assertTrue(r == 0 );
	}
	
	public void testahogarSinFichasEspecial2(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 7, 'n');
		this.addTorre1(4, 1, 'b');
		this.addAlfil1(2, 5, 'b');
		this.addAlfil2(2, 3, 'b');
		this.addDama(1, 1, 'b');
		
		int r = t.mover('b', 1,1, 1, 6, "h1", "h6");
		assertTrue(r == 0 );
	}
	
	
	
	/*************Tests para el uoi**********/
	public void testJaqueMateConFichaNoCortaArTorre(){
		this.addRey(8, 1, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(1, 4, 'b');
		this.addTorre2(1, 6, 'b');
		this.addAlfil1(1, 7, 'b');
		this.addDama(6, 3, 'b');
		
		this.addTorre1(6, 8, 'n');
		
		int r = t.mover('b', 1,4, 1, 5, "e1", "d1");
		assertTrue(r == 20 );
	}
	
	public void testJaqueMateConFichaNoCortaArDDama(){
		this.addRey(8, 1, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(1, 4, 'b');
		this.addTorre2(6, 1, 'b');
		this.addAlfil1(1, 2, 'b');
		this.addDama(1, 8, 'b');
		
		this.addTorre1(4, 7, 'n');
		
		int r = t.mover('b', 1,8, 2, 8, "a1", "a2");
		assertTrue(r == 10 );
	}
	
	public void testJaqueMateMiColorArD(){
		this.addRey(8, 1, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(1, 4, 'b');
		this.addTorre2(6, 1, 'b');
		this.addAlfil1(1, 2, 'b');
		this.addDama(1, 1, 'b');
		
		this.addTorre1(4, 6, 'n');
		
		int r = t.mover('b', 1,1, 5, 1, "h1", "h5");
		assertTrue(r == 20 );
	}
	
	public void testNoJaqueMateMiColorArD(){
		this.addRey(8, 1, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(1, 4, 'b');
		this.addTorre2(6, 1, 'b');
		this.addAlfil1(1, 2, 'b');
		this.addDama(1, 1, 'b');
		
		this.addPeon(4, 6, 'b',1);
		
		int r = t.mover('b', 1,1, 5, 1, "h1", "h5");
		assertTrue(r == 10 );
	}
	
	public void testNoJaqueMateMiColorAbI(){
		this.addRey(8, 1, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(4, 2, 'b');
		this.addTorre2(1, 6, 'b');
		this.addAlfil1(8, 7, 'b');
		this.addDama(1, 1, 'b');
		
		this.addPeon(6, 4, 'b',1);
		
		int r = t.mover('b', 1,1, 5, 1, "h1", "h5");
		assertTrue(r == 10 );
	}
	
	public void testNoJaqueMateMiColorAbD(){
		this.addRey(8, 1, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(4, 2, 'b');
		this.addTorre2(1, 4, 'b');
		this.addAlfil1(8, 3, 'b');
		this.addDama(1, 1, 'b');
		
		this.addPeon(6, 6, 'b',1);
		
		int r = t.mover('b', 1,1, 5, 1, "h1", "h5");
		assertTrue(r == 10 );
	}
	
	
/*************TestLCR**************/
	
	public void testNoHayJAquePeonAbD(){
		this.addRey(1, 4, 'n');
		this.addRey(5, 5, 'b');
		this.addPeon(5, 4, 'n',1);
		t.setColorDelJugadorConElTurno('n');
		
		int r = t.mover('n', 5, 4, 4, 4, "e5", "e4");
		assertTrue(""+r,r == 0);
	}
}
