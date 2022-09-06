
/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi]
 * represent the departure and the arrival airports of one flight. Reconstruct
 * the itinerary in order and return it.
 * 
 * All of the tickets belong to a man who departs from "JFK", thus, the
 * itinerary must begin with "JFK". If there are multiple valid itineraries, you
 * should return the itinerary that has the smallest lexical order when read as
 * a single string.
 * 
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use
 * all the tickets once and only once.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * Example 2:
 * 
 * 
 * Input: tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 * 
 * 
 * Constraints:
 * 
 * 1 <= tickets.length <= 300
 * tickets[i].length == 2
 * fromi.length == 3
 * toi.length == 3
 * fromi and toi consist of uppercase English letters.
 * fromi != toi
 * Accepted
 * 302,619
 * Submissions
 * 743,002
 */

import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
        for (List<String> list : tickets) {
            if (!hm.containsKey(list.get(0))) {
                hm.put(list.get(0), new PriorityQueue<String>());
            }
            hm.get(list.get(0)).add(list.get(1));
        }
        dfs(hm, "JFK", ans);
        return ans;
    }

    public void dfs(HashMap<String, PriorityQueue<String>> hm, String node, LinkedList<String> ans) {
        if (!hm.containsKey(node)) {
            ans.addFirst(node);
            return;
        }
        PriorityQueue<String> pq = hm.get(node);
        while (!pq.isEmpty()) {
            String nbr = pq.remove();
            dfs(hm, nbr, ans);
        }
        ans.addFirst(node);
    }
}