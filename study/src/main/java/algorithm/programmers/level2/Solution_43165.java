package algorithm.programmers.level2;

/**
 * 타겟 넘버
 */
public class Solution_43165 {
    int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
        }
        int value = numbers[index];
        dfs(numbers, target, index + 1, sum + value);
        dfs(numbers, target, index + 1, sum - value);
    }
}
