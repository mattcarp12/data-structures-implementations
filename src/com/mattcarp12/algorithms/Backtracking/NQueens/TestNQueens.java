package com.mattcarp12.algorithms.Backtracking.NQueens;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestNQueens {

    @Test
    public void testBoard () {
        NQueens q = new NQueens(4);
        q.board.placeQueen(0,0);
        q.board.placeQueen(2,1);
        assertFalse(q.board.rowIsClear(2,2));
        assertTrue(q.board.lowerDiagIsClear(2,2));
        assertFalse(q.board.upperDiagIsClear(2,2));
    }

    @Test
    public void testSolve() {
        NQueens q = new NQueens(5);
        q.Solve();
    }
}
