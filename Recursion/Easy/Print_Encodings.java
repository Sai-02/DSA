
/**
 * 1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
Use the input-output below to get more understanding on what is required
123 -> abc, aw, lc
993 -> iic
013 -> Invalid input. A string starting with 0 will not be passed.
103 -> jc
303 -> No output possible. But such a string maybe passed.
 In this case print nothing.

Note -> The online judge can't force you to write the function recursively 
but that is what the spirit of question is. Write recursive and not iterative logic.
 The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Permutations of str in order hinted by Sample output
Question Video

  COMMENTConstraints
0 <= str.length <= 10
Sample Input
655196

Sample Output
feeaif
feesf

 */

import java.util.*;

public class Print_Encodings {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        printEncodings(str, "");
        scan.close();
    }

    public static void printEncodings(String str, String ans) {
        if (str.equals("")) {
            System.out.println(ans);
            return;
        }
        if (str.charAt(0) == '0')
            return;

        char c1 = getCode(Integer.parseInt("" + str.charAt(0)));
        printEncodings(str.substring(1), ans + c1);

        if (str.length() >= 2) {

            int n = Integer.parseInt(str.substring(0, 2));
            if (n <= 26) {
                printEncodings(str.substring(2), ans + getCode(n));
            }
        }

    }

    public static char getCode(int i) {
        return (char) (i + 96);
    }

}