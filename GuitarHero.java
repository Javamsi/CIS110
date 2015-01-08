/*************************************************************************
  * Name         : Vamsi Jandhayala
  * PennKey      : javamsi
  * Recitation # : 207
  *
  * Description  : The purpose of this program is to create a keyboard by 
  * implementing the methods of GuitarString.java and constructing a particular
  * key for each of the keys of the string keyboard. This maps certain notes
  * to certain keys which the user can experiment with to produce sounds of 
  * different frequencies. 
  * 
  *  
  * Input: javac GuitarHero.java
  * java GuitarHero
  * 
  * Output: An empty white space window appears and keys can be typed to play
  * certain notes. 
  *****************************************************************************/
public class GuitarHero {

    public static void main(String[] args) {
        int N = 0;
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[keyboard.length()];
        for (int i = 0; i < strings.length; i++) {
            N = (int) (440.0 * Math.pow(2.0, (double)(i-24)/12));
            strings[i] = new GuitarString(N);
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
        }
    }

}
