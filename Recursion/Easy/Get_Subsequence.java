/**
 1. You are given a string str.
 2. Complete the body of getSS function - without changing signature - 
 to calculate all subsequences of str.
 Use sample input and output to take idea about subsequences.

 Note -> The online judge can't force you to write the function recursively but that
 is what the spirit of question is.
 Write recursive and not iterative logic. The purpose of the question is to aid 
 learning recursion and not test you.
 Input Format
 A string str
 Output Format
 Contents of the arraylist containing subsequences as shown in sample output

0 <= str.length <= 20
Sample Input
abc
Sample Output
[, c, b, bc, a, ac, ab, abc]
 */
import java.util.*;

public class Get_Subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(gss(str));
        scan.close();
    }

    public static ArrayList<String> gss(String str) {
        if (str.equals("")) {
            ArrayList<String> rawAns = new ArrayList<>();
            rawAns.add("");
            return rawAns;
        }
        ArrayList<String> rawAns = gss(str.substring(1));
        char c = str.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        int n = rawAns.size();
        for (int i = 0; i < n; i++) {
            ans.add("" + rawAns.get(i));
        }
        for (int i = 0; i < n; i++) {
            ans.add(c + rawAns.get(i));
        }
        return ans;

    }

}
// =================================================================================================================================================
// 
// Pepcoding Video Link : https://www.youtube.com/watch?v=Sa5PmCFF_zI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=25&ab_channel=Pepcoding
// 
// =================================================================================================================================================