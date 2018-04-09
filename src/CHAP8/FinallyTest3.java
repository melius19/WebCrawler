package CHAP8;

public class FinallyTest3 {
	public static void main(String[] args) {

		Card5 val = new Card5();

		String str = val.getClass().getName();
		Class cl2 = Card5.class;

		Card5 ob = (Card5) createObject("CHAP8.Card5");
		System.out.println(cl2);
		System.out.println(str);

		ob.method();
	}

	static Object createObject(String className) {
		Class classObj = null;
		try {
			classObj = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Object cObj = null;
		try {
			cObj = classObj.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return cObj;
	}
}

class Card5 {
	void method() {
		System.out.println("Hello");
	}
}
