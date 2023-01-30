package tictactoe;

import javax.swing.JOptionPane;

public class TicTacToe {

	static char player = 'O';
	static char game[][] = new char[6][7];

	public static void create() {

		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[0].length; j++) {
				game[i][j] = '-';
			}
		}
	}

	public static void play() {
		boolean win = false;
		while (!win) {

			changePlayer();
			getPlayerInput();
			displayBoard();

			if (checkWin()) {
				JOptionPane.showInternalMessageDialog(null, "player " + player + " won");
				win = true;
			}
		}

	}

	public static void getPlayerInput() {
		JOptionPane.showMessageDialog(null, "player " + player);
		boolean valid = false;
		do {
			String s1 = JOptionPane.showInputDialog("please enter the number of row");
			int k = Integer.parseInt(s1);
			String s2 = JOptionPane.showInputDialog("please enter the number of colomn");
			int m = Integer.parseInt(s2);

			int x = k - 1;
			int y = m - 1;
			if ((x >= 0 && x <= 5) && (y >= 0 && y <= 6) && game[x][y] == '-') {
				game[x][y] = player;
				valid = true;
			} else
				JOptionPane.showInternalMessageDialog(null, "this place is not available");

		} while (!valid);
	}

	public static void changePlayer() {
		if (player == 'O') {
			player = 'X';
		} else {
			player = 'O';
		}
	}

	public static boolean checkWin() {
		return rows(game) || colomns(game) || diagonal1(game) || diagonal2(game);
	}

	public static void displayBoard() {
		
		System.out.println("------------------------------");
		for (int i = 0; i < game.length; i++) {
			
			System.out.print("| ");
			for (int j = 0; j < game[0].length; j++) {
				
				System.out.print(game[i][j] + " | ");
		
			}
			System.out.println();
			System.out.println("------------------------------");

		}
		System.out.println();
	}

	public static boolean rows(char game[][]) {
		boolean value = false;
		int count = 0;
		for (int i = 0; i < game.length; i++) {
			count = 0;
			for (int j = 0; j < game[0].length; j++) {
				if (game[i][j] == player) {
					count++;
					if (count == 3)
						value = true;
				}

				else
					count = 0;
			}
		}
		return value;

	}

	public static boolean colomns(char game[][]) {

		boolean value = false;
		int count = 0;
		for (int j = 0; j < game[0].length; j++) {
			for (int i = 0; i < game.length; i++) {

				if (game[i][j] == player) {
					count++;
					if (count == 3)
						value = true;
				}

				else
					count = 0;
			}
		}
		return value;
	}

	public static boolean diagonal1(char game[][]) {
		boolean value = false;
		for (int i = 0; i < game.length - 2; i++) {
			for (int j = 0; j < game[0].length - 2; j++) {
				if (game[i][j] == game[i + 1][j + 1] && game[i][j] == game[i + 2][j + 2] && game[i][j] == player) {
					value = true;
					break;
				}
			}
		}
		return value;
	}

	public static boolean diagonal2(char game[][]) {
		boolean value = false;
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[0].length; j++) {
				if (i + 2 < 6 && j - 2 >= 0 && game[i][j] == game[i + 1][j - 1] && game[i][j] == game[i + 2][j - 2]
						&& game[i][j] == player) {
					value = true;
					break;
				}
			}
		}
		return value;
	}

	public static void main(String[] args) {
		create();
		play();
		System.out.println("See you Again !");
	}

}
