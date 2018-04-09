package CHAP7;

import java.util.Date;

public class JP_TEST {
	public static void main(String[] args) {
		Cc c = new Cc();
		System.out.println("HELLO" + c.p.x + c.method());
		System.out.println();
		System.out.println(Math.rint(-1.1));
		System.out.println((578+668)/2.0);
	}
}

class Cp {
	int x = 6;
	int y = 7;
	int s = 0;

	Cp() {
		return;
	}

	int method() {
		return x;
	}
}

interface hi {
}

interface he {
}

class Cc extends Cp implements hi, he {
	Cp p = new Cp();
	Date d = new Date();

	Cc() {
		return;
	}

	int method() {
		System.out.println("SUPER" + super.method());
		return p.y;
	}
}
