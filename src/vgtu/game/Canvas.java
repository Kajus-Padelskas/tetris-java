package vgtu.game;

import vgtu.controllers.FileController;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static vgtu.game.Colors.*;
import static vgtu.game.Tetris.tetris;

public class Canvas {

    private final int width = 10;
    private final int height = 20;
    private final int[][] tetrominoMatrix;
    private final FileController fileController = new FileController();
    private final Score score = Score.getInstance();

    public int getWidth() {
        return width;
    }

    private int[][] getTetrominoMatrix() {
        return tetris.getTetromino().getTetrominoMatrix();
    }

    public int getHeight() {
        return height;
    }

    private int getY() {
        return tetris.getTetromino().getyAxis();
    }

    private int getX() {
        return tetris.getTetromino().getxAxis();
    }

    public Canvas() {
        tetrominoMatrix = new int[height][width];
    }

    public Integer getCanvasCell(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return null;
        return tetrominoMatrix[y][x];
    }

    public void setCanvasCell(int x, int y, int cell) {
        if (x < 0 || y < 0 || x >= width || y >= height) return;
        tetrominoMatrix[y][x] = cell;
    }

    public void printCanvas() throws FileNotFoundException {
        int[][] tetrisCanvas = getCanvas();
        int[][] tetrominoMatrix = getTetrominoMatrix();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tetrisCanvas[i][j] != 0)
                    if (tetrominoMatrix[0][0] == 1 && tetrominoMatrix[1][0] == 1 && tetrominoMatrix[2][0] == 1 && tetrominoMatrix[2][1] == 1)
                        System.out.printf("%s \u25A0 %s", getAnsiRed(), getAnsiReset());
                    else if (tetrominoMatrix[0][0] == 1 && tetrominoMatrix[1][0] == 1 && tetrominoMatrix[1][1] == 1 && tetrominoMatrix[2][1] == 1)
                        System.out.printf("%s \u25A0 %s", getAnsiGreen(), getAnsiReset());
                    else if (tetrominoMatrix[0][0] == 1 && tetrominoMatrix[0][1] == 1 && tetrominoMatrix[0][2] == 1)
                        System.out.printf("%s \u25A0 %s", getAnsiCyan(), getAnsiReset());
                    else if (tetrominoMatrix[0][0] == 1 && tetrominoMatrix[0][1] == 1 && tetrominoMatrix[1][0] == 1 && tetrominoMatrix[1][1] == 1)
                        System.out.printf("%s \u25A0 %s", getAnsiYellow(), getAnsiReset());
                    else System.out.printf("%s \u25A0 %s", getAnsiPurple(), getAnsiReset());
                else
                    System.out.print(" \u25AB ");
            }
            System.out.println(getAnsiReset());
        }
        IntStream.range(0, 2).mapToObj(i -> getAnsiReset()).forEach(System.out::println);
        System.out.printf("%sYour score is: %d%s%n", getAnsiGreen(), getScore().getScore(), getAnsiReset()).printf("%sHighest score is: %d%s", getAnsiGreen(), fileController.readScore(), getAnsiReset());
        System.out.println();
    }

    public void removeFilledLines() {
        List<int[]> canvasLines = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            int numberOfOnes = 0;
            for (int j = 0; j < width; j++) {
                if (tetrominoMatrix[i][j] != 1) continue;
                numberOfOnes++;
            }
            if (width == numberOfOnes) getScore().setScore(getScore().getScore() + 100);
            else canvasLines.add(tetrominoMatrix[i]);
        }
        while (!(canvasLines.size() >= height)) canvasLines.add(0, new int[width]);
        IntStream.range(0, canvasLines.size()).forEach(i -> tetrominoMatrix[i] = canvasLines.get(i).clone());
    }

    private int[][] getCanvas() {
        int[][] tetrominoMatrix = getTetrominoMatrix();
        int[][] tetrisField = new int[height][width];
        int xAxis = getX();
        int yAxis = getY();
        IntStream.range(0, height).forEach(i -> System.arraycopy(this.tetrominoMatrix[i], 0, tetrisField[i], 0, width));
        for (int i = 0; i < tetrominoMatrix.length; i++)
            for (int j = 0; j < tetrominoMatrix.length; j++)
                if (tetrominoMatrix[i][j] == 1 && (yAxis + i < height && xAxis + j < width))
                    tetrisField[yAxis + i][xAxis + j] = 1;
        return tetrisField;
    }

    public Score getScore() {
        return score;
    }
}