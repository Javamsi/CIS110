public class Art2 {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        //Calls function Sierpinski for left and right sides of the triangle.
    }
    
    //Draws a triangle to be reused for the recursion 
    public static int snowFlake(int n, double x1, double y1, 
                                double x5, double y5) {
        double dx, dy, x2, x3, x4, y2, y3, y4;
        double size = 0.50;
        
        if(n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            StdDraw.line(x2, y2, x3, y3);
            StdDraw.line(x3, y3, x4, y4);
            StdDraw.line(x4, y4, x5, y5);
        }
        
        else {
            dx = x5 - x1;
            dy = y5 - y1;
            
            x2 = x1 + (dx/3);
            y2 = y1 + (dy/3);
            
            double sqrt = Math.sqrt(3) / 6;
            x3 = ((x1 + x5)/2 + sqrt * (y1 - y5));
            y3 = ((y1 + y5)/2 + sqrt * (x5 - x1));
            
            x4 = x1 + dx * (2/3);
            y4 = y1 + dy * (2/3);
            
            return n;
        }
        
    }
    
    
    
//Sierpinski functions that draws the triangles on all three sides
//recursively. The function is called for each section.
    public static int sierpinski (int n, double x, double y, double size){
        if (n == 0) {
            return n;
        }
        
        boolean bFlag=true;
        n--;
        
        //Calls the function sierpinski for the top section.
        /*if (bFlag == true){
         sierpinski(n, x , y + y1, dx);
         bFlag = false;
         }*/
        
        //Calls the function sierpinski for the right and left sections
        sierpinski(n, x, y, size);
        sierpinski(n, x, y, -size);
        return n;
    }
}


