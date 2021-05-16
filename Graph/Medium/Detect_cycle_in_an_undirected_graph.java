/*
Given an undirected graph with V vertices and E edges,
 check whether it contains any cycle or not. 

Example 1:

Input:   

Output: 1
Explanation: 1->2->3->4->1 is a cycle.
Example 2:

Input: 

Output: 0
Explanation: No cycle in the graph.
 

Your Task:
You don't need to read or print anything.
 Your task is to complete the function isCycle()
  which takes V denoting the number of vertices and adjacency
   list as input parameters and returns a boolean value denoting
    if the undirected graph contains any cycle or not.
 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 

Constraints:
1 ≤ V, E ≤ 105

Company Tags
Topic Tags
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Detect_cycle_in_an_undirected_graph{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends




// ============================================
// 
// BFS Approach
// 
// ==============================================


class Pair {
    int data;
    int parent;

    Pair(int data, int parent) {
        this.data = data;
        this.parent = parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V + 1];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {

                Pair newPair = new Pair(i, -1);
                visited[i] = true;
                q.add(newPair);
                while (!q.isEmpty()) {
                    Pair node = q.remove();
                    for (int j = 0; j < adj.get(node.data).size(); j++) {
                        if (!visited[adj.get(node.data).get(j)]) {
                            visited[adj.get(node.data).get(j)] = true;
                            Pair pair = new Pair(adj.get(node.data).get(j), node.data);
                            q.add(pair);
                        } else if (node.parent != adj.get(node.data).get(j)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}




// ===============================================
// 
// DFS Approach
// 
// ===============================================


