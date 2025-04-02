import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력 처리 (Scanner는 느리므로 BufferedReader 사용)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> m = new HashMap<>();

        // 숫자 카드의 범위가 2^62보다 작다 했으므로 long 타입 사용
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            m.put(x, m.getOrDefault(x, 0) + 1);
        }

        /*
        Map의 keySet을 list로 변환 후 정렬하는 이유
        1. 가장 많이 나온 숫자를 찾아야 함
        2. 동점인 경우 작은 수를 출력해야 함
        그래서 정렬을 먼저 하면 가장 작은 수부터 탐색 가능
        이후 count가 가장 큰 것을 찾아내면, 자동으로 조건을 만족함

        sort를 먼저 하면 동일 빈도면 작은 수라는 조건을 손쉽게 처리 가능
        */
        List<Long> keyList = new ArrayList<>(m.keySet());
        Collections.sort(keyList); // 오름차순 정렬 (기본)

        long ans = 0;
        int max = 0;

        for (long k : keyList) {
            int cnt = m.get(k);
            if (cnt > max) {
                max = cnt;
                ans = k;
            }
            // cnt == max 인 경우는 무시, 이미 정렬되어 있어서 작은 수가 먼저 나옴
        }

        System.out.println(ans);
    }
}
