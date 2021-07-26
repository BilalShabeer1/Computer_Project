/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

public class Customer {
    private String name;
    private int balance;

    Customer(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public String getName(){
        return this.name;
    }

    public int getBalance(){
        return this.balance;
    }
}
