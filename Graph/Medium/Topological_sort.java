/*
Given a Directed Graph with V vertices and E edges, 
Find any Topological Sorting of that Graph.


Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.
Example 2:

Input:


Output:
1
 

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function topoSort()  
which takes the integer V denoting the number of vertices 
and adjacency list as input parameters and returns an array 
consisting of a the vertices in Topological order. 
As there are multiple Topological orders possible, you may return any of them.


Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).


Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2

Company Tags
Topic Tags
 */
// { Driver Code Starts
import java.util.*;
import java.io.*;

public class Topological_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution5().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v])
                    return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends

/* Complete the function below */

// =======================================================
//
// DFS Approach
//
// =======================================================
class Solution5 {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> topSort = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getTopoSort(i, visited, topSort, adj);
            }
        }
        Collections.reverse(topSort);
        int ans[] = new int[topSort.size()];
        for (int i = 0; i < topSort.size(); i++) {
            ans[i] = topSort.get(i);
        }
        return ans;
    }

    static void getTopoSort(int node, boolean[] visited, ArrayList<Integer> topSort,
            ArrayList<ArrayList<Integer>> adj) {
        for (Integer i : adj.get(node)) {
            if (!visited[i]) {
                visited[i] = true;
                getTopoSort(i, visited, topSort, adj);
            }
        }
        topSort.add(node);
    }
}

// ===========================================================
//
// BFS Approach
//
// =============================================================

class Solution6 {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topSort = new ArrayList<>();
        int indegree[] = new int[V];
        Arrays.fill(indegree, 0);
        for (int i = 0; i < V; i++) {
            for (Integer j : adj.get(i)) {
                indegree[j]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.remove();
            topSort.add(node);
            for (Integer i : adj.get(node)) {
                if (--indegree[i] == 0) {
                    q.add(i);
                }
            }

        }
        int ans[] = new int[V];
        for (int i = 0; i < V; i++) {

            ans[i] = topSort.get(i);

        }
        return ans;

    }
}
