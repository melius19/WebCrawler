package CHAP11;

import java.util.Arrays;
import java.util.Random;

public class MyVector2 {
	public static void main(String[] args) {
		
		Random ran = new Random();
		for(int i=0;i<10;i++) {
			int num = ran.nextInt(100);
			System.out.println(num);
		}
		
		System.out.println("*****************");
		int i = 10;
		byte by = (byte) i;
		System.out.println(by);
		
		char a = 'A';
		char b = 'B';
		System.out.println(a+b);
		System.out.println((int)(a+b));		
		
		long tmp = (int)3.9;
		tmp %= 2;
		System.out.println(tmp);
		
		System.out.println("*****************");
		System.out.println("*****************");
		MyVector mv = new MyVector(5);
		System.out.println("capacity()	: " + mv.capacity());
		System.out.println("size()		: " + mv.size());
		System.out.println("isEmpty()	: " + mv.isEmpty());
		System.out.println("toString()	: " + mv);
		System.out.println("*****************");
		mv.add(1);
		mv.add(2);
		mv.add(3);
		mv.add(4);
		mv.add(5);
		mv.add(6);
		System.out.println("capacity()	: " + mv.capacity());
		System.out.println("toString()	: " + mv);
	}
}

class MyVector5 {

	private Object[] objArr;		// Object Array
	private int size;				// number of data in MyVector
	
	MyVector5(int capacity) {		// capacity : length of Object Array
		if (capacity < 0)
			throw new IllegalArgumentException("Invalid Argument");
		objArr = new Object[capacity];
	}
	
	MyVector5() {					// default length of Object Array : 16
		this(16);
	}
	
	int size() {					// get size
		return size;
	}
	
	int capacity() {				// get capacity
		return objArr.length;
	}
	
	boolean isEmpty() {				// check for no data
		return size == 0;
	}
	
	void add(Object obj) {
		if (size == objArr.length) {
			objArr = Arrays.copyOf(objArr, objArr.length * 2);	// extend array length
		}
		objArr[size++] = obj;		// add data to Array
	}
	
	Object get(int index) {			// get data with index
		if (index > size - 1 || index < 0) {	// check index with size
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
		return objArr[index];
	}
	
	public String toString() {
		return Arrays.toString(Arrays.copyOf(objArr, size));
	}
	
	int indexOf(Object obj) {		// get index with data
		for (int i = 0; i < size; i++) {
			if ((obj instanceof Object && obj.equals(objArr[i])) || obj == objArr[i])
				return i;
		}
		return -1;
	}
	
	boolean remove(Object obj) {	// remove data
		int idx = indexOf(obj);		// get data index
		if (idx < 0)				// check data existence with index number
			return false;
		System.arraycopy(objArr, idx + 1, objArr, idx, size - idx - 1); // copy array
		objArr[--size] = null;		// remove last data
		return true;
	}
}
