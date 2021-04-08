import java.util.Arrays;

public class Algorithmentest {

	public static void main(String[] args) {
		boolean detailed = false;
		int amount = detailed ? 10 : 100000;
		Sort sort = new Bubblesort(amount, detailed);
		// Insertionsort insertionsort = new Insertionsort();

		if (detailed) {
			System.out.println("Unsorted: " + Arrays.toString(sort.array));
		}

		long startTime = System.nanoTime();

		int[] sorted = sort.sort();

		long endTime = System.nanoTime();
		long calcTime = endTime - startTime;

		if (detailed) {
			System.out.println("Sorted: " + Arrays.toString(sorted));
		}
		// System.out.println("Berechnungszeit: " + Math.scalb(calcTime / 1000000, 3) +
		// " milliseconds");
		System.out.println("Berechnungszeit: " + calcTime / 1000000 + " milliseconds");
		System.out.println("Operationen: " + sort.operationAmount);
		System.out.println("Vergleiche: " + sort.comparisonAmount);
	}
}
