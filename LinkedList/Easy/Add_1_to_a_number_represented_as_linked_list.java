/*
A number N is represented in Linked List such that each digit 
corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457 
Example 2:

Input:
LinkedList: 1->2->3
Output: 124 
Your Task:
Your task is to complete the function addOne() 
which takes the head of the linked list as the only argument
 and returns the head of the modified linked list.
  The driver code prints the number.
Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 101000
 */

 // { Driver Code Starts



import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Sol4 obj = new Sol4();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Sol4
{
    public static Node addOne(Node head) 
    { 
       head=reverseNode(head);
       int carry=1;
       Node temp=head;
       Node prev=null;
       while(temp!=null){
           int sum=temp.data+carry;
           temp.data=sum%10;
           carry=sum/10;
           prev=temp;
           temp=temp.next;
           
           
           
           
       }
       if(carry==1){
           Node newNode=new Node(carry);
           prev.next=newNode;
           
           
       }
       return reverseNode(head);
       
    }
    public static Node reverseNode(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node prev=null,curr=head,next=head.next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
// ==============================================
// 
//  GFG Editorial
// 
// ============================================


// Reverse given linked list. For example, 1-> 9-> 9 -> 9 is converted to 9-> 9 -> 9 ->1.
// Start traversing linked list from leftmost node and add 1 to it
// . If there is a carry, move to the next node. Keep moving to the next
//  node while there is a carry.
// Reverse modified linked list and return head.



// class Sol
// {
//     public static Node reverse(Node head) 
//     // this function reverses the linked list
//     {
//         Node prev = null;
//         Node current = head;
//         Node next;
        
//         while (current != null) 
//         { 
//             next = current.next;     // storing next node
//             current.next = prev;     // linking current node to previous
//             prev = current;           // updating prev
//             current = next;           // updating current
//         }
        
//         return prev; 
//     } 

//     public static Node addOne(Node head) 
//     { 
//         head = reverse(head);           // reversing list to make addition easy
        
//         Node current = head;
//         int carry = 1;
        
//         while(carry!=0)
//         {
//             current.data += 1;         // adding one to current node
            
//             if(current.data < 10)return reverse(head);
//                 // if no carry we can reverse back list and return it
//             else current.data = 0;
//                 // else we continue with taking carry forward
            
//             if(current.next == null) break;
//                 // if, end of list, we break from loop
//             else current = current.next;
//                 // else we move to next node
//         }
        
//         current.next = new Node(1);  // adding new node for the carried 1
//         return reverse(head);
//     }
// }
