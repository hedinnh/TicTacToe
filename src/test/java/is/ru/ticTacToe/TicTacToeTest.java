package is.ru.ticTacToe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest{

    TicTacToe ttt = new TicTacToe();
    @Test
    public void testCreateBoard(){
        char[][] expected = new char[3][3];
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                 expected[i][j] = '-';
            }
        }
        assertEquals(expected, TicTacToe.createBoard());
    }

    @Test
    public void testMakeMove(){
        ttt.makeMove(1);
        assertEquals("X--------",ttt.getBoard());
        ttt.makeMove(5);
        assertEquals("X---O----",ttt.getBoard());
        ttt.makeMove(2);
        assertEquals("XX--O----", ttt.getBoard());
        ttt.makeMove(6);
        ttt.makeMove(8);
        assertEquals("XX--OO-X-", ttt.getBoard());
    }

    @Test
    public void testWinO(){
        ttt.makeMove(1);
        ttt.makeMove(3);
        ttt.makeMove(2);
        ttt.makeMove(6);
        ttt.makeMove(7);
        ttt.makeMove(9);

        assertEquals('O', ttt.checkWin());
    }

    @Test
    public void testWinX(){
        ttt.makeMove(1);
        ttt.makeMove(2);
        ttt.makeMove(3);
        ttt.makeMove(4);
        ttt.makeMove(7);
        ttt.makeMove(8);
        ttt.makeMove(9);
        ttt.makeMove(6);
        ttt.makeMove(5);

        assertEquals('X', ttt.checkWin());
    }

    @Test
    public void testDraw(){
        ttt.makeMove(5);
        ttt.makeMove(3);
        ttt.makeMove(1);
        ttt.makeMove(9);
        ttt.makeMove(6);
        ttt.makeMove(4);
        ttt.makeMove(7);
        ttt.makeMove(2);
        ttt.makeMove(8);

        assertEquals('E', ttt.checkWin());
    }

}
