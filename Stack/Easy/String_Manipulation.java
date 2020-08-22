
/*
Tom is a string freak. 
He has got sequences of  n words to manipulate.
 If in a sequence, two same words come together then he’ll destroy each other.
  He wants to know the number of words left in the sequence after this pairwise destruction.
 

Input:
The first line of input contains an integer denoting the no of test cases. 
Then T test cases follow. Each test case contains two lines. 
The first line of input contains an integer n denoting the number of words in a sequence.
 In the second line are n space separated words of the sequence. 
 Words are contiguous stretches of printable characters delimited by white space.
 

Output:
For each test case in a new line print the number of words left per sequence.
 

Constraints:
1<=T<=100
1<=n<=100
 

Example:
Input:
2
5
ab aa aa bcd ab
4
tom jerry jerry tom

Output:
3
0

Explanation:

Test Case 1: ab aa aa bcd ab
After the first iteration, we'll have: ab bcd ab
We can't further destroy more strings and hence we stop and the result is 3. 

Test Case 2: tom jerry jerry tom
After the first iteration, we'll have: tom tom
After the second iteration: 'empty-array' 
Hence, the result is 0.  
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class String_Manipulation {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = Integer.parseInt(scan.nextLine());
            Stack<String> a = new Stack<String>();

            for (int i = 0; i < n; i++) {
                String k = scan.next();
                if (a.empty()) {
                    a.push(k);

                } else {
                    if (a.peek().equals(k)) {
                        a.pop();

                    } else {
                        a.push(k);

                    }
                }
            }

            System.out.println(a.size());

        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}