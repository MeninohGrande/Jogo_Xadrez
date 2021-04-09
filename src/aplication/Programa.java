package aplication;

import java.text.ParseException;
import java.util.Scanner;

import board.Position;
import chess.ChessExecption;
import chess.ChessMatch;
import chess.Color;

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
			
			final String ANSI_WHITE = "\u001B[37m";
			final String ANSI_YELLOW = "\u001B[33m";
			final String ANSI_RESET = "\u001B[0m";

			for (int linha = 0;linha < chessMatch.getPieces().length; linha++){
				for(int col = 0; col < chessMatch.getPieces().length; col++){
					if (chessMatch.getPieces()[linha][col] != null){
						if(chessMatch.getPieces()[linha][col].getColor() == Color.WHITE){
						System.out.println("Posiçao: " + ANSI_WHITE + chessMatch.getPieces()[linha][col] +" "+ chessMatch.getPieces()[linha][col].getPosition()+ANSI_RESET);
						}else{
							System.out.println("Posiçao: " + ANSI_YELLOW + chessMatch.getPieces()[linha][col] +" "+ chessMatch.getPieces()[linha][col].getPosition()+ANSI_RESET);
						}
					}
				}
			}

			System.out.println("Deseja repetir? (s/n)");
			resp = sc.nextLine().toLowerCase().charAt(0);

		} catch (ChessExecption e) {
			System.out.println(e.getMessage());

		}catch(ParseException e){
			System.out.println(e.getMessage());
		}
	
	}
		sc.close();
	}
}
