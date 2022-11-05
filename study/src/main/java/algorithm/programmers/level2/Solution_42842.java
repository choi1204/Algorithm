package algorithm.programmers.level2;

/**
 * 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Solution_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) {
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int mid = (col - 2) * (row - 2);

                if (mid == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
        }
        return answer;
    }
}
