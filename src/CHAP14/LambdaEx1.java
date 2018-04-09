package CHAP14;

@FunctionalInterface
interface MyFunction {
	void myMethod();
}

public class LambdaEx1 {
	public static void main(String[] args) {
		MyFunction f = () -> {
		};
		Object obj = ((MyFunction) () -> {
		});
		String str = ((Object) (MyFunction) (() -> {
		})).toString();

		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);

		System.out.println((MyFunction) () -> {
		});
		System.out.println(((MyFunction) () -> {
		}).toString());
		System.out.println((Object) (MyFunction) (() -> {
		}));

		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
}

class Outer {
	int val = 10;

	class Inner {
		int val = 20;

		void method(int i) {
			int val = 30;
			// i = 10;

			MyFunction f = () -> {
				System.out.println(i);
				System.out.println(val);
				System.out.println(this.val);
				System.out.println(Outer.this.val);
			};
			f.myMethod();
		}
	}
}