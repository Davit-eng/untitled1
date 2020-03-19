package proj.dir;

public class Board {
    private final int width = 3;
    private final int height = 3;
    private char[][] board = new char[height][width];
    private char currentPlayerMark;

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public void setCurrentPlayerMark(char currentPlayerMark) {
        this.currentPlayerMark = currentPlayerMark;
    }

    public char[][] getBoard() {
        return board;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //region initializing Board
    public void initializingBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = '-';
            }
        }
    }

    //endregion
    //region print board
    public void printBoard() {
        for (int i = 0; i < width * 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j] + "|");

            }
            System.out.print("\n");
        }
        for (int i = 0; i < width * 2 + 1; i++) {
            System.out.print("-");
        }
    }

    //endregion
    //region checkWin
    public boolean checkWin() {
        return (checkWinByColumns() || checkWinByDiagonals() || checkWinByRows());
    }

    //endregion
    //region checkEquality
    private boolean checkEquality(char ch1, char ch2, char ch3) {
        return (ch1 == ch2) && (ch2 == ch3) && (ch3 != '-');
    }

    //endregion
    //region checkWinByRows
    private boolean checkWinByRows() {
        for (int i = 0; i < height; i++) {
                if(checkEquality(board[i][0],board[i][1],board[i][2])){
                   return true;
                }

        }
        return false;
    }

    //endregion
    //region checkWinByColumns
    private boolean checkWinByColumns() {
        for (int i = 0; i < width; i++) {
            if(checkEquality(board[0][i],board[1][i],board[2][i]))
                return true;

        }
        return false;
    }

    //endregion
    //region checkWinByDiagonals
    private boolean checkWinByDiagonals() {
        return (checkEquality(board[0][0],board[1][1],board[2][2])) || (checkEquality(board[0][2],board[1][1],board[2][0]));
    }

    //endregion
    //region isBoardFull
    public boolean isBoardFull(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }
    //endregion
    //region changeCurrentPlayer
    public boolean changeCurrentPlayer(){
        if (currentPlayerMark == 'X'){
            currentPlayerMark = '0';
            return true;
        }else if(currentPlayerMark == '0'){
            currentPlayerMark = 'X';
            return true;
        }else{
            return false;
        }
    }
    //endregion
}
