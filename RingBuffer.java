
/*************************************************************************
  * Name         : Vamsi Jandhayala
  * PennKey      : javamsi
  * Recitation # : 207
  *
  * Description  : The purpose of this program is to create a ring buffer that
  * fills the array until the capacity is reached. The ringbuffer is similar to
  * LFSR except the values are replaced. The peek value is obtained for 
  * purposes used in GuitarString.java. 
  *  
  * Input:
  * javac RingBuffer.java
  * java RingBuffer 10
  * 
  * Output: 
  * Size after wrap around is 55.0
  *****************************************************************************/

public class RingBuffer {
    private double[] rb;          // items in the buffer
    private int first;            // index for the next dequeue or peek
    private int last;             // index for the next enqueue
    private int size;             // number of items in the buffer
    
    
    // create an empty buffer, with given max capacity
    public RingBuffer(int capacity) {
        rb = new double[capacity];
        first = 0;
        last = 0;
        size = 0;
    }
    
    // return number of items currently in the buffer
    public int size() {
        return size;
    }
    
    // is the buffer empty (size equals zero)?
    public boolean isEmpty() {
        return size == 0;
    }
    
    // is the buffer full (size equals array capacity)?
    public boolean isFull() {
        return size == rb.length;
    }
    
    // add item x to the end
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x; 
        last = (last + 1) % rb.length;
        size++;
        if(last == rb.length)  {
            last = 0;
        }
    }
    
    // delete and return item from the front
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        double d = rb[first];
        first = first + 1;
        if(first == rb.length) {
            first = 0;
        }
        size--;
        return d;
    }
    
    // return (but do not delete) item from the front
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
    }
    
}