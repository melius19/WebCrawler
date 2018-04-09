package CHAP13;

import java.util.ArrayList;

public class ThreadWaitEx3 {

	public static void main(String[] args) throws InterruptedException {
		Desk desk = new Desk();
		new Thread(new Maker(desk), "MAKER0").start();
		new Thread(new Taker(desk, "redpen"), "TAKER1").start();
		// new Thread(new Taker(desk, "bluepen"), "TAKER2").start();

		Thread.sleep(3000);
		System.exit(0);

	}

}

// class Desk {
// String[] penNames = { "redpen", "bluepen", "bluepen" };
// final int MAX_PEN = 5;
//
// private ArrayList<String> pens = new ArrayList<String>();
//
// public Desk add(int i) {
// synchronized(this) {
// if (!(pens.size() < MAX_PEN))
// return this;
// if (!(0 > i) && i < penNames.length) {
// pens.add(penNames[i]);
// }
// return this;
// }
// }
//
// public Desk remove(String penName) {
// synchronized(this) {
// for (int i = 0; i < pens.size(); i++) {
// if (penName.equals(pens.get(i))) {
// pens.remove(i);
// return this;
// }
// }
// return this;
// }
// }
//
// public String toString() {
// return pens.toString();
// }
// }
//
// class Maker implements Runnable {
// private Desk desk;
//
// Maker(Desk desk) {
// this.desk = desk;
// }
//
// public void run() {
// while (true) {
// int i = (int) (Math.random() * desk.penNames.length);
// System.out.println(desk.add(i) + " added");
// try {
// Thread.sleep(100);
// } catch (InterruptedException e) {
// }
// }
// }
// }
//
// class Taker implements Runnable {
// private Desk desk;
// private String pen;
//
// Taker(Desk desk, String pen) {
// this.desk = desk;
// this.pen = pen;
// }
//
// public void run() {
// while (true) {
// System.out.println(desk.remove(pen) + " removed");
// try {
// Thread.sleep(100);
// } catch (InterruptedException e) {
// }
// }
// }
// }
