package omnirio.model;

import java.util.Objects;

public class Account {

    private String accountID;
    private String accountType;
    private String openDate;
    private String customerID;
    private String branch;
    private String flagAge;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFlagAge() {
        return flagAge;
    }

    public void setFlagAge(String flagAge) {
        this.flagAge = flagAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountID, account.accountID) &&
                Objects.equals(accountType, account.accountType) &&
                Objects.equals(openDate, account.openDate) &&
                Objects.equals(customerID, account.customerID) &&
                Objects.equals(branch, account.branch) &&
                Objects.equals(flagAge, account.flagAge);
    }

    @Override
    public int hashCode() {

        return Objects.hash(accountID, accountType, openDate, customerID, branch, flagAge);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", accountType='" + accountType + '\'' +
                ", openDate='" + openDate + '\'' +
                ", customerID='" + customerID + '\'' +
                ", branch='" + branch + '\'' +
                ", flagAge='" + flagAge + '\'' +
                '}';
    }
}
