import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. N: 동전 종류 수, K: 목표 금액 입력
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 2. 동전 가치 배열 선언
        int[] coins = new int[N];

        // 3. 동전 가치 입력 받기
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int count = 0; // 필요한 동전 개수의 합

        // 4. 큰 동전부터 사용하기 위해 뒤에서부터 순회
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                // 현재 금액 K에서 해당 동전을 몇 개 쓸 수 있는지 계산
                int use = K / coins[i];
                count += use; // 사용한 동전 개수 누적
                K -= use * coins[i]; // 사용한 금액만큼 차감
            }
        }

        // 5. 결과 출력: 최소 동전 개수
        System.out.println(count);
    }
}
