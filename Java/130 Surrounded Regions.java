
// Surrounded Regions

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年07月02日16:35:58
 * @url:https://leetcode.com/problems/surrounded-regions/
 */

public class Solution {

    public int stepArr[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int visit[][];
    public int m, n, startx, starty;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        && visit[i][j] == 0 && board[i][j] == 'O') {
                    startx = i;
                    starty = j;
                    bfs(board);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] != 1 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char board[][]) {
        Queue<Node> queue = new LinkedList<Node>();
        Node node = new Node(startx, starty);
        queue.offer(node);
        visit[startx][starty] = 1;
        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();
            int newx = 0;
            int newy = 0;
            for (int i = 0; i < 4; i++) {
                newx = node.x + stepArr[i][0];
                newy = node.y + stepArr[i][1];
                if (newx >= 0 && newx < m && newy >= 0 && newy < n
                        && visit[newx][newy] == 0 && board[newx][newy] == 'O') {
                    visit[newx][newy] = 1;
                    queue.offer(new Node(newx, newy));
                }
            }
        }
    }

    public class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}