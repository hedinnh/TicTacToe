package is.ru.ticTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest{
    @Test 
    public void testCreateBoard() {
        char[][] expected = new char[3][3];
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                 expected[i][j] = '-';
            }
        }
        assertEquals(expected, TicTacToe.createBoard());
    }

}
