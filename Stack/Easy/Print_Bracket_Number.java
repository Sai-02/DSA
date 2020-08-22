
/*
 * Given an expression exp of length n consisting of some brackets. The task is
 * to print the bracket numbers when the expression is being parsed.
 * 
 * Input: The first line contains an integer T, the number of test cases. For
 * each test case, there is a string exp containing the expression.
 * 
 * Output: For each test case, the output is the bracket numbers of the
 * expression.
 * 
 * Constraints: 1<=T<=100 1<=S<=100
 * 
 * Example: Input: 3​ (a+(b*c))+(d/e)​ ((())(())) ((((() Output: 1 2 2 1 3 3 1 2
 * 3 3 2 4 5 5 4 1 1 2 3 4 5 5
 * 
 * Explanation: Test case 1:The highlighted brackets in the given expression
 * (a+(b*c))+(d/e) has been assigned the numbers as: 1 2 2 1 3 3.
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Print_Bracket_Number {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            String s = scan.nextLine();
            Stack<Integer> a = new Stack<Integer>();

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {

                    count++;
                    a.push(count);
                    System.out.print(count + " ");
                } else if (s.charAt(i) == ')') {
                    System.out.print(a.pop() + " ");

                }

            }
            System.out.println();

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