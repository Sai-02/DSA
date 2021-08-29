
/**
 1. You are given a string str.
2. Complete the body of printSS function - without changing signature - 
to calculate and print all subsequences of str.
Use sample input and output to take idea about subsequences.

Note -> The online judge can't force you to write the
 function recursively but that is what the spirit of question is.
  Write recursive and not iterative logic.
   The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Subsequences of str in order hinted by Sample output
Question Video

  COMMENTConstraints
0 <= str.length <= 7
Sample Input
yvTA

Sample Output
yvTA
yvT
yvA
yv
yTA
yT
yA
 */
import java.util.*;

public class Print_Subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        printSS(str, "");
        scan.close();

    }

    public static void printSS(String str, String ans) {
        if (str.equals("")) {
            System.out.println(ans);
            return;
        }
        char c = str.charAt(0);
        printSS(str.substring(1), ans + c);
        printSS(str.substring(1), ans);
    }

}

/**
 * Printing the subsequence is much more efficient then storing them in a
 * arraylist as it might take 30 GB of space for a string of 30 characters See
 * this video :
 * https://www.youtube.com/watch?v=Ke8TPhHdHMw&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=34&ab_channel=Pepcoding
 */