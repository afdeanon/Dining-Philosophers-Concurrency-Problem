import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningService implements DiningServer {
	static int NUM_OF_PHILOSOPHERS = 5;
	ReentrantLock key[] = new ReentrantLock[NUM_OF_PHILOSOPHERS];
	Condition chopstick[] = new Condition[NUM_OF_PHILOSOPHERS];
	public DiningService() {
		for(int i=0;i<NUM_OF_PHILOSOPHERS;i++) {
			key[i] = new ReentrantLock();
			chopstick[i] = key[i].newCondition();
		}
	}

	@Override
	public void takeForks(int philosopherNumber) {
		try {
			if(key[philosopherNumber].getHoldCount() > 0)
				chopstick[philosopherNumber].await();
			if(key[(philosopherNumber+1)%4].getHoldCount() > 0)
				chopstick[(philosopherNumber+1)%4].await();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void returnForks(int philosopherNumber) {
		try {
			if(key[philosopherNumber].getHoldCount() > 0)
				chopstick[philosopherNumber].signal();
			if(key[(philosopherNumber+1)%4].getHoldCount() > 0)
				chopstick[(philosopherNumber+1)%4].signal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
