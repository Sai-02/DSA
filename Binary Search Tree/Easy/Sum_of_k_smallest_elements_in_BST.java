
/*
Given Binary Search Tree. 
The task is to find sum of all elements smaller 
than and equal to Kth smallest element.
Input:
The first line of input contains a single integer T 
denoting the number of test cases. Then T test cases follow.
 Each test case consists of three lines.
First line of each test case consist of integer N,
 denoting the number of elements in a BST.
Second line of each test case consists of N space 
separated integers denoting the elements in the BST
. (ignore duplicate during insertion in bst)
Third line of each test case consists of an integer K,
 denoting the Kth smallest elements.

Output:
It should be single line output, Print the respective output in the respective line.

Constraints:
1<=T<=100
1<=N<=50
1<=K<=N

Example:
Input:
1
7
20 8 4 12 10 14 22
3
Output:
22
Explanation:
The tree for above input will look like this:
          20
        /     \
       8     22
     /     \
    4     12
         /     \
        10    14
Sum of 3 smallest elements are: 4 + 8 + 10 = 22
 */

import java.util.*;
import java.io.*;

public class Sum_of_k_smallest_elements_in_BST {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            int n = scan.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            HashSet<Integer> h = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int value = scan.nextInt();
                if (!h.contains(value)) {
                    a.add(value);
                    h.add(value);

                }
            }
            int k = scan.nextInt();
            Collections.sort(a);

            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum = sum + a.get(i);
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
