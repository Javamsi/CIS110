/*************************************************************************
  * Name         : Vamsi Jandhayala
  * PennKey      : javamsi
  * Recitation # : 207
  *
  * Description  : The purpose of this program is the same as GuitarHero.java 
  * except in addition, the plot of the last N samples is plotted to emulate
  * the frequencies of the notes played. 
  *  
  * Input:
  * javac GuitarHeroVisualizer.java
  * java GuitarHeroVisualizer
  *  
  * Output: 
  * Opens a window that creates a graph of the data as the user plays different
  * notes. 
  *****************************************************************************/

public class GuitarHeroVisualizer {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[keyboard.length()];
        int numplots = 1000;
        //Set the X and Y scale of the graph
        StdDraw.setXscale(0, numplots);
        StdDraw.setYscale(-0.5, 0.5);
        double[] y = new double[numplots];
        double[] time = new double[numplots];
        int timestep = 0;
        
        for (int i = 0; i < strings.length; i++) {
            int N = (int) (440.0 * Math.pow(2.0, (double)(i-24)/12));
            strings[i] = new GuitarString(N);
        }
        
        //set the x axis from 0 to numplots
        for(int i = 0; i < numplots; i++) {
            time[i] = i;
        }
        
        // the main input loop
        while (true) {
            
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index >= 0) {
                    GuitarString string = strings[index];
                    string.pluck();
                }
            }
            // compute the superposition of the samples
            double sample = 0.0;
            for (GuitarString gs : strings) {
                sample += gs.sample();
                gs.tic();
            }
            StdAudio.play(sample);
            
            // Plot the graph if the last N samples were collected
            if(timestep == numplots) {
                StdDraw.clear();
                StdDraw.polygon(time, y);
                timestep = 0;
            }
            y[timestep] = sample;
            timestep++;
        }
    }
}


