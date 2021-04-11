package chess.pieces;

import board.Board;
import position.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{
    private boolean enPassant = false;

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    public void setEnPassant(boolean enPassant){
        this.enPassant = enPassant;
    }
    public boolean getEnPassant(){
        return this.enPassant;
    }

    private void testPosition(Position p){
        if(board.positionExists(p) && !board.thereIsAPiece(p))
            possibleMoves[p.getColuna()][p.getLinha()] = true;
    }
    private void testPositionAtack(Position p){
        if(board.positionExists(p) && board.thereIsAPiece(p) && isThereOponentPiece(p))            
            possibleMoves[p.getColuna()][p.getLinha()] = true;
    }


    @Override
    public boolean[][] possibleMoves() {
       Position p = new Position();

       if (super.getColor() == Color.WHITE){ // Pião Branco
        //Avante
        p.setColuna(super.position.getColuna());
        p.setLinha(super.position.getLinha() - 1);
        testPosition(p);
        if (getMoveCount() == 0){
            p.setLinha(super.position.getLinha() - 2);
            testPosition(p);
        }

        //Direita
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha() - 1);
        testPositionAtack(p);
        
        //Esquerda
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha() - 1);
        testPositionAtack(p);
            
       }else{                       //Pião Preto
        //Avante
        p.setColuna(super.position.getColuna());
        p.setLinha(super.position.getLinha() + 1);
        testPosition(p);

        if(getMoveCount() == 0){
            p.setLinha(super.position.getLinha() + 2);
            testPosition(p);
        }

        //Direita
        p.setColuna(super.position.getColuna() - 1);
        p.setLinha(super.position.getLinha() + 1);
        testPositionAtack(p);

        //Esqueda
        p.setColuna(super.position.getColuna() + 1);
        p.setLinha(super.position.getLinha() + 1);
        testPositionAtack(p);

       }
    return super.possibleMoves;
    }

    @Override
    public String toString() {
        return "P";
    }
}
