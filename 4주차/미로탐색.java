import java.util.*;

public class Main {
    static int N, M; // 행, 열
    static int[][] map; // 미로 정보
    static boolean[][] visited; // 방문 여부 저장
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동 방향
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 개행 제거

        map = new int[N][M];
        visited = new boolean[N][M];

        // 미로 정보 입력
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS 실행
        System.out.println(bfs(0, 0));
    }

    // BFS를 통해 최소 칸 수 탐색
    public static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x, y));

        // 탐색 거리 기록 (map을 재활용)
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 범위 밖이거나, 벽이거나, 이미 방문한 경우 skip
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (map[nx][ny] == 0 || visited[nx][ny])
                    continue;

                // 방문 처리 및 거리 누적
                visited[nx][ny] = true;
                map[nx][ny] = map[p.x][p.y] + 1; // 이전 거리 + 1
                queue.add(new Point(nx, ny));
            }
        }

        // 도착 지점의 값이 최소 칸 수
        return map[N - 1][M - 1];
    }
}
