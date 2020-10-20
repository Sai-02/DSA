
class LinkedList<E> {

    // Class for Node
    static class Node<E> {
        E data;
        Node next;

        // Constructor for class Node
        Node(E data) {
            this.data = data;
            next = null;

        }

    }

    // To check the value to be inserted in head or not
    private int counter = 0;

    // Defining Head
    Node head;
    Node temp;

    // Method for adding values to LinkedList
    void add(E data) {
        if (counter == 0) {
            head = new Node(data);
            temp = head;
            counter++;
            return;
        }
        Node newNode = new Node(data);

        temp.next = newNode;
        temp = temp.next;
        counter++;

    }

    void printList() throws NullPointerException {
        if (head == null) {
            throw new NullPointerException();
        }
        Node printNode = head;
        while (printNode != null) {
            System.out.print(printNode.data + " ");
            printNode = printNode.next;
        }
        System.out.println();
    }

    // Method for checking if LinkedList is Empty
    boolean isEmpty() {
        if (head == null) {
            return true;

        }
        return false;
    }

    void remove() throws NullPointerException {
        if (head == null) {
            throw new NullPointerException();
        } else if (head.next == null) {
            head = null;
            counter--;

        } else {
            Node delete = head;
            Node prev = delete;
            while (delete.next != null) {
                prev = delete;
                delete = delete.next;

            }
            prev.next = null;
            temp = prev;
            counter--;
        }
    }

}