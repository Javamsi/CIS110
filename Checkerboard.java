/* Checkerboard.java
 * Vamsi Jandhayala
 * 
 * September 16, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: Takes the inputed command line argument N, changes it into an
 * int type values and outputs N * N "*" values with spaces in between. The 
 * goal is to create a checkerboard pattern with alternating string characters
 * of "*" and " ". 
 * 
 * Usage:
 * %javac Checkerboard.java 
 * %java Checkerboard 2 (any N value)
 * Output: 
 *    "* * 
 *      * *"
 */

//Begin public class Checkerboard
public class Checkerboard {
    public static void main (String[] args) {
        /*Declare int x and set it to the value of the first command line
         argument */
        int x = Integer.parseInt(args[0]);
        int i;
        
        /*First if statement that is initiated if N is even, includes
         * nested for loops. 
         */
        
        if (x % 2 == 0){
            for(i = 0; i < x ; i += 2 ) {
                
                if (i > 0) {
                    System.out.println();
                }
                for(int a = 0; a < x; a+= 1){
                    System.out.print("* ");  
                }
                System.out.println();
                for(int a = 0; a < x; a+= 1){
                    System.out.print(" *");
                }
            }
            
            System.out.println();
        }
        
        /* Second if statement that is initiated if N is odd. Includes a nested 
         * for loop and if statements. 
         */
        if (x % 2 == 1) {
            for(i = 1; i < x+1; i+= 2){
                
                if(i != x+1) {
                    if(i > 1) {
                        System.out.println();
                    }
                    for(int a = 0; a < x; a+= 1){
                        System.out.print("* ");
                    }
                        System.out.println();
                }
                if(i != x){
                    for(int a = 0; a < x; a+= 1){
                        System.out.print(" *");
                        
                    }   
                }
            } 
        } 
    }
} //End public class Checkerboard 








