/*************************************************
 File: BankAccount.java
 By: Jeanine Nebrija
 Date: 4/24/24
 Compile: Open directory as IntelliJ project, compile and run.
 System: Windows w/ Java
 Description: Initializing the Bank Account of the customer.
 *************************************************/

import java.time.LocalDate;

public class BankAccount implements Comparable<BankAccount>{
    private String acctNum;
    private int custNum;
    private double balance;
    private LocalDate dateCreated;
    private LocalDate lastUpdateDate;
    private String acctType;
    private double odLimit;
    private double intRate;

    public BankAccount(String acct_num){
        this.acctNum=acct_num;
    }

    public static BankAccount parseJson(String s) {
//        ObjectMapper om=new ObjectMapper();
//        JsonNode jn = null;
//        try {jn = om.readTree(s);}
//        catch (JsonProcessingException e) {throw new RuntimeException(e);}
        return new BankAccount("1");
    }

    public String getAcctNum(){
        return this.acctNum;
    }
    public double getBalance(){return this.balance;}
    public void setBalance(double balance){this.balance=balance;}

    public LocalDate getDateCreated(){return this.dateCreated;}


    @Override
    public int compareTo(BankAccount o) {
        //compare dateCreated first
        int comparison=-Integer.compare(o.getDateCreated().compareTo(this.getDateCreated()), 0);

        //if equal, compare account balance
        if(comparison==0) return Double.compare(o.getBalance(),this.getBalance());
        else return comparison;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
        "acctNum = '" + acctNum + '\'' +
        ", custNum = " + custNum +
        ", balance = " + balance +
        ", dateCreated = '" + dateCreated + '\'' +
        ", lastUpdateDate = '" + lastUpdateDate + '\'' +
        ", acctType = '" + acctType + '\'' +
        ", odLimit = " + odLimit +
        ", intRate = " + intRate +
        '}';
    }

    public void setAcctNum(String acctNum) {
        this.acctNum=acctNum;
    }

    public int getCustNum() {
        return this.custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum=custNum;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public double getOdLimit() {
        return odLimit;
    }

    public void setOdLimit(double odLimit) {
        this.odLimit = odLimit;
    }

    public double getIntRate() {
        return intRate;
    }

    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }
}
