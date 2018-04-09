package CHAP12;

public class AnnotationEx1 {

	public static void main(String[] args) {
		Parent c = new Parent();
		c.oldField = 10;
		System.out.println(c.getOldField());
	}
}

class Parent {
	int newField;

	int getNewField() {
		return newField;
	}

	@Deprecated
	int oldField;

	@Deprecated
	int getOldField() {
		return oldField;
	}
}

// class Child extends Parent {
// @Override
// void parentMethod() {
// System.out.println("Parent2");
// }
// }
