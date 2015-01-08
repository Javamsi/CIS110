public class Art1 {
    public static void main (String[] args) {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        double x = 0.00;
        double y = 0.00;
        double size = 1.00;
        int N = Integer.parseInt(args[0]);
        //Calls function Sierpinski for left and right sides of the triangle.
        sierpinski(N, x, y, size);
        sierpinski(N, x, y, -size); 
    }
    
    //Draws a triangle to be reused for the recursion 
    public static void solidTriangle (double x, double y, double size) {
      double a = x;
          
        StdDraw.line(x, y, x + size, y);
     
       
    }
    
    //Sierpinski functions that draws the triangles on all three sides
    //recursively. The function is called for each section.
    public static int sierpinski (int n, double x, double y, double size){
        if (n == 0) {
            return n;
        }
        solidTriangle(x, y, size);
        x += 0.5 * size;
        size = 0.5 * size;
        //Calls the function sierpinski for the right and left sections
        sierpinski(n, x, y, size);
        sierpinski(n, x, y, -size);
        return n;
    }
}


