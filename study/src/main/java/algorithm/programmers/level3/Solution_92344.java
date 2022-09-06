package algorithm.programmers.level3;

/**
 * 파괴되지 않은 건물
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */
public class Solution_92344 {
    public int solution(int[][] board, int[][] skill) {
        int r = board.length;
        int c = board[0].length;
        int sum[][] = new int[r + 1][c + 1];

        for (int i = 0; i < skill.length; i++) {
            play(sum, skill[i][0], skill[i][1], skill[i][2],
                    skill[i][3], skill[i][4], skill[i][5]);
        }
        sum(board, sum);
        return check(board, sum);
    }

    public int check(int[][] board, int[][] sum) {
        int check = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + sum[i][j] > 0) {
                    check++;
                }
            }
        }
        return check;
    }

    private static void sum(int[][] board, int[][] sum) {
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 1; i < board.length; i++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
    }

    public void play(int[][] sum, int type, int r1, int c1,
                     int r2, int c2, int degree) {
        degree *= type == 1 ? -1 : 1;
        sum[r1][c1] += degree;
        sum[r1][c2 + 1] -= degree;
        sum[r2 + 1][c1] -= degree;
        sum[r2 + 1][c2 + 1] += degree;
    }
}
