package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestJAquesAlRey extends TestCase {

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
	
	
	protected Peon addPeon(int fila, int colum, char color){
		Peon p = new Peon(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			boolean seguir = true;
			for(int i = 0;i<8 && seguir;i++){
				if(t.getBlancas()[i] == null){
					t.getBlancas()[i] = p;
					seguir = false;
				}
			}
		}else{
			boolean seguir = true;
			for(int i = 0;i<8 && seguir;i++){
				if(t.getNegras()[i] == null){
					t.getNegras()[i] = p;
					seguir = false;
				}
			}
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
	
	
	
	/************************Haques normales************************/
	
	public void testHaquePeonArI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addPeon(3, 3, 'b');
		int r = t.mover('b', 3, 3, 4, 3, "", "");
		assertTrue(r == 10);
	}
	public void testNoHaquePeonArI(){
		this.addRey(1, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addPeon(2, 3, 'b');
		int r = t.mover('b', 2, 3, 3, 3, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueAlfilArI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(1, 2, 'b');
		int r = t.mover('b', 1, 2, 2, 1, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueDamaArI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addDama(1, 2, 'b');
		int r = t.mover('b', 1, 2, 2, 1, "", "");
		assertTrue(r == 10);
	}
	
	
	public void testHaqueDamaAr(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addDama(1, 3, 'b');
		int r = t.mover('b', 1, 3, 1, 4, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueTorreAr(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addTorre1(1, 3, 'b');
		int r = t.mover('b', 1, 3, 1, 4, "", "");
		assertTrue(r == 10);
	}
	
	
	
	public void testHaquePeonArD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 2, 'n');
		this.addPeon(3, 3, 'b');
		int r = t.mover('b', 3, 3, 4, 3, "", "");
		assertTrue(r == 10);
	}
	public void testNoHaquePeonArD(){
		this.addRey(1, 3, 'b');
		this.addRey(5, 2, 'n');
		this.addPeon(2, 3, 'b');
		int r = t.mover('b', 2, 3, 3, 3, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueAlfilArD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(1, 6, 'b');
		int r = t.mover('b', 1, 6, 2, 7, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueDamaArD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addDama(1, 6, 'b');
		int r = t.mover('b', 1, 6, 2, 7, "", "");
		assertTrue(r == 10);
	}
	
	
	public void testHaqueDamaD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addDama(1, 7, 'b');
		int r = t.mover('b', 1, 7, 5, 7, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueTorreD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addTorre1(1, 7, 'b');
		int r = t.mover('b', 1, 7, 5, 7, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueDamaI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addDama(1, 1, 'b');
		int r = t.mover('b', 1, 1, 5, 1, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueTorreI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addTorre1(1, 1, 'b');
		int r = t.mover('b', 1, 1, 5, 1, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueDamaAb(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addDama(8, 3, 'b');
		int r = t.mover('b', 8, 3, 8, 4, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueTorreAb(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addTorre1(8, 3, 'b');
		int r = t.mover('b', 8, 3, 8, 4, "", "");
		assertTrue(r == 10);
	}
	
	
	public void testHaquePeonAbD(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 2, 'b');
		this.addPeon(7, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 3, 6, 3, "", "");
		assertTrue(r == 10);
	}
	public void testNoHaquePeonAbD(){
		this.addRey(1, 3, 'n');
		this.addRey(5, 2, 'b');
		this.addPeon(8, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 3, 7, 3, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueAlfilAbD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(8, 5, 'b');
		int r = t.mover('b', 8, 5, 7, 6, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueDamaAbD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addDama(8, 5, 'b');
		int r = t.mover('b', 8, 5, 7, 6, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaquePeonAbI(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 2, 'b');
		this.addPeon(7, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 1, 6, 1, "", "");
		assertTrue(r == 10);
	}
	public void testNoHaquePeonAbI(){
		this.addRey(1, 3, 'n');
		this.addRey(5, 2, 'b');
		this.addPeon(8, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 1, 7, 1, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueAlfilAbI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(8, 3, 'b');
		int r = t.mover('b', 8, 3, 7, 2, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueDamaAbI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addDama(8, 3, 'b');
		int r = t.mover('b', 8, 3, 7, 2, "", "");
		assertTrue(r == 10);
	}
	
	
	public void testHaqueCaballo_1(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addCaballo1(1, 6, 'b');
		int r = t.mover('b', 1, 6, 3, 5, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueCaballo_2(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addCaballo1(1, 4, 'b');
		int r = t.mover('b', 1, 4, 3, 3, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueCaballo_3(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addCaballo1(2, 1, 'b');
		int r = t.mover('b', 2, 1, 4, 2, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueCaballo_4(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addCaballo1(8, 1, 'b');
		int r = t.mover('b', 8, 1, 6, 2, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueCaballo_5(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addCaballo1(8, 1, 'b');
		int r = t.mover('b', 8, 1, 7, 3, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueCaballo_6(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addCaballo1(8, 7, 'b');
		int r = t.mover('b', 8, 7, 7, 5, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueCaballo_7(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addCaballo1(5, 8, 'b');
		int r = t.mover('b', 5, 8, 6, 6, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueCaballo_8(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addCaballo1(2, 7, 'b');
		int r = t.mover('b', 2, 7, 4, 6, "", "");
		assertTrue(r == 10);
	}
	
	
	
	/****************************No haques*****************************/
	
	public void testHaquePeonArINH(){
		this.addRey(2, 2, 'n');
		this.addRey(5, 4, 'b');
		this.addPeon(3, 3, 'b');
		int r = t.mover('b', 3, 3, 4, 3, "f3", "f4");
		assertTrue(r == 0);
	}
	public void testNoHaquePeonArINH(){
		this.addRey(2, 2, 'n');
		this.addRey(5, 4, 'b');
		this.addPeon(2, 3, 'b');
		int r = t.mover('b', 2, 3, 3, 3, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueAlfilArINH(){
		this.addRey(2, 2, 'n');
		this.addRey(5, 4, 'b');
		this.addAlfil1(1, 2, 'b');
		int r = t.mover('b', 1, 2, 2, 1, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueDamaArINH(){
		this.addRey(3, 7, 'n');
		this.addRey(5, 4, 'b');
		this.addDama(1, 2, 'b');
		int r = t.mover('b', 1, 2, 2, 1, "", "");
		assertTrue(r == 0);
	}
	
	
	public void testHaqueDamaArNH(){
		this.addRey(5, 2, 'n');
		this.addRey(5, 4, 'b');
		this.addDama(1, 3, 'b');
		int r = t.mover('b', 1, 3, 1, 4, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueTorreArNH(){
		this.addRey(5, 2, 'n');
		this.addRey(5, 4, 'b');
		this.addTorre1(1, 3, 'b');
		int r = t.mover('b', 1, 3, 1, 4, "", "");
		assertTrue(r == 0);
	}
	
	
	
	public void testHaquePeonArDNH(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 2, 'b');
		this.addPeon(3, 3, 'b');
		int r = t.mover('b', 3, 3, 4, 3, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaquePeonArDNH(){
		this.addRey(1, 3, 'n');
		this.addRey(5, 2, 'b');
		this.addPeon(2, 3, 'b');
		int r = t.mover('b', 2, 3, 3, 3, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueAlfilArDNH(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 4, 'b');
		this.addAlfil1(1, 6, 'b');
		int r = t.mover('b', 1, 6, 2, 7, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueDamaArDNH(){
		this.addRey(3, 3, 'n');
		this.addRey(5, 4, 'b');
		this.addDama(1, 6, 'b');
		int r = t.mover('b', 1, 6, 2, 7, "", "");
		assertTrue(r == 0);
	}
	
	
	public void testHaqueDamaDNH(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 4, 'b');
		this.addDama(1, 7, 'b');
		int r = t.mover('b', 1, 7, 5, 7, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueTorreDNH(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 4, 'b');
		this.addTorre1(1, 7, 'b');
		int r = t.mover('b', 1, 7, 5, 7, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueDamaINH(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 4, 'b');
		this.addDama(1, 1, 'b');
		int r = t.mover('b', 1, 1, 5, 1, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueTorreINH(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 4, 'b');
		this.addTorre1(1, 1, 'b');
		int r = t.mover('b', 1, 1, 5, 1, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueDamaAbNH(){
		this.addRey(2, 2, 'n');
		this.addRey(5, 4, 'b');
		this.addDama(8, 3, 'b');
		int r = t.mover('b', 8, 3, 8, 4, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueTorreAbNH(){
		this.addRey(2, 2, 'n');
		this.addRey(5, 4, 'b');
		this.addTorre1(8, 3, 'b');
		int r = t.mover('b', 8, 3, 8, 4, "", "");
		assertTrue(r == 0);
	}
	
	
	public void testHaquePeonAbDNH(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 2, 'n');
		this.addPeon(7, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 3, 6, 3, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaquePeonAbDNH(){
		this.addRey(1, 3, 'b');
		this.addRey(5, 2, 'n');
		this.addPeon(8, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 3, 7, 3, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueAlfilAbDNH(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 4, 'b');
		this.addAlfil1(8, 5, 'b');
		int r = t.mover('b', 8, 5, 7, 6, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueDamaAbDNH(){
		this.addRey(2, 3, 'n');
		this.addRey(5, 4, 'b');
		this.addDama(8, 5, 'b');
		int r = t.mover('b', 8, 5, 7, 6, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaquePeonAbINH(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 2, 'n');
		this.addPeon(7, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 7, 1, 6, 1, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaquePeonAbINH(){
		this.addRey(1, 3, 'b');
		this.addRey(5, 2, 'n');
		this.addPeon(8, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int r = t.mover('n', 8, 1, 7, 1, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueAlfilAbINH(){
		this.addRey(2, 6, 'n');
		this.addRey(5, 4, 'b');
		this.addAlfil1(8, 3, 'b');
		int r = t.mover('b', 8, 3, 7, 2, "", "");
		assertTrue(r == 0);
	}
	
	public void testHaqueDamaAbINH(){
		this.addRey(2, 6, 'n');
		this.addRey(5, 4, 'b');
		this.addDama(8, 3, 'b');
		int r = t.mover('b', 8, 3, 7, 2, "", "");
		assertTrue(r == 0);
	}
	
	
	public void testHaqueCaballo_1NH(){
		this.addRey(8, 8, 'n');
		this.addRey(5, 4, 'b');
		this.addCaballo1(1, 6, 'b');
		int r = t.mover('b', 1, 6, 3, 5, "", "");
		assertTrue(r == 0);
	}
	public void testHaqueCaballo_2NH(){
		this.addRey(8, 8, 'n');
		this.addRey(5, 4, 'b');
		this.addCaballo1(1, 4, 'b');
		int r = t.mover('b', 1, 4, 3, 3, "", "");
		assertTrue(r == 0);
	}
	public void testHaqueCaballo_3NH(){
		this.addRey(8, 8, 'n');
		this.addRey(5, 4, 'b');
		this.addCaballo1(2, 1, 'b');
		int r = t.mover('b', 2, 1, 4, 2, "", "");
		assertTrue(r == 0);
	}
	public void testHaqueCaballo_4NH(){
		this.addRey(8, 8, 'n');
		this.addRey(5, 4, 'b');
		this.addCaballo1(8, 1, 'b');
		int r = t.mover('b', 8, 1, 6, 2, "", "");
		assertTrue(r == 0);
	}
	public void testHaqueCaballo_5NH(){
		this.addRey(8, 8, 'n');
		this.addRey(5, 4, 'b');
		this.addCaballo1(8, 1, 'b');
		int r = t.mover('b', 8, 1, 7, 3, "", "");
		assertTrue(r == 0);
	}
	public void testHaqueCaballo_6NH(){
		this.addRey(8, 8, 'n');
		this.addRey(5, 4, 'b');
		this.addCaballo1(8, 7, 'b');
		int r = t.mover('b', 8, 7, 7, 5, "", "");
		assertTrue(r == 0);
	}
	public void testHaqueCaballo_7NH(){
		this.addRey(8, 8, 'n');
		this.addRey(5, 4, 'b');
		this.addCaballo1(5, 8, 'b');
		int r = t.mover('b', 5, 8, 6, 6, "", "");
		assertTrue(r == 0);
	}
	public void testHaqueCaballo_8NH(){
		this.addRey(8, 8, 'n');
		this.addRey(5, 4, 'b');
		this.addCaballo1(2, 7, 'b');
		int r = t.mover('b', 2, 7, 4, 6, "", "");
		assertTrue(r == 0);
	}
	
	
	/******************************Haques al rey al moverse************************************/
	
	
	public void testmoverReyEnhaque_1(){
		this.addRey(5, 2, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 2, 5, 3, "", "");
		assertTrue(r == -7);
	}
	public void testmoverReyEnhaque_2(){
		this.addRey(5, 2, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 2, 6, 3, "", "");
		assertTrue(r == -7);
	}
	public void testmoverReyEnhaque_3(){
		this.addRey(5, 2, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 2, 4, 3, "", "");
		assertTrue(r == -7);
	}
	public void testmoverReyEnhaque_4(){
		this.addRey(3, 4, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 3, 4, 4, 4, "", "");
		assertTrue(r == -7);
	}
	public void testmoverReyEnhaque_5(){
		this.addRey(7, 4, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 7, 4, 6, 4, "", "");
		assertTrue(r == -7);
	}
	public void testmoverReyEnhaque_6(){
		this.addRey(5, 6, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 6, 5, 5, "", "");
		assertTrue(r == -7);
	}
	public void testmoverReyEnhaque_7(){
		this.addRey(5, 6, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 6, 4, 5, "", "");
		assertTrue(r == -7);
	}
	public void testmoverReyEnhaque_8(){
		this.addRey(5, 6, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 6, 6, 5, "", "");
		assertTrue(r == -7);
	}
	
	
	/*******************NO haque con el rey********************/
	
	public void testNoHaqueRey_1(){
		this.addPeon(1, 1, 'b');
		this.addRey(5, 1, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 1, 5, 2, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_2(){
		this.addPeon(1, 1, 'b');
		this.addRey(5, 1, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 1, 6, 2, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_3(){
		this.addPeon(1, 1, 'b');
		this.addRey(5, 1, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 1, 4, 2, "", "");
		assertTrue(r == 0);
	}
	
	public void testNoHaqueRey_4(){
		this.addPeon(1, 1, 'b');
		this.addRey(5, 7, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 7, 5, 6, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_5(){
		this.addPeon(1, 1, 'b');
		this.addRey(5, 7, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 7, 6, 6, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_6(){
		this.addPeon(1, 1, 'b');
		this.addRey(5, 7, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 5, 7, 4, 6, "", "");
		assertTrue(r == 0);
	}
	
	
	public void testNoHaqueRey_7(){
		this.addPeon(1, 1, 'b');
		this.addRey(2, 4, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 2, 4, 3, 4, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_8(){
		this.addPeon(1, 1, 'b');
		this.addRey(2, 4, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 2, 4, 3, 3, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_9(){
		this.addPeon(1, 1, 'b');
		this.addRey(2, 4, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 2, 4, 3, 5, "", "");
		assertTrue(r == 0);
	}
	
	
	public void testNoHaqueRey_10(){
		this.addPeon(1, 1, 'b');
		this.addRey(8, 4, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 8, 4, 7, 4, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_11(){
		this.addPeon(1, 1, 'b');
		this.addRey(8, 4, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 8, 4, 7, 3, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_12(){
		this.addPeon(1, 1, 'b');
		this.addRey(8, 4, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 8, 4, 7, 5, "", "");
		assertTrue(r == 0);
	}
	
	
	public void testNoHaqueRey_13(){
		this.addPeon(1, 1, 'b');
		this.addRey(2, 1, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 2, 1, 3, 2, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_14(){
		this.addPeon(1, 1, 'b');
		this.addRey(2, 7, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 2, 7, 3, 6, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_15(){
		this.addPeon(1, 1, 'b');
		this.addRey(8, 1, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 8, 1, 7, 2, "", "");
		assertTrue(r == 0);
	}
	public void testNoHaqueRey_16(){
		this.addPeon(1, 1, 'b');
		this.addRey(8, 7, 'b');
		this.addRey(5, 4, 'n');
		int r = t.mover('b', 8, 7, 7, 6, "", "");
		assertTrue(r == 0);
	}
	
	/**********************Dos fichas dan jaque***********************/
	
	
	
	
	
	public void testHaqueDobleDamaAr(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		
		this.addDama(1, 3, 'b');
		int r = t.mover('b', 1, 3, 1, 4, "", "");
		assertTrue(r == 10);
	}
	
	public void testHaqueDobleDamaArD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addDama(1, 6, 'b');
		int r = t.mover('b', 1, 6, 2, 7, "", "");
		assertTrue(r == 10);
	}
	
	
	public void testHaqueDobleDamaD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addDama(1, 7, 'b');
		int r = t.mover('b', 1, 7, 5, 7, "", "");
		assertTrue(r == 10);
	}
	
	
	
	public void testHaqueDobleDamaI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 2, 'b');
		this.addDama(1, 1, 'b');
		int r = t.mover('b', 1, 1, 5, 1, "", "");
		assertTrue(r == 10);
	}
	
	
	
	public void testHaqueDobleDamaAb(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addDama(8, 3, 'b');
		int r = t.mover('b', 8, 3, 8, 4, "", "");
		assertTrue(r == 10);
	}
	
	
	
	
	
	
	public void testHaqueDobleDamaAbD(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addDama(8, 5, 'b');
		int r = t.mover('b', 8, 5, 7, 6, "", "");
		assertTrue(r == 10);
	}
	
	
	
	public void testHaqueDobleDamaAbI(){
		this.addRey(2, 3, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addDama(8, 3, 'b');
		int r = t.mover('b', 8, 3, 7, 2, "", "");
		assertTrue(r == 10);
	}
	
	
	public void testHaqueDobleCaballo_1(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addCaballo1(1, 6, 'b');
		int r = t.mover('b', 1, 6, 3, 5, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueDobleCaballo_2(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addCaballo1(1, 4, 'b');
		int r = t.mover('b', 1, 4, 3, 3, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueDobleCaballo_3(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addCaballo1(2, 1, 'b');
		int r = t.mover('b', 2, 1, 4, 2, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueDobleCaballo_4(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addCaballo1(8, 1, 'b');
		int r = t.mover('b', 8, 1, 6, 2, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueDobleCaballo_5(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addCaballo1(8, 1, 'b');
		int r = t.mover('b', 8, 1, 7, 3, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueDobleCaballo_6(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addCaballo1(8, 7, 'b');
		int r = t.mover('b', 8, 7, 7, 5, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueDobleCaballo_7(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addCaballo1(5, 8, 'b');
		int r = t.mover('b', 5, 8, 6, 6, "", "");
		assertTrue(r == 10);
	}
	public void testHaqueDobleCaballo_8(){
		this.addRey(1, 1, 'b');
		this.addRey(5, 4, 'n');
		this.addAlfil1(2, 1, 'b');
		this.addCaballo1(2, 7, 'b');
		int r = t.mover('b', 2, 7, 4, 6, "", "");
		assertTrue(r == 10);
	}
	
	
	/***********************Mover el rey y ponerlo en jaque*********************/
	public void testEnrocarReyAlJaque(){
		this.addRey(1, 4, 'b');
		this.addRey(5, 4, 'n');
		this.addTorre1(1, 1, 'b');
		this.addTorre1(8, 2, 'n');
		
		int r = t.mover('b', 1, 4, 1, 2, "", "");
		assertTrue(""+r,r == -7);
	}
	
	public void testEnrocarReyAlJaqueValido(){
		this.addRey(1, 4, 'b');
		this.addRey(5, 4, 'n');
		this.addTorre1(1, 1, 'b');
		this.addTorre1(8, 3, 'n');
		
		int r = t.mover('b', 1, 4, 1, 2, "", "");
		assertTrue(""+r,r == -5);
	}
	
	public void testEnrocarLReyAlJaque(){
		this.addRey(1, 4, 'b');
		this.addRey(5, 4, 'n');
		this.addTorre1(1, 8, 'b');
		this.addTorre1(8, 6, 'n');
		
		int r = t.mover('b', 1, 4, 1, 6, "", "");
		assertTrue(""+r,r == -7);
	}
	
	public void testEnrocarLReyAlJaqueValido(){
		this.addRey(1, 4, 'b');
		this.addRey(5, 4, 'n');
		this.addTorre1(1, 8, 'b');
		this.addTorre1(8, 5, 'n');
		
		int r = t.mover('b', 1, 4, 1, 6, "", "");
		assertTrue(""+r,r == -5);
	}
	
	
	
	
	
}
