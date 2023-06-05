/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 * 
 * 
 * 
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2)
            return true;
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int dx = coordinates[1][0] - x0, dy = coordinates[1][1] - y0;
        for (int i = 1; i < coordinates.length; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if ((dx * (y - y0)) != (dy * (x - x0)))
                return false;
        }
        return true;
    }
}