
public class Philosopher extends Thread {
	int n;
	DiningServer ds;
	public Philosopher(int num, DiningServer ds) {
		n = num;
		this.ds = ds;
	}
	
	@Override
	public void run() {
		int sleepTime = 0;
		while(true) {
			try {
				ds.takeForks(n);
				sleepTime = getSleepTime();
				System.out.println("Philosopher " + (n+1) + " is thinking");
				Thread.sleep(sleepTime);
				
				ds.returnForks(n);
				sleepTime = getSleepTime();
				System.out.println("Philosopher " + (n+1) + " is eating");
				Thread.sleep(sleepTime);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private int getSleepTime() {
		return (int) ((Math.random() * (5000 - 1000)) + 1000);
	}
}