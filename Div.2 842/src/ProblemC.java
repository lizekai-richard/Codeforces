import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ProblemC {
    private int[] p;
    private int[] q;
    private int[] count;
    private boolean[] pHas;
    private boolean[] qHas;
    private boolean[] arrHas;
    private boolean[] duplicate;
    private final HashMap<Integer, Integer> pair = new HashMap<>();
    private final Stack<Integer> missingValues = new Stack<>();

    public void initialize(int n) {
        p = new int[n + 1];
        q = new int[n + 1];
        count = new int[n + 1];
        pHas = new boolean[n + 1];
        qHas = new boolean[n + 1];
        arrHas = new boolean[n + 1];
        duplicate = new boolean[n + 1];

        Arrays.fill(count, 0);
        Arrays.fill(pHas, false);
        Arrays.fill(qHas, false);
        Arrays.fill(arrHas, false);
        Arrays.fill(duplicate, false);
    }

    public void getMissingValues(int n, int[] arr) {
        for (int i = 0; i < n; ++i) {
            arrHas[arr[i]] = true;
        }
        for (int i = 1; i <= n; ++i) {
            if (!arrHas[i]) {
                missingValues.push(i);
            }
        }
    }

    public void getDuplicateValues(int n, int[] arr) {
        for (int i = 0; i < n; ++i) {
            count[arr[i]]++;
            if (count[arr[i]] >= 2) {
                duplicate[arr[i]] = true;
            }
        }
    }

    public void getPair(int n, int[] arr) {
        for (int i = 0; i < n; ++i) {
            if (duplicate[arr[i]] && !missingValues.empty()) {
                int m = missingValues.pop();
                pair.put(arr[i], m);
            }
        }
    }

    public int[][] solve(int n, int[] arr) {
        initialize(n);
        getMissingValues(n, arr);
        getDuplicateValues(n, arr);
        getPair(n, arr);

        for (int i = 1; i <= n; ++i) {
            if (count[i] > 2) {
                int[][] ans = new int[2][n];
                Arrays.fill(ans[0], -1);
                Arrays.fill(ans[1], -1);
                return ans;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (duplicate[arr[i]]) {
                if (pHas[arr[i]]) {
                    q[i] = arr[i];
                    p[i] = pair.get(arr[i]);
                } else {
                    p[i] = arr[i];
                    q[i] = pair.get(arr[i]);
                }
            } else {
                p[i] = arr[i];
                q[i] = arr[i];
            }
            pHas[p[i]] = true;
            qHas[q[i]] = true;
        }

        int[][] ans = new int[2][n];
        ans[0] = p;
        ans[1] = q;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProblemC c = new ProblemC();
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; ++j) {
                arr[j] = scanner.nextInt();
            }
            int[][] ans = c.solve(n, arr);
            if (ans[0][0] == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int j = 0; j < n; ++j) {
                    System.out.print(ans[0][j]);
                    System.out.print(" ");
                }
                System.out.println();
                for (int j = 0; j < n; ++j) {
                    System.out.print(ans[1][j]);
                    System.out.print(" ");
                }
            }
        }
    }

}
