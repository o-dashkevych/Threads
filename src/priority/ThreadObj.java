package priority;

public class ThreadObj extends Thread{

	public ThreadObj(String name) {
		super(name);
	}
	
	public ThreadObj(ThreadGroup tg, String name, int priority) {
		super(tg, name);
		setPriority(priority);
	}
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("I`m a " + getName());
		}
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
