
/*
Write a program to implement a Stack using Array. 
Your task is to use the class as shown in the comments in the code editor
 and complete the functions push() and pop() to implement a stack. 

Example 1:

Input: 
push(2)
push(3)
pop()
push(4) 
pop()
Output: 3, 4
Explanation: 
push(2)    the stack will be {2}
push(3)    the stack will be {2 3}
pop()      poped element will be 3,
           the stack will be {2}
push(4)    the stack will be {2 4}
pop()      poped element will be 4
Example 2:

Input: 
pop()
push(4)
push(5)
pop()
Output: -1, 5
Your Task:
You are required to complete two methods push() and pop().
 The push() method takes one argument, an integer 'x' to be pushed into the stack and pop()
  which returns an integer present at the top and popped out from the stack. 
  If the stack is empty then return -1 from the pop() method.

Expected Time Complexity : O(1) for both push() and pop().
Expected Auixilliary Space : O(1) for both push() and pop().

Constraints:
1 <= Q <= 100
1 <= x <= 100 
*/
// { Driver Code Starts
import java.util.*;

import java.io.*;
import java.lang.*;

public class Implement_stack_using_array {

    public static void main(String args[]) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t=sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = Integer.parseInt(read.readLine());
            int k = 0;
            String str[] = read.readLine().trim().split(" ");
            while (Q > 0) {
                int QueryType = 0;
                QueryType = Integer.parseInt(str[k++]);
                if (QueryType == 1) {
                    int a = Integer.parseInt(str[k++]);

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
 * You need to add code for functions push() and pop()
 */
class MyStack {

    int top;
    int arr[] = new int[1000];

    MyStack() {
        top = -1;
    }

    /*
     * The method push to push element into the stack
     */
    void push(int a) {
        top++;
        arr[top] = a;
    }

    /*
     * The method pop which return the element poped out of the stack
     */
    int pop() {
        if (top == -1) {
            return -1;
        }
        top--;
        return arr[top + 1];
    }
}

//===========================================================
//
// Approach
//
//===========================================================

// For push simply increment top and assign arr[top]=element

// For pop simply return top element and decrement top. If top is -1 then non pop can happen.
