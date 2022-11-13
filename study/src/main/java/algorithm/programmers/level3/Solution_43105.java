package algorithm.programmers.level3;

/**
 * 정수 삼각형
 */
public class Solution_43105 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = triangle[i][j];
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (i == triangle.length - 1) {
                    answer = Math.max(dp[i][j], answer);
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j] + triangle[i + 1][j], dp[i + 1][j]);
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + triangle[i + 1][j + 1], dp[i + 1][j + 1]);
                }
            }
        }


        return answer;
    }
}
