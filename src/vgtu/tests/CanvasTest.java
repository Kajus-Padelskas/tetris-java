package vgtu.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vgtu.controllers.FileController;

import java.io.FileNotFoundException;

class CanvasTest {

    @Test
    void readScore() throws FileNotFoundException {
        FileController fileController = new FileController();
        Assertions.assertEquals(200, fileController.readScore());
    }
}