package CHAP12;

enum Direction1 {
	EAST, SOUTH, WEST, NORTH
}

public class EnumEx1 {

	public static void main(String[] args) {
		Direction1 d1 = Direction1.EAST;
		Direction1 d2 = Direction1.valueOf("WEST");
		Direction1 d3 = Enum.valueOf(Direction1.class, "EAST");

		System.out.println("d1=" + d1);
		System.out.println("d2=" + d2);
		System.out.println("d3=" + d3);
		System.out.println("d1.compareto(Direction.EAST):" + (d1.compareTo(Direction1.EAST)));
		System.out.println("d1.compareto(Direction.SOUTH):" + (d1.compareTo(Direction1.SOUTH)));
		System.out.println("d1.compareto(Direction.WEST):" + (d1.compareTo(Direction1.WEST)));
		System.out.println("d1.compareto(Direction.NORTH):" + (d1.compareTo(Direction1.NORTH)));
	}
}
