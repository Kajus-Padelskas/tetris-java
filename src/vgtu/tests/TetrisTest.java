package vgtu.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vgtu.controllers.FileController;

import java.io.IOException;

class TetrisTest {

    @Test
    void writeRecordToFile() throws IOException {
        FileController fileController = new FileController();
        fileController.writeRecordToFile("Top score:" + 200);
        Assertions.assertEquals(200, fileController.readScore());
    }
}