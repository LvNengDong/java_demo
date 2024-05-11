//package geek.beauty.lesson._40;
//
///**
// * @Author lnd
// * @Description 0-1背包问题，回溯法解决
// * @Date 2024/4/27 21:59
// */
//public class Demo01 {
//    public static void main(String[] args) {
//        int[] weight = {2, 2, 4, 6, 3};  // 物品重量
//        new Demo01().f(weight);
//    }
//
//    private void f(int[] weight) {
//        int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
//        private int n = 5; // 物品个数
//        private int w = 9; // 背包承受的最大重量
//        public void f ( int i, int cw){ // 调用 f(0, 0)
//            if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
//                if (cw > maxW) maxW = cw;
//                return;
//            }
//            f(i + 1, cw); // 选择不装第 i 个物品
//            if (cw + weight[i] <= w) {
//                f(i + 1, cw + weight[i]); // 选择装第 i 个物品
//            }
//        }
//    }
//}
