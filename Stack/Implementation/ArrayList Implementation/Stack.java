import java.util.ArrayList;

class Stack<E> {
    ArrayList<E> arr = new ArrayList<>(100);
    private int count = -1;

    void push(E data) throws Exception {
        if (count == 99) {
            throw new Exception("Stack Overflow");
        }
        count++;
        arr.add(data);
    }

    E peek() throws Exception {
        if (count == -1) {
            throw new Exception("Stack Underflow!!");
        }
        return arr.get(count);
    }

    E pop() throws Exception {
        if (count == -1) {
            throw new Exception("Stack Underflow");
        }
        return arr.get(count--);
    }

    boolean isEmpty() {
        if (count == -1) {
            return true;
        } else {
            return false;
        }

    }

    boolean empty() {
        if (count == -1) {
            return true;
        } else {
            return false;
        }
    }

}