package CHAP15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileEx6Test {

	@Test
	void test1() {
		assertTrue(method(1, 2) == 3);
	}

	@Test
	void test2() {
		assertTrue(method(4, 5) == 9);
	}

	int method(int a, int b) {
		return a + b;
	}
}
