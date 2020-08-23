
/*
Given an array arr[] and a number k. 
The task is to delete k elements which are smaller than next element 
(i.e., we delete arr[i] if arr[i] < arr[i+1]) or become smaller than next because next element is deleted.

Input:
The first line contains an integer T, the number of test cases.
 For each test case, the first line contains an integer n, 
 denoting the size of the array. Next line contains n space separated integers, 
 followed by an integer k, denoting the number of elements to be deleted from the array.

Output:
For each test case, the output is the array arr[] 
after deleting the k elements from the array if possible, else print the left array as it is.

Constraints:
1<=T<=100
2<=n<=100
1<=k<=100

Example:
Input
4
3
3 100 1
1
5
20 10 25 30 40
2
5
23 45 11 77 18
3
2
2 5
2
Output
100 1
25 30 40
77 18
5

Explanation:
1. arr[0] < arr[1] means 3 is less than 100, so delete 3.
2. First we delete 10 because it follows arr[i] < arr[i+1]. 
Then we delete 20 because 25 is moved next to it and it also starts following the condition.
3. We delete 23, 45 and 11 as they follow the condition arr[i] < arr[i+1].
4.  As after deleting 2, we are left with 5 only and hence 5 is the answer. 
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Delete_array_elements_which_are_smaller_than_next_or_become_smaller {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();

            }
            int k = scan.nextInt();
            Stack<Integer> sk = new Stack<Integer>();
            for (int i = 0; i < a.length; i++) {
                int val = a[i];
                if (sk.empty()) {
                    sk.push(val);

                } else if (sk.peek() > val) {
                    sk.push(val);

                } else {
                    while (!sk.empty() && k-- > 0) {
                        if (sk.peek() < val) {
                            sk.pop();
                        } else {
                            k++;
                            break;
                        }

                    }
                    sk.push(val);
                }

            }
            String str = "";
            while (!sk.empty()) {
                str = sk.pop() + " " + str;

            }
            System.out.println(str);

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