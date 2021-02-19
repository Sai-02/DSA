
/*
Given a string S with repeated characters (only lowercase).
 The task is to rearrange characters in a string such that 
 no two adjacent characters are same.

Note : It may be assumed that the string has only lowercase English alphabets.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. Each test case contains a single line
 containing a string of lowercase english alphabets.

Output:
For each test case in a new line print "1" (without quotes)
 if the generated string doesn't contains any same adjacent characters,
  else if no such string is possible to be made print "0" (without quotes).

Constraints:
1 <= T <= 100
1 <= length of string <= 104

Example:
Input:
3
geeksforgeeks
bbbabaaacd
bbbbb

Output:
1
1
0

Explanation:
Testcase 1: All the repeated characters of the
 given string can be rearranged so that
 no adjacent characters in the string is equal.
Testcase 3: Repeated characters in the string cannot be rearranged such that there should not be any adjacent repeated character.
 */

import java.util.*;
import java.io.*;


public class Rearrange_characters {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            String str = scan.nextLine();
            int a[] = new int[26];
            for (int i = 0; i < 26; i++) {
                a[i] = 0;
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                a[(int) str.charAt(i) - 97]++;
            }
            int maxFreq = 0;
            for (int i = 0; i < 26; i++) {
                if (maxFreq < a[i]) {
                    maxFreq = a[i];
                }
            }
            if (maxFreq < length - maxFreq + 1) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

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


// ===========================================
// 
//  GFG Editorial
// 
// ===========================================

// 1. Put highest frequency character first (a greedy approach). 
// Use Binary Max Heap and put all characters and ordered by their frequencies
//  (highest frequency character at root).
// one by one take highest frequency character from the heap and add it to result.
//  Once added, decrease frequency of the character and 
// temporarily move this character out of Max Heap so that it is not picked next time.


// 2. Steps involved:
// 1. Build a Priority Queue or max heap, pq that stores characters and their frequencies.
//     (Priority_queue or max_heap is built on the bases of frequency of character.)
// 2. Create a temporary Key that will used as the previous visited element ( previous element in resultant string. Initialize it { char = ‘#’ , freq = ‘-1’ }
// 3. While pq is not empty.
//      Pop an element and add it to result.
//      Decrease frequency of the popped element by ‘1’
//      Push the previous element back into the pq if it’s frequency > ‘0’
//      Make the current element as previous element for the next iteration.
// 4. If length of resultant string and original, print “not possible”. Else print result.

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class GFG {
// 	public static void main (String[] args) {
// 		try {
// 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 			int t = Integer.parseInt(br.readLine());
// 			while (t-- > 0) {
// 				String str = br.readLine();
// 				boolean result = rearrangeCharacters(str);
// 				if (result)
// 					System.out.println(1);
// 				else
// 					System.out.println(0);
// 			}
// 		} catch (Exception e) {

// 		}
// 	}

// 	static class Key {
// 		int freq;
// 		char ch;

// 		Key(int freq, char c) {
// 			this.freq = freq;
// 			this.ch = c;
// 		}
// 	}

// 	static class KeyComparator implements Comparator<Key> {
// 		@Override
// 		public int compare(Key k1, Key k2) {
// 			return k2.freq - k1.freq;
// 		}
// 	}

// 	private static boolean rearrangeCharacters(String str) {
// 		final short MAX_CHAR = 26;
// 		int n = str.length();
// 		int count[] = new int[MAX_CHAR];

// 		// Populating array with char and frequencies
// 		for (int i = 0; i < n; ++i) {
// 			count[str.charAt(i) - 'a']++;
// 		}

// 		// Populating Priority Queue with Keys made from above array
// 		PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
// 		for (char c = 'a'; c <= 'z'; ++c) {
// 			int val = c - 'a';
// 			if (count[val] != 0) {
// 				pq.add(new Key(count[val], c));
// 			}
// 		}

// 		str = "";
// 		Key prev = new Key(-1, '$');
// 		while (pq.size() != 0) {
// 			Key k = pq.poll();
// 			str = str + k.ch;
// 			if (prev.freq > 0)
// 				pq.add(prev);
// 			k.freq--;
// 			prev = k;
// 		}
// 		if (n == str.length())
// 			return true;
// 		return false;
// 	}
// }
