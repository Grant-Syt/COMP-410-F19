package LinkedList_A1;

public class LinkedListPlayground {

  public static void main(String[] args) { 
    /*
     here you can instantiate your LinkedList and play around with it to check
     correctness. We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. This is for your use in testing your implementation.
      */
    test1();
    test2();

  }
  
  public static void test1(){
    // example test cases
    LinkedListImpl L= new LinkedListImpl();
    System.out.println(L.isEmpty());
    printList(L);
    L.clear();
    System.out.println(L.isEmpty());
    printList(L);
    System.out.println(L.sentinel.toString());
    L.insert(3.3,0);
    System.out.println(L.isEmpty());
    printList(L);
    System.out.println(L.sentinel.next.toString());
    L.insert(3.4, 0);
    L.insert(3.5, 0);
    L.insert(3.67, 1);
    L.insert(3.357, 0);
    L.insert(3.333, 4);
    System.out.println(L.size());
    printList(L);
    L.remove(3);
    System.out.println(L.size());
    printList(L);
    L.clear();
    L.insert(3.4, 0);
    L.insert(3.5, 0);
    L.insert(3.67, 1);
    L.insert(3.357, 0);
    L.insert(3.333, 3);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
  }

  public static void test2(){
    // example test cases
    LinkedListImpl L= new LinkedListImpl();
    L.insert(3.4,0);
    L.insert(3.5,1);
    L.insert(3.67,2);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
    
    System.out.println("");
    System.out.println("My Tests ;)");
    L.clear();
    L.insert(0,0);
    L.insert(1,1);
    L.insert(2,2);
    L.insert(3,3);
    L.insert(4,4);
    L.insert(5,5);
    printList(L);
    boolean test1 = L.insert(500, 10);
    System.out.println(test1);
    boolean test2 = L.insert(500, -1);
    System.out.println(test2);
    boolean test3 = L.remove(10);
    System.out.println(test3);
    boolean test4 = L.remove(-1);
    System.out.println(test4);
    double test5 = L.get(10);
    System.out.println(test5);
    double test6 = L.get(-1);
    System.out.println(test6);
    System.out.println(L.size());
    System.out.println(L.isEmpty());
    printList(L);
    L.clear();
    System.out.println(L.size());
    printList(L);
    System.out.println(L.sentinel.toString());
    System.out.println(L.sentinel.next);
  }
  
  public static void printList(LinkedListImpl L){ 
    //note that this is a good example of how to iterate through your linked list
    // since we know how many elements are in the list we can use a for loop
    // and not worry about checking the next field to see if we hit the end sentinel
    Node curr=L.sentinel.next; // the first data node in the list is the one after sentinel. 
    System.out.print("sentinel");
    for(int i=0; i<L.size(); i++) { 
      System.out.print(" --> " + curr.data);
      curr=curr.next;
    }
    System.out.println();
  }
}