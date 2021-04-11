package chess.pieces;

import board.Board;
import position.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{
    
    public Knight(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString() {
        return "C";
    }

    private void testPosition(Position p){
        if (board.positionExists(p))
           possibleMoves[p.getColuna()][p.getLinha()] = canMove(p);
    }
    @Override
    public boolean[][] possibleMoves() {
        Position p = new Position();

        //NE1
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha() - 2);
        testPosition(p);
        
        //NE2
        p.setColuna(super.position.getColuna() + 2);
        p.setLinha(super.position.getLinha() - 1);
        testPosition(p);

        //SE1
        p.setColuna(super.position.getColuna() + 2);
        p.setLinha(super.position.getLinha() + 1);
        testPosition(p);

        //SE2
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha() + 2);
        testPosition(p);

        //SW1
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha() + 2);
        testPosition(p);

        //SW2
        p.setColuna(super.position.getColuna() - 2);
        p.setLinha(super.position.getLinha() + 1);
        testPosition(p);

        //NW1
        p.setColuna(super.position.getColuna() - 2);
        p.setLinha(super.position.getLinha() - 1);
        testPosition(p);

        //NW2
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha() - 2);
        testPosition(p);
        
        return possibleMoves;
    }
}