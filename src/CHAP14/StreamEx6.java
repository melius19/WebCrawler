package CHAP14;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {
	public static void main(String[] args) {
		Student[] stuArr = { //
				new Student("LEE", 3, 300), new Student("KIM", 1, 200), new Student("AHN", 2, 300), //
				new Student("PAK", 2, 150), new Student("SOO", 1, 200), new Student("NHA", 3, 290), //
				new Student("GAM", 3, 180) };

		List<String> names = Stream.of(stuArr).map(Student::getName) //
				.collect(Collectors.toList());
		System.out.println(names);

		Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);

		for (Student s : stuArr2) {
			System.out.println(s);
		}

		Map<String, Student> stuMap = Stream.of(stuArr) //
				.collect(Collectors.toMap(s -> s.getName(), p -> p));

		for (String name : stuMap.keySet())
			System.out.println(name + "-" + stuMap.get(name));

		long count = Stream.of(stuArr).collect(Collectors.counting());
		long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(Student::getTotalScore));
		System.out.println("count=" + count);
		System.out.println("totalScore=" + totalScore);

		totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		System.out.println("totalScore=" + totalScore);

		Optional<Student> topStudent = Stream.of(stuArr) //
				.collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
		System.out.println("topStudent=" + topStudent.get());

		IntSummaryStatistics stat = Stream.of(stuArr) //
				.collect(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println(stat);
	}
}

class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;

	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
	}

	String getName() {
		return name;
	}

	int getBan() {
		return ban;
	}

	int getTotalScore() {
		return totalScore;
	}

	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}

}
