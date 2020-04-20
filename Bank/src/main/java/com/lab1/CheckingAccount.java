package com.lab1;

/**
 * code for checking account
 *
 */
public class CheckingAccount extends Account
{
    public CheckingAccount(Integer num, float money, String usr){
        super(num, money, usr);
    }

    @Override
    public float CalcInterest(){
        return 0;  
    }
}
