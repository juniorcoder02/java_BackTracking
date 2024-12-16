// N-Knights Problem: Place N knights on an N x N chessboard such that no two knights attack each other.
// Approach: Backtracking

public class NKnightProblem {

    static int count = 0; // To count the number of valid solutions

    /**
     * Function to check if placing a knight at (row, col) is safe.
     *
     * @param row   Current row on the board
     * @param col   Current column on the board
     * @param board The chessboard represented as a boolean array
     * @param N     Size of the board (N x N)
     * @return True if it's safe to place a knight, False otherwise
     */
    static boolean isSafe(int row, int col, boolean[][] board, int N) {
        // Possible moves a knight can make
        int[] rowMoves = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] colMoves = {-1, 1, -2, 2, -2, 2, -1, 1};

        // Check all 8 possible knight moves for potential attacks
        for (int i = 0; i < 8; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];

            if (newRow >= 0 && newCol >= 0 && newRow < N && newCol < N && board[newRow][newCol]) {
                return false; // Unsafe as another knight can attack
            }
        }

        return true; // Safe to place the knight
    }

    /**
     * Backtracking function to solve the N-Knights problem.
     *
     * @param row           Current row on the board
     * @param col           Current column on the board
     * @param knightsPlaced Number of knights placed so far
     * @param N             Size of the board (N x N)
     * @param board         The chessboard represented as a boolean array
     */
    static void solveNKnights(int row, int col, int knightsPlaced, int N, boolean[][] board) {
        // Base Case: If all knights are placed
        if (knightsPlaced == N) {
            count++;
            printBoard(board, N); // Print the valid board configuration
            return;
        }

        // If we go past the last row, stop recursion
        if (row >= N) return;

        // Try placing a knight at (row, col)
        if (isSafe(row, col, board, N)) {
            board[row][col] = true; // Place the knight

            // Move to the next cell
            if (col + 1 < N) {
                solveNKnights(row, col + 1, knightsPlaced + 1, N, board);
            } else {
                solveNKnights(row + 1, 0, knightsPlaced + 1, N, board);
            }

            board[row][col] = false; // Backtrack (remove the knight)
        }

        // Skip the current cell and move to the next
        if (col + 1 < N) {
            solveNKnights(row, col + 1, knightsPlaced, N, board);
        } else {
            solveNKnights(row + 1, 0, knightsPlaced, N, board);
        }
    }

    /**
     * Function to print the chessboard configuration.
     *
     * @param board The chessboard represented as a boolean array
     * @param N     Size of the board (N x N)
     */
    static void printBoard(boolean[][] board, int N) {
        System.out.println("Solution " + count + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] ? "K " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Main method to run the N-Knights Problem.
     */
    public static void main(String[] args) {
        // Step 1: Define the board size (N x N)
        int N = 4; // Change N to try different board sizes

        // Step 2: Initialize the chessboard as a boolean array
        boolean[][] board = new boolean[N][N];

        // Step 3: Start solving the problem using backtracking
        solveNKnights(0, 0, 0, N, board);

        // Step 4: Output the total number of solutions
        System.out.println("Total Solutions: " + count);
    }
}

/**
 * Approach:
 * 1. Start with an empty board and place knights one by one using recursion and backtracking.
 * 2. Use the `isSafe` function to ensure no two knights attack each other.
 * 3. If a configuration is valid (all N knights placed), print the board.
 * 4. Backtrack if a knight cannot be placed in a valid position.
 *
 * Time Complexity:
 * - In the worst case, there are N^2 cells to consider for each of the N knights.
 * - Complexity is approximately O(N! * N^2) due to backtracking.
 *
 * Space Complexity:
 * - O(N^2) for the board.
 * - O(N) for the recursion stack.
 */
