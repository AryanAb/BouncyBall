package com.game.main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TextHandler {

    public void write(){

        String path = "C:/Users/Level1.txt";
        File myFile = new File(path);

        if(!myFile.isFile()){
            try {
                PrintWriter writer = new PrintWriter(path, "UTF-8");
            } catch (IOException e){
                e.printStackTrace();
            }
        }



    }

}
