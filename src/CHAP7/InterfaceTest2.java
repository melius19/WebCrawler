package CHAP7;

public class InterfaceTest2 {
	public static void main(String[] args) {
		A0 a = new A0();
		a.autoPlay(new B0());
		a.autoPlay(new C());
	}
}

interface I0 {
	public abstract void play();
}

class A0 {
	void autoPlay(I0 i) {
		i.play();
	}
}

class B0 implements I0 {
	public void play() {
		System.out.println("play in B0 class");
	}
}

class C implements I0 {
	public void play() {
		System.out.println("play in C class");
	}
}
