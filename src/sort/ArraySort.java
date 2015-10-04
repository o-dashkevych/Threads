package sort;

public class ArraySort implements Runnable {
    private int items[];
    public ArraySort(int items[]) {
        this.items = items;
    }
    public void run(){
        for(int i = 0 ; i < items.length - 1 ; ++i) {
            for(int j = i + 1 ; j < items.length ; ++j) {
                if( items[i] < items[j] ) {
                    int tmp = items[i];
                    items[i] = items[j];
                    items[j] = tmp;
                }
            }
// освобождение семафора
            Sort.sortSemaphore.release();
            try {
                Thread.sleep(71);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
        Sort.sortSemaphore.release();
    }
}
