
// Palindrome Partitioning

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:32:09
 * @url:https://leetcode.com/problems/palindrome-partitioning/
 */

//DFS
public class Solution {

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        if (s == null || "".equals(s.trim())) {
            return list;
        }
        ArrayList<String> tempList = new ArrayList<String>();
        dfs(list, tempList, s);
        return list;
    }

    public void dfs(ArrayList<ArrayList<String>> list, ArrayList<String> tempList, String s) {
        if (s.length() == 0) {
            list.add(new ArrayList<String>(tempList));
        }
        int len = s.length();
        for (int i = 1; i <= len; i++) {
            String tempStr = s.substring(0, i);
            if (isPalindromic(tempStr)) {
                tempList.add(tempStr);
                dfs(list, tempList, s.substring(i));
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public boolean isPalindromic(String s) {
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while (start <= end && start < len && end >= 0) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

//BFS
public class Solution {

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        if (s == null || "".equals(s.trim())) {
            return list;
        }
        bfs(list, s);
        return list;
    }

    public void bfs(ArrayList<ArrayList<String>> list, String s) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(new StringBuffer(), s));
        while (!queue.isEmpty()) {
            Node node = queue.peek();
            queue.poll();
            String news = node.s;
            int len = news.length();
            if (len == 0) {
                StringBuffer sb = new StringBuffer(node.sb);
                String tempStr = sb.toString().trim();
                if (tempStr.replace(" ", "").equals(s)) {
                    String msg[] = tempStr.split(" ");
                    ArrayList<String> tempList = new ArrayList<String>();
                    for (int i = 0; i < msg.length; i++) {
                        tempList.add(msg[i]);
                    }
                    list.add(tempList);
                }
            }
            for (int i = 1; i <= len; i++) {
                String tempStr = news.substring(0, i);
                StringBuffer newsb = new StringBuffer(node.sb);
                if (isPalindromic(tempStr)) {
                    newsb.append(tempStr + " ");
                    queue.offer(new Node(newsb, news.substring(i)));
                }
            }
        }
    }

    public boolean isPalindromic(String s) {
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while (start <= end && start < len && end >= 0) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public class Node {
        StringBuffer sb;
        String s;

        Node(StringBuffer sb, String s) {
            this.sb = sb;
            this.s = s;
        }
    }
}