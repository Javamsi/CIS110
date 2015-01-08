/* PhotoMagic.java
 * Vamsi Jandhayala
 * 
 * October 16, 2012
 * 
 * PennKey: javamsi
 * Recitation: 207
 * 
 * Objective: The purpose of this program is to encrypt a binary string to 
 * a picture by using a transform function that Xor's the original binary string
 * of a certain length with the LSFR.generate() function (which returns a new
 * binary string). The string gets stored for the filename and the original
 * picture is restored if the same binary string is passed as the command line
 * argument.
 * 
 * Usage:
 * %PhotoMagic.java
 * %java PhotoMagic pipe.png 01101000010100010000 16
 * Output: Prints the picture of pixels
 * created from Xor-ing the original binary password
 * 
 * Usage: 
 * %PhotoMagic.java
 * %java PhotoMagic Xpipe.png 01101000010100010000 16
 * Output: Restores the original picture 
 */

public class PhotoMagic {
    //Transforms the picture using LFSR
    public static int[][]  transform(int[][] picture, String seed, int tap) {
        LFSR.init(seed, tap);
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                picture [i][j] = picture[i][j] ^ LFSR.generate(32);
            }
        }
        
        // displays the picture in a window
        ImageData.show(picture);
        return picture;
    }
    
    /*Reads in the name of a picture and the description of an LFSR
     * from the command-line and encrypt the picture with the LFSR*/
    public static void main(String[] args) {
        String binarypass = args[1];
        int tap = Integer.parseInt(args[2]); 
        int [][] picture = ImageData.imageData(args[0]);
        PhotoMagic.transform(picture, binarypass, tap);
    }
} 


