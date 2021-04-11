package position;

import board.BoardException;
import chess.ChessExecption;

public class Position {

	private int linha;
	private int coluna;
	private char chessColumn;
	private int chessRow;
	
	public Position(){
	}
	//Construtor posição de matriz
	public Position(int coluna, int linha) {
		setValues(coluna, linha);
	}
	//Construtor posição de xadrez
	public Position(char coluna, int linha) {
		setValues(coluna, linha);
	}
	
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		//Implementação sem validação da existencia da posição
		this.linha = linha;
		this.chessRow = 8 - linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		//Implementação sem validação da existencia da posição
		this.coluna = coluna;
		this.chessColumn = Character.toString(coluna + 'A').charAt(0);
	}
	public char getchessColumn() {
		return chessColumn;
	}
	public int getChessRow() {
		return chessRow;
	}
	//Metodo para Matriz
	public void setValues(int coluna, int linha) {
		if (linha < 0 || linha > 7 || coluna < 0 || coluna > 7)
			throw new BoardException("Posição de matriz invalida: Valores aceitos 0-7");
		//Matriz
		this.coluna = coluna;
		this.linha = linha;
		//Xadrez
		this.chessRow = 8 - linha;
		this.chessColumn = Character.toString(coluna + 'A').charAt(0);
	}
	//Metodo para Xadrez
	public void setValues(char coluna, int linha){
		coluna = Character.toUpperCase(coluna);
		if (linha < 1 || linha > 8 || coluna < 'A' || coluna > 'H')
			throw new ChessExecption("Posição de xadres invalida: Valores aceitos A1-H8");
		//Matriz
		this.linha = 8 - linha;
		this.coluna = coluna - 'A';
		//Xadrez
		this.chessRow = linha;
		this.chessColumn = coluna;
	}
	
	//Converte posição de matriz -> xadres
	public static Position fromPosition (Position p) {
		return new Position(p.getColuna(), p.getLinha());
	}
	//Converte posição de xadrez -> matriz
	public Position toPosition() {
		return new Position(coluna + 'A', 8 - linha);
	}
	
	@Override
	public String toString() {
		return "" + ((char) (this.coluna + 'A')) + (8 - this.linha);
	}

}
