package semaphore.repo;

/**
 * Created by Oleg Dashkevych on 9/6/2015.
 */
public class RepoRun {
    public static void main(String args[]) {
        Repository rp = new Repository(5);
        Thread[] thread = new Thread[20];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(String.valueOf(i)) {
                @Override
                public void run() {
                    rp.put(new Object());
                }
            };
        }
        for (Thread th : thread) {
            th.start();
        }
    }
}



