/*
Given an array arr[] of N numbers.
 The task is to print only those numbers whose digits 
 are from set {1,2,3}.

Example 1:

Input:
N = 3
arr[] = {4,6,7}
Output: -1
Explanation: No elements are there in the 
array which contains digits 1, 2 or 3.
Example 2:

Input:
N = 4
arr[] = {1,2,3,4}
Output: 1 2 3
Explanation: 1, 2 and 3 are the only 
elements in the array which conatins 
digits as 1, 2 or 3.
Your Task:
Complete findAll function and marked satisfied number as
 '1' in the map mp in range 1 to 1000000. If no number is 
 marked as satified number -1 will automatically be printed by 
 the drivers code. The driver code prints the elements in sorted order.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 <= N <= 106
1 <= A[i] <= 106

 

 

Company Tags
 */

// { Driver Code Starts
// Initial Template for Java

/* package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.awt.Point;
import java.util.Arrays;
import java.util.Vector;

public class Numbers_containing_1_2_and_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        findAll();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            Arrays.sort(arr);
            boolean flag = false;
            for (int x : arr) {
                if (mp.containsKey(x)) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }

            if (flag == false)
                System.out.print(-1);
            System.out.println();
        }

    }

    static HashMap<Integer, Integer> mp = new HashMap<>();

    // } Driver Code Ends
    // User function Template for Java

    public static void findAll() {
        for (int i = 1; i <= 1000000; i++) {
            String str = i + "";
            int length = str.length();
            boolean otherThan123 = false;
            for (int j = 0; j < length; j++) {
                char c = str.charAt(j);
                if (c == '1' || c == '2' || c == '3') {
                    continue;
                } else {
                    otherThan123 = true;
                }
            }
            if (!otherThan123) {
                mp.put(i, 1);
            }
        }

    }

    // { Driver Code Starts.

} // } Driver Code Ends


// ==========================================
// 
// GFG Editorial
// 
// ===========================================

// Hash all the numbers that can be generated using the digits 1, 2, and 3.
// Traverse the input array and jjust see if the array element exists in the hash.

// public static void findAll()
// {
//     int num=1,num2;
//     ArrayList<Integer> a=new ArrayList<>(); 
//     int j=1;
//     a.add(j);
//     a.add(j+1);
//     a.add(j+2);
//     mp.put(1,1);
//     mp.put(2,1);
//     mp.put(3,1);
    
//     j=0;
    
//     // push the elements which have digits as 1, 2, and 3 only
//     while(num<=1000000)
//     {
//     num2=a.get(j++);
    
//     if((num2*10)+1<=1000000){
//         a.add((num2*10)+1);
//         mp.put(num2*10+1,1);
//     }
    
//     if((num2*10)+2<=1000000){
//         a.add((num2*10)+2);
//         mp.put(num2*10+2,1);
//     }
    
//     num2=(num2*10)+3;
    
//     if(num2<=1000000){
//         a.add(num2);
//         mp.put(num2,1);
//     }
    
//     num=num2;
//     }
// }
  
      
