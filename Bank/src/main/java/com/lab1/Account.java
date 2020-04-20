package com.lab1;

/**
 * Hello world!
 *
 */
abstract class Account 
{
    private float banlance;
    private String name;
    public Integer id;
    
    public Account(Integer num, float money, String usr){
        banlance = money;
        name = usr;
        id = num;
    }

    protected float Getbanlance(){
        return banlance;
    }

    public void Deposit(float money){
        banlance += money;
    }

    public void Withdraw(float money){
        banlance -= money;
    }

    public void GetAccountSummary(){
        float interest = CalcInterest();
        UpdateBalance(interest);
        PrintSummary();       
    }

    public abstract float CalcInterest();

    private float UpdateBalance(float interest){
        banlance += interest;
        return banlance;
    }

    private void PrintSummary(){
        System.out.println( "Summary");
        System.out.println(String.format("account number: %s", id.toString()));
        System.out.println(String.format("name : %s", name));
        System.out.println(String.format("current balance: %f", banlance));
    }
}
