package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance < 5000)
        {
            throw new insufficientBalance("Insufficient Balance");
        }
        else
        {
            this.tradeLicenseId = tradeLicenseId;
        }

    }

    public String getTradeLicenseId()
    {
        return this.tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(this.tradeLicenseId == null )
        {
            throw new invalidLicense("Valid License can not be generated");
        }
        if(this.tradeLicenseId.length()<2)
        {
            return;
        }
        char[] chars = this.tradeLicenseId.toCharArray();
        for(int i=1;i<chars.length;i++)
        {
            if(chars[i]==chars[i-1])
            {
                rearrange(chars,i);
            }
        }
        if(check(chars))
        {
            throw new invalidLicense("Valid License can not be generated");
        }
        else
        {
            this.tradeLicenseId = chars.toString();
        }

    }
    public boolean check(char[] chars)
    {
        for(int i=1;i<chars.length;i++)
        {
            if(chars[i]==chars[i-1])
            {
                return true;
            }
        }
        return false;
    }
    public void rearrange(char[] chars,int index)
    {
        char temp = chars[index];
        chars[index] = chars[chars.length-index];
        chars[chars.length-index] = temp;

    }
    public static class insufficientBalance extends Exception
    {
        insufficientBalance(String msg)
        {
            super(msg);
        }

    }
    public static class invalidLicense extends Exception
    {
        invalidLicense(String msg)
        {
            super(msg);
        }

    }

}
