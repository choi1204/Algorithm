package algorithm.programmers.level1;


/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/77484
 * 로또의 최고 순위와 최저 순위
 */
public class Solution_77484 {
    public int[] solution(int[] lottos, int[] win_nums){
        int count = 0;
        int zero = 0;
        for(int num : lottos) {
            for (int compare : win_nums) {
                count = compare == num ? count + 1 : count;
            }
            zero = num == 0 ? zero + 1 : zero;
        }
        int best = 7 - count - zero;
        int worst = 7 - count;
        best = best == 7 ? 6 : best;
        worst = worst == 7 ? 6 :worst;
        int[] answer = {best, worst};
        return answer;
    }
}