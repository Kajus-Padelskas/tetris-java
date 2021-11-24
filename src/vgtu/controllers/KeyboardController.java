package vgtu.controllers;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static vgtu.game.Tetris.tetris;

public class KeyboardController {

    final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1024);

    private final Thread thread = new Thread(() -> {
        while (!tetris.isGameOver()) {
            try {
                queue.put(readKeyboardInput());
            } catch (InterruptedException e) {
                System.out.println("Error processing user input..");
            }
        }
    });

    private int readKeyboardInput() {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        if (input != null) {
            switch (input) {
                case "q" -> tetris.setGameOver(true);
                case "a" -> tetris.getTetromino().left();
                case "d" -> tetris.getTetromino().right();
                case "s" -> tetris.getTetromino().maxToBottom();
                case "r" -> tetris.getTetromino().rotateMatrix();
            }
        }
        return 0;
    }

    public Thread getThread() {
        return thread;
    }
}
