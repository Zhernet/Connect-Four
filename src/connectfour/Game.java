package connectfour;

abstract public class Game {
    
    private final Board board;
    
    public Game( Board board ) {
        this.board = board;
    }
    
    public void playGame() {        
        board.initialize();
        board.displayBoard();
   
        while ( ! board.isFull() ) {
            for ( Board.Cell player : Board.Cell.values() ) {
                board.playerPlays(player);
                board.displayBoard();
                if ( board.playerHasWon(player) ) {
                    playerWins(player);   
                    return;
                }
            }         
        }    
        
        noWinner();        
    }
    
    protected abstract void playerWins(Board.Cell player);

    protected abstract void noWinner();
    
}
