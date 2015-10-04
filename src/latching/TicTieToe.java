package latching;


// Latch imitation

public class TicTieToe {
    private volatile String name;
    private volatile boolean ready;

    public String getReading(){
        while (!ready){
            System.out.println(Thread.currentThread().getName() + " is waiting....");
            Thread.yield();
        }return name;
    }

    public void setValue(String  val){
        name = val;
        System.out.println(Thread.currentThread().getName() + " set value = " + name);
        ready = true;
    }
}
