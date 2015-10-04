package bubble_sort;

/**
 * Created by Oleg Dashkevych on 9/6/2015.
 */
public class BubbleSort implements Runnable{

    private int[] items;

    public BubbleSort(int[] items) {
        this.items = items;
    }

    @Override
    public void run() {
        System.out.println("RUN");

        boolean swaped = true;

        while (swaped) {


            System.out.println("WHILE");
            swaped = false;
            for (int j = 1; j < items.length; j++) {
                if (items[j - 1] > items[j]) {
                    int tmp = items[j];
                    items[j] = items[j - 1];
                    items[j - 1] = tmp;
                    swaped = true;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.err.print(e);
                }
            }
        }


    }
}
