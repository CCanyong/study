package qiniu;

/**
 * @author 陈灿勇
 * @version 0.0.1
 * @since 28/04/2020 20:03
 */


public class BankAccount {
    private volatile long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    static void transferFrom(BankAccount source, BankAccount dest, long amount) {
        source.balance -= amount;
        dest.balance += amount;
    }

    public synchronized long balance() {
        return balance;
    }
}
