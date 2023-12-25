package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount > maxWithdrawalLimit)
        {
            throw new insufficientBalance("Maximum Withdraw Limit Exceed");
        }
        if(this.getBalance()<amount)
        {
            throw new insufficientBalance("Insufficient Balance");
        }
        else
        {
            this.setBalance(this.getBalance()-amount);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return (this.getBalance()*this.rate*years)/100;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double principle = (this.getBalance()) * Math.pow((1+(rate/times)),times*years);
        return principle - this.getBalance();

    }
    public static class insufficientBalance extends Exception
    {
        insufficientBalance(String msg)
        {
            super(msg);
        }

    }

}
