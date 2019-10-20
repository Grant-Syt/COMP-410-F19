package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;

	BST_Node(String data) {
		this.data = data;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	/*
	 * public boolean containsNode(String s){ return false; } public boolean
	 * insertNode(String s){ return false; } public boolean removeNode(String s){
	 * return false; } public BST_Node findMin(){ return left; } public BST_Node
	 * findMax(){ return right; } public int getHeight(){ return 0; }
	 */

	// --- end fill in these methods --------------------------------------

	public boolean containsNode(String s) {
		/* in: string 
		 * out: boolean, tree contains node with string 
		 * effect: n/a
		 */
		if (this.data.compareTo(s) == 0) {
			// found node
			return true;

			// recursive search for node
		} else if (this.data.compareTo(s) < 0) {
			if (this.right == null) {
				return false;
			} else {
				return this.right.containsNode(s);
			}
		} else {
			if (this.left == null) {
				return false;
			} else {
				return this.left.containsNode(s);
			}
		}
	}

	public boolean insertNode(String s) {
		/* in: string 
		 * out: boolean, insert successful 
		 * effect: insert node in tree
		 */
		if (this.data.compareTo(s) == 0) {
			// node already in tree
			return false;

			// recursive search and insert
		} else if (this.data.compareTo(s) < 0) {
			if (this.right == null) {
				this.right = new BST_Node(s);
				this.right.parent = this;
				return true;
			} else {
				return this.right.insertNode(s);
			}
		} else {
			if (this.left == null) {
				this.left = new BST_Node(s);
				this.left.parent = this;
				return true;
			} else {
				return this.left.insertNode(s);
			}
		}
	}

	public boolean removeNode(String s) {
		/* in: string 
		 * out: boolean, remove successful 
		 * effect: remove node in tree if it exists
		 */
		if (this.data.compareTo(s) == 0) {
			// node found
			if (this.parent == null) {
				// remove cases for root
				if (this.left == null && this.right == null) {
					return true; // handled in BST Class
				} else if (this.left == null) {
					this.data = this.right.data;
					this.right.removeNode(this.right.data);
					return true;
				} else if (this.right == null) {
					this.data = this.left.data;
					this.left.removeNode(this.left.data);
					return true;
				} else {
					BST_Node rMin = this.right.findMin();
					this.data = rMin.data;
					rMin.removeNode(rMin.data);
					return true;
				}
			} else {
				// remove cases for non-root nodes
				if (this.left == null && this.right == null) {
					if (this.parent.right == this) {
						this.parent.right = null;
						return true;
					} else {
						this.parent.left = null;
						return true;
					}
				} else if (this.left == null) {
					if (this.parent.right == this) {
						this.parent.right = this.right;
						this.right.parent = this.parent;
						return true;
					} else {
						this.parent.left = this.right;
						this.right.parent = this.parent;
						return true;
					}
				} else if (this.right == null) {
					if (this.parent.right == this) {
						this.parent.right = this.left;
						this.left.parent = this.parent;
						return true;
					} else {
						this.parent.left = this.left;
						this.left.parent = this.parent;
						return true;
					}
				} else {
					BST_Node rMin = this.right.findMin();
					this.data = rMin.data;
					rMin.removeNode(rMin.data);
					return true;
				}
			}

			// recursive search for node
		} else if (this.data.compareTo(s) < 0) {
			if (this.right == null) {
				return false;
			} else {
				return this.right.removeNode(s);
			}
		} else {
			if (this.left == null) {
				return false;
			} else {
				return this.left.removeNode(s);
			}
		}
	}

	public BST_Node findMin() {
		/* in: n/a
		 * out: min node in tree
		 * effect: n/a
		 */
		BST_Node min = this;
		while (min.left != null) {
			min = min.left;
		}
		return min;
	}

	public BST_Node findMax() {
		/* in: n/a
		 * out: max node in tree 
		 * effect: n/a
		 */
		BST_Node max = this;
		while (max.right != null) {
			max = max.right;
		}
		return max;
	}

	public int getHeight() {	
		/* in: n/a
		 * out: int, height of tree
		 * effect: n/a
		 */
		int lChild = 0;
		int rChild = 0;

		if (this.left != null) { lChild = this.left.getHeight() + 1; }
		if (this.right != null) { rChild = this.right.getHeight() + 1; }

		return Math.max(lChild, rChild);
	}

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}