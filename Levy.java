// Levy tapestry applet (C)1998 by J. L. Pe
import java.applet.Applet;
import java.awt.*;

public class Levy extends Applet implements Runnable
{
 static final double DEGTORAD = .01745329251994;
 int xOrigin, yOrigin;
 int w, h;
 double alpha = 45 * DEGTORAD, fineness = .01; 
 double rotAngle, magnificationFactor, contractionFactor;
 Rectangle r;
 Point[] initialPts, initialPts2, initialPts3;
 double[] initialXs = {-.5, .5, .5, -.5};
 double[] initialYs = {.6, .6, -.4, -.4};
 double[] initialXs2 = {0, .5, 0, -.5};
 double[] initialYs2 = {.6, .1, -.4, .1};
 double[] initialXs3 = {-.1, .1, .1, -.1};
 double[] initialYs3 = {.3, .3, -.1, -.1};
 Color maroon = new Color(128, 0, 0);
 Thread paintThread;
 int delay = 12000;
 int spinIndex = 0;

 public String getAppletInfo()
 {
  return "Levy tapestry applet (C) 1998 by J. L. Pe";
 }

 public void init()
 {
  setBackground(Color.black);
  r = bounds();
  w = r.width;
  h = r.height;
  xOrigin = w / 2;
  yOrigin = h / 2;
  try
  {
   alpha =  Double.valueOf(getParameter("angle")).doubleValue() * DEGTORAD;
   fineness =  Double.valueOf(getParameter("fineness")).doubleValue();
   delay = Integer.parseInt(getParameter("delay")); 
   if ((alpha <= 0) || (alpha >= 90))
    throw new Exception("Bad angle value");
   if ((fineness <= 0) || (fineness >= 1))
    throw new Exception("Bad fineness value");
  }
  catch(Exception exc)
  {
   showStatus("Bad HTML parameter values");
   System.out.println("Bad HTML parameter values");
  }
  contractionFactor = Math.cos(alpha);
  magnificationFactor = .5 * Math.min(xOrigin, yOrigin);
 
  initialPts = new Point[4];
  initialPts2 = new Point[4];
  initialPts3 = new Point[4];
  for (int i = 0; i < 4; i++)
  {
   initialPts[i] = new Point(initialXs[i], initialYs[i]);   
   initialPts2[i] = new Point(initialXs2[i], initialYs2[i]);   
   initialPts3[i] = new Point(initialXs3[i], initialYs3[i]);   
  }
  paintThread = new Thread(this);
  paintThread.start();
 }

 public void run()
 {
  while(true)
  {
   spinIndex++;
   try
   {
    Thread.sleep(delay);
   }
   catch(InterruptedException iex){}   // pause to admire the view!

   repaint();
  }
 }
 private double sqDistance(Point p1, Point p2)
 {
  return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
 } 

 private void drawLevy(Graphics g, Point left, Point right, double magnification, int colorStyle)
 {
  Point left2, right2, left3, right3;
  int[] lplotter, rplotter, cplotter;
  double distance = 0;

   // compute points of children segments
  left2 = left;
  right2 = (Point.linearCombination(1 - contractionFactor, left, contractionFactor, right)).rotate(alpha, left);
  left3 = right2;
  right3 = right; 
  
   // if last level of recursion is reached, then draw segments and return
  lplotter = left.relativize(xOrigin, yOrigin, magnification);
  rplotter = right.relativize(xOrigin, yOrigin, magnification);
  cplotter = right2.relativize(xOrigin, yOrigin, magnification);
  distance = Math.sqrt(sqDistance(left, right));
  if (distance < fineness)
  {
   if (colorStyle == 0)
   {
    g.setColor(Color.gray);
   }else if (colorStyle == 1)
   {
    g.setColor(Color.green);
   }
   else
   {
    g.setColor(maroon);
   }
   g.drawLine(lplotter[0], lplotter[1], cplotter[0], cplotter[1]);
   if (colorStyle == 0)
   {
    g.setColor(Color.red);
   }else if (colorStyle == 1)
   {
    g.setColor(Color.yellow);
   }
   else
   {
    g.setColor(Color.magenta);
   } 
   g.drawLine(cplotter[0], cplotter[1], rplotter[0], rplotter[1]);
   return;
  }

  // recursively draw next segments if last level not yet reached
  drawLevy(g, left2, right2, magnification, colorStyle);
  drawLevy(g, left3, right3, magnification, colorStyle);
  
 }

 public void paint(Graphics g)
 {
  if (spinIndex % 6 == 0)
  {
   drawLevy(g, initialPts[0], initialPts[1], magnificationFactor, 0);
   drawLevy(g, initialPts[1], initialPts[2], magnificationFactor, 0);
   drawLevy(g, initialPts[2], initialPts[3], magnificationFactor, 0);
   drawLevy(g, initialPts[3], initialPts[0], magnificationFactor, 0);

   drawLevy(g, initialPts2[0], initialPts2[1], magnificationFactor, 1);
   drawLevy(g, initialPts2[1], initialPts2[2], magnificationFactor, 1);
   drawLevy(g, initialPts2[2], initialPts2[3], magnificationFactor, 1);
   drawLevy(g, initialPts2[3], initialPts2[0], magnificationFactor, 1);

   drawLevy(g, initialPts3[0], initialPts3[1], magnificationFactor, 2);
   drawLevy(g, initialPts3[1], initialPts3[2], magnificationFactor, 2);
   drawLevy(g, initialPts3[2], initialPts3[3], magnificationFactor, 2);
   drawLevy(g, initialPts3[3], initialPts3[0], magnificationFactor, 2);
  }
  else if (spinIndex % 6 == 1)
  {
   drawLevy(g, initialPts3[0], initialPts3[1], magnificationFactor, 2);
   drawLevy(g, initialPts3[1], initialPts3[2], magnificationFactor, 2);
   drawLevy(g, initialPts3[2], initialPts3[3], magnificationFactor, 2);
   drawLevy(g, initialPts3[3], initialPts3[0], magnificationFactor, 2);

   drawLevy(g, initialPts2[0], initialPts2[1], magnificationFactor, 1);
   drawLevy(g, initialPts2[1], initialPts2[2], magnificationFactor, 1);
   drawLevy(g, initialPts2[2], initialPts2[3], magnificationFactor, 1);
   drawLevy(g, initialPts2[3], initialPts2[0], magnificationFactor, 1);

   drawLevy(g, initialPts[0], initialPts[1], magnificationFactor, 0);
   drawLevy(g, initialPts[1], initialPts[2], magnificationFactor, 0);
   drawLevy(g, initialPts[2], initialPts[3], magnificationFactor, 0);
   drawLevy(g, initialPts[3], initialPts[0], magnificationFactor, 0);
  }
  else if (spinIndex % 6 == 2)
  {
   drawLevy(g, initialPts2[0], initialPts2[1], magnificationFactor, 1);
   drawLevy(g, initialPts2[1], initialPts2[2], magnificationFactor, 1);
   drawLevy(g, initialPts2[2], initialPts2[3], magnificationFactor, 1);
   drawLevy(g, initialPts2[3], initialPts2[0], magnificationFactor, 1);

   drawLevy(g, initialPts3[0], initialPts3[1], magnificationFactor, 2);
   drawLevy(g, initialPts3[1], initialPts3[2], magnificationFactor, 2);
   drawLevy(g, initialPts3[2], initialPts3[3], magnificationFactor, 2);
   drawLevy(g, initialPts3[3], initialPts3[0], magnificationFactor, 2);

   drawLevy(g, initialPts[0], initialPts[1], magnificationFactor, 0);
   drawLevy(g, initialPts[1], initialPts[2], magnificationFactor, 0);
   drawLevy(g, initialPts[2], initialPts[3], magnificationFactor, 0);
   drawLevy(g, initialPts[3], initialPts[0], magnificationFactor, 0);
  }
  else if (spinIndex % 6 == 3)
  {
   drawLevy(g, initialPts[0], initialPts[1], magnificationFactor, 2);
   drawLevy(g, initialPts[1], initialPts[2], magnificationFactor, 2);
   drawLevy(g, initialPts[2], initialPts[3], magnificationFactor, 2);
   drawLevy(g, initialPts[3], initialPts[0], magnificationFactor, 2);

   drawLevy(g, initialPts2[0], initialPts2[1], magnificationFactor, 1);
   drawLevy(g, initialPts2[1], initialPts2[2], magnificationFactor, 1);
   drawLevy(g, initialPts2[2], initialPts2[3], magnificationFactor, 1);
   drawLevy(g, initialPts2[3], initialPts2[0], magnificationFactor, 1);

   drawLevy(g, initialPts3[0], initialPts3[1], magnificationFactor, 0);
   drawLevy(g, initialPts3[1], initialPts3[2], magnificationFactor, 0);
   drawLevy(g, initialPts3[2], initialPts3[3], magnificationFactor, 0);
   drawLevy(g, initialPts3[3], initialPts3[0], magnificationFactor, 0);
  }
  else if (spinIndex % 6 == 4)
  {
   drawLevy(g, initialPts3[0], initialPts3[1], magnificationFactor, 1);
   drawLevy(g, initialPts3[1], initialPts3[2], magnificationFactor, 1);
   drawLevy(g, initialPts3[2], initialPts3[3], magnificationFactor, 1);
   drawLevy(g, initialPts3[3], initialPts3[0], magnificationFactor, 1);

   drawLevy(g, initialPts2[0], initialPts2[1], magnificationFactor, 0);
   drawLevy(g, initialPts2[1], initialPts2[2], magnificationFactor, 0);
   drawLevy(g, initialPts2[2], initialPts2[3], magnificationFactor, 0);
   drawLevy(g, initialPts2[3], initialPts2[0], magnificationFactor, 0);

   drawLevy(g, initialPts[0], initialPts[1], magnificationFactor, 2);
   drawLevy(g, initialPts[1], initialPts[2], magnificationFactor, 2);
   drawLevy(g, initialPts[2], initialPts[3], magnificationFactor, 2);
   drawLevy(g, initialPts[3], initialPts[0], magnificationFactor, 2);
  }
  else if (spinIndex % 6 == 5)
  {
   drawLevy(g, initialPts2[0], initialPts2[1], magnificationFactor, 0);
   drawLevy(g, initialPts2[1], initialPts2[2], magnificationFactor, 0);
   drawLevy(g, initialPts2[2], initialPts2[3], magnificationFactor, 0);
   drawLevy(g, initialPts2[3], initialPts2[0], magnificationFactor, 0);

   drawLevy(g, initialPts3[0], initialPts3[1], magnificationFactor, 2);
   drawLevy(g, initialPts3[1], initialPts3[2], magnificationFactor, 2);
   drawLevy(g, initialPts3[2], initialPts3[3], magnificationFactor, 2);
   drawLevy(g, initialPts3[3], initialPts3[0], magnificationFactor, 2);

   drawLevy(g, initialPts[0], initialPts[1], magnificationFactor, 1);
   drawLevy(g, initialPts[1], initialPts[2], magnificationFactor, 1);
   drawLevy(g, initialPts[2], initialPts[3], magnificationFactor, 1);
   drawLevy(g, initialPts[3], initialPts[0], magnificationFactor, 1);
  }
 }
}

class Point
{
 double x, y;

 Point(double x, double y)
 {
  this.x  =  x;
  this.y = y;
 }

 Point()
 {
  this(0, 0);
 }

 Point translate(Point p)
 {
  Point output = new Point();

  output.x = this.x + p.x;
  output.y = this.y + p.y;

  return output;
 }

 Point scalarMult(double r)
 {
  Point output = new Point();

  output.x = r * this.x;
  output.y = r * this.y;

  return output;

 }
 
 Point rotateO(double angle)  //rotate point by angle about the origin
 {
  Point output = new Point();

  output.x = this.x * Math.cos(angle) + (-this.y) * Math.sin(angle);
  output.y = this.x * Math.sin(angle) + this.y * Math.cos(angle);

  return output;
 }

 Point rotate(double angle, Point p)   
  // rotate through angle about arbitrary point p
 {
  Point output = new Point();

  output = this.translate(p.scalarMult(-1));
  output = output.rotateO(angle);
  output = output.translate(p);

  return output;
 }

 static Point sum(Point p1, Point p2)
 {
  Point output = new Point();

  output.x = p1.x + p2.x;
  output.y = p1.y + p2.y;

  return output;
 }

 static Point linearCombination(double a, Point p1, double b, Point p2)
 {
  return sum(p1.scalarMult(a), p2.scalarMult(b));
 }

 int[] relativize(int screenX, int screenY, double magnification)   // get screen coordinates of this point, where screen origin is (screenX, screenY)
 {
  int[] output = new int[2];

  output[0] = (int)(magnification * this.x + screenX);
  output[1] = (int)(screenY - magnification * this.y);

  return output;
 }  
} 