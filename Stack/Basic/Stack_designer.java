
/*
You are given an array A of size N. 
You need to push the elements of the array into a stack and then print them while popping.

Input Format:
The first line of input contains T denoting the number of testcases. 
T testcases follow. Each testcase contains two lines of input. 
The first line of input contains size of array N. 
The second line of array contains the elements of array separated by spaces.

Output Format:
For each testcase, in a new line, print the required output.

Your Task:
Since this is a function problem, you don't need to take any input.
 Just complete the provided functions _push() and _pop().

Constraints:
1 <= T <= 100
1 <= Ai <= 107

Examples:
Input:
2
5
1 2 3 4 5
7
1 6 43 1 2 0 5
Output:
5 4 3 2 1
5 0 2 1 43 6 1 
*/

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Stack_designer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            // Creating an ArrayList
            ArrayList<Integer> arr = new ArrayList<>();

            // Taking input the total number of elements
            int n = sc.nextInt();

            // adding all the elements to the ArrayList
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }

            // Calling the push method and passing
            // ArrayList and the it's size
            Stack<Integer> mys = _push(arr, n);

            // Calling the pop method
            // and passing Stack
            _pop(mys);

            System.out.println();
        }
    }

    // } Driver Code Ends

    // User function Template for Java

    public static Stack<Integer> _push(ArrayList<Integer> arr, int n) {
        Stack<Integer> a = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            a.push(arr.get(i));

        }
        return a;

    }

    public static void _pop(Stack<Integer> s) {
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }

    // { Driver Code Starts.
} // } Driver Code Ends