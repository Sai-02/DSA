
/*
Given an integer N, remove consecutive repeated digits from it.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow.
 The first line of each test case contains the integer N.

Output:
Print the number after removing consecutive digits. 
Print the answer for each test case in a new line.


Constraints:
1<= T <=100
1<= N <=1018


Example:

Input:
1
12224

Output:
124 
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Remove_repeated_digits_in_a_given_number {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {

            String s = scan.nextLine();
            Stack<Integer> a = new Stack<Integer>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                String j = c + "";
                int k = Integer.parseInt(j);
                if (i == 0) {
                    a.push(k);
                    System.out.print(k);

                } else if (a.peek() != k) {
                    a.push(k);
                    System.out.print(k);
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