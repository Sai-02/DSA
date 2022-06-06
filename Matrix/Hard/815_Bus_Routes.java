
/**
 * ou are given an array routes representing bus routes where routes[i] is a bus
 * route that the ith bus repeats forever.
 * 
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in
 * the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and
 * you want to go to the bus stop target. You can travel between bus stops by
 * buses only.
 * 
 * Return the least number of buses you must take to travel from source to
 * target. Return -1 if it is not possible.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then
 * take the second bus to the bus stop 6.
 * Example 2:
 * 
 * Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target
 * = 12
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * All the values of routes[i] are unique.
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 */

import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        HashMap<Integer, List<Integer>> busMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!busMap.containsKey(routes[i][j])) {
                    busMap.put(routes[i][j], new ArrayList<Integer>());
                }
                busMap.get(routes[i][j]).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        HashSet<Integer> stopsMap = new HashSet<>();
        HashSet<Integer> buses = new HashSet<>();
        int count = 0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int src = q.remove();
                for (int bus : busMap.get(src)) {
                    if (buses.contains(bus))
                        continue;
                    buses.add(bus);
                    for (int stop : routes[bus]) {
                        if (stop == target)
                            return count + 1;
                        if (!stopsMap.contains(stop)) {
                            stopsMap.add(stop);
                            q.add(stop);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}