package TicTacToeLLD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public int getSize(){
        return size;
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if(board[row][column] != null) {
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    public List<List<Integer>> getFreeSpaces() {
        List<List<Integer>> freeSpaces = new ArrayList<>();
        for(int i=0; i<size; ++i){
            for(int j=0; j<size; ++j){
                if(board[i][j] == null){
                    freeSpaces.add(Arrays.asList(i, j));
                }
            }
        }
        return freeSpaces;
    }

    public void printBoard() {
        for(int i=0; i<size; ++i) {
            for(int j=0; j<size; ++j) {
                if(board[i][j] == null){
                    System.out.print(" ");
                }
                else{
                    System.out.print(board[i][j].playingPieceType.name());
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
