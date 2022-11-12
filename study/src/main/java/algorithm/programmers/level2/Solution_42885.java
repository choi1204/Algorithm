package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 구명보트
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
public class Solution_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;

        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                answer++;
                l++;
                r++;
            } else {
                answer++;
                r--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_42885 sol = new Solution_42885();
        sol.solution(new int[] {70,50,80}, 100);
    }
}
