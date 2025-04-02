import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner 쓰면 시간 초과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 숫자의 최대 범위가 10,000 미만이므로 배열로 카운트 가능
        // 각 숫자가 몇 번 나왔는지 배열에 저장
        int[] cnt = new int[10001];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            cnt[x]++;
        }

        //StringBuilder로 문자열 한 번에 출력
        StringBuilder sb = new StringBuilder();

        /*
        등장한 숫자를 오름차순으로 탐색하면서 그 수가 몇 번 나왔는지를 기반으로 출력
        시간복잡도는 O(N + K), 여기서는 거의 O(N)으로 동작
        */
        for (int i = 1; i < 10001; i++) {
            while (cnt[i]-- > 0) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }
}
