public class Foo { 
public static String bar(String s) { 
if (s.length() < 2) return s; 
int m = s.length() / 2; 
String lh = bar(s.substring(0, m)); 
String rh = bar(s.substring(m, s.length())); 
s = rh + lh; 
System.out.println(s); 
return s; 
} 
public static void main(String[] args) { 
String s = args[0]; 
s = bar(s); 
} 
}