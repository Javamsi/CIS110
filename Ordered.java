/* Ordered.java
 * Vamsi Jandhayala
 * 
 * September 16, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: Takes the 3 inputed string type numbers in the command line
 * argument, changes them into int type values. The int type values are then 
 * compared to see if the order of the input numbers is strictly in ascending
 * or descending order, which would result in true as the output.
 * 
 * Usage:
 * %javac Ordered.java
 * %java SumThree 1 2 3 or 3 2 1(any three numbers)
 * Output: True
 * %javac Ordered.java
 * %java Ordered 1 3 2 or 2 1 3, etc...
 * Output: False
 */

import java.util.Scanner;
//Begin class Ordered 
public class Ordered {
    public static void main (String[] args) {
        //Define int x, y, and z as the three command line arguments
        int N = StdIn.readInt();
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        boolean isOrdered = true;
        
        /* if statements that define boolean type isOrdered and takes the case 
         * of strictly descending order integers to print true, otherwise to 
         * print false.
         */
        if (N > y) {
            if (N > z) {
                isOrdered = true;
            }
            if (N > y) {
                isOrdered = false;
            }
        }
        
        /* if statements that define boolean type isOrdered and takes the case 
         * of strictly ascending order integers to print true, otherwise to 
         * print false.
         */
        if (N < y) {
            if (N < z) {
                isOrdered = true;
            }
            if (N > z) {
                isOrdered = false;
            }
        }
        
        /* if statement that considers the special case where x = y, y = z,
         * and/or z = x, in which case isOrdered is set to be the value of
         * false.
         */
        if (x == y || y == z || x == z) { 
            isOrdered = false;
        }
        System.out.println(isOrdered);
    }
} // End class Ordered


