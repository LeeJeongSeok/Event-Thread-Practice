package com.lee.practice;

public class ThreadTest extends Thread{

    public void run() {
        System.out.println(Thread.currentThread().getName() + "thread run");

        try {
            Thread.sleep(5000);
        } catch(Exception e) {

        }

        System.out.println(Thread.currentThread().getName()  + "thread end");
    }

    public static void main(String[] args) {
        for (int i = 0; i<10; i++) {
            new ThreadTest().start();
        }

        System.out.println("main end");
    }
}
