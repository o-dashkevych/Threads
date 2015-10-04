package semaphore.repo;

import java.util.Hashtable;
import java.util.concurrent.Semaphore;

/**
 * Created by Oleg Dashkevych on 9/6/2015.
 */
public class Repository {

    private final Semaphore semaphore;

    private Hashtable<Integer, Object> table;

    public Repository(){
        this(10,10);
    }

    public Repository(int connections, int capacity){
        if(connections<=0 || capacity <= 0) throw new IllegalArgumentException();
        semaphore = new Semaphore(connections);
        table = new Hashtable<>(capacity);
    }

    public Repository(int connections){
        this(connections,10);
    }


    public void put(Object obj){
        try {
            semaphore.acquire();
            table.put(obj.hashCode(), obj);
            System.out.println("Thread #" + Thread.currentThread().getName() + " putted an obj " + obj.hashCode());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println("_Thread #" + Thread.currentThread().getName() + " putted an obj " + obj.hashCode());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Object get(Object key){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object item = table.get(key);
        System.out.println("Thread #" + Thread.currentThread().getName() + " got an obj " + item.hashCode());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        return item;
    }
}
