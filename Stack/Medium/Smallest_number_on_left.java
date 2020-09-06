
/*
 * Given an array of integers, find the nearest smaller number for every element
 * such that the smaller element is on left side.If no small element present on
 * the left print -1.
 * 
 * Input:
 * 
 * The first line of input contains T test cases.
 * 
 * The first line of each test case contains the number of elements in the
 * array.
 * 
 * The second line of each test case contains the elements of the array.
 * 
 * Output:
 * 
 * Print the n elements. Constraints:
 * 
 * 1<=T<=100
 * 
 * 1<=N<=100
 * 
 * 0<=A[i]<10000 Example:
 * 
 * Input:
 * 
 * 2
 * 
 * 3
 * 
 * 1 6 2
 * 
 * 6
 * 
 * 1 5 0 3 4 5
 * 
 * Output:
 * 
 * -1 1 1
 * 
 * -1 1 -1 0 3 4
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Smallest_number_on_left {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] a = new int[n];
            int[] left = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
                left[i] = 0;
            }
            Stack<Integer> s = new Stack<Integer>();
            int i = 0;
            while (i < n) {
                if (s.empty()) {
                    s.push(i);
                    left[i] = -1;
                    i++;
                } else {
                    if (a[s.peek()] < a[i]) {
                        left[i] = a[s.peek()];
                        s.push(i);
                        i++;
                    } else {
                        s.pop();
                    }
                }
            }

            for (i = 0; i < n; i++) {
                System.out.print(left[i] + " ");
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