package connectfour;

public class GameAscii extends Game {
    
    public GameAscii( Board board ) {
        super(board);
    }
    
    @Override
    protected void playerWins(Board.Cell player) {    
        System.out.println( Board.GetPlayerName(player) + " wins!");   
    }

    @Override
    protected void noWinner() {
        System.out.println("Draw.");
    }
    
}
