/* RGBtoCMYK.java
 * Vamsi Jandhayala
 * 
 * September 16, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: Takes the 3 command line arguments of RGB values converts them 
 * double types, and then computes and outputs the respective cyan,
 * magenta, yellow, and black color values.
 * 
 * Usage:
 * %javac RGBtoCMYK.java
 * %java RGBtoCMYK 255 0 100 (any three numbers)
 * Output: 
 * cyan: ......
 * magenta: ......
 * yellow: ......
 * black: .......
 */

//Begin public class RGBtoCMYK
public class RGBtoCMYK {
    public static void main (String[] args) {
        // Declare double type variables
        double r = Double.parseDouble(args[0]);
        double g = Double.parseDouble(args[1]);
        double b = Double.parseDouble(args[2]);
        double a = Math.max(r, g);
        double c = Math.max(g, b);
        double white; double cyan; double magenta; double yellow; double black;
        
        //If statement that considers when max value a > c
        if (a > c) {
            /*Setting white, cyan, magenta, yellow, and black to values
             * based on the equations to convert RGB values to CMYK values.
             */
            white = (r/255);
            cyan = ((white - (r/255))/ white);
            magenta = ((white - (g/255))/white);
            yellow = (white - (b/255));
            black = (1 - white);
            /*Prints out the corresponding cyan, magenta, yellow, 
             * and black values */
            System.out.print("cyan = "); 
            System.out.println(cyan);
            System.out.print("magenta = ");
            System.out.println(magenta);
            System.out.print("yellow = ");
            System.out.println(yellow);
            System.out.print("black = ");
            System.out.println(black);
        }
        
        // If statement that considers when max value c is greater than a
        if(c > a) {
            white = (b/255);
            cyan = ((white - (r/255))/ white);
            magenta = ((white - (g/255))/white);
            yellow = (white - (b/255));
            black = (1 - white);
            System.out.print("cyan = "); 
            System.out.println(cyan);
            System.out.print("magenta = ");
            System.out.println(magenta);
            System.out.print("yellow = ");
            System.out.println(yellow);
            System.out.print("black = ");
            System.out.println(black);
        } 
        //If statement that considers when max value a is equal to c
        if(a == c && a > 0 && c > 0) {
            white = (g/255);
            cyan = ((white - (r/255))/ white);
            magenta = ((white - (g/255))/white);
            yellow = (white - (b/255));
            black = (1 - white);
            System.out.print("cyan = "); 
            System.out.println(cyan);
            System.out.print("magenta = ");
            System.out.println(magenta);
            System.out.print("yellow = ");
            System.out.println(yellow);
            System.out.print("black = ");
            System.out.println(black);
        }
            
        /*The following nested if statements considers the special case where 
         * all three RGB values are 0.0.
         */
        if(r == 0.0) {
            if(g == 0.0){
                if(b == 0.0){
                    cyan = 0;
                    magenta = 0;
                    yellow = 0;
                    black = 1;
                    System.out.print("cyan = "); 
                    System.out.println(cyan);
                    System.out.print("magenta = ");
                    System.out.println(magenta);
                    System.out.print("yellow = ");
                    System.out.println(yellow);
                    System.out.print("black = ");
                    System.out.println(black);
                }
            }
        } 
    }  
} //End public class RGBtoCMYK