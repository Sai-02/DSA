
/*
 * Given a string S consisting only of opening and closing parenthesis 'ie '('
 * and ')', find out the length of the longest valid substring.
 * 
 * NOTE: Length of smallest the valid substring ( ) is 2.
 * 
 * 
 * 
 * Input The first line of input contains an integer T denoting the number of
 * test cases. Then T test cases follow. The first line of each test case
 * contains a string S consisting only of ( and ).
 * 
 * 
 * Output
 * 
 * Print out the length of the longest valid substring.
 * 
 * Constraints 1 <= T <= 100 0 < S <= 110
 * 
 * 
 * 
 * Examples
 * 
 * Input 4 (()( ()()(( ((()()()))) ()(())(
 * 
 * Output 2 4 10 6
 * 
 * Explanation: Test Case 1: (()( The longest valid substring is "()". Length =
 * 2 Test Case 2: ()()(( The longest valid substring is "()()". Length = 4 Test
 * Case 3: ((()()()))) The longest valid substring is "((()()()))". Length = 10
 * ​Test Case 4: ()(())( The longest valid substring is "()(())". Length = 6
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Valid_Substring {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            String str = scan.nextLine();
            Stack<Character> s = new Stack<>();
            Stack<Integer> index = new Stack<>();
            index.push(-1);
            int max = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    s.push('(');
                    index.push(i);
                } else {
                    if (!s.empty() && s.peek() == '(') {
                        s.pop();
                        index.pop();
                        max = Math.max(max, i - index.peek());
                    } else {
                        index.push(i);
                    }
                }

            }
            System.out.println(max);

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