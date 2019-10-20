package MinBinHeap_A3;

public interface Heap_Interface {
  /*
    Interface: The BHEAP will provide this collection of operations:

    insert
      in: an EntryPair object, containing the priority and string, 
          assume no duplicate priorities will be inserted
      effect: inserts EntryPair object and adjusts for heap order if necessary
      return: void
    delMin
      in: nothing
  	  effect: removes the root element from the heap and adjusts heap order,
      if empty no operation
      return: void
    getMin
      in: nothing
      effect: no change to heap, returns highest priority object or
      null if heap is empty
      return: an element (an EntryPair object)
    size
      in: nothing
      effect: no change to heap, returns number of objects in heap
      return: integer 0 or greater
    build
      in: array of elements that need to be in the heap
      effect: from empty heap, adds all elements to heap and adjusts for 
      heap order
      return: void
      (assume for a build that the bheap will start empty)
  */

  // ADT operations
  void insert(EntryPair entry);
  void delMin();
  EntryPair getMin();
  int size();
  void build(EntryPair [] entries);
  EntryPair[] getHeap();
}