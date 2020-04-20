package com.lab1;

import java.util.Scanner;

/**
 * main function
 *
 */
public class App 
{
    private static Bank b = Bank.getSingleBank();

    private static void show(){
        System.out.println( "ATM system" );
        System.out.println( "1.Open account" );
        System.out.println( "2.Deposit" );
        System.out.println( "3.Withdraw");
        System.out.println( "4.Get summary");
        System.out.println( "5.Close account");
        System.out.println( "6.Exit");
    }
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        while(true){
            show();
            int opt = Integer.parseInt(sc.nextLine());
            switch(opt) {
                case 1:
                    System.out.println("Enter name, deposit, account type");
                    String name = sc.nextLine();
                    float deposit = sc.nextFloat();
                    String temp = sc.nextLine();
                    String type = sc.nextLine();
                    b.openAccount(deposit, name, type);
                    break;
                case 2:
                    System.out.println("Enter account number, amount");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    float money = sc.nextFloat();
                    sc.nextLine();
                    Account ac = b.getAccount(id);
                    ac.Deposit(money);
                    b.UpdateAccount(id, ac);
                    break;
                case 3:
                    System.out.println("Enter account number, amount");
                    Integer id1 = sc.nextInt();
                    sc.nextLine();
                    float money1 = sc.nextFloat();
                    sc.nextLine();
                    Account ac1 = b.getAccount(id1);
                    ac1.Withdraw(money1);
                    b.UpdateAccount(id1, ac1);
                    break;
                case 4:
                    System.out.println("Enter account number");
                    Integer id2 = sc.nextInt();
                    sc.nextLine();
                    b.getAccount(id2).GetAccountSummary();
                    break;
                case 5:
                    System.out.println("Enter account number");
                    Integer id3 = sc.nextInt();
                    sc.nextLine();
                    b.closeAccount(id3);
                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("wrong option!");
            }
        }
        
    }
}
