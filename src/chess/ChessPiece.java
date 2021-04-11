package chess;

import board.Board;
import position.Position;

public abstract class ChessPiece {

	protected Position position;
	private Color color;
	private int moveCount = 0;
	protected Board board;
	protected boolean [][] possibleMoves;

	public ChessPiece(Board board, Color color) {
		this.board = board;
		this.color = color;
		possibleMoves = new boolean[this.board.getCOLUNA()][this.board.getLINHA()];
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
	
	protected abstract boolean[][] possibleMoves();

	protected boolean canMove(Position p){
		return !board.thereIsAPiece(p) || isThereOponentPiece(p);
	}
	
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