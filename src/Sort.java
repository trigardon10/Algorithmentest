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
