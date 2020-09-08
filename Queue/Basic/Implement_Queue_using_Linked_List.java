
/*
 * Implement a Queue using Linked List. A Query Q is of 2 Types (i) 1 x (a query
 * of this type means pushing 'x' into the queue) (ii) 2 (a query of this type
 * means to pop an element from the queue and print the poped element)
 * 
 * Example 1:
 * 
 * Input: Q = 5 Queries = 1 2 1 3 2 1 4 2 Output: 2 3 Explanation: n the first
 * testcase 1 2 the queue will be {2} 1 3 the queue will be {2 3} 2 poped
 * element will be 2 the queue will be {3} 1 4 the queue will be {3 4} 2 poped
 * element will be 3.
 * 
 * Example 2:
 * 
 * Input: Q = 4 Queries = 1 2 2 2 1 3 Output: 2 -1 Explanation: In the second
 * testcase 1 2 the queue will be {2} 2 poped element will be {2} then the queue
 * will be empty. 2 the queue is empty and hence -1 1 3 the queue will be {3}.
 * Your Task: Complete the function push() which takes an integer as input
 * parameter and pop() which will remove and return an element(-1 if queue is
 * empty).
 * 
 * Expected Time Complexity: O(1). Expected Auxiliary Space: O(1).
 */

// { Driver Code Starts
import java.util.*;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int a) {
        data = a;
        next = null;
    }
}

class GfG1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyQueue1 obj = new MyQueue1();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();

                    obj.push(a);

                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

// } Driver Code Ends

/*
 * The structure of the node of the queue is class QueueNode { int data;
 * QueueNode next; QueueNode(int a) { data = a; next = null; } }
 */

class MyQueue1 {
    QueueNode front, rear;

    // This function should add an item at
    // rear
    void push(int a) {
        if (rear == null) {
            rear = new QueueNode(a);
            front = rear;
            return;
        }
        QueueNode temp = new QueueNode(a);
        front.next = temp;
        front = front.next;

    }

    // This function should remove front
    // item from queue and should return
    // the removed item.
    int pop() {
        if (rear == null) {
            return -1;
        }
        int k = rear.data;
        rear = rear.next;
        return k;

    }
}
