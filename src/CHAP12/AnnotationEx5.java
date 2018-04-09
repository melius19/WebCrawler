package CHAP12;

import java.lang.annotation.*;

enum TestType {
	FIRST, FINAL
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
	String yymmdd();

	String hhmmss();
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
	int count() default 1;

	String testedBy();

	String[] testTools() default "JUnit";

	TestType testType() default TestType.FIRST;

	DateTime testDate();
}

@Deprecated
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class AnnotationEx5 {
	public static void main(String[] args) {
		Class<AnnotationEx5> cls = AnnotationEx5.class;
		TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);
		System.out.println(anno.toString());
		System.out.println(anno.hashCode());
		System.out.println(anno.annotationType());
		System.out.println(anno.testedBy());
		System.out.println(anno.testDate().yymmdd());
		System.out.println(anno.testDate().hhmmss());
	}
}
