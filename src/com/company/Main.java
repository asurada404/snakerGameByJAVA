package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        for(Direction direction : Direction.values()){
            System.out.println(direction);
        }

        int code = Direction.DOWN.directionCode();
        System.out.println(code);

        int name = Direction.DOWN.ordinal();
        System.out.println(name);
        Random ran = new Random();
        int ran1 = ran.nextInt(6);
        System.out.println(ran1);
    }
}
