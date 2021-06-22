/*
You have records of employee name as string (Ename) and salary as positive integer (S). 
You have to sort the records on the basis of employee salary,
 if salary is same then use employee name for comparison.

Example 1:

Input: N = 2
arr[] = {{xbnnskd, 100}, {geek, 50}}
Output: {geek 50}, {xbnnskd 100}
Explanation: geek has lowest salary 
as 50 and xbnnskd has more salary.
Example 2: 

Input: N = 2
arr[] = {{shyam, 50}, {ram, 50}} 
Output: ram 50 shyam 50
Your Task:
This is a function problem. You don't need to take any input,
 as it is already accomplished by the driver code. 
 You just need to complete the function sortRecords() that 
 takes array arr[] and integer N as parameters and sort the 
 array according to the above-given conditions. 
 The function does not return anything.

 

Expected Time Complexity: O(NlogN).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 103
*/

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;

class node {
    int salary;
    String name;

    public void setSalary(int a) {
        this.salary = a;
    }

    public void setName(String s1) {
        this.name = s1;
    }
}

public class Sorting_Employees {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            node a[] = new node[n];
            for (int i = 0; i < 2 * n; i = i + 2) {
                a[i / 2] = new node();
                a[i / 2].setName(q[i]);
                a[i / 2].setSalary(Integer.parseInt(q[i + 1]));
            }

            Solution5 ob = new Solution5();
            ob.sortRecords(a, n);
            for (int i = 0; i < n; i++) {
                System.out.print(a[i].name + " " + a[i].salary + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class node { int salary; String name; public void setSalary(int a) {
 * this.salary=a; } public void setName(String s) { this.name=s; } }
 */

class Solution5 {
    void sortRecords(node a[], int n) {
        node ans[] = getMergeSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            node newNode = getNode(ans, i);
            a[i] = newNode;
        }

    }

    node[] getMergeSort(node a[], int l, int h) {

        if (l == h) {
            node ans[] = new node[1];
            node newNode = getNode(a, l);
            ans[0] = newNode;
            return ans;
        }
        int mid = (l + h) / 2;
        node lsa[] = getMergeSort(a, l, mid);
        node rsa[] = getMergeSort(a, mid + 1, h);
        node ans[] = merge(lsa, rsa);
        return ans;

    }

    node[] merge(node a[], node b[]) {
        int n = a.length;
        int m = b.length;
        node ans[] = new node[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i].salary < b[j].salary) {
                node newNode = getNode(a, i);
                ans[k] = newNode;
                i++;
                k++;
            } else if (a[i].salary > b[j].salary) {
                node newNode = getNode(b, j);
                ans[k] = newNode;
                j++;
                k++;
            } else {
                if (a[i].name.compareTo(b[j].name) > 0) {
                    node newNode = getNode(b, j);
                    ans[k] = newNode;
                    j++;
                    k++;
                } else {
                    node newNode = getNode(a, i);
                    ans[k] = newNode;
                    i++;
                    k++;

                }
            }
        }
        while (i < n) {
            node newNode = getNode(a, i);
            ans[k] = newNode;
            i++;
            k++;

        }
        while (j < m) {
            node newNode = getNode(b, j);
            ans[k] = newNode;
            j++;
            k++;

        }
        return ans;

    }

    node getNode(node a[], int index) {
        node newNode = new node();
        newNode.setSalary(a[index].salary);
        newNode.setName(a[index].name);
        return newNode;
    }
}
