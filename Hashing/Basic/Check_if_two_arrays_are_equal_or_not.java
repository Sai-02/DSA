
/*
Given two arrays A and B of equal size N,
 the task is to find if given arrays are equal or not.
  Two arrays are said to be equal if both of them contain same set of elements,
   arrangements (or permutation) of elements may be different though.
Note : If there are repetitions,
 then counts of repeated elements must also be same for two array to be equal.

Example 1:

Input:
N = 5
A[] = {1,2,5,4,0}
B[] = {2,4,5,0,1}
Output: 1
Explanation: Both the array can be 
rearranged to {0,1,2,4,5}
Example 2:

Input:
N = 3
A[] = {1,2,5}
B[] = {2,4,15}
Output: 0
Explanation: A[] and B[] have only 
one common value.
Your Task:
Complete check() function which takes both the given array and 
their size as function arguments and returns true if the arrays
 are equal else returns false.The 0 and 1 printing is done by the driver code.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1<=N<=107
1<=A[],B[]<=1018

 
 */

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;

public class Check_if_two_arrays_are_equal_or_not {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();

        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }

            System.out.println(check(a, b, n) == true ? "1" : "0");

        }
    }

    // } Driver Code Ends
    // User function Template for Java

    public static boolean check(long a[], long b[], int n) {
        HashMap<Long, Integer> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hMap.containsKey(a[i])) {
                hMap.replace(a[i], hMap.get(a[i]) + 1);
            } else {
                hMap.put(a[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {

            if (hMap.containsKey(b[i])) {
                hMap.replace(b[i], hMap.get(b[i]) - 1);
                if (hMap.get(b[i]) <= 0) {
                    hMap.remove(b[i]);
                }
            } else {
                return false;
            }
        }
        if (hMap.isEmpty()) {

            return true;
        } else {
            return false;
        }

    }

    // { Driver Code Starts.

} // } Driver Code Ends


// =============================================
// 
// GFG Editorial
// 
// ============================================


//  Hash the elements of the first array and traverse the second array.
//  While traversing the second array see 
// if all the elements of second array give a hit in the hash.

// public static boolean check(long arr[],long brr[],int n)
// {
//     HashMap<Long, Long> hm = new HashMap<Long, Long>();
//     for(int i = 0;  i< n; i++)
//         {
//             long num = arr[i];
//             if(hm.containsKey(num))
//             {
//                 long freq = hm.get(num);
//                 freq++;
//                 hm.put(num, freq);
//             }
//             else{
//                 hm.put(num, (long)1);
//             }
//         }
    
        
//         // iterating through the elements and decrement the frequency this time
//         for(int i = 0; i < n; i++)
//         {
//             long num = brr[i];
//             if(hm.containsKey(num))
//             {
//                 long freq = hm.get(num);
//                 freq--;
//                 hm.put(num, freq);
//             }
//         }
         
//         boolean flag = false;
        
//         // print 0, if the map doesn't has 0 in it for any value
//         for(Map.Entry<Long, Long> entry: hm.entrySet())
//         {
//             if(entry.getValue() != 0)
//             {
//                 flag = true;
//                 return false;
                
//             }
//         }
        
        
//         return true;
// }
