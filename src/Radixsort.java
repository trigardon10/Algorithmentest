public class Radixsort extends Sort {

    public int[] sort() {
        int m = largest(array);

        for (int faktor = 1; m / faktor > 0; faktor *= 10) {
            int[] result = new int[array.length];
            int a;
            int[] count = new int[10];

            // Jeden Wert im count-Array auf 0 setzen
            for (int i = 0; i < 10; i++) {
                this.write(count, i, 0);
            }

            // Zählen, wie viele Werte es pro Stellenwert gibt
            for (a = 0; a < array.length; a++) {
                int index = (array[a] / faktor) % 10;
                this.write(count, index, count[index] + 1);
            }

            // Werte im count-Array auf tatsächlichen Index
            // im result-Array setzen
            for (a = 1; a < 10; a++) {
                this.write(count, a, count[a] + count[a - 1]);
            }

            // result-Array aufbauen
            for (a = array.length - 1; a >= 0; a--) {
                this.write(result, count[(array[a] / faktor) % 10] - 1, array[a]);

                int index = (array[a] / faktor) % 10;
                this.write(count, index, count[index] - 1);
            }

            // Originales Array anpassen
            for (a = 0; a < array.length; a++) {
                this.write(array, a, result[a]);
            }
        }
        return array;
    }

    private int largest(int[] array) {
        int larger = array[0], i;
        for (i = 1; i < array.length; i++) {
            if (array[i] > larger)
                larger = array[i];
        }
        return larger;
    }
}
