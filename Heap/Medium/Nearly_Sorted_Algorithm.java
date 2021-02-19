
/*
Given an array of n elements, 
where each element is at most k away from its target position.
 The task is to print array in sorted form.

Input:
First line consists of T test cases.
 First line of every test case consists of two integers N and K,
  denoting number of elements in array and
   at most k positions away from its target position respectively.
    Second line of every test case consists of elements of array.

Output:
Single line output to print the sorted array.

Constraints:
1<=T<=100
1<=N<=100
1<=K<=N

Example:
Input:
2
3 3
2 1 3
6 3
2 6 3 12 56 8
Output:
1 2 3
2 3 6 8 12 56
 */
import java.util.*;
import java.io.*;

public class Nearly_Sorted_Algorithm {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int value = scan.nextInt();
                pq.add(value);
            }
            for (int i = 0; i < n - k; i++) {
                int value = scan.nextInt();
                ans.add(pq.remove());
                pq.add(value);
            }
            while (!pq.isEmpty()) {
                ans.add(pq.remove());
            }
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ans.get(i) + " ");
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