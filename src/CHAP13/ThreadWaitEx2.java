package CHAP13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadWaitEx2 {

	public static void main(String[] args) throws InterruptedException {
		Desk desk = new Desk();
		new Thread(new Maker(desk), "MAKER").start();
		new Thread(new Taker(desk, "redpen"), "TAKER").start();
		new Thread(new Taker(desk, "bluepen"), "TAKER").start();

		Thread.sleep(3000);
		System.exit(0);
	}
}

class Desk {
	String[] penNames = { "redpen", "bluepen" };
	final int MAX_PEN = 5;

	// List<String> pens = Collections.synchronizedList(new ArrayList<String>());
	private ArrayList<String> pens = new ArrayList<String>();
	// Vector<String> pens = new Vector<String>();

	// public synchronized void add(int i) {
	public void add(int i) {
		// System.out.println("M1");
		if (!(pens.size() < MAX_PEN)) {
			// System.out.println("M2");
			return;
		}
		if (!(0 > i) && i < penNames.length) {
			pens.add(penNames[i]);
		}
		// System.out.println("M3");
		return;
	}

	// public synchronized void remove(String penName) {
	public void remove(String penName) {
		// System.out.println("T1");
		for (int i = 0; i < pens.size(); i++) {
			if (penName.equals(pens.get(i))) {
				pens.remove(i);
				// System.out.println("T2");
				return;
			}
		}
		// System.out.println("T3");
		return;
	}

	// public synchronized String toString() {
	public String toString() {
		return pens.toString();
	}
}

class Maker implements Runnable {
	private Desk desk;

	Maker(Desk desk) {
		this.desk = desk;
	}

	public void run() {
		while (true) {
			int i = (int) (Math.random() * desk.penNames.length);
			desk.add(i);
			System.out.println("make : " + desk);
			// System.out.println("make : ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Taker implements Runnable {
	private Desk desk;
	private String pen;

	Taker(Desk desk, String pen) {
		this.desk = desk;
		this.pen = pen;
	}

	public void run() {
		while (true) {
			desk.remove(pen);
			System.out.println("take : " + desk);
			// System.out.println("take : ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
