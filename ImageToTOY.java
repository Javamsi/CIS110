/*************************************************************************
 *  Copyright 2012 Benedict J. Brown
 *
 *  Compilation:  javac ImageToTOY.java
 *  Execution:    java ImageToTOY imagename seed tap
 *
 *  Takes an image, seed and tap bit, and prints them to stdout in the
 *  format except by lfsr.toy: number of bits in seed in hex, seed in
 *  hex, tap bit in hex, image width and height in hex, then 0 or 1
 *  for each bit of the image, then FFFF.
 *
 *  % java ImageData mandrill.jpg 0110011 3
 *
 *  Remarks
 *  -------
 *   - img[y][x] is row y, column x, where (0, 0) is upper left
 *
 *   - relies on the Image Data class and
 *     on the Picture class from the introcs standard library
 *
 *   - this program assumes a valid seed of at most 16 bits, and
 *     does not error checking
 *************************************************************************/

public class ImageToTOY {
  // print an integer as a series of 32 0s and 1s (in ASCII)
  public static void streamInt(int x) {
    // split the individual bits of x up into an array of ints
    for (int i = 31; i >= 0; i--) {
      if ((x & (1 << i)) == 0) System.out.println("0");
      else System.out.println("1");
    }
  }

  public static void main(String[] args) {
    int[][] img = ImageData.imageData(args[0]);

    // print out the number of bits in the seed in hex
    System.out.printf("%04X\n", args[1].length());

    // convert the seed from bits to an integer
    // and print it out in hex
    int seed = Integer.parseInt(args[1], 2);
    System.out.printf("%04X\n", seed);
    
    // print out the tap bit in hex
    System.out.printf("%04X\n", Integer.parseInt(args[2]));

    // print out image dimensions in hex
    System.out.printf("%04X\n", img[0].length); // width
    System.out.printf("%04X\n", img.length);    // height

    for (int row = 0; row < img.length; row++) {
      // System.err.println("Row " + row + 1);
      for (int col = 0; col < img[0].length; col++) {
        streamInt(img[row][col]);
      }
    }

    System.out.println("FFFF");
  }
}