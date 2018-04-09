package CHAP14;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx1 {

	public static void main(String[] args) {
		String[] strArr = { //
				"Inheritance", "Java", //
				"Lambda", "stream", "OptionalDouble", //
				"IntStream", "count", "sum" };

		Stream.of(strArr).forEach(System.out::println);

		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
		System.out.println("noEmptyStr =" + noEmptyStr);

		Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();
		System.out.println("sWord =" + sWord.get());

		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

		int count = intStream1.reduce(0, (a, b) -> a + 1);
		int sum = intStream2.reduce(0, (a, b) -> a + b);

		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);

		System.out.println("count=" + count);
		System.out.println("sum=" + sum);
		System.out.println("max=" + max.getAsInt());
		System.out.println("min=" + min.getAsInt());

		// Optional<String> opt1 = Optional.ofNullable(null);
		// Optional<String> opt2 = Optional.empty();
		// Optional<String> opt3 = Optional.of("");
		// Optional<String> opt4 = Optional.of("four_4");
		//
		// System.out.println(opt1);
		// System.out.println(opt2);
		// System.out.println(opt3);
		// System.out.println(opt4);
		//
		// System.out.println(opt1.equals(opt2));
		// System.out.println(opt1.equals(opt3));
		//
		// int result3 = optStrToInt(Optional.of("123"), 0);
		// System.out.println(result3);
		// int result4 = optStrToInt(Optional.of(""), 0);
		// System.out.println(result4);
	}

	static int optStrToInt(Optional<String> optStr, int defaultValue) {
		try {
			return optStr.map(Integer::parseInt).get();
		} catch (Exception e) {
			return defaultValue;
		}
	}

}
