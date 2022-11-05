package algorithm.programmers.level1;

/**
 * 최소직사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Solution_86491 {
    public int solution(int[][] sizes) {
        int maxV = 0;
        int maxH = 0;
        for (int[] size : sizes) {
            int v = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            maxV = Math.max(v, maxV);
            maxH = Math.max(h,maxH);
        }
        return maxV * maxH;
    }
}
