package MinBinHeap_A3;

import java.lang.Math;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; //load this array
	private int size;
	private static final int arraySize = 10000;
	//Everything in the array will initially 
	//be null. This is ok! Just build out 
	//from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000);
		size = 0;
		//0th will be unused for simplicity
		//of child/parent computations...
		//the book/animation page both do this.
	}

	//Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() { 
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		// description in interface
		if (size + 1 <= arraySize) {
			int hole = size + 1;
			while ( hole > 1 && 
					entry.getPriority() < 
					array[(int) Math.floor(hole / 2)].getPriority()){
				array[hole] = array[(int) Math.floor(hole / 2)];
				array[(int) Math.floor(hole / 2)] = null;
				hole = (int) Math.floor(hole / 2);
			}
			array[hole] = entry;
			size++;
		} else {
			throw new IndexOutOfBoundsException(
					"Attempted to insert more EntryPairs than MinBinHeap can hold");
		}
	}

	@Override
	public void delMin() {
		// description in interface
		if (size > 0) {
			if (size == 1) {
				array[1] = null;
				size--;
			} else {
				EntryPair temp = array[size];
				array[size] = null;
				size--;
				bubbleDown(1, temp);
			}
		}
	}

	@Override
	public EntryPair getMin() {
		// description in interface
		if (size == 0) {
			return null;
		} else {
			return array[1];
		}
	}

	@Override
	public int size() {
		// description in interface
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		// description in interface
		for (int i = 0; i < entries.length; i++) {
			array[i + 1] = entries[i];
			size++;
		}
		int lastParentPos = (int) Math.floor(size/2);
		for (int i = lastParentPos; i > 0; i--) {
			bubbleDown(i, array[i]);
		}
	}

	// helper methods

	private void bubbleDown(int hole, EntryPair temp) {
		/* in: location in array that becomes hole and EntryPair to eventually insert
		 * effect: makes hole, swaps down until heap order is achieved, and inserts temp
		 * out: n/a
		 */
		array[hole] = null;
		boolean keepGoing = true;
		while (keepGoing) {
			if (hole*2 < arraySize && (hole*2) + 1 <= arraySize) {
				if (array[hole*2] == null && array[(hole*2) + 1] == null) {
					keepGoing = false;
				} else if (array[hole*2] != null && array[(hole*2) + 1] != null) {
					if (array[hole*2].getPriority() > temp.getPriority() && 
							array[(hole*2) + 1].getPriority() > temp.getPriority()) {
						keepGoing = false;
					} else if (array[hole*2].getPriority() < array[(hole*2) + 1].getPriority()) {
						array[hole] = array[hole*2];
						array[hole*2] = null;
						hole = hole*2;
					} else {
						array[hole] = array[(hole*2) + 1];
						array[(hole*2) + 1] = null;
						hole = (hole*2) + 1;
					}
				} else if (array[hole*2] != null) {
					if (array[hole*2].getPriority() > temp.getPriority()) {
						keepGoing = false;
					} else {
						array[hole] = array[hole*2];
						array[hole*2] = null;
						hole = hole*2;
					}
				} else {
					if (array[(hole*2) + 1].getPriority() > temp.getPriority()) {
						keepGoing = false;
					} else {
						array[hole] = array[(hole*2) + 1];
						array[(hole*2) + 1] = null;
						hole = (hole*2) + 1;
					}
				}
			} else {
				if (hole*2 == arraySize) {
					if (array[hole*2].getPriority() > temp.getPriority()) {
						keepGoing = false;
					} else {
						array[hole] = array[hole*2];
						array[hole*2] = null;
						hole = hole*2;
						keepGoing = false;
					}
				} else {
					// both children > arraySize
					keepGoing = false;
				}
			}
		}
		array[hole] = temp;
	}
}