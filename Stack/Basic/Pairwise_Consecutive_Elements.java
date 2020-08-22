
/*
Given a stack of integers of size N, your task is to complete the function pairWiseConsecutive(), 
that checks whether numbers in the stack are pairwise consecutive or not. 
The pairs can be increasing or decreasing, and if the stack has an odd number of elements,
 the element at the top is left out of a pair. The function should retain the original stack content.

Only following standard operations are allowed on stack.

push(X): Enter a element X on top of stack.
pop(): Removes top element of the stack.
empty(): To check if stack is empty.
Input Format:
The first line of input contains T denoting the number of testcases.
 T testcases follow.
  Each testcase contains two lines of input. 
  The first line contains n denoting the number of elements to be inserted into the stack.
   The second line contains the elements to be inserted into the stack.

Output Format:
For each testcase, in a new line, 
print "Yes"(without quote) if the elements of the stack is pairwise consecutive, 
else print "No".

Your Task:
This is a function problem.
 You only need to complete the function pairWiseConsecutive that takes a stack as an argument 
 and returns true if the stack is found to be pairwise consecutive, else it returns false. 
 The printing is done by the driver code.

Constraints:
1 < =T <= 100
1 < =N <= 103

Example:
Input:
2
6
1 2 3 4 5 6
5
1 5 3 9 7
Output:
Yes
No

Explanation:
Testcase1: The number of elements are even and they are pairwise consecutive so we print Yes.
Testcase2: The number of elements are odd so we remove the top element and check for pairwise consecutive. 
It is not so we print No.
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;

public class Pairwise_Consecutive_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            Stack<Integer> st = new Stack<Integer>();
            int n = sc.nextInt();
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp = sc.nextInt();
                st.push(temp);
            }
            GFG gfg = new GFG();
            if (gfg.pairWiseConsecutive(st) == true)
                System.out.println("Yes");
            else
                System.out.println("No");

        }
    }
}
// } Driver Code Ends

// User function Template for Java

// your task is to complete the function
// function should return true/false or 1/0
class GFG {
    public static boolean pairWiseConsecutive(Stack<Integer> st) {
        int k = st.pop();
        while (!st.empty()) {
            int l = st.pop();
            if (Math.abs(k - l) != 1) {
                return false;
            }
            k = l;

        }
        return true;

    }
}

// ==================================
//
// Approach
//
// ==================================

// Create an auxillary stack and keep on pushing the elements to it.
// If the size is even then push all elements but if it is odd then leave the
// top element.
// Now keep on popping and checking if the absolute difference of pair is 1 or
// not.