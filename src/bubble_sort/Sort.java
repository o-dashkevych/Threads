package bubble_sort;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Oleg Dashkevych on 9/6/2015.
 */
public class Sort {

    private static int[] items;
    private static final int COUNT = 10;
    public static Semaphore sortSemaphore =
            new Semaphore(1, false);
    public static void main(String[] args) {
        items = new int[COUNT];
        System.out.println("\nUnsorted array:");
        for (int i = 0; i < COUNT; i++) {
            items[i] = new Random().nextInt(100);
            System.out.print(items[i] + " ");
        }
        System.out.println("\nSorted array:");
        new Thread(new BubbleSort(items)).start();
        for(int i = 0 ; i < items.length ; ++i) {
            sortSemaphore.acquireUninterruptibly();
            System.out.print(items[i] + " ");
        }
        System.out.println("End");
    }
}
