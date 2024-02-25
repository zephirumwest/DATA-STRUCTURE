public class RBT {
    public Node root;

    public RBT() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean hasLeftChild(Node node) {
        return node.left != null;
    }

    public boolean hasRightChild(Node node) {
        return node.right != null;
    }

    public boolean insert(int key, String payload) {
        if (root == null) {
            root = new Node(false, key, payload, null);
            return true;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            if (key == current.key) {
                return false; // Key already exists in the tree
            }

            parent = current;
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        Node newNode = new Node(true, key, payload, parent);

        if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        fixInsert(newNode);
        return true;
    }

    private void fixInsert(Node node) {
        while (node.parent != null && node.parent.red) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;

                if (uncle != null && uncle.red) {
                    node.parent.red = false;
                    uncle.red = false;
                    node.parent.parent.red = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }

                    node.parent.red = false;
                    node.parent.parent.red = true;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;

                if (uncle != null && uncle.red) {
                    node.parent.red = false;
                    uncle.red = false;
                    node.parent.parent.red = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }

                    node.parent.red = false;
                    node.parent.parent.red = true;
                    rotateLeft(node.parent.parent);
                }
            }
        }

        root.red = false;
    }

    private void rotateLeft(Node node) {
        Node child = node.right;
        node.right = child.left;

        if (child.left != null) {
            child.left.parent = node;
        }

        child.parent = node.parent;

        if (node.parent == null) {
            root = child;
        } else if (node == node.parent.left) {
            node.parent.left = child;
        } else {
            node.parent.right = child;
        }

        child.left = node;
        node.parent = child;
    }

    private void rotateRight(Node node) {
        Node child = node.left;
        node.left = child.right;

        if (child.right != null) {
            child.right.parent = node;
        }

        child.parent = node.parent;

        if (node.parent == null) {
            root = child;
        } else if (node == node.parent.right) {
            node.parent.right = child;
        } else {
            node.parent.left = child;
        }

        child.right = node;
        node.parent = child;
    }

    public boolean delete(int key) {
        Node node = searchNode(key);
    
        if (node == null) {
            return false; // Key does not exist in the tree
        }
    
        Node child;
        if (node.left == null || node.right == null) {
            child = node;
        } else {
            child = successor(node);
        }
    
        Node parent = child.parent;
    
        if (child.left != null) {
            node = child.left;
        } else {
            node = child.right;
        }
    
        if (node != null) {
            node.parent = parent;
        }
    
        if (parent == null) {
            root = node;
        } else if (child == parent.left) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    
        if (child != null && node != null) {
            child.key = node.key;
            child.payload = node.payload;
        }
    
        if (child == null || !child.red) {
            fixDelete(node, parent);
        }
    
        return true;
    }    

    private void fixDelete(Node node, Node parent) {
        while (node != root && (node == null || !node.red)) {
            if (node == parent.left) {
                Node sibling = parent.right;

                if (sibling.red) {
                    sibling.red = false;
                    parent.red = true;
                    rotateLeft(parent);
                    sibling = parent.right;
                }

                if ((sibling.left == null || !sibling.left.red) &&
                        (sibling.right == null || !sibling.right.red)) {
                    sibling.red = true;
                    node = parent;
                    parent = node.parent;
                } else {
                    if (sibling.right == null || !sibling.right.red) {
                        if (sibling.left != null) {
                            sibling.left.red = false;
                        }

                        sibling.red = true;
                        rotateRight(sibling);
                        sibling = parent.right;
                    }

                    sibling.red = parent.red;
                    parent.red = false;
                    sibling.right.red = false;
                    rotateLeft(parent);
                    node = root;
                    break;
                }
            } else {
                Node sibling = parent.left;

                if (sibling.red) {
                    sibling.red = false;
                    parent.red = true;
                    rotateRight(parent);
                    sibling = parent.left;
                }

                if ((sibling.right == null || !sibling.right.red) &&
                        (sibling.left == null || !sibling.left.red)) {
                    sibling.red = true;
                    node = parent;
                    parent = node.parent;
                } else {
                    if (sibling.left == null || !sibling.left.red) {
                        if (sibling.right != null) {
                            sibling.right.red = false;
                        }

                        sibling.red = true;
                        rotateLeft(sibling);
                        sibling = parent.left;
                    }

                    sibling.red = parent.red;
                    parent.red = false;
                    sibling.left.red = false;
                    rotateRight(parent);
                    node = root;
                    break;
                }
            }
        }

        if (node != null) {
            node.red = false;
        }
    }

    public String query(int key) {
        Node node = searchNode(key);
        if (node != null) {
            return node.payload;
        }
        return null;
    }

    private Node searchNode(int key) {
        Node current = root;

        while (current != null) {
            if (key == current.key) {
                return current;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    private Node successor(Node node) {
        Node current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
