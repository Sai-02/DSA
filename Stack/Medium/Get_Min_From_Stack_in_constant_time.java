// =============================================================
// 
// Question-Design a stack that performs getMinimum in O(1)
// 
// ===============================================================

public class Get_Min_From_Stack_in_constant_time {
    public static void main(String[] args) throws Exception {
        SpecialStack sp = new SpecialStack();
        sp.push(100);
        System.out.println(sp.getMin());
        sp.push(50);
        System.out.println(sp.getMin());
        sp.push(0);
        System.out.println(sp.getMin());
        sp.pop();
        System.out.println(sp.getMin());
        
    }

}

class SpecialStack {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;

        }
    }

    Node head, minHead;

    void push(int data) {
        if (head == null) {
            head = new Node(data);
            minHead = new Node(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            if (data > minHead.data) {
                data = minHead.data;
            }
            Node newMinNode = new Node(data);
            newMinNode.next = minHead;
            minHead = newMinNode;

        }
    }

    int peek() throws Exception {
        if (head == null) {
            throw new Exception("Stack Underflow");

        }
        return head.data;
    }

    int pop() throws Exception {
        if (head == null) {
            throw new Exception("Stack Underflow");
        }
        int data = head.data;
        head = head.next;
        minHead = minHead.next;
        return data;
    }

    int getMin() throws Exception {
        if (head == null) {
            throw new Exception("Stack Underflow");
        }
        return minHead.data;
    }

    boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

}