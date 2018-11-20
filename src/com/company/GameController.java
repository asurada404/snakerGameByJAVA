package com.company;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameController implements Runnable, KeyListener {
    private final Grid grid;
    private final GameView gameView;

    private boolean running;

    public GameController(Grid grid, GameView gameView){
        this.grid = grid;
        this.gameView = gameView;
        this.running = true;
    }

    @Override
    public void run(){
        while(running){
            try{
                Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
            }catch (InterruptedException e){
                break;
            }
            // next step
            boolean next = grid.nextRound();
            if(next == false){
                gameView.showGameOverMessage();
            }
            gameView.draw();
            // end exit
            // continue update

        }
//        running = false;
    }


    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();

        switch(keyCode){
            case  KeyEvent.VK_UP:{
                //System.out.println("VK_UP");
                grid.changeDirection(Direction.UP);
                break;
            }
            case KeyEvent.VK_DOWN:{
                //System.out.println("VK_DOWN");
                grid.changeDirection(Direction.DOWN);
                break;
            }
            case KeyEvent.VK_RIGHT:{
                //System.out.println("VK_RIGHT");
                grid.changeDirection(Direction.RIGHT);
                break;
            }
            case KeyEvent.VK_LEFT:{
                //System.out.println("VK_LEFT");
                grid.changeDirection(Direction.LEFT);
                break;
            }
        }
        System.out.println(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
