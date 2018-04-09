package CHAP8;

public class ExceptionEx7 {

	public static void main(String[] args) {
		method1();
		// try {
		// System.out.println(0 / 0);
		// } catch (ArithmeticException e) {
		// System.out.println("TRUE");
		// } catch (Exception e) {
		// }
		System.out.println("HALLO");
	}

	static void method1() throws NullPointerException {
		// throw new NullPointerException();
	}
}
