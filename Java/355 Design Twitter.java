
// 355. Design Twitter

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-14 14:03:23
 * @url:https://leetcode.com/problems/design-twitter/
 */

public class Twitter {

    private Map<Integer, List<Integer>> followMap;
    private Map<Integer, List<Integer>> tweetMap;
    private List<Integer> tweetList;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<Integer, List<Integer>>();
        tweetMap = new HashMap<Integer, List<Integer>>();
        tweetList = new ArrayList<Integer>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Integer> list = new ArrayList<Integer>();
        if (tweetMap.containsKey(userId)) {
            list = tweetMap.get(userId);
        }
        list.add(tweetId);
        tweetMap.put(userId, list);
        tweetList.add(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<Integer>();
        if (tweetMap.containsKey(userId)) {
            list = tweetMap.get(userId);
        }
        List<Integer> allList = new ArrayList<Integer>(list);
        List<Integer> followees = new ArrayList<Integer>();
        if (followMap.containsKey(userId)) {
            followees = followMap.get(userId);
        }
        for (int i = 0; i < followees.size(); i++) {
            if (tweetMap.containsKey(followees.get(i))) {
                allList.addAll(tweetMap.get(followees.get(i)));
            }
        }
        Set<Integer> set = new HashSet<Integer>(allList);
        List<Integer> feedList = new ArrayList<Integer>();
        int k = 0;
        for (int i = tweetList.size() - 1; i >= 0; i--) {
            if (k == 10) {
                break;
            }
            int tweetId = tweetList.get(i);
            if (set.contains(tweetId)) {
                feedList.add(tweetId);
                k++;
            }
        }
        return feedList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        List<Integer> list = new ArrayList<Integer>();
        if (followMap.containsKey(followerId)) {
            list = followMap.get(followerId);
        }
        if (!list.contains(followeeId)) {
            list.add(followeeId);
        }
        followMap.put(followerId, list);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            List<Integer> list = followMap.get(followerId);
            list.remove((Integer) followeeId);
            followMap.put(followerId, list);
        }
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