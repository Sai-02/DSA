/*
 * Given N integers, the task is to insert those elements in the queue. Also,
 * given M integers, task is to find the frequency of each number in the Queue.
 * 
 * Example:
 * 
 * Input: 8 1 2 3 4 5 2 3 1 5 1 3 2 9 10
 * 
 * Output: 2 2 2 -1 -1
 * 
 * Explanation: After inserting 1, 2, 3, 4, 5, 2, 3, 1 into the queue, frequency
 * of 1 is 2, 3 is 2, 2 is 2, 9 is -1 and 10 is -1 (since, 9 and 10 is not there
 * in the queue). Your Task: Your task is to complete the functions insert() and
 * findFrequency() which inserts the element into the queue and find the count
 * of occurences of element in the queue respectively.
 * 
 * Constraints: 1 <= N <= 103 1 <= M <= 103 1 <= Elements of Queue <= 106
 */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends

//User function Template for Java

// Helper class Geeks to implement 
// insert() and findFrequency()
class Geeks {

    // Function to insert element into the queue
    static void insert(Queue<Integer> q, int k) {
        q.add(k);

    }

    // Function to find frequency of an element
    // rteturn the frequency of k
    static int findFrequency(Queue<Integer> q, int k) {
        int count = Collections.frequency(q, k);

        if (count == 0) {
            return -1;
        }
        return count;

    }

}

// { Driver Code Starts.

// Driver class with driver code
class GFG {

    // Driver code
    public static void main(String[] args) {

        // Taking input using scanner class
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while (testcase-- > 0) {
            // Declaring Queue
            Queue<Integer> q = new LinkedList<>();
            int n = sc.nextInt();

            // Invoking object of Geeks class
            Geeks obj = new Geeks();

            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                obj.insert(q, k);
            }

            int x = sc.nextInt();
            for (int i = 0; i < x; i++) {
                int k = sc.nextInt();
                int f = obj.findFrequency(q, k);
                if (f != 0) {
                    System.out.println(f);
                } else {
                    System.out.println("-1");
                }
            }
        }
    }
} // } Driver Code Ends