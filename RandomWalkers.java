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
 * mean squared distance = ......
 */

import java.util.Random; //imports the package Random

//Begin public class RandomWalker
public class RandomWalkers{
    public static void main (String[] args) {
        //Initialize int and double variables
        int z = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        Random generator = new Random ();
        int x = 0;
        int y = 0;
        double distance = 0;
        double m = 0;
        int directionx, directiony, magnitudex, magnitudey;
        
        /*for loop that sets the number of iterations of squared distance
         * to be conducted based on the command line argument T.
         */
        for(int j = 0; j < T; j++){
            
            for(int i = 0; i < z; i++){
                //Setting direction and magnitude to random integers of 0 or 1 
                directionx = generator.nextInt(2);
                directiony = generator.nextInt(2);
                magnitudex = generator.nextInt(2);
                magnitudey = generator.nextInt(2);
                
                //if statements to carry out direction and magnitude of motion
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
                
                
            } 
            //Calculating the distance squared.
            distance = ((x*x) + (y*y));   
        } 
        m = m + distance; 
        /* This allows the sum to be calculated and stored for each iteration
         * to provide a total sum of the squared distances
         */
        double meansquareddistance = m / T;
        /*Dividing the total sum by the number of iterations to find the mean
         * squared distance.
         */
        System.out.println("mean squared distance = " + meansquareddistance);
        
    }
} //End class RandomWalkers

