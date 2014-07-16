package connectfour;

public class ConnectFour {

    public static void main(String[] args) {
        Game game = new GameAscii( new BoardAscii() );
        game.playGame();
    }
    
}
        