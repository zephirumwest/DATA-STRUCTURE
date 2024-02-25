public class DList {
    public DNode first;
    public DNode last;
    
    public DList() {
        this.first = null;
        this.last = null;
    }
    
    public void insertAtFront(int x) {
        DNode node = new DNode(x);
        if (this.first == null) {
            this.first = node;
            this.last = node;
        } else {
            node.next = this.first;
            this.first.prev = node;
            this.first = node;
        }
    }
    
    public void insertAtEnd(int x) {
        DNode node = new DNode(x);
        if (this.first == null) {
            this.first = node;
            this.last = node;
        } else {
            node.prev = this.last;
            this.last.next = node;
            this.last = node;
        }
    }
    
    public int deleteFromFront() {
        if (this.first == null) {
            return -1;
        }
        int data = this.first.data;
        if (this.first == this.last) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
            this.first.prev = null;
        }
        return data;
    }
    
    public int deleteFromEnd() {
        if (this.last == null) {
            return -1;
        }
        int data = this.last.data;
        if (this.first == this.last) {
            this.first = null;
            this.last = null;
        } else {
            this.last = this.last.prev;
            this.last.next = null;
        }
        return data;
    }
    
    public DIter getIter() {
        return new DIter(this, this.first);
    }
}