
/**
 * 1. You are given a string str.
2. Complete the body of printPermutations function - without changing signature - to calculate and print all permutations of str.
Use sample input and output to take idea about permutations.

Note -> The online judge can't force you to write the function recursively but 
that is what the spirit of question is. Write recursive and not iterative logic.
 The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Permutations of str in order hinted by Sample output
Question Video

  COMMENTConstraints
0 <= str.length <= 7
Sample Input
abc
Sample Output
abc
acb
bac
bca
cab
cba


Asked in Companies
Related Topics
 */

import java.util.*;

public class Print_Permutations {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        printPermutations(str, "");
        scan.close();
    }

    public static void printPermutations(String str, String asf) {
        if (str.equals("")) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            printPermutations(str.substring(0, i) + str.substring(i + 1), asf + c);
        }

    }

}