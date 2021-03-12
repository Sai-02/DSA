/*
Given an array of names (consisting of lowercase characters)
 of candidates in an election. A candidate name in array represents a
  vote casted to the candidate. Print the name of candidate that received Max votes.
   If there is tie, print lexicographically smaller name.

Example 1:

Input:
N = 13
Votes[] = {john,johnny,jackie,johnny,john 
jackie,jamie,jamie,john,johnny,jamie,
johnny,john}
Output: john 4
Explanation: john has 4 votes casted for 
him, but so does johny. john is 
lexicographically smaller, so we print 
john and the votes he received.
Example 2:

Input:
N = 3
Votes[] = {andy,blake,clark}
Output: andy 1
Explanation: All the candidates get 1 
votes each. We print andy as it is 
lexicographically smaller.
Your Task:
You only need to complete the function winner() 
that takes an array of strings arr, and n as
 parameters and returns the name of the candiate 
 with maximum votes and the number of votes the candidate
  got as an array of size 2.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
 */

// { Driver Code Starts
import java.io.*;
import java.util.*;

public class Winner_of_an_election {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String arr[] = new String[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.next();

            Solution3 obj = new Solution3();
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);

        }

    }
}
// } Driver Code Ends

// User function Template for Java

/*
 * class pair { String first; int second; pair(String first , int second) {
 * this.first = first; this.second = second; } }
 */
class Solution3 {
    public static String[] winner(String arr[], int n) {
        String ans[] = { "", "" };
        int maxCount = -1;
        int maxIndex = -1;
        HashMap<String, Integer> hm = new HashMap<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (hm.containsKey(arr[i])) {
                int count = hm.get(arr[i]);
                count++;
                hm.replace(arr[i], count);
                if (count > maxCount) {
                    maxCount = count;
                    maxIndex = i;

                } else if (maxCount == count) {
                    if (arr[maxIndex].compareTo(arr[i]) > 0) {

                        maxIndex = i;
                    }
                }

            } else {
                hm.put(arr[i], 1);
                if (1 > maxCount) {
                    maxCount = 1;
                    maxIndex = i;

                } else if (maxCount == 1) {
                    if (arr[maxIndex].compareTo(arr[i]) > 0) {

                        maxIndex = i;
                    }
                }

            }
        }
        ans[0] += arr[maxIndex];
        ans[1] += hm.get(ans[0]);
        return ans;

    }
}

// =====================================
// 
//  GFG Editorial
// 
// =====================================


// 1. Suggested Reading: map<string, int>
// An efficient solution is to use Hashing. 
// We insert all votes in a hash map and keep track of counts of different names.
//  Finally we traverse the map and print the person with maximum votes.


// class Solution
// {
//     public static String[] winner(String arr[], int n)
//     {
//         // map to store count of frequency of each name
//         HashMap<String, Integer> mp = new HashMap<>();
        
//         // storing the frequency of names in the map
//         for(int i = 0; i < n; i++)
//         {
//             String key = arr[i];
//             if(mp.containsKey(key) == true)
//             {
//                 int freq = mp.get(key);
//                 freq++;
//                 mp.put(key, freq);
//             }else
//             {
//                 mp.put(key, 1);
//             }
//         }
        
//         // Traverse through map to find the candidate 
//         // with maximum votes. 
//         int maxx = 0; 
//         String answer = ""; 
//         for (Map.Entry<String,Integer> entry : mp.entrySet()) 
//         { 
//             String key  = entry.getKey(); 
//             Integer val = entry.getValue(); 
//             if (val > maxx) 
//             { 
//                 maxx = val; 
//                 answer = key; 
//             } 
  
//             // If there is a tie, pick lexicographically 
//             // smaller.  
//             else if (val == maxx && 
//                 answer.compareTo(key) > 0) 
//                 answer = key; 
//         } 
//         String result[] = {answer,maxx+""};
//         return result;
//     }
// }
