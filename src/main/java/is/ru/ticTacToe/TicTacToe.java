package is.ru.ticTacToe;

public class TicTacToe {
	private char[] board;

	public static char[][] createBoard()
	{
		char[][] newBoard = new char[3][3];
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
			newBoard[i][j] = '-';
			}
		}
		return newBoard;
	}
	public static void main(String[] args) {
		System.out.println("test");


	}

}
