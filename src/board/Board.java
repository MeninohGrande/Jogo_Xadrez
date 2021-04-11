package board;

import chess.ChessPiece;

public class Board {

	private final int LINHA = 8, COLUNA = 8;
	private ChessPiece[][] chessPiece = new ChessPiece[COLUNA][LINHA];
	
	public Board(){
		System.out.println("Novo Tabuleiro");
	}
	public int getCOLUNA() {
		return COLUNA;
	}
	public int getLINHA() {
		return LINHA;
	}
	
	private void setChessPiece(ChessPiece piece, Position p) {
		this.chessPiece[p.getColuna()][p.getLinha()] = piece;
	}
	
	//Retorna a peça pela posição
	public ChessPiece getChessPiece(Position position) {		
		return getChessPiece(position.getColuna(), position.getLinha());		
	}
	
	//Retorna a peça pela matriz
	public ChessPiece getChessPiece(int coluna, int linha) {
		if (!positionExist(coluna, linha))
			throw new BoardException("Posição invalida");
		
		return chessPiece[coluna][linha];
	}
	
	public boolean positionExists(Position position) {
		return positionExist(position.getColuna(), position.getLinha());
	}
	
	private boolean positionExist(int coluna, int linha) {
		return linha < this.LINHA && linha >= 0 && coluna >= 0 && coluna < this.COLUNA;
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) 
			throw new BoardException("Esta posição não existe no tabuleiro");
		return getChessPiece(position) != null;
	}
	
	public void placePiece (ChessPiece piece, Position p) {
		if (!positionExists(p))
			throw new BoardException("Está posição não existe no tabuleiro");
		if (thereIsAPiece(p))
			throw new BoardException("Já existe uma peça nessa posição");
		
		this.chessPiece[p.getColuna()][p.getLinha()] = piece;
		this.chessPiece[p.getColuna()][p.getLinha()].setPosition(p);
		//piece.setPosition(p);
	}
	
	public ChessPiece removePiece(ChessPiece piece, Position p) {
		if (!positionExists(p))
			throw new BoardException("Está posição não existe no tabuleiro");
		if (!thereIsAPiece(p))
			return null;
		
		ChessPiece temp = getChessPiece(p);
		temp.setPosition(getChessPiece(p).getPosition());
		setChessPiece(null, p);
		
		return temp;
	}
}
