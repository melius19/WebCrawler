package CHAP13;

import javax.swing.JOptionPane;

public class ThreadEx13 {

	public static void main(String[] args) {
		Thread13_1 th1 = new Thread13_1();
		th1.start();
		String input = JOptionPane.showInputDialog("Enter number");
		System.out.println(input);
		System.out.println("Interrupted!!");
		th1.interrupt();
		System.out.println("isInterrupted :" + th1.isInterrupted());
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
		}
		System.out.println("isInterrupted :" + th1.isInterrupted());
	}
}

class Thread13_1 extends Thread {
	public void run() {
		int i = 10;
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			// System.out.println("Interrupted :" + this.interrupted());
			// System.out.println("isInterrupted :" + this.isInterrupted());
			for (long x = 0; x < 2500000000L; x++)
				;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Exception CATCH");
			}
		}
		System.out.println("COUNT OVER");
		System.out.println("isInterrupted :" + this.isInterrupted());
		System.out.println("Interrupted :" + this.interrupted());
	}
}