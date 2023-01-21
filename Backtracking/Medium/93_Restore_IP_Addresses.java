
/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

1 <= s.length <= 20
s consists of digits only.
Accepted
349,179
Submissions
780,721
 */
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> num = new ArrayList<>();
        solver(s, num, ans, 0);
        return ans;
    }

    public void solver(String s, List<String> num, List<String> ans, int index) {
        if (index == s.length() && num.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String n : num) {
                if (n.charAt(0) == '0' && n.length() > 1)
                    return;
                sb.append(n);
                sb.append(".");
            }
            sb.setLength(sb.length() - 1);
            ans.add(sb.toString());
        }
        if (index == s.length())
            return;
        int val = Integer.parseInt(s.substring(index, index + 1));
        if (0 <= val && val <= 255) {
            num.add(s.substring(index, index + 1));
            solver(s, num, ans, index + 1);
            num.remove(num.size() - 1);
        }
        if (index > s.length() - 2)
            return;
        val = Integer.parseInt(s.substring(index, index + 2));
        if (0 <= val && val <= 255) {
            num.add(s.substring(index, index + 2));
            solver(s, num, ans, index + 2);
            num.remove(num.size() - 1);
        }
        if (index > s.length() - 3)
            return;
        val = Integer.parseInt(s.substring(index, index + 3));
        if (0 <= val && val <= 255) {
            num.add(s.substring(index, index + 3));
            solver(s, num, ans, index + 3);
            num.remove(num.size() - 1);
        }

    }
}