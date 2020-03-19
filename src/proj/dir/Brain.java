package proj.dir;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class Brain {
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        Board board = new Board();
        board.setCurrentPlayerMark('X');
        board.initializingBoard();
        System.out.println("----Tic Tac Toe----");
        while (board.isBoardFull() == false) {
            if(board.checkWin() == true){
                board.printBoard();
                System.out.println("\n");
                board.changeCurrentPlayer();
                System.out.println("The great win of " + board.getCurrentPlayerMark());
                return;
            }
            board.printBoard();
            int x, y;
            System.out.println("\n");
            System.out.println("Please enter the coordinate you have chosen ");
            x = scanner.nextByte();
            y = scanner.nextByte();
            if(board.getBoard()[x][y] == '0' || board.getBoard()[x][y] == 'X'){
                System.out.println("Sorry,this place has already taken");
                System.out.println("Try again.");
                continue;
            }else{
                board.getBoard()[x][y] = board.getCurrentPlayerMark();
                board.changeCurrentPlayer();
            }



        }
        System.out.println("Sorry,you cant play any more because the board is full");
    }
}
