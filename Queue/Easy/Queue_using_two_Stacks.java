
/*
 * Implement a Queue using 2 stacks s1 and s2 . A Query Q is of 2 Types (i) 1 x
 * (a query of this type means pushing 'x' into the queue) (ii) 2 (a query of
 * this type means to pop element from queue and print the poped element)
 * 
 * Example 1:
 * 
 * Input: 5 1 2 1 3 2 1 4 2
 * 
 * Output: 2 3
 * 
 * Explanation: In the first testcase 1 2 the queue will be {2} 1 3 the queue
 * will be {2 3} 2 poped element will be 2 the queue will be {3} 1 4 the queue
 * will be {3 4} 2 poped element will be 3. Example 2:
 * 
 * Input: 4 1 2 2 2 1 4
 * 
 * Output: 2 -1
 * 
 * Explanation: In the second testcase 1 2 the queue will be {2} 2 poped element
 * will be 2 and then the queue will be empty 2 the queue is empty and hence -1
 * 1 4 the queue will be {4}. Your Task: You are required to complete the two
 * methods push which take one argument an integer 'x' to be pushed into the
 * queue and pop which returns a integer poped out from other queue(-1 if the
 * queue is empty). The printing is done automatically by the driver code.
 * 
 * Expected Time Complexity : O(1) for both push() and O(N) for pop(). Expected
 * Auxilliary Space : O(N).
 * 
 * Constraints: 1 <= Q <= 100 1 <= x <= 100
 * 
 * Note:The Input/Ouput format and Example given are used for system's internal
 * purpose, and should be used by a user for Expected Output only. As it is a
 * function problem, hence a user should not read any input from stdin/console.
 * The task is to complete the function specified, and not to write the full
 * code.
 */

// { Driver Code Starts
import java.util.*;
import java.util.Stack;
import java.util.LinkedList;

public class Queue_using_two_Stacks {
    public static void main(String args[]) {
        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking input the number of testcases
        int t = sc.nextInt();
        while (t > 0) {
            // Creating a new object of class StackQueue
            StackQueue g = new StackQueue();

            // Taking input the total number of Queries
            int q = sc.nextInt();
            while (q > 0) {
                int QueryTyoe = sc.nextInt();

                // If QueryTyoe is 1 then
                // we call the Push method
                // of class StackQueue
                // else we call the Pop method
                if (QueryTyoe == 1) {
                    int a = sc.nextInt();
                    g.Push(a);
                } else if (QueryTyoe == 2)
                    System.out.print(g.Pop() + " ");
                q--;

            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /*
     * The method insert to push element into the queue
     */
    void Push(int x) {

        s1.push(x);

    }

    /*
     * The method remove which return the element popped out of the queue
     */
    int Pop() {
        if (s1.empty()) {
            return -1;
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        int k = s2.pop();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return k;
    }
}
//=====================================
//
// Approach
//
//=====================================

// There are multiple methods to solve this problem.

// enQueue(q,  x)
//   1) Push x to s1 (assuming size of stacks is unlimited).
// Here time complexity will be O(1)

// deQueue(q)
//   1) If both stacks are empty then error.
//   2) If s2 is empty
//        While s1 is not empty, push everything from s1 to s2.
//   3) Pop the element from s2 and return it.
// Here time complexity will be O(n)

// OR

// enQueue(q, x)
//   1) While s1 is not empty, push everything from s1 to s2.
//   2) Push x to s1 (assuming size of stacks is unlimited).
//   3) Push everything back to s1.
// Here time complexity will be O(n)

// deQueue(q)
//   1) If s1 is empty then error
//   2) Pop an item from s1 and return it
// Here time complexity will be O(1)

