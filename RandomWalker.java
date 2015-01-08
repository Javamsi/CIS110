/* RandomWalkers.java
 * Vamsi Jandhayala
 * 
 * September 16, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: Takes the 2 inputed string type numbers in the command line
 * argument, changes them into int type values, and outputs the mean squared 
 * distance traveled from the origin from a number of trials. 
 * 
 * Usage:
 * %javac RandomWalker.java
 * %java RandomWalker 100 10000
 * Output:
 * (,)
 * ...
 * ...
 * squared distance = ....
 */

import java.util.Random; //imports the package Random

//Begin public class RandomWalker
public class RandomWalker{
    public static void main (String[] args) {
        //Initialize int variables and Random generator
        int z = Integer.parseInt(args[0]);
        Random generator = new Random ();
        int x = 0;
        int y = 0;
        int distancesquared = 0;
        int directionx, directiony, magnitudex, magnitudey;
        
        /* Simulates the Brownian motion of the walker until z movements 
         * are reached.
         */
        
        for(int i = 0; i < z; i++){
            /*Represent the positive and negative
             * motion in both the x and y dimension.
             */
            directionx = generator.nextInt(2);
            directiony = generator.nextInt(2);
            magnitudex = generator.nextInt(2);
            magnitudey = generator.nextInt(2);
            /*if statements to  carry out particular functions depending on 
             * the values of directionx and directiony. 
             */
            if (directionx == 0) {
                x = x + magnitudex;
            }
            if (directionx == 1) {
                x = x - magnitudex;
            }
            if (directiony == 0) {
                y = y + magnitudey;   
            }
            if (directiony == 1) {
                y = y - magnitudey;
                
            } 
            System.out.println("(" + x + "," + y + ")");
        }
        //Solving for distancesquared
        distancesquared = ((x*x) + (y*y));
        System.out.println("squared distance = " + distancesquared);
    }  
} //End class RandomWalker


