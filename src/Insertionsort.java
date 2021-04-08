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

            // TODO Allgemein halten
            if (detailed) {
                System.out.println(i + " --> " + j);
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < array.length; k++) {
                    boolean close = false;
                    if (k == j) {
                        sb.append("\u001B[31m");
                        close = true;
                    }
                    sb.append(array[k]);
                    if (close) {
                        sb.append("\u001B[0m");
                    }
                    sb.append(", ");
                }
                System.out.println(sb);
                System.out.println();
            }

        }
        return array;
    }
}