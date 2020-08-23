
/*
Compress the string when lower and upper case are same. In compressed string characters should be in lowercase.

for ex:     input    aaABBb

               output  3a3b

Input

The first line of the input contains a single integer T denoting the number of test cases.
The first line of each test case contains string s.
Output

For each test case, output the required string.

Constraints

    •    1 ≤ T ≤ 101

    •    1 ≤ |s|≤ 1000

Example

Input:

3

aabbB

abc

aaacca

Output:

2a3b

1a1b1c

3a2c1a 
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Easy_string {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            String s = scan.nextLine();
            String ans = "";
            Stack<Character> a = new Stack<Character>();

            int k = 0;
            for (int i = 0; i < s.length(); i++) {
                int v = (int) s.charAt(i);
                if (v < 91) {
                    v = v + 32;
                }
                if (a.empty()) {
                    a.push((char) v);
                    k++;
                } else {
                    if ((int) a.peek() == v) {
                        k++;
                    } else {
                        ans = ans + k + a.pop();
                        a.push((char) v);
                        k = 1;
                    }

                }

            }
            ans = ans + k + a.pop();
            System.out.println(ans);

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