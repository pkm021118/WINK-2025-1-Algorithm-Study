import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 수식 입력 받기
        String expression = sc.nextLine();

        // 수식을 '-' 기호를 기준으로 나누기
        // '-'를 기준으로 괄호를 묶으면 전체 값을 최소화할 수 있음
        String[] parts = expression.split("-");

        // 첫 번째 부분은 괄호를 씌울 수 없기 때문에 무조건 더해줌
        int result = sum(parts[0]);

        // 두 번째 부분부터는 괄호로 묶어 전체를 한꺼번에 빼줌
        for (int i = 1; i < parts.length; i++) {
            // 각 파트를 '+' 기준으로 나누고 합한 다음 result에서 빼기
            result -= sum(parts[i]);
        }

        // 계산 결과 출력
        System.out.println(result);
    }

    // 문자열을 '+' 기준으로 나눈 후 각 숫자를 모두 더한 값을 반환하는 함수
    private static int sum(String str) {
        // '+' 기호를 기준으로 나누기
        String[] tokens = str.split("\\+");

        int total = 0;

        // 나뉜 각 숫자를 정수로 바꾸어 더해줌
        for (String token : tokens) {
            total += Integer.parseInt(token); // 문자열 숫자를 정수로 변환 후 누적
        }

        return total; // 전체 합 반환
    }
}
