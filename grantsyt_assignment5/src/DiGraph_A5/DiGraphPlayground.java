package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
      exTest();
    }
  
    public static void exTest(){
//      DiGraph d = new DiGraph();
//      d.addNode(1, "f");
//      d.addNode(3, "s");
//      d.addNode(7, "t");
//      d.addNode(0, "fo");
//      d.addNode(4, "fi");
//      d.addNode(6, "si");
//      d.addEdge(0, "f", "s", 0, null);
//      d.addEdge(1, "f", "si", 0, null);
//      d.addEdge(2, "s", "t", 0, null);
//      d.addEdge(3, "fo", "fi", 0, null);
//      d.addEdge(4, "fi", "si", 0, null);
//      System.out.println("numEdges: "+d.numEdges());
//      System.out.println("numNodes: "+d.numNodes());
      
      
      
      DiGraph a = new DiGraph();
      a.addNode(0, "0");
      a.addNode(1, "1");
      a.addNode(2, "2");
      a.addNode(3, "3");
      a.addNode(4, "4");
      a.addNode(5, "5");
      a.addNode(6, "6");
      System.out.println(a.numNodes());
      System.out.println(a.numEdges());
      a.addEdge(0, "0", "5", 3, null);
      a.addEdge(1, "3", "2", 6, null);
      a.addEdge(2, "4", "0", 1, null);
      a.addEdge(3, "4", "5", 2, null);
      a.addEdge(4, "6", "1", 4, null);
      System.out.println(a.numNodes());
      System.out.println(a.numEdges());
      ShortestPathInfo[] solutiona = a.shortestPath("0");
      for (ShortestPathInfo n : solutiona) {
    	  System.out.println(n.toString());
      }
    }
}