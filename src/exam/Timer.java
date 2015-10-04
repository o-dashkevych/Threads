package exam;

public class Timer extends Thread{

	@Override
	public void run() {
		for (int i = 5214;; i++) {
			System.out.println("Year " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
