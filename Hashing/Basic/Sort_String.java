/*
Given a string of lowercase characters from ‘a’ – ‘z’. We need to write a program to print the characters of this string in sorted order.

Input:
The first line contains an integer T, denoting number of test cases. Then T test case follows. First line of each test case contains a string S each.

Output:
For each test case, print the string S in sorted order.

Constraints:
1<=T<=100
1<=|S|<=4*10^4
String S will contains lowercase character from 'a'-'z

Example:
Input:
2
bbccdefbbaa
geeksforgeeks
Output :
aabbbbccdef
eeeefggkkorss

Topic Tags

If you are facing any issue on this page. Please let us know.

 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Sort_String {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            int freq[] = new int[26];
            for (int i = 0; i < 26; i++) {
                freq[i] = 0;
            }
            String str = scan.nextLine();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                int index = str.charAt(i);
                index = index - 97;
                freq[index]++;
            }
            String ans = "";
            for (int i = 0; i < 26; i++) {
                while (freq[i]-- > 0) {
                    ans = ans + (char) (i + 97);
                }
            }
            System.out.println(ans);

        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}