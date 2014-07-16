package connectfour;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    private Board instance;
    final private Board.Cell player1 = Board.Cell.PLAYER1;
    final private Board.Cell player2 = Board.Cell.PLAYER2;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new BoardImpl();
        instance.initialize();        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class Board.
     */
    @Test
    public void testInitialize() {      
        assertFalse(instance.isFull());
    }

    @Test
    public void testAddNullDiscToColumn() {             
        try {
            instance.addToColumn(null, 0);
            fail("NullCellException was expected");        
        } catch (NullCellException e) {
        }   
    }
        
    @Test
    public void testAddSameDiscTwice() {  
        try {
            instance.addToColumn(player1, 0);
            instance.addToColumn(player1, 1);
            fail("SamePlayerTwiceException was expected");  
        } catch (SamePlayerTwiceException e) {
        }
        
        try {
            instance.addToColumn(player2, 0);
            instance.addToColumn(player2, 1);
            fail("SamePlayerTwiceException was expected");  
        } catch (SamePlayerTwiceException e) {
        }
    }
         
    @Test
    public void testAddToInvalidColumn() {          
        try {
            instance.addToColumn(player1, -1);
            fail("InvalidColumnException was expected");            
        } catch (InvalidColumnException e) {
        }
        
        try {
            instance.addToColumn(player2, -1);
            fail("InvalidColumnException was expected");            
        } catch (InvalidColumnException e) {
        }
            
        try {            
            instance.addToColumn(player1, Board.WIDTH);
            fail("InvalidColumnException was expected");        
        } catch (InvalidColumnException e) {
        }   
                
        try {            
            instance.addToColumn(player2, Board.WIDTH);
            fail("InvalidColumnException was expected");        
        } catch (InvalidColumnException e) {
        }   
        
    } 
    
    @Test
    public void testColumnIsFull() {
        for (int i = 0; i < Board.HEIGHT; i++) {
            if (i%2 == 0)
                instance.addToColumn(player1, 0);
            else
                instance.addToColumn(Board.Cell.PLAYER2, 0);
        }        
        assertTrue( instance.columnIsFull(0) );
    }   
    
    @Test
    public void testConnectFourHorizontal() {              
        instance.addToColumn(player1, 0);
        instance.addToColumn(player2, 0);
        
        instance.addToColumn(player1, 1);
        instance.addToColumn(player2, 1);
        
        instance.addToColumn(player1, 2);
        instance.addToColumn(player2, 2);
        
        instance.addToColumn(player1, 3);
        assertTrue( instance.playerHasWon(player1) );
        assertFalse( instance.playerHasWon(player2) );
    }
    
    @Test
    public void testConnectFourVertical() {     
        instance.addToColumn(player1, 0);
        instance.addToColumn(player2, 1);
        
        instance.addToColumn(player1, 0);
        instance.addToColumn(player2, 1);
        
        instance.addToColumn(player1, 0);
        instance.addToColumn(player2, 1);
        
        instance.addToColumn(player1, 0);
        assertTrue( instance.playerHasWon(player1) );
        assertFalse( instance.playerHasWon(player2) );
    }
    
    @Test
    public void testConnectFourDiagonalLowerRight() {     
        instance.addToColumn(player1, Board.WIDTH - 1);
        instance.addToColumn(player2, Board.WIDTH -  2);
        
        instance.addToColumn(player1, Board.WIDTH -  2);
        instance.addToColumn(player2, Board.WIDTH -  3);
        
        instance.addToColumn(player1, Board.WIDTH -  3);
        instance.addToColumn(player2, Board.WIDTH -  4);
        
        instance.addToColumn(player1, Board.WIDTH -  3);
        instance.addToColumn(player2, Board.WIDTH -  4);
        
        instance.addToColumn(player1, Board.WIDTH -  4);
        instance.addToColumn(player2, 0);
        
        instance.addToColumn(player1, Board.WIDTH -  4);
        
        assertTrue( instance.playerHasWon(player1) );
        assertFalse( instance.playerHasWon(player2) );
    }
    
    @Test
    public void testConnectFourDiagonalLowerLeft() {     
        instance.addToColumn(player1, 0);
        instance.addToColumn(player2, 1);
        
        instance.addToColumn(player1, 1);
        instance.addToColumn(player2, 2);
        
        instance.addToColumn(player1, 2);
        instance.addToColumn(player2, 3);
        
        instance.addToColumn(player1, 2);
        instance.addToColumn(player2, 3);
        
        instance.addToColumn(player1, 3);
        instance.addToColumn(player2, 1);
        
        instance.addToColumn(player1, 3);
        
        assertTrue( instance.playerHasWon(player1) );
        assertFalse( instance.playerHasWon(player2) );
    }
    
    @Test
    public void boardIsFull() {
        
    }
    

    public class BoardImpl extends Board {

        public void displayBoard() {
        }

        public void playerPlays(Cell player) {
        }
    }
    
}
