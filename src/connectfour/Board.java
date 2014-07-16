package connectfour;

abstract public class Board {
    
    protected static final int WIDTH = 7;
    protected static final int HEIGHT = 6;
    static public enum Cell { PLAYER1, PLAYER2 };
    protected final Cell[][] board = new Cell[WIDTH][HEIGHT];  
    private Cell lastPlayedPlayer;
    
    public abstract void displayBoard();
    
    public void initialize(){
        for (int col = 0; col < WIDTH; col ++)   
            for (int row = 0; row < HEIGHT; row++)
                board[col][row] = null;
        
        lastPlayedPlayer = null;
    }
    
    public abstract void playerPlays(Cell player);
    
    public Boolean isFull(){
        for (int col = 0; col < WIDTH; col ++)   
            if (!columnIsFull(col))
                return false;
        return true;
    }    
        
    protected Boolean columnIsFull(int col){
        for (int row = 0; row < HEIGHT; row++)
            if (board[col][row] == null)
                return false;
        return true;
    }   
   
    protected void addToColumn(Cell disc, int column){
        if (disc == null)
            throw new NullCellException();
        if (disc == lastPlayedPlayer)
            throw new SamePlayerTwiceException();
        if (column < 0)
            throw new InvalidColumnException();
        if (column >= WIDTH)
            throw new InvalidColumnException();        
        if (columnIsFull(column))
            throw new ColumnFullException();
        
        for (int row = HEIGHT -1; row >= 0; row--)
            if (board[column][row] == null) {
                board[column][row] = disc;
                lastPlayedPlayer = disc;
                return;
            }
    }    
    
    public static String GetPlayerName(Cell player){
        switch (player) {
            case PLAYER1:
                return "PLAYER 1";
            case PLAYER2:
                return "PLAYER 2";
            default:
                return "ERROR";
        }                
    }
    
    public boolean playerHasWon(Cell player) {
        if (HorizontalConnectFour(player))
            return true;
        if (VerticalConnectFour(player))
            return true;
        if (DiagonalLowerRightConnectFour(player))
            return true;
        if (DiagonalLowerLeftConnectFour(player))
            return true;
        return false;
    }
    
    private boolean HorizontalConnectFour(Cell disc) {
        for (int col = 0; col < WIDTH - 3; col++)
            for (int row = 0; row < HEIGHT; row++)
                if (board[col][row] == disc &&
                board[col + 1][row] == disc &&
                board[col + 2][row] == disc &&
                board[col + 3][row] == disc)
                    return true;
        
        return false;        
    }
     
    private boolean VerticalConnectFour(Cell disc) {
        for (int col = 0; col < WIDTH; col++)
            for (int row = 0; row < HEIGHT - 3; row++)
                if (board[col][row] == disc &&
                board[col][row + 1] == disc &&
                board[col][row + 2] == disc &&
                board[col][row + 3] == disc)
                    return true;
        
        return false;        
    }  
        
    private boolean DiagonalLowerRightConnectFour(Cell disc) {
        for (int col = 0; col < WIDTH - 3; col++)
            for (int row = 0; row < HEIGHT - 3; row++)            
                if (board[col][row] == disc &&
                board[col + 1][row + 1] == disc &&
                board[col + 2][row + 2] == disc &&
                board[col + 3][row + 3] == disc)
                    return true;
        
        return false;        
    }   
    
    private boolean DiagonalLowerLeftConnectFour(Cell disc) {
        for (int col = 0; col < WIDTH - 3; col++)
            for (int row = 3; row < HEIGHT; row++)            
                if (board[col][row] == disc &&
                    board[col + 1][row - 1] == disc &&
                    board[col + 2][row - 2] == disc &&
                    board[col + 3][row - 3] == disc)
                        return true;
        
        return false;        
    }   
    
}
