/*

Given an adjacency list of a graph adj  of V no.
 of vertices having 0 based index. Check whether the graph is bipartite or not.
 

Example 1:

Input: 

Output: 1
Explanation: The given graph can be colored 
in two colors so, it is a bipartite graph.
Example 2:

Input:

Output: 0
Explanation: The given graph cannot be colored 
in two colors such that color of adjacent 
vertices differs. 
 

Your Task:
You don't need to read or print anything. 
Your task is to complete the function isBipartite()
 which takes V denoting no. of vertices and adj denoting adjacency
  list of graph and returns a boolean value true if graph is bipartite 
  otherwise returns false.
 

Expected Time Complexity: O(V)
Expected Space Complexity: O(V)

Constraints:
1 ≤ V, E ≤ 105

Company Tags
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Bipartite_Graph {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

// ====================================================
//
// BFS Approach
//
// ===================================================

class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V + 1];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                q.add(i);
                while (!q.isEmpty()) {
                    int node = q.remove();
                    for (Integer j : adj.get(node)) {
                        if (color[j] == -1) {
                            color[j] = 1 - color[node];
                            q.add(j);
                        } else if (color[node] == color[j]) {
                            return false;
                        }
                    }

                }

            }
        }

        return true;
    }
}

// ==============================================
//
// DFS Approach
//
// ===============================================

class Solution1 {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V + 1];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!checkBP(adj, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkBP(ArrayList<ArrayList<Integer>> adj, int color[], int node) {
        for (Integer i : adj.get(node)) {
            if (color[i] == -1) {
                color[i] = 1 - color[node];
                if (!checkBP(adj, color, i)) {
                    return false;
                }
            } else if (color[i] == color[node]) {
                return false;
            }
        }
        return true;

    }
}