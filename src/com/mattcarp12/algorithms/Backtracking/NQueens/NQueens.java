package com.mattcarp12.algorithms.Backtracking.NQueens;

public class NQueens {

    class Board {
        int N;
        boolean[][] board;

        Board(int N) {
            this.N = N;
            board = new boolean[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    board[row][col] = false;
                }
            }
        }

        int numCols() { return N; }

        int numRows() { return N; }

        void placeQueen(int row, int col) {
            if (row >= N || row < 0 || col < 0 || col >= N)
                throw new IllegalArgumentException("Illegal row/col value.");
            board[row][col] = true;
        }

        void removeQueen(int row, int col) {
            if (row >= N || row < 0 || col < 0 || col >= N)
                throw new IllegalArgumentException("Illegal row/col value.");
            board[row][col] = false;
        }

        boolean rowIsClear(int queenRow, int queenCol) {
            for (int j = 0; j < queenCol; j++) {
                if (board[queenRow][j]) return false;
            }
            return true;
        }

        boolean upperDiagIsClear(int queenRow, int queenCol) {
            for (int row = queenRow - 1, col = queenCol - 1;
                 row >= 0 && col >= 0; row--, col--) {
                if (board[row][col]) return false;
            }
            return true;
        }

        boolean lowerDiagIsClear(int queenRow, int queenCol) {
            for (int row = queenRow + 1, col = queenCol - 1;
                 row < N && col >= 0; row++, col--) {
                if (board[row][col]) return false;
            }
            return true;
        }

        boolean isSafe(int queenRow, int queenCol) {
            return rowIsClear(queenRow, queenCol) &&
                    upperDiagIsClear(queenRow, queenCol) &&
                    lowerDiagIsClear(queenRow, queenCol);
        }

        void printBoard() {

        }

        void toListString() {

        }
    }

    public Board board;

    NQueens(int N) {
        this.board = new Board(N);
    }

    public void Solve() {
        Solve(0);
    }

    private boolean Solve(int col) {
        if (col >= board.numCols()) return true;

        for (int row = 0; row < board.numRows(); row++) {
            if (board.isSafe(row, col)) {
                board.placeQueen(row, col);
                boolean trySol = Solve(col + 1);
                if (trySol) return true;
                board.removeQueen(row, col);
            }
            if (col == 0) board.printBoard();
        }
        return false;
    }



}
