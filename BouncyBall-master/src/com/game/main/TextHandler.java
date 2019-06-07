package com.game.main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;

public class TextHandler {

    private EditorHandler eHandler;
    private LevelEditor editor;

    public TextHandler(EditorHandler eHandler){

        this.eHandler = eHandler;
    }

    public void save(String name, File path){

        String finalPath = path + "/" + name + ".txt";
        File myFile = new File(finalPath);
        System.out.println(path);

        if(!myFile.isFile()){
            try {
                PrintWriter writer = new PrintWriter(path, "UTF-8");
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try{
            PrintWriter writer = new PrintWriter(myFile);
            for(int i = 0; i < eHandler.object.size(); i++){
                GameObject tempObject = eHandler.object.get(i);
                writer.println(tempObject.x + " " + tempObject.y + " " + tempObject.id);
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void load(Handler handler){

        String path = "C:/Users/aryan/Level4.txt";
        File myFile = new File(path);

        try {

            Scanner reader = new Scanner(myFile);

            while(reader.hasNext()) {
                String xString = reader.next();
                String yString = reader.next();
                String idString = reader.next();
                int x = Integer.parseInt(xString);
                int y = Integer.parseInt(yString);

                if(idString.equals("BounceTile")){
                    handler.addObject(new Tile(x, y, ID.BounceTile));
                } else if(idString.equals("DeathTile")){
                    handler.addObject(new DeathTile(x, y, ID.DeathTile));
                } else if(idString.equals("Star")){
                    handler.addObject(new Star(x, y, ID.Star));
                } else if(idString.equals("Player")) {
                    Player player = new Player(x, y, ID.Player, handler);
                    handler.object.addFirst(player);
                    player.velY = +3;
                }

            }

            reader.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
