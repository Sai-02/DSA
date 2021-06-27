/*
Given an array of integers, sort the array according to frequency of elements.
 That is elements that have higher frequency come first. If frequencies of
  two elements are same, then smaller number comes first.

Example 1:

Input:
N = 5
A[] = {5,5,4,6,4}
Output: 4 4 5 5 6
Explanation: The highest frequency here is
2. Both 5 and 4 have that frequency. Now
since the frequencies are same then 
smallerelement comes first. So 4 4 comes 
firstthen comes 5 5. Finally comes 6.
The output is 4 4 5 5 6.
Example 2:

Input:
N = 5
A[] = {9,9,9,2,5}
Output: 9 9 9 2 5
Explanation: The highest frequency here is
3. The element 9 has the highest frequency
So 9 9 9 comes first. Now both 2 and 5
have same frequency. So we print smaller
element first.
The output is 9 9 9 2 5.
Your Task:

You only need to complete the function sortByFreq that takes arr,
 and n as parameters and returns the sorted array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N). 

Constraints:
1 ≤ N ≤ 105
1 ≤ Ai ≤ 105 

 

Company Tags
Topic Tags
*/
// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

public class Sorting_Elements_of_an_Array_by_Frequency {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            int size = Integer.parseInt(sc.readLine());
            int arr[] = new int[size];
            String[] temp = sc.readLine().trim().split("\\s+");

            for (int i = 0; i < size; i++)
                arr[i] = Integer.parseInt(temp[i]);

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution3().sortByFreq(arr, size);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution3 {
    // Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                hm.replace(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        quickSort(arr, 0, n - 1, hm);
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(arr[i]);
        }
        return a;
    }

    static void quickSort(int a[], int l, int h, HashMap<Integer, Integer> hm) {
        if (l >= h) {
            return;
        }
        int pivot = a[h];
        int pivotIndex = partition(a, l, h, pivot, hm);
        quickSort(a, l, pivotIndex - 1, hm);
        quickSort(a, pivotIndex, h, hm);

    }

    static int partition(int a[], int l, int h, int pivot, HashMap<Integer, Integer> hm) {
        int i = l, j = l;
        while (i <= h) {
            if (hm.get(a[i]) < hm.get(pivot)) {
                i++;

            } else if (hm.get(a[i]) > hm.get(pivot)) {
                swap(a, i, j);
                i++;
                j++;
            } else {
                if (a[i] > pivot) {
                    i++;
                } else {
                    swap(a, i, j);
                    i++;
                    j++;
                }
            }
        }
        return (j - 1);

    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}