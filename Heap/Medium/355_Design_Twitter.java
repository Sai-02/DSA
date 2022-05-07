
/**
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user, and is able to see the 10 most recent tweets in
 * the user's news feed.
 * 
 * Implement the Twitter class:
 * 
 * Twitter() Initializes your twitter object.
 * void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId
 * by the user userId. Each call to this function will be made with a unique
 * tweetId.
 * List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs
 * in the user's news feed. Each item in the news feed must be posted by users
 * who the user followed or by the user themself. Tweets must be ordered from
 * most recent to least recent.
 * void follow(int followerId, int followeeId) The user with ID followerId
 * started following the user with ID followeeId.
 * void unfollow(int followerId, int followeeId) The user with ID followerId
 * started unfollowing the user with ID followeeId.
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed",
 * "unfollow", "getNewsFeed"]
 * [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 * Output
 * [null, null, [5], null, null, [6, 5], null, [5]]
 * 
 * Explanation
 * Twitter twitter = new Twitter();
 * twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
 * twitter.getNewsFeed(1); // User 1's news feed should return a list with 1
 * tweet id -> [5]. return [5]
 * twitter.follow(1, 2); // User 1 follows user 2.
 * twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
 * twitter.getNewsFeed(1); // User 1's news feed should return a list with 2
 * tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is
 * posted after tweet id 5.
 * twitter.unfollow(1, 2); // User 1 unfollows user 2.
 * twitter.getNewsFeed(1); // User 1's news feed should return a list with 1
 * tweet id -> [5], since user 1 is no longer following user 2.
 * 
 * 
 * Constraints:
 * 
 * 1 <= userId, followerId, followeeId <= 500
 * 0 <= tweetId <= 104
 * All the tweets have unique IDs.
 * At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and
 * unfollow.
 */

import java.util.*;

class Twitter {
    int time = 0;

    class Tweet implements Comparable<Tweet> {
        int id, time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }

        public int compareTo(Tweet t) {
            return t.time - this.time;
        }
    }

    class User {
        int id;
        Tweet head;
        HashSet<Integer> followee = new HashSet<>();

        User(int id) {
            this.id = id;
        }
    }

    HashMap<Integer, User> userMap = new HashMap<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            user.followee.add(userId);
            userMap.put(userId, user);
        }
        Tweet tweet = new Tweet(tweetId, time);
        time++;
        tweet.next = userMap.get(userId).head;
        userMap.get(userId).head = tweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            user.followee.add(userId);
            userMap.put(userId, user);
        }
        List<Integer> ans = new ArrayList<>();
        User user = userMap.get(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        for (int u : user.followee) {
            if (userMap.get(u).head != null)
                pq.add(userMap.get(u).head);
        }
        while (pq.size() > 0 && ans.size() < 10) {
            Tweet t = pq.remove();
            ans.add(t.id);
            Tweet next = t.next;
            if (next != null)
                pq.add(next);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            user.followee.add(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            user.followee.add(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).followee.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userMap.get(followerId).followee.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */