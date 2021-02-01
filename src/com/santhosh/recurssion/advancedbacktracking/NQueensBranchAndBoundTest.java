package com.santhosh.recurssion.advancedbacktracking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NQueensBranchAndBoundTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldValidateQueensPath() {
        // given
        NQueensBranchAndBound branchAndBoundNQueensPath = new NQueensBranchAndBound();

        // when
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int row = 0;
        boolean[] cols = new boolean[n];
        boolean[] nd = new boolean[2 * n - 1];
        boolean[] rd = new boolean[2 * n - 1];
        branchAndBoundNQueensPath.queenTraversalBandB(board, row, cols, nd, rd, "");

        // then
        Assert.assertEquals("0-1, 1-3, 2-0, 3-2, ." + "\n" + "0-2, 1-0, 2-3, 3-1, ." + "\n", out.toString());
    }

}
