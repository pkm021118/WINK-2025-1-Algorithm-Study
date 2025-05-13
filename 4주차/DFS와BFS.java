import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; // 인접 리스트로 그래프 표현
    static boolean[] visited; // 방문 여부 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수
        int V = sc.nextInt(); // 시작 정점

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a); // 양방향 그래프
        }

        // 인접 리스트 오름차순 정렬 (작은 번호부터 탐색)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 실행
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(); // 줄바꿈

        // BFS 실행
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }

    // 깊이 우선 탐색 (재귀)
    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " "); // 방문한 정점 출력

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next); // 방문하지 않은 정점 재귀 호출
            }
        }
    }

    // 너비 우선 탐색 (큐 사용)
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " "); // 방문한 정점 출력

            for (int next : graph[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next); // 방문하지 않은 정점 큐에 추가
                }
            }
        }
    }
}
