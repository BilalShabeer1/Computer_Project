/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.util.HashMap;
import java.util.Scanner;

public class BankAccount {
    private static HashMap<String, Customer> accounts;
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        
        accounts = new HashMap<>();
        

        System.out.println("Enter Account Number: ");
        String account_number =    in.nextLine();

        if(accounts.containsKey(account_number)){
            options(account_number);
        }
        else{ //If no then ask customer to open an account
            System.out.println("You are a new customer do you want to open account (y/n): ");
            char opt = in.next().charAt(0);
            switch(opt){
                case 'y':
                    account_number = openAccount();
                    options(account_number);
                case 'n':
                    System.exit(0);
            }
        }
        in.close();
        System.exit(0);
    }
    //Method for opening account
    public static String openAccount(){

        System.out.print("Enter Your name: ");
        String name = in.next();
        System.out.print("Enter Your cnic: ");
        String cnic = in.next();

        if(cnic.length() < 13 || cnic.length() > 13)
            System.out.println("Invalid Cnic");
        else{
            Customer customer = new Customer(name);
            accounts.put(cnic, customer);
        }

        return cnic;
    }

    public static boolean depositFunds(Customer customer){
        System.out.println("Enter deposit Amount: ");
        int balance = in.nextInt();
        if(balance < 0){
            System.out.println("exiting because negative amount for deposit is entered");
            in.close();
            return false;
        }
        else{
            System.out.println("Current balance: " + customer.getBalance());
            balance += customer.getBalance();
            System.out.println("Balance after deposit: " + balance);
            customer.setBalance(balance);
        }
        System.out.println("Balance Deposited Successfully");
        return true;
    }

    public static boolean withdrawFunds(Customer customer){
        System.out.println("Enter withdraw Amount: ");
        if(customer.getBalance() <= 0){
            System.out.println("Cannot withdraw because bank balance is 0 or less than zero");
            return false;
        }
        else{
            int balance = in.nextInt();
            System.out.println("Current balance: " + customer.getBalance());
            balance = customer.getBalance() - balance;
            customer.setBalance(balance);
            System.out.println("Balance after withdraw: " + balance);
            System.out.println("balance withdrawn");
        }
        return true;
    }

    public static void closeAccount(){
        System.out.println("Enter Account Number: ");
        String account_number =    in.nextLine();
        if(accounts.containsKey(account_number)){
            options(account_number);
        }
        else{ //If no then ask customer to open an account
            System.out.println("You are a new customer do you want to open account (y/n): ");
            char opt = in.next().charAt(0);
            switch(opt){
                case 'y':
                    account_number = openAccount();
                    options(account_number);
                case 'n':
                    System.exit(0);
            }
        }   
    }

    public static void options(String account_number){
        //Check if customer already has account
        
        Customer customer = accounts.get(account_number);

        System.out.println("Enter 1 to deposit funds: ");
        System.out.println("Enter 2 to withdraw funds: ");
        System.out.println("Enter 3 to Close Account: ");
        System.out.print("Option: ");
        char choice = in.next().charAt(0);

        switch(choice){
            case '1':
                depositFunds(customer);
                options(account_number);
            case '2':
                withdrawFunds(customer);
                options(account_number);
            case '3':
                closeAccount();
                options(account_number);
        }
    }
}
