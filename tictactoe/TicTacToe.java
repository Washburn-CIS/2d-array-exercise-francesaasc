import java.util.Scanner;

public class TicTacToe {
    private static char[][] board; 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new char[][]{       // each char is . (nothing places), X or O
            {'.','.','.'},
            {'.','.','.'},
            {'.','.','.'}};

        char turn = 'X';    // X or O
        char winner = '-';  // - means no winner, otherwise X or O
        printBoard();

        for(int placed=0; placed<9 && winner == '-'; placed++) {
            System.out.printf("It is %c's turn%n", turn);
            System.out.print("Enter row for move (1-3): ");
            int r = in.nextInt() - 1;
            System.out.print("Enter column for move (1-3): ");
            int c = in.nextInt() - 1;

             // challenge: prevent the turn from advancing if the user entered bad coordinates

             // process user's move
            board[r][c] = turn;               // save move on the board
            turn = turn == 'X' ? 'O': 'X';    // alternating turns
            printBoard();
            winner = findWinner();
        }
        if(winner != '-') {
            System.out.printf("Game Over: %c wins%n", winner);
        } else {
            System.out.printf("Game Over: no winner%n");
        }
    }

    public static void printBoard() {
        System.out.print("  1 2 3\n  -----\n");
        for(int r=0; r<3; r++) {
            System.out.print(r+1+" ");
            for(int c=0; c<3; c++) {
                System.out.print(board[r][c]);
                if (c<2) System.out.print('|');
            }
            System.out.print("\n  -----\n");
        }
    }

    public static char findWinner() {
        for(int r=0; r<3; r++) {
            // three-in-a-row horizontally
            if(board[r][0] != '.' && board[r][0] == board[r][1] && board[r][1] == board[r][2]) {
                return board[r][0];
            }
        }

        for(int c=0; c<3; c++) {
            // three-in-a-row vertically
            if(board[0][c] != '.' && board[0][c] == board[1][c] && board[1][c] == board[2][c]) {
                return board[0][c];
            }
        }

        // TODO: three-in-a-row vertically 

        // diagonals
        if(board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if(board[0][2] != '.' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][0];
        }
        // TODO: check other diagonal
            
        return '-';
    }
}
