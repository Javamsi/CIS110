/*************************************************************************
 *  Copyright 2012 Benedict J. Brown
 *
 *  Compilation:  javac TOYToImage.java
 *  Execution:    java ToyToImage image.png < TOYimagename
 *
 *  Reads an image in lfsr.toy format, and displays it
 *
 *  % java ToyToImage TOYMandrill.out
 *
 *  Remarks
 *  -------
 *   - relies on the Image Data class and
 *     on the Picture class from the introcs standard library
 *
 *   - this program assumes a valid seed of at most 16 bits, and
 *     does not error checking
 *************************************************************************/

public class TOYToImage {
  // Read 32 ASCII bits from stdin and convert them to an int
  public static int unstreamInt() {
    int x = 0;

    for (int i = 0; i < 32; i++)
      x = 2 * x + (StdIn.readInt() & 1);

    return x;
  }

  public static void main(String[] args) {
    // discard info that we don't need
    StdIn.readString(); // number of bits in seed
    StdIn.readString(); // seed
    StdIn.readString(); // tap

    // read image width and height
    int w = Integer.parseInt(StdIn.readString(), 16);
    int h = Integer.parseInt(StdIn.readString(), 16);

    int[][] img = new int[h][w];

    // read in the image
    for (int row = 0; row < h; row++)
      for (int col = 0; col < w; col++)
        img[row][col] = unstreamInt();

    // display the image
    ImageData.show(img);
  }
}