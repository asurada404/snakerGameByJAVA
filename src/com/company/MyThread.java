package com.company;

class MyThread implements Runnable {
    public void run(){

    }
    public static void main(String[] args){
        MyThread thread = new MyThread();
        new Thread(thread).start();
    }

}


