package thread;

public class BackgroundLogger extends Thread {

	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("Background Logging.." + i);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}
}
