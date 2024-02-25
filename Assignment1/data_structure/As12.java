import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class As12 {

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    static Node add(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new Node(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }

        return dummy.next;
    }

    static Node multiply(Node l1, Node l2) {
        Node dummy = new Node(0);

        while (l1 != null) {
            Node cur = dummy;
            int carry = 0;

            for (int i = 0; i < l1.val; i++) {
                cur = add(cur, l2);
            }

            for (int i = 0; i < l1.val; i++) {
                cur = cur.next;
            }

            cur.val += carry;

            while (cur.next != null && cur.val > 9) {
                cur.val -= 10;
                cur.next.val += 1;
                cur = cur.next;
            }

            if (cur.val > 9) {
                cur.val -= 10;
                cur.next = new Node(1);
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt");

        String num1 = br.readLine();
        String op = br.readLine();
        String num2 = br.readLine();

        Node l1 = null;
        Node l2 = null;

        for (int i = num1.length() - 1; i >= 0; i--) {
            Node node = new Node(num1.charAt(i) - '0');
            node.next = l1;
            l1 = node;
        }

        for (int i = num2.length() - 1; i >= 0; i--) {
            Node node = new Node(num2.charAt(i) - '0');
            node.next = l2;
            l2 = node;
        }

        Node result = null;

        if (op.equals("plus")) {
            result = add(l1, l2);
        } else if (op.equals("times")) {
            result = multiply(l1, l2);
        }

        while (result != null && result.val == 0) {
            result = result.next;
        }

        while (result != null) {
            fw.write(String.valueOf(result.val));
            result = result.next;
        }

        br.close();
        fw.close();
    }
}
