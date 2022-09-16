package algorithm.programmers.level1;

/*
직사각형 남은 한점 구하기
데모테스트
 */
public class Solution_1878 {
    public int[] solution(int[][] v) {

        int answer[] = new int[2];

        for (int i = 0; i < 2; i++) {
            if (v[0][i] == v[1][i]) {
                answer[i] = v[2][i];
            } else if (v[0][i] == v[2][i]) {
                answer[i] = v[1][i];
            } else {
                answer[i] = v[0][i];
            }
        }
        return answer;
    }
}
