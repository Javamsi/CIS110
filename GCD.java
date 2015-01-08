/* GCD.java
 * Vamsi Jandhayala
 * 
 * September 16, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: Takes the 2 inputed string type numbers in the command line
 * arguments, changes them into int type values and outputs their GCD.
 * 
 * Usage:
 * %javac GCD.java
 * %java GCD 10 8 (any two numbers)
 * Output: "The GCD of 10 and 8 is 2"  
 */

public class GCD {
    public static void main (String[] args) {
        /* Initializes int a, b, x, and y*/
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]); 
        int x = a;
        int y = b;
        
        /* while statement that is conducted when a does not equal b. The first 
         * if statement is initialized when a > b and the second when b > a.
         */
        while (a != b) {
            
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        System.out.println("The GCD of " + x + " and " + y + " is " + b);
    }  
} //Ends public class GCD.







