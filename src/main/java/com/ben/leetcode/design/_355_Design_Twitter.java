package com.ben.leetcode.design;

import java.util.*;

public class _355_Design_Twitter {
    static class Twitter {

        static class Tweet {
            public int id;
            public long time;
            public Tweet next;

            public Tweet(int id) {
                this.id = id;
                this.time = timeStamp++;
                next = null;
            }
        }

        static class User {
            public int id;
            public Set<Integer> followed;
            public Tweet head;

            public User(int id) {
                this.id = id;
                this.followed = new HashSet<>();
                follow(id);
                head = null;
            }

            public void follow(int id) {
                this.followed.add(id);
            }

            public void unfollow(int id) {
                this.followed.remove(id);
            }

            public void post(int id) {
                Tweet t = new Tweet(id);
                t.next = head;
                head = t;
            }
        }

        private static long timeStamp = 0;

        private Map<Integer, User> userMap;

        public Twitter() {
            this.userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            User user = getUser(userId);
            user.post(tweetId);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new LinkedList<>();
            User user = this.userMap.get(userId);
            if (user == null)
                return res;

            Set<Integer> users = user.followed;
            PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> (int) (b.time - a.time));

            for (int u : users) {
                Tweet t = getUser(u).head;
                if (t != null)
                    queue.add(t);
            }

            int n = 0;
            while (!queue.isEmpty() && n < 10) {
                Tweet t = queue.poll();
                res.add(t.id);
                n++;
                if (t.next != null)
                    queue.add(t.next);
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            User follower = getUser(followerId);
            User followee = getUser(followeeId);

            follower.follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followeeId == followerId)
                return;

            getUser(followerId).unfollow(followeeId);
        }

        private User getUser(int userId) {
            User user = userMap.get(userId);
            if (user == null) {
                user = new User(userId);
                userMap.put(userId, user);
            }
            return user;
        }
    }
}
