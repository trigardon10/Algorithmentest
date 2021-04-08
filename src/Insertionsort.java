public class Insertionsort extends Sort {
    public int[] sort() {
        for (int i = 0; i < array.length; i++) {
            int entry = array[i];
            int j = i;
            while (j > 0 && this.compare(array[j - 1], entry) > 0) {
                this.write(array, j, array[j - 1]);
                j--;
            }
            this.write(array, j, entry);
            this.printMove(array, i, j);
        }
        return array;
    }
}