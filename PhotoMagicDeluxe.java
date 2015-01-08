/* PhotoMagicDeluxe.java
 * Vamsi Jandhayala
 * 
 * October 17, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: The purpose of this program is similar to PhotoMagic.java in that
 * it takes a command line "password" and encrypts a particular picture. Then,
 * the original base 64 password is converted to a binary string that is 
 * read by the function PhotoMagic.transform(). The original picture is restored
 * if the original password is used.
 * 
 * Usage:
 * %PhotoMagicDeluxe.java
 * %java PhotoMagicDeluxe pipe.png 1AZe34E456 16
 * Output: Prints the picture of pixels
 * created from Xor-ing the original base 64 password
 * 
 * Usage: 
 * %PhotoMagicDeluxe.java
 * %java PhotoMagicDeluxe Xpipe.png 1AZe34E456 16
 * Output: Restores the original picture 
 */

public class PhotoMagicDeluxe {
   
    public static void main(String[] args) {
        /*Initialize arrays and string variables to convert the "password" 
         * into a binary sequence on which LFSR can be performed. */
        String base64 = 
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        int[] arr = new int[64];
        char[] arr1 = new char[10];
        String[] arr2 = new String[10];
        int[] x = new int[10];
        int[] y = new int[6];
        char[] basePass = new char[64];
        String binaryinput = "";
        String binaryPass = args[1];
        int [][] picture = ImageData.imageData(args[0]);
        int tap = Integer.parseInt(args[2]);
        
        /*  Assigns numeric values for each character of the 64 characters in
         * base 64 values based on their position. Then converts these numbers
         * to a binary sequence
         */ 
        for (int j = 0; j < binaryPass.length(); j++) {
            arr1[j] = binaryPass.charAt(j);
            x[j] = base64.indexOf(arr1[j]);
            for (int k = 5; k >= 0; k--) { 
                if (x[j] > Math.pow(2, k)) {
                    y[k] = 1;
                    x[j] = x[j] - (int) Math.pow(2, k);
                }
                arr2[j] = Integer.toString(y[k]);
                binaryinput = binaryinput + arr2[j];
            } 
        }
        
        PhotoMagic.transform(picture, binaryinput, tap);
    } 
}


