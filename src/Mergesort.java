import java.util.Arrays;

public class Mergesort extends Sort {
    public int[] sort() {
        return this.mergeSort(array);
    }

    private int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mitte = (int) (arr.length / 2);
        int[] l = Arrays.copyOfRange(arr, 0, mitte);
        int[] r = Arrays.copyOfRange(arr, mitte, arr.length);
        l = mergeSort(l);
        r = mergeSort(r);
        return this.merge(l, r);
    }

    private int[] merge(int[] l, int[] r) {
        int[] arr = new int[l.length + r.length];
        int lPos = 0;
        int rPos = 0;
        int arrPos = 0;

        while (this.compare(lPos, l.length) < 0 && this.compare(rPos, r.length) < 0) {
            // Welcher Wert ist kleiner
            if (this.compare(l[lPos], r[rPos]) < 0) {
                this.write(arr, arrPos++, l[lPos++]);
            } else {
                this.write(arr, arrPos++, r[rPos++]);
            }
        }

        // Rest kopieren
        while (this.compare(lPos, l.length) < 0) {
            this.write(arr, arrPos++, l[lPos++]);
        }

        while (this.compare(rPos, r.length) < 0) {
            this.write(arr, arrPos++, r[rPos++]);
        }

        if (detailed) {
            System.out.println(Arrays.toString(l) + " + " + Arrays.toString(r));
            System.out.println("-> " + Arrays.toString(arr) + "\n");
        }

        return arr;
    }
}
