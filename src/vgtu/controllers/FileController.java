package vgtu.controllers;

import java.io.*;
import java.util.Scanner;

public class FileController {
    public void writeRecordToFile(String score) throws IOException {
        BufferedWriter bw;
        File file = new File("score.txt");
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
        bw.write(score);
        bw.flush();
        bw.close();
    }

    public int readScore() throws FileNotFoundException {
        File myObj = new File("score.txt");
        Scanner myReader = new Scanner(myObj);
        String[] words = new String[0];
        while (myReader.hasNextLine()) {
            String input = myReader.nextLine();
            words = input.trim().split(":");
        }
        return Integer.parseInt(words[1]);
    }
}
