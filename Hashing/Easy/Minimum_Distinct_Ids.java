/*
Given an array of items, the i'th index element denotes the item id’s
 and given a number m, the task is to remove m elements such that
  there should be minimum distinct id’s left. Print the number of distinct id’s.

Example 1 -

Input:
n = 6
arr[] = {2, 2, 1, 3, 3, 3}
m = 3
Output:
1
Explanation : 
Remove 2,2,1
Example 2 -

Input:
n = 8
arr[] = {2, 4, 1, 5, 3, 5, 1, 3}
m = 2
Output:
3
Explanation:
Remove 2,4
Your Task:
This is a function problem.
 You don't have to take any input. 
 Your task is to complete the distinctIds()
  which takes sorted array, its size n, and m as its parameter. 
  You only need to find the minimum number of distinct IDs and return it.
   The driver code will print the returned value.

Expected Time Complexity: O(n log(n))
Expected Auxillary Space: O(n)

Constraints:
1 ≤ n ≤ 100
1 ≤ arr[i] ≤ 106
1 ≤ m ≤ 100
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class Minimum_Distinct_Ids {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int m = sc.nextInt();

            System.out.println(new Solution11().distinctIds(arr, n, m));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution11 {
    int distinctIds(int arr[], int n, int m) {
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
        Collection<Integer> v = hm.values();
        ArrayList<Integer> a = new ArrayList<>(v);
        Collections.sort(a);
        int count = 0;
        n = a.size();
        for (int i = 0; i < n; i++) {
            if (m >= a.get(i)) {
                m = m - a.get(i);
                count++;
            } else {
                break;
            }
        }
        return a.size() - count;

    }
}

// ==================================
// 
// GFG Editorial
// 
// =================================

// Try counting the distinct IDs and sort them in increasing order.


// class Solution
// {
//     int distinctIds(int arr[], int n, int m)
//     {
//         HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
//         ArrayList<Integer> a = new ArrayList<Integer>();
//     	int count = 0;
    
//     	// Store the occurrence of ids
//     	for (int i = 0; i < n; i++)
//         {
//     		if (mp.containsKey(arr[i]))
//     		{
//     		    int val = mp.get(arr[i]);
//     		    mp.put(arr[i], val + 1);
//     		}
//     		else 
//     		{
//     		    mp.put(arr[i], 1);
//     		}
//         }
    
//     	// Store into the ArrayList frequencies of unique IDs
//     	Iterator it = mp.entrySet().iterator();
//     	while (it.hasNext())
//     	{
//     	    Map.Entry me = (Map.Entry)it.next();
//     	    a.add((Integer)me.getValue());
//     	}
    	
//     	// Sort the ArrayList
//     	Collections.sort(a);
//     	int size = a.size();
    
//     	// Start removing elements from the beginning
//     	for (int i = 0; i < size; i++) {
    
//     		// Remove if current value is less than 
//     		// or equal to 
//     		if (a.get(i) <= m) {
//     			m -= a.get(i);
//     			count++;
//     		}
//     		// Return the remaining size
//     		else
//     			break;
//     	}
//     	return size - count;
//     }
// }
