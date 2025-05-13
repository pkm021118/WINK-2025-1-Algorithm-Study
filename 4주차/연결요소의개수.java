import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; // 그래프를 인접 리스트로 표현
    static boolean[] visited; // 방문 여부 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 수
        int M = sc.nextInt(); // 간선의 수

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 및 양방향 연결
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u); // 무방향 그래프이므로 양쪽에 모두 추가
        }

        visited = new boolean[N + 1]; // 정점 방문 여부 저장 배열
        int count = 0; // 연결 요소 개수

        // 각 정점에 대해 DFS를 수행 (방문 안 한 경우만)
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i); // DFS 또는 BFS 모두 가능
                count++; // DFS 한 번 끝날 때마다 새로운 연결 요소
            }
        }

        System.out.println(count); // 결과 출력
    }

    // DFS 구현
    public static void dfs(int v) {
        visited[v] = true;

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
