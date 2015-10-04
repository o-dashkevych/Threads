package priority;

public class App02 {
	public static void main(String... args) {
		ThreadGroup tg1 = new ThreadGroup("Tg1");
		ThreadObj obj1 = new ThreadObj(tg1, "Igor", Thread.MAX_PRIORITY);
	//	obj1.start();
		obj1.setDaemon(true);
		obj1.start();
		System.out.println("Main end");
		
	}

}
