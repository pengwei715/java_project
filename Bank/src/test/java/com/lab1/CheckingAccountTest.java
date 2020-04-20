package com.lab1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Checking account
 */
public class CheckingAccountTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void interestTest()
    {
        float deposit=100.0f;
        String name = new String("Joe");
        Integer id = 1;
        Account ac = new CheckingAccount(id, deposit, name);
        ac.GetAccountSummary();
        assertTrue( ac.Getbanlance() == 100.0f);
    }
}
