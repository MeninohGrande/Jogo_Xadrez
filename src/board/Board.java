package board;

import chess.ChessPiece;

public class Board {

	private final int LINHA = 8, COLUNA = 8;
	private ChessPiece[][] chessPiece = new ChessPiece[LINHA][COLUNA];
	
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
		this.chessPiece[p.getLinha()][p.getColuna()] = piece;
	}
	
	//Retorna a peça pela posição
	public ChessPiece getChessPiece(Position position) {		
		return getChessPiece(position.getColuna(), position.getLinha());		
	}
	
	//Retorna a peça pela matriz
	public ChessPiece getChessPiece(int linha, int coluna) {
		if (!positionExist(linha, coluna))
			throw new BoardException("Posição invalida");
		
		return chessPiece[linha][coluna];
	}
	
	public boolean positionExists(Position position) {
		return positionExist(position.getLinha(), position.getColuna());
	}
	
	private boolean positionExist(int linha, int coluna) {
		return linha <= this.LINHA && linha >= 0 && coluna >= 0 && coluna <= this.COLUNA;
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) 
			throw new BoardException("Está posição não existe no tabuleiro");
		return getChessPiece(position) != null;
	}
	
	public void placePiece (ChessPiece piece, Position p) {
		if (!positionExists(p))
			throw new BoardException("Está posição não existe no tabuleiro");
		if (thereIsAPiece(p))
			throw new BoardException("Já existe uma peça nessa posição");
		
		this.chessPiece[p.getLinha()][p.getColuna()] = piece;
		this.chessPiece[p.getLinha()][p.getColuna()].setPosition(p);
		//piece.setPosition(p);
	}
	
	public ChessPiece removePiece(ChessPiece piece, Position p) {
		if (!positionExists(p))
			throw new BoardException("Está posição não existe no tabuleiro");
		if (!thereIsAPiece(p))
			return null;
		
		ChessPiece temp = getChessPiece(p);
		temp.setPosition(null);
		setChessPiece(null, p);
		
		return temp;
	}
}
