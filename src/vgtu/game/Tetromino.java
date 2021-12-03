package vgtu.game;

import java.util.stream.IntStream;

import static vgtu.game.Tetris.tetris;

public class Tetromino {

    private final Canvas canvas = tetris.getCanvas();
    private final Globals globals = new Globals();
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
        int[][] newArr = new int[getGlobals().getTetrominosMatrixLength()][getGlobals().getTetrominosMatrixLength()];

        if (tetrominoMatrix[0][0] == 1 && tetrominoMatrix[0][1] == 1 && tetrominoMatrix[1][0] == 1 && tetrominoMatrix[1][1] == 1)
            IntStream.range(0, getGlobals().getTetrominosMatrixLength()).forEach(i -> System.arraycopy(this.tetrominoMatrix[i], 0, newArr[i], 0, getGlobals().getTetrominosMatrixLength()));
        else
            for (int i = 0; i < getGlobals().getTetrominosMatrixLength(); i++) {
                int k = 0;
                for (int j = (getGlobals().getTetrominosMatrixLength() - 1); j >= 0; j--) {
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
        for (int i = 0; i < getGlobals().getTetrominosMatrixLength(); i++)
            for (int j = 0; j < getGlobals().getTetrominosMatrixLength(); j++) {
                if (tetrominoMatrix[i][j] == 0) continue;
                getCanvas().setCanvasCell(xAxis + j, yAxis + i, 1);
            }
    }

    public boolean checkCurrentCellAccessibility() {
        for (int i = 0; i < getGlobals().getTetrominosMatrixLength(); i++)
            for (int j = 0; j < getGlobals().getTetrominosMatrixLength(); j++) {
                if (tetrominoMatrix[i][j] == 0) continue;
                if (getCanvas().getHeight() > yAxis + i && getCell(i, j) != null && getCell(i, j) != 1) continue;
                return false;
            }
        return true;
    }

    private Integer getCell(int i, int j) {
        Integer cell = getCanvas().getCanvasCell(xAxis + j, yAxis + i);
        return cell;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Globals getGlobals() {
        return globals;
    }

}