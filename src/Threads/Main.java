package Threads;

public class Main { public static void main(String[] args) throws InterruptedException {

    Thread1 threadRun = new Thread1();
    Thread thread1 = new Thread(threadRun);

    Thread2 threadRun2 = new Thread2();
    Thread thread2 = new Thread(threadRun2);

    thread1.start();
    thread1.join();
    thread2.start();
}
}