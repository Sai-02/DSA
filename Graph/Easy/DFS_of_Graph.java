/*
Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach to find the DFS traversal of the graph starting from
 the 0th vertex from left to right according to the graph..


Example 1:

Input:

Output: 0 1 2 4 3
Explanation: 
0 is connected to 1, 2, 4.
1 is connected to 0.
2 is connected to 0.
3 is connected to 0.
4 is connected to 0, 3.
so starting from 0, it will go to 1 then 2
then 4, and then from 4 to 3.
Thus dfs will be 0 1 2 4 3.
Example 2:

Input:

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 2. 
2 is connected to 1.
3 is connected to 0. 
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3. 

Your task:
You don’t need to read input or print anything. 
Your task is to complete the function dfsOfGraph()
 which takes the integer V denoting the number of
  vertices and adjacency list as input parameters 
  and returns  a list containing the DFS traversal
   of the graph starting from the 0th vertex from 
   left to right according to the graph.


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

public class DFS_of_Graph {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution1 obj = new Solution1();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution1 {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean visited[] = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                getDFS(dfs, visited, i, adj);
            }
        }
        return dfs;
    }

    public void getDFS(ArrayList<Integer> dfs, boolean[] visited, int i, ArrayList<ArrayList<Integer>> adj) {
        visited[i] = true;
        dfs.add(i);
        for (int j = 0; j < adj.get(i).size(); j++) {
            if (!visited[adj.get(i).get(j)]) {
                getDFS(dfs, visited, adj.get(i).get(j), adj);
            }
        }
    }
}


// ===============================================
// 
// GFG Editorial
// 
// =============================================== 



// Algorithm: 

// Create a recursive function that takes the index of node and a visited array.
// Mark the current node as visited and print the node.
// Traverse all the adjacent and unmarked nodes and call the recursive 
// function with index of adjacent node.


// class Solution
// {
    
//     private void dfs(int ch, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj)
//     {
//         //marking vertex as visited and adding it to output list.
//         vis[ch] = true;
//         ans.add(ch);
        
//         //iterating over connected components of the vertex and if any 
// 	    //of them is not visited then calling the function recursively.
//         for(int i = 0; i < adj.get(ch).size(); i++)
//             if(!vis[adj.get(ch).get(i)])
//                 dfs(adj.get(ch).get(i), vis, ans, adj);
//     }
    
//     //Function to return a list containing the DFS traversal of the graph.
//     public ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
//     {
//         //using a boolean list to mark all the vertices as not visited.
//         boolean[] vis = new boolean[V];
//         ArrayList<Integer> ans = new ArrayList<Integer>();
// 	    dfs(0, vis, ans, adj);
	    
// 	    //returning the output list.
// 	    return ans;
//     }
// }

