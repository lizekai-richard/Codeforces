import java.util.Scanner;

public class ProblemA {

    public static int solve(int[] nums, int n) {
        int numOfOnes = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                numOfOnes++;
            }
        }
        int numOfPair = Math.floorDiv(numOfOnes, 2);
        return numOfPair + (n - numOfOnes) + (numOfOnes - 2 * numOfPair);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; ++j) {
                nums[j] = scanner.nextInt();
            }
            System.out.println(solve(nums, n));
        }
    }
}
