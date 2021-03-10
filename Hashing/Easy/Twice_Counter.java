/*
Given a list of N words. 
Count the number of words that appear exactly twice in the list.

Example 1:

Input:
N = 3
list = {Geeks, For, Geeks}
Output: 1
Explanation: 'Geeks' is the only word that 
appears twice. 
Example 2:

Input:
N = 8
list = {Tom, Jerry, Thomas, Tom, Jerry, 
Courage, Tom, Courage}
Output: 2
Explanation: 'Jerry' and 'Courage' are the 
only words that appears twice. 

Your Task:  
You dont need to read input or print anything.
 Complete the function countWords()
  which takes integer N and list of strings
   as input parameters and returns the number of words that appear twice in the list.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)  


Constraints:
1<= N <= 104
 */

// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

public class Twice_Counter {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String list[] = new String[n];
            for (int i = 0; i < n; i++)
                list[i] = sc.next();
            Solution2 ob = new Solution2();
            System.out.println(ob.countWords(list, n));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution2 {
    public int countWords(String list[], int n) {
        int count = 0;
        int length = list.length;
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (hm.containsKey(list[i])) {
                if (hm.get(list[i]) == 2) {
                    count--;
                }
                hm.replace(list[i], hm.get(list[i]) + 1);
                if (hm.get(list[i]) == 2) {
                    count++;
                }
            } else {
                hm.put(list[i], 1);
            }
        }

        return count;
    }
}
