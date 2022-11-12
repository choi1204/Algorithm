package algorithm.programmers.level3;

import java.util.*;

/**
 * 퍼즐 조각 채우기
 * https://school.programmers.co.kr/learn/courses/30/lessons/84021
 */
public class Solution_84021 {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> boardBlank = getList(game_board, 0);
        List<List<int[]>> puzzle = getList(table, 1);
        return fillPuzzle(boardBlank, puzzle);
    }

    private int fillPuzzle(List<List<int[]>> boardBlankList, List<List<int[]>> puzzleList) {
        int size = 0;
        int puzzleSize = puzzleList.size();
        int boardSize = boardBlankList.size();
        boolean[] checkBoard = new boolean[boardBlankList.size()];

        for (int i = 0; i < puzzleSize; i++) {
            List<int[]> puzzle = puzzleList.get(i);
            for (int j = 0; j < boardSize; j++) {
                List<int[]> blankBoard = boardBlankList.get(j);
                if (puzzle.size() != blankBoard.size() || checkBoard[j]) {
                    continue;
                }
                if (isFill(puzzle, blankBoard)) {
                    size += puzzle.size();
                    checkBoard[j] = true;
                    break;
                }
            }
        }
        return size;
    }

    private boolean isFill(List<int[]> puzzle, List<int[]> blankBoard) {
        boolean isFill = false;
        blankBoard.sort((o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]));

        for (int i = 0; i < 4; i++) {
            puzzle.sort((o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]));
            int nearZeroX = puzzle.get(0)[0];
            int nearZeroY = puzzle.get(0)[1];

            for (int j = 0; j < puzzle.size(); j++) {
                puzzle.get(j)[0] -= nearZeroX;
                puzzle.get(j)[1] -= nearZeroY;
            }

            boolean isFillPoint = true;
            for (int j = 0; j < puzzle.size(); j++) {
                int[] puzzlePoint = puzzle.get(j);
                int[] boardPoint = blankBoard.get(j);

                if (boardPoint[0] != puzzlePoint[0] || boardPoint[1] != puzzlePoint[1]) {
                    isFillPoint = false;
                    break;
                }
            }
            if (isFillPoint) {
                isFill = true;
                break;
            } else {
                for (int j = 0; j < puzzle.size(); j++) {
                    int temp = puzzle.get(j)[0];
                    puzzle.get(j)[0] = puzzle.get(j)[1];
                    puzzle.get(j)[1] = temp;
                }
            }
        }
        return isFill;
    }

    public List<List<int[]>> getList(int[][] arr, int searchValue) {
        int y = arr.length;
        int x = arr[0].length;
        List<List<int[]>> list = new ArrayList<>();
        boolean[][] visit = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visit[i][j] && arr[i][j] == searchValue) {
                    list.add(bfs(arr, i, j, searchValue, visit));
                }
            }
        }
        return list;
    }

    private List<int[]> bfs(int[][] arr, int y, int x, int searchValue, boolean[][] visit) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {0, 0});
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (nextX < 0 || nextY < 0 || nextX >= arr[0].length || nextY >= arr.length) {
                    continue;
                }
                if (visit[nextY][nextX] || arr[nextY][nextX] != searchValue) {
                    continue;
                }
                visit[nextY][nextX] = true;
                queue.add(new int[]{nextY, nextX});
                list.add(new int[]{nextY - y, nextX - x});
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution_84021 sol = new Solution_84021();
        sol.solution(new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}},
                new int[][] {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}});
    }
}

