/* SumThree.java
 * Vamsi Jandhayala
 * 
 * September 8, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: Takes the 3 inputed string type numbers in the command line
 * argument, changes them into int type values and outputs their sum
 * 
 * Usage:
 * %javac SumThree.java
 * %java SumThree 1 2 3 (any three numbers)
 * Output: 6  (the sum of the three numbers)
 */

public class SumThree { //Begins class SumThree
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]); //Sets the 1st string type input
        //to the int type variable x
        int y = Integer.parseInt(args[1]); //Sets the 2nd string type input 
        //to the int type variable y
        int z = Integer.parseInt(args[2]); //Sets the 3rd string type input
        //to the int type variable z
        System.out.println(x+y+z); //Prints out the sum of variables x,y,z, 
        //which are the inputed values
    }
} //Ends class SumThree