package CHAP13;

public class ThreadEx4 {
	static long startTime = 0;

	public static void main(String[] args) {

		Thread4_1 th1 = new Thread4_1();
		Thread4_2 th2 = new Thread4_2();

		th2.setPriority(7);

		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(|) : " + th2.getPriority());

		th1.start();
		th2.start();
	}
}

class Thread4_1 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
			// for (int x = 0; x < 10000000; x++);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

class Thread4_2 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
			// for (int x = 0; x < 10000000; x++);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}
