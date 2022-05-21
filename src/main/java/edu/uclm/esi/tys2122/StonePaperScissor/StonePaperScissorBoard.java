package edu.uclm.esi.tys2122.StonePaperScissor;

import edu.uclm.esi.tys2122.model.Board;

public class StonePaperScissorBoard extends Board {

    private int[] squares;

    private int max_length = 2;

    public StonePaperScissorBoard() {
        this.squares = new int[max_length];
        for (int i=0; i<max_length; i++)
                this.squares[i] = 0;
    }

    public int[][] getSquares() {
        return new int[2][2];
    }

    public int[] getArray() {return squares;}
}
