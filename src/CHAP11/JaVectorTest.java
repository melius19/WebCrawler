package CHAP11;

import java.util.Vector;

public class JaVectorTest {

	public static void main(String[] args) {

		MyVector mv0;
		try {
			mv0 = new MyVector(-1);
		} catch (IllegalArgumentException e) {
			mv0 = new MyVector(2);
		}
		System.out.println(mv0);

		Vector mv = new Vector(5);
		System.out.println("*****************");
		System.out.println("new MyVector(5)");
		System.out.println("capacity()	: " + mv.capacity());
		System.out.println("size()		: " + mv.size());
		System.out.println("isEmpty()	: " + mv.isEmpty());
		System.out.println("toString()	: " + mv);
		System.out.println("*****************");
		System.out.println("mv.add(1)	: " + mv.add(1));
		System.out.println("mv.add(3)	: " + mv.add(3));
		System.out.println("mv.add(5)	: " + mv.add(5));
		System.out.println("mv.add(null)    : " + mv.add(null));
		System.out.println("mv.add(7)	: " + mv.add(7));
		System.out.println("mv.add(9)	: " + mv.add(9));
		System.out.println("mv.add(\"Cat\")   : " + mv.add("Cat"));
		System.out.println("*****************");
		System.out.println("capacity()	: " + mv.capacity());
		System.out.println("size()		: " + mv.size());
		System.out.println("isEmpty()	: " + mv.isEmpty());
		System.out.println("toString()	: " + mv);
		System.out.println("*****************");
		System.out.println("get(0)		: " + mv.get(0));
		System.out.println("get(2)		: " + mv.get(2));
		System.out.println("get(5)		: " + mv.get(5));
		System.out.println("get(3)		: " + mv.get(3));
		System.out.println("get(6)		: " + mv.get(6));
		System.out.print("get(9)		: ");
		try {
			System.out.println(mv.get(9));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("invalid index");
		}
		System.out.print("get(-1)		: ");
		try {
			System.out.println(mv.get(-1));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("invalid index");
		}
		System.out.println("*****************");
		System.out.println("indexOf(1)	: " + mv.indexOf(1));
		System.out.println("indexOf(3)	: " + mv.indexOf(3));
		System.out.println("indexOf(\"Cat\")  : " + mv.indexOf("Cat"));
		System.out.println("indexOf(null)	: " + mv.indexOf(null));
		System.out.println("indexOf(9)	: " + mv.indexOf(9));
		System.out.println("indexOf(8)	: " + mv.indexOf(8));
		System.out.println("*****************");
		System.out.println("remove(1)> " + mv.remove((Integer) 1) + "\t\t> " + mv);
		System.out.println("remove(7)> " + mv.remove((Integer) 7) + "\t\t> " + mv);
		System.out.println("remove(3)> " + mv.remove((Integer) 3) + "\t\t> " + mv);
		System.out.println("remove(7)> " + mv.remove((Integer) 7) + "\t> " + mv);
		System.out.println("remove(null)> " + mv.remove(null) + "\t> " + mv);
		System.out.println("remove(5)> " + mv.remove((Integer) 5) + "\t\t> " + mv);
		System.out.println("remove(\"Cat\")> " + mv.remove("Cat") + "\t> " + mv);
		System.out.println("remove(9)> " + mv.remove((Integer) 9) + "\t\t> " + mv);
		System.out.println("remove(7)> " + mv.remove((Integer) 7) + "\t> " + mv);
		System.out.println("*****************");
		System.out.println("capacity()	: " + mv.capacity());
		System.out.println("size()		: " + mv.size());
		System.out.println("isEmpty()	: " + mv.isEmpty());
		System.out.println("toString()	: " + mv);
	}
}
