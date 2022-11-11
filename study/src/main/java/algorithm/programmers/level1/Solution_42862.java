package algorithm.programmers.level1;

/**
 * 체육복
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Solution_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 2];
        int answer = 0;
        for (int index : lost) {
            arr[index] = -1;
        }

        for (int index : reserve) {
            arr[index] += 1;
        }

        for (int i = 1 ; i<= n; i++) {
            if (arr[i] == -1) {
                if (arr[i - 1] == 1) {
                    arr[i - 1] = 0;
                    arr[i] = 0;
                } else if (arr[i + 1] == 1) {
                    arr[i] = 0;
                    arr[i + 1] = 0;
                }
            }
            if (arr[i] >= 0) {
                answer++;
            }
        }
        return answer;
    }
}
