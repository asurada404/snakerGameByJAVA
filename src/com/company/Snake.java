package com.company;

import java.util.LinkedList;
public class Snake {
    private LinkedList<Node> body = new LinkedList<Node>();

    //eat food
    public Node eat(Node food){
        Node bodyHead = getHead();
        if( isNeighbor(bodyHead, food)){
            body.addFirst(food);
            return food;
        }
        else
            return null;
    }

    //  eat food <-- is Neighbor?
    private boolean isNeighbor(Node a , Node b){
        int distanceX = Math.abs(a.getX() - b.getX());
        int distanceY = Math.abs(a.getY() - b.getY());
        return distanceX + distanceY == 1;
    }

    // move
    public Node move(Direction direction){
        Node bodyHead = getHead();
        Node bodyTail = body.pollLast();
        int bodyHeadX = bodyHead.getX();
        int bodyHeadY = bodyHead.getY();
        int newHeadX = 0;
        int newHeadY = 0;
        //judge direction is ok?
        Node bodySecondNode = body.get(1);
        int step = Settings.DEFAULT_NODE_SIZE;
        System.out.println("direction: " + direction.directionCode());
        switch (direction){
            case DOWN:{
                //System.out.println("SWITCH DOWN");
                newHeadX = bodyHeadX;
                newHeadY = bodyHeadY + 1;
                break;
            }
            case UP:{
                //System.out.println("SWITCH UP");
                newHeadX = bodyHeadX;
                newHeadY = bodyHeadY - 1;
                break;
            }
            case LEFT:{
                //System.out.println("SWITCH LEFT");
                newHeadX = bodyHeadX - 1;
                newHeadY = bodyHeadY ;
                break;
            }
            case RIGHT:{
                //System.out.println("SWITCH RIGHT");
                newHeadX = bodyHeadX + 1;
                newHeadY = bodyHeadY;
                break;
            }
        }
        Node newHead = new Node(newHeadX, newHeadY);
        body.addFirst(newHead);
        // get the last node before update;

        //add new head to body
//        System.out.println("newHeadx: " + newHeadX);
//        System.out.println("newHeady: " + newHeadY);
//        System.out.println("Headx: " + bodyHeadX);
//        System.out.println("Heady: " + bodyHeadY);
        body.addFirst(newHead);
        //remove the last node
        body.removeLast();

        return bodyTail;


    }

    // get Head position
    public Node getHead(){
        return this.body.getFirst();
    }
    // add Tail
    public Node addTail(Node area){
        this.body.addLast(area);
        return area;
    }
    // get body
    public LinkedList<Node> getBody() {
        return this.body;
    }

    //get body len
    public int getLen(){
        return this.body.size();
    }


}
