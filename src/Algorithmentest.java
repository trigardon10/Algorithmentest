import java.util.Arrays;

public class Algorithmentest {

	public static void main(String[] args) {
		int[] unsorted = { 8, 7, 2, 9, 234, 412, 21, 4, 975, 42, 278 };
		System.out.println("Unsorted: " + Arrays.toString(unsorted));

		Bubblesort bubblesort = new Bubblesort();
		// Insertionsort insertionsort = new Insertionsort();

		long startTime = System.nanoTime();

		int[] sorted = bubblesort.sort(unsorted);

		long endTime = System.nanoTime();
		long calcTime = endTime - startTime;

		System.out.println("Sorted: " + Arrays.toString(sorted));
		System.out.println("Berechnungszeit: " + calcTime + " nanoseconds");
	}
}
