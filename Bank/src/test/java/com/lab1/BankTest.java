package com.lab1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Bank.
 */
public class BankTest 
{
    /**
     * Rigorous Test :-)
     */
    //test only one bank
    @Test
    public void oneBankTest() {
        Bank b1 = Bank.getSingleBank();
        Bank b2 = Bank.getSingleBank();
        assertTrue( b1 == b2 );
    }
    
    //test open account
    @Test
    public void openAccountTest() {
        Bank b = Bank.getSingleBank();
        float deposit=100.0f;
        String name = new String("Joe");
        String type1 = new String("checking");
        String type2 = new String("saving");
        Integer id1 =  b.openAccount(deposit, name, type1);
        Integer id2 = b.openAccount(deposit, name, type2);
        
        assertTrue(b.getAccount(id1).Getbanlance()==100.0);
        assertTrue(b.getAccount(id2).Getbanlance()==100.0);
    }

    //test close account
    @Test
    public void closeAccountTest() {
        Bank b = Bank.getSingleBank();
        float deposit=100.0f;
        String name = new String("Joe");
        String type1 = new String("checking");
        String type2 = new String("saving");
        Integer id1 =  b.openAccount(deposit, name, type1);
        Integer id2 = b.openAccount(deposit, name, type2);
        float left1 = b.closeAccount(id1);
        float left2 = b.closeAccount(id2);
        assertTrue(left1==100.0);
        assertTrue(left2==100.0);
    }

}
