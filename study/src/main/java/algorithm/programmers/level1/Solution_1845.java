package algorithm.programmers.level1;

/**
 * 폰켓몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Solution_1845 {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] visit = new boolean[200001];
        for (int num : nums) {
            if (!visit[num]) {
                visit[num] = true;
                answer++;
            }
        }
        if (answer > nums.length / 2) {
            answer = nums.length / 2;
        }
        return answer;
    }
}
