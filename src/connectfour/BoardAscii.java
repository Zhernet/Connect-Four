package connectfour;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BoardAscii extends Board{    
    
    private final Scanner scanner;      
    private final int NUMBER_SHIFT = 1;
    
    
    public BoardAscii(){   
        this.scanner = new Scanner(System.in);
    }
        
    @Override
    public void displayBoard(){
         displayNumbers();
         displayValues();
         System.out.println();
    }
 
    private void displayNumbers(){
        for (int col = 0 + NUMBER_SHIFT; col < WIDTH + NUMBER_SHIFT; col ++)  
             System.out.print("|" + col);
        System.out.println("|");
    }

    private void displayValues(){
        for (int row = 0; row < HEIGHT; row ++)
             displayRow(row);
    }
    
    private void displayRow(int row){
        for (int col = 0; col < WIDTH; col ++) 
            System.out.print("|" + getCellChar(col, row) );
        System.out.println("|");
    }
        
    private String getCellChar(int col, int row){
        if (board[col][row] == null)
            return "_";
        else if (board[col][row] == Cell.PLAYER1)
            return "X";
        else if (board[col][row] == Cell.PLAYER2)
            return "O";
        else return " ";
    }  
    
    @Override
    public void playerPlays(Cell player){     
        
        final String message = String.format("%s, enter a number between %d and %d: ",
                GetPlayerName(player),
                0 + NUMBER_SHIFT,
                WIDTH); 
        try {
            addToColumn(player, askForAColumnNumber(message) );
           
        } catch (NullCellException e) {
            System.out.println("Invalid player!");
            
        } catch (SamePlayerTwiceException e) {
            System.out.println("The same player can't play twice in a row!");
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            playerPlays(player);
        
        } catch (InvalidColumnException e) {
            System.out.println("Invalid column! Choose another column.");
            playerPlays(player);
        
        } catch (ColumnFullException e) {
            System.out.println("Column full! Choose another column.");
            playerPlays(player);
        }
    }
        
    private int askForAColumnNumber(String message){
        System.out.printf(message);
        try { 
            int result = scanner.nextInt();
            return result - NUMBER_SHIFT;
            
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw e;    
        }
    }
    
    private boolean columnCanBeUsed(int column){
        return !columnIsFull(column);
    }
    
}