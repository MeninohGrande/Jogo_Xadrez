package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
    Board board = new Board();


    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
    private void testPosition(Position p){
        if(board.positionExists(p))
            possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
    }
 
    @Override
    public boolean[][] possibleMoves() {
        Position p = new Position();

        //Acima
        p.setColuna(super.position.getColuna());
        p.setLinha(super.position.getLinha() - 1);
        testPosition(p);

        //Abaixo
        p.setLinha(super.position.getLinha() + 1);
        testPosition(p);
        
        //Direita
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha());
        testPosition(p);
        
        //Esquerda
        p.setColuna(super.position.getColuna() + 1);
        testPosition(p);
        
        //NE
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha() - 1);
        testPosition(p);

        //SE
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha() + 1);
        testPosition(p);

        //SW
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha() + 1);
        testPosition(p);

        //NW
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha() - 1);
        testPosition(p);

        return super.possibleMoves;
    }

}
