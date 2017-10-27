package is.ru.ticTacToe;


import edu.princeton.cs.algs4.*;

public class TicTacToe {
	private static char[][] board;
	private static boolean done;
	private static boolean playerTurn = false;
	/**
	 * Constructor, set variables and call createboard
	 */
	public TicTacToe() {
		done = false;
		createBoard();
	}
	/** Create a 3x3[][] board for TicTacToe game
	 * @return [][] board
	 */
	public static char[][] createBoard()
	{
		board = new char[3][3];
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board[i][j] = '-';
			}
		}
		
		return board;
	}
	/** 
	 * Print the multidimensional array to console
	 */
	public void printBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

	}
	public void boardFull()
	{
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
			{
				if(board[i][j] != '-')
					count++;
			}
		}
		if(count == 9)
			done = true;
	}



	public static void main(String[] args) {
		
	}
}
