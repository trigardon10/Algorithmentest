import java.util.Random;

public abstract class Sort {
  protected int length;
  protected boolean detailed;
  protected int[] array;
  public long operationAmount = 0;
  public long comparisonAmount = 0;

  public void init(int length, boolean detailed) {
    this.length = length;
    this.detailed = detailed;
    this.array = this.createRandomArray();
    this.operationAmount = 0;
    this.comparisonAmount = 0;
  }

  public abstract int[] sort();

  protected void swap(int[] arr, int i1, int i2) {
    int temp = arr[i1];
    this.write(arr, i1, arr[i2]);
    this.write(arr, i2, temp);
  }

  protected void write(int[] arr, int idx, int value) {
    arr[idx] = value;
    this.operationAmount++;
  }

  protected int compare(int val1, int val2) {
    this.comparisonAmount++;
    return val1 - val2;
  }

  protected void printMove(int[] arr, int i1, int i2) {
    if (detailed) {
      System.out.println(i1 + " --> " + i2);
      StringBuilder sb = new StringBuilder();
      for (int k = 0; k < array.length; k++) {
        boolean close = false;
        if (k == i2) {
          sb.append("\u001B[31m");
          close = true;
        } else if ((k > i2 && k <= i1) || (k < i2 && k >= i1)) {
          sb.append("\u001B[33m");
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

  protected void printSwap(int[] arr, int i1, int i2) {
    if (detailed) {
      System.out.println(i1 + " <--> " + i2);
      StringBuilder sb = new StringBuilder();
      for (int k = 0; k < array.length; k++) {
        boolean close = false;
        if (k == i1 || k == i2) {
          sb.append("\u001B[33m");
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

  private int[] createRandomArray() {
    int[] arr = new int[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = i;
    }
    Random rand = new Random();

    for (int i = 0; i < arr.length; i++) {
      int randomIndexToSwap = rand.nextInt(arr.length);
      this.swap(arr, i, randomIndexToSwap);
    }
    return arr;
  }
}
