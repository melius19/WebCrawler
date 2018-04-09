package CHAP13;

import javax.swing.JOptionPane;

public class ThreadEx6 {

	public static void main(String[] args) {
		Thread7_1 th1 = new Thread7_1();
		th1.start();
		String input = JOptionPane.showInputDialog("Input number");
		System.out.println(input);
	}
}

class Thread7_1 extends Thread {
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
}