public class Transpose {
  public static void transpose1(int[][] arr) {
    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < row; col++) {
        // swap the elements at a[row][col] and a[col][row]
        int tmp = arr[row][col];
        arr[row][col] = arr[col][row];
        arr[col][row] = tmp;
      }
    }
  }

  public static void transpose2(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;

    int[][] arr2 = new int[rows][cols];
    for (int row = 0; row < rows; row++)
      for (int col = 0; col < cols; col++)
        arr2[row][col] = arr[row][col];

    transpose1(arr2);
  }

  public static int[][] transpose3(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;

    int[][] out = new int[cols][rows];
    for (int row = 0; row < rows; row++)
      for (int col = 0; col < cols; col++)
        out[col][row] = arr[row][col];

    return out;
  }

  // print out the array a
  public static void printArray(int[][] a) {
    for (int row = 0; row < a.length; row++) {
      for (int col = 0; col < a[row].length; col++)
        System.out.print(a[row][col] + " ");
      System.out.println();
    }
  }
   public static void main(String[] args) {
    // a is a 3 x 2 array
    int[][] a = { { 1, 2 },
                  { 3, 4 },
                  { 5, 6 } };

    int[][] b = transpose3(a);
    printArray(b);
  }
}
