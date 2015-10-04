package exam;

public class ChristBirth implements Runnable {

	private void newEra(){
		System.out.println("New Claendar have been started!");
		for (int i = 0; i <= 2015; i++) {
			try {
				System.out.println("Year: " + i);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Override
	public void run() {
		newEra();
	}

}
