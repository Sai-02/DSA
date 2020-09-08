
/*
 * Given a Queue Q containing N elements. The task is to reverse the Queue. Your
 * task is to complete the function rev(), that reverses the N elements of the
 * queue.
 * 
 * Example 1:
 * 
 * Input: N = 6 Queue = 4 3 1 10 2 6 Output: 6 2 10 1 3 4 Explanation: After
 * reversing the given elements of the queue , the resultant queue will be 6 2
 * 10 1 3 4. Example 2:
 * 
 * Input: N = 4 Queue = 4 3 2 1 Output: 1 2 3 4 Explanation: After reversing the
 * given elements of the queue , the resultant queue will be 1 2 3 4. Your Task:
 * You only need to complete the function rev that takes a queue as parameter
 * and returns the reversed queue. The printing is done automatically by the
 * driver code.
 * 
 * Expected Time Complexity : O(n) Expected Auxilliary Space : O(n)
 */

// { Driver Code Starts
import java.util.*;
import java.io.*;

public class Queue_Reversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading total number of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            // Reading total number of elements
            int n = Integer.parseInt(br.readLine());

            // Creating a Queue
            Queue<Integer> q = new LinkedList<>();

            // Reading all the elements in a string
            String s = br.readLine();

            // Spliting the string into different
            // string separated by space
            String[] a = s.split(" ");

            // adding all the elements to the Queue
            for (String b : a) {
                int x = Integer.parseInt(b);
                q.add(x);
            }

            // Creating an object of class Geeks
            GfG3 g = new GfG3();

            // calling rev method of class Geeks
            q = g.rev(q);

            // printing the elements of the queue
            while (!q.isEmpty()) {
                int x = q.peek();
                q.poll();
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java
/* Complete the function below */
class GfG3 {
    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> st = new Stack<Integer>();
        while (!q.isEmpty()) {
            st.push(q.remove());
        }
        while (!st.empty()) {
            q.add(st.pop());
        }
        return q;
    }
}
