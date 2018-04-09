package CHAP14;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CollectorsEx1 {

	public static void main(String[] args) {
		String[] strArr = { "aaa", "bbb", "ccc" };
		Stream<String> strStream = Stream.of(strArr);
		String result = strStream.collect(new ConcatCollector());

		System.out.println(Arrays.toString(strArr));
		System.out.println(result);
	}
}

class ConcatCollector implements Collector<String, StringBuilder, String> {
	public Supplier<StringBuilder> supplier() {
		return () -> new StringBuilder();
		// return StringBuilder::new;
	}

	public BiConsumer<StringBuilder, String> accumulator() {
		return (sb, s) -> sb.append(s);
		// return StringBuilder::append;
	}

	public Function<StringBuilder, String> finisher() {
		return sb -> sb.toString();
		// return StringBuilder::toString;
	}

	public BinaryOperator<StringBuilder> combiner() {
		return (sb, sb2) -> sb.append(sb2);
		// return StringBuilder::append;
	}

	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}