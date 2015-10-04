package sort;

import java.util.Random;
import java.util.concurrent.Semaphore;
public class Sort {
    public static final int ITEMS_COUNT = 15;
    public static int items[];
    // семафор, контролирующий разрешение на доступ к элементам массива
    public static Semaphore sortSemaphore =
            new Semaphore(0, true);
    public static void main(String[] args) {
        items = new int[ITEMS_COUNT];
        for(int i = 0 ; i < items.length ; ++i)
            items[i] = new Random().nextInt(100);
        new Thread(new ArraySort(items)).start();
        for(int i = 0 ; i < items.length ; ++i) {
/*
* при проверке доступности элемента сортируемого
* массива происходит блокировка главного потока
* до освобождения семафора
*/
            sortSemaphore.acquireUninterruptibly();
            System.out.print(items[i] + " ");
        }
    }
}
