package chess;

import board.Board;
import board.Position;

public abstract class ChessPiece {

	protected Position position;
	private Color color;
	private int moveCount;
	protected Board board;
	
	public ChessPiece(Board board, Color color) {
		this.board = board;
		this.color = color;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position p) {
		this.position = p;
	}
	public Color getColor() {
		return this.color;
	}
	public int getMoveCount() {
		return this.moveCount;
	}
	public void incrementMoveCount() {
		this.moveCount ++;
	}
	public void decreaseMoveCount() {
		this.moveCount --;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean isAPossibleMove(Position p) {
		return possibleMoves()[p.getLinha()][p.getColuna()];
	}

	public boolean isThereAnyPossibleMove() {
		boolean [][] matPossibleMoves = possibleMoves();
		
		for(int linha = 0; linha < matPossibleMoves.length; linha++) {
			for(int coluna = 0; coluna < matPossibleMoves.length; coluna++) {
				if (matPossibleMoves[linha][coluna])
					return true;
			}
		}
		return false;
	}

	public boolean isThereOponentPiece(Position p) {
		if (!board.thereIsAPiece(p))
			throw new ChessExecption("Não há peça nessa posição");
		
		ChessPiece piece = this.board.getChessPiece(p);
		return piece != null && piece.getColor() != this.color;
	
	}
	
	public Position getChesPosition(){
		return Position.fromPosition(position);
	}
	@Override
	public abstract String toString();
}