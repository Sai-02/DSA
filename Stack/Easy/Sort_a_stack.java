/*
Given a stack, the task is to sort it such that the top of the stack has 
the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything.
 Your task is to complete the function sort()
  which sorts the elements present in the given stack. 
  (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity : O(N*N)
Expected Auixilliary Space : O(N) recursive.

Constraints:
1<=N<=100

Note:The Input/Ouput format and Example given are used for system's internal purpose,
 and should be used by a user for Expected Output only. As it is a function problem,
  hence a user should not read any input from stdin/console. The task is to complete 
  the function specified, and not to write the full code.

Company Tags
 */

// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;

public class Sort_a_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0)
                s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

/* Complete the function below */
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        sortStack(s);
        return s;

    }

    public void sortStack(Stack<Integer> st) {
        if (st.size() == 0) {
            return;
        }
        int temp = st.pop();
        sortStack(st);
        insertSorted(st, temp);

    }

    public void insertSorted(Stack<Integer> st, int x) {
        if (st.empty() || st.peek() < x) {
            st.push(x);
            return;
        }
        int temp = st.pop();
        insertSorted(st, x);
        st.push(temp);

    }
}