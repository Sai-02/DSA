
/*
Given an expression string exp. Examine whether
 the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases. 
 Each test case consists of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced 
else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced 
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Parenthesis_Checker {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            Stack<Character> a = new Stack<Character>();
            String s = scan.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                try {
                    if (c == '(' || c == '{' || c == '[') {
                        a.push(c);
                    }

                    else if (c == ']' && a.peek() == '[') {
                        a.pop();
                    } else if (c == '}' && a.peek() == '{') {
                        a.pop();
                    } else if (c == ')' && a.peek() == '(') {
                        a.pop();
                    }

                    else {
                        break;
                    }
                } catch (Exception e) {
                    a.push(c);
                    break;

                }

            }
            if (a.empty()) {
                System.out.println("balanced");
            } else {
                System.out.println("not balanced");
            }

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

// =====================================================
//
// Approach
//
//
// =====================================================

// Push the element into the stack.
// Pop the element from the stack if the top of stack has the opposite
// parenthesis.
// At the end check if the stack size is empty or not.
// The answer is balanced if stack is empty or else it is unbalanced