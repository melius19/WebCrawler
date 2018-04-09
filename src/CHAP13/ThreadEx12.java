package CHAP13;

public class ThreadEx12 {

	public static void main(String[] args) {
		Thread12_1 th1 = new Thread12_1();
		Thread12_2 th2 = new Thread12_2();
		th1.start();
		th2.start();

		System.out.println("<<MAIN END>>");
	}
}

class Thread12_1 extends Thread {
	public void run() {
		int tmp1 = 0;
		for (int i = 0; i < 10; i++) {
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// }
			for (long x = 0; x < 2500000000L; x++)
				tmp1 = 13 + 21;
			System.out.print("-");
		}
		System.out.print("<<th1 END>>");
	}
}

class Thread12_2 extends Thread {
	public void run() {
		int tmp2 = 0;
		for (int i = 0; i < 10; i++) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//			}
			for (long x = 0; x < 2500000000L; x++)
				tmp2 = 13 + 21;
			System.out.print("|");
		}
		System.out.print("<<th2 END>>");
	}
}
