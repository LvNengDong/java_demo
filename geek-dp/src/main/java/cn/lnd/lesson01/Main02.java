package cn.lnd.lesson01;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/6 10:29
 */
public class Main02 {
    public static void main(String[] args) {
        System.out.println(new Main02().getMinCoinCount());
    }

    int getMinCoinCount() {
        int[] values = {5, 3};  // 硬币面值
        int total = 11; // 总价
        int minCoin = getMinCoinCountLoop(total, values, 0);
        return (minCoin == Integer.MAX_VALUE) ? -1 : minCoin;
    }

    private int getMinCoinCountLoop(int total, int[] values, int k) {
        int minCount = Integer.MAX_VALUE;
        int valueCount = values.length;

        if (k == valueCount) {
            Math.min(minCount, getMinCoinCountOfValue(total, values, 0));
        }

        for (int i = k; i < valueCount; i++) {
            // k位置已经排列好
            int t = values[k];
            values[k] = values[i];
            values[i]=t;
            minCount = Math.min(minCount, getMinCoinCountLoop(total, values, k + 1)); // 考虑后一位
            // 回溯
            t = values[k];
            values[k] = values[i];
            values[i]=t;
        }
        return minCount;
    }

    private int getMinCoinCountOfValue(int total, int[] values, int valueIndex) {
        int valueCount = values.length;
        if (valueIndex == valueCount) {
            return Integer.MAX_VALUE;
        }
        int minResult = Integer.MAX_VALUE;
        int curValue = values[valueIndex];
        int maxCount = total / curValue;

        for (int count = maxCount; count >= 0; count--) {
            int rest = total - count * curValue;
            // 如果rest为0，表示余额已除尽，组合完成
            if (rest == 0) {
                minResult = Math.min(minResult, count);
                break;
            }
            // 否则尝试用剩余面值求当前余额的硬币总数
            int restCount = getMinCoinCountOfValue(rest, values, valueIndex + 1);
            // 如果后续没有可用组合
            if (restCount == Integer.MAX_VALUE) {
                // 如果当前面值已经为0，返回-1表示尝试失败
                if (count == 0) {
                    break;
                }
                // 否则尝试把当前面值-1
                continue;
            }
            minResult = Math.min(minResult, count + restCount);
        }
        return minResult;
    }
}
