package vgtu.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vgtu.game.Tetromino;

class TetrominoTest {

    @Test
    void rotateMatrixTest() {
        int[][] matrix = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 0}
        };
        int[][] matrixEx = {
                {1, 1, 1},
                {1, 0, 0},
                {0, 0, 0}
        };
        Tetromino tetromino = new Tetromino(20, 20, matrix);
        Assertions.assertArrayEquals(matrixEx, tetromino.rotateMatrix());
    }

    @Test
    void rotateMatrixTest1() {
        int[][] matrix = {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 0}
        };
        int[][] matrixEx = {
                {0, 1, 1},
                {1, 1, 0},
                {0, 0, 0}
        };
        Tetromino tetromino = new Tetromino(20, 20, matrix);
        Assertions.assertArrayEquals(matrixEx, tetromino.rotateMatrix());
    }

    @Test
    void rotateMatrixTest2() {
        int[][] matrix = {
                {1, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] matrixEx = {
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 1}
        };
        Tetromino tetromino = new Tetromino(20, 20, matrix);
        Assertions.assertArrayEquals(matrixEx, tetromino.rotateMatrix());
    }

    @Test
    void rotateMatrixTest3() {
        int[][] matrix = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        int[][] matrixEx = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        Tetromino tetromino = new Tetromino(20, 20, matrix);
        Assertions.assertArrayEquals(matrixEx, tetromino.rotateMatrix());
    }

    @Test
    void rotateMatrixTest4() {
        int[][] matrix = {
                {1, 1, 1},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] matrixEx = {
                {0, 0, 1},
                {0, 1, 1},
                {0, 0, 1}
        };
        Tetromino tetromino = new Tetromino(20, 20, matrix);
        Assertions.assertArrayEquals(matrixEx, tetromino.rotateMatrix());
    }


    @Test
    void getTetrominoMatrix() {
        int[][] matrix = {
                {1, 1, 1},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] matrixEx = {
                {1, 1, 1},
                {0, 1, 0},
                {0, 0, 0}
        };
        Tetromino tetromino = new Tetromino(20, 20, matrix);
        Assertions.assertArrayEquals(matrixEx, tetromino.getTetrominoMatrix());
    }

    @Test
    void getTetrominoMatrix1() {
        int[][] matrix = {
                {1, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] matrixEx = {
                {1, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
        };
        Tetromino tetromino = new Tetromino(20, 20, matrix);
        Assertions.assertArrayEquals(matrixEx, tetromino.getTetrominoMatrix());
    }

    @Test
    void getTetrominoMatrix2() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 0}
        };
        int[][] matrixEx = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 0}
        };
        Tetromino tetromino = new Tetromino(20, 20, matrix);
        Assertions.assertArrayEquals(matrixEx, tetromino.getTetrominoMatrix());
    }


    @Test
    void checkCurrentCellAccessibilityTrue() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 0}
        };
        Tetromino tetromino = new Tetromino(5, 10, matrix);
        Assertions.assertTrue(tetromino.checkCurrentCellAccessibility());
    }

    @Test
    void checkCurrentCellAccessibilityFalse() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 0}
        };
        Tetromino tetromino = new Tetromino(11, 10, matrix);
        Assertions.assertFalse(tetromino.checkCurrentCellAccessibility());
    }
}