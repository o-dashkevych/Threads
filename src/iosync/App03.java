package iosync;

import java.io.IOException;

public class App03 {

    public static void main(String[] args) {
        try {
            Synchro s = new Synchro("data.txt");
            MyThread t1 = new MyThread("First", s);
            MyThread t2 = new MyThread("Second", s);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            s.close();
        } catch (IOException e) {
            System.err.print("������ �����");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.print("������ ������");
            e.printStackTrace();
        }
    }

}
