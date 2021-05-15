/*
Given the adjacency list of a bidirectional graph. 
Your task is to return the adjacency list for each vertex.


Example 1:

Input:

Output: 
0-> 1-> 4 
1-> 0-> 2-> 3-> 4 
2-> 1-> 3 
3-> 1-> 2-> 4 
4-> 0-> 1-> 3
Explanation:
As 0,1 and 3 is connected to 4 so 4th row
of the list containing 4 and its connected
nodes 0,1 and 3 and we have to add those in
sorted order and same for every row.


Example 2:

Input:


Output: 
0-> 2-> 3 
1-> 2 
2-> 0-> 1 
3-> 0
Explanation:
As 2 and 3 is connected to 0 so 0th row
of the list containing 0 and its connected 
nodes 2 and 3 and we have to add those in
sorted order and same for every row. 


Your task:
You don’t need to read input or print anything. 
Your task is to complete the function printGraph() 
which takes the integer V denoting the number of vertices and adjacency
 list as input parameters and returns the list of list  contains the node
  itself with its connected nodes(as same as it is given in input adjacency  list).



Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ V, E ≤ 104
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Print_adjacency_list {
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
            Solution2 obj = new Solution2();
            ArrayList<ArrayList<Integer>> ans = obj.printGraph(V, adj);
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size() - 1; j++) {
                    System.out.print(ans.get(i).get(j) + "-> ");
                }
                System.out.print(ans.get(i).get(ans.get(i).size() - 1));
                System.out.println();
            }
        }
    }
}// } Driver Code Ends

class Solution2 {
    // Function to return the adjacency list for each vertex.
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        for (int i = 0; i < adj.size(); i++) {
            adj.get(i).add(0, i);

        }
        return adj;
    }
}
// ====================================================
// 
//  GFG Editorial
// 
// ====================================================


// Use dynamic arrays (vector in C++/ArrayList in Java) to represent adjacency lists 
// instead of the linked list.
//  The vector implementation has advantages of cache friendliness. 

// class Solution
// {
//     //Function to return the adjacency list for each vertex.
//     public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj)
//     {
//         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
//         //iterating over each vertex.
//         for(int i=0; i<V; i++)
//         {
//             ArrayList<Integer> temp = new ArrayList<>();
            
//             //pushing the vertex at ith index and all the 
//   		    //nodes connected to it in the output list.
//             temp.add(i);
//             for(int j=0; j<adj.get(i).size(); j++)
//             {
//                 temp.add(adj.get(i).get(j));
//             }
//             ans.add(temp);
//         }
//         //returning the list.
//         return ans;
//     }
// }
