package TicTacToeLLD;

import java.util.LinkedList;
import java.util.*;

public class TicTacToeGame {
    private Deque<Player> players;
    private Board board;

    public void initializeGame() {
        players = new LinkedList<>();

        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {
            //get the player turn
            Player playerTurn = players.removeFirst();

            //display the board
            board.printBoard();

            //get the free space from the board
            List<List<Integer>> freeSpaces = board.getFreeSpaces();

            //if no free space, continue to tie
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            //read user input
            System.out.print("Player:" + playerTurn.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            //place the piece into the cell
            boolean pieceAddedSuccessfully = board.addPiece(inputRow, inputColumn, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            //check winner
            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece().playingPieceType);
            if(winner) {
                return playerTurn.getName();
            }

            //put the player to the deque
            players.addLast(playerTurn);
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int column, PlayingPieceType playingPieceType) {
        boolean rowMatch = true;
        for(int i=0; i<board.getSize(); ++i){
            if(board.board[row][i] == null || board.board[row][i].playingPieceType != playingPieceType){
                rowMatch = false;
                break;
            }
        }
        if(rowMatch) return true;

        boolean columnMatch = true;
        for(int i=0; i<board.getSize(); ++i){
            if(board.board[i][column] == null || board.board[i][column].playingPieceType != playingPieceType){
                columnMatch = false;
                break;
            }
        }
        if(columnMatch) return true;

        boolean diagonalMatch = true;
        for(int i=0; i< board.getSize(); ++i){
            if(board.board[i][i] == null || board.board[i][i].playingPieceType != playingPieceType){
                diagonalMatch = false;
                break;
            }
        }
        if(diagonalMatch) return true;

        boolean antiDiagonalMatch = true;
        for(int i=0; i<board.getSize(); ++i){
            if(board.board[i][board.getSize()-i-1] == null || board.board[i][board.getSize()-i-1].playingPieceType != playingPieceType){
                antiDiagonalMatch = false;
                break;
            }
        }
        return antiDiagonalMatch;
    }
}
