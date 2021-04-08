public class Bubblesort extends Sort {
    public int[] sort(int[] array) {
        for (int i = array.length; i > 1; i--) {
            for (int y = 0; y < i - 1; y++) {
                if (array[y] > array[y + 1]) {
                    int bigger = array[y];
                    int smaller = array[y + 1];
                    array[y] = smaller;
                    array[y + 1] = bigger;
                }
            }
        }
        return array;
    }
}