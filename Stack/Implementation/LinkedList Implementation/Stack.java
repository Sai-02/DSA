class Stack<E> {
    class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    void push(E data) {
        if (head == null) {
            head = new Node(data);

        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;

        }
    }

    E pop() throws Exception {
        if (head == null) {
            throw new Exception("Stack is empty");
        } else {
            E data = head.data;
            head = head.next;
            return data;
        }

    }

    E peek() throws Exception {
        if (head == null) {
            throw new Exception("Stack is empty");

        } else {
            return head.data;
        }
    }

    boolean empty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }
}