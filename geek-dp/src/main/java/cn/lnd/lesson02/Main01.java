package cn.lnd.lesson02;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/10 12:21
 */
public class Main01 {
    public static void main(String[] args) {
        int res = new Main01().fibonacci(5);
        System.out.println(res);
    }

    /**
     * 斐波那契——迭代解法
     * @param n
     * @return
     */
    int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int res = 0;
        int prev = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            res = prev + cur;
            prev = cur;
            cur = res;
        }
        return res;
    }
}


