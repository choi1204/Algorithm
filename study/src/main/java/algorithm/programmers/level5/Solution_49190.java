package algorithm.programmers.level5;

import java.util.*;

/**
 * 방의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/49190
 */
public class Solution_49190 {
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx = {0, 1, 1, 1, 0, -1 ,-1, -1};

    class Point {
        int y;
        int x;

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y;
        }
        Point(int y, int x) {
            this.y = y;
            this.x= x;
        }
    }
    public int solution(int[] arrows) {
        Map<Point, Set<Point>> map = new HashMap<>();
        int answer = 0;
        Point currentPoint = new Point(0, 0);
        map.put(currentPoint, new HashSet<>());
        
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                Point nextPoint = new Point(currentPoint.y + dy[arrow], currentPoint.x + dx[arrow]);
                map.get(currentPoint).add(nextPoint);
                // 다음 정점 첫 방문
                if (!map.containsKey(nextPoint)) {
                    map.put(nextPoint, initList(currentPoint));
                    // 정점은 이미 있지만 간선 처음
                } else if (!map.get(nextPoint).contains(currentPoint)) {
                    map.get(nextPoint).add(currentPoint);
                    answer++;
                }
                currentPoint = nextPoint;
            }
        }
        return answer;
    }

    private static Set<Point> initList(Point currentPoint) {
        Set<Point> set = new HashSet<>();
        set.add(currentPoint);
        return set;
    }

}
