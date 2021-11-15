
/**
 * 1. You are given a number n. 2. You are required to print the number of
 * binary strings of length n with no consecutive 0's. Input Format A number n
 * Output Format A number representing the number of binary strings of length n
 * with no consecutive 0's. Question Video
 * 
 * COMMENTConstraints 0 < n <= 45 Sample Input 6 Sample Output 21
 * 
 * 
 */
import java.util.*;

public class Count_Binary_Strings {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count0 = 1;
        int count1 = 1;
        for (int i = 1; i < n; i++) {
            int newCount0 = count1;
            int newCount1 = count0 + count1;
            count0 = newCount0;
            count1 = newCount1;
        }
        System.out.println(count0 + count1);
        scan.close();
    }

}

// =================================================================================
//
// Explanation: https://www.youtube.com/watch?v=nqrXHJWMeBc&ab_channel=Pepcoding
//
// =================================================================================