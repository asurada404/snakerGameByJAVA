package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class GameView {
    private final Grid grid;

    private JPanel canvas;

    public void init(){
        canvas =  new JPanel(){
            @Override
            public void paintComponent(Graphics graphics){
                drawGriBackground(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics,grid.getFood());
            }
        };
    }


    public GameView(Grid grid){
        this.grid =  grid;
    }

    public void draw(){
        Graphics  graphics = canvas.getGraphics();
        drawGriBackground(graphics);
        drawSnake(graphics, grid.getSnake());
        drawFood(graphics, grid.getFood());
        canvas.repaint();
    }

    public JPanel getCanvas(){
        return canvas;
    }

    //draw snake
    public void drawSnake(Graphics graphics, Snake snake) {
        Color c = Color.green;
        Iterator<Node> it = snake.getBody().iterator();
        while (it.hasNext()) {
            Node n = it.next();
            drawSquare(graphics, n, c);
        }
    }

    // draw food
    public void drawFood(Graphics graphics, Node squareArea){
        drawCircle(graphics, grid.getFood(), Color.green);
    }

    // draw background
    public void drawGriBackground(Graphics graphics){
              graphics.setColor(new Color(0,0,0));
        graphics.fillRect(0,0, grid.getWidth()*Settings.DEFAULT_NODE_SIZE,grid.getHeight()*Settings.DEFAULT_NODE_SIZE);
    }

    //snake <-- draw square(snake)
    private void drawSquare(Graphics graphics, Node squareArea, Color color){
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX()*size, squareArea.getY()*size, size-1, size-1);

    }

    //food <-- draw circle(food)
    private void drawCircle(Graphics graphics, Node squareAera, Color color){
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillOval(squareAera.getX()*size, squareAera.getY()*size, size, size);
    }

    //game over message
    public void showGameOverMessage(){
        JOptionPane.showMessageDialog(null, "game over","OVER", JOptionPane.INFORMATION_MESSAGE);
    }

}
