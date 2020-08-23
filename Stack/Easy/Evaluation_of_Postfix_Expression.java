
/* 
Given a postfix expression, the task is to evaluate the expression and print the final value.
 Operators will only include the basic arithmetic operators like *,/,+ and - . 

Input:
The first line of input will contains an integer T denoting the no of test cases .
 Then T test cases follow. Each test case contains an postfix expression.

Output:
For each test case, in a new line, evaluate the postfix expression and print the value.

Constraints:
1 <= T <= 100
1 <= length of expression <= 100

Example:
Input:
2
231*+9-
123+*8-
Output:
-4
-3

Explanation: 
Test Case 1: 231*+9-
- : ( ) - ( )
9 : ( ) - (9)
+ : ( ( ) + ( ) ) - (9)
'*':  ( ( ) + ( ( ) * ( ) ) ) - (9)
1 : ( ( ) + ( ( ) * (1) ) ) - (9)
3 : ( ( ) + ( (3) * (1) ) ) - (9)
2 : ( (2) + ( (3) * (1) ) ) - (9) 
Result = (2 + 3) - 9 = 5 - 9 = -4

Test Case 2: 123+*8-
- : ( ) - ( )
8 : ( ) - (8)
* : ( ( ) * ( ) ) - (8)
+ : ( ( ) * ( ( ) + ( ) ) ) - (8)
3 : ( ( ) * ( ( ) + (3) ) ) - (8)
2 : ( ( ) * ( (2) + (3) ) ) - (8)
1 : ( (1) * ( (2) + (3) ) ) - (8) 
Result = (1 * 5) - 8 = 5 - 8 = -3
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Evaluation_of_Postfix_Expression {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            Stack<Integer> a = new Stack<Integer>();
            String s = scan.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '+') {
                    int k1 = a.pop();
                    int k2 = a.pop();
                    k1 = k1 + k2;
                    a.push(k1);

                } else if (c == '-') {
                    int k1 = a.pop();
                    int k2 = a.pop();
                    k1 = k2 - k1;
                    a.push(k1);

                } else if (c == '*') {
                    int k1 = a.pop();
                    int k2 = a.pop();
                    k1 = k1 * k2;
                    a.push(k1);

                } else if (c == '/') {
                    int k1 = a.pop();
                    int k2 = a.pop();
                    k1 = k2 / k1;
                    a.push(k1);

                } else {
                    String k = c + "";
                    a.push(Integer.parseInt(k));
                }

            }
            System.out.println(a.peek());

        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

// =================================================
//
// Approach
//
// =================================================

// Algorithm for evaluation postfix expressions.

// Create a stack to store operands (or values).
// Scan the given expression and do following for every scanned element.
// a. If the element is a number, push it into the stack
// b. If the element is a operator, pop operands for the operator from stack.
// c. Evaluate the operator and push the result back to the stack
// When the expression is ended, the number in the stack is the final answer