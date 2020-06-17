package com.lee.practice;

public class ThreadTest3 implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "쓰레드가 출근했습니다.");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }

        System.out.println(Thread.currentThread().getName() + "쓰레드가 퇴근했습니다.");
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i< 10; i++) {
            new Thread(new ThreadTest3()).start();
        }

        for (int i = 0; i< 10; i++) {
            new Thread(new ThreadTest3()).join();
        }

        System.out.println("main 종료");
    }
}
