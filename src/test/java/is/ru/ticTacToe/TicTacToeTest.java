package is.ru.ticTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest{
    @Test
    public void testCreateBoard()
    {
        char[][] expected = new char[3][3];
        expected[0][0] = '-';
        expected[0][1] = '-';
        expected[0][2] = '-';
        expected[1][0] = '-';
        expected[1][1] = '-';
        expected[1][2] = '-';
        expected[2][0] = '-';
        expected[2][1] = '-';
        expected[2][2] = '-';

        assertEquals(expected, TicTacToe.createBoard());
    }
}
