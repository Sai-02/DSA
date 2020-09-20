
/*
 * A deque is a double-ended queue that allows enqueue and dequeue operations
 * from both the ends.
 * 
 * Given a deque and Q queries. The task is to perform some operation on dequeue
 * according to the queries as given below: 1. pb: query to push back the
 * element x. 2. pf: query to push element x(given with query) to the front of
 * the deque. 3. pp_b(): query to delete element from the back of the deque. 4.
 * f: query to return a front element from the deque.
 * 
 * Example 1:
 * 
 * Input: 5 pf 5 pf 10 pb 6 f pp_b
 * 
 * Output: 10
 * 
 * Explanation: 1. After push front deque will be {5} 2. After push front deque
 * will be {10, 5} 3. After push back deque will be {10, 5, 6} 4. Return front
 * element which is 10 5. After pop back deque will be {10, 5}
 * 
 * Example 2:
 * 
 * Input: 2 pf 5 f
 * 
 * Output: 5
 * 
 * Explanation: 1. After push front deque will be {5} 2. Return front element
 * which is 5 Your Task: Your task is to complete the following functions:
 * push_back_pb(): Push back the given element and then driver code prints that
 * element. push_front_pf(): Push front the given element and then driver code
 * prints that element. pop_back_ppb(): Pop the back element (if exists) and
 * then the driver code prints the size of the deque. front_dq(): Return the
 * front elements if it exists, else return -1. The driver code prints the
 * return value.
 * 
 * Expected Time Complexity: O(1) Expected Auxilliary Space: O(N)
 * 
 * Constraints: 1 ≤ Number of queries ≤ 105
 */
// { Driver Code Starts
// Initial Template for Java

/* package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Deque_Implementations {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Creating a new ArrayDeque
            ArrayDeque<Integer> dq = new ArrayDeque<>();

            // Taking the total number of queries
            int queries = sc.nextInt();

            while (queries-- > 0) {

                // taking input the String and removing spaces from front and rear
                String s = sc.next().trim();

                // if query is push back
                if (s.equals("pb")) {
                    int x = Integer.parseInt(sc.nextLine().trim());

                    push_back_pb(dq, x);
                    System.out.println(dq.peekLast());
                }

                // if query is to push front
                else if (s.equals("pf")) {
                    int x = Integer.parseInt(sc.nextLine().trim());

                    push_front_pf(dq, x);
                    System.out.println(dq.peekFirst());
                }

                // if query is to pop back
                else if (s.equals("pp_b")) {
                    pop_back_ppb(dq);
                    System.out.println(dq.size());
                }

                // if query is to return front
                else {
                    int x = front_dq(dq);
                    System.out.println(x);
                }

            }
        }

    }

    // } Driver Code Ends

    // User function Template for Java

    /*
     * Function to push element to front dq : dqueue in which element is to be
     * pushed x : element to be pushed
     */
    public static void push_back_pb(ArrayDeque<Integer> dq, int x) {

        dq.addLast(x);

    }

    /*
     * Function to pop element from back dq : dqueue From which element is to be
     * popped
     */
    public static void pop_back_ppb(ArrayDeque<Integer> dq) {

        if (dq.size() == 0) {
            return;
        }
        dq.removeLast();

    }

    /*
     * Function to return element from front dq : dqueue from which element is to be
     * returned
     */
    public static int front_dq(ArrayDeque<Integer> dq) {
        if (dq.size() == 0) {
            return -1;

        }
        return dq.peek();

    }

    /*
     * Function to push element to front dq : dqueue in which element is to be
     * pushed x : element to be pushed
     */
    public static void push_front_pf(ArrayDeque<Integer> dq, int x) {

        dq.addFirst(x);

    }

    // { Driver Code Starts.

} // } Driver Code Ends