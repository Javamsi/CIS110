public class Sierpinski {
    public static void main(String[] args) {
        //Draws unit triangle
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(0.0, 0.0, 0.5, (Math.sqrt(3)/2));
        StdDraw.line(0.5, (Math.sqrt(3)/2), 1.0, 0.0);
        double x = 0.50;
        double y = 0.00;
        double size = 0.50;
        int N = Integer.parseInt(args[0]);
        //Calls function Sierpinski for left and right sides of the triangle.
        sierpinski(N, x, y, size);
        sierpinski(N, x, y, -size); 
    }
    
    //Draws a triangle to be reused for the recursion 
    public static void solidTriangle(double x, double y, double size) {
        double dx = 0.5 * size;
        double y1 = Math.sqrt((size*size) - (dx*dx));
        double[] x0 = {x, (x + (size/2)), (x - (size/2))};
        double[] y0 = {y, (y + y1), (y + y1)};
        StdDraw.filledPolygon(x0, y0);
    }
    
    //Sierpinski functions that draws the triangles on all three sides
    //recursively. The function is called for each section.
    public static int sierpinski(int n, double x, double y, double size) {
        if (n == 0) {
            return n;
        }
        double dx = 0.50 * size;
        double y1 = Math.sqrt((size*size) - (dx*dx));
        solidTriangle(x, y, size);
        //Calls the function sierpinski for the top section.
        sierpinski(n-1, x , y + y1, dx);   
        //Calls the function sierpinski for the right and left sections
        sierpinski(n-1, x + dx, y, dx);
        sierpinski(n-1, x + dx, y, -dx);
        return n;
    }
}


