package CHAP12;

import java.util.ArrayList;

public class FruitBoxEx3 {

	public static void main(String[] args) {
		FruitBox3<Fruit3> fruitBox = new FruitBox3<Fruit3>();
		FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>();
		FruitBox3<?> appleBox1 = new FruitBox3();
		Box<?> toyBox = new Box<Toy3>();

		
		fruitBox.add(new Fruit3());
		fruitBox.add(new Apple3());
		fruitBox.add(new Grape3());

		System.out.println(Juicer.makeJuice(fruitBox));
	}
}

class Juicer {
	static Juice makeJuice(FruitBox3<? extends Fruit3> box) {
		String tmp = "";
		for (Fruit3 f : box.getList())
			tmp += f + " ";
		return new Juice(tmp);
	}
}

class Juice {
	String name;

	Juice(String name) {
		this.name = name + "Juice";
	}

	public String toString() {
		return name;
	}
}

class FruitBox3<T extends Fruit3> extends Box<T> {
}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();

	void add(T item) {
		list.add(item);
	}

	T get(int i) {
		return list.get(i);
	}

	int size() {
		return list.size();
	}

	public String toString() {
		return list.toString();
	}

	ArrayList<T> getList() {
		return list;
	}
}

class Toy3 {
	public String toString() {
		return "Toy";
	}
}

class Fruit3 {
	public String toString() {
		return "Fruit";
	}
}

class Apple3 extends Fruit3 {
	public String toString() {
		return "Apple";
	}
}

class Grape3 extends Fruit3 {
	public String toString() {
		return "Grape";
	}
}
