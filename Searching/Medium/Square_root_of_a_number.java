/*
Given an integer x, find the square root of x. If x is not a perfect square, 
then return floor(√x).

 

Example 1:

Input:
x = 5
Output: 2
Explanation: Since, 5 is not a perfect 
square, floor of square_root of 5 is 2.
Example 2:

Input:
x = 4
Output: 2
Explanation: Since, 4 is a perfect 
square, so its square root is 2.
 

Your Task:
You don't need to read input or print anything. 
The task is to complete the function floorSqrt() 
which takes x as the input parameter and return its square root.
Note: Try Solving the question without using sqrt Function.

 

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ x ≤ 107

Company Tags
Topic Tags
Related Courses

 */

// { Driver Code Starts
import java.util.Scanner;

public class Square_root_of_a_number {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}// } Driver Code Ends

/*
 * You are required to complete this function
 */

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 0, r = x;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if (mid * mid < x) {

                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }
}
// =============================================================
// 
// GFG Editorial
// 
// =============================================================


// 1) Start with ‘start’ = 0, end = ‘x’,
// 2) Do following while ‘start’ is smaller than or equal to ‘end’.
//       a) Compute ‘mid’ as (start + end)/2
//       b) compare mid*mid with x.
//       c) If x is equal to mid*mid, return mid.
//       d) If x is greater, do binary search between mid+1 and end. In this case, we also update ans (Note that we need floor).
//       e) If x is smaller, do binary search between start and mid



// class Solution


// {
//      long floorSqrt(long x)
// 	 {
// 	     // base case
// 		if(x == 0 || x == 1)
// 			return x;
			
// 		long start = 1, end = x, ans = 0;
		
// 		// binary search to find square root of a number
// 		while(start <= end)
// 		{
// 			long mid = (start + end)/2;

//             // if mid*mid == x, then mid is the required element
// 			if(mid*mid == x)
// 				return mid;
				
// 			// if mid*mid < x, then iterate for upper half
// 			if(mid*mid < x)
// 			{
// 				start = mid+1;
// 				ans = mid;
// 			}
// 			// else, iterate for lower half
// 			else
// 				end = mid - 1;
				
// 		}
// 		return ans;
// 	 }
// }