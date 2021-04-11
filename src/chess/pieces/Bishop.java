package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{

    public Bishop(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString() {
        return "B";
    }
    @Override
    public boolean[][] possibleMoves() {
        Position p = new Position();
        
        //NW
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha() - 1);

        while(board.positionExists(p) && !board.thereIsAPiece(p)){
                possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
    
            p.setColuna(p.getColuna() - 1);
            p.setLinha(p.getLinha() - 1);
        }
        if(board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);

        //NE
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha() - 1);

        while(board.positionExists(p) && !board.thereIsAPiece(p)){
                possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);  
           
            p.setColuna(p.getColuna() + 1);
            p.setLinha(p.getLinha() - 1);
        }
        if(board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);

        //SE
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha() + 1);

        while(board.positionExists(p) && !board.thereIsAPiece(p)){
                possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
            
            p.setColuna(p.getColuna() + 1);
            p.setLinha(p.getLinha() + 1);
        }
        if(board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
        
        //SW
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha() + 1);

        while(board.positionExists(p) && !board.thereIsAPiece(p)){
                possibleMoves[p.getColuna()][p.getLinha()] = true;
            
            p.setColuna(p.getColuna() - 1);
            p.setLinha(p.getLinha() + 1);
        }
        if(board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = true;        

    return possibleMoves;
    }
  
}