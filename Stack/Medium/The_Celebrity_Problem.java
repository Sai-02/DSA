
/*
 * You are in a party of N people, where only one person is known to everyone.
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone
 * in the party. Your task is to find the stranger (celebrity) in party.
 * 
 * Example 1:
 * 
 * Input: N = 3 M[][] = {{0 1 0}, {0 0 0}, {0 1 0}} Output: 1 Explanation: The
 * matrix will look like 0 1 0 0 0 0 0 1 0 Here, the celebrity is the person
 * with index 1 ie id 1 Example 2:
 * 
 * Input: N = 2 M[][] = {{0 1}, {1 0}} Output: -1 Explanation: The matrix will
 * look like 0 1 1 0 Here, there is no such person who is a celebrity (a
 * celebrity should know no one). Your Task: You will be given a square matrix
 * M[][] where if an element of row i and column j is set to 1 it means ith
 * person knows jth person. You need to complete the function getId() which
 * finds the id of the celebrity if present else return -1. The function getId()
 * takes two arguments, the square matrix M and its size N.
 * 
 * Note: M[i][i] will be equal to zero always.
 * 
 * Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
 * 
 * Constraints: 2 <= N <= 501 0 <= M[][] <= 1
 */
// { Driver Code Starts
import java.util.*;

public class The_Celebrity_Problem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Celebrity().getId(M, N));
            t--;
        }
    }
}
// } Driver Code Ends

class Celebrity {
    // The task is to complete this function
    int getId(int M[][], int n) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            s.push(i);
        }
        while (s.size() != 1) {
            int i = s.pop();
            int j = s.pop();
            if (M[i][j] == 1) {
                s.push(j);
            } else if (M[j][i] == 1) {
                s.push(i);
            }
        }
        int j = s.pop();
        for (int i = 0; i < n; i++) {
            if (i != j && M[i][j] != 1) {
                return -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (M[j][i] != 0) {
                return -1;
            }

        }
        return j;

    }
}

// ====================
//
// Approach
//
// ===================
// Use the following observation based on elimination technique

// If A knows B, then A can’t be celebrity. Discard A, and B may be celebrity.
// If A doesn’t know B, then B can’t be celebrity. Discard B, and A may be
// celebrity.
// Repeat above two steps till we left with only one person.
// Ensure the remained person is celebrity.

// Use stack to verity celebrity.

// Push all the celebrities into a stack.
// Pop off top two persons from the stack, discard one person based on return
// status of Mat(A, B).
// Push the remained person onto stack.
// Repeat step 2 and 3 until only one person remains in the stack.
// Check the remained person in stack doesn’t have acquaintance with anyone else
// or not.