
/*
 * mplement a Stack using two queues q1 and q2.
 * 
 * Example 1:
 * 
 * Input: push(2) push(3) pop() push(4) pop() Output: 3 4 ​Explanation: push(2)
 * the stack will be {2} push(3) the stack will be {2 3} pop() poped element
 * will be 3 the stack will be {2} push(4) the stack will be {2 4} pop() poped
 * element will be 4 Example 2:
 * 
 * Input: push(2) pop() pop() push(3) Output: 2 -1 Your Task:
 * 
 * Since this is a function problem, you don't need to take inputs. You are
 * required to complete the two methods push() which takes an integer 'x' as
 * input denoting the element to be pushed into the stack and pop() which
 * returns the integer poped out from the stack(-1 if the stack is empty).
 * 
 * Expected Time Complexity: O(1) for push() and O(N) for pop() (or vice-versa).
 */
// { Driver Code Starts
import java.util.*;

public class Stack_using_two_queues {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            Queues g = new Queues();

            int q = sc.nextInt();
            while (q > 0) {
                int QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    g.push(a);
                } else if (QueryType == 2)
                    System.out.print(g.pop() + " ");
                q--;
            }
            System.out.println();

            t--;
        }
    }
}

// } Driver Code Ends

class Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    Queue<Integer> temp = new LinkedList<Integer>();

    /* The method pop which return the element poped out of the stack */
    int pop() {
        if (q1.isEmpty()) {
            return -1;
        } else {
            int k = q1.peek();
            q1.remove();
            return k;

        }
    }

    /* The method push to push element into the stack */
    void push(int a) {
        q2.add(a);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());

        }
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }

    }
}
// ===============================
//
// Approach
//
// ===============================

// Assume two queue's q1 & q2.
// makes sure that newly entered element is always at the front of ‘q1’.
// pop operation just dequeues from ‘q1’.
// ‘q2’ is used to put every new element at front of ‘q1’.

// x is the element to be pushed and s is stack
// push(s, x):
// 1) Enqueue x to q2
// 2) One by one dequeue everything from q1 and enqueue to q2.
// 3) Swap the names of q1 and q2
// // Swapping of names is done to avoid one more movement of all elements from
// q2 to q1.

// pop(s):
// 1) Dequeue an item from q1 and return it.