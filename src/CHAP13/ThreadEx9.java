package CHAP13;

public class ThreadEx9 {

	public static void main (String[] args) throws Exception {
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");

		// ThreadGroup(ThreadGroup parent, String name)
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");
		grp1.setMaxPriority(3);

		Runnable r1 = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		};
		Runnable r5 = new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
			}
		};


		new Thread(grp1, r5, "th1").start();
		new Thread(subGrp1, r5, "th2").start();
		new Thread(grp2, r1, "th3").start();

		System.out.println(">List of ThreadGroup: " + main.getName());
		System.out.println(">Active ThreadGroup: " + main.activeGroupCount());
		Thread.sleep(1500);
		System.out.println(">Active Tread: " + main.activeCount());
		System.out.println();
		main.list();
	}
}
