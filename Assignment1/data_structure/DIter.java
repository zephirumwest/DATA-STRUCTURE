public class DIter {
    public DNode cur;
    private DList list;
    
    public DIter(DList list, DNode cur) {
        this.list = list;
        this.cur = cur;
    }
    
    public boolean atEnd() {
        return cur == null;
    }
    
    public int getValue() {
        if (cur == null) {
            return -1;
        }
        return cur.data;
    }
    
    public boolean setValue(int x) {
        if (cur == null) {
            return false;
        }
        cur.data = x;
        return true;
    }
    
    public int delete() {
        if (cur == null) {
            return -1;
        }
        int deletedData = cur.data;
        DNode prevNode = cur.prev;
        DNode nextNode = cur.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            list.first = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            list.last = prevNode;
        }
        cur = nextNode;
        return deletedData;
    }
    
    public void insertBefore(int x) {
        DNode newNode = new DNode(x);
        newNode.data = x;
        newNode.prev = cur.prev;
        newNode.next = cur;
        if (cur.prev != null) {
            cur.prev.next = newNode;
        } else {
            list.first = newNode;
        }
        cur.prev = newNode;
    }
    
    public boolean insertAfter(int x) {
        if (cur == null) {
            return false;
        }
        DNode newNode = new DNode(x);
        newNode.data = x;
        newNode.prev = cur;
        newNode.next = cur.next;
        if (cur.next != null) {
            cur.next.prev = newNode;
        } else {
            list.last = newNode;
        }
        cur.next = newNode;
        return true;
    }
    
    public void prev() {
        if (cur != null) {
            cur = cur.prev;
        }
    }
    
    public void next() {
        if (cur != null) {
            cur = cur.next;
        }
    }
}
