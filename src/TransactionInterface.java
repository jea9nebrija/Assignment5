
public interface TransactionInterface {
    String execute();

    double getAmount();
    BankAccount getDestinationAccount();
    BankAccount getSourceAccount();

    String getType();

    void setDescription(String sampleDeposit);

    String getDescription();
}