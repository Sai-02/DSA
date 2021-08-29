
/**
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally 
(as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or 
more steps diagonally (as d1, d2, ..). 
4. Complete the body of getMazePath function - without changing signature
 - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that 
is what the spirit of question is. Write recursive and not iterative logic. 
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
2
2
Sample Output
[h1v1, v1h1, d1]

Pepcoding question link : https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-maze-path-with-jumps-official/ojquestion
 */
import java.util.*;

public class Get_Maze_Path_With_Jumps {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(getMazePaths(1, 1, n, m));
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
        for (int i = 1; i <= dc - sc; i++) {
            ArrayList<String> hor = getMazePaths(sr, sc + i, dr, dc);
            for (String s : hor) {
                ans.add("h" + i + s);
            }

        }
        for (int i = 1; i <= dr - sr; i++) {
            ArrayList<String> ver = getMazePaths(sr + i, sc, dr, dc);
            for (String s : ver) {
                ans.add("v" + i + s);
            }

        }
        for (int i = 1; i <= dr - sr && i <= dc - sc; i++) {
            ArrayList<String> dia = getMazePaths(sr + i, sc + i, dr, dc);
            for (String s : dia) {
                ans.add("d" + i + s);
            }

        }
        return ans;

    }

}