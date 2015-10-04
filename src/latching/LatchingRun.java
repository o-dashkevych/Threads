package latching;

/**
 * Created by Oleg Dashkevych on 9/8/2015.
 */
public class LatchingRun {

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        TicTieToe ticTieToe = new TicTieToe();
        for (int i = 0; i < 10; i++) {
            if(i % 2 != 0) {
                threads[i] = new Thread("Thread #" + i) {
                    @Override
                    public void run() {
                        ticTieToe.setValue(this.getName());
                    }
                };
            }
            else{
                threads[i] = new Thread("Thread #" + i) {
                    @Override
                    public void run() {
                        ticTieToe.getReading();
                    }
                };
            }
        }
        for (Thread th : threads) {
            th.start();
        }
    }
}
