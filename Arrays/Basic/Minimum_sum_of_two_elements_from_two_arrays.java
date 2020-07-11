/* Given two arrays a[] and b[] of same size.
Your task is to find minimum sum of two elements such that they belong to different arrays
 and are not at same index in their arrays.

Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow.
  Each test case contains an integer n denoting the size of the array.
   Then next two lines contains n space separated integers forming the arrays.

Output:
Output the minimum sum.
Constraints:
1<=T<=100
1<=N<=100
1<=a[i]<=1000
1<=b[i]<=1000
Example:
Input:
2
5
1 5 4 3 2
2 1 4  5 3
4
1 2 3 4
1 3 5 6
Output:
2
3
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Minimum_sum_of_two_elements_from_two_arrays {
	public static void main (String[] args) {
	    Scanner scan=new Scanner(System.in);
	    int t=scan.nextInt();
	    while(t-->0){
	        int n=scan.nextInt();
	        int[] a=new int[n];
	        int[] b=new int[n];
	        int minA=Integer.MAX_VALUE;
	        int minB=Integer.MAX_VALUE;
	        int indexA=0,indexB=0;
	        
	        for(int i=0;i<n;i++){
	            a[i]=scan.nextInt();
	            if(minA>a[i]){
	                minA=a[i];
	                indexA=i;
	            }
	        }
	        for(int i=0;i<n;i++){
	            b[i]=scan.nextInt();
	            if(minB>b[i]){
	                minB=b[i];
	                indexB=i;
	            }
	        }
	        if(indexA==indexB){
	            if(minA>minB){
	                Arrays.sort(b);
	                minA=minA+b[1];
	                System.out.println(minA);
	            }
	            else{
	                Arrays.sort(a);
	                minB=minB+a[1];
	                System.out.println(minB);
	            }
	            
	        }
	        else{
	            minA=minA+minB;
	            System.out.println(minA);
	        }
	        
	    }
		
	}
}