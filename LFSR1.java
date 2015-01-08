public class LFSR1 {
    private static char N;
    private static char[] seedArray = new char[11];
    private static int tapPosition = 0;
    
    public static boolean init(String seed, int tap) {
        for(int i = 0; i < seedArray.length; i++) {
            seedArray[i] = seed.charAt(i);
            //System.out.println(seedArray);
        }
        return true;
    }
    
    public static int step() {
        int tapPosition = 2;
        char initial = seedArray[0];
        int initialPosition = Character.getNumericValue(initial);
        int tap = (int)seedArray[tapPosition];
        for (int i = 0; i < seedArray.length - 1; i++) {
            seedArray[i] = seedArray[i + 1];
            //System.out.print(seedArray[i]);
        }
        seedArray[seedArray.length-1] = (char)(initialPosition ^ tap);
        //System.out.println(seedArray[seedArray.length-1]);
        return Character.getNumericValue(seedArray[seedArray.length - 1]);
    }
    
    /* public static int generate (int k) {
     * 
     * 
     * 
     } */
    
    public static String string() {
        String seed = new String(seedArray);
        return seed;
    } 
    
    public static void main (String[] args) {
        String seed = "011010101101";
        LFSR.init("01101000010", 8);
        for (int i = 0; i < 10; i++) {
            int bit = LFSR.step();
            StdOut.println(LFSR.string() + " " + bit); 
        }
        
    }
} 


