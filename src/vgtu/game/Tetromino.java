package vgtu.game;

import java.util.stream.IntStream;

import static vgtu.game.Tetris.tetris;

public class Tetromino {

    Canvas canvas = tetris.getCanvas();
    Globals globals = new Globals();

    private int xAxis;
    private int yAxis;
    private int[][] tetrominoMatrix;

    public Tetromino(int xAxis, int yAxis, int[][] tetrominoMatrix) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.tetrominoMatrix = tetrominoMatrix;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public boolean gameOver() {
        return yAxis <= 1;
    }

    public int[][] getTetrominoMatrix() {
        return tetrominoMatrix;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int[][] rotateMatrix() {
        int[][] newArr = new int[globals.getTetrominosMatrixLength()][globals.getTetrominosMatrixLength()];

        if (tetrominoMatrix[0][0] == 1 && tetrominoMatrix[0][1] == 1 && tetrominoMatrix[1][0] == 1 && tetrominoMatrix[1][1] == 1)
            IntStream.range(0, globals.getTetrominosMatrixLength()).forEach(i -> System.arraycopy(this.tetrominoMatrix[i], 0, newArr[i], 0, globals.getTetrominosMatrixLength()));
        else
            for (int i = 0; i < globals.getTetrominosMatrixLength(); i++) {
                int k = 0;
                for (int j = (globals.getTetrominosMatrixLength() - 1); j >= 0; j--) {
                    newArr[i][j] = tetrominoMatrix[k][i];
                    k++;
                }
            }
        tetrominoMatrix = newArr;
        return newArr;
    }

    public void maxToBottom() {
        while (checkCurrentCellAccessibility()) {
            yAxis++;
        }
        yAxis--;
    }

    public void left() {
        xAxis--;
        if (!checkCurrentCellAccessibility())
            xAxis++;
    }

    public void right() {
        xAxis++;
        if (!checkCurrentCellAccessibility())
            xAxis--;
    }

    public void landTetromino() {
        for (int i = 0; i < globals.getTetrominosMatrixLength(); i++)
            for (int j = 0; j < globals.getTetrominosMatrixLength(); j++) {
                if (tetrominoMatrix[i][j] == 0) continue;
                canvas.setCanvasCell(xAxis + j, yAxis + i, 1);
            }
    }

    public boolean checkCurrentCellAccessibility() {
        for (int i = 0; i < globals.getTetrominosMatrixLength(); i++)
            for (int j = 0; j < globals.getTetrominosMatrixLength(); j++) {
                if (tetrominoMatrix[i][j] == 0) continue;
                Integer cell = canvas.getCanvasCell(xAxis + j, yAxis + i);
                if (canvas.getHeight() > yAxis + i && cell != null && cell != 1) continue;
                return false;
            }
        return true;
    }
}