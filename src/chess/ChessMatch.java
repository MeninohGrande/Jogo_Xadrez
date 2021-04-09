package chess;

import board.Board;
import board.Position;
import chess.pieces.King;
import chess.pieces.Queen;

public class ChessMatch {

    Board board;


    public ChessMatch(){
        board = new Board();
        startMatch();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] matChessPieces = new ChessPiece[board.getLINHA()][board.getCOLUNA()];
        for(int linha = 0; linha < board.getLINHA(); linha++){
            for(int coluna = 0; coluna < board.getCOLUNA(); coluna++){

                matChessPieces[linha][coluna] = board.getChessPiece(linha, coluna);
            }
        }
        return matChessPieces;
    }

    private void placeNewPiece(char coluna, int linha,ChessPiece piece){
        board.placePiece(piece, new Position(coluna, linha));
    }

    private void startMatch(){
        placeNewPiece('E', 1, new King(board, Color.WHITE));
        placeNewPiece('D', 1, new Queen(board, Color.WHITE));

        placeNewPiece('E', 8, new King(board, Color.BLACK));
        placeNewPiece('D', 8, new Queen(board, Color.BLACK));
    }

    
}