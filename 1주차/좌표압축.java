import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        입력이 많을 때 Scanner는 매우 느림
        내부적으로 정규표현식을 사용해서 속도가 느리고
        많은 양의 입력을 처리할 때 시간 초과가 날 수 있음
        그래서 BufferedReader를 사용함
        BufferedReader는 입력을 버퍼에 쌓아서 한 번에 처리하기 때문에 매우 빠름
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        /*
        BufferedReader는 한 줄 전체를 문자열로 받기 때문에
        공백으로 구분된 숫자들을 나누려면 별도의 처리가 필요함
        StringTokenizer는 split()보다 속도도 빠르고 메모리 사용도 적음
        대량의 숫자를 처리할 때 StringTokenizer가 효율적임
        */
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = a[i];
        }

        /*
        좌표 압축을 하기 위해 정렬을 사용함
        정렬된 배열에서 중복을 제거하고 그 값을 기준으로 인덱스를 부여함
        */
        Arrays.sort(b);

        /*
        Map을 사용해서 각 숫자에 대해 압축된 인덱스를 저장함
        중복된 숫자는 한 번만 처리하도록 containsKey로 체크함
        */
        Map<Integer, Integer> m = new HashMap<>();
        int idx = 0;
        for (int x : b) {
            if (!m.containsKey(x)) {
                m.put(x, idx++);
            }
        }

        /*
        출력도 Scanner처럼 반복적으로 System.out.print를 쓰면 매우 느림
        StringBuilder를 사용해서 결과를 모두 문자열로 만들어 놓고
        마지막에 한 번만 출력하면 성능이 훨씬 좋아짐
        */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(m.get(a[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
