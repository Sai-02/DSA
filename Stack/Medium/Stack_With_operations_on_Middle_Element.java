// ================================================================
// 
// Question: Design a stack with operations on middle element
// 
// =================================================================
public class Stack_With_operations_on_Middle_Element {

    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
        Stack<Integer> st = new Stack<>();
        st.push(1);
        System.out.println(st.findMiddle());
        st.push(2);
        System.out.println(st.findMiddle());
        st.push(3);
        System.out.println(st.findMiddle());
        st.push(4);

        System.out.println(st.findMiddle());
        st.push(5);
        System.out.println(st.findMiddle());
        st.pop();
        System.out.println(st.findMiddle());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        while (!st.isEmpty()) {
            System.out.println(st.deleteMiddle());

        }

    }
}

class Stack<E> {
    private class Node {
        E data;
        Node next;
        Node prev;

        Node(E data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    int count;
    private Node head, middleNode;

    Stack() {
        count = 0;
    }

    void push(E data) {
        count++;
        if (head == null) {
            head = new Node(data);
            middleNode = head;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        if (count == 1) {
            middleNode = head;
        } else if (count % 2 != 0) {
            middleNode = middleNode.prev;
        }
    }

    E pop() throws Exception {
        if (head == null) {
            throw new Exception("Stack Underflow");
        } else {
            E data = head.data;
            head = head.next;
            head.prev = null;
            count--;
            if (count % 2 == 0) {
                middleNode = middleNode.next;
            }
            return data;

        }

    }

    E peek() throws Exception {
        if (head == null) {
            throw new Exception("Stack Underflow");
        } else {
            return head.data;
        }
    }

    boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    E findMiddle() throws Exception {
        if (count == 0) {
            throw new Exception("Stack Underflow");
        }
        return middleNode.data;

    }

    E deleteMiddle() throws Exception {
        if (count == 0) {
            throw new Exception("Stack Underflow");

        }
        if (count == 1) {
            count--;
            E data = middleNode.data;
            head = null;
            middleNode = null;
            return data;
        }
        if (count == 2) {
            count--;
            E data = middleNode.data;
            // middleNode.prev.next = null;
            head = head.next;
            middleNode = head;
            return data;

        }

        E data = middleNode.data;

        Node next = middleNode.next;
        Node prev = middleNode.prev;
        middleNode.prev.next = next;
        middleNode.next.prev = prev;
        if (count % 2 == 0) {

            middleNode = next;
        } else {
            middleNode = prev;
        }
        count--;
        return data;
    }
}