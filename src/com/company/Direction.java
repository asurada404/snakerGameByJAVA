package com.company;

public enum Direction {
//    public static final int UP = 0;
//    public static final int RIGHT = 1;
//    public static final int DOWN = 2;
//    public static final int LEFT = 3;
    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    //member variables
    private final int directionCode;

    //member methods
    public int directionCode(){
        return directionCode;
    }

    //construct function
    Direction(int directionCode){
        this.directionCode = directionCode;
    }

}
