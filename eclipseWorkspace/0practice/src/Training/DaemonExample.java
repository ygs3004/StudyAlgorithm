package Training;

public class DaemonExample {

	public static void main(String[] args) {
		AutoSaveThread autoSaveThread=new AutoSaveThread();
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			
		}
		System.out.println("메인 스레드 종료");
		autoSaveThread.interrupt();
	}

}
