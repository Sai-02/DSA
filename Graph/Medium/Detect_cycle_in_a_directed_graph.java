
/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
 check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You don’t need to read input or print anything.
 Your task is to complete the function isCyclic()
  which takes the integer V denoting the number of
   vertices and adjacency list as input parameters
    and returns a boolean value denoting if the given
     directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105

Company Tags
 */
// { Driver Code Starts
import java.util.*;

public class Detect_cycle_in_a_directed_graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution4().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

/* Complete the function below */

// ===================================================
//
// DFS Approach
//
// ====================================================

class Solution4 {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfsVisited[i] = true;
                if (checkCycle(visited, dfsVisited, i, adj)) {

                    return true;
                }
                dfsVisited[i] = false;
            }
        }

        return false;
    }

    public boolean checkCycle(boolean visited[], boolean dfsVisited[], int node, ArrayList<ArrayList<Integer>> adj) {
        for (Integer i : adj.get(node)) {
            if (!visited[i]) {
                visited[i] = true;
                dfsVisited[i] = true;
                if (checkCycle(visited, dfsVisited, i, adj)) {
                    return true;
                }

            } else if (visited[i] && dfsVisited[i]) {
                return true;
            }
            dfsVisited[i] = false;
        }
        return false;
    }
}

// ====================================================
//
// BFS Approach
//
// ====================================================

class Solution7 {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        Arrays.fill(indegree, 0);
        for (int i = 0; i < V; i++) {
            for (Integer j : adj.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.remove();
            for (Integer i : adj.get(node)) {
                if (--indegree[i] == 0) {
                    q.add(i);
                }
            }
            count++;
        }
        if (count != V) {
            return true;
        }
        return false;
    }

}