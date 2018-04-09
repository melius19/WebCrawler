package CHAP11;

import java.util.Arrays;

public class MyVectorMain {

	public static void main(String[] args) {
		MyVector mv = new MyVector(5);
		System.out.println("*****************");
		System.out.println("new MyVector(5)");
		System.out.println("capacity()	: " + mv.capacity());
		System.out.println("size()		: " + mv.size());
		System.out.println("isEmpty()	: " + mv.isEmpty());
		System.out.println("toString()	: " + mv);
		System.out.println("*****************");
		System.out.println("mv.add(1)	: " + mv.add(1));
		System.out.println("mv.add(3).add(5): " + mv.add(3).add(5));
		System.out.println("mv.add(null)    : " + mv.add(null));
		System.out.println("mv.add(7).add(9): " + mv.add(7).add(9));
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
		System.out.println("remove(1)> " + mv.remove(1) + "\t\t> " + mv);
		System.out.println("remove(7)> " + mv.remove(7) + "\t\t> " + mv);
		System.out.println("remove(3)> " + mv.remove(3) + "\t\t> " + mv);
		System.out.println("remove(7)> " + mv.remove(7) + "\t> " + mv);
		System.out.println("remove(null)> " + mv.remove(null) + "\t> " + mv);
		System.out.println("remove(5)> " + mv.remove(5) + "\t\t> " + mv);
		System.out.println("remove(\"Cat\")> " + mv.remove("Cat") + "\t> " + mv);
		System.out.println("remove(9)> " + mv.remove(9) + "\t\t> " + mv);
		System.out.println("remove(7)> " + mv.remove(7) + "\t> " + mv);
		System.out.println("*****************");
		System.out.println("capacity()	: " + mv.capacity());
		System.out.println("size()		: " + mv.size());
		System.out.println("isEmpty()	: " + mv.isEmpty());
		System.out.println("toString()	: " + mv);
	}
}

class MyVector {
	private Object[] objArr; // Object Array
	private int size; // number of data in MyVector

	MyVector(int capacity) { // capacity : length of Object Array
		if (capacity < 0)
			throw new IllegalArgumentException("Invalid Argument");
		objArr = new Object[capacity];
	}

	MyVector() { // default length of Object Array : 16
		this(16);
	}

	int size() { // get size
		return size;
	}

	int capacity() { // get capacity
		return objArr.length;
	}

	boolean isEmpty() { // check for no data
		return size == 0;
	}

	MyVector add(Object obj) { // add data
		if (size == objArr.length) {
			// method 1
			// Object[] objArr2 = new Object[objArr.length * 2]; // create new array
			// System.arraycopy(objArr, 0, objArr2, 0, objArr.length); // copy array
			// objArr = objArr2;
			// method 2
			objArr = Arrays.copyOf(objArr, objArr.length * 2); // extend array length
			// method end
		}
		objArr[size++] = obj; // add data to Array
		return this;
	}

	// void add(Object obj) { // add data
	// if (!(size < objArr.length)) {
	// Object[] objArr2 = new Object[objArr.length * 2];
	// System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
	// objArr = objArr2;
	// }
	// objArr[size++] = obj; // add data to Array
	// return this;
	// }

	Object get(int index) { // get data with index
		if (index > size - 1 || index < 0) { // check index with size
			// return null;
			// throw new IllegalArgumentException("Invalid index");
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
		return objArr[index];
	}

	public String toString() {
		// method 1
		// String str = "[";
		// for (int i = 0; i < size; i++) {
		// str = str + objArr[i]; // add data to String
		// if (i < size - 1)
		// str = str + ",";
		// }
		// return str + "]";
		// method 2
		return Arrays.toString(Arrays.copyOf(objArr, size));
	}

	int indexOf(Object obj) { // get index with data
		for (int i = 0; i < size; i++) {
			// method 1
			// if (null == obj) {
			// if (obj == objArr[i])
			// return i;
			// } else if (obj.equals(objArr[i]))
			// return i;
			// method 2 : condition for Object instance & null case
			if ((obj instanceof Object && obj.equals(objArr[i])) || obj == objArr[i])
				return i;
			// method end
		}
		return -1;
	}

	boolean remove(Object obj) { // remove data
		int idx = indexOf(obj); // get data index
		if (idx < 0) // check data existence with index number
			return false;
		// method 1
		// for (int i = idx; i < size - 1; i++) {
		// objArr[i] = objArr[i + 1]; // copy data to forward room
		// }
		// method 2
		System.arraycopy(objArr, idx + 1, objArr, idx, size - idx - 1); // copy array
		// method end
		objArr[--size] = null; // remove last data
		return true;
	}
}
