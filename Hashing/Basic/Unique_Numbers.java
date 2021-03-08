/*
In the given range [L, R], print all numbers having unique digits.
 e.g. In range 10 to 20 should print all numbers except 11.

Example 1:

Input:
L = 10
R = 20

Output:
10 12 13 14 15 16 17 18 19 20

Explanation:
The number 11 has two 1 therefore
11 is not a unique number.
Example 2:

Input:
L = 1
R = 9

Output:
1 2 3 4 5 6 7 8 9

Explanation:
All the Numbers are unique.
Your Task:  
You don't need to read input or print anything.
 Your task is to complete the function uniqueNumbers()
  which takes two integers L and R as an input parameter
   and returns the list/vector of all the unique numbers present between L to R.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= L <= R <= 104

 

Company Tags
 */

// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class Unique_Numbers {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int l = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> numbers = ob.uniqueNumbers(l, r);
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();

        }
    }
}
// } Driver Code Ends

class Solution {

    static ArrayList<Integer> uniqueNumbers(int L, int R) {
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = L; i <= R; i++) {
            if (isUnique(i)) {
                a.add(i);
            }

        }
        return a;
    }

    static boolean isUnique(int n) {
        HashSet<Character> h = new HashSet<>();
        String str = "";
        str += n;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (h.contains(c)) {
                return false;
            } else {
                h.add(c);
            }

        }
        return true;
    }
}