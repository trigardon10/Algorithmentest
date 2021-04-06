import java.util.Arrays;
import java.util.Formatter;

public class Algorithmentest {

	public static void main(String[] args) {
		int[] unsorted = { 8, 7, 2, 9, 234, 412, 21, 4, 975, 42, 278 };
		System.out.println("Unsorted: " + Arrays.toString(unsorted));

		Insertionsort insertionsort = new Insertionsort();

		long startTime = System.nanoTime();

		int[] sorted = insertionsort.sort(unsorted, false);

		long endTime = System.nanoTime();
		long calcTime = endTime - startTime;

		System.out.println("Sorted: " + Arrays.toString(sorted));
		System.out.println("Berechnungszeit: " + calcTime + " nanoseconds");

		Formatter formatter = new Formatter();
		Formatter a = formatter.format("%s %<s %s", "a", "b", "c", "d");
		System.out.println(a);
		formatter.close();
	}
}
