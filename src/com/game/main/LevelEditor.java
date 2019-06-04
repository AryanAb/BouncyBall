package com.game.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;

public class LevelEditor extends Canvas implements Runnable {

    private static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean isRunning = false;

    public LevelEditor(){
        new EditorWindow(WIDTH, HEIGHT, "Editor", this);
    }

    public synchronized void start(){

        thread  = new Thread(this);
        thread.start();
        isRunning = true;

    }

    public synchronized void stop(){

        try{
            thread.join();
            isRunning = false;
        } catch (Exception e){
            System.err.println(e);
        }

    }

    public void tick(){

    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.dispose();
        bs.show();
    }

    public void run(){

        long elpasedTime = System.nanoTime();
        double tickRate = 60.0;
        double ns = 1000000000 / tickRate;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning){
            long now = System.nanoTime();
            delta += (now - elpasedTime) / ns;
            elpasedTime = now;
            while (delta >= 1) {

                tick();
                delta--;
            }
            if(isRunning){
                render();
            }
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    public static void main(String args[]){
        new LevelEditor();
    }

}
