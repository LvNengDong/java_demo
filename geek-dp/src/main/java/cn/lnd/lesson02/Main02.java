package cn.lnd.lesson02;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/10 12:21
 */
public class Main02 {
    public static void main(String[] args) {
        int res = new Main02().fibonacci(5);
        System.out.println(res);
    }

    /**
     * 斐波那契——递归解法
     * @param n
     * @return
     */
    int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}


