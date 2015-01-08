/* HiFive.java
 * Vamsi Jandhayala 
 * 
 * September 8, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 *
 * Objective: Takes the five input names in the command line argument
 * and prints them in reverse order in a specified sentence.
 *
 * Usage:
 * % javac HiFive.java 
 * % java HiFive a b c d e (any five names)
 * Output: "e, d, c, b and a were late to class" (the reverse order 
 * of the names in a sentence)
 */

public class HiFive { //Begins class HiFive
    public static void main(String [] args) {
        System.out.print(args[4]); //Prints out the last of the 
        //inputed values
        System.out.print(", "); //Prints out the specified statement
        System.out.print(args[3]); //Prints out the second to last of 
        //the inputed values
        System.out.print(", "); //Prints out the specified statement
        System.out.print(args[2]); //Prints out the third to last of 
        //the inputed values
        System.out.print(", "); //Prints out the specified statement
        System.out.print(args[1]); //Prints out the fourth to last of
        //the inputed values
        System.out.print(" and "); //Prints out the specified statement
        System.out.print(args[0]); //Prints out the fifth to last of
        //the inputed values
        System.out.println(" were late to class."); //Prints out the 
        //specified statement
    }
} //Ends Class HiFive
