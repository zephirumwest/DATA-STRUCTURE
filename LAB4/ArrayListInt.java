public class ArrayListInt {
    private int[][] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayListInt() {
        elementData = new int[DEFAULT_CAPACITY][2];
        size = 0;
    }

    public void add(int[] element) {
        if (size == elementData.length) {
            increaseCapacity();
        }
        elementData[size++] = element;
    }

    public int[] get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elementData[index];
    }

    public int size() {
        return size;
    }

    private void increaseCapacity() {
        int newCapacity = elementData.length * 2;
        int[][] newElementData = new int[newCapacity][2];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }
}
