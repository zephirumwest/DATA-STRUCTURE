public class Node {
    public boolean red;
    public int key;
    public String payload;
    public Node parent;
    public Node left, right;

    public Node(boolean red, int key, String payload, Node parent) {
        this.red = red;
        this.key = key;
        this.payload = payload;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}