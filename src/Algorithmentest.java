import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Algorithmentest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Sort[] algorithms = { new Bubblesort(), new Insertionsort() };

		// Algorithmus auswählen
		System.out.println("Wählen Sie eine der folgenden Optionen");
		System.out.println("--------------------------------------");
		for (int i = 0; i < algorithms.length; i++) {
			Sort algorithm = algorithms[i];
			System.out.println(i + 1 + " - " + algorithm.getClass().getName());
		}
		int index = scanner.nextInt();
		Sort chosenAlgorithm = algorithms[index - 1];

		System.out.println("\nSoll die detailierte Ausgabe aktiviert werden? (Y/N)");
		String sDetailed = scanner.next(Pattern.compile("Y|N", Pattern.CASE_INSENSITIVE));

		// Detailierte Ausgabe?
		boolean detailed = false;
		if ("Y".equalsIgnoreCase(sDetailed)) {
			detailed = true;
		}
		System.out.println();

		int[] unsorted = { 8, 7, 2, 9, 234, 412, 21, 4, 975, 42, 278 };
		System.out.println("Unsorted: " + Arrays.toString(unsorted));

		long startTime = System.nanoTime();

		int[] sorted = chosenAlgorithm.sort(unsorted, detailed);

		long endTime = System.nanoTime();
		long calcTime = endTime - startTime;

		System.out.println("Sorted: " + Arrays.toString(sorted));
		System.out.println("Berechnungszeit: " + calcTime + " nanoseconds");

		scanner.close();
	}
}
