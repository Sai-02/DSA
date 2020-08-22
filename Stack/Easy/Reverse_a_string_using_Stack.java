/*
An string of words is given, the task is to reverse the string using stack.

Input Format:
The first line of input will contains an integer T denoting the no of test cases . 
Then T test cases follow.
 Each test case contains a string s of words without spaces.

Output Format:
For each test case ,print the reverse of the string in new line. 

Your Task:
Since this is a function problem, you don't need to take any input. 
Just complete the provided function.

Constraints:
1 <= T <= 100
1 <= length of the string <= 100

Example:
Input:
2
GeeksQuiz
GeeksforGeeks
Output:
ziuQskeeG
skeeGrofskeeG 
*/
// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Reverse_a_string_using_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Solution obj = new Solution();
            obj.reverse(sc.next());
        }
    }
}
// } Driver Code Ends

class Solution {

    public void reverse(String str) {
        Stack<Character> a = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            a.push(str.charAt(i));

        }
        while (!a.empty()) {
            System.out.print(a.pop());
        }
        System.out.println();

    }

}