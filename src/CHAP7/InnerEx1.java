package CHAP7;

public class InnerEx1 {
	public static void main(String[] args) {
		System.out.println(Outer1.InstanceInner.CONST);
		System.out.println(Outer1.StaticInner.cv);
		System.out.println(null == null);

	}
}

class Outer1 {
	class InstanceInner {
		int iv = 100;
		// static int cv = 100;
		final static int CONST = 100; // constant pool
	}

	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}

	void myMethod() {
		class LocalInner {
			int iv = 300;
			// static int cv = 300;
			final static int CONST = 300; // constant pool
		}
	}
}
