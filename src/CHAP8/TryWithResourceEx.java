package CHAP8;

public class TryWithResourceEx {

	public static void main(String[] args) {
		// try (CloseableResource cr = new CloseableResource()) {
		// }
	}
}

// class CloseableResource implements AutoCloseable {
// public void exceptionWork(boolean exception) throws WorkException {
// System.out.println("exceptionWork(" + exception + ") is called.");
// if (exception)
// throw new WorkException("WorkException occur");
// }}
//
// Class WorkException extends Exception{
//
// }
