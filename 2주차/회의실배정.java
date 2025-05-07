import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 회의 개수 입력 받기
        int n = sc.nextInt();

        // 각 회의의 시작 시간과 종료 시간을 저장할 2차원 배열 선언
        int[][] meetings = new int[n][2];

        // 회의 정보 입력 받기
        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 끝나는 시간
        }

        // 회의를 끝나는 시간 기준으로 정렬
        // 끝나는 시간이 같으면 시작 시간을 기준으로 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0]; // 끝나는 시간이 같을 경우 시작 시간 기준으로 오름차순
            }
            return a[1] - b[1]; // 끝나는 시간 기준으로 오름차순 정렬
        });

        // 선택된 회의 수를 저장할 변수
        int count = 0;

        // 마지막으로 선택된 회의의 끝나는 시간을 저장할 변수
        int lastEndTime = 0;

        // 정렬된 회의 리스트를 순회하면서 회의 선택
        for (int i = 0; i < n; i++) {
            // 현재 회의의 시작 시간이 마지막으로 선택한 회의의 끝나는 시간보다 같거나 크면 선택 가능
            if (meetings[i][0] >= lastEndTime) {
                lastEndTime = meetings[i][1]; // 현재 회의의 끝나는 시간을 갱신
                count++; // 선택한 회의 수 증가
            }
        }

        // 결과 출력: 겹치지 않게 선택할 수 있는 회의의 최대 개수
        System.out.println(count);
    }
}
