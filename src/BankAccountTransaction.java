/*************************************************
 File: BankAccountTransaction.java
 By: Jeanine Nebrija
 Date: 4/24/24
 Compile: Open directory as IntelliJ project, compile and run.
 System: Windows w/ Java
 Description: Initializing Bacnk Account Transaction of the customer.
 *************************************************/


import java.time.LocalDateTime;

public class BankAccountTransaction implements Comparable<BankAccountTransaction>{
    private int id;
    private LocalDateTime datetime;
    private String type;
    private double amount;
    private String description;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private String status;
    private BankAccount account;

    public BankAccountTransaction(TransactionInterface t){
        this.destinationAccount=t.getDestinationAccount();
        this.amount=t.getAmount();
        this.type=t.getType();
        this.description=t.getDescription();
        this.status="PENDING";
    }

    @Override
    public int compareTo(BankAccountTransaction o) {
        return Integer.compare(o.getDate().compareTo(this.getDate()), 0);
    }

    @Override
    public String toString() {
        String str= "Transaction{";
        if(sourceAccount!=null){
            str+="sourceAccount = '" + sourceAccount.getAcctNum() + '\'';
        }
        if(destinationAccount!=null){
            str+="sourceAccount = '" + destinationAccount.getAcctNum() + '\'';
        }
        str+=", amount = " + amount +
            ", type = '" + type + '\'' +
            ", status = '" + status + '\'' +
            ", description = '" + description + '\'' +
            ", datetime = '" + datetime + '\'' +
            '}';

        return str;
    }

    public String execute(TransactionInterface t){
        status=t.execute();
        datetime=LocalDateTime.now();
        return status;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id=id;}

    public double getAmount() {return amount;}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return datetime;
    }

    public void setDate(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getRemarks() {return description;}

    public void setRemarks(String description) {
        this.description = description;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public BankAccount getSourceAccount() { return sourceAccount;}

    public void setSourceAccount(BankAccount sourceAccount) { this.sourceAccount = sourceAccount;}

    public BankAccount getDestinationAccount() {return destinationAccount;}

    public void setDestinationAccount(BankAccount destinationAccount) {this.destinationAccount = destinationAccount;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public static class DepositTransaction implements TransactionInterface {
        private final BankAccount destinationAccount;
        private final BankAccount sourceAccount;
        private final double amount;
        private String description;


        public DepositTransaction(BankAccount destinationAccount, double amount){
            this.sourceAccount = null;
            this.destinationAccount=destinationAccount;
            this.amount=amount;
            System.out.println("Deposit prepared for account#" + destinationAccount.getAcctNum() + ", " + "amount:" + amount);
        }

        @Override
        public String execute() {
            destinationAccount.setBalance(destinationAccount.getBalance()+amount);
            return "SUCCESS";
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public BankAccount getDestinationAccount() {
            return destinationAccount;
        }

        @Override
        public BankAccount getSourceAccount() {
            return sourceAccount;
        }

        @Override
        public String getType() {
            return "DEPOSIT";
        }

        @Override
        public void setDescription(String description) {
            this.description=description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static class WithdrawalTransaction implements TransactionInterface {
        private final BankAccount sourceAccount;
        private final BankAccount destinationAccount;
        private final double amount;
        private String description;

        public WithdrawalTransaction(BankAccount account, double amount){
            this.sourceAccount=account;
            this.destinationAccount=null;
            this.amount=amount;
            System.out.println("Deposit prepared for account#" + account.getAcctNum() + ", " + "amount:" + amount);
        }

        @Override
        public String execute() {
            if(sourceAccount.getBalance()<amount){
                return "FAILED -  INSUFFICIENT FUNDS";
            }

            sourceAccount.setBalance(sourceAccount.getBalance()-amount);
            return "SUCCESS";
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public BankAccount getSourceAccount() {
            return sourceAccount;
        }

        @Override
        public BankAccount getDestinationAccount() {
            return destinationAccount;
        }

        @Override
        public String getType() {
            return "WITHDRAWAL";
        }

        @Override
        public void setDescription(String description) {
            this.description=description;
        }

        public String getDescription() {
            return description;
        }
    }
}


