/*
Given an array of size N that can be used to represents a tree. 
The array indexes are values in tree nodes and array values 
give the parent node of that particular index (or node). 
The value of the root node index would always be -1 as there is no parent for root.
 Construct the standard linked representation of
  Binary Tree from this array representation.

 

Example 1:

Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a sturcture like 
          0
        /   \
       1     2
      / \
     3   4
    /
   5
 /
6
 

Example 2:

Input:
N = 3
parent[] = {2, 0, -1}
Output: 2 0 1
Explanation: the tree generated will
have a sturcture like
               2
             /   
            0      
          /   
         1     
 

Your Task:
You don't need to read input or print anything.
 The task is to complete the function createTree() 
 which takes 2 arguments parent[] and N and returns 
 the root node of the constructed tree.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class Construct_Binary_Tree_from_Parent_Array {
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG10 gfg = new GfG10();
            Node root = gfg.createTree(arr, n);

            printLevelOrder(root);
            System.out.println();
        }
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
        }
    }

    public static void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            result.clear();
            printGivenLevel(root, i);
            Collections.sort(result);
            for (int j = 0; j < result.size(); j++)
                System.out.print(result.get(j) + " ");
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        else {

            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public static void printGivenLevel(Node node, int level) {
        if (node == null)
            return;
        if (level == 1)
            result.add(node.data);
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
}

// } Driver Code Ends

/*
 * node class of the binary tree class Node { int data; Node left, right;
 * Node(int key) { data = key; left = right = null; } }
 */
class GfG10 {
    static Node root = null;
    static ArrayList<Node> created = new ArrayList<>();

    public static Node createTree(int parent[], int n) {
        root = null;
        created.clear();

        for (int i = 0; i < n; i++) {
            created.add(null);
        }
        for (int i = 0; i < n; i++) {

            createNode(parent, i);
        }

        return root;

    }

    public static void createNode(int parent[], int i) {
        if (created.get(i) != null) {
            return;
        }
        Node newNode = new Node(i);
        created.set(i, newNode);
        if (parent[i] == -1) {
            root = newNode;
            return;
        }
        if (created.get(parent[i]) == null) {
            createNode(parent, parent[i]);
        }
        if (created.get(parent[i]).left == null) {
            created.get(parent[i]).left = newNode;
            return;
        }
        created.get(parent[i]).right = newNode;

    }

}


// ========================================
// 
//  GFG Editorial
// 
// =========================================

// An Efficient Solution can solve the above problem in O(n) time.
//  The idea is to use extra space. An array created[0..n-1] is used to keep 
//  track of created nodes.

// createTree(parent[], n)

// Create an array of pointers say created[0..n-1]. 
// The value of created[i] is NULL if node for index i is not created,
//  else value is pointer to the created node.
// Do following for every index i of given array
// createNode(parent, i, created)
// createNode(parent[], i, crated[])

// If created[i] is not NULL, then node is already created. So return.
// Create a new node with value ‘i’.
// If parent[i] is -1 (i is root), make created node as root and return.
// Check if parent of ‘i’ is created (We can check this by checking 
// if created[parent[i]] is NULL or not.
// If parent is not created, recur for parent and create the parent first.
// Let the pointer to parent be p. If p->left is NULL, then make
//  the new node as left child. Else make the new node as right child of parent.





// Code 




// class GfG
// {
//     static Node root;
//     public static Node createTree(int arr[], int n)
//     {
//         root = null;
//          Node[] created = new Node[n];
//         for (int i = 0; i < n; i++) 
//             created[i] = null;
  
//         for (int i = 0; i < n; i++)
//             createNode(arr, i, created);
  
//         return root;
//     }
    
//     public static void createNode(int arr[], int i, Node created[])
//     {
//         if (created[i] != null)
//             return;
  
        
//         created[i] = new Node(i);
  
        
//         if (arr[i] == -1) 
//         {
//             root = created[i];
//             return;
//         }
  
       
//         if (created[arr[i]] == null)
//             createNode(arr, arr[i], created);
  
        
//         Node p = created[arr[i]];
  
        
//         if (p.left == null)
//             p.left = created[i];
//         else 
          
//             p.right = created[i];
//     }
// }

