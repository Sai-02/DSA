
/**
 * You are given a string s. We want to partition the string into as many parts
 * as possible so that each letter appears in at most one part.
 * 
 * Note that the partition is done so that after concatenating all the parts in
 * order, the resultant string should be s.
 * 
 * Return a list of integers representing the size of these parts.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits s into less parts.
 * Example 2:
 * 
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[][] a = new int[26][2];
        for (int index[] : a)
            Arrays.fill(index, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c - 'a'][1] = Math.max(a[c - 'a'][1], i);
            if (a[c - 'a'][0] == -1) {
                a[c - 'a'][0] = i;
            }
        }
        Arrays.sort(a, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        Stack<int[]> st = new Stack<>();
        for (int index[] : a) {
            if (index[0] != -1) {
                if (st.empty())
                    st.push(index);
                else if (index[0] > st.peek()[1])
                    st.push(index);
                else
                    st.peek()[1] = Math.max(index[1], st.peek()[1]);
            }
        }
        while (!st.empty()) {
            int index[] = st.pop();
            ans.add(index[1] - index[0] + 1);
        }
        Collections.reverse(ans);
        return ans;
    }
}