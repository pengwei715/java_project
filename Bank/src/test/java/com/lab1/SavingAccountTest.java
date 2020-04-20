package com.lab1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for saving account
 */
public class SavingAccountTest 
{
    @Test
    public void positiveRate()
    {
        float deposit=100.0f;
        String name = new String("Joe");
        Integer id = 1;
        float rate = 0.01f;
        Account ac = new SavingAccount(id, deposit, name, rate);
        ac.GetAccountSummary();
        float res = ac.Getbanlance();
        float interest = res - 100.0f;
        assertTrue( String.format("interest: %f",interest), interest == 1.0f);
        assertTrue( res==101);
    }
}
