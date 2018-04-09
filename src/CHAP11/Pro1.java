package CHAP11;

import java.util.*;

public class Pro1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();

		list.add(new Student("hon", 1, 1, 100, 100, 100));
		list.add(new Student("nam", 1, 2, 90, 70, 80));
		list.add(new Student("kim", 1, 3, 80, 80, 90));
		list.add(new Student("lee", 1, 4, 70, 90, 70));
		list.add(new Student("ahn", 1, 5, 60, 100, 80));

		// Collections.sort(list);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

class Student {
	String name;
	int ban;
	int no;
	int kor, eng, math;

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}
}

class Pro_1 {
	void mepro01(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();

		ArrayList kyo = new ArrayList();
		ArrayList cha = new ArrayList();
		ArrayList hap = new ArrayList();

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);

		kyo.addAll(list1);
		kyo.retainAll(list2);

		cha.addAll(list1);
		cha.removeAll(list2);

		hap.addAll(list1);
		hap.removeAll(list2);
		hap.addAll(list2);

		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}
