package CHAP13;

import java.util.*;

public class ThreadEx11 {
	public static void main(String[] args) {
		Thread11_1 t1 = new Thread11_1("Thread1");
		Thread11_2 t2 = new Thread11_2("Thread2");
		t1.start();
		t2.start();
	}
}

class Thread11_1 extends Thread {
	Thread11_1(String name) {
		super(name);
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}
}

class Thread11_2 extends Thread {
	Thread11_2(String name) {
		super(name);
	}

	public void run() {
		Map map = getAllStackTraces();
		Iterator it = map.keySet().iterator();

		int x = 0;
		while (it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread) obj;
			StackTraceElement[] ste = (StackTraceElement[]) (map.get(obj));

			System.out.println("[" + ++x + "] name : " + t.getName()//
					+ ", group :" + t.getThreadGroup().getName()//
					+ ", daemon : " + t.isDaemon());

			for (int i = 0; i < ste.length; i++) {
				System.out.println(ste[i]);
			}
			System.out.println();
		}
	}
}
