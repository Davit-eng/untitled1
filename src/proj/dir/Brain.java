package proj.dir;

import java.util.Scanner;

public class Brain {
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        Board board = new Board();
        board.setCurrentPlayerMark('X');
        board.initializingBoard();
        System.out.println("----Tic Tac Toe----");
        while (board.isBoardFull() == false) {
            if (board.checkWin() == true) {
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
            if (x - 1 >= board.getWidth() || y-1>=board.getHeight()){
                System.out.println("Sorry, you cant put it here ");
                System.out.println("Try again");
                continue;
            }
                if (board.getBoard()[x - 1][y - 1] == '0' || board.getBoard()[x - 1][y - 1] == 'X') {
                    System.out.println("Sorry,this place has already taken");
                    System.out.println("Try again.");
                    continue;
                } else {
                    putMark(board,x,y);
                }


        }
        System.out.println("Sorry,you cant play any more because the board is full");
    }
    private void putMark(Board board,int x,int y){
        board.getBoard()[x-1][y-1] = board.getCurrentPlayerMark();
        board.changeCurrentPlayer();
    }
}
