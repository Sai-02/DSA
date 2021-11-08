import java.util.*;

class Solution8 {
    public String makeGood(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (st.empty()) {
                st.push(c);
            } else {
                if (97 <= c && st.peek() < 97 || st.peek() >= 97 && c < 97) {
                    if (c == st.peek() + 32 || c == st.peek() - 32) {
                        st.pop();
                    } else {
                        st.push(c);
                    }

                } else {
                    st.push(c);
                }
            }
        }

        String ans = "";
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}