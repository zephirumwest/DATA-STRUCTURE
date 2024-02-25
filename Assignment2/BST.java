final public class BST {
	public BSTNode root;

	public BST() {
		root = null;
	}

	public void insert(int key) {
		if(root == null) {
			root = new BSTNode(key);
			return;
		}
		BSTNode cur = root;
		while(cur != null) {
			if(cur.key > key) {
				if(cur.left == null) {
					cur.left = new BSTNode(key);
					return;
				}
				cur = cur.left;
			} else if (cur.key < key) {
				if(cur.right == null) {
					cur.right = new BSTNode(key);
					return;
				}
				cur = cur.right;
			} else {
				return;
			}
		}
	}
}

