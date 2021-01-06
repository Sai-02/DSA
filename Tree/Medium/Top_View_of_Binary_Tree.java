/*
Given below is a binary tree.
 The task is to print the top view of binary tree.
  Top view of a binary tree is the set of nodes visible
   when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Print from leftmost node to rightmost node.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3

Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem.
 You don't have to take input. 
 Just complete the function printTopView()
  that takes root node as parameter and prints the top view.
   The newline is automatically appended by the driver code.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= Node Data <= 105
 
 */

// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Top_View_of_Binary_Tree {

    public static void main(String[] args) throws IOException {
        // Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            Queue<Node> q = new LinkedList<>();

            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");

            Node root = null;
            int j = 0;
            while (n > 0) {
                int a1 = Integer.parseInt(input[j]);
                int a2 = Integer.parseInt(input[j + 1]);
                char lr = input[j + 2].charAt(0);
                j += 3;

                if (root == null) {
                    root = new Node(a1);
                    q.add(root);
                }

                Node pick = q.peek();

                q.remove();

                if (lr == 'L') {
                    pick.left = new Node(a2);
                    q.add(pick.left);
                }
                a1 = Integer.parseInt(input[j]);
                a2 = Integer.parseInt(input[j + 1]);
                lr = input[j + 2].charAt(0);
                j += 3;

                if (lr == 'R') {
                    pick.right = new Node(a2);
                    q.add(pick.right);
                }

                n -= 2;
            }
            new View().topView(root);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */
class View {
    // function should print the topView of the binary tree
    static ArrayList<Integer> a = new ArrayList<>();
    static ArrayList<Integer> level = new ArrayList<>();
    static int leftCount = 0, rightCount = 0;

    static void topView(Node root) {
        a.clear();
        level.clear();
        findDistance(root, 0);
        for (int i = 0; i < Math.abs(leftCount) + rightCount + 1; i++) {
            a.add(0);
            level.add(Integer.MAX_VALUE);

        }
        solver(root, 0, 0);
        int n = a.size();
        for (int i = 0; i < n; i++) {
            if (a.get(i) != 0) {

                System.out.print(a.get(i) + " ");
            }
        }

    }

    static void findDistance(Node root, int distance) {
        if (root == null) {
            return;
        }
        leftCount = Math.min(leftCount, distance);
        rightCount = Math.max(rightCount, distance);

        findDistance(root.right, distance + 1);
        findDistance(root.left, distance - 1);
    }

    static void solver(Node root, int distance, int currLevel) {
        if (root == null) {
            return;
        }
        if (a.get(distance + Math.abs(leftCount)) == 0 || level.get(distance + Math.abs(leftCount)) > currLevel) {
            a.set(distance + Math.abs(leftCount), root.data);
            level.set(distance + Math.abs(leftCount), currLevel);

        }
        solver(root.left, distance - 1, currLevel + 1);
        solver(root.right, distance + 1, currLevel + 1);
    }
}



// =========================================================
// 
//  GFG Editorial
// 
// ========================================================

// 1. The root always gets printed.
// 2. Use level order traversal and print the extreme nodes on left and right.
//  You'd need to use a marker to keep track of levels.
//  The node after marker and the node before marker are the extreme nodes.

// class qObj
// {
//     Node node;
//     int level;
//     qObj(Node n,int l)
//     {
//         node=n;
//         level=l;
//     }
// }

// class View
// {
//     public static void topView(Node root)
//     {
//        Queue<qObj> q=new LinkedList<qObj>();
//        q.add(new qObj(root,1));
//        Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
       
//        // doing level order traversal and finding the extreme elements
//        while(!q.isEmpty()){
//            qObj popped=q.poll();
//            if(!map.containsKey(popped.level))
//             map.put(popped.level,popped.node.data);
//            if(popped.node.left!=null)
//             q.add(new qObj(popped.node.left,popped.level-1));
//            if(popped.node.right!=null)
//             q.add(new qObj(popped.node.right,popped.level+1));
//        }
       
//        for(Map.Entry<Integer,Integer> e:map.entrySet())
//        {
//            System.out.print(e.getValue()+" ");
//        }
       
//     }
// }