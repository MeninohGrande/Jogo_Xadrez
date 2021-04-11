package aplication;

import java.util.Scanner;

import board.BoardException;
import chess.ChessExecption;
import chess.ChessMatch;
import chess.Color;
import position.Position;

public class Programa {

	
	public static void main(String[] args){	

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		char resp = 's';

	
	while(resp == 's'){
		try {
			
			UI.printChessMatch(chessMatch);
			System.out.println("Origem: ");
			Position origem = 	UI.readChessPosition(sc);
			UI.printBoard(chessMatch.getPieces(), chessMatch.getPossibleMoves(origem));
			
			imprimir(chessMatch);

			System.out.println("Deseja repetir? ");
			resp = sc.nextLine().toLowerCase().charAt(0);

		} catch (ChessExecption e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			sc.nextLine();

		} catch (BoardException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			sc.nextLine();
		} catch(RuntimeException e){
			e.printStackTrace();
			sc.nextLine();
		}
	
	}
		sc.close();
	}

	private static void imprimir(ChessMatch chessMatch) {
		final String ANSI_WHITE = "\u001B[37m";
		final String ANSI_YELLOW = "\u001B[33m";
		final String ANSI_RESET = "\u001B[0m";

		for (int linha = 0;linha < chessMatch.getPieces().length; linha++){
			for(int col = 0; col < chessMatch.getPieces().length; col++){
				if (chessMatch.getPieces()[col][linha] != null){
					if(chessMatch.getPieces()[col][linha].getColor() == Color.WHITE){
						System.out.print("Posiçao: " + ANSI_WHITE + chessMatch.getPieces()[col][linha] +" "+ chessMatch.getPieces()[col][linha].getPosition()+ANSI_RESET);
						System.out.println();
					}else{
						System.out.print("Posiçao: " + ANSI_YELLOW + chessMatch.getPieces()[col][linha] +" "+ chessMatch.getPieces()[col][linha].getPosition()+ANSI_RESET);
						System.out.println();
					}
				}
			}
		}
	}
}
