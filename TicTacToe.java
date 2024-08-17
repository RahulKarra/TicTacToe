package TicTacToe;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) throws Exception {

        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        System.out.println("Note: U need to Enter index numbers of 2d arrays as input");
        Scanner in = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("player" + player + "Enter: ");
            int row = in.nextInt();
            int col = in.nextInt();

            if (board[row][col] == ' ') {
                // place the element.
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Player" + player + "has won!");
                } else if(isBoardFull(board)){
                    System.out.println("Its a Draw");
                    gameOver = true;
                } else {
                    // if(player == 'X'){
                    // player = 'O';
                    // } else {
                    // player = 'X';
                    // }
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Move, Try again !");
            }
        }
        System.out.println("Game Over");
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player) {
        // check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // check for columns
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check for diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        // return false if none of this condition is true
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
