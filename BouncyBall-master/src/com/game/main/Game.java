package com.game.main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1500, HEIGHT = WIDTH / 16 * 9;

    private Thread thread;
    private boolean isRunning = false;

    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    private Window win;
    private Player player;

    public enum STATE{
        Menu,
        LevelEditor,
        Game
    };

    public STATE gameState = STATE.Menu;

    public Game(){

        handler = new Handler();
        menu = new Menu(this, handler);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);

        win = new Window(WIDTH, HEIGHT, "Bouncy Ball!", this);
        //win.getPreferredSize(win);

        hud = new HUD();
        spawner = new Spawn(handler, hud);

    }

    public synchronized void start(){
        /*try {
            File file = new File("C:/Users/aryan/IdeaProjects/BouncyBall/Assets/Europe_The_Final_Countdown_Instrumental.wav");
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e){
            System.err.println(e);
        }*/
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
        if(gameState == STATE.Game){
            hud.tick();
        } else if(gameState == STATE.Menu){
            menu.tick();
        } else if(gameState == STATE.LevelEditor){
            win.toggleVisibility();
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());

        handler.render(g);

        if(gameState == STATE.Game){
            hud.render(g);
        } else if(gameState == STATE.Menu){
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static void main(String args[]){

        new Game();

    }

}
