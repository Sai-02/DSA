
/*
 * Given an infix expression in the form of a string str. Conver this infix
 * expression to postfix expression.
 * 
 * Infix expression: The expression of the form a op b. When an operator is
 * in-between every pair of operands. Postfix expression: The expression of the
 * form a b op. When an operator is followed for every pair of operands. Input:
 * The first line of input contains an integer T denoting the number of test
 * cases. The next T lines contains an infix expression.The expression contains
 * all characters and ^,*,/,+,-.
 * 
 * Output: For each testcase, in a new line, output the infix expression to
 * postfix expression.
 * 
 * Constraints: 1 <= T <= 100 1 <= length of str <= 103
 * 
 * Example: Input: 2 a+b*(c^d-e)^(f+g*h)-i A*(B+C)/D
 * 
 * Output: abcd^e-fgh*+^*+i- ABC+*D/
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Infix_to_Postfix {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            String str = scan.nextLine();
            Stack<Character> s = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '*' || c == '/' || c == '+' || c == '-' || c == '(' || c == ')' || c == '^') {
                    if (s.empty()) {
                        s.push(c);
                    } else {
                        if (c == '(') {
                            s.push(c);
                        } else if (c == ')') {
                            while (!s.empty()) {
                                char l = s.pop();
                                if (l == '(') {
                                    break;
                                }
                                System.out.print(l);
                            }
                        } else {
                            if (getPrecendence(c) > getPrecendence(s.peek())) {
                                s.push(c);
                            } else {
                                while (!s.empty() && getPrecendence(c) <= getPrecendence(s.peek())) {
                                    if (s.peek() == '(') {
                                        break;
                                    }
                                    System.out.print(s.pop());
                                }
                                s.push(c);
                            }
                        }

                    }
                } else {

                    System.out.print(c);
                }

            }
            while (!s.empty()) {
                System.out.print(s.pop());
            }
            System.out.println();

        }

    }

    public static int getPrecendence(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '(') {
            return 0;
        }

        else {
            return 1;
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

// =======================================
//
// Approach
//
// =======================================

// The postfix expressions can be evaluated easily using a stack.

// Scan the infix expression from left to right.
// If the scanned character is an operand, output it.
// Else,
// If the precedence of the scanned operator is greater than the precedence of
// the operator in the stack push it.
// Else, Pop all the operators from the stack which are greater than or equal to
// in precedence than that of the scanned operator. After doing that Push the
// scanned operator to the stack. (If encounter parenthesis while popping then
// stop there and push the scanned operator in the stack.)
// If the scanned character is an ‘(‘, push it to the stack.
// If the scanned character is an ‘)’, pop the stack and and output it until a
// ‘(‘ is encountered, and discard both the parenthesis.
// Repeat steps 2-6 until infix expression is scanned.
// Print the output
// Pop and output from the stack until it is not empty.



//====================================================
//
// GFG Editorial
//
//====================================================

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class GFG {
    
//     public static int prec(char ch) { 
// 		switch (ch) { 
// 		    case '+': 
// 		    case '-': 
// 		        return 1; 
// 		    case '*': 
// 		    case '/': 
// 			    return 2; 
// 		    case '^': 
// 			    return 3; 
// 		} 
// 		return -1; 
// 	} 
	
// 	public static String infixToPostfix(String exp) {
// 		String result = new String("");
// 		Stack<Character> stack = new Stack<>(); 
		
// 		for(int i = 0; i<exp.length(); ++i) { 
// 			char c = exp.charAt(i); 
// 			if (Character.isLetterOrDigit(c)) 
// 				result += c; 
// 			else if (c == '(') 
// 				stack.push(c); 
// 			else if (c == ')') { 
// 				while (!stack.isEmpty() && stack.peek() != '(') 
// 					result += stack.pop(); 
				
// 				if (!stack.isEmpty() && stack.peek() != '(') 
// 					return "Invalid Expression"; 				 
// 				else
// 					stack.pop(); 
// 			} else { 
// 				while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) 
// 					result += stack.pop(); 
// 				stack.push(c); 
// 			} 
	
// 		} 
// 		while (!stack.isEmpty()) 
// 			result += stack.pop(); 
// 		return result; 
// 	} 
    
// 	public static void main (String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int t = Integer.parseInt(br.readLine().trim());
// 		while(t-->0){
// 		    System.out.println(infixToPostfix(br.readLine().trim()));
// 		}
// 	}
// }