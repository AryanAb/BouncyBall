/**TextHandler.java
  * Joon Kim and Aryan Abed
  * June 12th 2019
  * To handle text and load the map into the game
  */


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;

public class TextHandler {
  
  private EditorHandler eHandler;
  
  public TextHandler(EditorHandler eHandler){
    
    this.eHandler = eHandler;
  }

  /**
   *
   * @param name
   * @param path
   */
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
        if(tempObject.id == ID.HBoost){
          writer.println(tempObject.x + " " + tempObject.y + " " + tempObject.id + " " + ((HBoost) tempObject).direction);
        } else {
          writer.println(tempObject.x + " " + tempObject.y + " " + tempObject.id);
        }
      }
      writer.close();
    } catch (IOException e){
      e.printStackTrace();
    }
    
  }

  /**
   *
   * @param handler
   * @param level the level of the game
   */
  public void load(Handler handler, int level){
    
    String path = "Levels/Level" + level+ ".txt";
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
          HUD.numStars++;
        } else if(idString.equals("Player")) {
          Player player = new Player(x, y, ID.Player, handler);
          handler.object.addFirst(player);
          player.velY = +3;
        }else if(idString.equals("HBoost")){
          String directionString = reader.next();
          int direction = Integer.parseInt(directionString);
          handler.addObject(new HBoost(x, y, ID.HBoost, direction));
        } else if(idString.equals("VBoost")){
          handler.addObject(new VBoost(x, y, ID.VBoost));
        }
        
      }

      reader.close();
      HUD.startingTime();
      
    } catch (IOException e){
      e.printStackTrace();
    }

    level++;
  }
  
}