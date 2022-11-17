/**
 * iven the coordinates of two rectilinear rectangles in a 2D plane, return the
 * total area covered by the two rectangles.
 * 
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its
 * top-right corner (ax2, ay2).
 * 
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its
 * top-right corner (bx2, by2).
 * 
 * 
 * 
 * Example 1:
 * 
 * Rectangle Area
 * Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 =
 * 2
 * Output: 45
 * Example 2:
 * 
 * Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2
 * = 2
 * Output: 16
 * 
 * 
 * Constraints:
 * 
 * -104 <= ax1 <= ax2 <= 104
 * -104 <= ay1 <= ay2 <= 104
 * -104 <= bx1 <= bx2 <= 104
 * -104 <= by1 <= by2 <= 104
 * Accepted
 * 165,368
 * Submissions
 * 385,764
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 * 
 */

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = ((ax2 - ax1) * (ay2 - ay1)), area2 = ((bx2 - bx1) * (by2 - by1));
        int area = area1 + area2;
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int x = right - left;

        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int y = top - bottom;
        if (x > 0 && y > 0)
            area -= (x * y);
        return area;
    }
}