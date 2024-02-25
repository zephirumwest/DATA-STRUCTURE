final public class BSTSplit {
    public BST bstSmaller;
    public BST bstGreater;

    public BSTSplit() {
        bstSmaller = new BST();
        bstGreater = new BST();
    }

    public void split(BST bstIn, int val) {
        if (bstIn.root == null) {
            return;
        }

        BSTNode cur = bstIn.root;
        while (cur != null) {
            if (cur.key < val) {
                bstSmaller.insert(cur.key);
                cur = cur.right;
            } else if (cur.key > val) {
                bstGreater.insert(cur.key);
                cur = cur.left;
            } else {
                break;
            }
        }

        if (cur == null) {
            return;
        }

        BSTNode left = cur.left;
        while (left != null && left.key == val) {
            bstGreater.insert(left.key);
            left = left.left;
        }
        BSTNode right = cur.right;
        while (right != null && right.key == val) {
            bstGreater.insert(right.key);
            right = right.right;
        }

        if (left != null) {
            bstSmaller.root = left;
            cur.left = null;
        }

        if (right != null) {
            bstGreater.root = right;
            cur.right = null;
        }
    }
}
