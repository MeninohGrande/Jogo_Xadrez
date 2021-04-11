package chess.pieces;

import board.Board;
import position.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        Position p = new Position();
        
        //Acima
       p.setColuna(super.position.getColuna());
       p.setLinha(super.position.getLinha() - 1);

        while(!board.thereIsAPiece(p) ){
                possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
           p.setLinha(p.getLinha() - 1);
        }
        if (board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);


        //Abaixo
        p.setColuna(super.position.getColuna());
        p.setLinha(super.position.getLinha() + 1);

        while(board.positionExists(p) && !board.thereIsAPiece(p)){
                possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
            p.setLinha(p.getLinha() + 1);
        }
        if (board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
        
        //Direita
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha());

        while(board.positionExists(p) && !board.thereIsAPiece(p)){
                possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
             p.setColuna(p.getColuna() - 1);            
        }
        if (board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);

        //Esquerda
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha());

        while(board.positionExists(p) && !board.thereIsAPiece(p)){
                possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
           p.setColuna(p.getColuna() + 1);
        }
        if (board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
        
      return super.possibleMoves;
    }

    @Override
    public String toString() {
        return "T";
    }
    
}
