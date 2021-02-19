
// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

public class Merge_k_Sorted_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();
            Solution T = new Solution();
            ArrayList<Integer> arr = T.mergeKArrays(a, n);
            for (int i = 0; i < n * n; i++)
                System.out.print(arr.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/* Complete the function below */
class Solution {
    public static ArrayList<Integer> mergeKArrays(int[][] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            pq.add(a[i][0]);

        }
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < k; j++) {
                pq.add(a[i][j]);

            }
            // ans.add(pq.remove());
        }
        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }
        return ans;

    }
}


// ===========================================================
// 
//  GFG Editorial
// 
// =========================================================



// An efficient solution is to use heap data structure
// . The time complexity of heap based solution is O(N Log k).

// 1. Create an output array.
// 2. Create a min heap of size k and insert 1st element in all the arrays into the heap
// 3. Repeat following steps while priority queue is not empty.
// …..a) Remove minimum element from heap (minimum is always at root)
//  and store it in output array.
// …..b) Insert next element from the array from which the element is extracted.
//  If the array doesn’t have any more elements, then do nothing.

 


// class Solution
// {
//  public static class HeapItem implements Comparable<HeapItem>{
//       int[] array;                
//       int index;        
//       // the index of current element               
      
//       public HeapItem(int[] arr, int index) 
//       {
//            array = arr;
//            this.index=index;
//       }   
//       @Override
//       public int compareTo(HeapItem h)
//       {
//           if(array[index] > h.array[h.index])
//               return 1;
//           else if(array[index] < h.array[h.index])
//               return -1;
//           else
//               return 0;
//       }
//  }
//  public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) {
      
//       // priority queue is heap in Java
//       PriorityQueue<HeapItem> pq = new PriorityQueue<HeapItem>();             
//       // add arrays to the heap
//       for (int i = 0; i < arrays.length; i++) {
//           pq.add(new HeapItem(arrays[i], 0));
//       }
      
//       ArrayList<Integer> result = new ArrayList<Integer>();       
//       while (!pq.isEmpty()) {             
//           HeapItem current = pq.remove();
//           result.add(current.array[current.index]);                       
//           if (current.index < current.array.length-1) 
//           {  
// 			current.index++;
// 			pq.add(current); 
//           }
//      }
//      return result;
//  } 
// }
