package vgtu.game;

import vgtu.controllers.FileController;
import vgtu.controllers.KeyboardController;

import static java.awt.desktop.UserSessionEvent.Reason.LOCK;
import static vgtu.game.Colors.ANSI_RED;
import static vgtu.game.Colors.ANSI_RESET;
import static vgtu.game.TetrominosIndustry.generateTetromino;

public class Tetris {
    private Tetromino tetromino = null;
    private final KeyboardController keyboardController = new KeyboardController();
    private final Canvas canvas = new Canvas();
    public static Tetris tetris = new Tetris();
    public FileController fileController = new FileController();
    private boolean isGameOver = false;

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Tetromino getTetromino() {
        return tetromino;
    }

    public void generateNewFigure() {
        tetromino = generateTetromino((int) (Math.random() * (canvas.getWidth() / 2)), 0);
    }

    public void startGame() throws Exception {
        keyboardController.getThread().start();
        generateNewFigure();
        do {
            tetromino.setyAxis(tetromino.getyAxis() + 1);
            while (!tetromino.checkCurrentCellAccessibility()) {
                tetromino.setyAxis(tetromino.getyAxis() - 1);
                tetromino.landTetromino();
                isGameOver = tetromino.gameOver();
                canvas.removeFilledLines();
                generateNewFigure();
            }
            canvas.printCanvas();
            synchronized (LOCK) {
                LOCK.wait(1000);
            }
        } while (!isGameOver);
        if (fileController.readScore() < canvas.score.getScore())
            fileController.writeRecordToFile(canvas.score.toString());
        System.out.printf("%sGame Over%s%n", ANSI_RED, ANSI_RESET);
    }

    public static void main(String[] args) throws Exception {
        tetris.startGame();
        System.exit(0);
    }
}