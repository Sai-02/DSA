
/*
 * Find the largest rectangular area possible in a given histogram where the
 * largest rectangle can be made of a number of contiguous bars. For simplicity,
 * assume that all bars have same width and the width is 1 unit.
 * 
 * Input: The first line contains an integer 'T' denoting the total number of
 * test cases. T test-cases follow. In each test cases, the first line contains
 * an integer 'N' denoting the size of array. The second line contains N
 * space-separated integers A1, A2, ..., AN denoting the elements of the array.
 * The elements of the array represents the height of the bars.
 * 
 * Output: For each test-case, in a separate line, the maximum rectangular area
 * possible from the contiguous bars.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 105 1 <= A[i] <= 104
 * 
 * Example: Input: 2 7 6 2 5 4 5 1 6 4 6 3 4 2 Output: 12 9
 * 
 * Explanation: Testcase1:
 * 
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Maximum_Rectangular_Area_in_Histogram {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }

            int max = 0;
            Stack<Integer> s = new Stack<>();
            int i = 0;
            while (i < n) {
                if (s.empty() || a[s.peek()] <= a[i]) {
                    s.push(i);
                    i++;

                } else {

                    int k = s.peek();
                    s.pop();

                    int area = a[k] * (s.empty() ? i : (i - s.peek() - 1));
                    max = Math.max(area, max);

                }
            }

            while (!s.empty()) {
                int k = s.peek();
                s.pop();
                int area = a[k] * (s.empty() ? i : (i - s.peek() - 1));
                max = Math.max(area, max);

            }

            System.out.println(max);

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

// ===============================
//
// Approach
//
// ===============================

// Assume Width of all bars to be 1 for simplicity.
// For every bar ‘x’, calculate the area with ‘x’ as the smallest bar in the
// rectangle.
// To calculate area with ‘x’ as smallest bar, find index of the first smaller
// (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right
// of ‘x’. Assume these indexes as ‘left index’ and ‘right index’ respectively.
// Traverse all bars from left to right, maintain a stack of bars. Every bar is
// pushed to stack once.
// POP a bar from stack when a bar of smaller height is seen.
// When a bar is popped, calculate the area with the popped bar as smallest bar.
// Get the left and right indexes of the popped bar – the current index tells us
// the ‘right index’ and index of previous item in stack is the ‘left index’.

// algo

// The complete algorithm:

// 1) Create an empty stack.

// 2) Start from first bar, and do following for every bar ‘arr[i]’ where ‘i’
// varies from 0 to n-1.
// ……a) If stack is empty or arr[i] is higher than the bar at top of stack, then
// push ‘i’ to stack.
// ……b) If this bar is smaller than the top of stack, then keep removing the top
// of stack while top of the stack is greater. Let the removed bar be arr[tp].
// Calculate area of rectangle with arr[tp] as smallest bar. For arr[tp], the
// ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is
// ‘i’ (current index).

// 3) If the stack is not empty, then one by one remove all bars from stack and
// do step 2.b for every removed bar.

// ====================================
//
// GFG Editorial
//
// ===================================

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class GFG {
    
//     public static long getMaxArea(long hist[], long n)  { 

//         Stack<Long> s = new Stack<Long>(); 
//         long max_area = 0, area_with_top; 
//         long tp=0, i = 0; 
//         while (i < n) { 
//             if(!s.empty())tp=s.peek();
//             if (s.empty() || hist[(int)tp] <= hist[(int)i]) {
//                 s.push(i++); 
//             } else { 
//                 tp = s.peek(); 
//                 s.pop();
//                 area_with_top = hist[(int)tp] * (s.empty() ? i : i - s.peek() - 1); 
//                 if(max_area < area_with_top) 
//                     max_area = area_with_top; 
//             } 
//         } 
        
//         while (s.empty() == false) { 
//             tp = s.peek(); 
//             s.pop(); 
//             area_with_top = hist[(int)tp] * (s.empty() ? i : i - s.peek() - 1); 
//             if (max_area < area_with_top) 
//                 max_area = area_with_top; 
//         } 
//         return max_area; 
//     } 
    
// 	public static void main (String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int t = Integer.parseInt(br.readLine().trim());
// 		while(t-->0){
// 		    long n = Long.parseLong(br.readLine().trim());
// 		    String inputLine[] = br.readLine().trim().split(" ");
// 		    long[] arr = new long[(int)n];
// 		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
// 		    System.out.println(getMaxArea(arr, n));
// 		}
// 	}
// }
