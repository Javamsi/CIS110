
public class Students {
    public static void main (String[] args) { 

        // read the number of students
        int N = StdIn.readInt();
      
        // initialize four parallel arrays
        String[] first = new String[N];
        String[] last  = new String[N];
        String[] email = new String[N];
        int[] section  = new int[N];

        // read in the data
        for (int i = 0; i < N; i++) {
            first[i]   = StdIn.readString();
            last[i]    = StdIn.readString();
            email[i]   = StdIn.readString();
            section[i] = StdIn.readInt();
        }

       // print email addresses of all students in section 4
        StdOut.println("Section 4");
        StdOut.println("---------");
        for (int i = 0; i < N; i++) {
            if (section[i] == 4) {
                StdOut.println(email[i]);
            }
        }
        StdOut.println();

        // print email addresses of all students in section 5
        StdOut.println("Section 5");
        StdOut.println("---------");
        for (int i = 0; i < N; i++) {
            if (section[i] == 5) {
                StdOut.println(email[i]); 
            }
        } 

    }

}
