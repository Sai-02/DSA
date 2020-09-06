
/*
 * Gotham has been attacked by Joker . Bruce Wayne has deployed automatic
 * machine gun at each tower of Gotham. All the towers in Gotham are in straight
 * line. You are given no of towers 'n' followed by height of 'n' towers. For
 * every tower(p), find the height of the closest tower (towards the right),
 * greater than the height of tower(p). Now , Print sum of all such heights (mod
 * 1000000001).
 * 
 * Note : If for a tower(k) , no such tower exsits then take its height as 0.
 * 
 * Input: First line of the input contains t, the number of test cases. First
 * line of each test case contains 'n' denoting no of towers. This is followed
 * by 'n' spaced integers h1,h2.....h(n) representing height of towers.
 * 
 * Output: On a single line, output the sum(mod 1000000001).
 * 
 * 
 * Constraints: 1<=t<=100 1<=n<=18000 0<=a[i]<=100000
 * 
 * 
 * Example:
 * 
 * Input: 1 9 112 133 161 311 122 512 1212 0 19212
 * 
 * 
 * Output: 41265
 * 
 * Explanation : nextgreater(112) : 133 nextgreater(133) : 161 nextgreater(161)
 * : 311 nextgreater(311) : 512 nextgreater(122) : 512 nextgreater(512) : 1212
 * nextgreater(1212) : 19212 nextgreater(0) : 19212 nextgreater(19212) : 0
 * 
 * add = 133+161+311+512+512+1212+19212+19212+0 = 41265.
 * 
 * Expected Time complexity - O(n).
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Save_Gotham {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] a = new int[n];
            int[] right = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
                right[i] = 0;
            }
            Stack<Integer> s = new Stack<Integer>();
            int i = 0;
            while (i < n) {
                if (s.empty()) {
                    s.push(i);
                    i++;
                } else if (a[s.peek()] >= a[i]) {
                    s.push(i);
                    i++;
                } else {
                    right[s.pop()] = a[i];

                }

            }
            long sum = 0;
            for (i = 0; i < n; i++) {
                sum = sum + (long) right[i];
                sum = sum % 1000000001;
            }
            System.out.println(sum);

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