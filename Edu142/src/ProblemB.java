import java.util.Scanner;

public class ProblemB {

    public static int solve(int a1, int a2, int a3, int a4) {
        int time = a1;
        int alice = a1, bob = a1;
        if (a1 == 0) {
            return 1;
        } else if (a2 < a3) {
            time = time + 2 * a2;
            a3 -= a2;
            // If alice's mood is not enough for remaining type3 jokes, then tell alice's mood amount of type3 jokes
            if (alice < a3) {
                time = time + alice + 1;
            } else {  // Otherwise, tell all remaining type3 jokes. Then choose the minimum of Alice's mood, Bob's
                // mood and type4 jokes. That number will be the number of type4 jokes we can tell.
                alice -= a3;
                time += a3;
                time += Math.min(a4, Math.min(alice, bob) + 1);
            }
        } else {
            time = time + 2 * a3;
            a2 -= a3;
            if (bob < a2) {
                time = time + bob + 1;
            } else {
                bob -= a2;
                time += a2;
                time += Math.min(a4, Math.min(alice, bob) + 1);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            int a3 = scanner.nextInt();
            int a4 = scanner.nextInt();
            System.out.println(solve(a1, a2, a3, a4));
        }
    }
}
