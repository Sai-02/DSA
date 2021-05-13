/*
Given a directed graph with V nodes and E edges.
 If there is an edge from u to v then u depends on v. 
 Find out the sum of dependencies for every node. 
 Duplicate edges should be counted as separate edges.

Example 1:

Input:
V=4
E=4
Edges={ {0,2},{0,3},{1,3},{2,3} }




Output:
4
Explanation:
For the graph in diagram, A depends
on C and D i.e. 2, B depends on D i.e.
1, C depends on D i.e. 1
and D depends on none.
Hence answer -> 0 + 1 + 1 + 2 = 4
Example 2:

Input:
V=4
E=3
Edges={ {0,3},{0,2},{0,1} }
Output:
3
Explanation:
The sum of dependencies=3+0+0+0=3.

Your Task:
You don't need to read input or print anything.
Your task is to complete the function sumOfDependencies()
 which takes the adj (Adjacency list) and V (Number of nodes)as
  input parameters and returns the total sum of dependencies of all nodes.


Expected Time Complexity:O(V)
Expected Auxillary Space:O(1)


Constraints:
1<=V,E<=150

0<= Edges[i][0],Edges[i][1] <= V-1
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Sum_of_dependencies_in_graph {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(N);
            for (int i = 0; i < N; i++)
                adj.add(new ArrayList<Integer>());
            String S1[] = read.readLine().split(" ");
            for (int i = 0; i < 2 * M; i += 2) {
                x = Integer.parseInt(S1[i]);
                y = Integer.parseInt(S1[i + 1]);
                adj.get(x).add(y);
            }
            Solution ob = new Solution();
            System.out.println(ob.sumOfDependencies(adj, N));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        int sum = 0;
        for (int i = 0; i < adj.size(); i++) {
            sum += adj.get(i).size();
        }
        return sum;
    }
}

// ==========================================
//
// GFG Editorial
//
// ==========================================

// The sum of dependencies depends upon the number of edges attached to each
// node.