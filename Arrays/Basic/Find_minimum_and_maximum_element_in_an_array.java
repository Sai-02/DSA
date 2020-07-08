/*
Find minimum and maximum element in an array
Given an array A of size N of integers. 
Your task is to find the minimum and maximum elements in the array.

Input:
The first line of input contains an integer T denoting the number of test cases. 
T testcases follow. Each testcase contains 2 lines of input. 
The first line of each testcase contains the size of array N. 
The following line contains elements of the array separated by spaces.

Output:
For each testcase, print the minimum and maximum element of the array.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= Ai <=1012

Example:
Input:
2
6
3 2 1 56 10000 167
5
1 345 234 21 56789
Output:
1 10000
1 56789
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


public class Find_minimum_and_maximum_element_in_an_array {
	public static void main (String[] args) {
	    Scanner scan=new Scanner(System.in);
	    int t=scan.nextInt();
	    while(t-->0){
	        int n=scan.nextInt();
	        long[] a=new long[n];
	        for(int i=0;i<n;i++){
	            a[i]=scan.nextLong();
	        }
	        Arrays.sort(a);
	        System.out.println(a[0]+" "+a[n-1]);
	        
	    }
		
	}
}