public class Main {
    public static void main(String[] args) {
        DList list = new DList();
        DIter iter = list.getIter();

        // 리스트가 비어있는 경우
        System.out.println(list.deleteFromFront());  // -1
        System.out.println(list.deleteFromEnd());    // -1

        // 리스트에 값 추가
        list.insertAtFront(1);
        list.insertAtEnd(3);
        list.insertAtFront(2);
        list.insertAtEnd(4);

        // 리스트 전체 출력
        iter = list.getIter();
        while (!iter.atEnd()) {
            System.out.print(iter.getValue() + " ");
            iter.next();
        }
        System.out.println();

        // 첫 번째 노드 삭제
        list.deleteFromFront();
        iter = list.getIter();
        while (!iter.atEnd()) {
            System.out.print(iter.getValue() + " ");
            iter.next();
        }
        System.out.println();

        // 마지막 노드 삭제
        list.deleteFromEnd();
        iter = list.getIter();
        while (!iter.atEnd()) {
            System.out.print(iter.getValue() + " ");
            iter.next();
        }
        System.out.println();

        // 리스트에 값 추가
        list.insertAtFront(-1);
        list.insertAtEnd(5);

        // 노드 값 변경
        iter = list.getIter();
        while (!iter.atEnd()) {
            if (iter.getValue() == 3) {
                iter.setValue(33);
            }
            iter.next();
        }
        iter = list.getIter();
        while (!iter.atEnd()) {
            System.out.print(iter.getValue() + " ");
            iter.next();
        }
        System.out.println();

        // 노드 삭제
        iter = list.getIter();
        while (!iter.atEnd()) {
            if (iter.getValue() == 2) {
                iter.delete();
            } else {
                iter.next();
            }
        }
        iter = list.getIter();
        while (!iter.atEnd()) {
            System.out.print(iter.getValue() + " ");
            iter.next();
        }
        System.out.println();

        // 이전 노드로 이동
        iter = list.getIter();
        iter.next();
        iter.next();
        iter.prev();
        System.out.println(iter.getValue());  // 33

        // 이전 노드로 이동 (첫 번째 노드)
        iter.prev();
        System.out.println(iter.getValue());  // -1

        // 다음 노드로 이동 (끝 노드)
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        System.out.println(iter.getValue());  // -1

        // 현재 노드에 값 추가
        iter.insertBefore(10);
        iter.insertBefore(20);
        iter.prev();
        iter.insertBefore(30);
        iter = list.getIter();
        while (!iter.atEnd()) {
            System.out.print(iter.getValue() + " ");
            iter.next();
        }
        System.out.println();

        // 다음 노드에 값 추가
        iter = list.getIter();
        iter.next();
        iter.next();
        iter.insertAfter(40);
        iter.insertAfter(50);
        iter.insertAfter(60);
        iter = list.getIter();
        while (!iter.atEnd()) {
            System.out.print(iter.getValue() + " ");
            iter.next();
        }
        System.out.println();
    }
}