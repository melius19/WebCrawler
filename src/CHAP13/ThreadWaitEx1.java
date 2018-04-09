package CHAP13;

import java.util.ArrayList;

public class ThreadWaitEx1 {

	public static void main(String[] args) throws Exception {
		Table table = new Table();

		new Thread(new Cook(table), "COOK0").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();

		Thread.sleep(10000);
		System.exit(0);
	}
}

class Table {
	String[] dishNames = { "donut", "burger", "burger" };
	final int MAX_FOOD = 5;

	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + "is waiting.");
			try {
				wait();
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		dishes.add(dish);
		notify();
		System.out.println("Dishes:" + dishes.toString());
	}

	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				try {
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
			while (true) {
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				}
				try {
					System.out.println(name + " is waiting.");
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public int dishNum() {
		return dishNames.length;
	}
}

class Cook implements Runnable {
	private Table table;

	Cook(Table table) {
		this.table = table;
	}

	public void run() {
		while (true) {
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Customer implements Runnable {
	private Table table;
	private String food;

	Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}

	void eatFood() {
		table.remove(food);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
			}
			String name = Thread.currentThread().getName();
			eatFood();
			System.out.println(name + " ate a " + food);
		}
	}
}