package lab5;

import java.util.Scanner;

public class TicTacToe {

	private static final char EMPTY = ' ';
	private char[][] board;
	private char current;

	public TicTacToe() {
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY;
			}
		}
		current = 'X';
	}

	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
				if (j < 2) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if (i < 2) {
				System.out.println("-------------");
			}
		}
	}

	public boolean checkRows() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true; 
			}
		}
		return false;
	}

	public boolean checkColumns() {
		for (int i = 0; i < 3; i++) {
			if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true; 
			}
		}
		return false;
	}

	public boolean checkDiagonals() {

		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true; 
		}
		if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true; 
		}
		return false;
	}

	public boolean checkWin() {
		return checkRows() || checkColumns() || checkDiagonals();
	}

	public boolean makeMove(int row, int col) {
		if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
			return false;
		}
		board[row][col] = current;

		if (checkWin()) {
			printBoard();
			System.out.println("Player " + current + " wins");
			return true;
		} else if (isBoardFull()) {
			printBoard();
			System.out.println("Drawn!");
			return true;
		}
		current = (current == 'X') ? 'O' : 'X';
		return true;

	}

	public boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		Scanner sc = new Scanner(System.in);

		while (true) {
			game.printBoard();
			System.out.println("Player: " + game.current);

			int row = sc.nextInt();
			int col = sc.nextInt();

			if (row >= 0 && row < 3 && col >= 0 && col < 3) {
				if (!game.makeMove(row, col)) {
					System.out.println("Invalid move. Try again");
				}
			} else {
				System.out.println("Invalid input. Enter row and column values between 0 and 2");
			}
		}

	}

}