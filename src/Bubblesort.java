public class Bubblesort extends Sort {
    public int[] sort() {
        for (int i = array.length; i > 1; i--) {
            for (int y = 0; y < i - 1; y++) {
                // TODO vergleich über Superklasse machen
                if (array[y] > array[y + 1]) {
                    this.swap(array, y, y + 1);
                }
            }
        }
        return array;
    }
}