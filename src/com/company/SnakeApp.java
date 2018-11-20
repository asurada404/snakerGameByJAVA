package com.company;

import javax.swing.*;
import java.awt.*;
import java.lang.Runnable;


public class SnakeApp implements  Runnable{

    public void init(){

        //init grid
        Grid  grid = new Grid(Settings.DEFAULT_GRID_WIDTH,Settings.DEFAULT_GRID_HEIGHT);

        // init game windows
        JFrame window = new JFrame("snake game");
        Container contentPane = window.getContentPane();

        //init game view
        GameView gameView = new GameView(grid);
        gameView.init();

        int ns = Settings.DEFAULT_NODE_SIZE;
        //set windows size
        gameView.getCanvas().setPreferredSize( new Dimension(Settings.DEFAULT_GRID_WIDTH * ns, Settings.DEFAULT_GRID_HEIGHT * ns));
        contentPane.add(gameView.getCanvas(),BorderLayout.CENTER);

        GameController gameController = new GameController(grid, gameView);
        window.addKeyListener(gameController);
        new Thread(gameController).start();

        // windows size
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //rendering
        window.pack();
        window.setVisible(true);

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new SnakeApp());
        SnakeApp snakeApp =  new SnakeApp();
        snakeApp.init();
    }

    @Override
    public void run() {

    }
}
