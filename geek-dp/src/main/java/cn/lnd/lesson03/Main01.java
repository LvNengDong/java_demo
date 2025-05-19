package cn.lnd.lesson03;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/11 17:22
 */
public class Main01 {
    public static void main(String[] args) {
        int res = new Main01().fibonacciAdvance(5);
        System.out.println(res);
    }

    int fibonacciAdvance(int n) {
        int[] memo = new int[n + 1];
        return fibonacci(n, memo);
    }

    int fibonacci(int n, int[] memo) {
        if (0 == n || 1 == n) {
            return n;
        }

        if (memo[n] != 0) { // 看来备忘录中找到了之前计算的结果，既然找到了，直接返回，避免重复计算
            return memo[n];
        }

        if (n > 1) {
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);  // 给备忘录赋值
            return memo[n];
        }

        return 0; // 如果数值无效(比如 < 0)，则返回0
    }
}
