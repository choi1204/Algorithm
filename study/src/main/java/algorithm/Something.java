package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Something {
    public int[] solution(int t, int[] x1, int[] y1, int[] r1, int[] x2, int[] y2, int[] r2, int[] dx1, int[] dy1, int[] dx2, int[] dy2) {
        List<Integer> answer = new ArrayList<>();
        int count = x1.length;
        for (int i = 0; i < count; i++) {
            Circle circle1 = new Circle(x1[i], y1[i], r1[i], dx1[i], dy1[i]);
            Circle circle2 = new Circle(x2[i], y2[i], r2[i], dx2[i], dy2[i]);
            int c = -1;
            double area = Double.MAX_VALUE;
            while (getSquaredArea(circle1, circle2) < area) {
                area = getSquaredArea(circle1, circle2);
                circle1.move();
                circle2.move();
                c++;
            }
            answer.add(c);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static double getSquaredArea(Circle circle1, Circle circle2) {
        return Math.pow((circle1.x - circle2.x),2) + Math.pow((circle1.y - circle2.y), 2);
    }

    class Circle {
        int x;
        int y;
        int r;
        int dx;
        int dy;
        public Circle(int x, int y, int r, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.dx = dx;
            this.dy = dy;
        }

        public void move() {
            this.x += dx;
            this.y += dy;
        }

    }

    public static void main(String[] args) {
        Something something = new Something();
        something.solution(7, new int[]{0, 0, 0, 0, 0, 6, 6}, new int[]{0, 0, 0, 0, 0, 10, 10},
                new int[]{10, 10, 10, 1, 1, 201, 201}, new int[]{11, 11, 11, 1, 1, 201, 610}, new int[]{0, 0, 0, 1, 0, 6, 201}, new int[]{1, 1, 1, 1, 1, 10, 610}, new int[]{0, 0, 0, 1000000, 1000000, 3, 6},
        new int[]{0, 0, 0, 1, 0, 60, 1000000, 4, 5}, new int[]{1, -1, -2, 999999, 999999, 5, 4},
                new int[]{0, 1, -1, 1000000, 1000000, 6, 3});
    }
}
