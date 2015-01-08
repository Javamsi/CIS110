public class Why { 
    private String question; 
    private String answer; 
    public Why() { answer = "Because."; } 
    public Why(String q) { 
        question = q; 
        answer = "Why not?"; 
    } 
    public Why(String q, String a) { 
        question = q; 
        answer = a; 
    } 
    public String question() { 
        String q = "Why"; 
        if (question.length() > 0) 
            q = q + " " + question; 
        q = q + "?"; 
        return q; 
    } 
    public String answer() { 
        return answer; 
    } 
  //  public String toString() { 
    //    return question() + "\n" + answer() + "\n"; 
    //} 
    public static void main (String[] args) {
        Why w = new Why("why did the chicken cross the road?");
        System.out.println(w.toString());
    }
}