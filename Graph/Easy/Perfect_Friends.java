
/**
 * 1. You are given a number n (representing the number of students). Each
 * student will have an id
 * from 0 to n - 1.
 * 2. You are given a number k (representing the number of clubs)
 * 3. In the next k lines, two numbers are given separated by a space. The
 * numbers are ids of
 * students belonging to same club.
 * 4. You have to find in how many ways can we select a pair of students such
 * that both students are
 * from different clubs.
 * 
 * Constraints
 * None
 * 
 * Format
 * Input
 * Input has been managed for you
 * 
 * Output
 * Check the sample output
 * 
 * Example
 * Sample Input
 * 
 * 7
 * 5
 * 0 1
 * 2 3
 * 4 5
 * 5 6
 * 4 6
 * 
 * Sample Output
 * 16
 * 
 * Question Video
 * 
 * Play Video
 * Related Resources
 */

import java.io.*;
import java.util.*;

public class Perfect_Friends {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        for (int i = 0; i < k; i++) {
            String str[] = br.readLine().split(" ");
            int v1 = Integer.parseInt(str[0]), v2 = Integer.parseInt(str[1]);
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        ArrayList<ArrayList<Integer>> cc = new ArrayList<>();
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> ans = new ArrayList<>();
                getCC(i, visited, adj, ans);
                cc.add(ans);
            }
        }
        int pair = 0;
        for (int i = 0; i < cc.size(); i++) {
            for (int j = i + 1; j < cc.size(); j++) {
                pair += cc.get(i).size() * cc.get(j).size();
            }
        }
        System.out.println(pair);

    }

    public static void getCC(int src, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        if (visited[src])
            return;
        visited[src] = true;
        ans.add(src);
        for (int nbr : adj.get(src)) {
            getCC(nbr, visited, adj, ans);
        }

    }

}