package CHAP14;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class CollectorsEx2 {

	public static void main(String[] args) {
		int[] intArr = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(intArr));

		IntStream intStrm = IntStream.of(intArr);
		intStrm.forEach(System.out::println);

		intStrm = IntStream.of(intArr);
		Integer sum = intStrm.boxed().collect(new SumCollector());
		System.out.println(sum);
	}
}

class SumCollector implements Collector<Integer, Integer, Integer> {
	public Supplier<Integer> supplier() {
		return () -> new Integer(0);
		// return StringBuilder::new;
	}

	public BiConsumer<Integer, Integer> accumulator() {
		return (sb, s) -> new Integer(sb.intValue() + s.intValue());
		// return StringBuilder::append;
	}

	public Function<Integer, Integer> finisher() {
		return sb -> sb;
		// return StringBuilder::toString;
	}

	public BinaryOperator<Integer> combiner() {
		return (sb, sb2) -> new Integer(sb + sb2);
		// return StringBuilder::append;
	}

	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}
}