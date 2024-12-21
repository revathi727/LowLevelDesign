package TicTacToeLLD;

public class PlayingPiece {
    public PlayingPieceType playingPieceType;

    PlayingPiece(PlayingPieceType playingPieceType){ //Factory Design Pattern
        this.playingPieceType = playingPieceType;
    }
}
