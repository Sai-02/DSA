
/*
Given a N x N matrix, where every row and column is sorted in non-decreasing order.
 Find the kth smallest element in the matrix.

Example 1:
Input:
N = 4
mat[][] =     {{16, 28, 60, 64},
                   {22, 41, 63, 91},
                   {27, 50, 87, 93},
                   {36, 78, 87, 94 }}
K = 3
Output: 27
Explanation: 27 is the 3rd smallest element.
 

Example 2:
Input:
N = 4
mat[][] =     {{10, 20, 30, 40}
                   {15, 25, 35, 45}
                   {24, 29, 37, 48}
                   {32, 33, 39, 50}}
K = 7
Output: 30
Explanation: 30 is the 7th smallest element.


Your Task:
You don't need to read input or print anything. 
Complete the function kthsmallest() which takes the mat, 
N and K as input parameters and returns the kth smallest element in the matrix.
 

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 50
1 <= mat[][] <= 10000
1 <= K <= N*N

 

Company Tags
 */

// /{
// Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Kth_element_in_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while (t > 0) {
            int n = Integer.parseInt(sc.next());
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = Integer.parseInt(sc.next());

            int k = Integer.parseInt(sc.next());
            Solution3 ob = new Solution3();
            System.out.println(ob.kthSmallest(a, n, k));

            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution3 {
    public static int kthSmallest(int[][] mat, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() < k) {
                    pq.add(mat[i][j]);
                } else {
                    if (mat[i][j] < pq.peek()) {
                        pq.remove();
                        pq.add(mat[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
}


// ================================================
// 
//  GFG Editorial
// 
// ==============================================


// class Solution
// { 
	
// // A structure to store entry of heap. 
// // The entry contains value from 2D array, 
// // row and column numbers of the value 
// static class HeapNode 
// { 
	
// 	// Value to be stored 
// 	int val; 
	
// 	// Row number of value in 2D array 
// 	int r; 
	
// 	// Column number of value in 2D array 
// 	int c; 
	
// 	HeapNode(int val, int r, int c) 
// 	{ 
// 		this.val = val; 
// 		this.c = c; 
// 		this.r = r; 
// 	} 
// } 

// // A utility function to swap two HeapNode items. 
// static void swap(int i, int min, HeapNode[] arr) 
// { 
// 	HeapNode temp = arr[i]; 
// 	arr[i] = arr[min]; 
// 	arr[min] = temp; 
// } 

// // A utility function to minheapify the node 
// // harr[i] of a heap stored in harr[] 
// static void minHeapify(HeapNode harr[], 
// 					int i, int heap_size) 
// { 
// 	int l = 2 * i + 1; 
// 	int r = 2 * i + 2; 
// 	int min = i; 
	
// 	if (l < heap_size && 
// 		harr[l].val < harr[i].val) 
// 	{ 
// 		min = l; 
// 	} 
// 	if (r < heap_size && 
// 		harr[r].val < harr[min].val) 
// 	{ 
// 		min = r; 
// 	} 
	
// 	if (min != i) 
// 	{ 
// 		swap(i, min, harr); 
// 		minHeapify(harr, min, heap_size); 
// 	} 
// } 

// // A utility function to convert 
// // harr[] to a max heap 
// static void buildHeap(HeapNode harr[], int n) 
// { 
// 	int i = (n - 1) / 2; 
// 	while (i >= 0) 
// 	{ 
// 		minHeapify(harr, i, n); 
// 		i--; 
// 	} 
// } 

// // This function returns kth smallest 
// // element in a 2D array mat[][] 
// public static int kthSmallest(int[][] mat, int n, int k) 
// { 
	
// 	// k must be greater than 0 and 
// 	// smaller than n*n 
// 	if (k <= 0 || k > n * n) 
// 	{ 
// 		return Integer.MAX_VALUE; 
// 	} 
	
// 	// Create a min heap of elements 
// 	// from first row of 2D array 
// 	HeapNode harr[] = new HeapNode[n]; 
	
// 	for(int i = 0; i < n; i++) 
// 	{ 
// 		harr[i] = new HeapNode(mat[0][i], 0, i); 
// 	} 
// 	buildHeap(harr, n); 
	
// 	HeapNode hr = new HeapNode(0, 0, 0); 
	
// 	for(int i = 0; i < k; i++) 
// 	{ 
		
// 		// Get current heap root 
// 		hr = harr[0]; 
		
// 		// Get next value from column of root's 
// 		// value. If the value stored at root was 
// 		// last value in its column, then assign 
// 		// INFINITE as next value 
// 		int nextVal = hr.r < n - 1 ? 
// 					mat[hr.r + 1][hr.c] : 
// 					Integer.MAX_VALUE; 
						
// 		// Update heap root with next value 
// 		harr[0] = new HeapNode(nextVal, 
// 							hr.r + 1, hr.c); 
								
// 		// Heapify root 
// 		minHeapify(harr, 0, n); 
// 	} 
	
// 	// Return the value at last extracted root 
// 	return hr.val; 
// }
// }