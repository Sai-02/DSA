
/**
 * Given an array of strings words and a width maxWidth, format the text such
 * that each line has exactly maxWidth characters and is fully (left and right)
 * justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line does not divide evenly between words, the
 * empty slots on the left will be assigned more spaces than the slots on the
 * right.
 * 
 * For the last line of text, it should be left-justified, and no extra space is
 * inserted between words.
 * 
 * Note:
 * 
 * A word is defined as a character sequence consisting of non-space characters
 * only.
 * Each word's length is guaranteed to be greater than 0 and not exceed
 * maxWidth.
 * The input array words contains at least one word.
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["This", "is", "an", "example", "of", "text",
 * "justification."], maxWidth = 16
 * Output:
 * [
 * "This is an",
 * "example of text",
 * "justification. "
 * ]
 * Example 2:
 * 
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth =
 * 16
 * Output:
 * [
 * "What must be",
 * "acknowledgment ",
 * "shall be "
 * ]
 * Explanation: Note that the last line is "shall be " instead of "shall be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one
 * word.
 * Example 3:
 * 
 * Input: words =
 * ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"],
 * maxWidth = 20
 * Output:
 * [
 * "Science is what we",
 * "understand well",
 * "enough to explain to",
 * "a computer. Art is",
 * "everything else we",
 * "do "
 * ]
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 * Accepted
 * 277,344
 * Submissions
 * 754,043
 */
import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            StringBuilder sb = new StringBuilder();
            int count = 0, width = 0, i = 0, prev = index;
            for (i = index;; i++) {
                if (width + (count > 1 ? (count - 1) : 0) > maxWidth) {
                    width -= words[i - 1].length();
                    count--;
                    i--;
                    break;
                }
                if (i == words.length)
                    break;
                count++;
                width += words[i].length();
            }
            index = i;
            if (count == 1) {
                sb.append(words[index - 1]);
                while (sb.length() < maxWidth)
                    sb.append(" ");
                ans.add(sb.toString());
            } else {
                int space = (maxWidth - width) / (count - 1);
                int extra = (maxWidth - width) % (count - 1);
                for (int k = prev; k < index; k++) {
                    sb.append(words[k]);
                    if (sb.length() < maxWidth)
                        for (int sp = 0; sp < (space + (extra > 0 ? 1 : 0)); sp++)
                            sb.append(" ");
                    extra--;
                }
                ans.add(sb.toString());
            }

        }
        // Parsing last string
        StringBuilder sb = new StringBuilder("");
        char prev = '.';
        String last = ans.get(ans.size() - 1);
        for (int i = 0; i < last.length(); i++) {
            char c = last.charAt(i);
            if (c != ' ')
                sb.append(c);
            else if (prev != ' ')
                sb.append(" ");
            prev = c;
        }
        while (sb.length() < maxWidth)
            sb.append(" ");
        ans.set(ans.size() - 1, sb.toString());
        return ans;
    }
}