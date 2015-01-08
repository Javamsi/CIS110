/*************************************************************************
  * TopologicalSort.java
  * Name         : Vamsi Jandhayala
  * PennKey      : javamsi
  * Recitation # : 207
  *
  * Description  : The purpose of this program is to topologically sort the 
  * events from a given input. Topological sort takes the input values and 
  * checks each of the vertices or nodes that have no incoming edges and then 
  * places them in the front of the order of a linked list. Then, the rest of 
  * the nodes are marked and the function is recursively repeated until all of
  * the vertices of that have the prerequsites are read in. 
  *  
  * Input: javac TopologicalSort.java
  * java TopologicalSort tasks.java
  * 
  * Output: 
  * vertexNames = hw1:hw2:hw3:party1:party2:party3:party4:laundry:cook:eat:shop
  * vertex = hw1, edges = party4
  * vertex = hw2, edges = party4
  * vertex = hw3, edges = party4
  * vertex = party1, edges = party2
  * vertex = party2, edges = party3
  * vertex = party3, edges = party4
  * vertex = party4, edges = 
  * vertex = laundry, edges = party3
  * vertex = cook, edges = eat
  * vertex = eat, edges = 
  * vertex = shop, edges = cook
  * orderedNames = shop:cook:eat:laundry:party1:party2:party3:hw3:hw2:hw1:party4
  * Roots = hw1:hw2:hw3:party1:laundry:shop
  *****************************************************************************/
public class TopologicalSort1 {
    private int n;
    Vertex[] vertices;
    private boolean[] isVisited;
    
    //Constructor TopologicalSort used for reading in a graph from filename
    //and then creating a linked list of vertices from the given valid vertices
    public TopologicalSort1(String filename) { 
        In a = new In(filename);
        n = Integer.parseInt(a.readLine());
        vertices = new Vertex[n];
        isVisited = new boolean[n];
        for(int i = 0; i < n; i++) {
            isVisited[i] = false;
            Vertex v = new Vertex();
            v.name = a.readLine();
            vertices[i] = v;
        }
        String s = "";
        while((s = a.readLine()) != null) {
            if(s.trim().length() == 0) continue;
            String[] sa = s.trim().split("\\s+");               
            int v1 = Integer.parseInt(sa[0]);
            int v2 = Integer.parseInt(sa[1]);
            boolean isEndEdge = (v1 == -1) && (v2 == -1);
            boolean isValidEdge = (v1 >= 0 && v1 < n && v2 >= 0 && v2 < n);
            if(isEndEdge) break;
            if(!isValidEdge) continue;
            if(vertices[v1].edges == null) {
                VertexList edges = new VertexList();
                edges.target = v2;
                vertices[v1].edges = edges;
            }
            else {
                VertexList current = vertices[v1].edges;
                while(current.next != null) {
                    current = current.next;
                }
                current.next = new VertexList();
                current.next.target = v2;
            }
        }
    }
    
    
    //return the array of vertices in the graph
    public Vertex[] getVertices() {
        return vertices;
    }
    
    //return a linked list of vertices in topologically sorted order
    public VertexList getSortedVertices() {
        VertexList sortedVertices = null;
        if(vertices.length > 0) {
            sortedVertices = new VertexList();
            sortedVertices.target = -1;
            VertexList root = findRoots();
            sortedVertices = visit(root, sortedVertices);
        }
        return sortedVertices;
    } 
    
    
    //return the vertex names in the original order
    //with the string join inserted between each pair 
    public String vertexNames(String join) {
        String vert = " ";
        int i = 0;
        for(i = 0; i < n - 1; i++) {
            vert = vert + vertices[i].name + join;
        }
        if(i < n) {
            vert = vert + vertices[i].name;
        }
        return vert;
    }
    
    //return the vertex names in sorted order
    //with the string join inserted between each pair
    public String orderedNames(String join) {
        VertexList vl = getSortedVertices();
        return join(vl, join);
    }
  
    //Helper method to perform the condition where each of the vertices are 
    //visited and then once visited, the vertices are marked and the function
    //is conducted recursively 
    private VertexList visit(VertexList vl, VertexList sort) {
        while (vl != null) {
            Vertex v = vertices[vl.target];
            if (!isVisited[vl.target]) {
                isVisited[vl.target] = true;
                sort = visit(v.edges, sort);
                if(sort.target == -1) sort.target = vl.target;
                else {
                    VertexList head = new VertexList(); 
                    head.target = vl.target; 
                    head.next = sort;
                    sort = head;
                } 
            }
            vl = vl.next;
        }
        return sort;
    }
    
    //Helper method that returns a vertexList roots which returns the roots
    // or the vertices with no incoming edges. 
    private VertexList findRoots() {
        VertexList roots = new VertexList();
        roots.target = -1;
        for(int i = 0; i < n; i++) {
            boolean isFound = false;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                VertexList current = vertices[j].edges;
                while (current != null) {
                    if(current.target == i) {
                        isFound = true;
                        break;
                    }
                    current = current.next;
                }
                if(isFound) break;  
            }
            //We want to add the element to the end of the linked list roots
            if(!isFound) {
                VertexList current1 = roots;
                while (current1.next != null) {
                    current1 = current1.next;   
                }
                if (current1.target == -1) {
                    current1.target = i; 
                }
                else {
                    current1.next = new VertexList();
                    current1.next.target = i;
                }
            }
        }
        if(roots.target == -1) roots = null;
        return  roots;
    } 
    
    //Helper method for converting a linked list into a string with the 
    //String join inserted in between each vertex. 
    private String join(VertexList vl, String join) {
        String s = "";
        VertexList current = vl;
        while (current != null) {
            s += vertices[current.target].name;
            current = current.next;
            if (current != null) s += join;
        }  
        return s;
    }  
    
    //Main method to test and debugg each of the helper methods and variables
    //and to determine if the correct topological order was created. 
    public static void main (String[] args) {
        TopologicalSort1 t = new TopologicalSort1(args[0]);
        System.out.println("vertexNames = " + t.vertexNames(":"));
        for(Vertex v : t.getVertices()) {
            System.out.println("vertex = " + v.name + ", edges = " 
                                   + t.join(v.edges, ":"));
        }
        VertexList roots = t.findRoots();
        System.out.println("orderedNames = " + t.orderedNames(":")); 
        System.out.println("Roots = " + t.join(roots, ":")); 
    }
}