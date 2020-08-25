
/*
You are given N elements and your task is to Implement a Stack in which
 you can get minimum element in O(1) time.

Example 1:

Input:
push(2)
push(3)
pop()
getMin()
push(1)
getMin()
Output: 3 2 1
Explanation: In the first test case for
query 
push(2)  the stack will be {2}
push(3)  the stack will be {2 3}
pop()    poped element will be 3 the
         stack will be {2}
getMin() min element will be 2 
push(1)  the stack will be {2 1}
getMin() min element will be 1
Your Task:
You are required to complete the three methods push() 
which take one argument an integer 'x' to be pushed into the stack, pop()
 which returns a integer poped out from the stack and getMin() which returns the min element from the stack. 
 (-1 will be returned if for pop() and getMin() the stack is empty.)

Expected Time Complexity : O(1) for all the 3 methods.
Expected Auixilliary Space : O(1) for all the 3 methods.

Constraints:
1 <= Number of queries <= 100
1 <= values of the stack <= 100 
*/
// { Driver Code Starts
import java.util.*;

public class Get_minimum_element_from_stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int q = sc.nextInt();
            GfG g = new GfG();
            while (q > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                    // System.out.println(att);
                } else if (qt == 2) {
                    System.out.print(g.pop() + " ");
                } else if (qt == 3) {
                    System.out.print(g.getMin() + " ");
                }

                q--;
            }
            System.out.println();
            T--;
        }

    }
}

// } Driver Code Ends

class GfG {
    int minElement = 0;
    Stack<Integer> s = new Stack<Integer>();
    int prev = 0;

    /* returns min element from stack */
    int getMin() {
        if (s.empty()) {
            return -1;
        }
        return minElement;
    }

    /* returns poped element from stack */
    int pop() {
        if (s.empty()) {
            return -1;
        }

        if (s.peek() >= minElement) {
            return s.pop();

        } else {
            int k = minElement;
            minElement = 2 * minElement - s.peek();
            s.pop();
            return k;
        }

    }

    /* push element x into the stack */
    void push(int x) {
        if (s.empty()) {
            s.push(x);
            minElement = x;
        } else {
            if (minElement > x) {
                s.push(2 * x - minElement);
                minElement = x;
            } else {
                s.push(x);
            }

        }

    }
}
// =============================================
//
// Approach
//
// ==============================================
// 1. Define a variable minEle that stores the current minimum element in the
// stack.
// When a minEle is removed fromt he stack,
// we push “2x – minEle” into the stack instead of x so that previous minimum
// element can be retrieved
// using current minEle and its value stored in stack.

// Push(x) : Inserts x at the top of stack.

// If stack is empty, insert x into the stack and make minEle equal to x.
// If stack is not empty, compare x with minEle. Two cases arise:
// If x is greater than or equal to minEle, simply insert x.
// If x is less than minEle, insert (2*x – minEle) into the stack and make
// minEle equal to x.
// Pop() : Removes an element from top of stack.

// Remove element from top. Let the removed element be y. Two cases arise:
// If y is greater than or equal to minEle, the minimum element in the stack is
// still minEle.
// If y is less than minEle, the minimum element now becomes (2*minEle – y),
// update (minEle = 2*minEle – y). Now retrieve previous minimum from current
// minimum and its value in stack.


//====================================================
//
//       GFG Editorial
//
//====================================================

// class GfG
// {
// 	int minEle;
// 	Stack<Integer> s; // = new Stack<Integer>();;
    
// 	GfG()
// 	{
// 		s = new Stack<Integer>();
// 	}
	
// 	int getMin()
// 	{
// 		if(s.isEmpty())
// 			return -1;
// 		else
// 			return minEle;
// 	}
// 	int pop()
// 	{
// 		if(s.isEmpty())
// 			return -1;
		
// 		int t = s.pop();
// 		if(t < minEle)
// 		{
// 			int k = minEle;
// 			minEle = 2*minEle - t;
// 			return k;
// 		}
// 		else 
// 		{
// 			return t;
// 		}
// 	}
// 	void push(int x)
// 	{
		
// 		//System.out.println(s.peek());
// 		if(s.isEmpty())
// 		{
// 			minEle = x;
// 			s.push(x);
// 			return ;
// 		}
// 		else if(x < minEle)
// 			{
// 				s.push(2*x - minEle);
// 				minEle = x;
// 			}
// 			else
// 			{
// 				s.push(x);
// 			}
// 	}	
// }