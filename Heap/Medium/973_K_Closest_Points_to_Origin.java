
/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= points.length <= 104
 * -104 < xi, yi < 104
 */
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[][] = new int[k][2];
        for (int a[] : points) {
            Pair newPair = new Pair(a[0], a[1], getDistance(a[0], a[1]));
            pq.add(newPair);
            if (pq.size() > k)
                pq.remove();
        }
        for (int a[] : ans) {
            Pair pair = pq.remove();
            a[0] = pair.x;
            a[1] = pair.y;
        }

        return ans;
    }

    public int getDistance(int x, int y) {
        return (x * x) + (y * y);
    }

}

class Pair implements Comparable<Pair> {
    int x, y, distance;

    Pair(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int compareTo(Pair o) {
        return -(this.distance - o.distance);
    }
}
