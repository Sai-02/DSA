
/*
Given a string s of lowercase alphabets and a number k,
 the task is to print the minimum value of the string after removal 
 of ‘k’ characters. The value of a string is defined as the sum of 
 squares of the count of each distinct character.
 

Example 1:

Input: s = abccc, k = 1
Output: 6
Explaination:
We remove c to get the value as 12 + 12 + 22
 

Example 2:

Input: s = aabcbcbcabcc, k = 3
Output: 27
Explaination: We remove two 'c' and one 'b'. 
Now we get the value as 32 + 32 + 32.

Your Task:
You do not need to read input or print anything.
 Your task is to complete the function minValue() 
 which takes s and k as input parameters and returns
  the minimum possible required value.

 

Expected Time Complexity: O(N*logN)  where N is the length of string
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ k ≤ |string length| ≤ 100
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Game_with_String {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    static int minValue(String s, int k) {
        int a[] = new int[26];
        for (int i = 0; i < 26; i++) {
            a[i] = 0;
        }
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i);
            index = index - 97;
            a[index]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            pq.add(a[i]);

        }
        while (k-- > 0) {
            int value = pq.remove();
            if (value != 0) {
                value--;
                pq.add(value);
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum = sum + (int) Math.pow(pq.remove(), 2);

        }
        return sum;

    }
}
// ======================================================
// 
//  GFG Editorial
// 
// ======================================================


// The value is minimum when the maximum value is as low as possible.

// Use the concept of max heap.


// class Solution{
//     static int minValue(String s,int k){
//         int freq[] = new int[26];
//         for(int i = 0;i < s.length();i++)
// 			freq[s.charAt(i)-'a']++;
// 		PriorityQueue<Integer> p=new PriorityQueue(s.length(), new Comparator<Integer>(){
// 			public int compare(Integer i1,Integer i2){
// 				return i2-i1;
// 			}
// 		});
// 		for(int i = 0;i < 26;i++)
// 		    p.add(freq[i]);
// 	    while(k-- > 0){
// 		    int temp = p.peek();
// 		    p.poll();
// 		    temp = temp - 1;
// 		    p.add(temp);
// 		}
// 		int result = 0;
// 		while(!p.isEmpty()){
// 		    int x = p.peek();
// 		    result += (x*x);
// 		    p.poll();
// 		}
// 		return result;
//     }
// }
