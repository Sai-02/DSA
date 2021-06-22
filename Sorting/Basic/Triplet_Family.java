/*
Given an array A of integers.
 Find three numbers such that sum of two elements equals the third element and
  return the triplet in a container result,
   if no such triplet is found return the container as empty.

Input:
First line of input contains number of testcases.
 For each testcases there will two lines. 
 First line contains size of array and next line contains array elements.

Output:
For each test case output the triplets, if any triplet found from the array,
 if no such triplet is found, output -1.

Your Task: Your task is to complete the function to find triplet and
 return container containing result.

Constraints:
1 <= T <= 100
1 <= N <= 103
0 <= Ai <= 105

Example:
Input:
3
5
1 2 3 4 5
3
3 3 3
6
8 10 16 6 15 25

Output:
1
-1
1

Explanation:
Testcase 1:
Triplet Formed: {2, 1, 3}
Hence 1 
Test Case 2:
Triplet Formed: {}
Hence -1
Test Case 3:
Triplet Formed: {10, 15, 25}
Hence 1

Company Tags
*/

// { Driver Code Starts
import java.util.*;

public class Triplet_Family {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG gfg = new GfG();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = gfg.findTriplet(arr, n);
            if (res.size() != 3)
                System.out.println("-1");
            else {
                Collections.sort(res);
                if (res.get(0) + res.get(1) == res.get(2))
                    System.out.println("1");
                else
                    System.out.println("0");
            }
            // System.out.println();

        }
    }
}
// } Driver Code Ends

class GfG {
    public static ArrayList<Integer> findTriplet(int arr[], int n) {
        ArrayList<Integer> a = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (arr[j] + arr[k] == arr[i]) {
                    a.add(arr[j]);
                    a.add(arr[k]);
                    a.add(arr[i]);
                    return a;
                } else if (arr[j] + arr[k] < arr[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return a;

    }
}

