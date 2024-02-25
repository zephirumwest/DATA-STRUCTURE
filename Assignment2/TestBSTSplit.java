public class TestBSTSplit {
    public static void main(String[] args) {
        // create a binary search tree
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // split the binary search tree
        BSTSplit splitter = new BSTSplit();
        splitter.split(bst, 5);

        // check if bstSmaller contains the correct nodes
        BST bstSmaller = splitter.bstSmaller;
        System.out.print("bstSmaller: ");
        inorderTraversal(bstSmaller.root);

        // check if bstGreater contains the correct nodes
        BST bstGreater = splitter.bstGreater;
        System.out.print("bstGreater: ");
        inorderTraversal(bstGreater.root);
    }

    private static void inorderTraversal(BSTNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.key + " ");
        inorderTraversal(node.right);
    }
}
