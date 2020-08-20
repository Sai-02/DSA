class LinkedList {

    public Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;

        }
    }

    // Adding values to linkedlist
    public LinkedList add(LinkedList list, int newData) {
        Node newNode = new Node(newData);
        if (list.head == null) {
            list.head = newNode;

        } else {
            Node t = list.head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = newNode;
        }
        return list;
    }

    // Method to print linkedlist
    public static void printList(LinkedList list) {
        Node t = list.head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    // Method to get size of linkedlist
    public static int size(LinkedList list) {
        int n = 0;
        Node t = list.head;
        while (t != null) {
            t = t.next;
            n++;
        }

        return n;
    }

    // Method to return index of a key
    public static int indexOf(LinkedList list, int key) {
        int index = 0;
        Node t = list.head;
        while (t != null) {
            if (t.data == key) {
                return index;

            }
            t = t.next;
            index++;
        }

        return -1;
    }

    // Method to delete a key from list
    public static LinkedList remove(LinkedList list, int key) {
        if (list.head.data == key) {
            list.head = list.head.next;
            return list;
        }
        Node t = list.head;
        while (t.next != null) {
            if (t.next.data == key) {
                t.next = t.next.next;
                break;
            }
            t = t.next;
        }

        return list;
    }

    // Setter
    public static LinkedList set(LinkedList list, int index, int value) {
        Node t = list.head;
        int i = 0;
        while (t != null) {
            if (i == index) {
                t.data = value;
                return list;
            }
            t = t.next;
            i++;

        }
        return list;
    }

    // Getter
    public static int get(LinkedList list, int index) {
        Node t = list.head;
        int i = 0;
        while (t != null) {
            if (i == index) {
                return t.data;
            }
            t = t.next;
            i++;

        }
        return -1;

    }

    // Method to reverse LinkedList
    public static LinkedList reverse(LinkedList list) {
        Node t = list.head;
        while (t.next != null) {
            Node temp = new Node((t.next).data);
            temp.next = list.head;
            list.head = temp;
            t.next = (t.next).next;
        }
        return list;
    }
}
