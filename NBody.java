/* NBody.java
 * Vamsi Jandhayala
 * 
 * September 27, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: The purpose of this program is to simulate the solar system
 * using gravitational forces to calculate acceleration, velocity, and position
 * in the x and direction. It uses StdIn library to read in values for initial 
 * x and y positions and velocities and the number of bodies in the solar 
 * system. The StdDraw library is used to show the images and use the updated 
 * positions to simulate the motion of the bodies. Takes the 2 inputed command
 * line as increment in time and total time of simulation and increments time 
 * until the total time is reached. The position and velocities are arrays
 * that store values for each of the bodies in consideration and are updated 
 * for each of the bodies.
 * 
 * 
 * Usage:
 * %javac NBody.java
 * %java NBody 35000000 1000 < planets.txt (or any other text file)
 * Displays the canvas for the solar system along with the motion of the bodies
 * according to the program and data file. 
 *
 */

public class NBody {
    public static void main(String[] args) {
        /*Declares variables of position, velocity, acceleration, and force
         * and arrays of size N. Sets the scale and picture of background */
        int T = (int) Double.parseDouble(args[0]);
        int dt = (int) Double.parseDouble(args[1]);
        int N = Integer.parseInt(StdIn.readString());
        float R = Float.parseFloat(StdIn.readString());
        int i, j, k;
        double[] px = new double[N];
        double[] py = new double[N];
        double[] vx = new double[N]; 
        double[] vy = new double[N];
        double[] mass = new double[N];
        double ax = 0.0;
        double ay = 0.0;
        String[] image = new String[N];
        double[] fx = new double[N];
        double[] fy = new double[N];
        double G = 6.67E-11;
        StdDraw.setXscale(-R, R);
        StdDraw.setYscale(-R, R);
        StdDraw.picture(0, 0, "starfield.jpg");
        
        /* This for loop reads in the data from the directed file declared 
         * in the command line and assigns them to arrays to store the values 
         * for each of the bodies under consideration.
         */
            for (j = 0; j < N; j++) {
            px[j]   = StdIn.readDouble();
            py[j]   = StdIn.readDouble();
            vx[j]   = StdIn.readDouble();
            vy[j]   = StdIn.readDouble();
            mass[j] = StdIn.readDouble();
            image[j] = StdIn.readString();
        } 
            StdAudio.play("2001.mid");
        /* This for loop increments the time by dt until the total time T 
         * is reached. Inside, a for loop is used to calculate the net force in
         * the x and y directions. The loop is iterated until the 
         * net forces (fx and fy) are calculated for each body and the case
         * where i = j, that is the same body, is skipped.
         */
        for (k = 0; k < T; k += dt) {     
            for (i = 0; i < N; i++) {
                fx[i] = 0.0;
                fy[i] = 0.0;
                for (j = 0; j < N; j++) {
                    if (i == j) {
                        continue;
                    }
                    double dx = px[j] - px[i];
                    double dy = py[j] - py[i];
                    double d = Math.sqrt((dx * dx) + (dy * dy));
                    double F = (G * mass[i] * mass[j]) / (d * d);
                    fx[i] += ((F * dx) / d);
                    fy[i] += ((F * dy) / d);
                } 
            }
            StdDraw.picture(0, 0, "starfield.jpg");
            
            /* This for loop calculates the accelerations in the x and y 
             * direction for each of the N bodies. Calculates velocity and 
             * position. Then it redraws each of the N bodies using the updated
             * positions.
             */
            for (i = 0; i < N; i++) {
                ax = fx[i] / mass[i];
                ay = fy[i] / mass[i];
                vx[i] += ax * dt;
                vy[i] += ay * dt;
                px[i] += vx[i]*dt;
                py[i] += vy[i]*dt;  
                StdDraw.picture(px[i], py[i], image[i]);
            }
            StdDraw.show(20); 
        }
        /*For loop that prints out the final values of the arrays after the
        simualtion is complete. */
        for (i = 0; i < N; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          px[i], py[i], vx[i], vy[i], mass[i], image[i]);
        }
    }  
}