/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	
	Node sentinel; // this will be the entry point to your linked list (the head)
	private int size;
	
	public LinkedListImpl() {// this constructor is needed for testing purposes. Please don't modify!
		sentinel = new Node(0); // Note that the root's data is not a true part of your data set!
		size = 0;
	}

	// implement all methods in interface, and include the getRoot method we made
	// for testing purposes.
	// Feel free to implement private helper methods!

	@Override
	public boolean insert(double elt, int index) {
		// description in interface
		if (index > this.size() || index < 0) {
			// out of bounds
			return false;
		} else {
			// find adjacent nodes and change pointers
			Node inputNode = new Node(elt);
			if (this.size() == 0) {
				// only for first node in empty list
				sentinel.next = inputNode;
				sentinel.prev = inputNode;
				inputNode.next = sentinel;
				inputNode.prev = sentinel;
			} else {
				Node beforeNode = sentinel;
				for (int i = 0; i < index; i++) {
					beforeNode = beforeNode.next;
				}
				Node afterNode = beforeNode.next;
				afterNode.prev = inputNode;
				inputNode.next = afterNode;
				beforeNode.next = inputNode;
				inputNode.prev = beforeNode;
			}
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(int index) {
		// description in interface
		if (index > this.size() || index < 0) {
			// out of bounds
			return false;
		} else {
			// find adjacent nodes and change pointers
			if (this.size() == 1) {
				// only for last node
				this.clear();
			} else {
				Node beforeNode = sentinel;
				for (int i = 0; i < index; i++) {
					beforeNode = beforeNode.next;
				}
				Node afterNode = beforeNode.next.next;
				afterNode.prev = beforeNode;
				beforeNode.next = afterNode;
			}
		}
		size--;
		return true;
	}

	@Override
	public double get(int index) {
		// description in interface
		if (index + 1 > this.size() || index < 0) {
			// out of bounds
			return Double.NaN;
		} else {
			// find node
			Node curr = sentinel.next;
			for (int i = 0; i < index; i++) {
				curr = curr.next;
			}
			return curr.getData();
		}
	}

	@Override
	public int size() {
		// description in interface
		return size;
	}

	@Override
	public boolean isEmpty() {
		// description in interface
		return this.size() == 0;
	}

	@Override
	public void clear() {
		// description in interface
		size = 0;
		sentinel.next = null;
		sentinel.prev = null;
	}

	public Node getRoot() { // leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

}