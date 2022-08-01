package builders;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(Money amount) {
        super(amount);
    }

    @Override
    public Money applyOn(Money money) {
        return money.add(amount);
    }

    @Override
    public String toString() {
        return "Transaction : " + amount;
    }
}
