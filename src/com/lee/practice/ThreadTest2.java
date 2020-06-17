package com.lee.practice;

import java.util.ArrayList;

public class ThreadTest2 implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
        }
        System.out.println(Thread.currentThread().getName() + " thread end.");
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new ThreadTest2());
            t.start();
            threads.add(t);
        }

        for(int i=0; i<threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            }catch(Exception e) {
            }
        }
        System.out.println("main end.");
    }

}
