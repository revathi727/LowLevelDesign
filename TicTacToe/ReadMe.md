Entities:
- PlayingPiece
- Board
- Player

PieceType - X, O etc

PlayingPiece
- create PlayingPiece with type X, O, etc
- using Factory Design Pattern

Board
- has size nxn
- has playingpieces[][]

Player
- has name
- has Playingpiece

Game
- has list of players
- has board
