package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum<0 || sum > 9*digits)
        {
            return null;
        }
        int minsum = sum;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<digits-1;i++)
        {

            int digit = Math.min(minsum,9);
            if(digit<0)
            {
                throw new InvalidAccountNumberException("Account number can not be generated");
            }
            else
            {
                ans.append(digit);
                minsum = minsum - digit;
            }
        }
        ans.append(minsum);

        return ans.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance = this.balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount > this.balance)
        {
            throw new insufficientBalance("Insufficient Balance");
        }
        else
        {
            if(this.balance - amount < this.minBalance)
            {
                throw new insufficientBalance("Insufficient Balance");
            }
            this.balance = this.balance - amount;


        }

    }
    public static class InvalidAccountNumberException extends Exception
    {
        InvalidAccountNumberException(String msg)
        {
            super(msg);
        }

    }
    public double getBalance()
    {
        return this.getBalance();
    }

    public void setBalance(double temp)
    {
        this.balance = temp;
    }
    public static class insufficientBalance extends Exception
    {
        insufficientBalance(String msg)
        {
            super(msg);
        }

    }

}