
/**
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ),
 or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).

4. Complete the body of printMazePath function - without changing signature -
 to print the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively 
but that is what the spirit of question is. Write recursive and not iterative logic.
 The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
A number m
Output Format
Print paths (one path in each line) in order hinted by Sample output
Question Video

  COMMENTConstraints
0 <= n <= 5
0 <= m <= 5
Sample Input
3
3
Sample Output
h1h1v1v1
h1h1v2
h1v1h1v1
h1v1v1h1
h1v1d1
h1v2h1
h1d1v1
h2v1v1
h2v2
v1h1h1v1
v1h1v1h1
v1h1d1
v1h2v1
v1v1h1h1
v1v1h2
v1d1h1
v2h1h1
v2h2
d1h1v1
d1v1h1
d1d1
d2




 */

import java.util.*;

public class Print_Maze_Paths_With_Jumps {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        printMazePaths(1, 1, n, m, "");
        scan.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
        }
        if (sr > dr || sc > dc)
            return;
        for (int i = 1; i <= (dc - sc); i++) {
            printMazePaths(sr, sc + i, dr, dc, psf + "h" + i);
        }
        for (int i = 1; i <= (dr - sr); i++) {
            printMazePaths(sr + i, sc, dr, dc, psf + "v" + i);
        }
        for (int i = 1; i <= (dc - sc) && i <= (dr - sr); i++) {
            printMazePaths(sr + i, sc + i, dr, dc, psf + "d" + i);
        }

    }

}