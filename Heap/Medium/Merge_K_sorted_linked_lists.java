
/*
Given K sorted linked lists of different sizes.
 The task is to merge them in such a way that after 
 merging they will be a single sorted linked list.

Example 1:

Input:
K = 4
value = {{1,2,3},{4 5},{5 6},{7,8}}
Output: 1 2 3 4 5 5 6 7 8
Explanation:
The test case has 4 sorted linked 
list of size 3, 2, 2, 2
1st    list     1 -> 2-> 3
2nd   list      4->5
3rd    list      5->6
4th    list      7->8
The merged list will be
1->2->3->4->5->5->6->7->8.
Example 2:

Input:
K = 3
value = {{1,3},{4,5,6},{8}}
Output: 1 3 4 5 6 8
Explanation:
The test case has 3 sorted linked
list of size 2, 3, 1.
1st list 1 -> 3
2nd list 4 -> 5 -> 6
3rd list 8
The merged list will be
1->3->4->5->6->8.
Your Task:
The task is to complete the function mergeKList()
 which merges the K given lists into a sorted one.
  The printing is done automatically by the driver code.

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)
Note: n is the maximum size of all the k link list

Constraints
1 <= K <= 103

 

Company 
 */

// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Merge_K_sorted_linked_lists {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();

            Node[] a = new Node[N];

            for (int i = 0; i < N; i++) {
                int n = sc.nextInt();

                Node head = new Node(sc.nextInt());
                Node tail = head;

                for (int j = 0; j < n - 1; j++) {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }

                a[i] = head;
            }

            Merge g = new Merge();

            Node res = g.mergeKList(a, N);
            if (res != null)
                printList(res);
            System.out.println();
        }
    }
}// } Driver Code Ends

/*
 * class Node { int data; Node next;
 * 
 * Node(int key) { data = key; next = null; } }
 */

// a is an array of Nodes of the heads of linked lists
// and N is size of array a

class Pair implements Comparable<Pair> {
    int index;
    Node node;
    int val;

    Pair(int index, Node node, int val) {
        this.index = index;
        this.node = node;
        this.val = val;
    }

    public int compareTo(Pair o) {
        return this.val - o.val;

    }
}

class Merge {
    Node mergeKList(Node[] a, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Node head = null;
        Node temp = null;
        for (int i = 0; i < n; i++) {
            Pair newPair = new Pair(i, a[i], a[i].data);
            pq.add(newPair);
        }
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            if (head == null) {
                head = pair.node;
                temp = head;
            } else {
                temp.next = pair.node;
                temp = temp.next;

            }
            pair.node = pair.node.next;
            if (pair.node != null) {
                pair.val = pair.node.data;
                pq.add(pair);
            }
        }
        return head;

    }

}

// =============================================
// 
// GFG Editorial
// 
// =============================================


// A Simple Solution is to initialize result as first list.
//  Now traverse all lists starting from second list. 
//  Insert every node of currently traversed list into result in a sorted way. 
//  Time complexity of this solution is O(N2) 
// where N is total number of nodes, i.e., N = kn.

// 2. You can merge two lists from the array 
// then merge the result with third lists and so on till we get one complete list.


// class Merge
// {
//     // function to merger 2 sorted lists and
//     // return head of merged list
//     Node merge(Node a,Node b)
//     {
//         /* Base cases */
//         if(a==null)
//             return b;
//         if(b==null)
//             return a;
        
//         /* Pick either a or b, and recur */
//         if(a.data<b.data)
//         {
//             a.next=merge(a.next,b);
//             return a;
//         }
//         else
//         {
//             b.next=merge(a,b.next);
//             return b;
//         }
//     }
    
//     // The main function that takes an array of lists
//     // arr[0..last] and generates the sorted output
//     Node mergeKList(Node[]a,int N)
//     {
     
//         int last=N-1; // last index in array
// 	    // repeat until only one list is left
	    
//         while(last!=0)
//         {
//             int i=0;int j=last;
//             // (i, j) forms a pair which will be merger
            
//             while(i<j)
//             {
//                 a[i]=merge(a[i],a[j]);
//                 // merge List i with List j and store
// 			    // merged list in List i
			    
//                 i++;j--;
//                 // moving to next pair
                
//                 if(i>=j)
//                     // If all pairs are merged, update last
//                     last=j;
//             }
//         }
//         return a[0];
//     }
// }
