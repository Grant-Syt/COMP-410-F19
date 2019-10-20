package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST(){ size=0; root=null; }

	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){ return root; }

	@Override
	public boolean insert(String s) {
		// description in interface
		if (this.size() == 0) {
			root = new BST_Node(s);
			size++;
			return true;
		} else {
			boolean success = this.root.insertNode(s);
			if (success) {
				size++;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean remove(String s) {
		// description in interface
		if (this.size() == 0) {
			return false;
		} else if (this.size == 1) {
			boolean success = this.root.removeNode(s);
			if (success) {
				root = null;
				size--;
				return true;
			} else {
				return false;
			}
		} else {
			boolean success = this.root.removeNode(s);
			if (success) {
				size--;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public String findMin() {
		// description in interface
		if (this.size() == 0) {
			return null;
		} else {
			return this.root.findMin().data;
		}
	}

	@Override
	public String findMax() {
		// description in interface
		if (this.size() == 0) {
			return null;
		} else {
			return this.root.findMax().data;
		}
	}

	@Override
	public boolean empty() {
		// description in interface
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		// description in interface
		if (this.size() == 0) {
			return false;
		} else {
			return this.root.containsNode(s);
		}
	}

	@Override
	public int size() {
		// description in interface
		return size;
	}

	@Override
	public int height() {
		// description in interface
		if (this.size() == 0) {
			return -1;
		} else {
			return this.root.getHeight();
		}
	}

}