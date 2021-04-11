package chess;

import board.Board;
import board.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;
    private Color currentPlayer;
    private int jogada;

    public ChessMatch(){
        board = new Board();
        startMatch();
        currentPlayer = Color.WHITE;
        jogada = 0;
    }

    public boolean[][] getPossibleMoves(Position p){
        validatePieceSource(p);
        return board.getChessPiece(p).possibleMoves();
    }
    
    private void validatePieceSource(Position p){
        if (!board.positionExists(p))
            throw new ChessExecption("Essa posição não existe no tabuleiro");

        if (currentPlayer != board.getChessPiece(p).getColor())
            throw new ChessExecption("Essa peça não é sua");
        
        if (!board.getChessPiece(p).isThereAnyPossibleMove()){
            throw new ChessExecption("Não há movimento para essa peça");
        }
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] matChessPieces = new ChessPiece[board.getLINHA()][board.getCOLUNA()];
        for(int linha = 0; linha < board.getLINHA(); linha++){
            for(int coluna = 0; coluna < board.getCOLUNA(); coluna++){

                matChessPieces[coluna][linha] = board.getChessPiece(coluna, linha);
            }
        }
        return matChessPieces;
    }

    private void startMatch(){
        board.placePiece(new Rook(board, Color.WHITE),      new Position('A', 1));
        board.placePiece(new Knight(board, Color.WHITE),    new Position('B', 2));
        board.placePiece(new Bishop(board, Color.WHITE),    new Position('C', 2));
        board.placePiece(new Queen(board, Color.WHITE),     new Position('D', 2));
        board.placePiece(new King(board, Color.WHITE),      new Position('E', 2));
        board.placePiece(new Bishop(board, Color.WHITE),    new Position('F', 2));
        board.placePiece(new Knight(board, Color.WHITE),    new Position('G', 2));
        board.placePiece(new Rook(board, Color.WHITE),      new Position('H', 1));
        board.placePiece(new Pawn(board, Color.WHITE),      new Position('C', 3));


        board.placePiece(new Rook(board, Color.BLACK),      new Position('A', 8));
        board.placePiece(new Knight(board, Color.BLACK),    new Position('B', 7));
        board.placePiece(new Bishop(board, Color.BLACK),    new Position('C', 7));
        board.placePiece(new Queen(board, Color.BLACK),     new Position('D', 7));
        board.placePiece(new King(board, Color.BLACK),      new Position('E', 7));
        board.placePiece(new Bishop(board, Color.BLACK),    new Position('F', 7));
        board.placePiece(new Knight(board, Color.BLACK),    new Position('G', 7));
        board.placePiece(new Rook(board, Color.BLACK),      new Position('H', 8));
        board.placePiece(new Pawn(board, Color.BLACK),      new Position('D', 4));
    }

    
}