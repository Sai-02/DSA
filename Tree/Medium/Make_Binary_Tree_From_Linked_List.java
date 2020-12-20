
/*
Given a Linked List Representation of Complete Binary Tree.
 The task is to construct the Binary tree.
Note : The complete binary tree is represented as a linked 

list in a way where if root node is stored at position i, its left,
 and right children are stored at position 2*i+1, 2*i+2 respectively.
 



Example 1:

Input:
N = 5
K = 1->2->3->4->5
Output: 1 2 3 4 5
Explanation: The tree would look like
      1
    /   \
   2     3
 /  \
4   5
Now, the level order traversal of
the above tree is 1 2 3 4 5.
Example 2:

Input:
N = 5
K = 5->4->3->2->1
Output: 5 4 3 2 1
Explanation: The tree would look like
     5
   /  \
  4    3
 / \
2    1
Now, the level order traversal of
the above tree is 5 4 3 2 1.
Your Task:
The task is to complete the function convert() 
which takes head of linked list and root of the tree as the reference. 
The driver code prints the level order.

Constraints:
1 <= N <= 103
1 <= Ki <= 103

 */
//{
// Driver Code
// Starts

import java.util.*;

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Make_Binary_Tree_From_Linked_List {
    static Node lhead;
    static Queue<Tree> queue = new LinkedList<Tree>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Tree node = null;
            lhead = null;
            Node head = null;
            while (!queue.isEmpty()) {
                queue.poll();
            }
            int n = sc.nextInt();
            if (n != 0) {
                Make_Binary_Tree_From_Linked_List llist = new Make_Binary_Tree_From_Linked_List();
                int a1 = sc.nextInt();
                head = new Node(a1);
                llist.addToTheLast(head);
                lhead = head;
                for (int i = 1; i < n; i++) {
                    int a = sc.nextInt();
                    llist.addToTheLast(new Node(a));
                }
            }
            GfG4 g = new GfG4();
            Tree root = g.convert(lhead, node);
            try {
                levelOrder(root, n);
            } catch (NullPointerException ex) {
                System.out.println(-1);
            }
            System.out.println();
        }
    }

    public static void levelOrder(Tree root, int n) {
        queue.add(root);
        while (!queue.isEmpty() && n-- > 0) {
            Tree proot = queue.remove();
            try {
                queue.add(proot.left);
                queue.add(proot.right);
                System.out.print(proot.data + " ");
            } catch (NullPointerException ex) {
            }
        }
    }

    public void addToTheLast(Node head) {
        if (lhead == null)
            lhead = head;
        else {
            Node temp = lhead;
            while (temp.next != null)
                temp = temp.next;
            temp.next = head;
        }
    }
}// } Driver Code Ends

/*
 * class Tree{ int data; Tree left; Tree right; Tree(int d){ data=d; left=null;
 * right=null; } }
 * 
 * class Node { int data; Node next; Node(int d) { data = d; next = null; } }
 */
class GfG4 {
    static Node temp = null;

    public static Tree convert(Node head, Tree node) {
        Queue<Tree> q = new LinkedList<>();

        temp = head;
        node = new Tree(temp.data);
        temp = temp.next;
        q.add(node);
        q.add(null);
        while (!q.isEmpty()) {
            Tree t = q.remove();
            if (temp == null)
                break;
            if (t == null) {
                if (q.peek() == null) {
                    break;
                }
                q.add(null);
            } else {
                t.left = addChildren();
                t.right = addChildren();
                q.add(t.left);
                q.add(t.right);
            }

        }

        return node;

    }

    public static Tree addChildren() {
        if (temp == null) {
            return null;
        }
        Tree New = new Tree(temp.data);
        temp = temp.next;
        return New;

    }
}



// =====================================
// 
//  GFG Editorial
// 
// =====================================

// Create an empty queue.
// 2. Make the first node of the list as root, and enqueue it to the queue.
// 3. Until we reach the end of the list, do the following.
// ………a. Dequeue one node from the queue. This is the current parent.
// ………b. Traverse two nodes in the list, add them as children of the current parent.
// ………c. Enqueue the two nodes into the queue.




// class GfG {
//     public static Tree convert(Node head, Tree node) {
//         Queue<Tree> q = new LinkedList<Tree>();
//         if (head == null) {
//             node = null;
//             return null;
//         }
//         node = new Tree(head.data);
//         q.add(node);
//         head = head.next;
//         while (head != null) {
//             Tree parent = q.poll();
            
//             Tree leftChild = null, rightChild = null;
//             leftChild = new Tree(head.data);
//             q.add(leftChild);
//             head = head.next;
//             if (head != null) {
//                 rightChild = new Tree(head.data);
//                 q.add(rightChild);
//                 head = head.next;
//             }
//             parent.left = leftChild;
//             parent.right = rightChild;
//         }
//         return node;
//     }
// }




