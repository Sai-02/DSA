/*
Given a directed graph. The task is to do Breadth First Traversal 
of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge 
from u to v and find the BFS traversal of the graph starting from the 0th vertex,
 from left to right according to the graph. Also, you should only take nodes 
 directly or indirectly connected from Node 0 in consideration.


Example 1:

Input:

Output: 0 1 2 3 4
Explanation: 
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3.After this 2 to 4, thus bfs will be
0 1 2 3 4.
Example 2:

Input:

Output: 0 1 2
Explanation:
0 is connected to 1 , 2.
so starting from 0, it will go to 1 then 2,
thus bfs will be 0 1 2 3 4. 

Your task:
You don’t need to read input or print anything. 
Your task is to complete the function bfsOfGraph()
 which takes the integer V denoting the number of 
 vertices and adjacency list as input parameters and returns
   a list containing the BFS traversal of the graph starting
    from the 0th vertex from left to right.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 104

Company Tags
 */

// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

public class BFS_of_graph {
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
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> a = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            a.add(node);
            for (int j = 0; j < adj.get(node).size(); j++) {
                if (!visited[adj.get(node).get(j)]) {
                    q.add(adj.get(node).get(j));
                    visited[adj.get(node).get(j)] = true;
                }
            }

        }
        return a;
    }

}
// =============================================
//
// GFG Editorial
//
// ==============================================

// Use a boolean list to mark all the vertices as not visited.

// Initially mark first vertex as visited(true).

// Create a queue for BFS and push first vertex in queue.

// While queue is not empty:

// Keep adding front element in output list and popping it from queue.
// Traverse over all the connected components of front element.
// If they aren't visited, mark them visited and add to queue.
// Return the output list.

// class Solution
// {
// //Function to return Breadth First Traversal of given graph.
// public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>>
// adj)
// {
// //boolean list to mark all the vertices as not visited.
// boolean visited[] = new boolean[V];

// int s = 0;
// //initially we mark first vertex as visited(true).
// visited[s] = true;

// ArrayList<Integer> res = new ArrayList<>();

// //creating a queue for BFS and pushing first vertex in queue.
// LinkedList<Integer> q = new LinkedList<Integer>();
// q.add(s);

// while (q.size() != 0)
// {
// //adding front element in output list and popping it from queue.
// s = q.poll();
// res.add(s);

// //traversing over all the connected components of front element.
// Iterator<Integer> i = adj.get(s).listIterator();
// while (i.hasNext())
// {
// int n = i.next();
// //if they aren't visited, we mark them visited and add to queue.
// if (!visited[n])
// {
// visited[n] = true;
// q.add(n);
// }
// }
// }
// //returning the output list.
// return res;
// }
// }
