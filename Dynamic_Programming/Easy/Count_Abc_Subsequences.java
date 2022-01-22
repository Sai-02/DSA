
/**
 * 1. You are given a string str.
 * 2. You are required to calculate and print the count of subsequences of the
 * nature a+b+c+.
 * For abbc -> there are 3 subsequences. abc, abc, abbc
 * For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
 * 
 * Constraints
 * 0 < str.length <= 10
 * 
 * Format
 * Input
 * A string str
 * 
 * Output
 * count of subsequences of the nature a+b+c+
 * 
 * Example
 * Sample Input
 * 
 * abcabc
 * 
 * Sample Output
 * 7
 */

import java.util.*;

public class Count_Abc_Subsequences {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int a = 0, ab = 0, abc = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == 'a') {
                a = (2 * a) + 1;
            } else if (c == 'b') {
                ab = (2 * ab) + a;
            } else {
                abc = (2 * abc) + ab;
            }
        }
        System.out.println(abc);
        scan.close();

    }
}

// ==========================================================================================================
//
// Pepcoding Video Lecture:
// https://www.youtube.com/watch?v=IV9pbZsi5cc&t=801s&ab_channel=Pepcoding
//
// ==========================================================================================================