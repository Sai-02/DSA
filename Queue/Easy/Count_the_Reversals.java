
/*
 * Given a string S consisting only of opening and closing curly brackets '{'
 * and '}' find out the minimum number of reversals required to make a balanced
 * expression.
 * 
 * Input The first line of input contains an integer T, denoting the number of
 * test cases. Then T test cases follow. The first line of each test case
 * contains a string S consisting only of { and }.
 * 
 * Output Print out minimum reversals required to make S balanced. If it cannot
 * be balanced, then print -1.
 * 
 * Constraints 1 <= T <= 100 0 <= |S| <= 50
 * 
 * Examples Input 4 }{{}}{{{ {{}}}} {{}{{{}{{}}{{ {{{{}}}}
 * 
 * Output 3 1 -1 0
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Count_the_Reversals {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            String str = scan.nextLine();
            int ans = Reversals(str);
            System.out.println(ans);

        }

    }

    public static int Reversals(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            return -1;
        }
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (s.empty()) {
                s.push(str.charAt(i));
            } else {
                if (str.charAt(i) == '}' && s.peek() == '{') {
                    s.pop();

                } else {
                    s.push(str.charAt(i));
                }
            }
        }
        int n = 0, m = 0;
        while (!s.empty()) {
            if (s.peek() == '{') {
                n++;
            } else {
                m++;
            }
            s.pop();

        }
        return (int) (Math.ceil(n / 2.0) + Math.ceil(m / 2.0));
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