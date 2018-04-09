package CHAP12;

import java.util.Arrays;
import java.util.stream.Stream;

public class Pro3 {

	public static void main(String[] args) {
		Box1<? extends Object> b0 = new Box1();
		Box1<? extends Object> b1 = new Box1<Fruit3>();
		Box1<Fruit3> b2 = (Box1<Fruit3>) b0;

		b2.item = new Fruit3();
		System.out.println(b2.item instanceof Fruit3);

		String[] lineArr = { //
				"Belive or not It is true", //
				"Do or do not There is no try", };

		Stream<String> lineStream = Arrays.stream(lineArr);
		Stream<Stream<String>> strArrStream = lineStream.map(line -> Stream.of(line.split(" +")));
	}
}

class Box1<T extends Fruit3> {
	T item;

	void setItem(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}
}
