package com.lab1;

/**
 * code for saving account
 *
 */
public class SavingAccount extends Account 
{
    private float interestRate;

    public SavingAccount(Integer num, float money, String usr, float rate){
        super(num, money, usr);
        interestRate = rate;
    }

    @Override
    public float CalcInterest(){
        return Getbanlance()*interestRate;   
    }
}
