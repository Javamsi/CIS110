/* LFSR.java
 * Vamsi Jandhayala
 * 
 * October 16, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: The purpose of this program is to encrypt a binary string to 
 * by using a transform function that Xor's the original string of binary values
 * and then returns an integer of k steps with the function generate().
 * 
 * Usage:
 * %LFSR.java
 * %java LFSR 
 * 
 * Output:
 * 00001011001 25
 * 01100100100 4
 * 10010011110 30
 * 01111011011 27
 * 01101110010 18
 * 11001011010 26
 * 01101011100 28
 * 01110011000 24
 * 01100010111 23
 * 01011111101 29
 */

public class LFSR {
    
  //Initialize class variables seedArray and tapPosition 
    private static char[] seedArray = new char[11];
    private static int tapPosition = 0;
    
    /*The init function takes the given initial seed and tap and creates 
     * an LFSR. */
    public static boolean init(String seed, int tap) {
        for (int i = 0; i < seedArray.length; i++) {
            seedArray[i] = seed.charAt(i);
        }
        return true;
    }
    
    /*Simulates one step and returns the least significant bit (rightmost bit)
    as either 0 or 1 */
    public static int step() {
        tapPosition = 2;
        char initial = seedArray[0];
        int initialPosition = Character.getNumericValue(initial);
        int tap = (int) seedArray[tapPosition];
        for (int i = 0; i < seedArray.length - 1; i++) {
            seedArray[i] = seedArray[i + 1];
        }
        seedArray[seedArray.length-1] = (char) (initialPosition ^ tap);
        return Character.getNumericValue(seedArray[seedArray.length - 1]);
    }
    
    /*Simulates k steps and returns the k-bit integer created */
    public static int generate(int k) {
        int bitseq = 0;
        for (int j = 0; j < k; j++) {
            bitseq = 2*bitseq + LFSR.step();
        } 
        return bitseq;
    } 
    
    /* Returns a string representation of the LFSR */
    public static String string() {
        String seed = new String(seedArray);
        return seed;
    } 
    
    /*Main method to test all of the methods in LFSR*/
    public static void main(String[] args) {
        LFSR.init("01101000010", 8);
        for (int i = 0; i < 10; i++) {
            int r = generate(5);
            StdOut.println(LFSR.string()); 
        } 
    }
} 


