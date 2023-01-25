import java.util.Scanner;

public class ProblemC {

    public static int solve(int[] nums, int n) {
        int numOfOps = 0;
        int[] pos = new int[n + 10];
        for (int i = 1; i <= n; ++i) {
            pos[nums[i]] = i;
        }
        for (int i = 1; i <= n / 2; ++i) {
            if (pos[i] > pos[n - i + 1]) {
                numOfOps = Math.max(numOfOps, i);
            }
        }
        for (int i = 1; i <= (n + 1) / 2; ++i) {
            if (pos[i] < pos[i - 1] || pos[n - i + 2] < pos[n - i + 1]) {
                numOfOps = Math.max(numOfOps, i - 1);
            }
        }
        return numOfOps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = scanner.nextInt();
            int[] nums = new int[n + 1];
            for (int j = 1; j <= n; ++j) {
                nums[j] = scanner.nextInt();
            }
            System.out.println(solve(nums, n));
        }
    }
}
