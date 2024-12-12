/**
 * Problem: N-Queens Problem
 * Concept: Place N queens on an N x N chessboard such that no two queens threaten each other.
 * - A queen can attack in the same row, column, or diagonals.
 * - The goal is to find all possible arrangements where the queens do not threaten each other.
 * 
 * Approach:
 * 1. Use a backtracking algorithm to explore all possible configurations of queens on the board.
 * 2. Place queens row by row and check if the placement is safe:
 *    - No queen in the same column.
 *    - No queen on the upper-left diagonal.
 *    - No queen on the upper-right diagonal.
 * 3. If a valid placement is found for all rows, print the solution.
 * 4. Backtrack if a configuration is invalid, and try the next possible position.
 * 
 * Time Complexity: O(N!)
 * - The algorithm places queens row by row. For each row, it tries all columns. The number of possibilities decreases as queens are placed.
 * - Worst case: For the first row, there are N possibilities, for the second, N-1, and so on.
 * - Total possibilities ≈ N!.
 * 
 * Space Complexity: O(N^2)
 * - The board uses O(N^2) space to store the chessboard. The recursion stack uses O(N) space for function calls.
 * 
 * Example Output for N = 4:
 * Solution 1:
 * Q . . . 
 * . . Q . 
 * . . . Q 
 * . Q . . 
 * 
 * Solution 2:
 * Q . . . 
 * . . . Q 
 * . Q . . 
 * . . Q . 
 * 
 * Total solutions: 2
 */

 public class NQueensFixed {
    // Fixed size for the chessboard (4x4)
    static int N = 4; 
    // Counter to keep track of the number of solutions found
    static int solutionCount = 0; 

    public static void main(String[] args) {
        // Initialize the chessboard with '.'
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.'; // '.' indicates an empty cell
            }
        }

        // Start solving the N-Queens problem
        solveNQueens(board, 0);

        // Print the total number of solutions found
        System.out.println("Total solutions: " + solutionCount);
    }

    /**
     * Recursive function to solve the N-Queens problem.
     * 
     * @param board The current state of the chessboard.
     * @param row   The current row to place a queen.
     */
    private static void solveNQueens(char[][] board, int row) {
        // Base case: If all queens are placed, print the solution
        if (row == N) {
            printBoard(board);
            solutionCount++; // Increment the solution counter
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                // Place the queen if the position is safe
                board[row][col] = 'Q';

                // Recurse to place the queen in the next row
                solveNQueens(board, row + 1);

                // Backtrack: Remove the queen from the current position
                board[row][col] = '.';
            }
        }
    }

    /**
     * Function to check if placing a queen at (row, col) is safe.
     * 
     * @param board The current state of the chessboard.
     * @param row   The row to check.
     * @param col   The column to check.
     * @return True if the position is safe, false otherwise.
     */
    private static boolean isSafe(char[][] board, int row, int col) {
        // Check if any queen is in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // The position is safe
        return true;
    }

    /**
     * Function to print the current state of the chessboard.
     * 
     * @param board The chessboard to print.
     */
    private static void printBoard(char[][] board) {
        System.out.println("Solution " + (solutionCount + 1) + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
