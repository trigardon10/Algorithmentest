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

		int amount = detailed ? 10 : 100000;

		chosenAlgorithm.init(amount, detailed);

		if (detailed) {
			System.out.println("Unsorted: " + Arrays.toString(chosenAlgorithm.array));
			System.out.println();
		}

		long startTime = System.nanoTime();

		int[] sorted = chosenAlgorithm.sort();

		long endTime = System.nanoTime();
		long calcTime = endTime - startTime;

		if (detailed) {
			System.out.println("Sorted: " + Arrays.toString(sorted));
		}
		System.out.println("Berechnungszeit: " + calcTime / 1000000 + " milliseconds");
		System.out.println("Operationen: " + chosenAlgorithm.operationAmount);
		System.out.println("Vergleiche: " + chosenAlgorithm.comparisonAmount);

		scanner.close();
	}
}
