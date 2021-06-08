
/*
You are given an array arr[] of N integers including 0. 
The task is to find the smallest positive number missing from the array.

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.
Your Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number
 in the array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
-106 <= arr[i] <= 106

 

Company Tags
Topic Tags
Related Courses
Related Interview Experiences
 */
// { Driver Code Starts
import java.util.*;

// } Driver Code Ends

class Solution4 {
    // Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                arr[i] = size + 7;
            }
        }
        for (int i = 0; i < size; i++) {
            int z = Math.abs(arr[i]);
            if (z <= size) {
                if (arr[z - 1] > 0) {
                    arr[z - 1] *= -1;
                }

            }

        }
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return size + 1;

    }
}

// { Driver Code Starts.

public class Smallest_Positive_missing_number {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking testcases
        int t = sc.nextInt();
        while (t-- > 0) {

            // input number n
            int n = sc.nextInt();
            int[] arr = new int[n];

            // adding elements to the array
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            Solution4 obj = new Solution4();

            // calling missingNumber()
            int missing = obj.missingNumber(arr, n);
            System.out.println(missing);
        }
    }
}

// } Driver Code Ends

// ==============================================================
// 
// GFG Editorial
// 
// ==============================================================



// 1. Segregate Positive and Negative Numbers in the array.

// 2. Traverse all the Positive Numbers, 
//      i) If the number is larger than the input array size, do nothing.
//      ii) Else, the number is within input array size limit, consider number as array index, and mark the element at that index Negative.

// 3. After doing the above operation, Traverse the array with initial Positive values again, and store the first occurrence of index, whose value is Non-          Negative. (Because this means that index value was not present in the array)

// 4. This stored element is the Result.


// class Solution
// {
//     //Function that puts all non-positive (0 and negative) numbers on left 
//     //side of arr[] and return count of such numbers.
//     static int segregate (int arr[], int size)
//     {
//         int j = 0, i;
//         for(i = 0; i < size; i++)
//         {
//            if (arr[i] <= 0)  
//            {
//                int temp;
//                //changing the position of negative numbers and 0.
//                temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                //incrementing count of non-positive integers.
//                j++;  
//            }
//         } 
//         return j;
//     }
    
//     //Finding the smallest positive missing number in an array 
//     //that contains only positive integers.
//     static int findMissingPositive(int arr[], int size)
//     {
//         int i;
//         //marking arr[i] as visited by making arr[arr[i] - 1] negative. 
//         //note that 1 is subtracted because indexing starts from 0 and 
//         //positive numbers start from 1.
//         for(i = 0; i < size; i++)
//         {
//             if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
//             arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
//         }
        
//         for(i = 0; i < size; i++)
//         {
//             if (arr[i] > 0)
//             {
//                 //returning the first index where value is positive.
//                 // 1 is added because indexing starts from 0.
//                 return i+1;
//             }
//         }
//         return size+1;
//     }
    
//     //Function to find the smallest positive number missing from the array.
//     static int missingNumber(int arr[], int size)
//     {
//         //first separating positive and negative numbers. 
//         int shift = segregate (arr, size);
        
//         int arr2[] = new int[size-shift];
//         int j=0;
//         //shifting the array to access only positive part.
//         for(int i=shift;i<(size);i++)
//         {
//             arr2[j] = arr[i];
//             j++;
//         }
        
//         //calling function to find result and returning it.
//         return findMissingPositive(arr2, j);
//     }
    
// }

