/*
Find the first non-repeating element in a given array arr of N integers.
Note: Array consists of only positive and negative integers and not zero.

Example 1:

Input : arr[] = {-1, 2, -1, 3, 2}
Output : 3
Explanation:
-1 and 2 are repeating whereas 3 is 
the only number occuring once.
Hence, the output is 3. 
 

Example 2:

Input : arr[] = {1, 1, 1}
Output : 0

Your Task:
This is a function problem.
 The input is already taken care of by the driver code. 
 You only need to complete the function firstNonRepeating()
  that takes an array (arr), sizeOfArray (n), 
  and returns the first non-repeating element. 
  The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 107
-1016 <= Ai <= 1016
{Ai !=0 }

 */

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Non_Repeating_Element {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        while (testcases-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];

            String line = br.readLine();
            String[] elements = line.trim().split(" ");

            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(elements[index]);
            }

            Check obj = new Check();

            System.out.println(obj.firstNonRepeating(arr, n));

        }

    }
}

// } Driver Code Ends

// User function Template for Java

class Check {

    public int firstNonRepeating(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                int count = hm.get(arr[i]);
                count++;
                hm.replace(arr[i], count);

            } else {
                hm.put(arr[i], 1);

            }

        }
        for (int i = 0; i < n; i++) {
            if (hm.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return 0;
    }

}
