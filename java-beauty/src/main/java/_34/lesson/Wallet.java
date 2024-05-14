package _34.lesson;

/**
 * @Author lnd
 * @Description 使用类锁代理对象锁
 * @Date 2024/5/11 23:07
 */
public class Wallet {
    private int balance;

    public void transferTo(Wallet targetWallet, int amount) {
        synchronized (Wallet.class) {
            if (this.balance >= amount) {
                this.balance -= amount;
                targetWallet.balance += amount;
            }
        }
    }
}
