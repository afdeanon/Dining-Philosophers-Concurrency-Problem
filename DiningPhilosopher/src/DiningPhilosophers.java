
public class DiningPhilosophers {
	public static int NUM_OF_PHILOSOPHERS = 5;
	public static void main(String[] args) {
		DiningServer ds = new DiningService();
		for(int i=0;i<NUM_OF_PHILOSOPHERS;i++) {
			new Philosopher(i,ds).start();
		}
	}	

}