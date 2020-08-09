
/*
An array A containing heights of building was given.
 Its a rainy season. Calculate the amount of water collected between all the buildings.

 

Histograms with no space in between
Input:
The first line of input contains an integer T denoting the number of test cases. 
The first line of each test case is N, N is the number of buildings. 
The second line of each test case contains N input H[i],height of buildings.

Output:
Print the amount of water collected between all the buildings.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 103
1 ≤ H[i] ≤ 103

Example:
Input:
1
6
1 5 3 7 4 2

Output:
2

Explanation:
Testcase 1: Water are trapped by block at index 2 (0-based indexing) only and can trap 2 units of water. 
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Amount_of_Water {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] a = new int[n];
            int volume = 0;
            int prev = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }

            for (int i = 0; i < n; i++) {
                try {

                    if (prev > a[i] && a[i] < a[i + 1]) {
                        if(a[i+1]<prev){
                            prev=a[i+1];
                        }
                        int k = Math.abs(prev - a[i]);
                        volume = volume + k;

                    }
                    prev = a[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;

                }

            }
            System.out.println(volume);

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