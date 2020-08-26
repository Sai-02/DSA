
/*
 * Given an array A of size N having distinct elements, the task is to find the
 * next greater element for each element of the array in order of their
 * appearance in the array. If no such element exists, output -1
 * 
 * Input: The first line of input contains a single integer T denoting the
 * number of test cases. Then T test cases follow. Each test case consists of
 * two lines. The first line contains an integer N denoting the size of the
 * array. The Second line of each test case contains N space separated positive
 * integers denoting the values/elements in the array A.
 * 
 * Output: For each test case, print in a new line, the next greater element for
 * each array element separated by space in order.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 107 1 <= Ai <= 1018 Example: Input 2 4 1
 * 3 2 4 4 4 3 2 1 Output 3 4 4 -1 -1 -1 -1 -1
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Next_larger_element {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<Integer>();
            int n = scan.nextInt();
            long[] a = new long[n];
            long[] nextGreaterElement = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextLong();
            }
            for (int i = 0; i < n; i++) {
                if (s.empty()) {
                    s.push(i);
                } else {
                    if (a[s.peek()] >= a[i]) {
                        s.push(i);
                    } else {
                        while (!s.empty() && a[s.peek()] < a[i]) {
                            nextGreaterElement[s.pop()] = a[i];
                        }
                        s.push(i);
                    }
                }
            }
            while (!s.empty()) {
                nextGreaterElement[s.pop()] = -1;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(nextGreaterElement[i] + " ");
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
//===============================================
//
// Approach
//
//===============================================
