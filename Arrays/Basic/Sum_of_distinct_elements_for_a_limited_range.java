/*Sum of distinct elements for a limited range 
Given an array of n elements such that every element of array is an integer in the range 1 to n,
 find the sum of all the distinct elements of the array.

Input:
First line consists of T test cases. First line of every test case consists of N.
 Second line of every test case consists of elements of Array.

Output:
Single line output, print the sum of distinct element of array.

Constraints:
1<=T<=200
1<=N<=10^4

Example:
Input:
2
5
1 2 3 3 4
5
1 1 1 2 2
Output:
10
3
*/ 

import java.util.*;
import java.lang.*;
import java.io.*;

public class Sum_of_distinct_elements_for_a_limited_range {
	public static void main (String[] args) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0){
		    int n=scan.nextInt();
		    int[] a=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=scan.nextInt();
		        
		    }
		    Arrays.sort(a);
		    int sum=a[0];
		    int k=a[0];
		    for(int i=0;i<n;i++){
		        if(k!=a[i]){
		            
		        sum=sum+a[i];
		        k=a[i];
		        }
		        
		        
		    }
		    System.out.println(sum);
		}
	}
}