
/**
 1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature -
 to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively 
but that is what the spirit of question is.
 Write recursive and not iterative logic. The purpose of the question is to aid 
 learning recursion and not test you.
Input Format
A number n
Output Format
Contents of the arraylist containing paths as shown in sample output
Question Video

  COMMENTConstraints
0 <= n <= 10
Sample Input
3
Sample Output
[111, 12, 21, 3]
 */
import java.util.*;

public class Get_Stair_Paths {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(getStairPaths(n));
        scan.close();

    }

    public static ArrayList<String> getStairPaths(int n) {
        if (n < 0)
            return new ArrayList<String>();
        if (n == 0) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> nm1 = getStairPaths(n - 1);
        ArrayList<String> nm2 = getStairPaths(n - 2);
        ArrayList<String> nm3 = getStairPaths(n - 3);
        ArrayList<String> ans = new ArrayList<>();
        for (String s : nm1) {
            ans.add("1" + s);
        }
        for (String s : nm2) {
            ans.add("2" + s);
        }
        for (String s : nm3) {
            ans.add("3" + s);
        }
        return ans;
    }

}