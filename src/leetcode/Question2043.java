package leetcode;

/**
 * 直接模拟
 */
public class Question2043 {

    private final long[] remain;

    public Question2043(long[] balance) {
        this.remain = balance;
    }

    public boolean isInvalid(int account) {
        return account < 1 || account > remain.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (isInvalid(account1) || isInvalid(account2) || remain[account1 - 1] < money) {
            return false;
        }
        remain[account1 - 1] -= money;
        remain[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (isInvalid(account)) {
            return false;
        }
        remain[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (isInvalid(account) || remain[account - 1] < money) {
            return false;
        }
        remain[account - 1] -= money;
        return true;
    }
}
