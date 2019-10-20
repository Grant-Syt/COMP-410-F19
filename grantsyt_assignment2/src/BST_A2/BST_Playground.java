package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/
  
  public static void main(String[]args){

   // you should test your BST implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node
	  
	  BST a = new BST();
	  a.insert("d");
	  a.insert("b");
	  a.remove("b");
	  a.insert("b");
	  a.insert("e");
	  System.out.println("Test 1: ");
	  printInOrder(a.getRoot());
	  System.out.println("\n");
	  
	  BST b = new BST();
	  b.insert("a");
	  b.insert("b");
	  System.out.println("Test 2: ");
	  printInOrder(b.getRoot());
	  System.out.println(b.findMax());
	  System.out.println(b.findMin());
	  System.out.println("\n");
	 
	  System.out.println("Test 3: ");
	  BST c = new BST();
	  c.insert("0");
	  c.insert("C");
	  c.insert("A");
	  c.insert("B");
	  c.insert("E");
	  c.insert("D");
	  c.remove("C");
	  c.remove("A");
	  c.remove("D");
	  System.out.println(c.height());
	  printInOrder(c.getRoot());
	  boolean success = c.remove("B");
	  System.out.println(success);
	  printInOrder(c.getRoot());
	  c.remove("E");
	  printInOrder(c.getRoot());
	  System.out.println("\n");
	  
	  System.out.println("Test 4: ");
	  BST d = new BST();
	  d.insert("a");
	  d.insert("b");
	  d.insert("c");
	  d.insert("d");
	  d.insert("e");
	  d.insert("f");
	  d.insert("g");
	  d.insert("h");
	  d.insert("i");
	  d.insert("j");
	  printInOrder(d.getRoot());
	  System.out.println("\n");
      System.out.println("Height: ");
	  System.out.println(d.height());
	  System.out.println("\n");
	  
	  
  }

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  static void printInOrder(BST_Node root){
  //will print your current tree In-Order
  if(root!=null){
    printInOrder(root.getLeft());
    System.out.print(root.getData() + " ");
    printInOrder(root.getRight());
  }
  }
}