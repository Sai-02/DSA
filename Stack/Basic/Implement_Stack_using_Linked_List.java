
/*
Let's give it a try! You have a linked list and 
you have to implement the functionalities push and pop of stack using this given linked list.
 Your task is to use the class as shown in the comments in the code editor and 
 complete the functions push() and pop() to implement a stack. 

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
Your Task: You are required to complete two methods push() and pop().
 The push() method takes one argument, an integer 'x' to be pushed into the 
 stack and pop() which returns an integer present at the top and popped out from the stack. 
 If the stack is empty then return -1 from the pop() method.

Expected Time Complexity: O(1) for both push() and pop().
Expected Auxiliary Space: O(1) for both push() and pop().

Constraints:
1 <= Q <= 100
1 <= x <= 100 
*/
// { Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;

    StackNode(int a) {
        data = a;
        next = null;
    }
}

public class Implement_Stack_using_Linked_List {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack1 obj = new MyStack1();
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
 * The structure of the node of the stack is class StackNode { int data;
 * StackNode next; StackNode(int a) { data = a; next = null; } }
 */
class MyStack1 {

    // Note that top is by default null
    // in Java
    StackNode top;

    void push(int a) {
        if (top == null) {
            top = new StackNode(a);
            return;
        }
        StackNode temp = new StackNode(a);
        temp.next = top;
        top = temp;

    }

    int pop() {
        if (top == null) {
            return -1;
        }
        int k = top.data;
        top = top.next;
        return k;
    }
}

// =============================================
//
// Approach
//
// =============================================

// Since we need to maintain LIFO (Last in First Out) Order, we insert and
// delete from same end.

// In a singly linked list we can insert at head and delete from head in O(1)
// time.

// =============================================
//
// GFG Editorial
//
// =============================================
// class MyStack {

// StackNode top;

// // function to push element
// void push(int a) {

// // base case, when stack is empty
// if (top == null) {
// top = new StackNode(a);
// }

// // make a new node at top and assign it as top
// else
// {
// StackNode temp = new StackNode(a);
// temp.next = top;
// top = temp;
// }
// }

// // function to pop elements
// int pop() {
// StackNode temp = top;

// // base case, when stack is empty
// if (temp == null) {
// return -1;
// }
// else

// // delete the element(node) at top
// {
// temp = temp.next;
// int r = top.data;
// top = temp;
// return r;
// }
// }
// }