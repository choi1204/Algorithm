package algorithm.programmers.level1;

/**
 * 평균 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12944
 */
public class Solution_12944 {
    public double solution(int[] arr) {
        double answer = 0;
        for (int num : arr) {
            answer += num;
        }
        answer /= arr.length;
        return answer;
    }
}
