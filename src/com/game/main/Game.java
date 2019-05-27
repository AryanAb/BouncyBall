package com.game.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
//import java.security.spec.ECField;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean isRunning = false;

    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    //private Window win;

    public Game(){
        handler = new Handler();

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Bouncy Ball!", this);
        //win.getPreferredSize(win);

        hud = new HUD();
        spawner = new Spawn(handler, hud);

        handler.addObject(new Player(100, 100, ID.Player, handler));
        handler.addObject(new Tile(100, 200, ID.BounceTile));
        handler.addObject(new DeathTile(300,300, ID.DeathTile));
        handler.addObject(new Star(125, 170, ID.Star));

    }

    public synchronized void start(){
        thread  = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            isRunning = false;
        } catch (Exception e){
            e.printStackTrace();
        }
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

    private void tick(){

        handler.tick();
        hud.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String args[]){

        new Game();

    }

}
