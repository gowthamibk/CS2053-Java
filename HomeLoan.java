package edu.bank;

public class HomeLoan implements Loan {
    private double rate;

    @Override
    public void getInterestRate(double rate) {
        this.rate = rate;
        System.out.println("Home Loan Interest Rate: " + this.rate + "%");
    }
}

