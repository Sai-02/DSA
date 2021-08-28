
/**
 1. You are given a number n and a number m representing number of rows and columns
  in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner.
 Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature - to get
 the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but 
that is what the spirit of question is. Write recursive and not iterative logic.
 The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
A number m
Output Format
Contents of the arraylist containing paths as shown in sample output
Question Video

  COMMENTConstraints
0 <= n <= 10
0 <= m <= 10
Sample Input
3
3
Sample Output
[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
 */

import java.util.*;

public class Get_Maze_Paths {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(getMazePaths(0, 0, n - 1, m - 1));
        scan.close();

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList<String> ans = new ArrayList<>();
        if (sr == dr && sc == dc) {
            ans.add("");
            return ans;
        }
        if (sr > dr || sc > dc) {
            return ans;
        }
        ArrayList<String> ver = getMazePaths(sr + 1, sc, dr, dc);
        ArrayList<String> hor = getMazePaths(sr, sc + 1, dr, dc);
        for (String s : hor) {
            ans.add("h" + s);
        }
        for (String s : ver) {
            ans.add("v" + s);
        }
        return ans;

    }

}