package is.ru.ticTacToe;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import edu.princeton.cs.algs4.*;

public class TicTacToe {
	private static char[][] board;
	private static boolean done;
	private static boolean playerTurn = true;
	/**
	 * Constructor, set variables and call createboard
	 */
	public TicTacToe() {
		done = false;
		playerTurn = true;
		createBoard();
	}
	/** Create a 3x3[][] board for TicTacToe game
	 * @return [][] board
	 */
	public static char[][] createBoard()
	{
		board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
		return board;
	}
	//Test HElper
	public static String getBoard()
	{
		String s = "";
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				s = s + (board[i][j]);
			}
		}
		return s;
	}
	/**
	 * Print the multidimensional array to console
	 */
	public void printBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

	}
	public boolean boardFull() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] != '-')
					count++;
			}
		}
		if(count == 9) {
			done = true;
			return true;
		}
		return false;
	}

		/** Check if there is a winner
	 * @return E if even
	 */
	public char checkWin() {
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
				done = true;
				return board[i][0];
			}
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
				done = true;
				return board[0][i];
			}
		}
		if((board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[1][1] != '-') {
			done = true;
			return board[1][1];
		}
		if(boardFull() == true) {
			return 'E';
		}
		return '-';
	}

	public void makeMove(int i)
	{
		if(done) {
			return;
		}

		int y = 0;
		if(i > 3) {
			if(i > 6) {
				i = i - 6;
				y = 2;
			} else {
				i = i - 3;
				y = 1;
			}
		}
		i = i - 1;
		if(board[y][i] == '-') {
			if(!playerTurn) {
				board[y][i] = 'O';
				playerTurn = !playerTurn;
			} else {
				board[y][i] = 'X';
				playerTurn = !playerTurn;
			}
		}
		checkWin();
	}


	public JSONObject reset() {
		done = false;
		playerTurn = true;
		createBoard();
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();

		String b = null;
		for (int i = 0; i < board.length; i++) {
			JSONArray cells = new JSONArray();
			for (int j = 0; j < board[i].length; j++) {
				cells.add(String.valueOf(board[i][j]));
			}
			arr.add(cells);
		}
		obj.put("cells", arr);
		obj.put("gameOver" , done);
		obj.put("winner", String.valueOf(checkWin()));
		return obj;
	}
	public JSONObject updateCell(int cell) {
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		makeMove(cell);
		String b = null;
		for (int i = 0; i < board.length; i++) {
			JSONArray cells = new JSONArray();
			for (int j = 0; j < board[i].length; j++) {
				cells.add(String.valueOf(board[i][j]));
			}
			arr.add(cells);
		}
		obj.put("cells", arr);
		obj.put("gameOver" , done);
		obj.put("winner", String.valueOf(checkWin()));
		return obj;
	}
	public static void main(String[] args) {

	}
}
