package algorithm.programmers.level3;
/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43162
 * 네트워크
 */
public class Solution_43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n ; i++) {
            if (!visit[i]) {
                search(computers, i, visit);
                answer++;
            }
        }
        return answer;
    }
    void search(int[][] computers, int n, boolean[] visit) {
        visit[n] = true;
        int[] arr = computers[n];
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i] && arr[i] == 1) {
                search(computers, i, visit);
            }
        }
    }
}
