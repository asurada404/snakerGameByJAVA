package com.company;
import java.util.Arrays;
import java.util.Random;

public class Grid {

    public final boolean[][] status;
    private final int width ;
    private final int height ;


    private Snake snake;
    private Node food;

    private Direction snakeDirection = Direction.LEFT;

    public Grid(int width, int height){
        this.width  = width;
        this.height = height;

        status  =  new boolean[width][height];
        for(int i = 0; i < width; i++ ){
                Arrays.fill(status[i], false);

        }
        initSnake();
        createFood();
    }
    // initialize snake
    private Snake initSnake(){
        snake =  new Snake();
        int y = height/2;
        for(int i = width/2; i < width*5/6; i++ ){
            int x = i;
            Node  node1 = new Node(x,y);
            snake.addTail(node1);
            status[x][y] = true;
        }
        return snake;
    }

    // create food
    public Node createFood(){
        Random ran = new Random();
        int x = ran.nextInt(width);
        int y = ran.nextInt(height);
        this.food =  new Node(x,y);
        return this.food;

    }

    //next step: true or false
    public boolean nextRound(){
        Node snakeHead = snake.getHead();
        if(!isBoundary(snakeHead)){
            Node snakeTail = snake.move(snakeDirection);
            System.out.println("Next step!");
            if(headIsFood(snakeHead, food)){
                System.out.println("head is food");
                snake.addTail(snakeTail);
                int score = snake.getLen();
                System.out.println("!!!Score: " + score);
                createFood();
            }
            return true;

        }
        System.out.println(isBoundary(snakeHead));
        return false;
    }

    // next step <-- boundary?
    private boolean isBoundary(Node head){
        int x = head.getX();
        int y = head.getY();
        if(x == 0 || y == 0 || x == width || y == height){
            return true;
        }
        else
            return false;
    }

    //next step <-- head is food?
    private boolean headIsFood(Node head, Node food){
        if(head.getX() == food.getX() && head.getY() == food.getY()){
            return true;
        }
        else
            return false;
    }

    //change direction
    public void changeDirection(Direction newDirection){
        //System.out.println("newDirection: " + newDirection.directionCode());
        //System.out.println("snakeDirection: " + snakeDirection.directionCode());
        if(!snakeDirection.equals(newDirection)){
            snakeDirection = newDirection;
        }
        return;
    }

    public Snake getSnake(){
        return snake;

    }
    public Node getFood(){
        return food;

    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }



}
