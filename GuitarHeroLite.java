public class GuitarHeroLite {
    public static void main (String[] args) {
        int[] rb = new int[37];
        double[] concert = new double[37];
        double[] keyString = new double[37];
        char[] typedKey = new char[37]; 
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        String a;
        double sample = 0;
        
        for(int i = 0; i < 36; i++) {
            rb[i] = keyboard.indexOf(i);
            concert[i] = 2 * Math.pow(440,((rb[i]-24)/12));
            keyString[i] = keyboard.charAt(i);
            GuitarString  = new GuitarString(concert[i]);
            typedKey[i] = keyboard.charAt(i);
        }
        
            while (true) {
                if(StdDraw.hasNextKeyTyped()) {
                    char key = StdDraw.nextKeyTyped();
                    for(int j = 0; j < 36; j++) {
                        if(key == typedKey[j]) {
                            ((String) keyString[j]).pluck();
                            break;
                        }
                    }
                    sample = sample + stringKey.pluck();
                }
                StdAudio.play(sample);
                for(int k = 0; k < 36; k++) {
                
            }
           
        }
        
        
        
    }  
}