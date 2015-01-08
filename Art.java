public class Art { 
    
    public static void main(String[] args) {
        // Initialize the coordinates 
        int N = Integer.parseInt(args[0]);
        double x1 = 0.0;
        double y1 = 0.7;
        double x2 = 0.5;
        double y2 = 0.0;
        double x3 = 1.0;
        double y3 = 0.7;
        double x4 = 0.50;
        double y4 = 0.75;
        double x5 = 0.0;
        double y5 = 0.25;

        for (int i = 0; i < N; i++) {
            // Calls snowFlake for each of the initial triangle's three sides
            snowFlake(N, x2, y2, x1, y1);
            snowFlake(N, x3, y3, x2, y2);
            snowFlake(N, x1, y1, x3, y3);
            x1 = x1 + Math.pow(0.5, N);
            x3 = x3 - Math.pow(0.5, N);
        }
    }
    //Recursive function that plots coordinates and draws a snowflake 
    public static void snowFlake(int n, double x1, double y1,  
                                 double x5, double y5) {
        double dx, dy, x2, x3, x4, y2, y3, y4;
        double sqrt = (Math.sqrt(3) / 6.0);
        
        if (n == 0) {
            StdDraw.line(x5, y5, x1, y1);
        }
        //Sets the coordinates and then calls the method snowFlake 4 times
        else {
            dx = x5 - x1;
            dy = y5 - y1;
            
            x2 = x1 + (dx/3);
            y2 = y1 + (dy/3);
            
            x3 = (0.5*(x5 + x1) + sqrt * (y1 - y5));
            y3 = (0.5*(y5 + y1) + sqrt * (x5 - x1));
            
            x4 = x5 - (dx/3);
            y4 = y5 - (dy/3);
            
            snowFlake(n-1, x2, y2, x1, y1);
            snowFlake(n-1, x3, y3, x2, y2); 
            snowFlake(n-1, x3, y3, x4, y4);
            snowFlake(n-1, x4, y4, x5, y5);
            
        }
    }
}

