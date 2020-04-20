package com.lab1;
import java.util.*;

/**
 * Singleton Bank class
 *
 */
public class Bank 
{ 
    private static Bank oneBank;
    private static Hashtable<Integer, Account> accounts;

    private Bank() {
        accounts = new Hashtable<Integer, Account>();
    }
    private static Integer idGenerater(){
        Random rand = new Random();
        while (true) {
            Integer newNum = rand.nextInt(100000000);
            if (accounts.get(newNum) == null) {
                return newNum;
            }            
        } 
    }

    public static Bank getSingleBank() {
        if (oneBank == null) {
            synchronized (Bank.class){
                if (oneBank == null) {
                    oneBank = new Bank();
                }
            } 
        }
        return oneBank;
    }

    private float GetCurrentRate(){
        Random rd = new Random();
        float res = rd.nextFloat();
        while(res > 0.05){
            res = rd.nextFloat();
        }
        return res;
    }

    public void UpdateAccount(Integer id, Account ac){
        accounts.put(id, ac);
    }
    
    
    public Integer openAccount(float deposit, String name, String type) {
        Integer accountNum = idGenerater();
        if (accounts.get(accountNum) == null) {
            synchronized(accounts){   
                if (accounts.get(accountNum) == null) {
                    if (type.equals("checking")){
                        Account newAccount = new CheckingAccount(accountNum, deposit, name);
                        accounts.put(accountNum, newAccount);
                        System.out.println(String.format("Your account number is : %d",accountNum));
                        return accountNum;
                    }
                    else {
                        float rate = GetCurrentRate();
                        Account newAccount = new SavingAccount(accountNum, deposit, name, rate);
                        accounts.put(accountNum, newAccount);
                        System.out.println(String.format("Your account number is : %d", accountNum));
                        return accountNum;
                    }
                      
                }
            }
        }
        return -1;
    }

    public Account getAccount(Integer id){
        if (accounts.get(id) != null){
            return accounts.get(id);
        }
        return null;
    }

    public float closeAccount(Integer oldId) {
        if (accounts.get(oldId) != null) {
            synchronized(accounts){
                if (accounts.get(oldId) != null) {
                    Account oldAccount = accounts.get(oldId);
                    accounts.remove(oldId);
                    System.out.println(String.format("return %f", oldAccount.Getbanlance()));
                    return oldAccount.Getbanlance();    
                }
            }
        }
        return 0;
        
    }
}
